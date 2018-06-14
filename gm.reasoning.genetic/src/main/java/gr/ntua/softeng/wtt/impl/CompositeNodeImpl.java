/**
 */
package gr.ntua.softeng.wtt.impl;

import gr.ntua.softeng.wtt.CompositeNode;
import gr.ntua.softeng.wtt.Decomposition;
import gr.ntua.softeng.wtt.WttPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gr.ntua.softeng.wtt.impl.CompositeNodeImpl#getHasDecomposition <em>Has Decomposition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompositeNodeImpl extends TemplateNodeImpl implements CompositeNode {
	/**
	 * The cached value of the '{@link #getHasDecomposition() <em>Has Decomposition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasDecomposition()
	 * @generated
	 * @ordered
	 */
	protected Decomposition hasDecomposition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WttPackage.Literals.COMPOSITE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decomposition getHasDecomposition() {
		return hasDecomposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHasDecomposition(Decomposition newHasDecomposition, NotificationChain msgs) {
		Decomposition oldHasDecomposition = hasDecomposition;
		hasDecomposition = newHasDecomposition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WttPackage.COMPOSITE_NODE__HAS_DECOMPOSITION, oldHasDecomposition, newHasDecomposition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasDecomposition(Decomposition newHasDecomposition) {
		if (newHasDecomposition != hasDecomposition) {
			NotificationChain msgs = null;
			if (hasDecomposition != null)
				msgs = ((InternalEObject)hasDecomposition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WttPackage.COMPOSITE_NODE__HAS_DECOMPOSITION, null, msgs);
			if (newHasDecomposition != null)
				msgs = ((InternalEObject)newHasDecomposition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WttPackage.COMPOSITE_NODE__HAS_DECOMPOSITION, null, msgs);
			msgs = basicSetHasDecomposition(newHasDecomposition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WttPackage.COMPOSITE_NODE__HAS_DECOMPOSITION, newHasDecomposition, newHasDecomposition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WttPackage.COMPOSITE_NODE__HAS_DECOMPOSITION:
				return basicSetHasDecomposition(null, msgs);
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
			case WttPackage.COMPOSITE_NODE__HAS_DECOMPOSITION:
				return getHasDecomposition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WttPackage.COMPOSITE_NODE__HAS_DECOMPOSITION:
				setHasDecomposition((Decomposition)newValue);
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
			case WttPackage.COMPOSITE_NODE__HAS_DECOMPOSITION:
				setHasDecomposition((Decomposition)null);
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
			case WttPackage.COMPOSITE_NODE__HAS_DECOMPOSITION:
				return hasDecomposition != null;
		}
		return super.eIsSet(featureID);
	}

} //CompositeNodeImpl
