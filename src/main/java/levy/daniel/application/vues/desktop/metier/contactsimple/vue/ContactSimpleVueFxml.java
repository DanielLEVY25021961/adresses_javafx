package levy.daniel.application.vues.desktop.metier.contactsimple.vue;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;
import levy.daniel.application.vues.desktop.metier.contactsimple.controllervue.IContactSimpleVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;


/**
 * CLASSE ContactSimpleVueFxml :<br/>
 * prépare la VUE AnchorPane <b>this.personneAnchorPane</b> 
 * modélisant une ContactSimple.<br/>
 * <ul>
 * <li>charge dans sa méthode dessiner() le FXML.</li>
 * <li></li>
 * <li></li>
 * <li></li>
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
public class ContactSimpleVueFxml {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * root : BorderPane :<br/>
	 * Panneau de fond de la scene.<br/>
	 */
	private BorderPane root;
	

	/**
	 * accueilController : IAccueilController :<br/>
	 * IAccueilController "Maître de Cérémonie" chargé 
	 * de mettre à disposition du présent CONTROLLER 
	 * toutes les vues, controllers et services de l'application.<br/>
	 */
	private IAccueilController accueilController;


	/**
	 * personneAnchorPane : AnchorPane :<br/>
	 * panneau AnchorPane (VUE) modélisant une personne.<br/>
	 */
	private AnchorPane personneAnchorPane;

	
	/**
	 * contactSimpleVueController : ContactSimpleVueController :<br/>
	 * CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
	 */
	private IContactSimpleVueController contactSimpleVueController;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ContactSimpleVueFxml.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR ContactSimpleVueFxml(
	 * IAccueilController pAccueilController) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <ul>
	 * <li>instancie la VUE this.personneAnchorPane 
	 * via un FXMLLoader. </li>
	 * <li>Le chargement via le FXMLLoader provoque automatiquement 
	 * l'instanciation du CONTROLLER DE VUE ContactSimpleVueController 
	 * et l'exécution de sa méthode initialize().</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pAccueilController : IAccueilController.<br/>  
	 */
	public ContactSimpleVueFxml(
			final IAccueilController pAccueilController) {
		
		super();
				
		this.accueilController = pAccueilController;
		this.root = this.accueilController.getRoot();
		
		/* INSTANCIE LA VUE EN CHARGEANT UN FICHIER fxml. */
		this.dessiner();
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * method dessiner() :<br/>
	 * <ul>
	 * INSTANCIE LA VUE EN CHARGEANT UN FICHIER fxml.<br/>
	 * <li>instancie un FXMLLoader.</li>
	 * <li>positionne le FXMLLoader sur le bon fichier fxml.</li>
	 * <li>charge le fichier fxml et instancie le panneau 
	 * AnchorPane (VUE) modélisant une ContactSimple.</li>
	 * <li>Récupère les données (MODEL) à afficher dans le TableView 
	 * auprès du CONTROLLER this.accueilController.</li>
	 * <li>Passe le MODEL initial (base de données, fichier...) 
	 * à afficher dans le TableView au CONTROLLER DE VUE 
	 * this.personneVueController.</li>
	 * <li>Initialise la sélection dans le TableView.</li>
	 * <li>Positionne la VUE dans le panneau de fond de la scene.</li>
	 * </ul>
	 */
	private void dessiner() {

		try {

			/* instancie un FXMLLoader. */
			final FXMLLoader loader = new FXMLLoader();
			
			final URL url = ContactSimpleVueFxml.class
					.getResource("PersonneVue.fxml");
			
			/* positionne le FXMLLoader sur le bon fichier fxml. */
			loader.setLocation(url);

			/* charge le fichier fxml et instancie le panneau 
			 * AnchorPane (VUE) modélisant une ContactSimple.*/
			this.personneAnchorPane = (AnchorPane) loader.load();
			
			/* LOAD PROVOQUE UN APPEL AUTOMATIQUE DU CONSTRUCTEUR
			 * , PUIS DE LA METHODE initialize() 
			 * du this.personneVueController. */
			
			/* récupère le CONTROLLER de VUE auprès du FXMLLoader. */
            this.recupererPersonneVueController(loader);
            
            /* CALLBACK. */
            /* Récupère les données (MODEL) à afficher dans le TableView 
             * auprès du CONTROLLER this.accueilController. */
            final ObservableList<IContactSimpleModelObs> modelTableView 
            	= this.accueilController.getListeContactSimples();
            
            /* Passe le MODEL initial (base de données, fichier...) 
             * à afficher dans le TableView au CONTROLLER DE VUE 
             * this.personneVueController. */
            this.contactSimpleVueController
            	.setModelTableViewPersonnes(modelTableView);
            
            /* Initialise la sélection dans le TableView. */
            this.selectionnerValeurInitiale(0);
                        
            this.contactSimpleVueController
            	.setAccueilController(this.accueilController);

			/* Positionne la VUE dans le panneau de fond de la scene. */
			this.root.setCenter(this.personneAnchorPane);
						
		}
		catch (IOException e) {
			
			final String message 
				= "Impossible de créer le personneAnchorPane " 
						+ "à partir des fichiers XML";

			if (LOG.isFatalEnabled()) {
				LOG.fatal(message, e);
			}

		}

	} // Fin de dessiner().________________________________________________
	

	
	/**
	 * method recupererPersonneVueController(
	 * FXMLLoader pLoader) :<br/>
	 * récupère le CONTROLLER DE VUE auprès du FXMLLoader.<br/>
	 * <br/>
	 *
	 * @param pLoader : FXMLLoader.<br/>
	 */
	private void recupererPersonneVueController(
			final FXMLLoader pLoader) {
		
		this.contactSimpleVueController 
    		= (IContactSimpleVueController) pLoader.getController();
		
	} // Fin de recupererPersonneVueController(...)._______________________
	

	
	/**
	 * method selectionnerValeurInitiale(
	 * int pIndex) :<br/>
	 * Sélectionne un rang dans le TableView en 
	 * fonction de son index 0-based.<br/>
	 * <br/>
	 *
	 * @param pIndex : int : 
	 * index 0-based de la donnée dans le MODEL.<br/>
	 */
	private void selectionnerValeurInitiale(
			final int pIndex) {
		this.contactSimpleVueController.getModelSelection().select(pIndex);
	} // Fin de selectionnerValeurInitiale(...).___________________________
	
	
	
	/**
	 * method getRoot() :<br/>
	 * Getter du Panneau de fond de la scene.<br/>
	 * <br/>
	 *
	 * @return root : BorderPane.<br/>
	 */
	public BorderPane getRoot() {	
		return this.root;
	} // Fin de getRoot()._________________________________________________
	
	
	
	/**
	* method setRoot(
	* BorderPane pRoot) :<br/>
	* Setter du Panneau de fond de la scene.<br/>
	* <br/>
	*
	* @param pRoot : BorderPane : valeur à passer à root.<br/>
	*/
	public void setRoot(
			final BorderPane pRoot) {	
		this.root = pRoot;
	} // Fin de setRoot(...).______________________________________________


	
	/**
	 * method getAccueilController() :<br/>
	 * Getter de AccueilController.<br/>
	 * <br/>
	 *
	 * @return accueilController : IAccueilController.<br/>
	 */
	public IAccueilController getAccueilController() {	
		return this.accueilController;
	} // Fin de getAccueilController().____________________________________


	
	/**
	* method setAccueilController(
	* IAccueilController pAccueilController) :<br/>
	* Setter de AccueilController.<br/>
	* <br/>
	*
	* @param pAccueilController : IAccueilController : 
	* valeur à passer à accueilController.<br/>
	*/
	public void setAccueilController(
			final IAccueilController pAccueilController) {	
		this.accueilController = pAccueilController;
	} // Fin de setAccueilController(...)._________________________________


	
	/**
	 * method getPersonneAnchorPane() :<br/>
	 * Getter du panneau AnchorPane (VUE) modélisant une personne.<br/>
	 * <br/>
	 *
	 * @return personneAnchorPane : AnchorPane.<br/>
	 */
	public AnchorPane getPersonneAnchorPane() {	
		return this.personneAnchorPane;
	} // Fin de getPersonneAnchorPane().___________________________________


	
	/**
	* method setPersonneAnchorPane(
	* AnchorPane pPersonneAnchorPane) :<br/>
	* Setter du panneau AnchorPane (VUE) modélisant une personne.<br/>
	* <br/>
	*
	* @param pPersonneAnchorPane : AnchorPane : 
	* valeur à passer à personneAnchorPane.<br/>
	*/
	public void setPersonneAnchorPane(
			final AnchorPane pPersonneAnchorPane) {	
		this.personneAnchorPane = pPersonneAnchorPane;
	} // Fin de setPersonneAnchorPane(...).________________________________


	
	/**
	 * method getPersonneVueController() :<br/>
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
	 * <br/>
	 *
	 * @return contactSimpleVueController : ContactSimpleVueController.<br/>
	 */
	public IContactSimpleVueController getPersonneVueController() {
		return this.contactSimpleVueController;
	} // Fin de getPersonneVueController().________________________________


	
	/**
	* method setPersonneVueController(
	* ContactSimpleVueController pPersonneVueController) :<br/>
	* Setter du CONTROLLER DE VUE fabriqué automatiquement lors du 
    * chargement du FXML par le FXMLLoader.<br/>
    * Permet d'accéder aux objets graphiques de 
    * la VUE générés par le FXML.<br/>
	* <br/>
	*
	* @param pContactSimpleVueController : ContactSimpleVueController : 
	* valeur à passer à contactSimpleVueController.<br/>
	*/
	public void setPersonneVueController(
			final IContactSimpleVueController pContactSimpleVueController) {
		this.contactSimpleVueController = pContactSimpleVueController;
	} // Fin de setPersonneVueController(...)._____________________________
	
	
	
} // FIN DE LA CLASSE ContactSimpleVueFxml.---------------------------------------
