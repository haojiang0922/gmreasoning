package gr.ntua.softeng.wtt.ecore;

import org.eclipse.emf.ecore.EObject;

public interface EcoreModelLoader<T extends EObject> {

	public T getLoadedModel();
}
