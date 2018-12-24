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
	 * Rajoute un ContactSimpleModelObs associé à la ContactSimple pContactSimple 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt;
	 * <b>this.listeContactSimples</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs associé au IContactSimple.</li>
	 * <li>retourne false si this.listeContactSimples == null.</li>
	 * <li>retourne false si pContactSimple == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimple.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterContactSimpleAList(IContactSimple pContactSimple);

	
	
	/**
	 * <ul>
	 * Rajoute un ContactSimpleModelObs associé à la ContactSimple pContactSimple 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs associé au IContactSimple.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pContactSimple == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimple.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterContactSimpleAList(
			IContactSimple pContactSimple, ObservableList<IContactSimpleModelObs> pList);

	
	
	/**
	 * <ul>
	 * Rajoute un ContactSimpleModelObs pContactSimple 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listeContactSimples</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pContactSimple == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimpleModelObs.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterContactSimpleControllerAList(IContactSimpleModelObs pContactSimple);
	
	
	
	/**
	 * <ul>
	 * Rajoute un ContactSimpleModelObs pContactSimple 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pContactSimple == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimpleModelObs.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterContactSimpleControllerAList(
			IContactSimpleModelObs pContactSimple
				, ObservableList<IContactSimpleModelObs> pList);

	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de ContactSimpleModelObs 
	 * associés à des IContactSimple pContactSimple 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listContactSimples</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs 
	 * associé à chaque IContactSimple.</li>
	 * <li>retourne false si this.listContactSimples == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * @param pListAAjouter : List&lt;IContactSimple&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListeContactSimplesAList(List<IContactSimple> pListAAjouter);
	
	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de ContactSimpleModelObs 
	 * associés à des IContactSimple pContactSimple 
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
	boolean ajouterListeContactSimplesAList(
			List<IContactSimple> pListAAjouter
				, ObservableList<IContactSimpleModelObs> pList);
	
	
	
	/**
	 * <ul>
	 * Rajoute une Liste pListAAjouter de IContactSimpleModelObs  
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listeContactSimples</b>.<br/>
	 * <li>retourne false si this.listeContactSimples == null.</li>
	 * <li>retourne false si pListAAjouter == null.</li>
	 * </ul>
	 * 
	 * @param pListAAjouter : List&lt;IContactSimpleModelObs&gt;.
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean ajouterListeContactSimpleControllersAList(
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
	boolean ajouterListeContactSimpleControllersAList(
			List<IContactSimpleModelObs> pListAAjouter
				, ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleModelObs associé à la ContactSimple pContactSimple 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt;
	 * <b>this.listeContactSimples</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs associé au IContactSimple.</li>
	 * <li>retourne false si this.listeContactSimples == null.</li>
	 * <li>retourne false si pContactSimple == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimple.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerContactSimpleAList(IContactSimple pContactSimple);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleModelObs associé à la ContactSimple pContactSimple 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs associé au IContactSimple.</li>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pContactSimple == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimple.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerContactSimpleAList(
			IContactSimple pContactSimple
				, ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleModelObs pContactSimple 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listeContactSimples</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pContactSimple == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimpleModelObs.<br/>
	 * 
	 * @return boolean : true si l'ajout est effectué.<br/>
	 */
	boolean retirerContactSimpleControllerAList(
			IContactSimpleModelObs pContactSimple);
	
	

	/**
	 * <ul>
	 * Retire un ContactSimpleModelObs pContactSimple 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>pList</b>.<br/>
	 * <li>retourne false si pList == null.</li>
	 * <li>retourne false si pContactSimple == null.</li>
	 * </ul>
	 * 
	 * @param pContactSimple : IContactSimpleModelObs.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerContactSimpleControllerAList(
			IContactSimpleModelObs pContactSimple
				, ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de ContactSimpleModelObs 
	 * associés à des IContactSimple pContactSimple 
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listContactSimples</b>.<br/>
	 * <li>instancie le IContactSimpleModelObs 
	 * associé à chaque IContactSimple.</li>
	 * <li>retourne false si this.listContactSimples == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * @param pListAretirer : List&lt;IContactSimple&gt;.<br/>
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListeContactSimplesAList(
			List<IContactSimple> pListAretirer);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de ContactSimpleModelObs 
	 * associés à des IContactSimple pContactSimple 
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
	boolean retirerListeContactSimplesAList(
			List<IContactSimple> pListAretirer
				, ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * <ul>
	 * Retire une Liste pListAretirer de IContactSimpleModelObs  
	 * à la liste ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listeContactSimples</b>.<br/>
	 * <li>retourne false si this.listeContactSimples == null.</li>
	 * <li>retourne false si pListAretirer == null.</li>
	 * </ul>
	 * 
	 * @param pListAretirer : List&lt;IContactSimpleModelObs&gt;.
	 * 
	 * @return : true si l'ajout est effectué.<br/>
	 */
	boolean retirerListeContactSimpleControllersAList(
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
	boolean retirerListeContactSimpleControllersAList(
			List<IContactSimpleModelObs> pListAretirer
				, ObservableList<IContactSimpleModelObs> pList);
	
	

	/**
	 * Retourne le nombre d'éléments dans la liste 
	 * ObservableList&lt;IContactSimpleModelObs&gt; 
	 * <b>this.listeContactSimples</b>.<br/>
	 * <ul>
	 * <li>retourne 0 si this.listeContactSimples == null.</li>
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
	 * ObservableList&lt;IContactSimpleModelObs&gt; this.listeContactSimples.<br/>
	 * <ul>
	 * <li>retourne null si this.listeContactSimples == null.</li>
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
	 * method getContactSimpleAnchorPane() :<br/>
	 * Getter du panneau AnchorPane (VUE) modélisant une contactSimple.<br/>
	 * <br/>
	 *
	 * @return : this.contactSimpleAnchorPane : AnchorPane.<br/>
	 */
	AnchorPane getContactSimpleAnchorPane();
	
	

	/**
	 * method setContactSimpleAnchorPane() :<br/>
	 * Setter du panneau AnchorPane (VUE) modélisant une contactSimple.<br/>
	 * <br/>
	 *
	 * @param pContactSimpleAnchorPane :  :  .<br/>
	 */
	void setContactSimpleAnchorPane(AnchorPane pContactSimpleAnchorPane);
	
	

	/**
	 * method getListeContactSimples() :<br/>
	 * Getter de la liste des ContactSimpleModelObs.
	 * <br/>
	 *
	 * @return listeContactSimples : 
	 * ObservableList<IContactSimpleModelObs>.<br/>
	 */
	ObservableList<IContactSimpleModelObs> getListeContactSimples();

	

	/**
	* method setListeContactSimples(
	* ObservableList<IContactSimpleModelObs> pListeContactSimples) :<br/>
	* Setter de la liste des ContactSimpleModelObs.
	* <br/>
	*
	* @param pListeContactSimples : ObservableList<IContactSimpleModelObs> : 
	* valeur à passer à listeContactSimples.<br/>
	*/
	void setListeContactSimples(
			ObservableList<IContactSimpleModelObs> pListeContactSimples);
	
	

} // FIN DE L'INTERFACE IListeContactSimplesModelObs.---------------------------