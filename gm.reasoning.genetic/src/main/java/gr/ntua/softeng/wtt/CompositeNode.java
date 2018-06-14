/**
 */
package gr.ntua.softeng.wtt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gr.ntua.softeng.wtt.CompositeNode#getHasDecomposition <em>Has Decomposition</em>}</li>
 * </ul>
 * </p>
 *
 * @see gr.ntua.softeng.wtt.WttPackage#getCompositeNode()
 * @model abstract="true"
 * @generated
 */
public interface CompositeNode extends TemplateNode {
	/**
	 * Returns the value of the '<em><b>Has Decomposition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Decomposition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Decomposition</em>' containment reference.
	 * @see #setHasDecomposition(Decomposition)
	 * @see gr.ntua.softeng.wtt.WttPackage#getCompositeNode_HasDecomposition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Decomposition getHasDecomposition();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.CompositeNode#getHasDecomposition <em>Has Decomposition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Decomposition</em>' containment reference.
	 * @see #getHasDecomposition()
	 * @generated
	 */
	void setHasDecomposition(Decomposition value);

} // CompositeNode
