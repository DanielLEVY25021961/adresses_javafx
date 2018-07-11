package levy.daniel.application.controllers.desktop.accueil;

import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import levy.daniel.application.MainApplication;
import levy.daniel.application.controllers.desktop.metier.personne.ICreationPersonneVueController;
import levy.daniel.application.controllers.desktop.metier.personne.IPersonneController;
import levy.daniel.application.controllers.desktop.metier.personne.IPersonneVueController;
import levy.daniel.application.model.services.metier.personne.IPersonneService;



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
	AnchorPane getPersonneAnchorPane();



	/**
	* method setPersonneAnchorPane(
	* AnchorPane pPersonneAnchorPane) :<br/>
	* Setter du panneau AnchorPane (VUE) modélisant une personne.<br/>
	* <br/>
	*
	* @param pPersonneAnchorPane : AnchorPane : 
	* valeur à passer à personneAnchorPane.<br/>
	*/
	void setPersonneAnchorPane(AnchorPane pPersonneAnchorPane);


	
	/**
	 * method getPersonneVueController() :<br/>
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
	 * <br/>
	 *
	 * @return personneVueController : PersonneVueController.<br/>
	 */
	IPersonneVueController getPersonneVueController();


	
	/**
	* method setPersonneVueController(
	* PersonneVueController pPersonneVueController) :<br/>
	* Setter du CONTROLLER DE VUE fabriqué automatiquement lors du 
    * chargement du FXML par le FXMLLoader.<br/>
    * Permet d'accéder aux objets graphiques de 
    * la VUE générés par le FXML.<br/>
	* <br/>
	*
	* @param pPersonneVueController : PersonneVueController : 
	* valeur à passer à personneVueController.<br/>
	*/
	void setPersonneVueController(
			IPersonneVueController pPersonneVueController);
	
	
	
	/**
	 * method getListePersonnes() :<br/>
	 * Getter de la liste des PersonneController.
	 * <br/>
	 *
	 * @return listePersonnes : 
	 * ObservableList<IPersonneController>.<br/>
	 */
	ObservableList<IPersonneController> getListePersonnes();


	
	/**
	* method setListePersonnes(
	* ObservableList<IPersonneController> pListePersonnes) :<br/>
	* Setter de la liste des PersonneController.
	* <br/>
	*
	* @param pListePersonnes : ObservableList<IPersonneController> : 
	* valeur à passer à listePersonnes.<br/>
	*/
	void setListePersonnes(
			ObservableList<IPersonneController> pListePersonnes);
	

	
	/**
	 * method getPersonneService() :<br/>
	 * Getter du SERVICE gérant les Personne et assurant le lien 
	 * entre les CONTROLLERS et la logique metier.<br/>
	 * <br/>
	 *
	 * @return personneService : IPersonneService.<br/>
	 */
	IPersonneService getPersonneService();


	
	/**
	* method setPersonneService(
	* IPersonneService pPersonneService) :<br/>
	* Setter du SERVICE gérant les Personne et assurant le lien 
	* entre les CONTROLLERS et la logique metier.<br/>
	* <br/>
	*
	* @param pPersonneService : IPersonneService : 
	* valeur à passer à personneService.<br/>
	*/
	void setPersonneService(IPersonneService pPersonneService);
	

	
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
	
	
	
} // FIN DE L'INTERFACE IAccueilController.----------------------------------
