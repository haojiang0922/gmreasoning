/**
 */
package gr.ntua.softeng.wtt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gr.ntua.softeng.wtt.Contribution#getType <em>Type</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.Contribution#getFrom <em>From</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.Contribution#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see gr.ntua.softeng.wtt.WttPackage#getContribution()
 * @model
 * @generated
 */
public interface Contribution extends TemplateLink {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link gr.ntua.softeng.wtt.ContributionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see gr.ntua.softeng.wtt.ContributionType
	 * @see #setType(ContributionType)
	 * @see gr.ntua.softeng.wtt.WttPackage#getContribution_Type()
	 * @model required="true"
	 * @generated
	 */
	ContributionType getType();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.Contribution#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see gr.ntua.softeng.wtt.ContributionType
	 * @see #getType()
	 * @generated
	 */
	void setType(ContributionType value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(CompositeNode)
	 * @see gr.ntua.softeng.wtt.WttPackage#getContribution_From()
	 * @model required="true"
	 * @generated
	 */
	CompositeNode getFrom();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.Contribution#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(CompositeNode value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(CompositeNode)
	 * @see gr.ntua.softeng.wtt.WttPackage#getContribution_To()
	 * @model required="true"
	 * @generated
	 */
	CompositeNode getTo();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.Contribution#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(CompositeNode value);

} // Contribution
