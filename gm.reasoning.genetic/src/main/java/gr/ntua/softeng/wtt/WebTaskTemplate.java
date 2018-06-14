/**
 */
package gr.ntua.softeng.wtt;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Web Task Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gr.ntua.softeng.wtt.WebTaskTemplate#getName <em>Name</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.WebTaskTemplate#getDescr <em>Descr</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.WebTaskTemplate#getRefersTo <em>Refers To</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.WebTaskTemplate#getContains <em>Contains</em>}</li>
 * </ul>
 * </p>
 *
 * @see gr.ntua.softeng.wtt.WttPackage#getWebTaskTemplate()
 * @model
 * @generated
 */
public interface WebTaskTemplate extends EObject {
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
	 * @see gr.ntua.softeng.wtt.WttPackage#getWebTaskTemplate_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.WebTaskTemplate#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Descr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descr</em>' attribute.
	 * @see #setDescr(String)
	 * @see gr.ntua.softeng.wtt.WttPackage#getWebTaskTemplate_Descr()
	 * @model
	 * @generated
	 */
	String getDescr();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.WebTaskTemplate#getDescr <em>Descr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descr</em>' attribute.
	 * @see #getDescr()
	 * @generated
	 */
	void setDescr(String value);

	/**
	 * Returns the value of the '<em><b>Refers To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refers To</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refers To</em>' containment reference.
	 * @see #setRefersTo(Task)
	 * @see gr.ntua.softeng.wtt.WttPackage#getWebTaskTemplate_RefersTo()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Task getRefersTo();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.WebTaskTemplate#getRefersTo <em>Refers To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refers To</em>' containment reference.
	 * @see #getRefersTo()
	 * @generated
	 */
	void setRefersTo(Task value);

	/**
	 * Returns the value of the '<em><b>Contains</b></em>' containment reference list.
	 * The list contents are of type {@link gr.ntua.softeng.wtt.TemplateLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains</em>' containment reference list.
	 * @see gr.ntua.softeng.wtt.WttPackage#getWebTaskTemplate_Contains()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemplateLink> getContains();

} // WebTaskTemplate
