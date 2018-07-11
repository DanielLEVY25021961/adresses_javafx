/**
 * 
 */
package levy.daniel.application.controllers.desktop.metier.personne.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.controllers.desktop.metier.personne.IPersonneController;
import levy.daniel.application.model.metier.personne.IPersonne;
import levy.daniel.application.model.metier.personne.impl.Personne;

/**
 * CLASSE PersonneControllerTest :<br/>
 * Test JUnit de la classe <b>PersonneController</b>.<br/>
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
public class PersonneControllerTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * personne1 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne1 
		= new Personne(
				"Zorro", "Halliday"
				, "2, rue de la Pompe", "73 850", "Chambéry"
				, LocalDate.of(1900, 2, 25));

	/**
	 * personne1 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne1Equals 
		= new Personne(
				"Zorro", "Halliday"
				, "17, rue de la Mélodie", "77 850", "Provins"
				, LocalDate.of(1900, 2, 25));
	
	/**
	 * personne2 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne2 
		= new Personne(
			"Papy", "Gonzales"
			, "7, avenue du Sentier", "75 008", "Paris"
			, LocalDate.of(1961, 2, 25));
	
	/**
	 * personne3 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne3 
		= new Personne(
			"Benito", "De la Roza"
			, "3, rue de la Pompe", "74 850", "Annecy"
			, LocalDate.of(2000, 2, 25));

	/**
	 * personne4 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne4 
		= new Personne(
			"Maléna", "Rozita"
			, "2, rue de la Pompe", "74 950", "Annecy-le-Vieux"
			, LocalDate.of(2000, 2, 25));
	
	/**
	 * personne5 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne5 
		= new Personne(
			"Concerto", "D'Aranjuez"
			, "2, rue de la Pompe", "73 850", "Chambéry"
			, LocalDate.of(2000, 2, 25));

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(PersonneControllerTest.class);
	
	
	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR PersonneControllerTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public PersonneControllerTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * teste les constructeurs d'arité nulle.<br/>
	 * garantit que :
	 * <ul>
	 * <li>les constructeurs d'arité nulle fonctionnent bien</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testConstructeurNull() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE PersonneControllerTest - méthode testConstructeurNull() ********** ");
		}
		
		final IPersonneController personneNull1 
			= new PersonneController(null);
		final IPersonneController personneNull2 
			= new PersonneController();
		
		assertEquals("personneNull1.equals(personneNull2)"
				, personneNull1
					, personneNull2);
		
		assertTrue("personneNull1.hashCode() == personneNull2.hashCode()"
				, personneNull1.hashCode() == personneNull2.hashCode());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(personneNull1.toString());
			System.out.println(personneNull2.toString());
		}

	} // Fin de testConstructeurNull().____________________________________


	
	/**
	 * method testEquals() :<br/>
	 * <ul>
	 * Teste la méthode <b>equals(Object pObj)</b> :
	 * <li>garantit le contrat Java reflexif x.equals(x).</li>
	 * <li>garantit le contrat Java symétrique 
	 * x.equals(y) ----> y.equals(x).</li>
	 * <li>garantit le contrat Java transitif 
	 * x.equals(y) et y.equals(z) ----> x.equals(z).</li>
	 * <li>garantit le contrat Java sur les hashcode 
	 * x.equals(y) ----> x.hashcode() == y.hashcode().</li>
	 * <li>garantit que les null sont bien gérés 
	 * dans equals(Object pObj).</li>
	 * <li>garantit que x.equals(null) retourne false 
	 * (avec x non null).</li>
	 * <li>garantit le bon fonctionnement de equals() 
	 * en cas d'égalité métier.</li>
	 * <li>garantit le bon fonctionnement de equals() 
	 * en cas d'inégalité métier.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testEquals() {
		
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE PersonneControllerTest - méthode testEquals() ********** ");
		}
		

		final IPersonneController objet1 
		= new PersonneController(this.personne1);
		
		final IPersonneController objet2 
		= new PersonneController(this.personne1Equals);
		
		final IPersonneController objet3 
		= new PersonneController(this.personne1);

		
		/* garantit le contrat Java reflexif x.equals(x). */
		assertEquals("x.equals(x) : "
				, objet1
					, objet1);
				
		/* garantit le contrat Java symétrique 
		 * x.equals(y) ----> y.equals(x). */
		assertEquals("objet1.equals(objet2) : "
				, objet2
					, objet1);
		
		/* garantit le contrat Java transitif 
		 * x.equals(y) et y.equals(z) ----> x.equals(z). */
		assertEquals("objet1.equals(objet2) : ", objet1, objet2);
		assertEquals("objet2.equals(objet3) : ", objet2, objet3);
		assertEquals("objet1.equals(objet3) : ", objet1, objet3);
		
		/* garantit le contrat Java sur les hashcode 
		 * x.equals(y) ----> x.hashcode() == y.hashcode(). */
		assertEquals("objet1.hashCode().equals(objet2.hashCode()) : "
				, objet1.hashCode()
					, objet2.hashCode());

				
		/* garantit que les null sont bien gérés dans equals(...). */
		final IPersonneController objetNull1 
			= new PersonneController();
		final IPersonneController objetNull2 
			= new PersonneController();

		assertEquals("objetNull1.equals(objetNull2) : "
				, objetNull1
					, objetNull2);
		assertEquals("objetNull1.hashCode().equals(objetNull2.hashCode()) : "
				, objetNull1.hashCode()
					, objetNull2.hashCode());

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("OBJETNULL1 : " 
					+ objetNull1.toString());
			System.out.println("OBJETNULL2 : " 
					+ objetNull2.toString());
		}
		
		final IPersonneController objet1AvecNull 
			= new PersonneController(null);
		
		final IPersonneController objet2AvecNull 
			= new PersonneController(null);

		assertEquals("objet1AvecNull.equals(objet2AvecNull) : "
				, objet1AvecNull
					, objet2AvecNull);
		assertEquals("objet1AvecNull.hashCode()"
				+ ".equals(objet2AvecNull.hashCode()) : "
				, objet1AvecNull.hashCode()
					, objet2AvecNull.hashCode());

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("OBJET1AVECNULL : " 
					+ objet1AvecNull.toString());
			System.out.println("OBJET2AVECNULL : " 
					+ objet2AvecNull.toString());
		}

		
		/* garantit que x.equals(null) retourne false (avec x non null). */
		assertNotNull("objet1 pas equals(null) : "
				, objet1);
				
		/* garantit le bon fonctionnement de equals() 
		 * en cas d'égalité métier. */
		assertEquals("objet1.equals(objet2) : "
				, objet1
					, objet2);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("OBJET1 : " 
					+ objet1.toString());
			System.out.println("OBJET2 : " 
					+ objet2.toString());
		}

		
		/* garantit le bon fonctionnement de equals() 
		 * en cas d'inégalité métier. */
		final IPersonneController objetDiff1 
			= new PersonneController(this.personne2);
		
		final IPersonneController objetDiff2 
			= new PersonneController(this.personne3);
		
		assertFalse("objetDiff1 PAS equals(objetDiff2) : "
				, objetDiff1.equals(objetDiff2));
		assertNotSame("objetDiff1.hashCode() "
				+ "PAS equals(objetDiff2.hashCode()) : "
				, objetDiff1.hashCode(), objetDiff2.hashCode());
		

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("OBJETDIFF1 : " 
					+ objetDiff1.toString());
			System.out.println("OBJETDIFF2 : " 
					+ objetDiff2.toString());
		}
		
	} // Fin de testEquals().______________________________________________



	/**
	 * method testCompareTo() :<br/>
	 * <ul>
	 * Teste la méthode <b>compareTo(CiviliteComplete pLoc)</b> :
	 * <li>garantit que compareTo(memeInstance) retourne 0.</li>
	 * <li>garantit que compareTo(null) retourne un nombre négatif.</li>
	 * <li>garantit le contrat Java Contrat Java : 
	 * x.equals(y) ---> x.compareTo(y) == 0.</li>
	 * <li>garantit que les null sont bien gérés 
	 * dans compareTo(CiviliteComplete pLoc).</li>
	 * <li>garantit le bon fonctionnement (bon ordre) de compareTo().</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testCompareTo() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE PersonneControllerTest - méthode testCompareTo() ********** ");
		}

		final IPersonneController objet1 
			= new PersonneController(this.personne1);
		
		final IPersonneController objet1MemeInstance = objet1;
		
		final IPersonneController objetEquals1 
			= new PersonneController(this.personne1Equals);
		
		final IPersonneController objetEquals2 
			= new PersonneController(this.personne1);

		final IPersonneController objetNull1 
		= new PersonneController();
	
		final IPersonneController objetNull2 
			= new PersonneController(null);
				
		final IPersonneController objetCompAvant1 
			= new PersonneController(this.personne3);

		final IPersonneController objetCompApres2 
			= new PersonneController(this.personne2);

	
		/* garantit que compareTo(memeInstance) retourne 0. */		
		final int compareMemeInstance 
			= objet1.compareTo(objet1MemeInstance);
		
		assertSame("compareTo(memeInstance) doit retourner 0 : "
				, compareMemeInstance, 0);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("COMPARETO() DE LA MEME INSTANCE : " 
					+ compareMemeInstance);
		}
		
		/* garantit que compareTo(null) retourne -1. */
		final int compareToNull = objet1.compareTo(null);
		
		assertTrue("compareTo(null) doit retourner négatif : "
				, compareToNull < 0);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("COMPARETO(null)  : " 
					+ compareToNull);
		}
		
		/* garantit le contrat Java Contrat Java : 
		 * x.equals(y) ---> x.compareTo(y) == 0. */		
		final int compareToEquals = objetEquals1.compareTo(objetEquals2);

		assertSame("Instance.compareTo(equalsInstance) doit retourner 0 : "
				, compareToEquals, 0);
		assertTrue("loc10.hashCode() == loc11.hashCode() : "
				, objetEquals1.hashCode() == objetEquals2.hashCode());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("COMPARETO(equalsInstance)  : " 
					+ compareToEquals);
		}
		
		
		/* garantit que les null sont bien gérés dans 
		 * compareTo(CiviliteComplete pLoc). */		
		final int compareToEqualsNull = objetNull1.compareTo(objetNull2);
		
		assertSame("InstanceNull.compareTo(equalsInstanceNull) doit retourner 0 : "
				, compareToEqualsNull, 0);
		assertTrue("locNull10.hashCode() == locNull11.hashCode() : "
				, objetNull1.hashCode() == objetNull2.hashCode());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("COMPARETO(equalsInstanceNull)  : " 
					+ compareToEqualsNull);
		}

		
		/* garantit le bon fonctionnement (bon ordre) de compareTo(). */		
		final int compare = objetCompAvant1.compareTo(objetCompApres2);
		
		assertTrue("objetCompAvant1 doit être avant objetCompApres2 : "
				, compare < 0);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("COMPARETO(existant)  : " 
					+ compare);
		}
		
	} // Fin de testCompareTo().___________________________________________
	



} // FIN DE LA CLASSE PersonneControllerTest.--------------------------------
