/**
 */
package gr.ntua.softeng.wtt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gr.ntua.softeng.wtt.ResourceDependency#getFrom <em>From</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.ResourceDependency#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see gr.ntua.softeng.wtt.WttPackage#getResourceDependency()
 * @model
 * @generated
 */
public interface ResourceDependency extends TemplateLink {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(Action)
	 * @see gr.ntua.softeng.wtt.WttPackage#getResourceDependency_From()
	 * @model required="true"
	 * @generated
	 */
	Action getFrom();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.ResourceDependency#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Action value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(Resource)
	 * @see gr.ntua.softeng.wtt.WttPackage#getResourceDependency_To()
	 * @model required="true"
	 * @generated
	 */
	Resource getTo();

	/**
	 * Sets the value of the '{@link gr.ntua.softeng.wtt.ResourceDependency#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Resource value);

} // ResourceDependency
