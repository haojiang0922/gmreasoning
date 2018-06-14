/**
 */
package gr.ntua.softeng.wtt.impl;

import gr.ntua.softeng.wtt.Action;
import gr.ntua.softeng.wtt.CompositeNode;
import gr.ntua.softeng.wtt.Contribution;
import gr.ntua.softeng.wtt.ContributionType;
import gr.ntua.softeng.wtt.Decomposition;
import gr.ntua.softeng.wtt.DecompositionType;
import gr.ntua.softeng.wtt.Precedence;
import gr.ntua.softeng.wtt.Resource;
import gr.ntua.softeng.wtt.ResourceDependency;
import gr.ntua.softeng.wtt.Task;
import gr.ntua.softeng.wtt.TemplateLink;
import gr.ntua.softeng.wtt.TemplateNode;
import gr.ntua.softeng.wtt.WebTaskTemplate;
import gr.ntua.softeng.wtt.WttFactory;
import gr.ntua.softeng.wtt.WttPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WttPackageImpl extends EPackageImpl implements WttPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decompositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass precedenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webTaskTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum decompositionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum contributionTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see gr.ntua.softeng.wtt.WttPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WttPackageImpl() {
		super(eNS_URI, WttFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link WttPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WttPackage init() {
		if (isInited) return (WttPackage)EPackage.Registry.INSTANCE.getEPackage(WttPackage.eNS_URI);

		// Obtain or create and register package
		WttPackageImpl theWttPackage = (WttPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WttPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WttPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theWttPackage.createPackageContents();

		// Initialize created meta-data
		theWttPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWttPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WttPackage.eNS_URI, theWttPackage);
		return theWttPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateLink() {
		return templateLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateNode() {
		return templateNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateNode_Cost() {
		return (EAttribute)templateNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateNode_Name() {
		return (EAttribute)templateNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeNode() {
		return compositeNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeNode_HasDecomposition() {
		return (EReference)compositeNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTask() {
		return taskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Requires() {
		return (EReference)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceDependency() {
		return resourceDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDependency_From() {
		return (EReference)resourceDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDependency_To() {
		return (EReference)resourceDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecomposition() {
		return decompositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecomposition_DecomposedTo() {
		return (EReference)decompositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecomposition_Type() {
		return (EAttribute)decompositionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrecedence() {
		return precedenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrecedence_From() {
		return (EReference)precedenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrecedence_To() {
		return (EReference)precedenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContribution() {
		return contributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContribution_Type() {
		return (EAttribute)contributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContribution_From() {
		return (EReference)contributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContribution_To() {
		return (EReference)contributionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebTaskTemplate() {
		return webTaskTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebTaskTemplate_Name() {
		return (EAttribute)webTaskTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebTaskTemplate_Descr() {
		return (EAttribute)webTaskTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWebTaskTemplate_RefersTo() {
		return (EReference)webTaskTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWebTaskTemplate_Contains() {
		return (EReference)webTaskTemplateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDecompositionType() {
		return decompositionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getContributionType() {
		return contributionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WttFactory getWttFactory() {
		return (WttFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		templateLinkEClass = createEClass(TEMPLATE_LINK);

		templateNodeEClass = createEClass(TEMPLATE_NODE);
		createEAttribute(templateNodeEClass, TEMPLATE_NODE__COST);
		createEAttribute(templateNodeEClass, TEMPLATE_NODE__NAME);

		compositeNodeEClass = createEClass(COMPOSITE_NODE);
		createEReference(compositeNodeEClass, COMPOSITE_NODE__HAS_DECOMPOSITION);

		taskEClass = createEClass(TASK);

		actionEClass = createEClass(ACTION);
		createEReference(actionEClass, ACTION__REQUIRES);

		resourceEClass = createEClass(RESOURCE);

		resourceDependencyEClass = createEClass(RESOURCE_DEPENDENCY);
		createEReference(resourceDependencyEClass, RESOURCE_DEPENDENCY__FROM);
		createEReference(resourceDependencyEClass, RESOURCE_DEPENDENCY__TO);

		decompositionEClass = createEClass(DECOMPOSITION);
		createEReference(decompositionEClass, DECOMPOSITION__DECOMPOSED_TO);
		createEAttribute(decompositionEClass, DECOMPOSITION__TYPE);

		precedenceEClass = createEClass(PRECEDENCE);
		createEReference(precedenceEClass, PRECEDENCE__FROM);
		createEReference(precedenceEClass, PRECEDENCE__TO);

		contributionEClass = createEClass(CONTRIBUTION);
		createEAttribute(contributionEClass, CONTRIBUTION__TYPE);
		createEReference(contributionEClass, CONTRIBUTION__FROM);
		createEReference(contributionEClass, CONTRIBUTION__TO);

		webTaskTemplateEClass = createEClass(WEB_TASK_TEMPLATE);
		createEAttribute(webTaskTemplateEClass, WEB_TASK_TEMPLATE__NAME);
		createEAttribute(webTaskTemplateEClass, WEB_TASK_TEMPLATE__DESCR);
		createEReference(webTaskTemplateEClass, WEB_TASK_TEMPLATE__REFERS_TO);
		createEReference(webTaskTemplateEClass, WEB_TASK_TEMPLATE__CONTAINS);

		// Create enums
		decompositionTypeEEnum = createEEnum(DECOMPOSITION_TYPE);
		contributionTypeEEnum = createEEnum(CONTRIBUTION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		compositeNodeEClass.getESuperTypes().add(this.getTemplateNode());
		taskEClass.getESuperTypes().add(this.getCompositeNode());
		actionEClass.getESuperTypes().add(this.getCompositeNode());
		resourceEClass.getESuperTypes().add(this.getTemplateNode());
		resourceDependencyEClass.getESuperTypes().add(this.getTemplateLink());
		precedenceEClass.getESuperTypes().add(this.getTemplateLink());
		contributionEClass.getESuperTypes().add(this.getTemplateLink());

		// Initialize classes and features; add operations and parameters
		initEClass(templateLinkEClass, TemplateLink.class, "TemplateLink", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(templateNodeEClass, TemplateNode.class, "TemplateNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemplateNode_Cost(), ecorePackage.getEIntegerObject(), "cost", null, 0, 1, TemplateNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplateNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, TemplateNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeNodeEClass, CompositeNode.class, "CompositeNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeNode_HasDecomposition(), this.getDecomposition(), null, "hasDecomposition", null, 1, 1, CompositeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAction_Requires(), this.getResource(), null, "requires", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceDependencyEClass, ResourceDependency.class, "ResourceDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceDependency_From(), this.getAction(), null, "from", null, 1, 1, ResourceDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDependency_To(), this.getResource(), null, "to", null, 1, 1, ResourceDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decompositionEClass, Decomposition.class, "Decomposition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDecomposition_DecomposedTo(), this.getCompositeNode(), null, "decomposedTo", null, 1, -1, Decomposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDecomposition_Type(), this.getDecompositionType(), "type", null, 1, 1, Decomposition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(precedenceEClass, Precedence.class, "Precedence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrecedence_From(), this.getCompositeNode(), null, "from", null, 1, 1, Precedence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrecedence_To(), this.getCompositeNode(), null, "to", null, 1, 1, Precedence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contributionEClass, Contribution.class, "Contribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContribution_Type(), this.getContributionType(), "type", null, 1, 1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_From(), this.getCompositeNode(), null, "from", null, 1, 1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_To(), this.getCompositeNode(), null, "to", null, 1, 1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(webTaskTemplateEClass, WebTaskTemplate.class, "WebTaskTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWebTaskTemplate_Name(), ecorePackage.getEString(), "name", null, 1, 1, WebTaskTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebTaskTemplate_Descr(), ecorePackage.getEString(), "descr", null, 0, 1, WebTaskTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWebTaskTemplate_RefersTo(), this.getTask(), null, "refersTo", null, 1, 1, WebTaskTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWebTaskTemplate_Contains(), this.getTemplateLink(), null, "contains", null, 0, -1, WebTaskTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(decompositionTypeEEnum, DecompositionType.class, "DecompositionType");
		addEEnumLiteral(decompositionTypeEEnum, DecompositionType.AND);
		addEEnumLiteral(decompositionTypeEEnum, DecompositionType.OR);

		initEEnum(contributionTypeEEnum, ContributionType.class, "ContributionType");
		addEEnumLiteral(contributionTypeEEnum, ContributionType.PPS);
		addEEnumLiteral(contributionTypeEEnum, ContributionType.MMS);
		addEEnumLiteral(contributionTypeEEnum, ContributionType.PPD);
		addEEnumLiteral(contributionTypeEEnum, ContributionType.MMD);

		// Create resource
		createResource(eNS_URI);
	}

} //WttPackageImpl
