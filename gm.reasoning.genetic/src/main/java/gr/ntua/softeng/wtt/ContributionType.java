/**
 */
package gr.ntua.softeng.wtt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Contribution Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see gr.ntua.softeng.wtt.WttPackage#getContributionType()
 * @model
 * @generated
 */
public enum ContributionType implements Enumerator {
	/**
	 * The '<em><b>PPS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PPS_VALUE
	 * @generated
	 * @ordered
	 */
	PPS(0, "PPS", "PPS"),

	/**
	 * The '<em><b>MMS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MMS_VALUE
	 * @generated
	 * @ordered
	 */
	MMS(1, "MMS", "MMS"),

	/**
	 * The '<em><b>PPD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PPD_VALUE
	 * @generated
	 * @ordered
	 */
	PPD(2, "PPD", "PPD"),

	/**
	 * The '<em><b>MMD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MMD_VALUE
	 * @generated
	 * @ordered
	 */
	MMD(3, "MMD", "MMD");

	/**
	 * The '<em><b>PPS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PPS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PPS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PPS_VALUE = 0;

	/**
	 * The '<em><b>MMS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MMS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MMS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MMS_VALUE = 1;

	/**
	 * The '<em><b>PPD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PPD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PPD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PPD_VALUE = 2;

	/**
	 * The '<em><b>MMD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MMD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MMD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MMD_VALUE = 3;

	/**
	 * An array of all the '<em><b>Contribution Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ContributionType[] VALUES_ARRAY =
		new ContributionType[] {
			PPS,
			MMS,
			PPD,
			MMD,
		};

	/**
	 * A public read-only list of all the '<em><b>Contribution Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ContributionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Contribution Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContributionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ContributionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Contribution Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContributionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ContributionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Contribution Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContributionType get(int value) {
		switch (value) {
			case PPS_VALUE: return PPS;
			case MMS_VALUE: return MMS;
			case PPD_VALUE: return PPD;
			case MMD_VALUE: return MMD;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ContributionType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ContributionType
