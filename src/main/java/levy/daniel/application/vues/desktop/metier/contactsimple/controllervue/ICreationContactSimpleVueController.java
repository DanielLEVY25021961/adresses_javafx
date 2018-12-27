/**
 * 
 */
package levy.daniel.application.vues.desktop.metier.contactsimple.controllervue;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;

/**
 * INTERFACE ICreationContactSimpleVueController :<br/>
 * Interface factorisant les comportements des 
 * CONTROLLERS DE VUE CreationContactSimpleVueController.<br/>
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
 * @since 24 mai 2018
 *
 */
public interface ICreationContactSimpleVueController {

	
	
	/**
	 * Gère l'appui sur le bouton enregistrer.<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 */
	void enregistrer();
	
	

	/**
	 * Gère l'appui sur le bouton annuler.<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 */
	void annuler();
	

	
	/**
     * Lit la VUE et retourne un IContactSimpleModelObs avec ses valeurs.<br/>
     * <ul>
     * <li>retourne null si la VUE est vide.</li>
     * </ul>
     *
     * @return : IContactSimpleModelObs.<br/>
     */
    IContactSimpleModelObs lire();
    
    
    
	/**
	 * Affiche un ContactSimpleModelObs dans la VUE.<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @param pContactSimpleModelObs : IContactSimpleModelObs.<br/>
	 */
	void afficher(IContactSimpleModelObs pContactSimpleModelObs);
	
	

	/**
	 * Getter de l'AnchorPane de la vue de création d'une ContactSimple.<br/>
	 *
	 * @return this.creationContactSimpleVueAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getCreationContactSimpleVueAnchorPane();
	
	

	/**
	* Setter de l'AnchorPane de la vue de création d'une ContactSimple.<br/>
	*
	* @param pCreationContactSimpleVueAnchorPane : AnchorPane : 
	* valeur à passer à this.creationContactSimpleVueAnchorPane.<br/>
	*/
	void setCreationContactSimpleVueAnchorPane(
			AnchorPane pCreationContactSimpleVueAnchorPane);
	
	

	/**
	 * Getter du GridPane de la vue de création d'une ContactSimple.<br/>
	 *
	 * @return this.contactSimpleGridPane : GridPane.<br/>
	 */
	GridPane getContactSimpleGridPane();
	
	

	/**
	* Setter du GridPane de la vue de création d'une ContactSimple.<br/>
	*
	* @param pContactSimpleGridPane : GridPane : 
	* valeur à passer à this.contactSimpleGridPane.<br/>
	*/
	void setContactSimpleGridPane(GridPane pContactSimpleGridPane);
	
	

	/**
	 * Getter du Label pour le prénom.<br/>
	 *
	 * @return this.prenomLabel : Label.<br/>
	 */
	Label getPrenomLabel();
	
	

	/**
	* Setter du Label pour le prénom.<br/>
	*
	* @param pPrenomLabel : Label : 
	* valeur à passer à this.prenomLabel.<br/>
	*/
	void setPrenomLabel(Label pPrenomLabel);
	
	

	/**
	 * Getter du Label pour le nom.<br/>
	 *
	 * @return this.nomLabel : Label.<br/>
	 */
	Label getNomLabel();
	
	

	/**
	* Setter du Label pour le nom.<br/>
	*
	* @param pNomLabel : Label : 
	* valeur à passer à this.nomLabel.<br/>
	*/
	void setNomLabel(Label pNomLabel);
	
	

	/**
	 * Getter du Label pour la rue.<br/>
	 *
	 * @return this.rueLabel : Label.<br/>
	 */
	Label getRueLabel();
	
	

	/**
	* Setter du Label pour la rue.<br/>
	*
	* @param pRueLabel : Label : 
	* valeur à passer à this.rueLabel.<br/>
	*/
	void setRueLabel(Label pRueLabel);


	
	/**
	 * Getter du Label pour le complément de rue.<br/>
	 * <br/>
	 *
	 * @return this.rue2Label : Label.<br/>
	 */
	Label getRue2Label();



	/**
	* Setter du Label pour le complément de rue.<br/>
	*
	* @param pRue2Label : Label : 
	* valeur à passer à this.rue2Label.<br/>
	*/
	void setRue2Label(Label pRue2Label);
	
	

	/**
	 * Getter du Label pour la ville.<br/>
	 *
	 * @return this.villeLabel : Label.<br/>
	 */
	Label getVilleLabel();
	
	

	/**
	* Setter du Label pour la ville.<br/>
	*
	* @param pVilleLabel : Label : 
	* valeur à passer à this.villeLabel.<br/>
	*/
	void setVilleLabel(Label pVilleLabel);
	
	

	/**
	 * Getter du Label pour le code postal.<br/>
	 *
	 * @return this.codePostalLabel : Label.<br/>
	 */
	Label getCodePostalLabel();
	
	

	/**
	* Setter du Label pour le code postal.<br/>
	*
	* @param pCodePostalLabel : Label : 
	* valeur à passer à this.codePostalLabel.<br/>
	*/
	void setCodePostalLabel(Label pCodePostalLabel);
	
	

	/**
	 * Getter du Label pour le pays.<br/>
	 *
	 * @return this.paysLabel : Label.<br/>
	 */
	Label getPaysLabel();
	
	

	/**
	* Setter du Label pour le pays.<br/>
	*
	* @param pPaysLabel : Label : 
	* valeur à passer à this.paysLabel.<br/>
	*/
	void setPaysLabel(Label pPaysLabel);
	
	

	/**
	 * Getter du Label pour le téléphone.<br/>
	 *
	 * @return this.telephoneLabel : Label.<br/>
	 */
	Label getTelephoneLabel();
	
	

	/**
	* Setter du Label pour le téléphone.<br/>
	*
	* @param pTelephoneLabel : Label : 
	* valeur à passer à this.telephoneLabel.<br/>
	*/
	void setTelephoneLabel(Label pTelephoneLabel);
	
	

	/**
	 * Getter du Label pour le mail.<br/>
	 *
	 * @return this.mailLabel : Label.<br/>
	 */
	Label getMailLabel();
	
	

	/**
	* Setter du Label pour le mail.<br/>
	*
	* @param pMailLabel : Label : 
	* valeur à passer à this.mailLabel.<br/>
	*/
	void setMailLabel(Label pMailLabel);
	
	

	/**
	 * Getter du Label pour la date de naissance.<br/>
	 *
	 * @return this.dateNaissanceLabel : Label.<br/>
	 */
	Label getDateNaissanceLabel();
	
	

	/**
	* Setter du Label pour la date de naissance.<br/>
	*
	* @param pDateNaissanceLabel : Label : 
	* valeur à passer à this.dateNaissanceLabel.<br/>
	*/
	void setDateNaissanceLabel(Label pDateNaissanceLabel);
	
	

	/**
	 * Getter du TextField pour le prénom.<br/>
	 *
	 * @return this.prenomTextField : TextField.<br/>
	 */
	TextField getPrenomTextField();
	
	

	/**
	* Setter du TextField pour le prénom.<br/>
	*
	* @param pPrenomTextField : TextField : 
	* valeur à passer à this.prenomTextField.<br/>
	*/
	void setPrenomTextField(TextField pPrenomTextField);
	
	

	/**
	 * Getter du TextField pour le nom.<br/>
	 *
	 * @return this.nomTextField : TextField.<br/>
	 */
	TextField getNomTextField(); 
	
	

	/**
	* Setter du TextField pour le nom.<br/>
	*
	* @param pNomTextField : TextField : 
	* valeur à passer à this.nomTextField.<br/>
	*/
	void setNomTextField(TextField pNomTextField);
	
	

	/**
	 * Getter du TextField pour la rue.<br/>
	 *
	 * @return this.rueTextField : TextField.<br/>
	 */
	TextField getRueTextField();
	
	

	/**
	* Setter du TextField pour la rue.<br/>
	*
	* @param pRueTextField : TextField : 
	* valeur à passer à this.rueTextField.<br/>
	*/
	void setRueTextField(TextField pRueTextField);
	
	

	/**
	 * Getter du TextField pour le complément de rue.<br/>
	 *
	 * @return this.rue2TextField : TextField.<br/>
	 */
	TextField getRue2TextField();
	
	

	/**
	* Setter du TextField pour le complément de rue.<br/>
	*
	* @param pRue2TextField : TextField : 
	* valeur à passer à this.rue2TextField.<br/>
	*/
	void setRue2TextField(TextField pRue2TextField);
	
	

	/**
	 * Getter du TextField pour la ville.<br/>
	 *
	 * @return this.villeTextField : TextField.<br/>
	 */
	TextField getVilleTextField();
	
	

	/**
	* Setter du TextField pour la ville.<br/>
	*
	* @param pVilleTextField : TextField : 
	* valeur à passer à this.villeTextField.<br/>
	*/
	void setVilleTextField(TextField pVilleTextField);

	

	/**
	 * Getter du TextField pour le code postal.<br/>
	 *
	 * @return this.codePostalTextField : TextField.<br/>
	 */
	TextField getCodePostalTextField();

	

	/**
	* Setter du TextField pour le code postal.<br/>
	*
	* @param pCodePostalTextField : TextField : 
	* valeur à passer à this.codePostalTextField.<br/>
	*/
	void setCodePostalTextField(TextField pCodePostalTextField);
	
	

	/**
	 * Getter du TextField pour le pays.<br/>
	 *
	 * @return this.paysTextField : TextField.<br/>
	 */
	TextField getPaysTextField();
	
	

	/**
	* Setter du TextField pour le pays.<br/>
	*
	* @param pPaysTextField : TextField : 
	* valeur à passer à this.paysTextField.<br/>
	*/
	void setPaysTextField(TextField pPaysTextField);
	
	

	/**
	 * Getter du TextField pour le téléphone.<br/>
	 *
	 * @return this.telephoneTextField : TextField.<br/>
	 */
	TextField getTelephoneTextField();
	
	

	/**
	* Setter du TextField pour le téléphone.<br/>
	*
	* @param pTelephoneTextField : TextField : 
	* valeur à passer à this.telephoneTextField.<br/>
	*/
	void setTelephoneTextField(TextField pTelephoneTextField);
	
	

	/**
	 * Getter du TextField pour le mail.<br/>
	 *
	 * @return this.mailTextField : TextField.<br/>
	 */
	TextField getMailTextField();
	
	

	/**
	* Setter du TextField pour le mail.<br/>
	*
	* @param pMailTextField : TextField : 
	* valeur à passer à this.mailTextField.<br/>
	*/
	void setMailTextField(TextField pMailTextField);

	

	/**
	 * Getter du TextField pour la date de naissance.<br/>
	 *
	 * @return this.dateNaissanceTextField : TextField.<br/>
	 */
	TextField getDateNaissanceTextField();
	
	

	/**
	* Setter du TextField pour la date de naissance.<br/>
	*
	* @param pDateNaissanceTextField : TextField : 
	* valeur à passer à this.dateNaissanceTextField.<br/>
	*/
	void setDateNaissanceTextField(TextField pDateNaissanceTextField);
	
	

	/**
	 * Getter de la barre de boutons.<br/>
	 *
	 * @return this.creationContactSimpleVueButtonBar : ButtonBar.<br/>
	 */
	ButtonBar getCreationContactSimpleVueButtonBar();
	
	

	/**
	* Setter de la barre de boutons.<br/>
	*
	* @param pCreationContactSimpleVueButtonBar : ButtonBar : 
	* valeur à passer à this.creationContactSimpleVueButtonBar.<br/>
	*/
	void setCreationContactSimpleVueButtonBar(
			ButtonBar pCreationContactSimpleVueButtonBar);
	
	

	/**
	 * Getter du bouton "enregistrer une Contact Simple".<br/>
	 *
	 * @return this.enregistrerButton : Button.<br/>
	 */
	Button getEnregistrerButton();
	
	

	/**
	* Setter du bouton "enregistrer une Contact Simple".<br/>
	*
	* @param pEnregistrerButton : Button : 
	* valeur à passer à this.enregistrerButton.<br/>
	*/
	void setEnregistrerButton(Button pEnregistrerButton);
	
	

	/**
	 * Getter du bouton "Annuler la saisie".<br/>
	 *
	 * @return this.annulerButton : Button.<br/>
	 */
	Button getAnnulerButton();
	
	

	/**
	* Setter du bouton "Annuler la saisie".<br/>
	*
	* @param pAnnulerButton : Button : 
	* valeur à passer à this.annulerButton.<br/>
	*/
	void setAnnulerButton(Button pAnnulerButton);
	
	

	/**
	 * Getter du theatre pour afficher la boîte de dialogue 
	 * de création d'une ContactSimple.<br/>
	 * <br/>
	 *
	 * @return this.dialogStage : Stage.<br/>
	 */
	Stage getDialogStage(); 
	
	

	/**
	* Setter du theatre pour afficher la boîte de dialogue 
	* de création d'une ContactSimple.<br/>
	* <br/>
	*
	* @param pDialogStage : Stage : 
	* valeur à passer à this.dialogStage.<br/>
	*/
	void setDialogStage(Stage pDialogStage);
	
	

} // FIN DE L'INTERFACE ICreationContactSimpleVueController.----------------------