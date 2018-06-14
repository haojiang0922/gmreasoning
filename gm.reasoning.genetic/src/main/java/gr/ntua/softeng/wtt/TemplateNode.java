/**
 */
package gr.ntua.softeng.wtt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gr.ntua.softeng.wtt.TemplateNode#getCost <em>Cost</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.TemplateNode#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see gr.ntua.softeng.wtt.WttPackage#getTemplateNode()
 * @model abstract="true"
 * @generated
 */
public interface TemplateNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cost</em>' attribute.
	 * @see #setCost(Integer)
	 * @see gr.ntua.softeng.wtt.WttPackage#getTemplateNode_Cost()
	 * @model
	 * @generated
	 */
	Integer getCost();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.TemplateNode#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost</em>' attribute.
	 * @see #getCost()
	 * @generated
	 */
	void setCost(Integer value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see gr.ntua.softeng.wtt.WttPackage#getTemplateNode_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.TemplateNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TemplateNode
