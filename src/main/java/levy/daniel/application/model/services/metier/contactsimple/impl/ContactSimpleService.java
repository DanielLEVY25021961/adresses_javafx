package levy.daniel.application.model.services.metier.contactsimple.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.persistence.metier.contactsimple.InitialiseurDeData;
import levy.daniel.application.model.services.metier.contactsimple.IContactSimpleService;


/**
 * class ContactSimpleService :<br/>
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
public class ContactSimpleService implements IContactSimpleService {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ContactSimpleService.class);
	

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR ContactSimpleService() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ContactSimpleService() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple create(
			final IContactSimple pObject) {

		System.out.println(pObject.toString());
		return pObject;
		
	} // Fin de create(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IContactSimple> initialiserListeContactSimples() {
		return InitialiseurDeData.getListePersonnes();
	} // Fin de initialiserListePersonnes()._______________________________



} // FIN DE LA CLASSE ContactSimpleService.---------------------------------------
