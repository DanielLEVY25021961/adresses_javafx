package levy.daniel.application.model.services.metier.contactsimple;

import java.util.List;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;



/**
 * class IContactSimpleService :<br/>
 * .<br/>
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
public interface IContactSimpleService {
	
	
	
	/**
	 * method create(
	 * IContactSimple pObject) :<br/>
	 * crée une IContactSimple.<br/>
	 * <br/>
	 *
	 * @param pObject : IContactSimple.<br/>
	 * 
	 * @return : IContactSimple.<br/>
	 */
	IContactSimple create(IContactSimple pObject);
	

	
	/**
	 * Fournit la liste des Personnes déjà stockées 
	 * pour initialiser l'interface IHM d'accueil.<br/>
	 * 
	 * @return List&lt;IContactSimple&gt;
	 */
	List<IContactSimple> initialiserListeContactSimples();
	
	
	
} // FIN DE L'INTERFACE IContactSimpleService.------------------------------------
