package levy.daniel.application.model.dao.metier.contactsimple.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;
import levy.daniel.application.model.persistence.metier.contactsimple.InitialiseurDeData;
import levy.daniel.application.model.persistence.metier.contactsimple.dao.jaxb.impl.ContactSimpleDaoJAXB;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ContactSimpleEntityJAXB;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ListeContactSimplesEntityJAXB;


/**
 * CLASSE ContactSimpleDaoJAXBTest :<br/>
 * Test JUnit de la classe ContactSimpleDaoJAXB.<br/>
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
 * @since 24 mai 2018
 *
 */
public class ContactSimpleDaoJAXBTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * dao : ContactSimpleDaoJAXB :<br/>
	 * DAO.<br/>
	 */
	private transient ContactSimpleDaoJAXB dao;
	
	/**
	 * <b>fichier xml dans lequel on enregistre les données en JAXB</b>.<br/>
	 * new File("./data/base-adresses_javafx-hsqldb/base-adresses_javafx-hsqldb.xml").<br/>
	 */
	public static final File FILE 
		= new File("./data/base-adresses_javafx-hsqldb/base-adresses_javafx-hsqldb.xml");
	
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleDaoJAXBTest.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR ContactSimpleDaoJAXBTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ContactSimpleDaoJAXBTest() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method testEnregistrer() :<br/>
	 * Teste la méthode enregistrer(ListeContactSimplesEntityJAXB, File).<br/>
	 * <ul>
	 * <li>garantit que enregistrer crée un fichier XML.</li>
	 * <li>garantit que le fichier XML existe.</li>
	 * <li>garantit que le fichier XML n'est pas vide.</li>
	 * </ul>
	 * 
	 * @throws JAXBException 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testEnregistrer() throws JAXBException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testEnregistrer() ********** ");
		}
		
		this.dao = new ContactSimpleDaoJAXB();
		
		final List<IContactSimple> contactsContactSimple 
			= InitialiseurDeData.getListeContactSimples();
		
		this.dao.enregistrer(contactsContactSimple, FILE);
		
		/* garantit que le fichier XML existe. */
		assertTrue("le fichier doit exister : ", FILE.exists());
		
		/* garantit que le fichier XML n'est pas vide. */
		assertTrue("le fichier ne doit pas être vide : ", FILE.length() > 0);
		
	} // Fin de testEnregistrer()._________________________________________


	
	
	/**
	 * method testRecupererListeModeles() :<br/>
	 * Teste la méthode recupererListeModeles(File).<br/>
	 * <ul>
	 * <li>garantit que recupererListeModeles crée la liste des MODEL.</li>
	 * <li>garantit que la liste des MODEL existe.</li>
	 * <li>garantit que la liste des MODEL n'est pas vide.</li>
	 * </ul>
	 *
	 * @throws JAXBException
	 * @throws FileNotFoundException :  :  .<br/>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testRecupererListeModeles() 
			throws JAXBException, FileNotFoundException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testRecupererListeModeles() ********** ");
		}
		
		this.dao = new ContactSimpleDaoJAXB();
		
		final List<IContactSimple> contactsContactSimple 
		= InitialiseurDeData.getListeContactSimples();
	
		/* enregistrement. */
		this.dao.enregistrer(contactsContactSimple, FILE);
		
		/* récupération. */
		final List<IContactSimple> contacts = this.dao.recupererListeModeles(FILE);
		
		/* garantit que la liste des MODEL existe.*/
		assertNotNull("la liste récupérée ne doit pas être null : "
				, contacts);
		
		/* garantit que la liste des MODEL n'est pas vide. */
		assertFalse("la liste récupérée ne doit pas être vide : "
				, contacts.isEmpty());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(this.dao.afficherListeContactSimple(contacts));
		}
				
	} // Fin de testRecupererListeModeles()._______________________________
	
	
	/**
	 * method testCreer() :<br/>
	 * Teste la méthode create(IContactSimple, File).<br/>
	 * <ul>
	 * <li>garantit que create rajoute la ContactSimple à la liste des MODEL.</li>
	 * </ul>
	 *
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testCreer() throws JAXBException, FileNotFoundException {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testCreer() ********** ");
		}
		
		this.dao = new ContactSimpleDaoJAXB();
		
		final List<IContactSimple> contactsContactSimple 
		= InitialiseurDeData.getListeContactSimples();
	
		/* enregistrement. */
		this.dao.enregistrer(contactsContactSimple, FILE);
		
		/* récupération. */
		final List<IContactSimple> contacts = this.dao.recupererListeModeles(FILE);
		
		final int tailleInitiale = contacts.size();

		/* ajout d'une IContactSimple. */
		final IContactSimple contactSimpleEnPlus 
			= new ContactSimple(2L
					, "Michael", "Caine"
					, "75, 5th Avenue", "NY", "New York"
					, LocalDate.of(1950, 2, 20));
		
		final IContactSimple contactSimpleCreee 
			= this.dao.create(contactSimpleEnPlus, FILE);
		
		/* récupération. */
		final List<IContactSimple> contactsFinaux = this.dao.recupererListeModeles(FILE);
		
		final int tailleFinale = contactsFinaux.size();
		
		/* garantit que create rajoute la ContactSimple à la liste des MODEL. */
		assertEquals("Taille finale vaut taille initiale + 1 : "
				, tailleFinale
					, tailleInitiale + 1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(contactSimpleCreee.toString());
		}
		
	} // Fin de testCreer()._______________________________________________
	
	
	
	/**
	 * method convertirListModelEnEntities(
	 * List&lt;IContactSimple&gt; pList) :<br/>
	 * convertit une Liste de ContactSimple en liste 
	 * de ContactSimpleEntityJAXB.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;
	 * 
	 * @return : List&lt;ContactSimpleEntityJAXB&gt;.<br/>
	 */
	private List<ContactSimpleEntityJAXB> convertirListModelEnEntities(
			final List<IContactSimple> pList) {
		
		if (pList == null) {
			return null;
		}
		
		final List<ContactSimpleEntityJAXB> resultat 
			= new ArrayList<ContactSimpleEntityJAXB>();
		
		for (final IContactSimple contactSimple : pList) {
			
			if (contactSimple != null) {
				
				final ContactSimpleEntityJAXB contactSimpleJAXB 
					= new ContactSimpleEntityJAXB(contactSimple);
				
				resultat.add(contactSimpleJAXB);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________
	


	/**
	 * Instancie une Entity JAXB ListeContactSimplesEntityJAXB à partir 
	 * d'une Liste de MODEL List&lt;IContactSimple&gt; pList.<br/>
	 * <ul>
	 * <li>retourne null si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IContactSimple&gt; : Liste de MODEL 
	 * à transformer en Entities JAXB en vue de la sérialization.<br/>
	 * 
	 * @return : ListeContactSimplesEntityJAXB : Entity serializable 
	 * sous forme de fichier XML.<br/>
	 */
	private ListeContactSimplesEntityJAXB creerEntityJAXB(
			final List<IContactSimple> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<ContactSimpleEntityJAXB> liste 
			= this.convertirListModelEnEntities(pList);
	
		final ListeContactSimplesEntityJAXB contacts 
			= new ListeContactSimplesEntityJAXB(liste);
		
		return contacts;
		
	} // Fin de creerEntityJAXB(...).______________________________________
	
	

} // FIN DE LA CLASSE ContactSimpleDaoJAXBTest.-----------------------------------
