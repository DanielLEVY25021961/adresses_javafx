package levy.daniel.application.model.dao.metier.personne.impl;

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

import levy.daniel.application.model.dao.metier.personne.InitialiseurDeData;
import levy.daniel.application.model.metier.personne.IPersonne;
import levy.daniel.application.model.metier.personne.impl.Personne;


/**
 * CLASSE PersonneDaoJAXBTest :<br/>
 * Test JUnit de la classe PersonneDaoJAXB.<br/>
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
public class PersonneDaoJAXBTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * dao : PersonneDaoJAXB :<br/>
	 * DAO.<br/>
	 */
	private transient PersonneDaoJAXB dao;
	
	/**
	 * FILE : File :<br/>
	 * new File("./data/contacts.xml").<br/>
	 */
	public static final File FILE = new File("./data/contacts.xml");
	
	
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
		= LogFactory.getLog(PersonneDaoJAXBTest.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR PersonneDaoJAXBTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public PersonneDaoJAXBTest() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method testEnregistrer() :<br/>
	 * Teste la méthode enregistrer(ContactsEntityJAXB, File).<br/>
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
			System.out.println("********** CLASSE PersonneDaoJAXBTest - méthode testEnregistrer() ********** ");
		}
		
		this.dao = new PersonneDaoJAXB();
		
		final List<IPersonne> contactsPersonne 
			= InitialiseurDeData.getListePersonnes();
		
		this.dao.enregistrer(contactsPersonne, FILE);
		
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
			System.out.println("********** CLASSE PersonneDaoJAXBTest - méthode testRecupererListeModeles() ********** ");
		}
		
		this.dao = new PersonneDaoJAXB();
		
		final List<IPersonne> contactsPersonne 
		= InitialiseurDeData.getListePersonnes();
	
		/* enregistrement. */
		this.dao.enregistrer(contactsPersonne, FILE);
		
		/* récupération. */
		final List<IPersonne> contacts = this.dao.recupererListeModeles(FILE);
		
		/* garantit que la liste des MODEL existe.*/
		assertNotNull("la liste récupérée ne doit pas être null : "
				, contacts);
		
		/* garantit que la liste des MODEL n'est pas vide. */
		assertFalse("la liste récupérée ne doit pas être vide : "
				, contacts.isEmpty());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(this.dao.afficherListePersonne(contacts));
		}
				
	} // Fin de testRecupererListeModeles()._______________________________
	
	
	/**
	 * method testCreer() :<br/>
	 * Teste la méthode create(IPersonne, File).<br/>
	 * <ul>
	 * <li>garantit que create rajoute la Personne à la liste des MODEL.</li>
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
			System.out.println("********** CLASSE PersonneDaoJAXBTest - méthode testCreer() ********** ");
		}
		
		this.dao = new PersonneDaoJAXB();
		
		final List<IPersonne> contactsPersonne 
		= InitialiseurDeData.getListePersonnes();
	
		/* enregistrement. */
		this.dao.enregistrer(contactsPersonne, FILE);
		
		/* récupération. */
		final List<IPersonne> contacts = this.dao.recupererListeModeles(FILE);
		
		final int tailleInitiale = contacts.size();

		/* ajout d'une IPersonne. */
		final IPersonne personneEnPlus 
			= new Personne(2L
					, "Michael", "Caine"
					, "75, 5th Avenue", "NY", "New York"
					, LocalDate.of(1950, 2, 20));
		
		final IPersonne personneCreee 
			= this.dao.create(personneEnPlus, FILE);
		
		/* récupération. */
		final List<IPersonne> contactsFinaux = this.dao.recupererListeModeles(FILE);
		
		final int tailleFinale = contactsFinaux.size();
		
		/* garantit que create rajoute la Personne à la liste des MODEL. */
		assertEquals("Taille finale vaut taille initiale + 1 : "
				, tailleFinale
					, tailleInitiale + 1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(personneCreee.toString());
		}
		
	} // Fin de testCreer()._______________________________________________
	
	
	
	/**
	 * method convertirListModelEnEntities(
	 * List&lt;IPersonne&gt; pList) :<br/>
	 * convertit une Liste de Personne en liste 
	 * de PersonneEntityJAXB.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IPersonne&gt;
	 * 
	 * @return : List&lt;PersonneEntityJAXB&gt;.<br/>
	 */
	private List<PersonneEntityJAXB> convertirListModelEnEntities(
			final List<IPersonne> pList) {
		
		if (pList == null) {
			return null;
		}
		
		final List<PersonneEntityJAXB> resultat 
			= new ArrayList<PersonneEntityJAXB>();
		
		for (final IPersonne personne : pList) {
			
			if (personne != null) {
				
				final PersonneEntityJAXB personneJAXB 
					= new PersonneEntityJAXB(personne);
				
				resultat.add(personneJAXB);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________
	


	/**
	 * Instancie une Entity JAXB ContactsEntityJAXB à partir 
	 * d'une Liste de MODEL List&lt;IPersonne&gt; pList.<br/>
	 * <ul>
	 * <li>retourne null si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IPersonne&gt; : Liste de MODEL 
	 * à transformer en Entities JAXB en vue de la sérialization.<br/>
	 * 
	 * @return : ContactsEntityJAXB : Entity serializable 
	 * sous forme de fichier XML.<br/>
	 */
	private ContactsEntityJAXB creerEntityJAXB(
			final List<IPersonne> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<PersonneEntityJAXB> liste 
			= this.convertirListModelEnEntities(pList);
	
		final ContactsEntityJAXB contacts 
			= new ContactsEntityJAXB(liste);
		
		return contacts;
		
	} // Fin de creerEntityJAXB(...).______________________________________
	
	

} // FIN DE LA CLASSE PersonneDaoJAXBTest.-----------------------------------
