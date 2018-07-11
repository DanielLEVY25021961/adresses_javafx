/**
 * 
 */
package levy.daniel.application.controllers.desktop.metier.personne;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;
import levy.daniel.application.model.metier.personne.IPersonne;

/**
 * INTERFACE IListePersonnesController :<br/>
 * Interface factorisant les comportements 
 * des ListePersonnesController.<br/>
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
public interface IListePersonnesController {
	
	

	/**
	 * <ul>
	 * Rajoute un PersonneController associé à la Personne pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt;
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>instancie le IPersonneController associé au IPersonne.</li>
	 * <li>retourne false si this.listePersonnes == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IPersonne.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneAList(IPersonne pPersonne);

	
	
	/**
	 * <ul>
	 * Rajoute un PersonneController associé à la Personne pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IPersonneController associé au IPersonne.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IPersonne.<br/>
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneAList(
			IPersonne pPersonne, ObservableList<IPersonneController> pList);

	
	
	/**
	 * <ul>
	 * Rajoute un PersonneController pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IPersonneController.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneControllerAList(IPersonneController pPersonne);
	
	
	
	/**
	 * <ul>
	 * Rajoute un PersonneController pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IPersonneController.<br/>
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneControllerAList(
			IPersonneController pPersonne
				, ObservableList<IPersonneController> pList);

	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de PersonneController 
	 * associés à des IPersonne pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>this.listPersonnes</b>.<br/>
	 * <li>instancie le IPersonneController 
	 * associé à chaque IPersonne.</li>
	 * <li>retourne false si this.listPersonnes == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * @param pListAAjouter : List&lt;IPersonne&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonnesAList(List<IPersonne> pListAAjouter);
	
	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de PersonneController 
	 * associés à des IPersonne pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IPersonneController associé 
	 * à chaque IPersonne.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * 
	 * @param pListAAjouter : List&lt;IPersonne&gt;.<br/>
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonnesAList(
			List<IPersonne> pListAAjouter
				, ObservableList<IPersonneController> pList);
	
	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de IPersonneController  
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si this.listePersonnes == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * @param pListAAjouter : List&lt;IPersonneController&gt;.
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonneControllersAList(
			List<IPersonneController> pListAAjouter);
	
	

	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de IPersonneController  
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * @param pListAAjouter : List&lt;IPersonneController&gt;.
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonneControllersAList(
			List<IPersonneController> pListAAjouter
				, ObservableList<IPersonneController> pList);
	
	

	/**
	 * <ul>
	 * Retire un PersonneController associé à la Personne pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt;
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>instancie le IPersonneController associé au IPersonne.</li>
	 * <li>retourne false si this.listePersonnes == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IPersonne.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneAList(IPersonne pPersonne);
	
	

	/**
	 * <ul>
	 * Retire un PersonneController associé à la Personne pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IPersonneController associé au IPersonne.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IPersonne.<br/>
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneAList(
			IPersonne pPersonne
				, ObservableList<IPersonneController> pList);
	
	

	/**
	 * <ul>
	 * Retire un PersonneController pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IPersonneController.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneControllerAList(
			IPersonneController pPersonne);
	
	

	/**
	 * <ul>
	 * Retire un PersonneController pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IPersonneController.<br/>
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneControllerAList(
			IPersonneController pPersonne
				, ObservableList<IPersonneController> pList);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de PersonneController 
	 * associés à des IPersonne pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>this.listPersonnes</b>.<br/>
	 * <li>instancie le IPersonneController 
	 * associé à chaque IPersonne.</li>
	 * <li>retourne false si this.listPersonnes == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * @param pListAretirer : List&lt;IPersonne&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonnesAList(
			List<IPersonne> pListAretirer);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de PersonneController 
	 * associés à des IPersonne pPersonne 
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IPersonneController associé 
	 * à chaque IPersonne.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * 
	 * @param pListAretirer : List&lt;IPersonne&gt;.<br/>
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonnesAList(
			List<IPersonne> pListAretirer
				, ObservableList<IPersonneController> pList);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de IPersonneController  
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si this.listePersonnes == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * @param pListAretirer : List&lt;IPersonneController&gt;.
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonneControllersAList(
			List<IPersonneController> pListAretirer);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de IPersonneController  
	 * à la liste ObservableList&lt;IPersonneController&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * @param pListAretirer : List&lt;IPersonneController&gt;.
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonneControllersAList(
			List<IPersonneController> pListAretirer
				, ObservableList<IPersonneController> pList);
	
	

	/**
	 * Retourne le nombre d'éléments dans la liste 
	 * ObservableList&lt;IPersonneController&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <ul>
	 * <li>retourne 0 si this.listePersonnes == null.</li>
	 * </ul>
	 *
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return : int : nombre d'éléments dans la liste.<br/>
	 */
	int count();
	
	

	/**
	 * Retourne le nombre d'éléments dans la liste 
	 * ObservableList&lt;IPersonneController&gt; pList.<br/>
	 * <ul>
	 * <li>retourne 0 si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return : int : nombre d'éléments dans la liste.<br/>
	 */
	int count(ObservableList<IPersonneController> pList);
	
	

	/**
	 * Fournit une String pour l'affichage de la liste 
	 * ObservableList&lt;IPersonneController&gt; this.listePersonnes.<br/>
	 * <ul>
	 * <li>retourne null si this.listePersonnes == null.</li>
	 * </ul>
	 *
	 * @return : String : pour affichage.<br/>
	 */
	String afficherListe();
	
	

	/**
	 * Fournit une String pour l'affichage de la liste 
	 * ObservableList&lt;IPersonneController&gt; pList.<br/>
	 * <ul>
	 * <li>retourne null si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 * 
	 * @return : String : pour affichage.<br/>
	 */
	String afficherListe(
			ObservableList<IPersonneController> pList);
	
	

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
	
	

} // FIN DE L'INTERFACE IListePersonnesController.---------------------------