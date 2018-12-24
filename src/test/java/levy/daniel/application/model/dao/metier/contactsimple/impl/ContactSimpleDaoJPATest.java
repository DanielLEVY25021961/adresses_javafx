package levy.daniel.application.model.dao.metier.contactsimple.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.persistence.metier.contactsimple.InitialiseurDeData;
import levy.daniel.application.model.persistence.metier.contactsimple.dao.jpa.impl.ContactSimpleDaoJPA;


/**
 * CLASSE ContactSimpleDaoJPATest :<br/>
 * Test JUnit de la classe ContactSimpleDaoJPA.<br/>
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
 * @since 26 mai 2018
 *
 */
@PersistenceContext(name="META-INF/persistence-test.xml")
public class ContactSimpleDaoJPATest {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;


	/**
	 * dao : ContactSimpleDaoJPA :<br/>
	 * DAO JPA.<br/>
	 */
	private final transient ContactSimpleDaoJPA dao = new ContactSimpleDaoJPA();
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleDaoJPATest.class);

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR ContactSimpleDaoJPATest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ContactSimpleDaoJPATest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	
	/**
	 * method testEnregistrer() :<br/>
	 * Teste la méthode save(Iterable).<br/>
	 * <ul>
	 * <li>garantit que save(Iterable) enregistre en base.</li>
	 * <li>garantit que la liste en base existe.</li>
	 * <li>garantit que la liste en base n'est pas vide.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testEnregistrer() throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testEnregistrer() ********** ");
		}
		

		final List<IContactSimple> contactsContactSimple 
			= InitialiseurDeData.getListeContactSimples();
		
		/* Enregistrement de la liste en base. */
		final List<IContactSimple> listecontactSimples 
			= (List<IContactSimple>) this.dao.save(contactsContactSimple);
		
		/* garantit que la liste en base existe. */
		assertNotNull("la liste en base doit exister : ", listecontactSimples);
		
		/* garantit que la liste en base n'est pas vide. */
		assertFalse("la liste en base ne doit pas être vide : ", listecontactSimples.isEmpty());
		
	} // Fin de testEnregistrer()._________________________________________

	
	
} // FIN DE LA CLASSE ContactSimpleDaoJPATest.------------------------------------
