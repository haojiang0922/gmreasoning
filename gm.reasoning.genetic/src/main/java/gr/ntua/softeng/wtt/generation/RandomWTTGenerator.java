package gr.ntua.softeng.wtt.generation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import gr.ntua.softeng.wtt.*;

public class RandomWTTGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		RandomWTTGenerator r = new RandomWTTGenerator();
		WebTaskTemplate wtt = r.generate(500, 1500, null, new Integer(1000), -1);
		printWTT(wtt);
		storeWebTaskTemplate("models/random/"+wtt.getName()+".wtt",wtt);		
	}
	
	public WebTaskTemplate generate(int tasksNumber, int actionsNumber, Integer costMin, Integer costMax, int factor) {
		
		WttFactory factory = WttFactory.eINSTANCE;
		WebTaskTemplate wtt = factory.createWebTaskTemplate();
		wtt.setName("WTT_" + System.currentTimeMillis());
		
		Task rootTask = factory.createTask();
		rootTask.setName("root");
		rootTask.setCost(calcRandomCost(costMin,costMax,factor));
		wtt.setRefersTo(rootTask);
		
		ArrayList<Task> tasks = new ArrayList<Task>(); 
		tasks.add(rootTask);
		for (int i = 0; i < tasksNumber - 1; i++) {
			Task t = factory.createTask();
			t.setCost(calcRandomCost(costMin,costMax,factor));
			t.setName("task_"+(i+1));
			tasks.add(t);
		}
		
		ArrayList<Action> actions = new ArrayList<Action>();
		for (int i = 0; i < actionsNumber; i++) {
			Action a = factory.createAction();
			a.setCost(calcRandomCost(costMin,costMax,factor));
			a.setName("action_"+(i+1));
			actions.add(a);
		}
		
		ArrayList<Resource> resources = new ArrayList<Resource>();
		
		int maxTasksDepth = (int) (Math.log(tasks.size()) / Math.log(2));
		int index = 1;
		int pIndex = 0;
		for (int i = 0; i < maxTasksDepth+1 && index < tasks.size(); i++) {
			for (int j = 0; j < Math.pow(2, i) && index < tasks.size(); j++) {
				Task parent = tasks.get(j+pIndex);
				Decomposition dec = calcRandomDecomposition();
				parent.setHasDecomposition(dec);
				for (int k = 0; k < 2 && index < tasks.size(); k++) {
					Task child = tasks.get(index);
					dec.getDecomposedTo().add(child);
					index++;
				}
			}
			pIndex += (int)Math.pow(2, i);
		}

		for (int i = 0; i < 2 && actions.size() > 0; i++) { 
			for (Task t : tasks) {
				if (t.getHasDecomposition() == null) {
					Decomposition dec = calcRandomDecomposition();
					t.setHasDecomposition(dec);
					Action a = calcRandomAction(actions);
					addRandomResourcesToAction(a,resources);
					dec.getDecomposedTo().add(a);
					actions.remove(a);
				}
				else if (t.getHasDecomposition().getDecomposedTo().size() == 1 && actions.size() > 0) {
					Decomposition dec = t.getHasDecomposition();
					Action a = calcRandomAction(actions);
					addRandomResourcesToAction(a,resources);
					dec.getDecomposedTo().add(a);
					actions.remove(a);
				}
			}
		}
		
		while (actions.size() > 0) {
			Random rand = new Random();
			int task = rand.nextInt(tasks.size());
			Task t = tasks.get(task);
			Decomposition dec = t.getHasDecomposition();
			Action a = calcRandomAction(actions);
			addRandomResourcesToAction(a,resources);
			dec.getDecomposedTo().add(a);
			actions.remove(a);
		}
		
		return wtt;
	}

	private void addRandomResourcesToAction(Action a,
			ArrayList<Resource> resources) {
		Random rand = new Random();
		int resourcesNumber = rand.nextInt(4) + 2;
		for (int i = 0; i < resourcesNumber; i++) {
				Resource r = WttFactory.eINSTANCE.createResource();
				r.setName("resource_"+(resources.size()+1));
				resources.add(r);
				a.getRequires().add(r);
		}
	}

	private Action calcRandomAction(ArrayList<Action> actions) {
		Random rand = new Random();
		return actions.get(rand.nextInt(actions.size()));
	}

	public static void printWTT(WebTaskTemplate wtt) {
		Task root = wtt.getRefersTo();
		Decomposition dec = root.getHasDecomposition();
		System.out.println("Root: " + root.getName() + ", cost: " + root.getCost() + (dec != null ? " ["+dec.getType()+"]" : ""));	
		for (CompositeNode c : dec.getDecomposedTo()) {
			printWTTNodeAndSubNodes(c,"\t");
		}
	}

	private static void printWTTNodeAndSubNodes(CompositeNode c, String offset) {
		Decomposition dec = c.getHasDecomposition();
		System.out.println(offset+ "Node: " + c.getName() + ", cost: " + c.getCost() + (dec != null ? " ["+dec.getType()+"]" : ""));
		if (dec != null) {
			for (CompositeNode child : dec.getDecomposedTo()) {
				printWTTNodeAndSubNodes(child,offset+"\t");
			}
		}
		if (c instanceof Action) {
			Action a = (Action)c;
			for (Resource r : a.getRequires()) {
				System.out.println(offset+"\t"+"Resource: " + r.getName());
			}
		}
	}

	private Decomposition calcRandomDecomposition() {
		Decomposition dec = WttFactory.eINSTANCE.createDecomposition();
		
		Random rand = new Random();
		if (rand.nextBoolean())
			dec.setType(DecompositionType.AND);
		else
			dec.setType(DecompositionType.OR);
		
		return dec;
	}

	private Integer calcRandomCost(Integer costMin, Integer costMax, int factor) {
		Random rand = new Random();
		if (costMin == null && costMax == null)
			return new Integer(rand.nextInt() * factor);
		
		if (costMin == null && costMax != null) 
			return new Integer(rand.nextInt(costMax.intValue())* factor);
		
		if (costMin != null && costMax == null) {
			return new Integer((rand.nextInt()) + costMin.intValue()* factor);
		}
		
		if (costMin != null && costMax != null) {
			return new Integer(costMin.intValue() + (rand.nextInt(costMax.intValue() - costMin.intValue()))* factor);
		}
		
		return null;
	}

	public static void storeWebTaskTemplate(String filename, WebTaskTemplate wtt) {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry reg =org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("wtt", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		org.eclipse.emf.ecore.resource.Resource resource = resSet.createResource(URI.createURI(filename));
		resource.getContents().add(wtt);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int allTasks = 0;
	private static int allActions = 0;
	private static int allResources = 0;
	public static void printStatsForWTT(WebTaskTemplate wtt) {
		allTasks = 1;
		allActions = 0;
		allResources = 0;
		for (CompositeNode c : wtt.getRefersTo().getHasDecomposition().getDecomposedTo()) {
			countNode(c);
		}
		System.out.println("Tasks: " + "\t" + allTasks + "\tActions: " + "\t" + allActions + "\tResources: " + "\t" + allResources);
	}

	private static void countNode(CompositeNode c) {
		if (c instanceof Task) {
			allTasks++;
		}
		if (c instanceof Action) {
			allActions++;
			allResources += ((Action)c).getRequires().size();
		}
		if ( c.getHasDecomposition() != null )
			for (CompositeNode cc : c.getHasDecomposition().getDecomposedTo()) {
				countNode(cc);
			}
	}
}
