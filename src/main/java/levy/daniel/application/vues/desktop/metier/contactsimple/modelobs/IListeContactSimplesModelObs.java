/**
 * 
 */
package levy.daniel.application.vues.desktop.metier.contactsimple.modelobs;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;

/**
 * INTERFACE IListeContactSimplesModelObs :<br/>
 * Interface factorisant les comportements 
 * des ListeContactSimplesModelObs.<br/>
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
public interface IListeContactSimplesModelObs {
	
	

	/**
	 * <ul>
	 * Rajoute un ContactSimpleModelObs associé à la ContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt;
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs associé au IContactSimple.</li>
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
	 * Rajoute un ContactSimpleModelObs associé à la ContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs associé au IContactSimple.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimple.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneAList(
			IContactSimple pContactSimple, ObservableList<IContactSimpleModelObs> pList);

	
	
	/**
	 * <ul>
	 * Rajoute un ContactSimpleModelObs pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IContactSimpleModelObs.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneControllerAList(IContactSimpleModelObs pPersonne);
	
	
	
	/**
	 * <ul>
	 * Rajoute un ContactSimpleModelObs pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IContactSimpleModelObs.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterPersonneControllerAList(
			IContactSimpleModelObs pPersonne
				, ObservableList<IContactSimpleModelObs> pList);

	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de ContactSimpleModelObs 
	 * associés à des IContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listPersonnes</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs 
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
	 * Rajoute une Liste pListAAjouter de ContactSimpleModelObs 
	 * associés à des IContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs associé 
	 * à chaque IContactSimple.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * 
	 * @param pListAAjouter : List&lt;IContactSimple&gt;.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonnesAList(
			List<IContactSimple> pListAAjouter
				, ObservableList<IContactSimpleModelObs> pList);
	
	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de IContactSimpleModelObs  
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si this.listePersonnes == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * @param pListAAjouter : List&lt;IContactSimpleModelObs&gt;.
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonneControllersAList(
			List<IContactSimpleModelObs> pListAAjouter);
	
	

	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de IContactSimpleModelObs  
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * @param pListAAjouter : List&lt;IContactSimpleModelObs&gt;.
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListePersonneControllersAList(
			List<IContactSimpleModelObs> pListAAjouter
				, ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleModelObs associé à la ContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt;
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs associé au IContactSimple.</li>
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
	 * Retire un ContactSimpleModelObs associé à la ContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs associé au IContactSimple.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimple.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneAList(
			IContactSimple pContactSimple
				, ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleModelObs pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IContactSimpleModelObs.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneControllerAList(
			IContactSimpleModelObs pPersonne);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleModelObs pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pPersonne == null.</li>
	 * </ul>
	 * 
	 * @param pPersonne : IContactSimpleModelObs.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerPersonneControllerAList(
			IContactSimpleModelObs pPersonne
				, ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de ContactSimpleModelObs 
	 * associés à des IContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listPersonnes</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs 
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
	 * Retire une Liste pListAretirer de ContactSimpleModelObs 
	 * associés à des IContactSimple pPersonne 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs associé 
	 * à chaque IContactSimple.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * 
	 * @param pListAretirer : List&lt;IContactSimple&gt;.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonnesAList(
			List<IContactSimple> pListAretirer
				, ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de IContactSimpleModelObs  
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <li>retourne false si this.listePersonnes == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * @param pListAretirer : List&lt;IContactSimpleModelObs&gt;.
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonneControllersAList(
			List<IContactSimpleModelObs> pListAretirer);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de IContactSimpleModelObs  
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * @param pListAretirer : List&lt;IContactSimpleModelObs&gt;.
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListePersonneControllersAList(
			List<IContactSimpleModelObs> pListAretirer
				, ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * Retourne le nombre d'éléments dans la liste 
	 * ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listePersonnes</b>.<br/>
	 * <ul>
	 * <li>retourne 0 si this.listePersonnes == null.</li>
	 * </ul>
	 *
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : int : nombre d'éléments dans la liste.<br/>
	 */
	int count();
	
	

	/**
	 * Retourne le nombre d'éléments dans la liste 
	 * ObservableList&lt;IContactSimpleModelObs&gt; pList.<br/>
	 * <ul>
	 * <li>retourne 0 si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : int : nombre d'éléments dans la liste.<br/>
	 */
	int count(ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * Fournit une String pour l'affichage de la liste 
	 * ObservableList&lt;IContactSimpleModelObs&gt; this.listePersonnes.<br/>
	 * <ul>
	 * <li>retourne null si this.listePersonnes == null.</li>
	 * </ul>
	 *
	 * @return : String : pour affichage.<br/>
	 */
	String afficherListe();
	
	

	/**
	 * Fournit une String pour l'affichage de la liste 
	 * ObservableList&lt;IContactSimpleModelObs&gt; pList.<br/>
	 * <ul>
	 * <li>retourne null si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : String : pour affichage.<br/>
	 */
	String afficherListe(
			ObservableList<IContactSimpleModelObs> pList);
	
	

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
	 * Getter de la liste des ContactSimpleModelObs.
	 * <br/>
	 *
	 * @return listePersonnes : 
	 * ObservableList<IContactSimpleModelObs>.<br/>
	 */
	ObservableList<IContactSimpleModelObs> getListePersonnes();

	

	/**
	* method setListePersonnes(
	* ObservableList<IContactSimpleModelObs> pListePersonnes) :<br/>
	* Setter de la liste des ContactSimpleModelObs.
	* <br/>
	*
	* @param pListePersonnes : ObservableList<IContactSimpleModelObs> : 
	* valeur à passer à listePersonnes.<br/>
	*/
	void setListePersonnes(
			ObservableList<IContactSimpleModelObs> pListePersonnes);
	
	

} // FIN DE L'INTERFACE IListeContactSimplesModelObs.---------------------------