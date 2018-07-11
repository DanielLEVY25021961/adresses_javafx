package levy.daniel.application.model.services.metier.personne;

import java.util.List;

import levy.daniel.application.model.metier.personne.IPersonne;



/**
 * class IPersonneService :<br/>
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
public interface IPersonneService {
	
	
	
	/**
	 * method create(
	 * IPersonne pObject) :<br/>
	 * crée une IPersonne.<br/>
	 * <br/>
	 *
	 * @param pObject : IPersonne.<br/>
	 * 
	 * @return : IPersonne.<br/>
	 */
	IPersonne create(IPersonne pObject);
	

	
	/**
	 * Fournit la liste des Personnes déjà stockées 
	 * pour initialiser l'interface IHM d'accueil.<br/>
	 * 
	 * @return List&lt;IPersonne&gt;
	 */
	List<IPersonne> initialiserListePersonnes();
	
	
	
} // FIN DE L'INTERFACE IPersonneService.------------------------------------
