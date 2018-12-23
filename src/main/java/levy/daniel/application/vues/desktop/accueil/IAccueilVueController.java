package levy.daniel.application.vues.desktop.accueil;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


/**
 * INTERFACE IAccueilVueController :<br/>
 * Interface factorisant les comportements des 
 * CONTROLLERS DE VUE AccueilVueController.<br/>
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
 * @since 22 mai 2018
 *
 */
public interface IAccueilVueController {

	
	
	/**
	 * method getRoot() :<br/>
	 * Getter du panneau de fond de la scene.<br/>
	 * <br/>
	 *
	 * @return root : BorderPane.<br/>
	 */
	BorderPane getRoot();
	
	

	/**
	* method setRoot(
	* BorderPane pRoot) :<br/>
	* Setter du panneau de fond de la scene.<br/>
	* <br/>
	*
	* @param pRoot : BorderPane : valeur à passer à root.<br/>
	*/
	void setRoot(BorderPane pRoot);
	


	/**
	 * method getRootMenuBar() :<br/>
	 * Getter de la barre de menus de this.root.<br/>
	 * <br/>
	 *
	 * @return rootMenuBar : MenuBar.<br/>
	 */
	MenuBar getRootMenuBar();
	


	/**
	* method setRootMenuBar(
	* MenuBar pRootMenuBar) :<br/>
	* Setter de la barre de menus de this.root.<br/>
	* <br/>
	*
	* @param pRootMenuBar : MenuBar : 
	* valeur à passer à rootMenuBar.<br/>
	*/
	void setRootMenuBar(MenuBar pRootMenuBar);
	


	/**
	 * method getMenuFile() :<br/>
	 * Getter du menu File.<br/>
	 * <br/>
	 *
	 * @return menuFile : Menu.<br/>
	 */
	Menu getMenuFile();
	


	/**
	* method setMenuFile(
	* Menu pMenuFile) :<br/>
	* Setter du menu File.<br/>
	* <br/>
	*
	* @param pMenuFile : Menu : valeur à passer à menuFile.<br/>
	*/
	void setMenuFile(Menu pMenuFile);
	


	/**
	 * method getMenuItemClose() :<br/>
	 * Getter du MenuItem Close du Menu File.<br/>
	 * <br/>
	 *
	 * @return menuItemClose : MenuItem.<br/>
	 */
	MenuItem getMenuItemClose(); 
	


	/**
	* method setMenuItemClose(
	* MenuItem pMenuItemClose) :<br/>
	* Setter du MenuItem Close du Menu File.<br/>
	* <br/>
	*
	* @param pMenuItemClose : MenuItem : 
	* valeur à passer à menuItemClose.<br/>
	*/
	void setMenuItemClose(MenuItem pMenuItemClose);
	


	/**
	 * method getMenuEdit() :<br/>
	 * Getter du menu Edit.<br/>
	 * <br/>
	 *
	 * @return menuEdit : Menu.<br/>
	 */
	Menu getMenuEdit();
	


	/**
	* method setMenuEdit(
	* Menu pMenuEdit) :<br/>
	* Setter du menu Edit.<br/>
	* <br/>
	*
	* @param pMenuEdit : Menu : valeur à passer à menuEdit.<br/>
	*/
	void setMenuEdit(Menu pMenuEdit);
	


	/**
	 * method getMenuItemDelete() :<br/>
	 * Getter du MenuItem Delete du Menu Edit.<br/>
	 * <br/>
	 *
	 * @return menuItemDelete : MenuItem.<br/>
	 */
	MenuItem getMenuItemDelete();
	


	/**
	* method setMenuItemDelete(
	* MenuItem pMenuItemDelete) :<br/>
	* Setter du MenuItem Delete du Menu Edit.<br/>
	* <br/>
	*
	* @param pMenuItemDelete : MenuItem : 
	* valeur à passer à menuItemDelete.<br/>
	*/
	void setMenuItemDelete(MenuItem pMenuItemDelete);
	


	/**
	 * method getMenuHelp() :<br/>
	 * Getter du menu Help.<br/>
	 * <br/>
	 *
	 * @return menuHelp : Menu.<br/>
	 */
	Menu getMenuHelp();
	


	/**
	* method setMenuHelp(
	* Menu pMenuHelp) :<br/>
	* Setter du menu Help.<br/>
	* <br/>
	*
	* @param pMenuHelp : Menu : valeur à passer à menuHelp.<br/>
	*/
	void setMenuHelp(Menu pMenuHelp);
	


	/**
	 * method getMenuItemAbout() :<br/>
	 * Getter du MenuItem About du Menu Help.<br/>
	 * <br/>
	 *
	 * @return menuItemAbout : MenuItem.<br/>
	 */
	MenuItem getMenuItemAbout();
	


	/**
	* method setMenuItemAbout(
	* MenuItem pMenuItemAbout) :<br/>
	* Setter du MenuItem About du Menu Help.<br/>
	* <br/>
	*
	* @param pMenuItemAbout : MenuItem : 
	* valeur à passer à menuItemAbout.<br/>
	*/
	void setMenuItemAbout(MenuItem pMenuItemAbout);

	
			
	/**
	* Getter du panneau du bas pour la recherche.
	*
	* @return this.rootGridPaneRecherche : GridPane.<br/>
	*/
	GridPane getRootGridPaneRecherche();
	
	
		
	/**
	* Setter du panneau du bas pour la recherche.
	*
	* @param pRootGridPaneRecherche : GridPane : 
	* valeur à passer à this.rootGridPaneRecherche.<br/>
	*/
	void setRootGridPaneRecherche(GridPane pRootGridPaneRecherche);
	

	
	/**
	 * Getter du label pour la zone de recherche.
	 *
	 * @return this.labelRootRecherche : Label.<br/>
	 */
	Label getLabelRootRecherche();


	
	/**
	* Setter du label pour la zone de recherche.
	*
	* @param pLabelRootRecherche : Label : 
	* valeur à passer à this.labelRootRecherche.<br/>
	*/
	void setLabelRootRecherche(Label pLabelRootRecherche);

	
	
	/**
	 * Getter de la zone de recherche.
	 *
	 * @return this.textFieldRootRecherche : 
	 * TextField.<br/>
	 */
	TextField getTextFieldRootRecherche();

	

	 /**
	 * Setter de la zone de recherche.
	 *
	 * @param pTextFieldRootRecherche : TextField : 
	 * valeur à passer à this.textFieldRootRecherche.<br/>
	 */
	void setTextFieldRootRecherche(TextField pTextFieldRootRecherche);

	
	
	/**
	 * Getter du bouton d'effacement de la zone de recherche.
	 *
	 * @return this.buttonRootClearRecherche : Button.<br/>
	 */
	Button getButtonRootClearRecherche();


	
	/**
	* Setter du bouton d'effacement de la zone de recherche.
	*
	* @param pButtonRootClearRecherche : Button : 
	* valeur à passer à this.buttonRootClearRecherche.<br/>
	*/
	void setButtonRootClearRecherche(Button pButtonRootClearRecherche);
	
		
	
} // FIN DE L'INTERFACE IAccueilVueController.-------------------------------
