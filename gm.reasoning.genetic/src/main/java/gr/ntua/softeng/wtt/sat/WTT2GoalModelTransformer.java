package gr.ntua.softeng.wtt.sat;

import gr.ntua.softeng.gtsat.goalmodel.GoalModelAbstraction;
import gr.ntua.softeng.gtsat.goalmodel.TemporalGoalModelAbstraction;
import gr.ntua.softeng.wtt.CompositeNode;
import gr.ntua.softeng.wtt.Contribution;
import gr.ntua.softeng.wtt.DecompositionType;
import gr.ntua.softeng.wtt.Precedence;
import gr.ntua.softeng.wtt.Task;
import gr.ntua.softeng.wtt.TemplateLink;
import gr.ntua.softeng.wtt.WebTaskTemplate;
import gr.ntua.softeng.wtt.WttPackage;
import gr.ntua.softeng.wtt.ecore.EcoreModelLoaderImpl;

import java.util.HashSet;
import java.util.Set;

public class WTT2GoalModelTransformer extends EcoreModelLoaderImpl<WebTaskTemplate> {
	
	private TemporalGoalModelAbstraction goalModel = null;
	
	public WTT2GoalModelTransformer(String filename) {
		super(filename);
		// Create the corresponding goal model abstraction
		goalModel = this.extractGoalModel();
	}
	
	private TemporalGoalModelAbstraction extractGoalModel() {
		TemporalGoalModelAbstraction gm = new TemporalGoalModelAbstraction();
		WebTaskTemplate wtt = this.getLoadedModel();
		// Get root task
		Task rootTask = wtt.getRefersTo();
		gm.addGoal(rootTask.getName());
		this.processCompositeNode(gm, rootTask);
		// Process pre Links
		this.processLinks(gm, wtt);
		return gm;		
	}
	
	private void processLinks(TemporalGoalModelAbstraction gm, WebTaskTemplate wtt) {
		for (TemplateLink link : wtt.getContains()) {
			if (link instanceof Precedence) {
				this.processPrecedenceLink(gm, (Precedence)link);
			} else if (link instanceof Contribution) {
				this.processContributionLink(gm, (Contribution)link);
			}
		}
	}
	
	private void processPrecedenceLink(TemporalGoalModelAbstraction gm, Precedence preLink) {
		String sourceNode = preLink.getFrom().getName();
		String targetNode = preLink.getTo().getName();
		gm.addPreLink(sourceNode, targetNode);
	}
	
	private void processContributionLink(GoalModelAbstraction gm, Contribution contr) {
		String sourceNode = contr.getFrom().getName();
		String targetNode = contr.getTo().getName();
		switch(contr.getType()) {
		case PPS: 
			gm.addPPSContribution(sourceNode, targetNode);
			break;
		case MMS:
			gm.addMMSContribution(sourceNode, targetNode);
			break;
		case PPD:
			gm.addPPDContribution(sourceNode, targetNode);
			break;
		case MMD :
			gm.addMMDContribution(sourceNode, targetNode);
			break;
		}
	}
	
	private void processCompositeNode(GoalModelAbstraction gm, CompositeNode node) {
		String nodeKey = node.getName();
		// Check if the node is a weighted one
		if (node.getCost() != null ) {
			gm.addWeightedNode(nodeKey, node.getCost());
		}
		if (node.getHasDecomposition() != null) {
			DecompositionType type = node.getHasDecomposition().getType();
			Set<String> childNodeKeys = new HashSet<String>();
			for (CompositeNode childNode : node.getHasDecomposition().getDecomposedTo()) {
				this.processCompositeNode(gm, childNode);
				childNodeKeys.add(childNode.getName());
			}
			// Add decomposition rule
			if (type.equals(DecompositionType.AND)) {
				gm.addANDDecomposition(nodeKey, childNodeKeys);
			} else {
				gm.addORDecomposition(nodeKey, childNodeKeys);
			}
		}
	}
	
	protected void initializeModel() {
		WttPackage.eINSTANCE.eClass();
	}
	
	protected String getExtension() {
		return "wtt";
	}
	
	public GoalModelAbstraction getGoalModelAbstraction() {
		return this.goalModel;
	}
}
