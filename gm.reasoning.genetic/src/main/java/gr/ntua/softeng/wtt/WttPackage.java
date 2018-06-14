/**
 */
package gr.ntua.softeng.wtt;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see gr.ntua.softeng.wtt.WttFactory
 * @model kind="package"
 * @generated
 */
public interface WttPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wtt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/webTaskTemplate/metamodel/wtt.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "wtt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WttPackage eINSTANCE = gr.ntua.softeng.wtt.impl.WttPackageImpl.init();

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.TemplateLinkImpl <em>Template Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.TemplateLinkImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getTemplateLink()
	 * @generated
	 */
	int TEMPLATE_LINK = 0;

	/**
	 * The number of structural features of the '<em>Template Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_LINK_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.TemplateNodeImpl <em>Template Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.TemplateNodeImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getTemplateNode()
	 * @generated
	 */
	int TEMPLATE_NODE = 1;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_NODE__COST = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_NODE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Template Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.CompositeNodeImpl <em>Composite Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.CompositeNodeImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getCompositeNode()
	 * @generated
	 */
	int COMPOSITE_NODE = 2;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__COST = TEMPLATE_NODE__COST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__NAME = TEMPLATE_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Has Decomposition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE__HAS_DECOMPOSITION = TEMPLATE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_NODE_FEATURE_COUNT = TEMPLATE_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.TaskImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 3;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__COST = COMPOSITE_NODE__COST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = COMPOSITE_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Has Decomposition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__HAS_DECOMPOSITION = COMPOSITE_NODE__HAS_DECOMPOSITION;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = COMPOSITE_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.ActionImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 4;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__COST = COMPOSITE_NODE__COST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = COMPOSITE_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Has Decomposition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__HAS_DECOMPOSITION = COMPOSITE_NODE__HAS_DECOMPOSITION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__REQUIRES = COMPOSITE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = COMPOSITE_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.ResourceImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__COST = TEMPLATE_NODE__COST;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = TEMPLATE_NODE__NAME;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = TEMPLATE_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.ResourceDependencyImpl <em>Resource Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.ResourceDependencyImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getResourceDependency()
	 * @generated
	 */
	int RESOURCE_DEPENDENCY = 6;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEPENDENCY__FROM = TEMPLATE_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEPENDENCY__TO = TEMPLATE_LINK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEPENDENCY_FEATURE_COUNT = TEMPLATE_LINK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.DecompositionImpl <em>Decomposition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.DecompositionImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getDecomposition()
	 * @generated
	 */
	int DECOMPOSITION = 7;

	/**
	 * The feature id for the '<em><b>Decomposed To</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__DECOMPOSED_TO = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Decomposition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.PrecedenceImpl <em>Precedence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.PrecedenceImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getPrecedence()
	 * @generated
	 */
	int PRECEDENCE = 8;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__FROM = TEMPLATE_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE__TO = TEMPLATE_LINK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Precedence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDENCE_FEATURE_COUNT = TEMPLATE_LINK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.ContributionImpl <em>Contribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.ContributionImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getContribution()
	 * @generated
	 */
	int CONTRIBUTION = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__TYPE = TEMPLATE_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__FROM = TEMPLATE_LINK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__TO = TEMPLATE_LINK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Contribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_FEATURE_COUNT = TEMPLATE_LINK_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.impl.WebTaskTemplateImpl <em>Web Task Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.impl.WebTaskTemplateImpl
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getWebTaskTemplate()
	 * @generated
	 */
	int WEB_TASK_TEMPLATE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_TASK_TEMPLATE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Descr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_TASK_TEMPLATE__DESCR = 1;

	/**
	 * The feature id for the '<em><b>Refers To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_TASK_TEMPLATE__REFERS_TO = 2;

	/**
	 * The feature id for the '<em><b>Contains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_TASK_TEMPLATE__CONTAINS = 3;

	/**
	 * The number of structural features of the '<em>Web Task Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_TASK_TEMPLATE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.DecompositionType <em>Decomposition Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.DecompositionType
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getDecompositionType()
	 * @generated
	 */
	int DECOMPOSITION_TYPE = 11;

	/**
	 * The meta object id for the '{@link gr.ntua.softeng.wtt.ContributionType <em>Contribution Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gr.ntua.softeng.wtt.ContributionType
	 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getContributionType()
	 * @generated
	 */
	int CONTRIBUTION_TYPE = 12;


	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.TemplateLink <em>Template Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Link</em>'.
	 * @see gr.ntua.softeng.wtt.TemplateLink
	 * @generated
	 */
	EClass getTemplateLink();

	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.TemplateNode <em>Template Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Node</em>'.
	 * @see gr.ntua.softeng.wtt.TemplateNode
	 * @generated
	 */
	EClass getTemplateNode();

	/**
	 * Returns the meta object for the attribute '{@link gr.ntua.softeng.wtt.TemplateNode#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cost</em>'.
	 * @see gr.ntua.softeng.wtt.TemplateNode#getCost()
	 * @see #getTemplateNode()
	 * @generated
	 */
	EAttribute getTemplateNode_Cost();

	/**
	 * Returns the meta object for the attribute '{@link gr.ntua.softeng.wtt.TemplateNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see gr.ntua.softeng.wtt.TemplateNode#getName()
	 * @see #getTemplateNode()
	 * @generated
	 */
	EAttribute getTemplateNode_Name();

	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.CompositeNode <em>Composite Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Node</em>'.
	 * @see gr.ntua.softeng.wtt.CompositeNode
	 * @generated
	 */
	EClass getCompositeNode();

	/**
	 * Returns the meta object for the containment reference '{@link gr.ntua.softeng.wtt.CompositeNode#getHasDecomposition <em>Has Decomposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Has Decomposition</em>'.
	 * @see gr.ntua.softeng.wtt.CompositeNode#getHasDecomposition()
	 * @see #getCompositeNode()
	 * @generated
	 */
	EReference getCompositeNode_HasDecomposition();

	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see gr.ntua.softeng.wtt.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see gr.ntua.softeng.wtt.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the containment reference list '{@link gr.ntua.softeng.wtt.Action#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requires</em>'.
	 * @see gr.ntua.softeng.wtt.Action#getRequires()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Requires();

	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see gr.ntua.softeng.wtt.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.ResourceDependency <em>Resource Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Dependency</em>'.
	 * @see gr.ntua.softeng.wtt.ResourceDependency
	 * @generated
	 */
	EClass getResourceDependency();

	/**
	 * Returns the meta object for the reference '{@link gr.ntua.softeng.wtt.ResourceDependency#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see gr.ntua.softeng.wtt.ResourceDependency#getFrom()
	 * @see #getResourceDependency()
	 * @generated
	 */
	EReference getResourceDependency_From();

	/**
	 * Returns the meta object for the reference '{@link gr.ntua.softeng.wtt.ResourceDependency#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see gr.ntua.softeng.wtt.ResourceDependency#getTo()
	 * @see #getResourceDependency()
	 * @generated
	 */
	EReference getResourceDependency_To();

	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.Decomposition <em>Decomposition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decomposition</em>'.
	 * @see gr.ntua.softeng.wtt.Decomposition
	 * @generated
	 */
	EClass getDecomposition();

	/**
	 * Returns the meta object for the containment reference list '{@link gr.ntua.softeng.wtt.Decomposition#getDecomposedTo <em>Decomposed To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decomposed To</em>'.
	 * @see gr.ntua.softeng.wtt.Decomposition#getDecomposedTo()
	 * @see #getDecomposition()
	 * @generated
	 */
	EReference getDecomposition_DecomposedTo();

	/**
	 * Returns the meta object for the attribute '{@link gr.ntua.softeng.wtt.Decomposition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see gr.ntua.softeng.wtt.Decomposition#getType()
	 * @see #getDecomposition()
	 * @generated
	 */
	EAttribute getDecomposition_Type();

	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.Precedence <em>Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precedence</em>'.
	 * @see gr.ntua.softeng.wtt.Precedence
	 * @generated
	 */
	EClass getPrecedence();

	/**
	 * Returns the meta object for the reference '{@link gr.ntua.softeng.wtt.Precedence#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see gr.ntua.softeng.wtt.Precedence#getFrom()
	 * @see #getPrecedence()
	 * @generated
	 */
	EReference getPrecedence_From();

	/**
	 * Returns the meta object for the reference '{@link gr.ntua.softeng.wtt.Precedence#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see gr.ntua.softeng.wtt.Precedence#getTo()
	 * @see #getPrecedence()
	 * @generated
	 */
	EReference getPrecedence_To();

	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.Contribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contribution</em>'.
	 * @see gr.ntua.softeng.wtt.Contribution
	 * @generated
	 */
	EClass getContribution();

	/**
	 * Returns the meta object for the attribute '{@link gr.ntua.softeng.wtt.Contribution#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see gr.ntua.softeng.wtt.Contribution#getType()
	 * @see #getContribution()
	 * @generated
	 */
	EAttribute getContribution_Type();

	/**
	 * Returns the meta object for the reference '{@link gr.ntua.softeng.wtt.Contribution#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see gr.ntua.softeng.wtt.Contribution#getFrom()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_From();

	/**
	 * Returns the meta object for the reference '{@link gr.ntua.softeng.wtt.Contribution#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see gr.ntua.softeng.wtt.Contribution#getTo()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_To();

	/**
	 * Returns the meta object for class '{@link gr.ntua.softeng.wtt.WebTaskTemplate <em>Web Task Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Task Template</em>'.
	 * @see gr.ntua.softeng.wtt.WebTaskTemplate
	 * @generated
	 */
	EClass getWebTaskTemplate();

	/**
	 * Returns the meta object for the attribute '{@link gr.ntua.softeng.wtt.WebTaskTemplate#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see gr.ntua.softeng.wtt.WebTaskTemplate#getName()
	 * @see #getWebTaskTemplate()
	 * @generated
	 */
	EAttribute getWebTaskTemplate_Name();

	/**
	 * Returns the meta object for the attribute '{@link gr.ntua.softeng.wtt.WebTaskTemplate#getDescr <em>Descr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descr</em>'.
	 * @see gr.ntua.softeng.wtt.WebTaskTemplate#getDescr()
	 * @see #getWebTaskTemplate()
	 * @generated
	 */
	EAttribute getWebTaskTemplate_Descr();

	/**
	 * Returns the meta object for the containment reference '{@link gr.ntua.softeng.wtt.WebTaskTemplate#getRefersTo <em>Refers To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Refers To</em>'.
	 * @see gr.ntua.softeng.wtt.WebTaskTemplate#getRefersTo()
	 * @see #getWebTaskTemplate()
	 * @generated
	 */
	EReference getWebTaskTemplate_RefersTo();

	/**
	 * Returns the meta object for the containment reference list '{@link gr.ntua.softeng.wtt.WebTaskTemplate#getContains <em>Contains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contains</em>'.
	 * @see gr.ntua.softeng.wtt.WebTaskTemplate#getContains()
	 * @see #getWebTaskTemplate()
	 * @generated
	 */
	EReference getWebTaskTemplate_Contains();

	/**
	 * Returns the meta object for enum '{@link gr.ntua.softeng.wtt.DecompositionType <em>Decomposition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Decomposition Type</em>'.
	 * @see gr.ntua.softeng.wtt.DecompositionType
	 * @generated
	 */
	EEnum getDecompositionType();

	/**
	 * Returns the meta object for enum '{@link gr.ntua.softeng.wtt.ContributionType <em>Contribution Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Contribution Type</em>'.
	 * @see gr.ntua.softeng.wtt.ContributionType
	 * @generated
	 */
	EEnum getContributionType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WttFactory getWttFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.TemplateLinkImpl <em>Template Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.TemplateLinkImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getTemplateLink()
		 * @generated
		 */
		EClass TEMPLATE_LINK = eINSTANCE.getTemplateLink();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.TemplateNodeImpl <em>Template Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.TemplateNodeImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getTemplateNode()
		 * @generated
		 */
		EClass TEMPLATE_NODE = eINSTANCE.getTemplateNode();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_NODE__COST = eINSTANCE.getTemplateNode_Cost();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE_NODE__NAME = eINSTANCE.getTemplateNode_Name();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.CompositeNodeImpl <em>Composite Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.CompositeNodeImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getCompositeNode()
		 * @generated
		 */
		EClass COMPOSITE_NODE = eINSTANCE.getCompositeNode();

		/**
		 * The meta object literal for the '<em><b>Has Decomposition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_NODE__HAS_DECOMPOSITION = eINSTANCE.getCompositeNode_HasDecomposition();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.TaskImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.ActionImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__REQUIRES = eINSTANCE.getAction_Requires();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.ResourceImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.ResourceDependencyImpl <em>Resource Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.ResourceDependencyImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getResourceDependency()
		 * @generated
		 */
		EClass RESOURCE_DEPENDENCY = eINSTANCE.getResourceDependency();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DEPENDENCY__FROM = eINSTANCE.getResourceDependency_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DEPENDENCY__TO = eINSTANCE.getResourceDependency_To();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.DecompositionImpl <em>Decomposition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.DecompositionImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getDecomposition()
		 * @generated
		 */
		EClass DECOMPOSITION = eINSTANCE.getDecomposition();

		/**
		 * The meta object literal for the '<em><b>Decomposed To</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECOMPOSITION__DECOMPOSED_TO = eINSTANCE.getDecomposition_DecomposedTo();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECOMPOSITION__TYPE = eINSTANCE.getDecomposition_Type();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.PrecedenceImpl <em>Precedence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.PrecedenceImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getPrecedence()
		 * @generated
		 */
		EClass PRECEDENCE = eINSTANCE.getPrecedence();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRECEDENCE__FROM = eINSTANCE.getPrecedence_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRECEDENCE__TO = eINSTANCE.getPrecedence_To();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.ContributionImpl <em>Contribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.ContributionImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getContribution()
		 * @generated
		 */
		EClass CONTRIBUTION = eINSTANCE.getContribution();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTION__TYPE = eINSTANCE.getContribution_Type();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTION__FROM = eINSTANCE.getContribution_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTION__TO = eINSTANCE.getContribution_To();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.impl.WebTaskTemplateImpl <em>Web Task Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.impl.WebTaskTemplateImpl
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getWebTaskTemplate()
		 * @generated
		 */
		EClass WEB_TASK_TEMPLATE = eINSTANCE.getWebTaskTemplate();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_TASK_TEMPLATE__NAME = eINSTANCE.getWebTaskTemplate_Name();

		/**
		 * The meta object literal for the '<em><b>Descr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WEB_TASK_TEMPLATE__DESCR = eINSTANCE.getWebTaskTemplate_Descr();

		/**
		 * The meta object literal for the '<em><b>Refers To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WEB_TASK_TEMPLATE__REFERS_TO = eINSTANCE.getWebTaskTemplate_RefersTo();

		/**
		 * The meta object literal for the '<em><b>Contains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WEB_TASK_TEMPLATE__CONTAINS = eINSTANCE.getWebTaskTemplate_Contains();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.DecompositionType <em>Decomposition Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.DecompositionType
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getDecompositionType()
		 * @generated
		 */
		EEnum DECOMPOSITION_TYPE = eINSTANCE.getDecompositionType();

		/**
		 * The meta object literal for the '{@link gr.ntua.softeng.wtt.ContributionType <em>Contribution Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gr.ntua.softeng.wtt.ContributionType
		 * @see gr.ntua.softeng.wtt.impl.WttPackageImpl#getContributionType()
		 * @generated
		 */
		EEnum CONTRIBUTION_TYPE = eINSTANCE.getContributionType();

	}

} //WttPackage
