package levy.daniel.application.controllers.desktop.accueil;

import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import levy.daniel.application.MainApplication;
import levy.daniel.application.model.services.metier.contactsimple.IContactSimpleService;
import levy.daniel.application.vues.desktop.accueil.IAccueilVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.controllervue.IContactSimpleVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.controllervue.ICreationContactSimpleVueController;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;



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
	 * Getter de l'application principale.<br/>
	 *
	 * @return mainApplication : MainApplication.<br/>
	 */
	MainApplication getMainApplication();
	
	
	
	/**
	* Setter de l'application principale.<br/>
	*
	* @param pMainApplication : MainApplication : 
	* valeur à passer à mainApplication.<br/>
	*/
	void setMainApplication(MainApplication pMainApplication);


	
	/**
	 * Getter du Panneau de fond de la scene.<br/>
	 *
	 * @return this.root : BorderPane.<br/>
	 */
	BorderPane getRoot();



	/**
	* Setter du Panneau de fond de la scene.<br/>
	*
	* @param pRoot : BorderPane : 
	* valeur à passer à this.root.<br/>
	*/
	void setRoot(BorderPane pRoot);


	
	/**
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement 
	 * lors du chargement du FXML par le FXMLLoader.<br/>
	 *
	 * @return accueilVueController : AccueilVueController.<br/>
	 */
	IAccueilVueController getAccueilVueController();


	
	/**
	* Setter du CONTROLLER DE VUE fabriqué automatiquement 
	* lors du chargement du FXML par le FXMLLoader.<br/>
	*
	* @param pAccueilVueController : AccueilVueController : 
	* valeur à passer à this.accueilVueController.<br/>
	*/
	void setAccueilVueController(
			IAccueilVueController pAccueilVueController);


	/**
	 * Getter du panneau AnchorPane (VUE) modélisant un contact simple.<br/>
	 *
	 * @return this.contactSimpleAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getContactSimpleAnchorPane();



	/**
	* Setter du panneau AnchorPane (VUE) modélisant un contact simple.<br/>
	*
	* @param pContactSimpleAnchorPane : AnchorPane : 
	* valeur à passer à this.contactSimpleAnchorPane.<br/>
	*/
	void setContactSimpleAnchorPane(AnchorPane pContactSimpleAnchorPane);


	
	/**
	 * Getter du CONTROLLER DE VUE fabriqué automatiquement lors du 
     * chargement du FXML par le FXMLLoader.<br/>
     * Permet d'accéder aux objets graphiques de 
     * la VUE générés par le FXML.<br/>
	 *
	 * @return this.contactSimpleVueController : 
	 * IContactSimpleVueController.<br/>
	 */
	IContactSimpleVueController getContactSimpleVueController();


	
	/**
	* Setter du CONTROLLER DE VUE fabriqué automatiquement lors du 
    * chargement du FXML par le FXMLLoader.<br/>
    * Permet d'accéder aux objets graphiques de 
    * la VUE générés par le FXML.<br/>
	*
	* @param pContactSimpleVueController : ContactSimpleVueController : 
	* valeur à passer à contactSimpleVueController.<br/>
	*/
	void setContactSimpleVueController(
			IContactSimpleVueController pContactSimpleVueController);
	
	
	
	/**
	 * Getter de la liste des ContactSimpleModelObs 
	 * (liste d'OBSERVABLES insérable dans un MODEL et 
	 * affichable dans un TableView).<br/>
	 *
	 * @return this.listeContactSimples : 
	 * ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 */
	ObservableList<IContactSimpleModelObs> getListeContactSimples();


	
	/**
	* Setter de la liste des ContactSimpleModelObs.
	* (liste d'OBSERVABLES insérable dans un MODEL et 
	 * affichable dans un TableView).<br/>
	*
	* @param pListeContactSimples : ObservableList&lt;IContactSimpleModelObs&gt; 
	* valeur à passer à this.listeContactSimples.<br/>
	*/
	void setListeContactSimples(
			ObservableList<IContactSimpleModelObs> pListeContactSimples);
	

	
	/**
	 * Getter du SERVICE gérant les ContactSimple et assurant le lien 
	 * entre les CONTROLLERS et la logique metier.<br/>
	 *
	 * @return this.contactSimpleService : IContactSimpleService.<br/>
	 */
	IContactSimpleService getContactSimpleService();


	
	/**
	* Setter du SERVICE gérant les ContactSimple et assurant le lien 
	* entre les CONTROLLERS et la logique metier.<br/>
	*
	* @param pContactSimpleService : IContactSimpleService : 
	* valeur à passer à this.contactSimpleService.<br/>
	*/
	void setContactSimpleService(IContactSimpleService pContactSimpleService);
	

	
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
	* @param pCreationContactSimpleVueController : ICreationContactSimpleVueController : 
	* valeur à passer à this.creationContactSimpleVueController.<br/>
	*/
	void setCreationContactSimpleVueController(
			ICreationContactSimpleVueController pCreationContactSimpleVueController);
	
	
	
} // FIN DE L'INTERFACE IAccueilController.----------------------------------
