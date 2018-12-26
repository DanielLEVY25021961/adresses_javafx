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
 * prépare la VUE AnchorPane <b>this.contactSimpleAnchorPane</b> 
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
	 * IAccueilController "Maître de Cérémonie" chargé 
	 * de mettre à disposition du présent CONTROLLER 
	 * toutes les vues, controllers et services de l'application.<br/>
	 */
	private IAccueilController accueilController;


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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleVueFxml.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <ul>
	 * <li>instancie la VUE this.contactSimpleAnchorPane 
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
		
		if (this.accueilController != null) {
			this.root = this.accueilController.getRoot();
		}
				
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
	 * this.contactSimpleVueController.</li>
	 * <li>Initialise la sélection dans le TableView.</li>
	 * <li>Positionne la VUE dans le panneau de fond de la scene.</li>
	 * </ul>
	 */
	private void dessiner() {

		try {

			/* instancie un FXMLLoader. */
			final FXMLLoader loader = new FXMLLoader();
			
			final URL url = ContactSimpleVueFxml.class
					.getResource("ContactSimpleVue.fxml");
			
			/* positionne le FXMLLoader sur le bon fichier fxml. */
			loader.setLocation(url);

			/* charge le fichier fxml et instancie le panneau 
			 * AnchorPane (VUE) modélisant une ContactSimple.*/
			this.contactSimpleAnchorPane = (AnchorPane) loader.load();
			
			/* LOAD PROVOQUE UN APPEL AUTOMATIQUE DU CONSTRUCTEUR
			 * , PUIS DE LA METHODE initialize() 
			 * du this.contactSimpleVueController. */
			
			/* récupère le CONTROLLER de VUE auprès du FXMLLoader. */
            this.recupererContactSimpleVueController(loader);
            
            /* CALLBACK. */
            /* Récupère les données (MODEL) à afficher dans le TableView 
             * auprès du CONTROLLER this.accueilController. */
            ObservableList<IContactSimpleModelObs> modelTableView = null;
            
            if (this.accueilController != null) {
            	modelTableView 
            		= this.accueilController.getListeContactSimples();
            }
            
            
            /* Passe le MODEL initial (base de données, fichier...) 
             * à afficher dans le TableView au CONTROLLER DE VUE 
             * this.contactSimpleVueController. */
            this.contactSimpleVueController
            	.setModelTableViewContactSimples(modelTableView);
            
            /* Initialise la sélection dans le TableView. */
            this.selectionnerValeurInitiale(0);
                        
            this.contactSimpleVueController
            	.setAccueilController(this.accueilController);

			/* Positionne la VUE dans le panneau de fond de la scene. */
            if (this.root != null) {
            	this.root.setCenter(this.contactSimpleAnchorPane);
            }
								
		}
		catch (IOException e) {
			
			final String message 
				= "Impossible de créer le contactSimpleAnchorPane " 
						+ "à partir des fichiers XML";

			if (LOG.isFatalEnabled()) {
				LOG.fatal(message, e);
			}

		}

	} // Fin de dessiner().________________________________________________
	

	
	/**
	 * récupère le CONTROLLER DE VUE auprès du FXMLLoader.<br/>
	 * <br/>
	 *
	 * @param pLoader : FXMLLoader.<br/>
	 */
	private void recupererContactSimpleVueController(
			final FXMLLoader pLoader) {
		
		this.contactSimpleVueController 
    		= (IContactSimpleVueController) pLoader.getController();
		
	} // Fin de recupererContactSimpleVueController(...).__________________
	

	
	/**
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
	 * Getter du Panneau de fond de la scene.<br/>
	 *
	 * @return this.root : BorderPane.<br/>
	 */
	public BorderPane getRoot() {	
		return this.root;
	} // Fin de getRoot()._________________________________________________
	
	
	
	/**
	* Setter du Panneau de fond de la scene.<br/>
	*
	* @param pRoot : BorderPane : 
	* valeur à passer à this.root.<br/>
	*/
	public void setRoot(
			final BorderPane pRoot) {	
		this.root = pRoot;
	} // Fin de setRoot(...).______________________________________________


	
	/**
	 * Getter de AccueilController.<br/>
	 *
	 * @return this.accueilController : IAccueilController.<br/>
	 */
	public IAccueilController getAccueilController() {	
		return this.accueilController;
	} // Fin de getAccueilController().____________________________________


	
	/**
	* Setter de AccueilController.<br/>
	*
	* @param pAccueilController : IAccueilController : 
	* valeur à passer à this.accueilController.<br/>
	*/
	public void setAccueilController(
			final IAccueilController pAccueilController) {	
		this.accueilController = pAccueilController;
	} // Fin de setAccueilController(...)._________________________________


	
	/**
	 * Getter du panneau AnchorPane (VUE) modélisant un contact simple.<br/>
	 *
	 * @return this.contactSimpleAnchorPane : AnchorPane.<br/>
	 */
	public AnchorPane getContactSimpleAnchorPane() {	
		return this.contactSimpleAnchorPane;
	} // Fin de getContactSimpleAnchorPane()().____________________________


	
	/**
	* Setter du panneau AnchorPane (VUE) modélisant un contact simple.<br/>
	*
	* @param pContactSimpleAnchorPane : AnchorPane : 
	* valeur à passer à this.contactSimpleAnchorPane.<br/>
	*/
	public void setContactSimpleAnchorPane(
			final AnchorPane pContactSimpleAnchorPane) {	
		this.contactSimpleAnchorPane = pContactSimpleAnchorPane;
	} // Fin de setContactSimpleAnchorPane(...).___________________________


	
	/**
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
	 *
	 * @return this.contactSimpleVueController : 
	 * ContactSimpleVueController.<br/>
	 */
	public IContactSimpleVueController getContactSimpleVueController() {
		return this.contactSimpleVueController;
	} // Fin de getContactSimpleVueController().___________________________


	
	/**
	* Setter du CONTROLLER DE VUE fabriqué automatiquement lors du 
    * chargement du FXML par le FXMLLoader.<br/>
    * Permet d'accéder aux objets graphiques de 
    * la VUE générés par le FXML.<br/>
	* <br/>
	*
	* @param pContactSimpleVueController : ContactSimpleVueController : 
	* valeur à passer à this.contactSimpleVueController.<br/>
	*/
	public void setContactSimpleVueController(
			final IContactSimpleVueController pContactSimpleVueController) {
		this.contactSimpleVueController = pContactSimpleVueController;
	} // Fin de setContactSimpleVueController(...).________________________
	
	
	
} // FIN DE LA CLASSE ContactSimpleVueFxml.----------------------------------
