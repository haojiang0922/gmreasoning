package gr.ntua.softeng.wtt.ecore;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public abstract class EcoreModelLoaderImpl<T extends EObject> implements EcoreModelLoader<T> {

	protected T model;
	
	public EcoreModelLoaderImpl(String filename) {
		File f = new File(filename);
		String uri = f.toURI().toString();
		this.model = this.loadModel(uri);
	}
	
	/**
	 * ObjectivesPackage.eINSTANCE.eClass();
	 */
	abstract protected void initializeModel();
	
	protected String getExtension() {
		return "xmi";
	}
	
	private T loadModel(String uri) {
		// Initialize the model
		initializeModel();
		// Register the XMI resource factory 
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put(this.getExtension(), new XMIResourceFactoryImpl());
		//m.put("xmi", new XMIResourceFactoryImpl());
		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();
		// Get the resource
		Resource resource = resSet.getResource(URI.createURI(uri), true);
		// Get the first model element and cast it to the right type
		T config = (T) resource.getContents().get(0);
		return config;
	}
	
	public T getLoadedModel() {
		return this.model;
	}
}
