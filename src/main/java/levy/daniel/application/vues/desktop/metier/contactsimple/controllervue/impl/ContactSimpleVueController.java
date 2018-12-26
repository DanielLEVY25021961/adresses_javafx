package levy.daniel.application.vues.desktop.metier.contactsimple.controllervue.impl;

import java.time.format.DateTimeFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;
import levy.daniel.application.vues.desktop.metier.contactsimple.controllervue.IContactSimpleVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.controllervue.ICreationContactSimpleVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.impl.ContactSimpleModelObs;
import levy.daniel.application.vues.desktop.metier.contactsimple.vue.CreationContactSimpleVueFxml;


/**
 * CLASSE ContactSimpleVueController :<br/>
 * CONTROLLER de la VUE <b>ContactSimpleVue.fxml</b>.<br/>
 * <ul>
 * <li>Permet d'accéder en JAVA aux objets graphiques de la VUE 
 * générée par le fxml.</li>
 * <li>la VUE générée par <b>ContactSimpleVue.fxml</b> est l'AnchorPane 
 * <b>this.contactSimpleAnchorPane</b></li>
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
public class ContactSimpleVueController implements IContactSimpleVueController {

	// ************************ATTRIBUTS************************************/


	/**
	 * IAccueilController "Maître de Cérémonie" chargé 
	 * de mettre à disposition du présent CONTROLLER 
	 * toutes les vues, controllers et services de l'application.<br/>
	 */
	private IAccueilController accueilController;

	/**
	 * AnchorPane principal de la VUE ContactSimpleVue.fxml.<br/>
	 */
	@FXML
	private AnchorPane contactSimpleAnchorPane;

	/**
	 * SplitPane contenu dans this.contactSimpleAnchorPane.<br/>
	 */
	@FXML
	private SplitPane contactSimpleSplitPane;
	
	/**
	 * AnchorPane gauche du SplitPane contenant le TableView.<br/>
	 */
	@FXML
	private AnchorPane contactSimplesTableViewAnchorPane;
		
	/**
	 * TableView&lt;IContactSimpleModelObs&gt; affichant 
	 * la liste des ContactSimple.<br/>
	 */
	@FXML
	private TableView<IContactSimpleModelObs> contactSimplesTableView;
	
	/**
	 * MODEL pour la sélection dans le TableView this.contactSimplesTableView.<br/>
	 */
	private TableViewSelectionModel<IContactSimpleModelObs> modelSelection;
	
	/**
	 * colonne des prénoms.<br/>
	 */
	@FXML
	private TableColumn<ContactSimpleModelObs, String> prenomTableColumn;
	
	/**
	 * colonne des noms.<br/>
	 */
	@FXML
	private TableColumn<ContactSimpleModelObs, String> nomTableColumn;
	
	/**
	 * colonne des dates de naissance.<br/>
	 */
	@FXML
	private TableColumn<ContactSimpleModelObs, String> dateNaissanceTableColumn;
	
	/**
	 * AnchorPane de droite contenant les 
	 * renseignements sur un ContactSimple.<br/>
	 */
	@FXML
	private AnchorPane renseignementsAnchorPane;
	
	/**
	 * Label "renseignements sur la Contact Simple".<br/>
	 */
	@FXML
	private Label renseignementsLabel;
	
	/**
	 * GridPane portant les renseignements sur une ContactSimple.<br/>
	 */
	@FXML
	private GridPane renseignementsGridPane;
	
	/**
	 * Label pour le prénom.<br/>
	 */
	@FXML
	private Label prenomLabel;
	
	/**
	 * Label pour le nom.<br/>
	 */
	@FXML
	private Label nomLabel;
	
	/**
	 * Label pour la rue.<br/>
	 */
	@FXML
	private Label rueLabel;
	
	/**
	 * Label pour la ville.<br/>
	 */
	@FXML
	private Label villeLabel;
	
	/**
	 * Label pour le code postal.<br/>
	 */
	@FXML
	private Label codePostalLabel;
	
	/**
	 * Label pour la date de naissance.<br/>
	 */
	@FXML
	private Label dateNaissanceLabel;

	
	/**
	 * TextField pour le prénom.<br/>
	 */
	@FXML
	private TextField prenomTextField;
	
	/**
	 * TextField pour le nom.<br/>
	 */
	@FXML
	private TextField nomTextField;
	
	/**
	 * TextField pour la rue.<br/>
	 */
	@FXML
	private TextField rueTextField;
	
	/**
	 * TextField pour la ville.<br/>
	 */
	@FXML
	private TextField villeTextField;
	
	/**
	 * TextField pour le code postal.<br/>
	 */
	@FXML
	private TextField codePostalTextField;
	
	/**
	 * TextField pour la date de naissance.<br/>
	 */
	@FXML
	private TextField dateNaissanceTextField;

	/**
	 * Barre de boutons d'édition des ContactSimple.<br/>
	 */
	@FXML
	private ButtonBar editionButtonBar;
	
	/**
	 * Bouton pour la création des ContactSimple.<br/>
	 */
	@FXML
	private Button createButton;

	/**
	 * Bouton pour la modification des ContactSimple.<br/>
	 */
	@FXML
	private Button editButton;
	
	/**
	 * Bouton pour la destruction des ContactSimple.<br/>
	 */
	@FXML
	private Button deleteButton;


	/**
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
		= LogFactory.getLog(ContactSimpleVueController.class);

	// *************************METHODES************************************/
	
	/**
	 * method CONSTRUCTEUR ContactSimpleVueController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * Automatiquement appelé en premier 
	 * lors du chargement du FXMLLoader.<br/>
	 * <br/>
	 */
	public ContactSimpleVueController() {		
		super();		
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method initialize() :<br/>
	 * <ul>
	 * <li>Initialise le présent CONTROLLER DE VUE.</li>
	 * <li>Méthode automatiquement appelée après que 
	 * le FXML ait été chargé (juste après le constructeur).</li>
	 * </ul>
	 */
	@FXML
    private void initialize() {
		
		this.initialiserDonneesTbViewContactSimples();
		
		this.creerListeners();
		
	} // Fin de initialize().______________________________________________



	/**
	 * <ul>
	 * <li><b>initialise les TableColumns du TableView en les 
	 * associant avec des <i>attributs de la Classe</i> 
	 * du MODEL OBSERVABLE ContactSimpleModelObs</b>.<br/>
	 * Par exemple, décide que le TableView va afficher les attributs 
	 * [prenom, nom et dateDeNaissance] de chaque enregistrement du MODEL.</li>
	 * <li>rend le TableView éditable.</li>
	 * <li>instancie le modelSelection du TableView 
	 * this.modelSelection.</li>
	 * <li>met la sélection dans le TableView en mode simple.</li>
	 * </ul>
	 */
	private void initialiserDonneesTbViewContactSimples() {
		
		/* initialise les TableColumns du TableView en les 
		 * associant avec des attributs du ContactSimpleModelObs. */
		this.prenomTableColumn
			.setCellValueFactory(
					new PropertyValueFactory<ContactSimpleModelObs, String>("prenom"));
		
		this.nomTableColumn
			.setCellValueFactory(
					new PropertyValueFactory<ContactSimpleModelObs, String>("nom"));
		
		/* "dateNaissance" est le nom de l'attribut 
		 * dans le MODEL OBSERVABLE. */
		final DateTimeFormatter formatter 
			= DateTimeFormatter.ofPattern("dd MMMM yyyy");
		
		this.dateNaissanceTableColumn.setCellValueFactory(
				new PropertyValueFactory<ContactSimpleModelObs, String>("dateNaissance"));
		
		/* rend le TableView éditable. */
		this.contactSimplesTableView.setEditable(true);
		
		/* instancie le modelSelection du TableView this.modelSelection. */
		this.modelSelection = this.contactSimplesTableView.getSelectionModel();
		
		/* met la sélection dans le TableView en mode simple. */
		this.modelSelection.setSelectionMode(SelectionMode.SINGLE);
				
	} // Fin de initialiserDonneesTbViewContactSimples().__________________

	
	
	/**
	 * method creerListeners() :<br/>
	 * Gère l'évènementiel en créant les Listeners.<br/>
	 * <br/>
	 */
	private void creerListeners() {
		
		this.creerListenerSurTableView();
		
	} // Fin de creerListeners().__________________________________________
	
	
	
	/**
	 * method creerListenerSurTableView() :<br/>
	 * Crée le Listener sur la sélection dans le TableView.<br/>
	 * <br/>
	 */
	private void creerListenerSurTableView() {
				
		this.modelSelection.selectedItemProperty().addListener(
				new ChangeListener<IContactSimpleModelObs>() {

					/**
					 * {@inheritDoc}
					 */
					@Override
					public void changed(final ObservableValue<? extends IContactSimpleModelObs> pObservable,
							final IContactSimpleModelObs pOldValue, final IContactSimpleModelObs pNewValue) {

						ContactSimpleVueController.this.afficherRenseignementsContactSimple(pNewValue);
						
					}
				});
		
	} // Fin de creerListenerSurTableView()._______________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void afficherRenseignementsContactSimple(
			final IContactSimpleModelObs pContactSimpleModelObs) {
		
		if (pContactSimpleModelObs != null) {
			
			final DateTimeFormatter formatter 
			= DateTimeFormatter.ofPattern("dd MMMM yyyy");
			
			this.prenomTextField.setText(
					pContactSimpleModelObs.getPrenom());
			this.nomTextField.setText(
					pContactSimpleModelObs.getNom());
			this.rueTextField.setText(
					pContactSimpleModelObs.getRue());
			this.villeTextField.setText(
					pContactSimpleModelObs.getVille());
			this.codePostalTextField.setText(
					pContactSimpleModelObs.getCodePostal());
			this.dateNaissanceTextField.setText(
					formatter.format(
							pContactSimpleModelObs.getDateNaissance()));
			
		} else {
			
			this.prenomTextField.setText(null);
			this.nomTextField.setText(null);
			this.rueTextField.setText(null);
			this.villeTextField.setText(null);
			this.codePostalTextField.setText(null);
			this.dateNaissanceTextField.setText(null);
			
		}
		
	} // Fin de afficherRenseignementsContactSimple(...).__________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@FXML
	public final void creerContactSimple() {
		
		/* instanciation d'une VUE via un FXMLLoader. */
		final CreationContactSimpleVueFxml vue 
			= new CreationContactSimpleVueFxml(this.accueilController);
		
		/* Récupération de la VUE créée. */
		this.creationContactSimpleVueAnchorPane 
			= vue.getCreationContactSimpleVueAnchorPane();
		
		/* Récupération du controller créé. */
		this.creationContactSimpleVueController 
			= vue.getCreationContactSimpleVueController();
		
		/* Alimentation de this.accueilController. */
		this.accueilController
			.setCreationContactSimpleVueAnchorPane(
					this.creationContactSimpleVueAnchorPane);
		
		this.accueilController
			.setCreationContactSimpleVueController(
					this.creationContactSimpleVueController);
		
		/* Création de la Scene. */
		final Scene scene = new Scene(this.creationContactSimpleVueAnchorPane);
		
		/* Création du theatre de la Boîte de dialogue. */
		final Stage dialogStage = new Stage();
        dialogStage.setTitle("Création d'un Contact Simple");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(this.accueilController.getMainApplication().getPrimaryStage());
		
        /* Passe la Scene au Theatre. */
        dialogStage.setScene(scene);
        
        /* Affiche le théatre jusqu'à ce que l'utilisateur le ferme. */
        dialogStage.showAndWait();
        
	} // Fin de creerContactSimple().______________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@FXML
	public final void modifierContactSimple() {
		/**/
	} // Fin de modifierContactSimple().___________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@FXML
	public final void deleteContactSimple() {
		
		if (this.modelSelection == null) {
			return;
		}
		
		final int selectedIndex = this.modelSelection.getSelectedIndex();
		
		if (selectedIndex >= 0) {
			this.contactSimplesTableView.getItems().remove(selectedIndex);
		} else {
			
	        final Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(
	        		this.accueilController
	        			.getMainApplication().getPrimaryStage());
	        alert.setTitle("Pas de Contact Simple sélectionné");
	        alert.setHeaderText("Pas de Contact Simple sélectionné");
	        alert.setContentText("SVP sélectionnez un contact simple dans la table.");

	        alert.showAndWait();
	    }
		
	} // Fin de deleteContactSimple()._____________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IAccueilController getAccueilController() {	
		return this.accueilController;
	} // Fin de getAccueilController().____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setAccueilController(
			final IAccueilController pAccueilController) {	
		this.accueilController = pAccueilController;
	} // Fin de setAccueilController(...)._________________________________


	
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
	public final SplitPane getContactSimpleSplitPane() {	
		return this.contactSimpleSplitPane;
	} // Fin de getContactSimpleSplitPane()._______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setContactSimpleSplitPane(
			final SplitPane pContactSimpleSplitPane) {
		this.contactSimpleSplitPane = pContactSimpleSplitPane;
	} // Fin de setContactSimpleSplitPane(...).____________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final AnchorPane getContactSimplesTableViewAnchorPane() {
		return this.contactSimplesTableViewAnchorPane;
	} // Fin de getContactSimplesTableViewAnchorPane().____________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setContactSimplesTableViewAnchorPane(
			final AnchorPane pContactSimplesTableViewAnchorPane) {
		this.contactSimplesTableViewAnchorPane = pContactSimplesTableViewAnchorPane;
	} // Fin de setContactSimplesTableViewAnchorPane(...)._________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TableView<IContactSimpleModelObs> getContactSimplesTableView() {
		return this.contactSimplesTableView;
	} // Fin de getContactSimplesTableView().______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setContactSimplesTableView(
			final TableView<IContactSimpleModelObs> pContactSimplesTableView) {
		this.contactSimplesTableView = pContactSimplesTableView;
	} // Fin de setContactSimplesTableView(...).___________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TableViewSelectionModel<IContactSimpleModelObs> getModelSelection() {
		return this.modelSelection;
	} // Fin de getModelSelection()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setModelSelection(
			final TableViewSelectionModel<IContactSimpleModelObs> pModelSelection) {
		this.modelSelection = pModelSelection;
	} // Fin de setModelSelection(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TableColumn<ContactSimpleModelObs, String> getPrenomTableColumn() {
		return this.prenomTableColumn;
	} // Fin de getPrenomTableColumn().____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPrenomTableColumn(
			final TableColumn<ContactSimpleModelObs, String> pPrenomTableColumn) {
		this.prenomTableColumn = pPrenomTableColumn;
	} // Fin de setPrenomTableColumn(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TableColumn<ContactSimpleModelObs, String> getNomTableColumn() {
		return this.nomTableColumn;
	} // Fin de getNomTableColumn()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setNomTableColumn(
			final TableColumn<ContactSimpleModelObs, String> pNomTableColumn) {
		this.nomTableColumn = pNomTableColumn;
	} // Fin de setNomTableColumn(...).____________________________________
	

			
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TableColumn<ContactSimpleModelObs, String> getDateNaissanceTableColumn() {
		return this.dateNaissanceTableColumn;
	} // Fin de getDateNaissanceTableColumn()._____________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setDateNaissanceTableColumn(
			final TableColumn<ContactSimpleModelObs, String> pDateNaissanceTableColumn) {
		this.dateNaissanceTableColumn = pDateNaissanceTableColumn;
	} // Fin de setDateNaissanceTableColumn(...).__________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final AnchorPane getRenseignementsAnchorPane() {
		return this.renseignementsAnchorPane;
	} // Fin de getRenseignementsAnchorPane()._____________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRenseignementsAnchorPane(
			final AnchorPane pRenseignementsAnchorPane) {
		this.renseignementsAnchorPane = pRenseignementsAnchorPane;
	} // Fin de setRenseignementsAnchorPane(...).__________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Label getRenseignementsLabel() {
		return this.renseignementsLabel;
	} // Fin de getRenseignementsLabel().__________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRenseignementsLabel(
			final Label pRenseignementsLabel) {
		this.renseignementsLabel = pRenseignementsLabel;
	} // Fin de setRenseignementsLabel(...)._______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final GridPane getRenseignementsGridPane() {
		return this.renseignementsGridPane;
	} // Fin de getRenseignementsGridPane()._______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRenseignementsGridPane(
			final GridPane pRenseignementsGridPane) {
		this.renseignementsGridPane = pRenseignementsGridPane;
	} // Fin de setRenseignementsGridPane(...).____________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Label getPrenomLabel() {
		return this.prenomLabel;
	} // Fin de getPrenomLabel().__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPrenomLabel(
			final Label pPrenomLabel) {
		this.prenomLabel = pPrenomLabel;
	} // Fin de setPrenomLabel(...)._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Label getNomLabel() {
		return this.nomLabel;
	} // Fin de getNomLabel()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setNomLabel(
			final Label pNomLabel) {
		this.nomLabel = pNomLabel;
	} // Fin de setNomLabel(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Label getRueLabel() {
		return this.rueLabel;
	} // Fin de getRueLabel()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRueLabel(
			final Label pRueLabel) {
		this.rueLabel = pRueLabel;
	} // Fin de setRueLabel(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Label getVilleLabel() {
		return this.villeLabel;
	} // Fin de getVilleLabel().___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setVilleLabel(
			final Label pVilleLabel) {
		this.villeLabel = pVilleLabel;
	} // Fin de setVilleLabel(...).________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Label getCodePostalLabel() {
		return this.codePostalLabel;
	} // Fin de getCodePostalLabel().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCodePostalLabel(
			final Label pCodePostalLabel) {
		this.codePostalLabel = pCodePostalLabel;
	} // Fin de setCodePostalLabel(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Label getDateNaissanceLabel() {
		return this.dateNaissanceLabel;
	} // Fin de getDateNaissanceLabel().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setDateNaissanceLabel(
			final Label pDateNaissanceLabel) {
		this.dateNaissanceLabel = pDateNaissanceLabel;
	} // Fin de setDateNaissanceLabel(...).________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TextField getPrenomTextField() {
		return this.prenomTextField;
	} // Fin de getPrenomTextField().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPrenomTextField(
			final TextField pPrenomTextField) {
		this.prenomTextField = pPrenomTextField;
	} // Fin de setPrenomTextField(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TextField getNomTextField() {
		return this.nomTextField;
	} // Fin de getNomTextField()._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setNomTextField(
			final TextField pNomTextField) {
		this.nomTextField = pNomTextField;
	} // Fin de setNomTextField(...).______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TextField getRueTextField() {
		return this.rueTextField;
	} // Fin de getRueTextField()._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRueTextField(
			final TextField pRueTextField) {
		this.rueTextField = pRueTextField;
	} // Fin de setRueTextField(...).______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TextField getVilleTextField() {
		return this.villeTextField;
	} // Fin de getVilleTextField()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setVilleTextField(
			final TextField pVilleTextField) {
		this.villeTextField = pVilleTextField;
	} // Fin de setVilleTextField(...).____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TextField getCodePostalTextField() {
		return this.codePostalTextField;
	} // Fin de getCodePostalTextField().__________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCodePostalTextField(
			final TextField pCodePostalTextField) {
		this.codePostalTextField = pCodePostalTextField;
	} // Fin de setCodePostalTextField(...)._______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TextField getDateNaissanceTextField() {
		return this.dateNaissanceTextField;
	} // Fin de getDateNaissanceTextField()._______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setDateNaissanceTextField(
			final TextField pDateNaissanceTextField) {
		this.dateNaissanceTextField = pDateNaissanceTextField;
	} // Fin de setDateNaissanceTextField(...).____________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ButtonBar getEditionButtonBar() {
		return this.editionButtonBar;
	} // Fin de getEditionButtonBar()._____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setEditionButtonBar(
			final ButtonBar pEditionButtonBar) {
		this.editionButtonBar = pEditionButtonBar;
	} // Fin de setEditionButtonBar(...).__________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Button getCreateButton() {
		return this.createButton;
	} // Fin de getCreateButton()._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCreateButton(
			final Button pCreateButton) {
		this.createButton = pCreateButton;
	} // Fin de setCreateButton(...).______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Button getEditButton() {
		return this.editButton;
	} // Fin de getEditButton().___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setEditButton(
			final Button pEditButton) {
		this.editButton = pEditButton;
	} // Fin de setEditButton(...).________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Button getDeleteButton() {
		return this.deleteButton;
	} // Fin de getDeleteButton()._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setDeleteButton(
			final Button pDeleteButton) {
		this.deleteButton = pDeleteButton;
	} // Fin de setDeleteButton(...).______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final AnchorPane getCreationContactSimpleVueAnchorPane() {
		return this.creationContactSimpleVueAnchorPane;
	} // Fin de getCreationContactSimpleVueAnchorPane().___________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCreationContactSimpleVueAnchorPane(
			final AnchorPane pCreationContactSimpleVueAnchorPane) {
		this.creationContactSimpleVueAnchorPane = pCreationContactSimpleVueAnchorPane;
	} // Fin de setCreationContactSimpleVueAnchorPane(...).________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ICreationContactSimpleVueController getCreationContactSimpleVueController() {
		return this.creationContactSimpleVueController;
	} // Fin de getCreationContactSimpleVueController().___________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCreationContactSimpleVueController(
			final ICreationContactSimpleVueController pCreationContactSimpleVueController) {
		this.creationContactSimpleVueController = pCreationContactSimpleVueController;
	} // Fin de setCreationContactSimpleVueController(...).________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setModelTableViewContactSimples(
			final ObservableList<IContactSimpleModelObs> pListeContactSimples) {
		this.contactSimplesTableView.setItems(pListeContactSimples);
	} // Fin de setModelTableViewContactSimples(...).______________________
	
	

} // FIN DE LA CLASSE ContactSimpleVueController.----------------------------
