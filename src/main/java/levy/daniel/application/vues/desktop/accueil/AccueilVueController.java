package levy.daniel.application.vues.desktop.accueil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


/**
 * CLASSE AccueilVueController :<br/>
 * CONTROLLER de la VUE <b>AccueilVue.fxml</b>.<br/>
 * <ul>
 * <li>Permet d'accéder en JAVA aux objets graphiques de la vue 
 * générée par le fxml.</li>
 * <li>L'annotation FXML permet de lier les objets graphiques crées 
 * dans le fxml aux attributs du présent CONTROLLER DE VUE.</li>
 * <li>Ce CONTROLLER DE VUE est <b>AUTOMATIQUEMENT ALIMENTE</b> 
 * LORS DU CHARGEMENT du FXML et sa méthode initialize() 
 * est AUTOMATIQUEMENT EXECUTEE.</li>
 * <li>Ce controlleur de vue est automatiquement instancié 
 * lors du chargement du FXML via son <b>constructeur d'arité nulle</b>. 
 * En conséquence, seuls ses objets graphiques annotés FXML 
 * sont alimentés par le FXML. Des éléments comme un MODEL 
 * pour alimenter par exemple une table doivent donc être 
 * passés par CallBack après l'instanciation du présent 
 * CONTROLLER DE VUE.</li>
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
 * @since 10 mai 2018
 *
 */
public class AccueilVueController implements IAccueilVueController {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * panneau de fond de la scene.<br/>
	 */
	@FXML
	private BorderPane root;
	
	/**
	 * barre de menus de this.root.<br/>
	 */
	@FXML
	private MenuBar rootMenuBar;
	
	/**
	 * menu File.<br/>
	 */
	@FXML
	private Menu menuFile;
	
	/**
	 * MenuItem Close du Menu File.<br/>
	 */
	@FXML
	private MenuItem menuItemClose;
	
	/**
	 * menu Edit.<br/>
	 */
	@FXML
	private Menu menuEdit;

	/**
	 * MenuItem Delete du Menu Edit.<br/>
	 */
	@FXML
	private MenuItem menuItemDelete;
	
	/**
	 * menu Help.<br/>
	 */
	@FXML
	private Menu menuHelp;
	
	/**
	 * MenuItem About du Menu Help.<br/>
	 */
	@FXML
	private MenuItem menuItemAbout;

	/**
	 * panneau du bas pour la recherche.
	 */
	@FXML
	private GridPane rootGridPaneRecherche;
	
	/**
	 * label pour la zone de recherche.
	 */
	@FXML
	private Label labelRootRecherche;
	
	/**
	 * zone de recherche.
	 */
	@FXML
	private TextField textFieldRootRecherche;
	
	/**
	 * bouton d'effacement de la zone de recherche.
	 */
	@FXML
	private Button buttonRootClearRecherche;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AccueilVueController.class);

	// *************************METHODES************************************/
	
		
	 /**
	 * method CONSTRUCTEUR AccueilVueController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * Automatiquement appelé en premier 
	 * lors du chargement du FXMLLoader.<br/>
	 * <br/>
	 */
	public AccueilVueController() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method initialize() :<br/>
	 * <ul>
	 * <li>Initialise le présent CONTROLLER DE VUE.</li>
	 * <li>Méthode automatiquement appelée après que 
	 * le FXML ait été chargé.</li>
	 * <li>prépare les menus.</li>
	 * <li>prépare les listeners.</li>
	 * </ul>
	 */
	@FXML
    private void initialize() {
		
		/* Préparer les menus ici. */
		
		/* prépare les listeners. */
		this.ajouterPropertyChangeListenerATextFieldRootRecherche();
		
	} // Fin de initialize().______________________________________________
	

	
	/**
	 * .<br/>
	 */
	private void ajouterPropertyChangeListenerATextFieldRootRecherche() {
		
		/* ajoute un ChangeListener à la textProperty de this.textField. */
		this.getTextFieldRootRecherche().textProperty().addListener(
				new ChangeListener<String>() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void changed(
					final ObservableValue<? extends String> pObservable
						, final String pOldValue
							, final String pNewValue) {
				
				System.out.println(AccueilVueController
						.this.getTextFieldRootRecherche().getText());
				
			} // Fin de changed(...)._____________________________
			
		}); // Fin de new ChangeListener<String>()._________________
			
	}
	

	
	/**
	 * .<br/>
	 */
	@FXML
    public void effacerRecherche() {
		this.getTextFieldRootRecherche().setText("");
	}
	
	
	
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
	public final MenuBar getRootMenuBar() {	
		return this.rootMenuBar;
	} // Fin de getRootMenuBar().__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRootMenuBar(
			final MenuBar pRootMenuBar) {	
		this.rootMenuBar = pRootMenuBar;
	} // Fin de setRootMenuBar(...)._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Menu getMenuFile() {	
		return this.menuFile;
	} // Fin de getMenuFile()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMenuFile(
			final Menu pMenuFile) {	
		this.menuFile = pMenuFile;
	} // Fin de setMenuFile(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final MenuItem getMenuItemClose() {	
		return this.menuItemClose;
	} // Fin de getMenuItemClose().________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMenuItemClose(
			final MenuItem pMenuItemClose) {	
		this.menuItemClose = pMenuItemClose;
	} // Fin de setMenuItemClose(...)._____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Menu getMenuEdit() {	
		return this.menuEdit;
	} // Fin de getMenuEdit()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMenuEdit(
			final Menu pMenuEdit) {	
		this.menuEdit = pMenuEdit;
	} // Fin de setMenuEdit(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final MenuItem getMenuItemDelete() {	
		return this.menuItemDelete;
	} // Fin de getMenuItemDelete()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMenuItemDelete(
			final MenuItem pMenuItemDelete) {	
		this.menuItemDelete = pMenuItemDelete;
	} // Fin de setMenuItemDelete(...).____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Menu getMenuHelp() {	
		return this.menuHelp;
	} // Fin de getMenuHelp()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMenuHelp(
			final Menu pMenuHelp) {	
		this.menuHelp = pMenuHelp;
	} // Fin de setMenuHelp(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final MenuItem getMenuItemAbout() {	
		return this.menuItemAbout;
	} // Fin de getMenuItemAbout().________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMenuItemAbout(
			final MenuItem pMenuItemAbout) {	
		this.menuItemAbout = pMenuItemAbout;
	} // Fin de setMenuItemAbout(...)._____________________________________


				
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final GridPane getRootGridPaneRecherche() {
		return this.rootGridPaneRecherche;
	} // Fin de getRootGridPaneRecherche().________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRootGridPaneRecherche(
			final GridPane pRootGridPaneRecherche) {
		this.rootGridPaneRecherche = pRootGridPaneRecherche;
	} // Fin de setRootGridPaneRecherche(...)._____________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Label getLabelRootRecherche() {
		return this.labelRootRecherche;
	} // Fin de getLabelRootRecherche().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setLabelRootRecherche(
			final Label pLabelRootRecherche) {
		this.labelRootRecherche = pLabelRootRecherche;
	} // Fin de setLabelRootRecherche(...).________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TextField getTextFieldRootRecherche() {
		return this.textFieldRootRecherche;
	} // Fin de getTextFieldRootRecherche()._______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setTextFieldRootRecherche(
			final TextField pTextFieldRootRecherche) {
		this.textFieldRootRecherche = pTextFieldRootRecherche;
	} // Fin de setTextFieldRootRecherche(...).____________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Button getButtonRootClearRecherche() {
		return this.buttonRootClearRecherche;
	} // Fin de getButtonRootClearRecherche()._____________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setButtonRootClearRecherche(
			final Button pButtonRootClearRecherche) {
		this.buttonRootClearRecherche = pButtonRootClearRecherche;
	} // Fin de setButtonRootClearRecherche(...).__________________________
		
	

} // FIN DE LA CLASSE AccueilVueController.----------------------------------
