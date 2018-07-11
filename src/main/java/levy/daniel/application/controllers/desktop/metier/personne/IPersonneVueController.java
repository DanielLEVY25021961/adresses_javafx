/**
 * 
 */
package levy.daniel.application.controllers.desktop.metier.personne;

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
import levy.daniel.application.controllers.desktop.metier.personne.impl.PersonneController;

/**
 * INTERFACE IPersonneVueController :<br/>
 * Interface factorisant les comportements des 
 * CONTROLLERS DE VUE PersonneVueController.<br/>
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
public interface IPersonneVueController {

	
	/**
	 * method afficherRenseignementsPersonne(
	 * IPersonneController pPersonneController) :<br/>
	 * Affiche les renseignements d'une Personne donnée 
	 * dans le GridPane de droite.<br/>
	 * <br/>
	 *
	 * @param pPersonneController : IPersonneController.<br/>
	 */
	void afficherRenseignementsPersonne(IPersonneController pPersonneController);

	

	/**
	 * Gère l'appui sur le bouton "Créer une Personne".<br/>
	 * Liée au OnClick du bouton createButton dans PersonneVue.fxml.<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 */
	void creerPersonne();


	
	/**
	 * Gère l'appui sur le bouton "Modifier une Personne".<br/>
	 * Liée au OnClick du bouton editButton dans PersonneVue.fxml.<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 */
	void modifierPersonne();
	
	
	
	/**
	 * method deletePersonneSelectionnee() :<br/>
	 * Gère l'appui sur le bouton "Détruire une Personne".<br/>
	 * Liée au OnClick du bouton deleteButton dans PersonneVue.fxml.<br/>
	 * <br/>
	 */
	void deletePersonneSelectionnee();

	
	
	/**
	 * method getAccueilController() :<br/>
	 * Getter de AccueilController.<br/>
	 * <br/>
	 *
	 * @return accueilController : IAccueilController.<br/>
	 */
	IAccueilController getAccueilController();
	
	

	/**
	* method setAccueilController(
	* IAccueilController pAccueilController) :<br/>
	* Setter de AccueilController.<br/>
	* <br/>
	*
	* @param pAccueilController : IAccueilController : 
	* valeur à passer à accueilController.<br/>
	*/
	void setAccueilController(IAccueilController pAccueilController);
	
	

	/**
	 * method getPersonneAnchorPane() :<br/>
	 * Getter de l'AnchorPane principal de PersonneVue.fxml.<br/>
	 * <br/>
	 *
	 * @return personneAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getPersonneAnchorPane();
	
	

	/**
	* method setPersonneAnchorPane(
	* AnchorPane pPersonneAnchorPane) :<br/>
	* Setter de l'AnchorPane principal de PersonneVue.fxml.<br/>
	* <br/>
	*
	* @param pPersonneAnchorPane : AnchorPane : 
	* valeur à passer à personneAnchorPane.<br/>
	*/
	void setPersonneAnchorPane(AnchorPane pPersonneAnchorPane);

	

	/**
	 * method getPersonneSplitPane() :<br/>
	 * Getter du SplitPane contenu dans this.personneAnchorPane.<br/>
	 * <br/>
	 *
	 * @return personneSplitPane : SplitPane.<br/>
	 */
	SplitPane getPersonneSplitPane();
	
	

	/**
	* method setPersonneSplitPane(
	* SplitPane pPersonneSplitPane) :<br/>
	* Setter du SplitPane contenu dans this.personneAnchorPane.<br/>
	* <br/>
	*
	* @param pPersonneSplitPane : SplitPane : 
	* valeur à passer à personneSplitPane.<br/>
	*/
	void setPersonneSplitPane(SplitPane pPersonneSplitPane);
	
	

	/**
	 * method getPersonnesTableViewAnchorPane() :<br/>
	 * Getter de l'AnchorPane gauche du SplitPane 
	 * contenant le TableView.<br/>
	 * <br/>
	 *
	 * @return personnesTableViewAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getPersonnesTableViewAnchorPane();
	
	

	/**
	* method setPersonnesTableViewAnchorPane(
	* AnchorPane pPersonnesTableViewAnchorPane) :<br/>
	* Setter de l'AnchorPane gauche du SplitPane 
	* contenant le TableView.<br/>
	* <br/>
	*
	* @param pPersonnesTableViewAnchorPane : AnchorPane : 
	* valeur à passer à personnesTableViewAnchorPane.<br/>
	*/
	void setPersonnesTableViewAnchorPane(AnchorPane pPersonnesTableViewAnchorPane);
	
	

	/**
	 * method getPersonnesTableView() :<br/>
	 * Getter du TableView&lt;IPersonneController&gt; affichant 
	 * la liste des Personne.<br/>
	 * <br/>
	 *
	 * @return personnesTableView : 
	 * TableView&lt;IPersonneController&gt;.<br/>
	 */
	TableView<IPersonneController> getPersonnesTableView();
	
	

	/**
	* method setPersonnesTableView(
	* TableView&lt;IPersonneController&gt; pPersonnesTableView) :<br/>
	* Setter du TableView&lt;IPersonneController&gt; affichant 
	* la liste des Personne.<br/>
	* <br/>
	*
	* @param pPersonnesTableView : TableView&lt;IPersonneController&gt; : 
	* valeur à passer à personnesTableView.<br/>
	*/
	void setPersonnesTableView(TableView<IPersonneController> pPersonnesTableView);
	
	

	/**
	 * method getModelSelection() :<br/>
	 * Getter du MODEL pour la sélection dans 
	 * le TableView this.personnesTableView.<br/>
	 * <br/>
	 *
	 * @return modelSelection : 
	 * TableViewSelectionModel&lt;IPersonneController&gt;.<br/>
	 */
	TableViewSelectionModel<IPersonneController> getModelSelection();
	
	

	/**
	* method setModelSelection(
	* TableViewSelectionModel&lt;IPersonneController&gt; pModelSelection) :<br/>
	* Setter du MODEL pour la sélection dans 
	* le TableView this.personnesTableView.<br/>
	* <br/>
	*
	* @param pModelSelection : TableViewSelectionModel&lt;IPersonneController&gt; : 
	* valeur à passer à modelSelection.<br/>
	*/
	void setModelSelection(TableViewSelectionModel<IPersonneController> pModelSelection);
	
	

	/**
	 * method getPrenomTableColumn() :<br/>
	 * Getter de la colonne des prénoms.<br/>
	 * <br/>
	 *
	 * @return prenomTableColumn : 
	 * TableColumn&lt;PersonneController,String&gt;.<br/>
	 */
	TableColumn<PersonneController, String> getPrenomTableColumn();
	
	

	/**
	* method setPrenomTableColumn(
	* TableColumn&lt;PersonneController,String&gt; pPrenomTableColumn) :<br/>
	* Setter de la colonne des prénoms.<br/>
	* <br/>
	*
	* @param pPrenomTableColumn : 
	* TableColumn&lt;PersonneController,String&gt; :
	*  valeur à passer à prenomTableColumn.<br/>
	*/
	void setPrenomTableColumn(TableColumn<PersonneController, String> pPrenomTableColumn);
	
	

	/**
	 * method getNomTableColumn() :<br/>
	 * Getter de la colonne des noms.<br/>
	 * <br/>
	 *
	 * @return nomTableColumn : TableColumn&lt;PersonneController,String&gt;.<br/>
	 */
	TableColumn<PersonneController, String> getNomTableColumn();
	
	

	/**
	* method setNomTableColumn(
	* TableColumn&lt;PersonneController,String&gt; pNomTableColumn) :<br/>
	* Setter de la colonne des noms.<br/>
	* <br/>
	*
	* @param pNomTableColumn : 
	* TableColumn&lt;PersonneController,String&gt; : 
	* valeur à passer à nomTableColumn.<br/>
	*/
	void setNomTableColumn(TableColumn<PersonneController, String> pNomTableColumn);
	
	

	/**
	 * method getRenseignementsAnchorPane() :<br/>
	 * Getter de l'AnchorPane de droite contenant les 
	 * renseignements sur une Personne.<br/>
	 * <br/>
	 *
	 * @return renseignementsAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getRenseignementsAnchorPane();
	
	

	/**
	* method setRenseignementsAnchorPane(
	* AnchorPane pRenseignementsAnchorPane) :<br/>
	* Setter de l'AnchorPane de droite contenant les 
	* renseignements sur une Personne.<br/>
	* <br/>
	*
	* @param pRenseignementsAnchorPane : AnchorPane : 
	* valeur à passer à renseignementsAnchorPane.<br/>
	*/
	void setRenseignementsAnchorPane(AnchorPane pRenseignementsAnchorPane);
	
	

	/**
	 * method getRenseignementsLabel() :<br/>
	 * Getter du Label "renseignements sur la Personne".<br/>
	 * <br/>
	 *
	 * @return renseignementsLabel : Label.<br/>
	 */
	Label getRenseignementsLabel();
	
	

	/**
	* method setRenseignementsLabel(
	* Label pRenseignementsLabel) :<br/>
	* Setter du Label "renseignements sur la Personne".<br/>
	* <br/>
	*
	* @param pRenseignementsLabel : Label : 
	* valeur à passer à this.renseignementsLabel.<br/>
	*/
	void setRenseignementsLabel(Label pRenseignementsLabel);

	

	/**
	 * method getRenseignementsGridPane() :<br/>
	 * Getter du GridPane portant les renseignements 
	 * sur une Personne.<br/>
	 * <br/>
	 *
	 * @return renseignementsGridPane : GridPane.<br/>
	 */
	GridPane getRenseignementsGridPane();

	

	/**
	* method setRenseignementsGridPane(
	* GridPane pRenseignementsGridPane) :<br/>
	* Setter du GridPane portant les renseignements 
	* sur une Personne.<br/>
	* <br/>
	*
	* @param pRenseignementsGridPane : GridPane : 
	* valeur à passer à renseignementsGridPane.<br/>
	*/
	void setRenseignementsGridPane(GridPane pRenseignementsGridPane);
	
	

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
	 * method getEditionButtonBar() :<br/>
	 * Getter de la Barre de boutons d'édition des Personne.<br/>
	 * <br/>
	 *
	 * @return editionButtonBar : ButtonBar.<br/>
	 */
	ButtonBar getEditionButtonBar();
	
	

	/**
	* method setEditionButtonBar(
	* ButtonBar pEditionButtonBar) :<br/>
	* Setter de la Barre de boutons d'édition des Personne.<br/>
	* <br/>
	*
	* @param pEditionButtonBar : ButtonBar : 
	* valeur à passer à editionButtonBar.<br/>
	*/
	void setEditionButtonBar(ButtonBar pEditionButtonBar);
	
	

	/**
	 * method getCreateButton() :<br/>
	 * Getter du Bouton pour la création des Personne.<br/>
	 * <br/>
	 *
	 * @return createButton : Button.<br/>
	 */
	Button getCreateButton();
	
	

	/**
	* method setCreateButton(
	* Button pCreateButton) :<br/>
	* Setter du Bouton pour la création des Personne.<br/>
	* <br/>
	*
	* @param pCreateButton : Button : 
	* valeur à passer à createButton.<br/>
	*/
	void setCreateButton(Button pCreateButton);
	
	

	/**
	 * method getEditButton() :<br/>
	 * Getter du Bouton pour la modification des Personne.<br/>
	 * <br/>
	 *
	 * @return editButton : Button.<br/>
	 */
	Button getEditButton();
	
	

	/**
	* method setEditButton(
	* Button pEditButton) :<br/>
	* Setter du Bouton pour la modification des Personne.<br/>
	* <br/>
	*
	* @param pEditButton : Button : 
	* valeur à passer à editButton.<br/>
	*/
	void setEditButton(Button pEditButton);
	
	

	/**
	 * method getDeleteButton() :<br/>
	 * Getter du Bouton pour la destruction des Personne.<br/>
	 * <br/>
	 *
	 * @return deleteButton : Button.<br/>
	 */
	Button getDeleteButton();
	
	

	/**
	* method setDeleteButton(
	* Button pDeleteButton) :<br/>
	* Setter du Bouton pour la destruction des Personne.<br/>
	* <br/>
	*
	* @param pDeleteButton : Button : 
	* valeur à passer à deleteButton.<br/>
	*/
	void setDeleteButton(Button pDeleteButton);
	

	
	/**
	 * Getter de l' AnchorPane pour la création d'une Personne.<br/>
	 * <br/>
	 *
	 * @return creationPersonneVueAnchorPane : AnchorPane : 
	 * this.creationPersonneVueAnchorPane.<br/>
	 */
	AnchorPane getCreationPersonneVueAnchorPane();



	/**
	* Setter de l'AnchorPane pour la création d'une Personne.<br/>
	* <br/>
	*
	* @param pCreationPersonneVueAnchorPane : AnchorPane : 
	* valeur à passer à this.creationPersonneVueAnchorPane.<br/>
	*/
	void setCreationPersonneVueAnchorPane(
			AnchorPane pCreationPersonneVueAnchorPane);



	/**
	 * Getter du CONTROLLER DE VUE de la VUE AnchorPane 
	 * pour la création d'une personne.<br/>
	 * <br/>
	 *
	 * @return this.creationPersonneVueController : 
	 * ICreationPersonneVueController.<br/>
	 */
	ICreationPersonneVueController getCreationPersonneVueController();



	/**
	* Setter du CONTROLLER DE VUE de la VUE AnchorPane 
	* pour la création d'une personne.<br/>
	* <br/>
	*
	* @param pCreationPersonneVueController : ICreationPersonneVueController : 
	* valeur à passer à this.creationPersonneVueController.<br/>
	*/
	void setCreationPersonneVueController(
			ICreationPersonneVueController pCreationPersonneVueController);
	
	

	/**
	 * method setModelTableViewPersonnes(
	 * ObservableList&lt;IPersonneController&gt; pListePersonnes) :<br/>
	 * Passe les données à afficher (MODEL) au TableView.<br/>
	 * <br/>
	 *
	 * @param pListePersonnes : ObservableList&lt;IPersonneController&gt; : 
	 * données (MODEL) à passer à this.personnesTableView.<br/>
	 */
	void setModelTableViewPersonnes(ObservableList<IPersonneController> pListePersonnes);

	
	
} // FIN DE L'INTERFACE IPersonneVueController?------------------------------