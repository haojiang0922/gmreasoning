/**
 */
package gr.ntua.softeng.wtt.util;

import gr.ntua.softeng.wtt.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see gr.ntua.softeng.wtt.WttPackage
 * @generated
 */
public class WttAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WttPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WttAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WttPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WttSwitch<Adapter> modelSwitch =
		new WttSwitch<Adapter>() {
			@Override
			public Adapter caseTemplateLink(TemplateLink object) {
				return createTemplateLinkAdapter();
			}
			@Override
			public Adapter caseTemplateNode(TemplateNode object) {
				return createTemplateNodeAdapter();
			}
			@Override
			public Adapter caseCompositeNode(CompositeNode object) {
				return createCompositeNodeAdapter();
			}
			@Override
			public Adapter caseTask(Task object) {
				return createTaskAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseResourceDependency(ResourceDependency object) {
				return createResourceDependencyAdapter();
			}
			@Override
			public Adapter caseDecomposition(Decomposition object) {
				return createDecompositionAdapter();
			}
			@Override
			public Adapter casePrecedence(Precedence object) {
				return createPrecedenceAdapter();
			}
			@Override
			public Adapter caseContribution(Contribution object) {
				return createContributionAdapter();
			}
			@Override
			public Adapter caseWebTaskTemplate(WebTaskTemplate object) {
				return createWebTaskTemplateAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.TemplateLink <em>Template Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.TemplateLink
	 * @generated
	 */
	public Adapter createTemplateLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.TemplateNode <em>Template Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.TemplateNode
	 * @generated
	 */
	public Adapter createTemplateNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.CompositeNode <em>Composite Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.CompositeNode
	 * @generated
	 */
	public Adapter createCompositeNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.Task
	 * @generated
	 */
	public Adapter createTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.ResourceDependency <em>Resource Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.ResourceDependency
	 * @generated
	 */
	public Adapter createResourceDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.Decomposition <em>Decomposition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.Decomposition
	 * @generated
	 */
	public Adapter createDecompositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.Precedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.Precedence
	 * @generated
	 */
	public Adapter createPrecedenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.Contribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.Contribution
	 * @generated
	 */
	public Adapter createContributionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gr.ntua.softeng.wtt.WebTaskTemplate <em>Web Task Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gr.ntua.softeng.wtt.WebTaskTemplate
	 * @generated
	 */
	public Adapter createWebTaskTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //WttAdapterFactory
