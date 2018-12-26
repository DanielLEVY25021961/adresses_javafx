package levy.daniel.application.vues.desktop.metier.contactsimple.controllervue.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import levy.daniel.application.vues.desktop.metier.contactsimple.controllervue.ICreationContactSimpleVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.impl.ContactSimpleModelObs;


/**
 * CLASSE CreationContactSimpleVueController :<br/>
 * CONTROLLER de la VUE <b>CreationContactSimpleVue.fxml</b>.<br/>
 * <ul>
 * <li>Permet d'accéder en JAVA aux objets graphiques de la VUE 
 * générée par le fxml.</li>
 * <li>la VUE générée par <b>CreationContactSimpleVue.fxml</b> est l'AnchorPane 
 * <b>this.creationContactSimpleVueAnchorPane</b></li>
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
 * @since 20 mai 2018
 *
 */
public class CreationContactSimpleVueController implements ICreationContactSimpleVueController {

	// ************************ATTRIBUTS************************************/

	/**
	 * AnchorPane de la vue de création d'une ContactSimple.<br/>
	 */
	@FXML
	private AnchorPane creationContactSimpleVueAnchorPane;
	
	/**
	 * GridPane de la vue de création d'une ContactSimple.<br/>
	 */
	@FXML
	private GridPane contactSimpleGridPane;
	
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
	 * Label pour le code postal.<br/>
	 */
	@FXML
	private Label codePostalLabel;
	
	/**
	 * Label pour la ville.<br/>
	 */
	@FXML
	private Label villeLabel;
	
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
	 * TextField pour le code postal.<br/>
	 */
	@FXML
	private TextField codePostalTextField;
	
	/**
	 * TextField pour la ville.<br/>
	 */
	@FXML
	private TextField villeTextField;
	
	/**
	 * TextField pour la date de naissance.<br/>
	 */
	@FXML
	private TextField dateNaissanceTextField;

	/**
	 * barre de boutons.<br/>
	 */
	@FXML
	private ButtonBar creationContactSimpleVueButtonBar;
	
	/**
	 * bouton "enregistrer une ContactSimple".<br/>
	 */
	@FXML
	private Button enregistrerButton;
	
	/**
	 * bouton "annuler la saisie".<br/>
	 */
	@FXML
	private Button annulerButton;
	
	/**
	 * theatre pour afficher la boîte de dialogue 
	 * de création d'une ContactSimple.<br/>
	 */
	private Stage dialogStage;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(CreationContactSimpleVueController.class);

	// *************************METHODES************************************/
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public CreationContactSimpleVueController() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



    /**
     * <ul>
	 * <li>Initialise le présent CONTROLLER DE VUE.</li>
	 * <li>Méthode automatiquement appelée après que 
	 * le FXML ait été chargé.</li>
	 * </ul>
     */
    @FXML
    private void initialize() {
    	/**/
    } // Fin de initialize().______________________________________________
    

    
    /**
	 * {@inheritDoc}
	 */
    @Override
	@FXML
    public final void enregistrer() {
    	/**/
    } // Fin de enregistrer().___________________________________________________
    

    
    /**
	 * {@inheritDoc}
	 */
    @Override
	@FXML
    public final void annuler() {
    	/**/
    } // Fin de annuler()._________________________________________________
    

    
    /**
   	 * {@inheritDoc}
   	 */
    @Override
    public final IContactSimpleModelObs lire() {
    	
    	/* retourne null si la VUE est vide. */
    	if (affichageNull()) {
    		return null;
    	}
    	
    	final DateTimeFormatter formatter 
		= DateTimeFormatter.ofPattern("dd MMMM yyyy");
    	
    	LocalDate dateNaissance = null;
    	
    	final String prenomString = this.prenomTextField.getText();
    	final String nomString = this.nomTextField.getText();
    	final String rueString = this.rueTextField.getText();
    	final String codePostalString = this.codePostalTextField.getText();
    	final String villeString = this.villeTextField.getText();
    	final String dateNaissanceString 
    		= this.dateNaissanceTextField.getText();
    	
    	
    	try {
    		
			if (dateNaissanceString != null) {
				dateNaissance 
				= formatter.parse(dateNaissanceString, LocalDate::from);
			}
			
			final IContactSimpleModelObs contactSimple 
				= new ContactSimpleModelObs(
						prenomString
						, nomString
						, rueString
						, codePostalString
						, villeString
						, dateNaissance);
			
			return contactSimple;
			
		} catch (Exception e) {
			
			if (LOG.isDebugEnabled()) {
				LOG.debug("Date incorrecte", e);
			}
			return null;
		}
    	
    } // Fin de lire().____________________________________________________
    
    
    
    /**
	 * {@inheritDoc}
	 */
    @Override
	public final void afficher(
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

    } // Fin de afficher(...)._____________________________________________
    
   
    
    /**
     * Détermine si la VUE est vide.<br/>
     * <ul>
     * <li>retourne true si la VUE est vide.</li>
     * </ul>
     *
     * @return : boolean : true si la VUE est vide.<br/>
     */
    private boolean affichageNull() {
    	
    	final String prenomString = this.prenomTextField.getText();
    	final String nomString = this.nomTextField.getText();
    	final String rueString = this.rueTextField.getText();
    	final String codePostalString = this.codePostalTextField.getText();
    	final String villeString = this.villeTextField.getText();
    	final String dateNaissanceString 
    		= this.dateNaissanceTextField.getText();
    	
    	if (prenomString == null 
    			&& nomString == null 
    				&& rueString == null 
    					&& codePostalString == null 
    						&& villeString == null 
    						 && dateNaissanceString == null) {
    		return true;
    	}
    	
    	return false;
    	
    } // Fin de affichageNull().___________________________________________
 
    
    
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
	public final GridPane getContactSimpleGridPane() {
		return this.contactSimpleGridPane;
	} // Fin de getContactSimpleGridPane().________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setContactSimpleGridPane(
			final GridPane pContactSimpleGridPane) {
		this.contactSimpleGridPane = pContactSimpleGridPane;
	} // Fin de setContactSimpleGridPane(...)._____________________________


		
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
	public final ButtonBar getCreationContactSimpleVueButtonBar() {
		return this.creationContactSimpleVueButtonBar;
	} // Fin de getCreationContactSimpleVueButtonBar().____________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCreationContactSimpleVueButtonBar(
			final ButtonBar pCreationContactSimpleVueButtonBar) {
		this.creationContactSimpleVueButtonBar = pCreationContactSimpleVueButtonBar;
	} // Fin de setcreationContactSimpleVueButtonBar(...)._________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Button getEnregistrerButton() {
		return this.enregistrerButton;
	} // Fin de getEnregistrerButton().____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setEnregistrerButton(
			final Button pEnregistrerButton) {
		this.enregistrerButton = pEnregistrerButton;
	} // Fin de setEnregistrerButton(...).__________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Button getAnnulerButton() {
		return this.annulerButton;
	} // Fin de getAnnulerButton().________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setAnnulerButton(
			final Button pAnnulerButton) {
		this.annulerButton = pAnnulerButton;
	} // Fin de setAnnulerButton(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Stage getDialogStage() {
		return this.dialogStage;
	} // Fin de getDialogStage().__________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setDialogStage(
			final Stage pDialogStage) {
		this.dialogStage = pDialogStage;
	} // Fin de setDialogStage(...)._______________________________________


	
	
} // FIN DE LA CLASSE CreationContactSimpleVueController.-------------------------
