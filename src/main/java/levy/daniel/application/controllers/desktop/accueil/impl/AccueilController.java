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
import levy.daniel.application.controllers.desktop.metier.personne.ICreationPersonneVueController;
import levy.daniel.application.controllers.desktop.metier.personne.IListePersonnesController;
import levy.daniel.application.controllers.desktop.metier.personne.IPersonneController;
import levy.daniel.application.controllers.desktop.metier.personne.IPersonneVueController;
import levy.daniel.application.controllers.desktop.metier.personne.impl.ListePersonnesController;
import levy.daniel.application.controllers.desktop.metier.personne.impl.PersonneController;
import levy.daniel.application.model.metier.personne.IPersonne;
import levy.daniel.application.model.services.metier.personne.IPersonneService;
import levy.daniel.application.model.services.metier.personne.impl.PersonneService;
import levy.daniel.application.vues.desktop.accueil.IAccueilVueController;
import levy.daniel.application.vues.desktop.metier.personne.PersonneVueFxml;


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
	 * mainApplication : MainApplication :<br/>
	 * application principale.<br/>
	 */
	private MainApplication mainApplication;
	
	/**
	 * root : BorderPane :<br/>
	 * Panneau de fond de la scene.<br/>
	 */
	private BorderPane root;

    /**
     * accueilVueController : AccueilVueController :<br/>
     * CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
     */
    private IAccueilVueController accueilVueController;
    
	/**
	 * personneAnchorPane : AnchorPane :<br/>
	 * panneau AnchorPane (VUE) modélisant une personne.<br/>
	 */
	private AnchorPane personneAnchorPane;

	/**
	 * personneVueController : PersonneVueController :<br/>
	 * CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
	 */
	private IPersonneVueController personneVueController;
	
	/**
	 * listePersonnes : ObservableList<IPersonneController> :<br/>
	 * liste des PersonneController.<br/>
	 */
	private ObservableList<IPersonneController> listePersonnes 
		= FXCollections.observableArrayList();

	/**
	 * personneService : IPersonneService :<br/>
	 * SERVICE gérant les Personne et assurant le lien 
	 * entre les CONTROLLERS et la logique metier.<br/>
	 */
	private IPersonneService personneService;
	
	/**
	 * listePersonnesController : IListePersonnesController :<br/>
	 * CONTROLLER gérant les listes de Personne et assurant le lien 
	 * entre la logique metier et les objets metier "Observers".<br/>
	 */
	private IListePersonnesController listePersonnesController;
	

	/**
	 * creationPersonneVueAnchorPane : AnchorPane :<br/>
	 * AnchorPane pour la création d'une Personne.
	 */
	private AnchorPane creationPersonneVueAnchorPane;

	
	/**
	 * creationPersonneVueController : ICreationPersonneVueController :<br/>
	 * CONTROLLER DE VUE de la VUE AnchorPane 
	 * pour la création d'une personne.<br/>
	 */
	private ICreationPersonneVueController creationPersonneVueController;

	
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
	 * <li>instancie le SERVICE pour les Personne 
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
		
		/* instancie le SERVICE pour les Personne. */
		this.personneService = new PersonneService();
		
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
		
		new ListePersonnesController(this.personneAnchorPane, this, this.listePersonnes);
		
	} // Fin de preparerSceneAccueil().____________________________________


	
	/**
	 * method initialiserDonnees() :<br/>
	 * <ul>
	 * <li>sollicite les SERVICES pour initialiser 
	 * toutes les données (MODEL) à passer à la VUE d'accueil.</li>
	 * <li>Récupère la liste des Personne déjà stockées 
	 * auprès du SERVICE.</li>
	 * <li>Convertit la List&lt;IPersonne&gt; en 
	 * ObservableList&lt;IPersonneController&gt;.</li>
	 * <li>Ajoute des valeurs initiales à l'ObservableList 
	 * this.listePersonnes.</li>
	 * </ul>
	 */
	private void initialiserDonnees() {
		
		/* Récupère la liste des Personne déjà stockées 
		 * auprès du SERVICE. */
		final List<IPersonne> listeInitialePersonnes 
			= this.personneService.initialiserListePersonnes();
		
		/* Convertit la List<IPersonne> en 
		 * ObservableList<IPersonneController>. */
		final ObservableList<IPersonneController> listeInitialePControllers 
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
	 * du PersonneVueFxml.</li>
	 * <li>Récupère le CONTROLLER DE VUE this.personneVueController 
	 * créé par le FXMLLoader.</li>
	 * </ul>
	 */
	private void dessinerVueAnchorPanePersonne() {
		
		/* Instancie la VUE this.personneAnchorPane. */
		final PersonneVueFxml personneVue = new PersonneVueFxml(this);
		
		/* Récupère la VUE this.personneAnchorPane 
		 * auprès du PersonneVueFxml. */
		this.personneAnchorPane = personneVue.getPersonneAnchorPane();
		
		/* Récupère le CONTROLLER DE VUE this.personneVueController 
		 * créé par le FXMLLoader. */
		this.personneVueController 
			= personneVue.getPersonneVueController();
				
	} // Fin de dessinerVueAnchorPanePersonne().___________________________
	
	

	/**
	 * method convertirList(
	 * List&lt;IPersonne&gt; pList) :<br/>
	 * convertit une java.util.List de IPersonne (MODEL) en 
	 * Collection de IPersonneController (CONTROLLER de IPersonne).<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IPersonne&gt;.<br/>
	 *  
	 * @return : ObservableList&lt;IPersonneController&gt;.<br/>
	 */
	private ObservableList<IPersonneController> convertirList(
			final List<IPersonne> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}

		final ObservableList<IPersonneController> resultat 
			= FXCollections.observableArrayList();
		
		for (final IPersonne personne : pList) {
			
			if (personne != null) {
				
				final IPersonneController personneController 
				= new PersonneController(personne);
				
				resultat.add(personneController);
				
			}			
		}
		
		return resultat;
		
	} // Fin de convertirList(...).________________________________________
	
	
	
	/**
	 * method ajouterPersonnesContrlAListPersonnes(
	 * ObservableList&lt;IPersonneController&gt; pList) :<br/>
	 * Ajoute des IPersonneController à <b>this.listePersonnes</b>.<br/>
	 * <br/>
	 *
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 */
	private void ajouterPersonnesContrlAListPersonnes(
			final ObservableList<IPersonneController> pList) {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}
		
		this.listePersonnes.addAll(pList);
		
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
	public final AnchorPane getPersonneAnchorPane() {	
		return this.personneAnchorPane;
	} // Fin de getPersonneAnchorPane().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPersonneAnchorPane(
			final AnchorPane pPersonneAnchorPane) {	
		this.personneAnchorPane = pPersonneAnchorPane;
	} // Fin de setPersonneAnchorPane(...).________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IPersonneVueController getPersonneVueController() {
		return this.personneVueController;
	} // Fin de getPersonneVueController().________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPersonneVueController(
			final IPersonneVueController pPersonneVueController) {
		this.personneVueController = pPersonneVueController;
	} // Fin de setPersonneVueController(...)._____________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ObservableList<IPersonneController> getListePersonnes() {	
		return this.listePersonnes;
	} // Fin de getListePersonnes()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setListePersonnes(
			final ObservableList<IPersonneController> pListePersonnes) {	
		this.listePersonnes = pListePersonnes;
	} // Fin de setListePersonnes(...).____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IPersonneService getPersonneService() {
		return this.personneService;
	} // Fin de getPersonneService().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPersonneService(
			final IPersonneService pPersonneService) {
		this.personneService = pPersonneService;
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
	public final ICreationPersonneVueController getCreationPersonneVueController() {
		return this.creationPersonneVueController;
	} // Fin de getCreationPersonneVueController().________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCreationPersonneVueController(
			final ICreationPersonneVueController pCreationPersonneVueController) {
		this.creationPersonneVueController = pCreationPersonneVueController;
	} // Fin de setCreationPersonneVueController(...)._____________________
	


} // FIN DE LA CLASSE CLASSE AccueilController.------------------------------
