/**
 */
package gr.ntua.softeng.wtt.impl;

import gr.ntua.softeng.wtt.Task;
import gr.ntua.softeng.wtt.TemplateLink;
import gr.ntua.softeng.wtt.WebTaskTemplate;
import gr.ntua.softeng.wtt.WttPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Task Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gr.ntua.softeng.wtt.impl.WebTaskTemplateImpl#getName <em>Name</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.impl.WebTaskTemplateImpl#getDescr <em>Descr</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.impl.WebTaskTemplateImpl#getRefersTo <em>Refers To</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.impl.WebTaskTemplateImpl#getContains <em>Contains</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WebTaskTemplateImpl extends EObjectImpl implements WebTaskTemplate {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescr() <em>Descr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescr()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescr() <em>Descr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescr()
	 * @generated
	 * @ordered
	 */
	protected String descr = DESCR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefersTo() <em>Refers To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefersTo()
	 * @generated
	 * @ordered
	 */
	protected Task refersTo;

	/**
	 * The cached value of the '{@link #getContains() <em>Contains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContains()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateLink> contains;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WebTaskTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WttPackage.Literals.WEB_TASK_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WttPackage.WEB_TASK_TEMPLATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescr(String newDescr) {
		String oldDescr = descr;
		descr = newDescr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WttPackage.WEB_TASK_TEMPLATE__DESCR, oldDescr, descr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task getRefersTo() {
		return refersTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefersTo(Task newRefersTo, NotificationChain msgs) {
		Task oldRefersTo = refersTo;
		refersTo = newRefersTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WttPackage.WEB_TASK_TEMPLATE__REFERS_TO, oldRefersTo, newRefersTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefersTo(Task newRefersTo) {
		if (newRefersTo != refersTo) {
			NotificationChain msgs = null;
			if (refersTo != null)
				msgs = ((InternalEObject)refersTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WttPackage.WEB_TASK_TEMPLATE__REFERS_TO, null, msgs);
			if (newRefersTo != null)
				msgs = ((InternalEObject)newRefersTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WttPackage.WEB_TASK_TEMPLATE__REFERS_TO, null, msgs);
			msgs = basicSetRefersTo(newRefersTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WttPackage.WEB_TASK_TEMPLATE__REFERS_TO, newRefersTo, newRefersTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateLink> getContains() {
		if (contains == null) {
			contains = new EObjectContainmentEList<TemplateLink>(TemplateLink.class, this, WttPackage.WEB_TASK_TEMPLATE__CONTAINS);
		}
		return contains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WttPackage.WEB_TASK_TEMPLATE__REFERS_TO:
				return basicSetRefersTo(null, msgs);
			case WttPackage.WEB_TASK_TEMPLATE__CONTAINS:
				return ((InternalEList<?>)getContains()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WttPackage.WEB_TASK_TEMPLATE__NAME:
				return getName();
			case WttPackage.WEB_TASK_TEMPLATE__DESCR:
				return getDescr();
			case WttPackage.WEB_TASK_TEMPLATE__REFERS_TO:
				return getRefersTo();
			case WttPackage.WEB_TASK_TEMPLATE__CONTAINS:
				return getContains();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WttPackage.WEB_TASK_TEMPLATE__NAME:
				setName((String)newValue);
				return;
			case WttPackage.WEB_TASK_TEMPLATE__DESCR:
				setDescr((String)newValue);
				return;
			case WttPackage.WEB_TASK_TEMPLATE__REFERS_TO:
				setRefersTo((Task)newValue);
				return;
			case WttPackage.WEB_TASK_TEMPLATE__CONTAINS:
				getContains().clear();
				getContains().addAll((Collection<? extends TemplateLink>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WttPackage.WEB_TASK_TEMPLATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WttPackage.WEB_TASK_TEMPLATE__DESCR:
				setDescr(DESCR_EDEFAULT);
				return;
			case WttPackage.WEB_TASK_TEMPLATE__REFERS_TO:
				setRefersTo((Task)null);
				return;
			case WttPackage.WEB_TASK_TEMPLATE__CONTAINS:
				getContains().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WttPackage.WEB_TASK_TEMPLATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WttPackage.WEB_TASK_TEMPLATE__DESCR:
				return DESCR_EDEFAULT == null ? descr != null : !DESCR_EDEFAULT.equals(descr);
			case WttPackage.WEB_TASK_TEMPLATE__REFERS_TO:
				return refersTo != null;
			case WttPackage.WEB_TASK_TEMPLATE__CONTAINS:
				return contains != null && !contains.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", descr: ");
		result.append(descr);
		result.append(')');
		return result.toString();
	}

} //WebTaskTemplateImpl
