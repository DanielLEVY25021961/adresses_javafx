package levy.daniel.application.controllers.desktop.accueil;

import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import levy.daniel.application.MainApplication;
import levy.daniel.application.controllers.desktop.metier.contactsimple.IContactSimpleController;
import levy.daniel.application.model.services.metier.contactsimple.IContactSimpleService;
import levy.daniel.application.vues.desktop.accueil.IAccueilVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.IContactSimpleVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.ICreationContactSimpleVueController;



/**
 * INTERFACE IAccueilController :<br/>
 * Interface factorisant les comportements 
 * des CONTROLLERS AccueilController.<br/>
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
public interface IAccueilController {

	
		
	/**
	 * method getMainApplication() :<br/>
	 * Getter de l'application principale.<br/>
	 * <br/>
	 *
	 * @return mainApplication : MainApplication.<br/>
	 */
	MainApplication getMainApplication();
	
	
	
	/**
	* method setMainApplication(
	* MainApplication pMainApplication) :<br/>
	* Setter de l'application principale.<br/>
	* <br/>
	*
	* @param pMainApplication : MainApplication : 
	* valeur à passer à mainApplication.<br/>
	*/
	void setMainApplication(MainApplication pMainApplication);


	
	/**
	 * method getRoot() :<br/>
	 * Getter du Panneau de fond de la scene.<br/>
	 * <br/>
	 *
	 * @return root : BorderPane.<br/>
	 */
	BorderPane getRoot();



	/**
	* method setRoot(
	* BorderPane pRoot) :<br/>
	* Setter du Panneau de fond de la scene.<br/>
	* <br/>
	*
	* @param pRoot : BorderPane : valeur à passer à root.<br/>
	*/
	void setRoot(BorderPane pRoot);


	
	/**
	 * method getAccueilVueController() :<br/>
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement 
	 * lors du chargement du FXML par le FXMLLoader.<br/>
	 * <br/>
	 *
	 * @return accueilVueController : AccueilVueController.<br/>
	 */
	IAccueilVueController getAccueilVueController();


	
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
	void setAccueilVueController(
			IAccueilVueController pAccueilVueController);


	/**
	 * method getPersonneAnchorPane() :<br/>
	 * Getter du panneau AnchorPane (VUE) modélisant une personne.<br/>
	 * <br/>
	 *
	 * @return personneAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getContactSimpleAnchorPane();



	/**
	* method setPersonneAnchorPane(
	* AnchorPane pPersonneAnchorPane) :<br/>
	* Setter du panneau AnchorPane (VUE) modélisant une personne.<br/>
	* <br/>
	*
	* @param pPersonneAnchorPane : AnchorPane : 
	* valeur à passer à personneAnchorPane.<br/>
	*/
	void setContactSimpleAnchorPane(AnchorPane pPersonneAnchorPane);


	
	/**
	 * method getPersonneVueController() :<br/>
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
	 * <br/>
	 *
	 * @return personneVueController : ContactSimpleVueController.<br/>
	 */
	IContactSimpleVueController getContactSimpleVueController();


	
	/**
	* method setPersonneVueController(
	* ContactSimpleVueController pPersonneVueController) :<br/>
	* Setter du CONTROLLER DE VUE fabriqué automatiquement lors du 
    * chargement du FXML par le FXMLLoader.<br/>
    * Permet d'accéder aux objets graphiques de 
    * la VUE générés par le FXML.<br/>
	* <br/>
	*
	* @param pContactSimpleVueController : ContactSimpleVueController : 
	* valeur à passer à personneVueController.<br/>
	*/
	void setPersonneVueController(
			IContactSimpleVueController pContactSimpleVueController);
	
	
	
	/**
	 * method getListePersonnes() :<br/>
	 * Getter de la liste des ContactSimpleController.
	 * <br/>
	 *
	 * @return listePersonnes : 
	 * ObservableList<IContactSimpleController>.<br/>
	 */
	ObservableList<IContactSimpleController> getListePersonnes();


	
	/**
	* method setListePersonnes(
	* ObservableList<IContactSimpleController> pListePersonnes) :<br/>
	* Setter de la liste des ContactSimpleController.
	* <br/>
	*
	* @param pListePersonnes : ObservableList<IContactSimpleController> : 
	* valeur à passer à listePersonnes.<br/>
	*/
	void setListePersonnes(
			ObservableList<IContactSimpleController> pListePersonnes);
	

	
	/**
	 * method getPersonneService() :<br/>
	 * Getter du SERVICE gérant les ContactSimple et assurant le lien 
	 * entre les CONTROLLERS et la logique metier.<br/>
	 * <br/>
	 *
	 * @return personneService : IContactSimpleService.<br/>
	 */
	IContactSimpleService getPersonneService();


	
	/**
	* method setPersonneService(
	* IContactSimpleService pPersonneService) :<br/>
	* Setter du SERVICE gérant les ContactSimple et assurant le lien 
	* entre les CONTROLLERS et la logique metier.<br/>
	* <br/>
	*
	* @param pContactSimpleService : IContactSimpleService : 
	* valeur à passer à personneService.<br/>
	*/
	void setPersonneService(IContactSimpleService pContactSimpleService);
	

	
	/**
	 * Getter de l' AnchorPane pour la création d'une ContactSimple.<br/>
	 * <br/>
	 *
	 * @return creationPersonneVueAnchorPane : AnchorPane : 
	 * this.creationPersonneVueAnchorPane.<br/>
	 */
	AnchorPane getCreationPersonneVueAnchorPane();



	/**
	* Setter de l'AnchorPane pour la création d'une ContactSimple.<br/>
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
	 * ICreationContactSimpleVueController.<br/>
	 */
	ICreationContactSimpleVueController getCreationPersonneVueController();



	/**
	* Setter du CONTROLLER DE VUE de la VUE AnchorPane 
	* pour la création d'une personne.<br/>
	* <br/>
	*
	* @param pCreationContactSimpleVueController : ICreationContactSimpleVueController : 
	* valeur à passer à this.creationPersonneVueController.<br/>
	*/
	void setCreationPersonneVueController(
			ICreationContactSimpleVueController pCreationContactSimpleVueController);
	
	
	
} // FIN DE L'INTERFACE IAccueilController.----------------------------------
