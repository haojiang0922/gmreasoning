/**
 */
package gr.ntua.softeng.wtt;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decomposition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gr.ntua.softeng.wtt.Decomposition#getDecomposedTo <em>Decomposed To</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.Decomposition#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see gr.ntua.softeng.wtt.WttPackage#getDecomposition()
 * @model
 * @generated
 */
public interface Decomposition extends EObject {
	/**
	 * Returns the value of the '<em><b>Decomposed To</b></em>' containment reference list.
	 * The list contents are of type {@link gr.ntua.softeng.wtt.CompositeNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decomposed To</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decomposed To</em>' containment reference list.
	 * @see gr.ntua.softeng.wtt.WttPackage#getDecomposition_DecomposedTo()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<CompositeNode> getDecomposedTo();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link gr.ntua.softeng.wtt.DecompositionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see gr.ntua.softeng.wtt.DecompositionType
	 * @see #setType(DecompositionType)
	 * @see gr.ntua.softeng.wtt.WttPackage#getDecomposition_Type()
	 * @model required="true"
	 * @generated
	 */
	DecompositionType getType();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.Decomposition#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see gr.ntua.softeng.wtt.DecompositionType
	 * @see #getType()
	 * @generated
	 */
	void setType(DecompositionType value);

} // Decomposition
