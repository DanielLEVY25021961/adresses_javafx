/**
 * 
 */
package levy.daniel.application.controllers.desktop.metier.contactsimple;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;

/**
 * INTERFACE IListeContactSimplesController :<br/>
 * Interface factorisant les comportements 
 * des ListeContactSimplesController.<br/>
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
 * @since 16 mai 2018
 *
 */
public interface IListeContactSimplesController {
	
	

	/**
	 * <ul>
	 * Rajoute un ContactSimpleController associé à la ContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt;
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>instancie le IContactSimpleController associé au IContactSimple.</li>
	 * <li>retourne false si this.listePersonnes == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimple.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneAList(IContactSimple pContactSimple);

	
	
	/**
	 * <ul>
	 * Rajoute un ContactSimpleController associé à la ContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IContactSimpleController associé au IContactSimple.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimple.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneAList(
			IContactSimple pContactSimple, ObservableList<IContactSimpleController> pList);

	
	
	/**
	 * <ul>
	 * Rajoute un ContactSimpleController pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IContactSimpleController.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneControllerAList(IContactSimpleController pPersonne);
	
	
	
	/**
	 * <ul>
	 * Rajoute un ContactSimpleController pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IContactSimpleController.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneControllerAList(
			IContactSimpleController pPersonne
				, ObservableList<IContactSimpleController> pList);

	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de ContactSimpleController 
	 * associés à des IContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>this.listPersonnes</b>.<br/>
	 * <li>instancie le IContactSimpleController 
	 * associé à chaque IContactSimple.</li>
	 * <li>retourne false si this.listPersonnes == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * @param pListAAjouter : List&lt;IContactSimple&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonnesAList(List<IContactSimple> pListAAjouter);
	
	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de ContactSimpleController 
	 * associés à des IContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IContactSimpleController associé 
	 * à chaque IContactSimple.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * 
	 * @param pListAAjouter : List&lt;IContactSimple&gt;.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonnesAList(
			List<IContactSimple> pListAAjouter
				, ObservableList<IContactSimpleController> pList);
	
	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de IContactSimpleController  
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si this.listePersonnes == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * @param pListAAjouter : List&lt;IContactSimpleController&gt;.
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonneControllersAList(
			List<IContactSimpleController> pListAAjouter);
	
	

	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de IContactSimpleController  
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * @param pListAAjouter : List&lt;IContactSimpleController&gt;.
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonneControllersAList(
			List<IContactSimpleController> pListAAjouter
				, ObservableList<IContactSimpleController> pList);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleController associé à la ContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt;
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>instancie le IContactSimpleController associé au IContactSimple.</li>
	 * <li>retourne false si this.listePersonnes == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimple.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneAList(IContactSimple pContactSimple);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleController associé à la ContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IContactSimpleController associé au IContactSimple.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimple.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneAList(
			IContactSimple pContactSimple
				, ObservableList<IContactSimpleController> pList);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleController pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IContactSimpleController.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneControllerAList(
			IContactSimpleController pPersonne);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleController pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IContactSimpleController.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneControllerAList(
			IContactSimpleController pPersonne
				, ObservableList<IContactSimpleController> pList);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de ContactSimpleController 
	 * associés à des IContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>this.listPersonnes</b>.<br/>
	 * <li>instancie le IContactSimpleController 
	 * associé à chaque IContactSimple.</li>
	 * <li>retourne false si this.listPersonnes == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * @param pListAretirer : List&lt;IContactSimple&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonnesAList(
			List<IContactSimple> pListAretirer);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de ContactSimpleController 
	 * associés à des IContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IContactSimpleController associé 
	 * à chaque IContactSimple.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * 
	 * @param pListAretirer : List&lt;IContactSimple&gt;.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonnesAList(
			List<IContactSimple> pListAretirer
				, ObservableList<IContactSimpleController> pList);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de IContactSimpleController  
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si this.listePersonnes == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * @param pListAretirer : List&lt;IContactSimpleController&gt;.
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonneControllersAList(
			List<IContactSimpleController> pListAretirer);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de IContactSimpleController  
	 * à la liste ObservableList&lt;IContactSimpleController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * @param pListAretirer : List&lt;IContactSimpleController&gt;.
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonneControllersAList(
			List<IContactSimpleController> pListAretirer
				, ObservableList<IContactSimpleController> pList);
	
	

	/**
	 * Retourne le nombre d'éléments dans la liste 
	 * ObservableList&lt;IContactSimpleController&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <ul>
	 * <li>retourne 0 si this.listePersonnes == null.</li>
	 * </ul>
	 *
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return : int : nombre d'éléments dans la liste.<br/>
	 */
	int count();
	
	

	/**
	 * Retourne le nombre d'éléments dans la liste 
	 * ObservableList&lt;IContactSimpleController&gt; pList.<br/>
	 * <ul>
	 * <li>retourne 0 si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return : int : nombre d'éléments dans la liste.<br/>
	 */
	int count(ObservableList<IContactSimpleController> pList);
	
	

	/**
	 * Fournit une String pour l'affichage de la liste 
	 * ObservableList&lt;IContactSimpleController&gt; this.listePersonnes.<br/>
	 * <ul>
	 * <li>retourne null si this.listePersonnes == null.</li>
	 * </ul>
	 *
	 * @return : String : pour affichage.<br/>
	 */
	String afficherListe();
	
	

	/**
	 * Fournit une String pour l'affichage de la liste 
	 * ObservableList&lt;IContactSimpleController&gt; pList.<br/>
	 * <ul>
	 * <li>retourne null si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : ObservableList&lt;IContactSimpleController&gt;.<br/>
	 * 
	 * @return : String : pour affichage.<br/>
	 */
	String afficherListe(
			ObservableList<IContactSimpleController> pList);
	
	

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
	void setAccueilController(
			IAccueilController pAccueilController);
	
	

	/**
	 * method getPersonneAnchorPane() :<br/>
	 * Getter du panneau AnchorPane (VUE) modélisant une personne.<br/>
	 * <br/>
	 *
	 * @return : this.personneAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getPersonneAnchorPane();
	
	

	/**
	 * method setPersonneAnchorPane() :<br/>
	 * Setter du panneau AnchorPane (VUE) modélisant une personne.<br/>
	 * <br/>
	 *
	 * @param pPersonneAnchorPane :  :  .<br/>
	 */
	void setPersonneAnchorPane(AnchorPane pPersonneAnchorPane);
	
	

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
	
	

} // FIN DE L'INTERFACE IListeContactSimplesController.---------------------------