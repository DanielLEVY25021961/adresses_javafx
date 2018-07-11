package levy.daniel.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import levy.daniel.application.controllers.desktop.accueil.IAccueilVueController;
import levy.daniel.application.controllers.desktop.accueil.impl.AccueilController;
import levy.daniel.application.vues.desktop.accueil.AccueilVueFxml;

/**
 * CLASSE MainApplication :<br/>
 * Point d'entrée de l'application.<br/>
 * Hérite de <b>javafx.application.Application</b>.
 * <br/><br/>
 * <img src="../../../../../../javadoc/images/classe_MainApplication.png" 
 * alt="diagramme de classes de la classe MainApplication" border="1" align="center" />
 * <br/><br/>
 * <ul>
 * fabrique dans sa méthode <b>start(Stage pPrimaryStage)</b> 
 * exécutée dans le <b>Thread JavaFX</b> : <br/>
 * <br/>
 * <li>Le panneau de fond de la Scene : le BorderPane <b>root</b> 
 * lié au fichier FXML <b>AccueilVue.fxml</b>.</li>
 * <br/>
 * <img src="../../../../../../javadoc/images/BorderPane_root-AccueilVue.fxml.png" 
 * alt="BorderPane root et sa MenuBar rootMenuBar" border="1" align="center" />
 * <br/><br/>
 * <li>le contenu de root : l'AnchorPane <b>personneAnchorPane</b> qui affiche 
 * les renseignements sur les Personnes du carnet d'adresses 
 * lié au fichier FXML <b>PersonneVue.fxml</b>.<br/>
 * La fabrication de personneAnchorPane et son incorporation dans root 
 * est déleguée au CONTROLLER <b>AccueilController</b>.</li>
 * <br/>
 * <img src="../../../../../../javadoc/images/AnchorPane_personneAnchorPane-PersonneVue.fxml.png" 
 * alt="AnchorPane personneAnchorPane lié à PersonneVue.fxml" border="1" align="center" />
 * <br/><br/>
 * <li>la <b>Scene</b> en lui passant root.</li>
 * <li>Puis, affiche le théâtre <b>this.primaryStage</b> après lui avoir passé la Scene.</li>
 * <br/>
 * <img src="../../../../../../javadoc/images/Stage_Theatre-Application de gestion d'adresses JavaFX.png" 
 * alt="Théâtre this.primaryStage affichant la Scene" border="1" align="center" />
 * <br/><br/>
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
public class MainApplication extends Application {
	

	// ************************ATTRIBUTS************************************/	
	
	/**
	 * primaryStage : Stage :<br/>
	 * <b>Theatre</b> chargé d'afficher la <b>Scene</b>.<br/>
	 */
	private Stage primaryStage;

	
    /**
     * root : BorderPane :<br/>
     * <b>panneau de fond</b> de la <b>Scene</b>.<br/>
     * Contient une barre de Menus en haut et 
     * l'essentiel de l'IHM en dessous.<br/>
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
	private static final Log LOG = LogFactory.getLog(MainApplication.class);


	// *************************METHODES************************************/


	
	 /**
	 * method CONSTRUCTEUR MainApplication() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public MainApplication() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
    
	/**
	 * method main(
	 * String[] pArgs) :<br/>
	 * Point d'entrée de l'application Desktop.<br/>
	 * <ul>
	 * <li>lancée dans le Thread Main.</li>
	 * <li>appelle automatiquement la méthode start(Stage pPrimaryStage) 
	 * de la présente classe.</li>
	 * </ul>
	 * <img src="../../../../../../javadoc/images/methode_main.png" 
	 * alt="méthode main(String[] pArgs)" 
	 * border="1" align="center"/>
	 * <br/>
	 *
	 * @param pArgs : String[] :  .<br/>
	 */
	public static void main(
			final String[] pArgs) {
		
		/* Exécution dans le Thread main. */
//		System.out.println("main(String[] pArgs) method dans le Thread : " +  Thread.currentThread().getName());
		
		/* Appel de la méthode launch(...) qui va appeler 
		 * la méthode start(...) de cette classe. */
		Application.launch(MainApplication.class, pArgs);

	} // Fin de main(...)._________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(
			final Stage pPrimaryStage) throws Exception {
		
		this.primaryStage = pPrimaryStage;
		this.primaryStage.setTitle("Application de gestion d'adresses JavaFX");
				
		/* Prépare la VUE d'accueil. */
		this.fabriquerPanneauFond();
				
	} // Fin de start(...).________________________________________________


	
	/**
	 * method fabriquerPanneauFond() :<br/>
	 * <ul>
	 * FABRIQUE LE PANNEAU DE FOND DE LA SCENE 
	 * <b>this.root</b> (BorderPane).<br/>
	 * DELEGUE A UN AccueilController LA FABRICATION DE L'AnchorPane 
	 * <b>personneAnchorPane</b> ET SON INCORPORATION DANS LE ROOT.<br/> 
	 * FABRIQUE LA SCENE <b>Scene</b> EN LUI PASSANT 
	 * LE PANNEAU DE FOND this.root.<br/>
	 * AFFICHE LE THEATRE <b>this.primaryStage</b>.<br/>
	 * <li>instancie un AccueilVueFxml chargé de dessiner 
	 * la VUE BorderPane this.root. </li>
	 * <li>récupère le panneau de fond <b>this.root</b> auprès 
	 * du AccueilVueFxml.</li>
	 * <li>récupère le CONTROLLER de VUE 
	 * <b>this.accueilVueController</b> auprès du AccueilVueFxml.</li>
	 * <li>le CONTROLLER DE VUE 
	 * this.accueilVueController permet d'accéder aux éléments 
	 * de la VUE BorderPane <b>this.root</b> 
	 * (barre de menus, menus, items, ...).</li>
	 * <li>décore <b>this.root</b> en lui incorporant un AnchorPane 
	 * <b>personneAnchorPane</b>. 
	 * Cette partie est déleguée à un CONTROLLER AccueilController.</li>
	 * <li>instancie la scene et passe le panneau de fond à la scene.</li>
	 * <li>passe la scene au theatre this.primaryStage.</li>
	 * <li>affiche le theatre this.primaryStage.</li>
	 * </ul>
	 * <img src="../../../../../../javadoc/images/methode_start.png" 
	 * alt="méthode start()" 
	 * border="1" align="center"/>
	 * <br/>
	 */
	private void fabriquerPanneauFond() {
		
    	/* *********************************************** */
    	/* FABRIQUE LE PANNEAU DE FOND this.root (BorderPane). */
        /* instancie un AccueilVueFxml chargé de dessiner 
         * la VUE BorderPane this.root. */
    	final AccueilVueFxml accueilVueFxml = new AccueilVueFxml();
    	
    	/* récupère le panneau de fond this.root 
    	 * auprès du AccueilVueFxml. */
    	this.recupererVue(accueilVueFxml);
        
        /* récupère le CONTROLLER de VUE auprès du AccueilVueFxml. */
        this.recupererControllerVue(accueilVueFxml);
 
            
            /* *********************************************** */
        /* DELEGUE A UN AccueilController LA FABRICATION DE 
         * L'AnchorPane <b>personneAnchorPane</b> 
         * ET SON INCORPORATION DANS lE ROOT. */
        /* Instancie le controller d'accueil 
		 * qui affiche la VUE d'accueil. */
   		new AccueilController(this);

   		
   		/* *********************************************** */
   		/* FABRIQUE LA SCENE EN LUI PASSANT LE PANNEAU 
   		 * DE FOND this.root. */
        /* instancie la scene et passe 
         * le panneau de fond à la scene. */
        final Scene scene = new Scene(this.root);
        
        /* passe la scene au theatre this.primaryStage. */
        this.primaryStage.setScene(scene);
        
        
        /* *********************************************** */
        /* AFFICHE LE THEATRE. */
        /* affiche le theatre this.primaryStage. */
        this.primaryStage.show();
        
      } // Fin de fabriquerPanneauFond().__________________________________
	
    
	
	/**
	 * Récupère la VUE créée par chargement d'un FXML 
	 * auprès de la classe XXXVueFxml.<br/>
	 * <ul>
	 * <li>stocke la VUE récupérée auprès de la classe XXXVueFxml 
	 * dans la VUE de la présente classe <b>this.root</b>.</li>
	 * <li>ne fait rien si pAccueilVueFxml == null.</li>
	 * </ul>
	 *
	 * @param pAccueilVueFxml : AccueilVueFxml.<br/>
	 */
	private void recupererVue(
			final AccueilVueFxml pAccueilVueFxml) {
		
		if (pAccueilVueFxml == null) {
			return;
		}
		
		this.root = pAccueilVueFxml.getRoot();
		
	} // Fin de recupererVue(...)._________________________________________
	

	
	/**
	 * Récupère le CONTROLLER de VUE créée par chargement d'un FXML 
	 * auprès de la classe XXXVueFxml.<br/>
	 * <ul>
	 * <li>stocke le CONTROLLER DE VUE récupéré 
	 * auprès de la classe XXXVueFxml 
	 * dans le CONTROLLER de VUE de la présente classe 
	 * <b>this.accueilVueController</b>.</li>
	 * <li>ne fait rien si pAccueilVueFxml == null.</li>
	 * </ul>
	 *
	 * @param pAccueilVueFxml : AccueilVueFxml.<br/>
	 */
	private void recupererControllerVue(
			final AccueilVueFxml pAccueilVueFxml) {
		
		if (pAccueilVueFxml == null) {
			return;
		}
		
		this.accueilVueController 
    		= pAccueilVueFxml.getAccueilVueController();
		
	} // Fin de recupererControllerVue(...)._______________________________

	
	
	/**
	 * method getPrimaryStage() :<br/>
	 * Getter du Theatre.<br/>
	 * <br/>
	 *
	 * @return primaryStage : Stage.<br/>
	 */
	public Stage getPrimaryStage() {	
		return this.primaryStage;
	} // Fin de getPrimaryStage()._________________________________________


	
	/**
	* method setPrimaryStage(
	* Stage pPrimaryStage) :<br/>
	* Setter du Theatre.<br/>
	* <br/>
	*
	* @param pPrimaryStage : Stage : 
	* valeur à passer à primaryStage.<br/>
	*/
	public void setPrimaryStage(
			final Stage pPrimaryStage) {	
		this.primaryStage = pPrimaryStage;
	} // Fin de setPrimaryStage(...).______________________________________


	
	/**
	 * method getRoot() :<br/>
	 * Getter du panneau de fond de la scene.<br/>
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
	* Setter du panneau de fond de la scene.<br/>
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

		
	
} // FIN DE LA CLASSE MainApplication.---------------------------------------
