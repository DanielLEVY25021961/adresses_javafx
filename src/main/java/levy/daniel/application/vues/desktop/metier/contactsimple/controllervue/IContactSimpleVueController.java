/**
 * 
 */
package levy.daniel.application.vues.desktop.metier.contactsimple.controllervue;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.impl.ContactSimpleModelObs;

/**
 * INTERFACE IContactSimpleVueController :<br/>
 * Interface factorisant les comportements des 
 * CONTROLLERS DE VUE ContactSimpleVueController.<br/>
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
public interface IContactSimpleVueController {

	
	/**
	 * Affiche les renseignements d'une ContactSimple donné 
	 * dans le GridPane de droite.<br/>
	 * <br/>
	 *
	 * @param pContactSimpleModelObs : IContactSimpleModelObs.<br/>
	 */
	void afficherRenseignementsContactSimple(
			IContactSimpleModelObs pContactSimpleModelObs);

	

	/**
	 * Gère l'appui sur le bouton "Créer une Contact Simple".<br/>
	 * Liée au OnClick du bouton createButton dans ContactSimpleVue.fxml.<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 */
	void creerContactSimple();


	
	/**
	 * Gère l'appui sur le bouton "Modifier une Contact Simple".<br/>
	 * Liée au OnClick du bouton editButton dans ContactSimpleVue.fxml.<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 */
	void modifierContactSimple();
	
	
	
	/**
	 * Gère l'appui sur le bouton "Détruire une Contact Simple".<br/>
	 * Liée au OnClick du bouton deleteButton dans ContactSimpleVue.fxml.<br/>
	 * <br/>
	 */
	void deleteContactSimple();

	
	
	/**
	 * Getter de AccueilController.<br/>
	 *
	 * @return this.accueilController : IAccueilController.<br/>
	 */
	IAccueilController getAccueilController();
	
	

	/**
	* Setter de AccueilController.<br/>
	*
	* @param pAccueilController : IAccueilController : 
	* valeur à passer à this.accueilController.<br/>
	*/
	void setAccueilController(IAccueilController pAccueilController);
	
	

	/**
	 * Getter de l'AnchorPane principal de ContactSimpleVue.fxml.<br/>
	 *
	 * @return this.contactSimpleAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getContactSimpleAnchorPane();
	
	

	/**
	* Setter de l'AnchorPane principal de ContactSimpleVue.fxml.<br/>
	*
	* @param pContactSimpleAnchorPane : AnchorPane : 
	* valeur à passer à this.contactSimpleAnchorPane.<br/>
	*/
	void setContactSimpleAnchorPane(AnchorPane pContactSimpleAnchorPane);

	

	/**
	 * Getter du SplitPane contenu dans this.contactSimpleAnchorPane.<br/>
	 *
	 * @return this.contactSimpleSplitPane : SplitPane.<br/>
	 */
	SplitPane getContactSimpleSplitPane();
	
	

	/**
	* Setter du SplitPane contenu dans this.contactSimpleAnchorPane.<br/>
	* <br/>
	*
	* @param pContactSimpleSplitPane : SplitPane : 
	* valeur à passer à this.contactSimpleSplitPane.<br/>
	*/
	void setContactSimpleSplitPane(SplitPane pContactSimpleSplitPane);
	
	

	/**
	 * Getter de l'AnchorPane gauche du SplitPane 
	 * contenant le TableView.<br/>
	 * <br/>
	 *
	 * @return this.contactSimplesTableViewAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getContactSimplesTableViewAnchorPane();
	
	

	/**
	* Setter de l'AnchorPane gauche du SplitPane 
	* contenant le TableView.<br/>
	*
	* @param pContactSimplesTableViewAnchorPane : AnchorPane : 
	* valeur à passer à this.contactSimplesTableViewAnchorPane.<br/>
	*/
	void setContactSimplesTableViewAnchorPane(
			AnchorPane pContactSimplesTableViewAnchorPane);
	
	

	/**
	 * Getter du TableView&lt;IContactSimpleModelObs&gt; affichant 
	 * la liste des ContactSimple.<br/>
	 *
	 * @return this.contactSimplesTableView : 
	 * TableView&lt;IContactSimpleModelObs&gt;.<br/>
	 */
	TableView<IContactSimpleModelObs> getContactSimplesTableView();
	
	

	/**
	* Setter du TableView&lt;IContactSimpleModelObs&gt; affichant 
	* la liste des ContactSimple.<br/>
	* <br/>
	*
	* @param pcontactSimplesTableView : TableView&lt;IContactSimpleModelObs&gt; : 
	* valeur à passer à this.contactSimplesTableView.<br/>
	*/
	void setContactSimplesTableView(
			TableView<IContactSimpleModelObs> pcontactSimplesTableView);
	
	

	/**
	 * Getter du MODEL pour la sélection dans 
	 * le TableView this.contactSimplesTableView.<br/>
	 *
	 * @return this.modelSelection : 
	 * TableViewSelectionModel&lt;IContactSimpleModelObs&gt;.<br/>
	 */
	TableViewSelectionModel<IContactSimpleModelObs> getModelSelection();
	
	

	/**
	* Setter du MODEL pour la sélection dans 
	* le TableView this.contactSimplesTableView.<br/>
	* <br/>
	*
	* @param pModelSelection : 
	* TableViewSelectionModel&lt;IContactSimpleModelObs&gt; : 
	* valeur à passer à this.modelSelection.<br/>
	*/
	void setModelSelection(
			TableViewSelectionModel<IContactSimpleModelObs> pModelSelection);
	
	

	/**
	 * Getter de la colonne des prénoms.<br/>
	 *
	 * @return this.prenomTableColumn : 
	 * TableColumn&lt;ContactSimpleModelObs,String&gt;.<br/>
	 */
	TableColumn<ContactSimpleModelObs, String> getPrenomTableColumn();
	
	

	/**
	* Setter de la colonne des prénoms.<br/>
	*
	* @param pPrenomTableColumn : 
	* TableColumn&lt;ContactSimpleModelObs,String&gt; :
	*  valeur à passer à this.prenomTableColumn.<br/>
	*/
	void setPrenomTableColumn(TableColumn<ContactSimpleModelObs, String> pPrenomTableColumn);
	
	

	/**
	 * Getter de la colonne des noms.<br/>
	 *
	 * @return this.nomTableColumn : 
	 * TableColumn&lt;ContactSimpleModelObs,String&gt;.<br/>
	 */
	TableColumn<ContactSimpleModelObs, String> getNomTableColumn();
	
	

	/**
	* Setter de la colonne des noms.<br/>
	*
	* @param pNomTableColumn : 
	* TableColumn&lt;ContactSimpleModelObs,String&gt; : 
	* valeur à passer à this.nomTableColumn.<br/>
	*/
	void setNomTableColumn(
			TableColumn<ContactSimpleModelObs, String> pNomTableColumn);
	

	
	/**
	 * Getter de la colonne des dates de naissance.<br/>
	 *
	 * @return this.dateNaissanceTableColumn : 
	 * TableColumn&lt;ContactSimpleModelObs,String&gt; : 
	 */
	TableColumn<ContactSimpleModelObs, String> getDateNaissanceTableColumn();



	/**
	* Setter de la colonne des dates de naissance.<br/>
	*
	* @param pDateNaissanceTableColumn : 
	* TableColumn&lt;ContactSimpleModelObs,String&gt; : 
	* valeur à passer à this.dateNaissanceTableColumn.<br/>
	*/
	void setDateNaissanceTableColumn(
			TableColumn<ContactSimpleModelObs, String> pDateNaissanceTableColumn);
	
	

	/**
	 * Getter de l'AnchorPane de droite contenant les 
	 * renseignements sur une ContactSimple.<br/>
	 *
	 * @return this.renseignementsAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getRenseignementsAnchorPane();
	
	

	/**
	* Setter de l'AnchorPane de droite contenant les 
	* renseignements sur une ContactSimple.<br/>
	*
	* @param pRenseignementsAnchorPane : AnchorPane : 
	* valeur à passer à this.renseignementsAnchorPane.<br/>
	*/
	void setRenseignementsAnchorPane(AnchorPane pRenseignementsAnchorPane);
	
	

	/**
	 * Getter du Label "renseignements sur la Contact Simple".<br/>
	 *
	 * @return this.renseignementsLabel : Label.<br/>
	 */
	Label getRenseignementsLabel();
	
	

	/**
	* Setter du Label "renseignements sur la ContactSimple".<br/>
	*
	* @param pRenseignementsLabel : Label : 
	* valeur à passer à this.renseignementsLabel.<br/>
	*/
	void setRenseignementsLabel(Label pRenseignementsLabel);

	

	/**
	 * Getter du GridPane portant les renseignements 
	 * sur une ContactSimple.<br/>
	 *
	 * @return this.renseignementsGridPane : GridPane.<br/>
	 */
	GridPane getRenseignementsGridPane();

	

	/**
	* Setter du GridPane portant les renseignements 
	* sur une ContactSimple.<br/>
	*
	* @param pRenseignementsGridPane : GridPane : 
	* valeur à passer à this.renseignementsGridPane.<br/>
	*/
	void setRenseignementsGridPane(GridPane pRenseignementsGridPane);
	
	

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
	 * Getter de la Barre de boutons d'édition des ContactSimple.<br/>
	 *
	 * @return this.editionButtonBar : ButtonBar.<br/>
	 */
	ButtonBar getEditionButtonBar();
	
	

	/**
	* Setter de la Barre de boutons d'édition des ContactSimple.<br/>
	*
	* @param pEditionButtonBar : ButtonBar : 
	* valeur à passer à this.editionButtonBar.<br/>
	*/
	void setEditionButtonBar(ButtonBar pEditionButtonBar);
	
	

	/**
	 * Getter du Bouton pour la création des ContactSimple.<br/>
	 *
	 * @return this.createButton : Button.<br/>
	 */
	Button getCreateButton();
	
	

	/**
	* Setter du Bouton pour la création des ContactSimple.<br/>
	*
	* @param pCreateButton : Button : 
	* valeur à passer à this.createButton.<br/>
	*/
	void setCreateButton(Button pCreateButton);
	
	

	/**
	 * Getter du Bouton pour la modification des ContactSimple.<br/>
	 *
	 * @return this.editButton : Button.<br/>
	 */
	Button getEditButton();
	
	

	/**
	* Setter du Bouton pour la modification des ContactSimple.<br/>
	*
	* @param pEditButton : Button : 
	* valeur à passer à this.editButton.<br/>
	*/
	void setEditButton(Button pEditButton);
	
	

	/**
	 * Getter du Bouton pour la destruction des ContactSimple.<br/>
	 *
	 * @return this.deleteButton : Button.<br/>
	 */
	Button getDeleteButton();
	
	

	/**
	* Setter du Bouton pour la destruction des ContactSimple.<br/>
	*
	* @param pDeleteButton : Button : 
	* valeur à passer à this.deleteButton.<br/>
	*/
	void setDeleteButton(Button pDeleteButton);
	

	
	/**
	 * Getter de l' AnchorPane pour la création d'une ContactSimple.<br/>
	 *
	 * @return this.creationContactSimpleVueAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getCreationContactSimpleVueAnchorPane();



	/**
	* Setter de l'AnchorPane pour la création d'une ContactSimple.<br/>
	*
	* @param pCreationContactSimpleVueAnchorPane : AnchorPane : 
	* valeur à passer à this.creationContactSimpleVueAnchorPane.<br/>
	*/
	void setCreationContactSimpleVueAnchorPane(
			AnchorPane pCreationContactSimpleVueAnchorPane);



	/**
	 * Getter du CONTROLLER DE VUE de la VUE AnchorPane 
	 * pour la création d'un contact simple.<br/>
	 *
	 * @return this.creationContactSimpleVueController : 
	 * ICreationContactSimpleVueController.<br/>
	 */
	ICreationContactSimpleVueController getCreationContactSimpleVueController();



	/**
	* Setter du CONTROLLER DE VUE de la VUE AnchorPane 
	* pour la création d'un contact simple.<br/>
	*
	* @param pCreationContactSimpleVueController : 
	* ICreationContactSimpleVueController : 
	* valeur à passer à this.creationContactSimpleVueController.<br/>
	*/
	void setCreationContactSimpleVueController(
			ICreationContactSimpleVueController pCreationContactSimpleVueController);
	
	

	/**
	 * Passe les données à afficher (MODEL) au TableView.<br/>
	 *
	 * @param pListeContactSimples : ObservableList&lt;IContactSimpleModelObs&gt; : 
	 * données (MODEL) à passer à this.contactSimplesTableView.<br/>
	 */
	void setModelTableViewContactSimples(
			ObservableList<IContactSimpleModelObs> pListeContactSimples);

	
	
} // FIN DE L'INTERFACE IContactSimpleVueController?------------------------------