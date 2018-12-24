package levy.daniel.application.controllers.desktop.accueil.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import levy.daniel.application.MainApplication;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;
import levy.daniel.application.controllers.desktop.metier.contactsimple.IContactSimpleController;
import levy.daniel.application.controllers.desktop.metier.contactsimple.IListeContactSimplesController;
import levy.daniel.application.controllers.desktop.metier.contactsimple.impl.ContactSimpleController;
import levy.daniel.application.controllers.desktop.metier.contactsimple.impl.ListeContactSimplesController;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.services.metier.contactsimple.IContactSimpleService;
import levy.daniel.application.model.services.metier.contactsimple.impl.ContactSimpleService;
import levy.daniel.application.vues.desktop.accueil.IAccueilVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.ContactSimpleVueFxml;
import levy.daniel.application.vues.desktop.metier.contactsimple.IContactSimpleVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.ICreationContactSimpleVueController;


/**
 * CLASSE AccueilController :<br/>
 * <ul>
 * CONTROLLER "Maître de Cérémonie" sollicité 
 * dès le lancement de l'application desktop 
 * (méthode start() de la classe MainApplication).<br/>
 * <li>Instancie, dessine et Retourne la scène d'accueil 
 * en décorant son panneau de fond this.root.</li>
 * <li>Met à disposition de tous les autres composants 
 * l'ensemble des VUES, CONTROLLERS et SERVICES 
 * utilisés dans l'application.</li>
 * <li>Se passe lui-même à tous les autres CONTROLLERS 
 * pour leur mettre à disposition l'ensemble des composants 
 * de l'application.</li>
 * <li>Instancie toutes les VUES.</li>
 * <li>Instancie tous les CONTROLLERS en leur passant leur
 *  VUE et leurs SERVICES.</li>
 * <li>instancie les MODELs comme par exemple les données initiales 
 * à injecter dans les TableViews.</li>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 9 mai 2018
 *
 */
public class AccueilController implements IAccueilController {

	// ************************ATTRIBUTS************************************/

	/**
	 * application principale.<br/>
	 */
	private MainApplication mainApplication;
	
	/**
	 * Panneau de fond de la scene.<br/>
	 */
	private BorderPane root;

    /**
     * CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
     */
    private IAccueilVueController accueilVueController;
    
	/**
	 * panneau AnchorPane (VUE) modélisant un contact simple.<br/>
	 */
	private AnchorPane contactSimpleAnchorPane;

	/**
	 * CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
	 */
	private IContactSimpleVueController contactSimpleVueController;
	
	/**
	 * liste des ContactSimpleController observables 
	 * pour tracker les changements dans les zones de texte.<br/>
	 */
	private ObservableList<IContactSimpleController> listeContactSimples 
		= FXCollections.observableArrayList();

	/**
	 * SERVICE gérant les ContactSimple et assurant le lien 
	 * entre les CONTROLLERS et la logique metier.<br/>
	 */
	private IContactSimpleService contactSimpleService;
	
	/**
	 * CONTROLLER gérant les listes de ContactSimple et assurant le lien 
	 * entre la logique metier et les objets metier "Observers".<br/>
	 */
	private IListeContactSimplesController listeContactSimplesController;
	

	/**
	 * creationPersonneVueAnchorPane : AnchorPane :<br/>
	 * AnchorPane pour la création d'une ContactSimple.
	 */
	private AnchorPane creationPersonneVueAnchorPane;

	
	/**
	 * creationContactSimpleVueController : ICreationContactSimpleVueController :<br/>
	 * CONTROLLER DE VUE de la VUE AnchorPane 
	 * pour la création d'un contact simple.<br/>
	 */
	private ICreationContactSimpleVueController creationContactSimpleVueController;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AccueilController.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AccueilController(
	 * MainApplication pMainApplication) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <ul>
	 * <li>alimente <b>this.root</b> (BorderPane) et 
	 * <b>this.accueilVueController</b> (CONTROLLER DE VUE).</li>
	 * <li>instancie le SERVICE pour les ContactSimple 
	 * <b>this.personneService</b>.</li>
	 * <li>PREPARE LA SCENE D'ACCUEIL.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pMainApplication : MainApplication.<br/>
	 */
	public AccueilController(
			final MainApplication pMainApplication) {
		
		super();
		
		this.mainApplication = pMainApplication;
		this.root = this.mainApplication.getRoot();
		this.accueilVueController 
			= this.mainApplication.getAccueilVueController();
		
		/* instancie le SERVICE pour les ContactSimple. */
		this.contactSimpleService = new ContactSimpleService();
		
		this.preparerSceneAccueil(); // NOPMD by dan on 09/05/18 17:54
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * method preparerSceneAccueil() :<br/>
	 * <ul>
	 * <li>initialise toutes les données (MODEL) 
	 * à passer à la VUE d'accueil.</li>
	 * <li>intancie et dessine la VUE this.personneAnchorPane.</li>
	 * <li></li>
	 * <li>.</li>
	 * <li>.</li>
	 * <li>.</li>
	 * <li>.</li>
	 * <li>.</li>
	 * <li>.</li>
	 * <img src="../../../../../../../../../../javadoc/images/AccueilController.preparerSceneAccueil_1.png"/>
	 * <img src="../../../../../../../../../../javadoc/images/AccueilController.preparerSceneAccueil_2.png"/>
	 * </ul>
	 */
	private void preparerSceneAccueil() {

		/* initialise toutes les données (MODEL) 
		 * à passer à la VUE d'accueil. */
		this.initialiserDonnees();
		
		/* intancie et dessine la VUE this.personneAnchorPane.*/
		this.dessinerVueAnchorPanePersonne();
		
		new ListeContactSimplesController(this.contactSimpleAnchorPane, this, this.listeContactSimples);
		
	} // Fin de preparerSceneAccueil().____________________________________


	
	/**
	 * method initialiserDonnees() :<br/>
	 * <ul>
	 * <li>sollicite les SERVICES pour initialiser 
	 * toutes les données (MODEL) à passer à la VUE d'accueil.</li>
	 * <li>Récupère la liste des ContactSimple déjà stockées 
	 * auprès du SERVICE.</li>
	 * <li>Convertit la List&lt;IContactSimple&gt; en 
	 * ObservableList&lt;IContactSimpleController&gt;.</li>
	 * <li>Ajoute des valeurs initiales à l'ObservableList 
	 * this.listePersonnes.</li>
	 * </ul>
	 */
	private void initialiserDonnees() {
		
		/* Récupère la liste des ContactSimple déjà stockées 
		 * auprès du SERVICE. */
		final List<IContactSimple> listeInitialePersonnes 
			= this.contactSimpleService.initialiserListePersonnes();
		
		/* Convertit la List<IContactSimple> en 
		 * ObservableList<IContactSimpleController>. */
		final ObservableList<IContactSimpleController> listeInitialePControllers 
			= this.convertirList(listeInitialePersonnes);
		
		/* Ajoute des valeurs initiales à l'ObservableList 
		 * this.listePersonnes. */
		this.ajouterPersonnesContrlAListPersonnes(
				listeInitialePControllers);
		
	} // Fin de initialiserDonnees().______________________________________

	
	
	/**
	 * method dessinerVueAnchorPanePersonne() :<br/>
	 * <ul>
	 * <li>intancie et dessine la VUE <b>this.personneAnchorPane</b>.</li>
	 * <li>Positionne this.personneAnchorPane dans 
	 * le panneau de fond de la scene this.root;</li>
	 * <li>Récupère la VUE this.personneAnchorPane auprès 
	 * du ContactSimpleVueFxml.</li>
	 * <li>Récupère le CONTROLLER DE VUE this.personneVueController 
	 * créé par le FXMLLoader.</li>
	 * </ul>
	 */
	private void dessinerVueAnchorPanePersonne() {
		
		/* Instancie la VUE this.personneAnchorPane. */
		final ContactSimpleVueFxml personneVue = new ContactSimpleVueFxml(this);
		
		/* Récupère la VUE this.personneAnchorPane 
		 * auprès du ContactSimpleVueFxml. */
		this.contactSimpleAnchorPane = personneVue.getPersonneAnchorPane();
		
		/* Récupère le CONTROLLER DE VUE this.personneVueController 
		 * créé par le FXMLLoader. */
		this.contactSimpleVueController 
			= personneVue.getPersonneVueController();
				
	} // Fin de dessinerVueAnchorPanePersonne().___________________________
	
	

	/**
	 * method convertirList(
	 * List&lt;IContactSimple&gt; pList) :<br/>
	 * convertit une java.util.List de IContactSimple (MODEL) en 
	 * Collection de IContactSimpleController (CONTROLLER de IContactSimple).<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;.<br/>
	 *  
	 * @return : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 */
	private ObservableList<IContactSimpleController> convertirList(
			final List<IContactSimple> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}

		final ObservableList<IContactSimpleController> resultat 
			= FXCollections.observableArrayList();
		
		for (final IContactSimple contactSimple : pList) {
			
			if (contactSimple != null) {
				
				final IContactSimpleController contactSimpleController 
				= new ContactSimpleController(contactSimple);
				
				resultat.add(contactSimpleController);
				
			}			
		}
		
		return resultat;
		
	} // Fin de convertirList(...).________________________________________
	
	
	
	/**
	 * method ajouterPersonnesContrlAListPersonnes(
	 * ObservableList&lt;IContactSimpleController&gt; pList) :<br/>
	 * Ajoute des IContactSimpleController à <b>this.listePersonnes</b>.<br/>
	 * <br/>
	 *
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 */
	private void ajouterPersonnesContrlAListPersonnes(
			final ObservableList<IContactSimpleController> pList) {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}
		
		this.listeContactSimples.addAll(pList);
		
	} // Fin de ajouterPersonnesContrlAListPersonnes(...)._________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public MainApplication getMainApplication() {
		return this.mainApplication;
	} // Fin de getMainApplication().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMainApplication(
			final MainApplication pMainApplication) {
		this.mainApplication = pMainApplication;
	} // Fin de setMainApplication(...).___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final BorderPane getRoot() {	
		return this.root;
	} // Fin de getRoot()._________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRoot(
			final BorderPane pRoot) {	
		this.root = pRoot;
	} // Fin de setRoot(...).______________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IAccueilVueController getAccueilVueController() {
		return this.accueilVueController;
	} // Fin de getAccueilVueController()._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setAccueilVueController(
			final IAccueilVueController pAccueilVueController) {
		this.accueilVueController = pAccueilVueController;
	} // Fin de setAccueilVueController(...).______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final AnchorPane getContactSimpleAnchorPane() {	
		return this.contactSimpleAnchorPane;
	} // Fin de getContactSimpleAnchorPane().______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setContactSimpleAnchorPane(
			final AnchorPane pContactSimpleAnchorPane) {	
		this.contactSimpleAnchorPane = pContactSimpleAnchorPane;
	} // Fin de setContactSimpleAnchorPane(...).___________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IContactSimpleVueController getContactSimpleVueController() {
		return this.contactSimpleVueController;
	} // Fin de getContactSimpleVueController().___________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPersonneVueController(
			final IContactSimpleVueController pContactSimpleVueController) {
		this.contactSimpleVueController = pContactSimpleVueController;
	} // Fin de setPersonneVueController(...)._____________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ObservableList<IContactSimpleController> getListePersonnes() {	
		return this.listeContactSimples;
	} // Fin de getListePersonnes()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setListePersonnes(
			final ObservableList<IContactSimpleController> pListePersonnes) {	
		this.listeContactSimples = pListePersonnes;
	} // Fin de setListePersonnes(...).____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IContactSimpleService getPersonneService() {
		return this.contactSimpleService;
	} // Fin de getPersonneService().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPersonneService(
			final IContactSimpleService pContactSimpleService) {
		this.contactSimpleService = pContactSimpleService;
	} // Fin de setPersonneService(...).___________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final AnchorPane getCreationPersonneVueAnchorPane() {
		return this.creationPersonneVueAnchorPane;
	} // Fin de getCreationPersonneVueAnchorPane().________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCreationPersonneVueAnchorPane(
			final AnchorPane pCreationPersonneVueAnchorPane) {
		this.creationPersonneVueAnchorPane = pCreationPersonneVueAnchorPane;
	} // Fin de setCreationPersonneVueAnchorPane(...)._____________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ICreationContactSimpleVueController getCreationPersonneVueController() {
		return this.creationContactSimpleVueController;
	} // Fin de getCreationPersonneVueController().________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCreationPersonneVueController(
			final ICreationContactSimpleVueController pCreationContactSimpleVueController) {
		this.creationContactSimpleVueController = pCreationContactSimpleVueController;
	} // Fin de setCreationPersonneVueController(...)._____________________
	


} // FIN DE LA CLASSE CLASSE AccueilController.------------------------------
