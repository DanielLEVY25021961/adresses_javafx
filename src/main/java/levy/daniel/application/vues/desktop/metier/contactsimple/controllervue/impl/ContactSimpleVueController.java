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
 * CONTROLLER de la VUE <b>PersonneVue.fxml</b>.<br/>
 * <ul>
 * <li>Permet d'accéder en JAVA aux objets graphiques de la VUE 
 * générée par le fxml.</li>
 * <li>la VUE générée par <b>PersonneVue.fxml</b> est l'AnchorPane 
 * <b>this.personneAnchorPane</b></li>
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
	 * accueilController : IAccueilController :<br/>
	 * IAccueilController "Maître de Cérémonie" chargé 
	 * de mettre à disposition du présent CONTROLLER 
	 * toutes les vues, controllers et services de l'application.<br/>
	 */
	private IAccueilController accueilController;

	/**
	 * personneAnchorPane : AnchorPane :<br/>
	 * AnchorPane principal de PersonneVue.fxml.<br/>
	 */
	@FXML
	private AnchorPane personneAnchorPane;

	/**
	 * personneSplitPane : SplitPane :<br/>
	 * SplitPane contenu dans this.personneAnchorPane.<br/>
	 */
	@FXML
	private SplitPane personneSplitPane;
	
	/**
	 * personnesTableViewAnchorPane : AnchorPane :<br/>
	 * AnchorPane gauche du SplitPane contenant le TableView.<br/>
	 */
	@FXML
	private AnchorPane personnesTableViewAnchorPane;
	
	
	/**
	 * personnesTableView : TableView&lt;IContactSimpleModelObs&gt; :<br/>
	 * TableView&lt;IContactSimpleModelObs&gt; affichant 
	 * la liste des ContactSimple.<br/>
	 */
	@FXML
	private TableView<IContactSimpleModelObs> personnesTableView;
	
	/**
	 * prenomTableColumn : 
	 * TableColumn&lt;ContactSimpleModelObs,String&gt; :<br/>
	 * colonne des prénoms.<br/>
	 */
	@FXML
	private TableColumn<ContactSimpleModelObs, String> prenomTableColumn;
	
	/**
	 * modelSelection : TableViewSelectionModel&lt;IContactSimpleModelObs&gt; :<br/>
	 * MODEL pour la sélection dans le TableView this.personnesTableView.<br/>
	 */
	private TableViewSelectionModel<IContactSimpleModelObs> modelSelection;
	
	/**
	 * nomTableColumn : 
	 * TableColumn<ContactSimpleModelObs,String> :<br/>
	 * colonne des noms.<br/>
	 */
	@FXML
	private TableColumn<ContactSimpleModelObs, String> nomTableColumn;
		
	/**
	 * renseignementsAnchorPane : AnchorPane :<br/>
	 * AnchorPane de droite contenant les 
	 * renseignements sur une ContactSimple.<br/>
	 */
	@FXML
	private AnchorPane renseignementsAnchorPane;
	
	/**
	 * renseignementsLabel : Label :<br/>
	 * Label "renseignements sur la ContactSimple".<br/>
	 */
	@FXML
	private Label renseignementsLabel;
	
	/**
	 * renseignementsGridPane : GridPane :<br/>
	 * GridPane portant les renseignements sur une ContactSimple.<br/>
	 */
	@FXML
	private GridPane renseignementsGridPane;
	
	/**
	 * prenomLabel : Label :<br/>
	 * Label pour le prénom.<br/>
	 */
	@FXML
	private Label prenomLabel;
	
	/**
	 * nomLabel : Label :<br/>
	 * Label pour le nom.<br/>
	 */
	@FXML
	private Label nomLabel;
	
	/**
	 * rueLabel : Label :<br/>
	 * Label pour la rue.<br/>
	 */
	@FXML
	private Label rueLabel;
	
	/**
	 * villeLabel : Label :<br/>
	 * Label pour la ville.<br/>
	 */
	@FXML
	private Label villeLabel;
	
	/**
	 * codePostalLabel : Label :<br/>
	 * Label pour le code postal.<br/>
	 */
	@FXML
	private Label codePostalLabel;
	
	/**
	 * dateNaissanceLabel : Label :<br/>
	 * Label pour la date de naissance.<br/>
	 */
	@FXML
	private Label dateNaissanceLabel;

	
	/**
	 * prenomTextField : TextField :<br/>
	 * TextField pour le prénom.<br/>
	 */
	@FXML
	private TextField prenomTextField;
	
	/**
	 * nomTextField : TextField :<br/>
	 * TextField pour le nom.<br/>
	 */
	@FXML
	private TextField nomTextField;
	
	/**
	 * rueTextField : TextField :<br/>
	 * TextField pour la rue.<br/>
	 */
	@FXML
	private TextField rueTextField;
	
	/**
	 * villeTextField : TextField :<br/>
	 * TextField pour la ville.<br/>
	 */
	@FXML
	private TextField villeTextField;
	
	/**
	 * codePostalTextField : TextField :<br/>
	 * TextField pour le code postal.<br/>
	 */
	@FXML
	private TextField codePostalTextField;
	
	/**
	 * dateNaissanceTextField : TextField :<br/>
	 * TextField pour la date de naissance.<br/>
	 */
	@FXML
	private TextField dateNaissanceTextField;

	/**
	 * editionButtonBar : ButtonBar :<br/>
	 * Barre de boutons d'édition des ContactSimple.<br/>
	 */
	@FXML
	private ButtonBar editionButtonBar;
	
	/**
	 * createButton : Button :<br/>
	 * Bouton pour la création des ContactSimple.<br/>
	 */
	@FXML
	private Button createButton;

	/**
	 * editButton : Button :<br/>
	 * Bouton pour la modification des ContactSimple.<br/>
	 */
	@FXML
	private Button editButton;
	
	/**
	 * deleteButton : Button :<br/>
	 * Bouton pour la destruction des ContactSimple.<br/>
	 */
	@FXML
	private Button deleteButton;


	/**
	 * creationPersonneVueAnchorPane : AnchorPane :<br/>
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
		
		this.initialiserDonneesTbViewPersonnes();
		
		this.creerListeners();
		
	} // Fin de initialize().______________________________________________



	/**
	 * method initialiserDonneesTbViewPersonnes() :<br/>
	 * <ul>
	 * <li>initialise les TableColumns du TableView en les 
	 * associant avec des attributs du ContactSimpleModelObs.</li>
	 * <li>rend le TableView éditable.</li>
	 * <li>instancie le modelSelection du TableView 
	 * this.modelSelection.</li>
	 * <li>met la sélection dans le TableView en mode simple.</li>
	 * </ul>
	 */
	private void initialiserDonneesTbViewPersonnes() {
		
		/* initialise les TableColumns du TableView en les 
		 * associant avec des attributs du ContactSimpleModelObs. */
		this.prenomTableColumn
			.setCellValueFactory(
					new PropertyValueFactory<ContactSimpleModelObs, String>("prenom"));
		
		this.nomTableColumn
			.setCellValueFactory(
					new PropertyValueFactory<ContactSimpleModelObs, String>("nom"));
		
		/* rend le TableView éditable. */
		this.personnesTableView.setEditable(true);
		
		/* instancie le modelSelection du TableView this.modelSelection. */
		this.modelSelection = this.personnesTableView.getSelectionModel();
		
		/* met la sélection dans le TableView en mode simple. */
		this.modelSelection.setSelectionMode(SelectionMode.SINGLE);
				
	} // Fin de initialiserDonneesTbViewPersonnes()._______________________

	
	
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

						ContactSimpleVueController.this.afficherRenseignementsPersonne(pNewValue);
						
					}
				});
		
	} // Fin de creerListenerSurTableView()._______________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void afficherRenseignementsPersonne(
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
		
	} // Fin de afficherRenseignementsPersonne(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@FXML
	public final void creerPersonne() {
		
		/* instanciation d'une VUE via un FXMLLoader. */
		final CreationContactSimpleVueFxml vue 
			= new CreationContactSimpleVueFxml(this.accueilController);
		
		/* Récupération de la VUE créée. */
		this.creationPersonneVueAnchorPane 
			= vue.getCreationPersonneVueAnchorPane();
		
		/* Récupération du controller créé. */
		this.creationContactSimpleVueController 
			= vue.getCreationPersonneVueController();
		
		/* Alimentation de this.accueilController. */
		this.accueilController
			.setCreationPersonneVueAnchorPane(
					this.creationPersonneVueAnchorPane);
		
		this.accueilController
			.setCreationPersonneVueController(
					this.creationContactSimpleVueController);
		
		/* Création de la Scene. */
		final Scene scene = new Scene(this.creationPersonneVueAnchorPane);
		
		/* Création du theatre de la Boîte de dialogue. */
		final Stage dialogStage = new Stage();
        dialogStage.setTitle("Création de ContactSimple");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(this.accueilController.getMainApplication().getPrimaryStage());
		
        /* Passe la Scene au Theatre. */
        dialogStage.setScene(scene);
        
        /* Affiche le théatre jusqu'à ce que l'utilisateur le ferme. */
        dialogStage.showAndWait();
        
	} // Fin de creerPersonne().___________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@FXML
	public final void modifierPersonne() {
		/**/
	} // Fin de modifierPersonne().________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@FXML
	public final void deletePersonneSelectionnee() {
		
		if (this.modelSelection == null) {
			return;
		}
		
		final int selectedIndex = this.modelSelection.getSelectedIndex();
		
		if (selectedIndex >= 0) {
			this.personnesTableView.getItems().remove(selectedIndex);
		} else {
			
	        final Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(
	        		this.accueilController
	        			.getMainApplication().getPrimaryStage());
	        alert.setTitle("Pas de ContactSimple sélectionnée");
	        alert.setHeaderText("Pas de ContactSimple sélectionnée");
	        alert.setContentText("SVP sélectionnez une personne dans la table.");

	        alert.showAndWait();
	    }
		
	} // Fin de deletePersonneSelectionnee().______________________________
	
	
	
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
	public final SplitPane getPersonneSplitPane() {	
		return this.personneSplitPane;
	} // Fin de getPersonneSplitPane().____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPersonneSplitPane(
			final SplitPane pPersonneSplitPane) {	
		this.personneSplitPane = pPersonneSplitPane;
	} // Fin de setPersonneSplitPane(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final AnchorPane getPersonnesTableViewAnchorPane() {
		return this.personnesTableViewAnchorPane;
	} // Fin de getPersonnesTableViewAnchorPane()._________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPersonnesTableViewAnchorPane(
			final AnchorPane pPersonnesTableViewAnchorPane) {
		this.personnesTableViewAnchorPane = pPersonnesTableViewAnchorPane;
	} // Fin de setPersonnesTableViewAnchorPane(...).______________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TableView<IContactSimpleModelObs> getPersonnesTableView() {
		return this.personnesTableView;
	} // Fin de getPersonnesTableView().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPersonnesTableView(
			final TableView<IContactSimpleModelObs> pPersonnesTableView) {
		this.personnesTableView = pPersonnesTableView;
	} // Fin de setPersonnesTableView(...).________________________________


		
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
	public final ICreationContactSimpleVueController getCreationPersonneVueController() {
		return this.creationContactSimpleVueController;
	} // Fin de getCreationPersonneVueController().________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCreationPersonneVueController(
			final ICreationContactSimpleVueController pCreationContactSimpleVueController) {
		this.creationContactSimpleVueController = pCreationContactSimpleVueController;
	} // Fin de setCreationPersonneVueController(...)._____________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setModelTableViewPersonnes(
			final ObservableList<IContactSimpleModelObs> pListePersonnes) {
		this.personnesTableView.setItems(pListePersonnes);
	} // Fin de setModelTableViewPersonnes(...).___________________________
	
	

} // FIN DE LA CLASSE ContactSimpleVueController.---------------------------------
