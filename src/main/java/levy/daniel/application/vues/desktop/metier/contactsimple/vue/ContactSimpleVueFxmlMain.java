package levy.daniel.application.vues.desktop.metier.contactsimple.vue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * CLASSE ContactSimpleVueFxmlMain :<br/>
 * .<br/>
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
 * @since 24 déc. 2018
 *
 */
public class ContactSimpleVueFxmlMain extends Application {

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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleVueFxmlMain.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ContactSimpleVueFxmlMain() {
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
	 * @param pArgs : String[].<br/>
	 */
	public static void main(
			final String... pArgs) {
		
		/* Exécution dans le Thread main. */
//		System.out.println("main(String[] pArgs) method dans le Thread : " +  Thread.currentThread().getName());
		
		/* Appel de la méthode launch(...) qui va appeler 
		 * la méthode start(...) de cette classe. */
		Application.launch(ContactSimpleVueFxmlMain.class, pArgs);

	} // Fin de main(...)._________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(
			final Stage pPrimaryStage) throws Exception {
		
		this.primaryStage = pPrimaryStage;
		this.primaryStage.setTitle("ContactSimpleVueFxmlMain");
				
		/* Prépare la VUE d'accueil. */
		this.fabriquerPanneauFond();
				
	} // Fin de start(...).________________________________________________


	
	/**
	 * method fabriquerPanneauFond() :<br/>
	 * <ul>
	 * <li>FABRIQUE LE PANNEAU DE FOND DE LA SCENE 
	 * <b>this.root</b> (BorderPane).</li>
	 * <li>FABRIQUE LA SCENE <b>Scene</b> EN LUI PASSANT 
	 * LE PANNEAU DE FOND this.root.</li>
	 * <li>AFFICHE LE THEATRE <b>this.primaryStage</b>.</li>
	 * 
	 * <li>récupère le panneau de fond <b>this.root</b> auprès 
	 * du AccueilVueFxml.</li>
	 * <li>récupère le CONTROLLER de VUE 
	 * <b>this.accueilVueController</b> auprès du AccueilVueFxml.</li>
	 * <li>le CONTROLLER DE VUE 
	 * this.accueilVueController permet d'accéder aux éléments 
	 * de la VUE BorderPane <b>this.root</b> 
	 * (barre de menus, menus, items, ...).</li>
	 * <li>décore <b>this.root</b> en lui incorporant un AnchorPane 
	 * <b>contactSimpleAnchorPane</b>. 
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
		
		ContactSimpleVueFxml vue = new ContactSimpleVueFxml(null);
		final Node node = vue.getContactSimpleAnchorPane();
		
    	/* *********************************************** */
    	/* FABRIQUE LE PANNEAU DE FOND this.root (BorderPane). */
        this.root = new BorderPane(node);

   		
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
	 * Getter du Theatre.<br/>
	 *
	 * @return this.primaryStage : Stage.<br/>
	 */
	public Stage getPrimaryStage() {	
		return this.primaryStage;
	} // Fin de getPrimaryStage()._________________________________________


	
	/**
	* Setter du Theatre.<br/>
	*
	* @param pPrimaryStage : Stage : 
	* valeur à passer à this.primaryStage.<br/>
	*/
	public void setPrimaryStage(
			final Stage pPrimaryStage) {	
		this.primaryStage = pPrimaryStage;
	} // Fin de setPrimaryStage(...).______________________________________


	
	/**
	 * Getter du panneau de fond de la scene.<br/>
	 *
	 * @return this.root : BorderPane.<br/>
	 */
	public BorderPane getRoot() {	
		return this.root;
	} // Fin de getRoot()._________________________________________________


	
	/**
	* Setter du panneau de fond de la scene.<br/>
	*
	* @param pRoot : BorderPane : 
	* valeur à passer à this.root.<br/>
	*/
	public void setRoot(
			final BorderPane pRoot) {	
		this.root = pRoot;
	} // Fin de setRoot(...).______________________________________________



}
