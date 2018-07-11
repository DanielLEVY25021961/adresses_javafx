package levy.daniel.application.model.dao.metier.personne.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.personne.InitialiseurDeData;
import levy.daniel.application.model.metier.personne.IPersonne;


/**
 * CLASSE PersonneDaoJPATest :<br/>
 * Test JUnit de la classe PersonneDaoJPA.<br/>
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
public class PersonneDaoJPATest {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;


	/**
	 * dao : PersonneDaoJPA :<br/>
	 * DAO JPA.<br/>
	 */
	private final transient PersonneDaoJPA dao = new PersonneDaoJPA();
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(PersonneDaoJPATest.class);

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR PersonneDaoJPATest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public PersonneDaoJPATest() {
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
			System.out.println("********** CLASSE PersonneDaoJPATest - méthode testEnregistrer() ********** ");
		}
		

		final List<IPersonne> contactsPersonne 
			= InitialiseurDeData.getListePersonnes();
		
		/* Enregistrement de la liste en base. */
		final List<IPersonne> listepersonnes 
			= (List<IPersonne>) this.dao.save(contactsPersonne);
		
		/* garantit que la liste en base existe. */
		assertNotNull("la liste en base doit exister : ", listepersonnes);
		
		/* garantit que la liste en base n'est pas vide. */
		assertFalse("la liste en base ne doit pas être vide : ", listepersonnes.isEmpty());
		
	} // Fin de testEnregistrer()._________________________________________

	
	
} // FIN DE LA CLASSE PersonneDaoJPATest.------------------------------------
