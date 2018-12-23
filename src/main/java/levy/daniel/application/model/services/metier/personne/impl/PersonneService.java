package levy.daniel.application.model.services.metier.personne.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.IPersonne;
import levy.daniel.application.model.persistence.metier.personne.InitialiseurDeData;
import levy.daniel.application.model.services.metier.personne.IPersonneService;


/**
 * class PersonneService :<br/>
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
public class PersonneService implements IPersonneService {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(PersonneService.class);
	

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR PersonneService() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public PersonneService() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IPersonne create(
			final IPersonne pObject) {

		System.out.println(pObject.toString());
		return pObject;
		
	} // Fin de create(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IPersonne> initialiserListePersonnes() {
		return InitialiseurDeData.getListePersonnes();
	} // Fin de initialiserListePersonnes()._______________________________



} // FIN DE LA CLASSE PersonneService.---------------------------------------
