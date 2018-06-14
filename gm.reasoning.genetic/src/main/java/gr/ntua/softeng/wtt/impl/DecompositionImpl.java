/**
 */
package gr.ntua.softeng.wtt.impl;

import gr.ntua.softeng.wtt.CompositeNode;
import gr.ntua.softeng.wtt.Decomposition;
import gr.ntua.softeng.wtt.DecompositionType;
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
 * An implementation of the model object '<em><b>Decomposition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gr.ntua.softeng.wtt.impl.DecompositionImpl#getDecomposedTo <em>Decomposed To</em>}</li>
 *   <li>{@link gr.ntua.softeng.wtt.impl.DecompositionImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DecompositionImpl extends EObjectImpl implements Decomposition {
	/**
	 * The cached value of the '{@link #getDecomposedTo() <em>Decomposed To</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecomposedTo()
	 * @generated
	 * @ordered
	 */
	protected EList<CompositeNode> decomposedTo;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final DecompositionType TYPE_EDEFAULT = DecompositionType.AND;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DecompositionType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecompositionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WttPackage.Literals.DECOMPOSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompositeNode> getDecomposedTo() {
		if (decomposedTo == null) {
			decomposedTo = new EObjectContainmentEList<CompositeNode>(CompositeNode.class, this, WttPackage.DECOMPOSITION__DECOMPOSED_TO);
		}
		return decomposedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecompositionType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DecompositionType newType) {
		DecompositionType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WttPackage.DECOMPOSITION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WttPackage.DECOMPOSITION__DECOMPOSED_TO:
				return ((InternalEList<?>)getDecomposedTo()).basicRemove(otherEnd, msgs);
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
			case WttPackage.DECOMPOSITION__DECOMPOSED_TO:
				return getDecomposedTo();
			case WttPackage.DECOMPOSITION__TYPE:
				return getType();
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
			case WttPackage.DECOMPOSITION__DECOMPOSED_TO:
				getDecomposedTo().clear();
				getDecomposedTo().addAll((Collection<? extends CompositeNode>)newValue);
				return;
			case WttPackage.DECOMPOSITION__TYPE:
				setType((DecompositionType)newValue);
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
			case WttPackage.DECOMPOSITION__DECOMPOSED_TO:
				getDecomposedTo().clear();
				return;
			case WttPackage.DECOMPOSITION__TYPE:
				setType(TYPE_EDEFAULT);
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
			case WttPackage.DECOMPOSITION__DECOMPOSED_TO:
				return decomposedTo != null && !decomposedTo.isEmpty();
			case WttPackage.DECOMPOSITION__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //DecompositionImpl
