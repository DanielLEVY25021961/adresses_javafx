/**
 * 
 */
package levy.daniel.application.vues.desktop.metier.contactsimple.vue;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;
import levy.daniel.application.vues.desktop.metier.contactsimple.controllervue.IContactSimpleVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.controllervue.ICreationContactSimpleVueController;

/**
 * CLASSE CreationContactSimpleVueFxml :<br/>
 * prépare la VUE AnchorPane <b>this.creationPersonneVueAnchorPane</b> 
 * modélisant la boîte de dialogue de création d'une ContactSimple.<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 22 mai 2018
 *
 */
public class CreationContactSimpleVueFxml {

	// ************************ATTRIBUTS************************************/
	
	/**
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
	 * VUE créée par la présente Classe.<br/>
	 * AnchorPane pour la création d'une ContactSimple.
	 */
	private AnchorPane creationContactSimpleVueAnchorPane;
	
	/**
	 * CONTROLLER DE VUE de la VUE AnchorPane 
	 * pour la création d'un contact simple.<br/>
	 */
	private ICreationContactSimpleVueController creationContactSimpleVueController;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(CreationContactSimpleVueFxml.class);

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pAccueilController : IAccueilController.<br/>
	 */
	public CreationContactSimpleVueFxml(
			final IAccueilController pAccueilController) {
		
		super();
		
		this.accueilController = pAccueilController;
		this.root = this.accueilController.getRoot();		
		this.contactSimpleAnchorPane 
			= this.accueilController.getContactSimpleAnchorPane();
		this.contactSimpleVueController 
			= this.accueilController.getContactSimpleVueController();
		
		this.dessiner();
		
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * method dessiner() :<br/>
	 * <ul>
	 * INSTANCIE LA VUE EN CHARGEANT UN FICHIER fxml.<br/>
	 * <li>instancie un FXMLLoader.</li>
	 * <li>positionne le FXMLLoader sur le bon fichier fxml.</li>
	 * <li>charge le fichier fxml et instancie le panneau 
	 * AnchorPane (VUE) modélisant la boite de saisie d'une ContactSimple.</li>
	 * </ul>
	 */
	private void dessiner() {
		
		try {
        	
        	/* *********************************************** */
        	/* FABRIQUE LE PANNEAU this.
        	 * creationContactSimpleVueAnchorPane (AnchorPane). */
            final FXMLLoader loader = new FXMLLoader();
            
            final URL url = CreationContactSimpleVueFxml.class
            		.getResource("CreationContactSimpleVue.fxml");
            
            /* positionne le FXMLLoader sur le bon fichier fxml. */
            loader.setLocation(url);
            
            /* charge le fichier fxml et instancie le 
             * panneau de fond de la scene. */
            /* instancie et alimente automatiquement le CONTROLLER DE VUE 
             * AccueilVueController. */
            this.creationContactSimpleVueAnchorPane 
            	= (AnchorPane) loader.load();
			
			/* récupère le CONTROLLER de VUE auprès du FXMLLoader. */
            this.creationContactSimpleVueController 
        	= (ICreationContactSimpleVueController) loader.getController();

		}
		catch (IOException e) {
			
			final String message 
    		= "Impossible de créer la boîte de dialogue "
    				+ "de création d'une ContactSimple "
    				+ "à partir des fichiers XML";
    	
	    	if (LOG.isFatalEnabled()) {
	    		LOG.fatal(message, e);
	    	}
		}
		
	} // Fin de dessiner().________________________________________________
	
	
	
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
	} // Fin de getContactSimpleAnchorPane().______________________________


	
	/**
	* Setter du panneau AnchorPane (VUE) modélisant un contact simple.<br/>
	*
	* @param pPersonneAnchorPane : AnchorPane : 
	* valeur à passer à this.contactSimpleAnchorPane.<br/>
	*/
	public void setContactSimpleAnchorPane(
			final AnchorPane pPersonneAnchorPane) {	
		this.contactSimpleAnchorPane = pPersonneAnchorPane;
	} // Fin de setPersonneAnchorPane(...).________________________________


	
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
	*
	* @param pContactSimpleVueController : ContactSimpleVueController : 
	* valeur à passer à this.contactSimpleVueController.<br/>
	*/
	public void setContactSimpleVueController(
			final IContactSimpleVueController pContactSimpleVueController) {
		this.contactSimpleVueController = pContactSimpleVueController;
	} // Fin de setContactSimpleVueController(...).________________________



	/**
	 * Getter de la VUE créée par la présente Classe.<br/>
	 * AnchorPane pour la création d'une ContactSimple.<br/>
	 *
	 * @return this.creationContactSimpleVueAnchorPane : AnchorPane.<br/>
	 */
	public AnchorPane getCreationContactSimpleVueAnchorPane() {
		return this.creationContactSimpleVueAnchorPane;
	} // Fin de getCreationContactSimpleVueAnchorPane().___________________



	/**
	* Setter de la VUE créée par la présente Classe.<br/>
	* AnchorPane pour la création d'une ContactSimple.<br/>
	*
	* @param pCreationContactSimpleVueAnchorPane : AnchorPane : 
	* valeur à passer à this.creationContactSimpleVueAnchorPane.<br/>
	*/
	public void setCreationContactSimpleVueAnchorPane(
			final AnchorPane pCreationContactSimpleVueAnchorPane) {
		this.creationContactSimpleVueAnchorPane = pCreationContactSimpleVueAnchorPane;
	} // Fin de setCreationContactSimpleVueAnchorPane(...).________________



	/**
	 * Getter du CONTROLLER DE VUE de la VUE AnchorPane 
	 * pour la création d'un contact simple.<br/>
	 *
	 * @return this.creationContactSimpleVueController : 
	 * ICreationContactSimpleVueController.<br/>
	 */
	public ICreationContactSimpleVueController getCreationContactSimpleVueController() {
		return this.creationContactSimpleVueController;
	} // Fin de getCreationContactSimpleVueController().___________________



	/**
	* Setter du CONTROLLER DE VUE de la VUE AnchorPane 
	* pour la création d'un contact simple.<br/>
	* <br/>
	*
	* @param pCreationContactSimpleVueController : ICreationContactSimpleVueController : 
	* valeur à passer à this.creationContactSimpleVueController.<br/>
	*/
	public void setCreationContactSimpleVueController(
			final ICreationContactSimpleVueController pCreationContactSimpleVueController) {
		this.creationContactSimpleVueController = pCreationContactSimpleVueController;
	} // Fin de setCreationContactSimpleVueController(...).________________
	

	
} // FIN DE LA CLASSE CreationContactSimpleVueFxml.--------------------------
