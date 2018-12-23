package levy.daniel.application.vues.desktop.accueil;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;


/**
 * CLASSE AccueilVueFxml :<br/>
 * prépare et retourne la VUE BorderPane <b>this.root</b> 
 * modélisant le panneau de fond de la Scene de l'application.<br/>
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
 * @since 22 mai 2018
 *
 */
public class AccueilVueFxml {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * loader : FXMLLoader :<br/>
	 * FXMLLoader.<br/>
	 */
	private final transient FXMLLoader loader = new FXMLLoader();
	
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
     * Accède aux éléments graphiques de <b>this.root</b> : 
     * barre de menus, Menus, Items des menus, ..<br/>
     */
    private IAccueilVueController accueilVueController;
    
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AccueilVueFxml.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public AccueilVueFxml() {
		
		super();
		
		this.dessiner();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method dessiner() :<br/>
	 * <ul>
	 * INSTANCIE LA VUE EN CHARGEANT UN FICHIER fxml.<br/>
	 * <li>instancie un FXMLLoader.</li>
	 * <li>positionne le FXMLLoader sur le bon fichier fxml.</li>
	 * <li>charge le fichier fxml et instancie le panneau 
	 * BorderPane (VUE) modélisant le panneau de fond de l'application.</li>
	 * </ul>
	 */
	private void dessiner() {
		
        try {
        	
        	/* *********************************************** */
        	/* FABRIQUE LE PANNEAU DE FOND this.root (BorderPane). */
            
            final URL url = AccueilVueFxml.class
            		.getResource("AccueilVue.fxml");
            
            /* positionne le FXMLLoader sur le bon fichier fxml. */
            this.positionnerLoader(url);
            
            /* charge le fichier fxml et instancie le 
             * panneau de fond de la scene. */
            /* instancie et alimente automatiquement le CONTROLLER DE VUE 
             * AccueilVueController. */
			this.chargerVueEtControllerDeVue(this.loader);
			
			/* récupère le CONTROLLER de VUE auprès du FXMLLoader. */
	        this.recupererAccueilVueController(this.loader);

		}
		catch (IOException e) {
			
			final String message 
    		= "Impossible de créer le fond de scène "
    				+ "à partir des fichiers XML";
    	
	    	if (LOG.isFatalEnabled()) {
	    		LOG.fatal(message, e);
	    	}
		}
        
	} // Fin de dessiner().________________________________________________
	

	
	/**
	 * Positionne this.loader sur pUrl.<br/>
	 *
	 * @param pUrl : URL.<br/>
	 */
	private void positionnerLoader(
			final URL pUrl) {
		this.loader.setLocation(pUrl);
	} // Fin de positionnerLoader(...).____________________________________
	

	
	/**
	 * Charge la VUE et instancie le CONTROLLER DE VUE associé.<br/>
	 * <ul>
	 * <li>charge la VUE BorderPane <b>this.root</b>.</li>
	 * <li>instancie le CONTROLLER DE VUE associé 
	 * <b>this.accueilVueController</b>.</li>
	 * </ul>
	 *
	 * @param pLoader : FXMLLoader.<br/>
	 * 
	 * @throws IOException 
	 */
	private void chargerVueEtControllerDeVue(
			final FXMLLoader pLoader) throws IOException {
		this.root = (BorderPane) pLoader.load();
	} // Fin de chargerVueEtControllerDeVue(...).__________________________
	
	
	
	/**
	 * method recupererPersonneVueController(
	 * FXMLLoader pLoader) :<br/>
	 * récupère le CONTROLLER DE VUE auprès du FXMLLoader.<br/>
	 * <br/>
	 *
	 * @param pLoader : FXMLLoader.<br/>
	 */
	private void recupererAccueilVueController(
			final FXMLLoader pLoader) {
		
		this.accueilVueController 
    	= (IAccueilVueController) pLoader.getController();
		
	} // Fin de recupererAccueilVueController(...).________________________
	
	
	
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
	 * method getAccueilVueController() :<br/>
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement 
	 * lors du chargement du FXML par le FXMLLoader.<br/>
	 * <br/>
	 *
	 * @return accueilVueController : AccueilVueController.<br/>
	 */
	public IAccueilVueController getAccueilVueController() {
		return this.accueilVueController;
	} // Fin de getAccueilVueController()._________________________________


	
	/**
	* method setAccueilVueController(
	* AccueilVueController pAccueilVueController) :<br/>
	* Setter du CONTROLLER DE VUE fabriqué automatiquement 
	* lors du chargement du FXML par le FXMLLoader.<br/>
	* <br/>
	*
	* @param pAccueilVueController : AccueilVueController : 
	* valeur à passer à accueilVueController.<br/>
	*/
	public void setAccueilVueController(
			final IAccueilVueController pAccueilVueController) {
		this.accueilVueController = pAccueilVueController;
	} // Fin de setAccueilVueController(...).______________________________

		

} // FIN DE LA CLASSE AccueilVueFxml.----------------------------------------
