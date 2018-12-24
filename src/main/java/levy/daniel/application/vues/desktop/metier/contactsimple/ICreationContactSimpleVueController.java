/**
 * 
 */
package levy.daniel.application.vues.desktop.metier.contactsimple;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import levy.daniel.application.controllers.desktop.metier.contactsimple.IContactSimpleController;

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
     * Lit la VUE et retourne un IContactSimpleController avec ses valeurs.<br/>
     * <ul>
     * <li>retourne null si la VUE est vide.</li>
     * </ul>
     *
     * @return : IContactSimpleController.<br/>
     */
    IContactSimpleController lire();
    
    
    
	/**
	 * Affiche un ContactSimpleController dans la VUE.<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @param pContactSimpleController : IContactSimpleController.<br/>
	 */
	void afficher(IContactSimpleController pContactSimpleController);
	
	

	/**
	 * method getCreationPersonneVueAnchorPane() :<br/>
	 * Getter de l'AnchorPane de la vue de création d'une ContactSimple.<br/>
	 * <br/>
	 *
	 * @return creationPersonneVueAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getCreationPersonneVueAnchorPane();
	
	

	/**
	* method setCreationPersonneVueAnchorPane(
	* AnchorPane pCreationPersonneVueAnchorPane) :<br/>
	* Setter de l'AnchorPane de la vue de création d'une ContactSimple.<br/>
	* <br/>
	*
	* @param pCreationPersonneVueAnchorPane : AnchorPane : 
	* valeur à passer à creationPersonneVueAnchorPane.<br/>
	*/
	void setCreationPersonneVueAnchorPane(AnchorPane pCreationPersonneVueAnchorPane);
	
	

	/**
	 * method getPersonneGridPane() :<br/>
	 * Getter du GridPane de la vue de création d'une ContactSimple.<br/>
	 * <br/>
	 *
	 * @return personneGridPane : GridPane.<br/>
	 */
	GridPane getPersonneGridPane();
	
	

	/**
	* method setPersonneGridPane(
	* GridPane pPersonneGridPane) :<br/>
	* Setter du GridPane de la vue de création d'une ContactSimple.<br/>
	* <br/>
	*
	* @param pPersonneGridPane : GridPane : 
	* valeur à passer à personneGridPane.<br/>
	*/
	void setPersonneGridPane(GridPane pPersonneGridPane);
	
	
	
	/**
	 * method getPrenomLabel() :<br/>
	 * Getter du Label pour le prénom.<br/>
	 * <br/>
	 *
	 * @return prenomLabel : Label.<br/>
	 */
	Label getPrenomLabel();
	
	

	/**
	* method setPrenomLabel(
	* Label pPrenomLabel) :<br/>
	* Setter du Label pour le prénom.<br/>
	* <br/>
	*
	* @param pPrenomLabel : Label : 
	* valeur à passer à prenomLabel.<br/>
	*/
	void setPrenomLabel(Label pPrenomLabel);
	
	

	/**
	 * method getNomLabel() :<br/>
	 * Getter du Label pour le nom.<br/>
	 * <br/>
	 *
	 * @return nomLabel : Label.<br/>
	 */
	Label getNomLabel();
	
	

	/**
	* method setNomLabel(
	* Label pNomLabel) :<br/>
	* Setter du Label pour le nom.<br/>
	* <br/>
	*
	* @param pNomLabel : Label : 
	* valeur à passer à nomLabel.<br/>
	*/
	void setNomLabel(Label pNomLabel);
	
	

	/**
	 * method getRueLabel() :<br/>
	 * Getter du Label pour la rue.<br/>
	 * <br/>
	 *
	 * @return rueLabel : Label.<br/>
	 */
	Label getRueLabel();
	
	

	/**
	* method setRueLabel(
	* Label pRueLabel) :<br/>
	* Setter du Label pour la rue.<br/>
	* <br/>
	*
	* @param pRueLabel : Label : 
	* valeur à passer à rueLabel.<br/>
	*/
	void setRueLabel(Label pRueLabel);
	
		

	/**
	 * method getCodePostalLabel() :<br/>
	 * Getter du Label pour le code postal.<br/>
	 *
	 * @return codePostalLabel : Label.<br/>
	 */
	Label getCodePostalLabel();
	
	

	/**
	* method setCodePostalLabel(
	* Label pCodePostalLabel) :<br/>
	* Setter du Label pour le code postal.<br/>
	* <br/>
	*
	* @param pCodePostalLabel : Label : 
	* valeur à passer à codePostalLabel.<br/>
	*/
	void setCodePostalLabel(Label pCodePostalLabel);
	
	

	/**
	 * method getVilleLabel() :<br/>
	 * Getter du Label pour la ville.<br/>
	 * <br/>
	 *
	 * @return villeLabel : Label.<br/>
	 */
	Label getVilleLabel();
	
	

	/**
	* method setVilleLabel(
	* Label pVilleLabel) :<br/>
	* Setter du Label pour la ville.<br/>
	* <br/>
	*
	* @param pVilleLabel : Label : 
	* valeur à passer à villeLabel.<br/>
	*/
	void setVilleLabel(Label pVilleLabel);
	

	
	/**
	 * method getDateNaissanceLabel() :<br/>
	 * Getter du Label pour la date de naissance.<br/>
	 * <br/>
	 *
	 * @return dateNaissanceLabel : Label.<br/>
	 */
	Label getDateNaissanceLabel();
	
	

	/**
	* method setDateNaissanceLabel(
	* Label pDateNaissanceLabel) :<br/>
	* Setter du Label pour la date de naissance.<br/>
	* <br/>
	*
	* @param pDateNaissanceLabel : Label : 
	* valeur à passer à dateNaissanceLabel.<br/>
	*/
	void setDateNaissanceLabel(Label pDateNaissanceLabel);
	
	

	/**
	 * method getPrenomTextField() :<br/>
	 * Getter du TextField pour le prénom.<br/>
	 * <br/>
	 *
	 * @return prenomTextField : TextField.<br/>
	 */
	TextField getPrenomTextField();
	
	

	/**
	* method setPrenomTextField(
	* TextField pPrenomTextField) :<br/>
	* Setter du TextField pour le prénom.<br/>
	* <br/>
	*
	* @param pPrenomTextField : TextField : 
	* valeur à passer à prenomTextField.<br/>
	*/
	void setPrenomTextField(TextField pPrenomTextField);
	
	

	/**
	 * method getNomTextField() :<br/>
	 * Getter du TextField pour le nom.<br/>
	 * <br/>
	 *
	 * @return nomTextField : TextField.<br/>
	 */
	TextField getNomTextField();
	
	

	/**
	* method setNomTextField(
	* TextField pNomTextField) :<br/>
	* Setter du TextField pour le nom.<br/>
	* <br/>
	*
	* @param pNomTextField : TextField : 
	* valeur à passer à nomTextField.<br/>
	*/
	void setNomTextField(TextField pNomTextField);
	
	

	/**
	 * method getRueTextField() :<br/>
	 * Getter du TextField pour la rue.<br/>
	 * <br/>
	 *
	 * @return rueTextField : TextField.<br/>
	 */
	TextField getRueTextField();
	
	

	/**
	* method setRueTextField(
	* TextField pRueTextField) :<br/>
	* Setter du TextField pour la rue.<br/>
	* <br/>
	*
	* @param pRueTextField : TextField : 
	* valeur à passer à rueTextField.<br/>
	*/
	void setRueTextField(TextField pRueTextField);
	
	

	/**
	 * method getVilleTextField() :<br/>
	 * Getter du TextField pour la ville.<br/>
	 * <br/>
	 *
	 * @return villeTextField : TextField.<br/>
	 */
	TextField getVilleTextField();
	
	

	/**
	* method setVilleTextField(
	* TextField pVilleTextField) :<br/>
	* Setter du TextField pour la ville.<br/>
	* <br/>
	*
	* @param pVilleTextField : TextField : 
	* valeur à passer à villeTextField.<br/>
	*/
	void setVilleTextField(TextField pVilleTextField);
	
	

	/**
	 * method getCodePostalTextField() :<br/>
	 * Getter du TextField pour le code postal.<br/>
	 * <br/>
	 *
	 * @return codePostalTextField : TextField.<br/>
	 */
	TextField getCodePostalTextField();
	
	

	/**
	* method setCodePostalTextField(
	* TextField pCodePostalTextField) :<br/>
	* Setter du TextField pour le code postal.<br/>
	* <br/>
	*
	* @param pCodePostalTextField : TextField : 
	* valeur à passer à codePostalTextField.<br/>
	*/
	void setCodePostalTextField(TextField pCodePostalTextField);
	
	

	/**
	 * method getDateNaissanceTextField() :<br/>
	 * Getter du TextField pour la date de naissance.<br/>
	 * <br/>
	 *
	 * @return dateNaissanceTextField : TextField.<br/>
	 */
	TextField getDateNaissanceTextField();
	
	

	/**
	* method setDateNaissanceTextField(
	* TextField pDateNaissanceTextField) :<br/>
	* Setter du TextField pour la date de naissance.<br/>
	* <br/>
	*
	* @param pDateNaissanceTextField : TextField : 
	* valeur à passer à dateNaissanceTextField.<br/>
	*/
	void setDateNaissanceTextField(TextField pDateNaissanceTextField);
	
	

	/**
	 * Getter de la barre de boutons.<br/>
	 * <br/>
	 *
	 * @return this.creationPersonneVueButtonBar : ButtonBar.<br/>
	 */
	ButtonBar getCreationPersonneVueButtonBar();
	
	

	/**
	* Setter de la barre de boutons.<br/>
	* <br/>
	*
	* @param pCreationPersonneVueButtonBar : ButtonBar : 
	* valeur à passer à this.creationPersonneVueButtonBar.<br/>
	*/
	void setCreationPersonneVueButtonBar(ButtonBar pCreationPersonneVueButtonBar);
	
	

	/**
	 * Getter du bouton "enregistrer une ContactSimple".<br/>
	 * <br/>
	 *
	 * @return this.enregistrerButton : Button.<br/>
	 */
	Button getEnregistrerButton();
	
	

	/**
	* Setter du bouton "enregistrer une ContactSimple".<br/>
	* <br/>
	*
	* @param pEnregistrerButton : Button : 
	* valeur à passer à this.enregistrerButton.<br/>
	*/
	void setEnregistrerButton(Button pEnregistrerButton);
	
	

	/**
	 * Getter du bouton "Annuler la saisie".<br/>
	 * <br/>
	 *
	 * @return this.annulerButton : Button.<br/>
	 */
	Button getAnnulerButton();
	
	

	/**
	* Setter du bouton "Annuler la saisie".<br/>
	* <br/>
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
	 * @return dialogStage : Stage : this.dialogStage.<br/>
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