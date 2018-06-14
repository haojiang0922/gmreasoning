/**
 */
package gr.ntua.softeng.wtt.util;

import gr.ntua.softeng.wtt.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see gr.ntua.softeng.wtt.WttPackage
 * @generated
 */
public class WttSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WttPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WttSwitch() {
		if (modelPackage == null) {
			modelPackage = WttPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case WttPackage.TEMPLATE_LINK: {
				TemplateLink templateLink = (TemplateLink)theEObject;
				T result = caseTemplateLink(templateLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WttPackage.TEMPLATE_NODE: {
				TemplateNode templateNode = (TemplateNode)theEObject;
				T result = caseTemplateNode(templateNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WttPackage.COMPOSITE_NODE: {
				CompositeNode compositeNode = (CompositeNode)theEObject;
				T result = caseCompositeNode(compositeNode);
				if (result == null) result = caseTemplateNode(compositeNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WttPackage.TASK: {
				Task task = (Task)theEObject;
				T result = caseTask(task);
				if (result == null) result = caseCompositeNode(task);
				if (result == null) result = caseTemplateNode(task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WttPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseCompositeNode(action);
				if (result == null) result = caseTemplateNode(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WttPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseTemplateNode(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WttPackage.RESOURCE_DEPENDENCY: {
				ResourceDependency resourceDependency = (ResourceDependency)theEObject;
				T result = caseResourceDependency(resourceDependency);
				if (result == null) result = caseTemplateLink(resourceDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WttPackage.DECOMPOSITION: {
				Decomposition decomposition = (Decomposition)theEObject;
				T result = caseDecomposition(decomposition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WttPackage.PRECEDENCE: {
				Precedence precedence = (Precedence)theEObject;
				T result = casePrecedence(precedence);
				if (result == null) result = caseTemplateLink(precedence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WttPackage.CONTRIBUTION: {
				Contribution contribution = (Contribution)theEObject;
				T result = caseContribution(contribution);
				if (result == null) result = caseTemplateLink(contribution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WttPackage.WEB_TASK_TEMPLATE: {
				WebTaskTemplate webTaskTemplate = (WebTaskTemplate)theEObject;
				T result = caseWebTaskTemplate(webTaskTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateLink(TemplateLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateNode(TemplateNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeNode(CompositeNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTask(Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceDependency(ResourceDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decomposition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decomposition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecomposition(Decomposition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Precedence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Precedence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrecedence(Precedence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contribution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contribution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContribution(Contribution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Task Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Task Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWebTaskTemplate(WebTaskTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //WttSwitch
