/**
 * 
 */
package levy.daniel.application.vues.desktop.metier.contactsimple;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;

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
	 * creationPersonneVueAnchorPane : AnchorPane :<br/>
	 * VUE créée par la présente Classe.<br/>
	 * AnchorPane pour la création d'une ContactSimple.
	 */
	private AnchorPane creationPersonneVueAnchorPane;

	
	/**
	 * creationContactSimpleVueController : ICreationContactSimpleVueController :<br/>
	 * CONTROLLER DE VUE de la VUE AnchorPane 
	 * pour la création d'une personne.<br/>
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
	 * method CONSTRUCTEUR CreationContactSimpleVueFxml() :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pAccueilController : IAccueilController.<br/>
	 */
	public CreationContactSimpleVueFxml(final IAccueilController pAccueilController) {
		
		super();
		
		this.accueilController = pAccueilController;
		this.root = this.accueilController.getRoot();		
		this.personneAnchorPane 
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
        	 * creationPersonneVueAnchorPane (AnchorPane). */
            final FXMLLoader loader = new FXMLLoader();
            
            final URL url = CreationContactSimpleVueFxml.class
            		.getResource("CreationPersonneVue.fxml");
            
            /* positionne le FXMLLoader sur le bon fichier fxml. */
            loader.setLocation(url);
            
            /* charge le fichier fxml et instancie le 
             * panneau de fond de la scene. */
            /* instancie et alimente automatiquement le CONTROLLER DE VUE 
             * AccueilVueController. */
            this.creationPersonneVueAnchorPane 
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



	/**
	 * Getter de la VUE créée par la présente Classe.<br/>
	 * AnchorPane pour la création d'une ContactSimple.<br/>
	 * <br/>
	 *
	 * @return creationPersonneVueAnchorPane : AnchorPane : 
	 * this.creationPersonneVueAnchorPane.<br/>
	 */
	public AnchorPane getCreationPersonneVueAnchorPane() {
		return this.creationPersonneVueAnchorPane;
	} // Fin de getCreationPersonneVueAnchorPane().________________________



	/**
	* Setter de la VUE créée par la présente Classe.<br/>
	* AnchorPane pour la création d'une ContactSimple.<br/>
	* <br/>
	*
	* @param pCreationPersonneVueAnchorPane : AnchorPane : 
	* valeur à passer à this.creationPersonneVueAnchorPane.<br/>
	*/
	public void setCreationPersonneVueAnchorPane(
			final AnchorPane pCreationPersonneVueAnchorPane) {
		this.creationPersonneVueAnchorPane = pCreationPersonneVueAnchorPane;
	} // Fin de setCreationPersonneVueAnchorPane(...)._____________________



	/**
	 * Getter du CONTROLLER DE VUE de la VUE AnchorPane 
	 * pour la création d'une personne.<br/>
	 * <br/>
	 *
	 * @return this.creationPersonneVueController : 
	 * ICreationContactSimpleVueController.<br/>
	 */
	public ICreationContactSimpleVueController getCreationPersonneVueController() {
		return this.creationContactSimpleVueController;
	} // Fin de getCreationPersonneVueController().________________________



	/**
	* Setter du CONTROLLER DE VUE de la VUE AnchorPane 
	* pour la création d'une personne.<br/>
	* <br/>
	*
	* @param pCreationContactSimpleVueController : ICreationContactSimpleVueController : 
	* valeur à passer à this.creationPersonneVueController.<br/>
	*/
	public void setCreationPersonneVueController(
			final ICreationContactSimpleVueController pCreationContactSimpleVueController) {
		this.creationContactSimpleVueController = pCreationContactSimpleVueController;
	} // Fin de setCreationPersonneVueController(...)._____________________
	

	
} // FIN DE LA CLASSE CreationContactSimpleVueFxml.-------------------------------
