package levy.daniel.application.model.persistence.metier.contactsimple.dao.jaxb.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.persistence.metier.contactsimple.InitialiseurDeData;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ContactSimpleEntityJAXB;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ListeContactSimplesEntityJAXB;


/**
 * CLASSE ContactSimpleDaoJAXBTest :<br/>
 * Test JUnit de la classe ContactSimpleDaoJAXB.<br/>
 * TEST DE DAO.<br/>
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
	 * DAO.<br/>
	 */
	private static transient ContactSimpleDaoJAXB dao;

	/**
	 * "nomTest".<br/>
	 */
	public static final String NOMTEST = "nomTest";
					
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;
	
	/**
	 * "unused".<br/>
	 */
	public static final String UNUSED = "unused";
	
	/**
	 * "testCreateNull()".<br/>
	 */
	public static final String TEST_CREATE_NULL 
		= "testCreateNull()";
	
	/**
	 * "testCreate()".<br/>
	 */
	public static final String TEST_CREATE 
		= "testCreate()";
	
	/**
	 * "testCreateDoublon()".<br/>
	 */
	public static final String TEST_CREATE_DOUBLON 
		= "testCreateDoublon()";
	
	/**
	 * "testPersistNull()".<br/>
	 */
	public static final String TEST_PERSIST_NULL 
		= "testPersistNull()";
	
	/**
	 * "testPersist()".<br/>
	 */
	public static final String TEST_PERSIST 
		= "testPersist()";
	
	/**
	 * "testPersistDoublon()".<br/>
	 */
	public static final String TEST_PERSIST_DOUBLON 
	= "testPersistDoublon()";
	
	/**
	 * "testCreateReturnIdNull()".<br/>
	 */
	public static final String TEST_CREATERETURNID_NULL 
		= "testCreateReturnIdNull()";
	
	/**
	 * "testCreateReturnId()".<br/>
	 */
	public static final String TEST_CREATERETURNID 
		= "testCreateReturnId()";
	
	/**
	 * "testCreateReturnIdDoublon()".<br/>
	 */
	public static final String TEST_CREATERETURNID_DOUBLON 
		= "testCreateReturnIdDoublon()";
	
	/**
	 * "testSaveNull()".<br/>
	 */
	public static final String TEST_SAVE_NULL 
		= "testSaveNull()";

	/**
	 * testSaveObjetsNull().
	 */
	public static final String TEST_SAVE_OBJETS_NULL 
		= "testSaveObjetsNull()";

	/**
	 * "testSave()".<br/>
	 */
	public static final String TEST_SAVE 
		= "testSave()";
		
	/**
	 * "testSaveDoublon()".<br/>
	 */
	public static final String TEST_SAVE_DOUBLON 
		= "testSaveDoublon()";
	
	/**
	 * "testRetrieveNull()".<br/>
	 */
	public static final String TEST_RETRIEVE_NULL 
		= "testRetrieveNull()";

	
	/**
	 * "testRetrieveObjetNull()".<br/>
	 */
	public static final String TEST_RETRIEVE_OBJET_NULL 
		= "testRetrieveObjetNull()";

	/**
	 * "testRetrieveInexistant()".<br/>
	 */
	public static final String TEST_RETRIEVE_INEXISTANT 
		= "testRetrieveInexistant()";
	
	/**
	 * "testRetrieve()".<br/>
	 */
	public static final String TEST_RETRIEVE 
		= "testRetrieve()";

	/**
	 * "testFindByIdNull()".<br/>
	 */
	public static final String TEST_FINDBYID_NULL 
		= "testFindByIdNull()";

	/**
	 * "testFindByIdInexistant()".<br/>
	 */
	public static final String TEST_FINDBYID_INEXISTANT 
		= "testFindByIdInexistant()";

	/**
	 * "testFindById()".<br/>
	 */
	public static final String TEST_FINDBYID 
		= "testFindById()";
	
	/**
	 * "testRetrieveIdNull()".<br/>
	 */
	public static final String TEST_RETRIEVEID_NULL 
		= "testRetrieveIdNull()";

	
	/**
	 * "testRetrieveIdObjetNull()".<br/>
	 */
	public static final String TEST_RETRIEVEID_OBJET_NULL 
		= "testRetrieveIdObjetNull()";

	/**
	 * "testRetrieveIdInexistant()".<br/>
	 */
	public static final String TEST_RETRIEVEID_INEXISTANT 
		= "testRetrieveIdInexistant()";
	
	/**
	 * "testRetrieveId()".<br/>
	 */
	public static final String TEST_RETRIEVEID 
		= "testRetrieveId()";
	
	/**
	 * "testFindAll()".<br/>
	 */
	public static final String TEST_FINDALL 
		= "testFindAll()";
	
	/**
	 * "testFindAllMax()".<br/>
	 */
	public static final String TEST_FINDALLMAX 
		= "testFindAllMax()";
		
	/**
	 * "testFindAllIterable()".<br/>
	 */
	public static final String TEST_FINDALLITERABLE 
		= "testFindAllIterable()";
		
	/**
	 * "testUpdateInexistant()".<br/>
	 */
	public static final String TEST_UPDATE_INEXISTANT 
		= "testUpdateInexistant()";
		
	/**
	 * "testUpdate()".<br/>
	 */
	public static final String TEST_UPDATE 
		= "testUpdate()";
	
	/**
	 * "testDeleteInexistant()".<br/>
	 */
	public static final String TEST_DELETE_INEXISTANT 
		= "testDeleteInexistant()";
	
	/**
	 * "testDelete()".<br/>
	 */
	public static final String TEST_DELETE 
		= "testDelete()";
		
	/**
	 * "testDeleteByIdInexistant()".<br/>
	 */
	public static final String TEST_DELETEBYID_INEXISTANT 
		= "testDeleteByIdInexistant()";
		
	/**
	 * "testDeleteById()".<br/>
	 */
	public static final String TEST_DELETEBYID 
		= "testDeleteById()";
	
	/**
	 * "testDeleteByIdBooleanInexistant()".<br/>
	 */
	public static final String TEST_DELETEBYIDBOOLEAN_INEXISTANT 
		= "testDeleteByIdBooleanInexistant()";
		
	/**
	 * "testDeleteByIdBoolean()".<br/>
	 */
	public static final String TEST_DELETEBYIDBOOLEAN 
		= "testDeleteByIdBoolean()";
	
	
	/**
	 * TIRETS : String :<br/>
	 * "--------------------------------------------------------".<br/>
	 */
	public static final String TIRETS 
	= "--------------------------------------------------------";

	
	/**
	 * NBRE_OBJET_INITIAL : String :<br/>
	 * "NOMBRE D'OBJETS INITIALEMENT dans le stockage : ".<br/>
	 */
	public static final String NBRE_OBJET_INITIAL 
		= "NOMBRE D'OBJETS INITIALEMENT dans le stockage : ";
	
		
	/**
	 * "nombreObjetsFinal doit valoir ".<br/>
	 */
	public static final String NBRE_OBJETS_FINAL_DOIT 
		= "nombreObjetsFinal doit valoir ";
	
	
	/**
	 * "nombreObjetsinitial + 0 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_ZERO 
		= "nombreObjetsinitial + 0 : ";
	
	
	/**
	 * "nombreObjetsinitial + 1 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_UN 
		= "nombreObjetsinitial + 1 : ";

	
	/**
	 * "nombreObjetsinitial + 2 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_DEUX 
		= "nombreObjetsinitial + 2 : ";

	
	/**
	 * "nombreObjetsinitial + 3 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_TROIS 
	= "nombreObjetsinitial + 3 : ";
	
	/**
	 * "nombreObjetsinitial + 4 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_QUATRE 
	= "nombreObjetsinitial + 4 : ";


	/**
	 * "OBJET1 NON PERSISTANT : ".<br/>
	 */
	public static final String OBJET1_NON_PERSISTANT 
		= "OBJET1 NON PERSISTANT : ";
	
	/**
	 * "OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : ".<br/>
	 */
	public static final String OBJET2_NON_PERSISTANT_DOUBLON1 
		= "OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : ";
		
	/**
	 * "LOT D'OBJETS INITIALEMENT dans le stockage : ".<br/>
	 */
	public static final String LOT_OBJET_INITIAL 
	= "LOT D'OBJETS INITIALEMENT dans le stockage : ";
	
	/**
	 * "LOT D'OBJETS dans le stockage APRES DELETE : ".<br/>
	 */
	public static final String LOT_OBJETS_APRES_DELETE 
		= "LOT D'OBJETS dans le stockage APRES DELETE : ";
	
	/**
	 * saut de ligne de la plateforme.<br/>
	 */
	public static final String SAUT_LIGNE_PLATEFORME 
		= System.getProperty("line.separator");


	/**
	 * "France".<br/>
	 */
	public static final String FRANCE = "France";


	 /**
	 * objet CORRECT à créer dans le stockage 
	 * pour la méthode remplirStockage() .<br/>
	 * Ne doit pas causer de doublon
	 */
	public static transient IContactSimple objetRemplirStockage1 
		= new ContactSimple(
			"Horace", "Silver"
			, "17, rue de la Plomberie"
			, null
			, "73 698", "Chambéry"
			, FRANCE
			, "04 79 85 54 63"
			, "horace.silver@free.fr"
			, LocalDate.of(1950, 1, 17));
	
	 /**
	 * objet CORRECT à créer dans le stockage 
	 * pour la méthode remplirStockage() .<br/>
	 * Ne doit pas causer de doublon
	 */
	public static transient IContactSimple objetRemplirStockage2 
		= new ContactSimple(
			"Johnny", "Halliday"
			, "7, avenue des Zozos"
			, "Bâtiment les Etoiles"
			, "75 001", "Paris"
			, FRANCE
			, "01 44 85 54 63"
			, "johnny.halliday@free.fr"
			, LocalDate.of(1952, 7, 22));

	 /**
	 * objet CORRECT à créer dans le stockage 
	 * pour la méthode remplirStockage() .<br/>
	 * Ne doit pas causer de doublon
	 */
	public static transient IContactSimple objetRemplirStockage3 
	= new ContactSimple(
			"Papy", "Gonzales"
			, "rue3"
			, "complément rue3"
			, "cp3", "ville3"
			, "USA"
			, "00 33 (1) 585 54 63"
			, "papy.gonzales@aol.com"
			, LocalDate.of(2018, 5, 3));

	 /**
	 * objet CORRECT à créer dans le stockage 
	 * pour la méthode remplirStockage() .<br/>
	 * Ne doit pas causer de doublon
	 */
	public static transient IContactSimple objetRemplirStockage4 
		= new ContactSimple(
				"Zorro", "Démoniaque"
				, "rue4"
				, null
				, "cp4", "ville4"
				, "Angleterre"
				, "00 33 (3) 472 54 63"
				, "zorro.demoniac@british.com"
				, LocalDate.of(2018, 5, 4));
	
	/**
	 * objet CORRECT à créer dans le stockage 
	 * pour les tests creation.<br/>
	 * Ne doit pas causer de doublon
	 */
	public static transient IContactSimple objetACreer1 
		= new ContactSimple(
			"Michael", "Caine"
			, "75, 5th Avenue"
			, null
			, "NY", "New York"
			, "USA"
			, "00 33 322 56 98"
			, "michael.caine@aol.com"
			, LocalDate.of(1950, 2, 20));
	
	/**
	 * objet CORRECT à créer dans le stockage 
	 * pour les tests creation.<br/>
	 * Ne doit pas causer de doublon
	 */
	public static transient IContactSimple objetACreer2 
		= new ContactSimple(
			"Steve", "McQueen"
			, "107, 15th Avenue"
			, "Greenwich"
			, "SF", "San Fransisco"
			, "USA"
			, "00 31 344 56 98"
			, "steve.mcqueen@aol.com"
			, LocalDate.of(1947, 7, 27));
	
	/**
	 * objet1, objet2EqualsObj1, objet3EqualsObj1 doivent être equals().
	 */
	public static transient IContactSimple objet1 
		= new ContactSimple(1L, "prenomTest", NOMTEST
				, "17, rue des Acacias"
				, "Bâtiment 57, appartement 22"
				, "75013", "Paris"
				, "France"
				, "06 60 52 44 89"
				, "test@free.fr"
				, fournirLocalDate("05/01/1976"));
	
	/**
	 * objet1MemeInstance doit être la même instance que objet1.<br/>
	 */
	public static transient IContactSimple objet1MemeInstance = objet1;
	
	/**
	 * objet1, objet2EqualsObj1, objet3EqualsObj1 doivent être equals().
	 */
	public static transient IContactSimple objet2EqualsObj1 
		=  new ContactSimple(2L, "prenomTest", NOMTEST
				, "172, rue des Acacias"
				, "Bâtiment 572, appartement 22"
				, "75014", "Paris2"
				, "France2"
				, "06 60 52 44 90"
				, "test@free.fr"
				, fournirLocalDate("05/01/1976"));
	
	/**
	 * objet1, objet2EqualsObj1, objet3EqualsObj1 doivent être equals().
	 */
	public static transient IContactSimple objet3EqualsObj1 
		= new ContactSimple(3L, "prenomTest", NOMTEST
				, "174, rue des Acacias"
				, "Bâtiment 573, appartement 22"
				, "75015", "Paris3"
				, "France3"
				, "06 60 52 44 91"
				, "test@free.fr"
				, fournirLocalDate("05/01/1976"));

	/**
	 * objetNull1 et objetNull2 doivent être instanciés 
	 * avec le constructeur d'arité nulle ou avoir 
	 * tous les attributs aux valeurs par défaut.
	 */
	public static transient IContactSimple objetNull1 
		= new ContactSimple(null, null
				, null
				, null
				, null, null
				, null
				, null
				, null
				, null);
	
	/**
	 * objetNull1 et objetNull2 doivent être instanciés 
	 * avec le constructeur d'arité nulle ou avoir 
	 * tous les attributs aux valeurs par défaut.
	 */
	public static transient IContactSimple objetNull2 
		= new ContactSimple();

	/**
	 * Objet Inexistant dans le stockage.
	 */
	public static transient IContactSimple objetInexistant 
	= new ContactSimple("prenomInexistant", "nomInexistant"
			, "rue1Inexistant"
			, "rue2Inexistant"
			, "codePostalInexistant", "villeInexistant"
			, "Pays inexistant"
			, "telephone inexistant"
			, "mail inexistant"
			, LocalDate.of(1940, 9, 3));

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleDaoJAXBTest.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ContactSimpleDaoJAXBTest() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	


	/**
	 * Teste la méthode <b>create(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que create(null) ne stocke rien.</li>
	 * <li>garantit que create(null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreateNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testCreateNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_CREATE_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final IContactSimple objetVraimentNull1 = null;
		IContactSimple objetVraimentNull1Persistant = null;
						
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			this.afficherNbreObjetsInitial(nombreObjetsInitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objetVraimentNull1Persistant = dao.create(objetVraimentNull1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherObjetPersistant(
						objetVraimentNull1Persistant, nombreObjetsFinal);						
			}
			
			/* garantit que create(null) retourne null. */
			assertNull(
					"create(null) doit retourner null : "
						, objetVraimentNull1Persistant);
			
			/* garantit que create(null) ne stocke rien. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsInitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATE_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testCreateNull().__________________________________________
	

	
	/**
	 * Teste la méthode <b>create(objetNull)</b>.<br/>
	 * <ul>
	 * <li>garantit que create(objetNull) ne stocke rien .</li>
	 * <li>garantit que create(objetNull) retourne null.</li>
	 * <li>objetNull est un objet avec les valeurs obligatoires à null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreateObjetNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testCreateObjetNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_CREATE_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		IContactSimple objetNull1Persistant = null;
		IContactSimple objetNull2Persistant = null;
						
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			this.afficherNbreObjetsInitial(nombreObjetsInitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objetNull1Persistant = dao.create(objetNull1);
			objetNull2Persistant = dao.create(objetNull2);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println("OBJET METIER AVEC ATTRIBUTS NULL objetNull1 : " + objetNull1.toString());
				
				if (objetNull1Persistant != null) {
					System.out.println("OBJET PERSISTANT objetNull1Persistant : " + objetNull1Persistant.toString());
				} else {
					System.out.println("OBJET PERSISTANT objetNull1Persistant : null");
				}
				
				System.out.println("OBJET METIER AVEC ATTRIBUTS NULL objetNull2 : " + objetNull2.toString());
				
				if (objetNull1Persistant != null) {
					System.out.println("OBJET PERSISTANT objetNull2Persistant : " + objetNull2Persistant.toString());
				} else {
					System.out.println("OBJET PERSISTANT objetNull2Persistant : null");
				}
				
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
				
			}
			
			/* garantit que create(objetNull) retourne null. */
			assertNull(
					"create(objetNull) doit retourner null : "
						, objetNull1Persistant);

			/* garantit que create(objetNull) ne stocke rien. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsInitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATE_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testCreateNull().__________________________________________
	

		
	/**
	 * Teste la méthode create(Objet Metier).<br/>
	 * <ul>
	 * <li>garantit que create(objet correct) 
	 * rajoute l'objet métier dans le stockage.</li>
	 * <li>garantit que create(objet correct) retourne l'objet persisté.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testCreate() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testCreate() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_CREATE);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT CREATE : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		try {
			
			/* ********************************************************* */
			/* ***********************CREATION************************** */		
			final IContactSimple objetPersiste1 = dao.create(objetACreer1);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("OBJET CREE : " + objetPersiste1.toString());
			}
			
			/* garantit que create(...) retourne l'objet persisté. */
			assertNotNull(
					"l'objet persisté retourne par create(...) ne doit pas être null : "
						, objetPersiste1);
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES CREATE : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
						
			/* garantit que create rajoute l'objet métier dans le stockage. */
			assertEquals("nombreObjetsFinal vaut nombreObjetsInitial + 1 : "
					, nombreObjetsFinal
						, Long.valueOf(nombreObjetsInitial + 1));

			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATE);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
				
	} // Fin de testCreate().______________________________________________
	

	
	/**
	 * Teste la méthode create(Doublon).<br/>
	 * <ul>
	 * <li>garantit que create(Doublon) ne rajoute rien dans le stockage.</li>
	 * <li>garantit que create(Doublon) retourne null.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testCreateDoublon() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testCreateDoublon() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_CREATE_DOUBLON);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		IContactSimple objet1Persistant = null;
		IContactSimple objet1MemeInstancePersistant = null;
		IContactSimple objet2EqualsObjet1Persistant = null;
		IContactSimple objet3EqualsObjet1Persistant = null;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT CREATE DOUBLON : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
			
			System.out.println();
			System.out.println("LISTE D'OBJETS METIER A CREER : ");
			System.out.println("objet1 : " + objet1.toString());
			System.out.println("objet1MemeInstance : " + objet1MemeInstance.toString());
			System.out.println("objet2EqualsObj1 : " + objet2EqualsObj1.toString());
			System.out.println("objet3EqualsObj1 : " + objet3EqualsObj1.toString());
		}
		
		try {
			
			/* ********************************************************* */
			/* ***********************CREATION************************** */		
			objet1Persistant = dao.create(objet1);
			objet1MemeInstancePersistant = dao.create(objet1MemeInstance);
			objet2EqualsObjet1Persistant = dao.create(objet2EqualsObj1);
			objet3EqualsObjet1Persistant = dao.create(objet3EqualsObj1);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				
				if (objet1Persistant != null) {
					System.out.println("OBJET CREE objet1Persistant : " + objet1Persistant.toString());
				} else {
					System.out.println("OBJET CREE objet1Persistant : NULL");
				}
				
				if (objet1MemeInstancePersistant != null) {
					System.out.println("OBJET CREE objet1MemeInstancePersistant : " + objet1MemeInstancePersistant.toString());
				} else {
					System.out.println("OBJET CREE objet1MemeInstancePersistant : NULL");
				}
				
				if (objet2EqualsObjet1Persistant != null) {
					System.out.println("OBJET CREE objet2EqualsObjet1Persistant : " + objet2EqualsObjet1Persistant.toString());
				} else {
					System.out.println("OBJET CREE objet2EqualsObjet1Persistant : NULL");
				}
				
				if (objet3EqualsObjet1Persistant != null) {
					System.out.println("OBJET CREE objet3EqualsObjet1Persistant : " + objet3EqualsObjet1Persistant.toString());
				} else {
					System.out.println("OBJET CREE objet3EqualsObjet1Persistant : NULL");
				}
				
			}
			
			/* garantit que create(...) retourne l'objet persisté. */
			assertNotNull(
					"l'objet persisté retourne par create(...) ne doit pas être null : "
						, objet1Persistant);
			
			/* garantit que create(Doublon) retourne null. */
			assertNull(
					"create(doublon) doit retourner null : "
						, objet1MemeInstancePersistant);
			
			/* garantit que create(Doublon) retourne null. */
			assertNull(
					"create(doublon) doit retourner null : "
						, objet2EqualsObjet1Persistant);
			
			/* garantit que create(Doublon) retourne null. */
			assertNull(
					"create(doublon) doit retourner null : "
						, objet3EqualsObjet1Persistant);
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES CREATE : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
						
			/* garantit que create rajoute l'objet métier dans le stockage. */
			/* garantit que create(Doublon) ne rajoute rien dans le stockage. */
			assertEquals("nombreObjetsFinal vaut nombreObjetsInitial + 1 : "
					, nombreObjetsFinal
						, Long.valueOf(nombreObjetsInitial + 1));

			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATE);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}

	} // Fin de testCreateDoublon()._______________________________________
	


	/**
	 * Teste la méthode <b>persist(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que persist(null) ne stocke rien.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testPersistNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testPersistNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_PERSIST_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final IContactSimple objetVraimentNull1 = null;
						
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			this.afficherNbreObjetsInitial(nombreObjetsInitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			dao.persist(objetVraimentNull1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherNbreObjetsFinal(nombreObjetsFinal);			
			}
			
			/* garantit que persist(null) ne stocke rien. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsInitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_PERSIST_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testPersistNull().__________________________________________
	

	
	/**
	 * Teste la méthode <b>persist(objetNull)</b>.<br/>
	 * <ul>
	 * <li>garantit que persist(objetNull) ne stocke rien .</li>
	 * <li>objetNull est un objet avec les valeurs obligatoires à null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testPersistObjetNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testPersistObjetNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_PERSIST_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			this.afficherNbreObjetsInitial(nombreObjetsInitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			dao.persist(objetNull1);
			dao.persist(objetNull2);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println("OBJET METIER AVEC ATTRIBUTS NULL objetNull1 : " + objetNull1.toString());
								
				System.out.println("OBJET METIER AVEC ATTRIBUTS NULL objetNull2 : " + objetNull2.toString());
								
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
				
			}
			
			/* garantit que persist(objetNull) ne stocke rien. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsInitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_PERSIST_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testPersistNull().__________________________________________
	

		
	/**
	 * Teste la méthode persist(Objet Metier).<br/>
	 * <ul>
	 * <li>garantit que persist(objet correct) 
	 * rajoute l'objet métier dans le stockage.</li>
	 * <li>garantit que persist(objet correct) retourne l'objet persisté.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testPersist() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testPersist() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_PERSIST);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT PERSIST : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		try {
			
			/* ********************************************************* */
			/* ***********************CREATION************************** */		
			dao.persist(objetACreer1);
			/* ********************************************************* */
						
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES PERSIST : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
						
			/* garantit que persist rajoute l'objet métier dans le stockage. */
			assertEquals("nombreObjetsFinal vaut nombreObjetsInitial + 1 : "
					, nombreObjetsFinal
						, Long.valueOf(nombreObjetsInitial + 1));

			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_PERSIST);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
				
	} // Fin de testPersist().______________________________________________
	

	
	/**
	 * Teste la méthode persist(Doublon).<br/>
	 * <ul>
	 * <li>garantit que persist(Doublon) ne rajoute rien dans le stockage.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testPersistDoublon() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testPersistDoublon() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_PERSIST_DOUBLON);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT PERSIST DOUBLON : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
			
			System.out.println();
			System.out.println("LISTE D'OBJETS METIER A CREER : ");
			System.out.println("objet1 : " + objet1.toString());
			System.out.println("objet1MemeInstance : " + objet1MemeInstance.toString());
			System.out.println("objet2EqualsObj1 : " + objet2EqualsObj1.toString());
			System.out.println("objet3EqualsObj1 : " + objet3EqualsObj1.toString());
		}
		
		try {
			
			/* ********************************************************* */
			/* ***********************CREATION************************** */		
			dao.persist(objet1);
			dao.persist(objet1MemeInstance);
			dao.persist(objet2EqualsObj1);
			dao.persist(objet3EqualsObj1);
			/* ********************************************************* */
									
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES PERSIST : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
						
			/* garantit que persist rajoute l'objet métier dans le stockage. */
			/* garantit que persist(Doublon) ne rajoute rien dans le stockage. */
			assertEquals("nombreObjetsFinal vaut nombreObjetsInitial + 1 : "
					, nombreObjetsFinal
						, Long.valueOf(nombreObjetsInitial + 1));

			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_PERSIST);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}

	} // Fin de testPersistDoublon()._______________________________________
	


	/**
	 * Teste la méthode <b>createReturnId(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que createReturnId(null) ne stocke rien.</li>
	 * <li>garantit que createReturnId(null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreateReturnIdNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testCreateReturnIdNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_CREATERETURNID_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final IContactSimple objetVraimentNull1 = null;
		Long objetVraimentNull1PersistantId = null;
						
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			this.afficherNbreObjetsInitial(nombreObjetsInitial);		
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objetVraimentNull1PersistantId = dao.createReturnId(objetVraimentNull1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherNbreObjetsFinal(nombreObjetsFinal);					
			}
			
			/* garantit que createReturnId(null) retourne null. */
			assertNull(
					"createReturnId(null) doit retourner null : "
						, objetVraimentNull1PersistantId);
			
			/* garantit que createReturnId(null) ne stocke rien. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsInitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATERETURNID_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testCreateReturnIdNull().__________________________________________
	

	
	/**
	 * Teste la méthode <b>createReturnId(objetNull)</b>.<br/>
	 * <ul>
	 * <li>garantit que createReturnId(objetNull) ne stocke rien .</li>
	 * <li>garantit que createReturnId(objetNull) retourne null.</li>
	 * <li>objetNull est un objet avec les valeurs obligatoires à null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreateReturnIdObjetNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testCreateReturnIdObjetNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_CREATERETURNID_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Long objetNull1PersistantId = null;
		Long objetNull2PersistantId = null;
						
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			this.afficherNbreObjetsInitial(nombreObjetsInitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objetNull1PersistantId = dao.createReturnId(objetNull1);
			objetNull2PersistantId = dao.createReturnId(objetNull2);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println("OBJET METIER AVEC ATTRIBUTS NULL objetNull1 : " + objetNull1.toString());
				
				if (objetNull1PersistantId != null) {
					System.out.println("ID OBJET PERSISTANT objetNull1Persistant : " + objetNull1PersistantId.toString());
				} else {
					System.out.println("ID OBJET PERSISTANT objetNull1Persistant : null");
				}
				
				System.out.println("OBJET METIER AVEC ATTRIBUTS NULL objetNull2 : " + objetNull2.toString());
				
				if (objetNull1PersistantId != null) {
					System.out.println("ID OBJET PERSISTANT objetNull2Persistant : " + objetNull2PersistantId.toString());
				} else {
					System.out.println("ID OBJET PERSISTANT objetNull2Persistant : null");
				}
				
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
				
			}
			
			/* garantit que createReturnId(objetNull) retourne null. */
			assertNull(
					"createReturnId(objetNull) doit retourner null : "
						, objetNull1PersistantId);

			/* garantit que createReturnId(objetNull) ne stocke rien. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsInitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATERETURNID_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testCreateReturnIdNull().__________________________________________
	

		
	/**
	 * Teste la méthode createReturnId(Objet Metier).<br/>
	 * <ul>
	 * <li>garantit que createReturnId(objet correct) 
	 * rajoute l'objet métier dans le stockage.</li>
	 * <li>garantit que createReturnId(objet correct) retourne 
	 * l'ID de l'objet persisté.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testCreateReturnId() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testCreateReturnId() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_CREATERETURNID);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT CREATE : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		try {
			
			/* ********************************************************* */
			/* ***********************CREATION************************** */		
			final Long objetPersiste1Id = dao.createReturnId(objetACreer1);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("ID de l'OBJET CREE : " + objetPersiste1Id.toString());
			}
			
			/* garantit que createReturnId(...) retourne l'objet persisté. */
			assertNotNull(
					"l'ID de l'objet persisté retourne par createReturnId(...) ne doit pas être null : "
						, objetPersiste1Id);
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES CREATE : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
						
			/* garantit que createReturnId rajoute l'objet métier dans le stockage. */
			assertEquals("nombreObjetsFinal vaut nombreObjetsInitial + 1 : "
					, nombreObjetsFinal
						, Long.valueOf(nombreObjetsInitial + 1));

			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATERETURNID);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
				
	} // Fin de testCreateReturnId().______________________________________________
	

	
	/**
	 * Teste la méthode createReturnId(Doublon).<br/>
	 * <ul>
	 * <li>garantit que createReturnId(Doublon) ne rajoute rien dans le stockage.</li>
	 * <li>garantit que createReturnId(Doublon) retourne null.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testCreateReturnIdDoublon() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testCreateReturnIdDoublon() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_CREATERETURNID_DOUBLON);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Long objet1PersistantId = null;
		Long objet1MemeInstancePersistantId = null;
		Long objet2EqualsObjet1PersistantId = null;
		Long objet3EqualsObjet1PersistantId = null;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT CREATE DOUBLON : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
			
			System.out.println();
			System.out.println("LISTE D'OBJETS METIER A CREER : ");
			System.out.println("objet1 : " + objet1.toString());
			System.out.println("objet1MemeInstance : " + objet1MemeInstance.toString());
			System.out.println("objet2EqualsObj1 : " + objet2EqualsObj1.toString());
			System.out.println("objet3EqualsObj1 : " + objet3EqualsObj1.toString());
		}
		
		try {
			
			/* ********************************************************* */
			/* ***********************CREATION************************** */		
			objet1PersistantId = dao.createReturnId(objet1);
			objet1MemeInstancePersistantId = dao.createReturnId(objet1MemeInstance);
			objet2EqualsObjet1PersistantId = dao.createReturnId(objet2EqualsObj1);
			objet3EqualsObjet1PersistantId = dao.createReturnId(objet3EqualsObj1);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				
				if (objet1PersistantId != null) {
					System.out.println("ID OBJET CREE objet1Persistant : " + objet1PersistantId.toString());
				} else {
					System.out.println("ID OBJET CREE objet1Persistant : NULL");
				}
				
				if (objet1MemeInstancePersistantId != null) {
					System.out.println("ID OBJET CREE objet1MemeInstancePersistant : " + objet1MemeInstancePersistantId.toString());
				} else {
					System.out.println("ID OBJET CREE objet1MemeInstancePersistant : NULL");
				}
				
				if (objet2EqualsObjet1PersistantId != null) {
					System.out.println("ID OBJET CREE objet2EqualsObjet1Persistant : " + objet2EqualsObjet1PersistantId.toString());
				} else {
					System.out.println("ID OBJET CREE objet2EqualsObjet1Persistant : NULL");
				}
				
				if (objet3EqualsObjet1PersistantId != null) {
					System.out.println("ID OBJET CREE objet3EqualsObjet1Persistant : " + objet3EqualsObjet1PersistantId.toString());
				} else {
					System.out.println("ID OBJET CREE objet3EqualsObjet1Persistant : NULL");
				}
				
			}
			
			/* garantit que createReturnId(...) retourne l'objet persisté. */
			assertNotNull(
					"ID de l'objet persisté retourne par createReturnId(...) ne doit pas être null : "
						, objet1PersistantId);
			
			assertEquals(
					"ID de l'objet persisté retourne par createReturnId(...) doit valoir 0L : "
						, Long.valueOf(0L)
							, objet1PersistantId);
			
			/* garantit que createReturnId(Doublon) retourne null. */
			assertNull(
					"createReturnId(doublon) doit retourner null : "
						, objet1MemeInstancePersistantId);
			
			/* garantit que createReturnId(Doublon) retourne null. */
			assertNull(
					"createReturnId(doublon) doit retourner null : "
						, objet2EqualsObjet1PersistantId);
			
			/* garantit que createReturnId(Doublon) retourne null. */
			assertNull(
					"createReturnId(doublon) doit retourner null : "
						, objet3EqualsObjet1PersistantId);
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES CREATE : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
						
			/* garantit que createReturnId rajoute l'objet métier dans le stockage. */
			/* garantit que createReturnId(Doublon) ne rajoute rien dans le stockage. */
			assertEquals("nombreObjetsFinal vaut nombreObjetsInitial + 1 : "
					, nombreObjetsFinal
						, Long.valueOf(nombreObjetsInitial + 1));

			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATERETURNID_DOUBLON);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}

	} // Fin de testCreateReturnIdDoublon()._______________________________________
	


	/**
	 * Teste la méthode <b>save(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que save(null) ne stocke rien.</li>
	 * <li>garantit que save(null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testSaveNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testSaveNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVE_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final List<IContactSimple> listVraimentNull1 = null;
		List<IContactSimple> listVraimentNull1Persistant = null;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
					
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT SAVE(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			listVraimentNull1Persistant = (List<IContactSimple>) dao.save(listVraimentNull1);
			/* *********************************************** */
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("LISTE D'OBJETS APRES SAVE(NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				
				System.out.println();
				if (listVraimentNull1Persistant != null) {
					System.out.println("LISTE D'OBJETS PERSISTES : ");
					System.out.println(this.afficherListeObjetsMetier(
									listVraimentNull1Persistant));
				} else {
					System.out.println("LISTE D'OBJETS PERSISTES : NULL");
				}
					
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
			
			/* garantit que save(null) retourne null. */
			assertNull(
					"save(null) doit retourner null : "
						, listVraimentNull1Persistant);
			
			/* garantit que save(null) ne stocke rien. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsInitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVE_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testSaveNull().____________________________________________
	
	
	
	/**
	 * Teste la méthode <b>save(objets Null)</b>.<br/>
	 * <ul>
	 * <li>garantit que save(objets null) ne stocke rien.</li>
	 * <li>garantit que save(objets null) retourne une liste vide.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testSaveObjetsNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testSaveObjetsNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVE_OBJETS_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final List<IContactSimple> listAvecNull1 = new ArrayList<IContactSimple>();
		listAvecNull1.add(objetNull1);
		listAvecNull1.add(objetNull2);
		List<IContactSimple> listAvecNull1Persistant = null;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
					
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT SAVE(OBJETS NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
			
			System.out.println();
			System.out.println("LISTE D'OBJETS METIER A CREER : ");
			System.out.println("objetNull1 : " + objetNull1.toString());
			System.out.println("objetNull2 : " + objetNull2.toString());
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			listAvecNull1Persistant = (List<IContactSimple>) dao.save(listAvecNull1);
			/* *********************************************** */
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES SAVE(OBJETS NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				
				System.out.println();
				if (listAvecNull1Persistant != null) {
					System.out.println("LISTE D'OBJETS PERSISTES : ");
					System.out.println(this.afficherListeObjetsMetier(
									listAvecNull1Persistant));
				} else {
					System.out.println("LISTE D'OBJETS PERSISTES : NULL");
				}
					
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
			
			/* garantit que save(objets null) retourne une liste vide. */
			if (listAvecNull1Persistant != null) {
				
				assertTrue(
						"save(objets null) doit retourner unue liste vide : "
							, listAvecNull1Persistant.isEmpty());
			}
			
			
			/* garantit que save(objets null) ne stocke rien. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsInitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVE_OBJETS_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testSaveObjetsNull().______________________________________
	
	
	
	/**
	 * Teste la méthode <b>save(objets corrects)</b>.<br/>
	 * <ul>
	 * <li>garantit que save(objets corrects) stocke.</li>
	 * <li>garantit que save(objets corrects) 
	 * retourne une liste des objets stockés.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testSave() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testSave() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVE);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final List<IContactSimple> list1 = new ArrayList<IContactSimple>();
		list1.add(objetACreer1);
		list1.add(objetACreer2);
		List<IContactSimple> list1Persistante = null;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
					
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT SAVE(OBJETS CORRECTS) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
			
			System.out.println();
			System.out.println("LISTE D'OBJETS METIER A CREER : ");
			System.out.println("objetACreer1 : " + objetACreer1.toString());
			System.out.println("objetACreer2 : " + objetACreer2.toString());
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			list1Persistante = (List<IContactSimple>) dao.save(list1);
			/* *********************************************** */
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES SAVE(OBJETS CORRECTS) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				
				System.out.println();
				if (list1Persistante != null) {
					System.out.println("LISTE D'OBJETS PERSISTES : ");
					System.out.println(this.afficherListeObjetsMetier(
									list1Persistante));
				} else {
					System.out.println("LISTE D'OBJETS PERSISTES : NULL");
				}
					
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
			
			/* garantit que save(objets corrects) retourne une liste non vide. */
			if (list1Persistante != null) {
				
				assertFalse(
						"save(objets null) doit retourner une liste NON vide : "
							, list1Persistante.isEmpty());
			}
			
			
			/* garantit que save(objets corrects) stocke. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_DEUX
					, nombreObjetsFinal == nombreObjetsInitial + 2);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVE);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testSave().________________________________________________
	
	
	
	/**
	 * Teste la méthode <b>save(doublons)</b>.<br/>
	 * <ul>
	 * <li>garantit que save(doublons) ne stocke pas de doublon.</li>
	 * <li>garantit que save(doublons) 
	 * retourne une liste des objets stockés.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testSaveDoublon() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testSaveDoublon() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVE_DOUBLON);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final List<IContactSimple> list1 = new ArrayList<IContactSimple>();
		list1.add(objet1);
		list1.add(objet1MemeInstance);
		list1.add(objet2EqualsObj1);
		list1.add(objet3EqualsObj1);
		List<IContactSimple> list1Persistante = null;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
					
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT SAVE(DOUBLONS) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
			
			System.out.println();
			System.out.println("LISTE D'OBJETS METIER A CREER : ");
			System.out.println("objet1 : " + objet1.toString());
			System.out.println("objet1MemeInstance : " + objet1MemeInstance.toString());
			System.out.println("objet2EqualsObj1 : " + objet2EqualsObj1.toString());
			System.out.println("objet3EqualsObj1 : " + objet3EqualsObj1.toString());
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			list1Persistante = (List<IContactSimple>) dao.save(list1);
			/* *********************************************** */
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES SAVE(DOUBLONS) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				
				System.out.println();
				if (list1Persistante != null) {
					System.out.println("LISTE D'OBJETS PERSISTES : ");
					System.out.println(this.afficherListeObjetsMetier(
									list1Persistante));
				} else {
					System.out.println("LISTE D'OBJETS PERSISTES : NULL");
				}
					
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
			
			/* garantit que save(doublon) retourne une liste non vide. */
			if (list1Persistante != null) {
				
				assertFalse(
						"save(objets null) doit retourner une liste NON vide : "
							, list1Persistante.isEmpty());
			}
			
			
			/* garantit que save(doublon) stocke mais aucun doublon. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsInitial + 1);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVE_DOUBLON);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testSaveDoublon()._________________________________________
	

	
	/**
	 * Teste la méthode <b>retrieve(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que retrieve(null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRetrieveNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testRetrieveNull() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_RETRIEVE_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT RETRIEVE(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = null;
		IContactSimple objetPersisteTrouve1 = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJET METIER A RECHERCHER : ");
			System.out.println("objetARechercher1 : NULL");

		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIEVE************************** */		
			objetPersisteTrouve1 = dao.retrieve(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1 != null) {
					System.out.println("objetPersisteTrouve1 : " + objetPersisteTrouve1.toString());
				} else {
					System.out.println("objetPersisteTrouve1 : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIEVE(NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que retrieve(null) retourne null. */
			assertNull(
					"retrieve(null) doit retourner null : "
						, objetPersisteTrouve1);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_RETRIEVE_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testRetrieveNull().________________________________________
	

	
	/**
	 * Teste la méthode <b>retrieve(objet null)</b>.<br/>
	 * <ul>
	 * <li>garantit que retrieve(objet null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRetrieveObjetNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testRetrieveObjetNull() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_RETRIEVE_OBJET_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT RETRIEVE(OBJET NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = objetNull1;
		IContactSimple objetPersisteTrouve1 = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJET METIER A RECHERCHER : ");
			if (objetARechercher1 != null) {
				System.out.println("objetARechercher1 : " + objetARechercher1.toString());
			} else {
				System.out.println("objetARechercher1 : NULL");
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIEVE************************** */		
			objetPersisteTrouve1 = dao.retrieve(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1 != null) {
					System.out.println("objetPersisteTrouve1 : " + objetPersisteTrouve1.toString());
				} else {
					System.out.println("objetPersisteTrouve1 : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIEVE(OBJET NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que retrieve(objet null) retourne null. */
			assertNull(
					"retrieve(objet null) doit retourner null : "
						, objetPersisteTrouve1);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_RETRIEVE_OBJET_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testRetrieveObjetNull().___________________________________
	

	
	/**
	 * Teste la méthode <b>retrieve(inexistant)</b>.<br/>
	 * <ul>
	 * <li>garantit que retrieve(inexistant) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRetrieveInexistant() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testRetrieveInexistant() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_RETRIEVE_INEXISTANT);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT RETRIEVE(INEXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = objetInexistant;
		IContactSimple objetPersisteTrouve1 = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJET METIER A RECHERCHER : ");
			if (objetARechercher1 != null) {
				System.out.println("objetARechercher1 : " + objetARechercher1.toString());
			} else {
				System.out.println("objetARechercher1 : NULL");
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIEVE************************** */		
			objetPersisteTrouve1 = dao.retrieve(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1 != null) {
					System.out.println("objetPersisteTrouve1 : " + objetPersisteTrouve1.toString());
				} else {
					System.out.println("objetPersisteTrouve1 : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIEVE(INEXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que retrieve(inexistant) retourne null. */
			assertNull(
					"retrieve(inexistant) doit retourner null : "
						, objetPersisteTrouve1);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_RETRIEVE_INEXISTANT);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testRetrieveInexistant().__________________________________
	

	
	/**
	 * Teste la méthode <b>retrieve(existant)</b>.<br/>
	 * <ul>
	 * <li>garantit que retrieve(existant) retourne l'objet 
	 * persistant récupéré dans le stockage.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRetrieve() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testRetrieve() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_RETRIEVE);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT RETRIEVE(EXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = objetRemplirStockage1;
		IContactSimple objetPersisteTrouve1 = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJET METIER A RECHERCHER : ");
			if (objetARechercher1 != null) {
				System.out.println("objetARechercher1 : " + objetARechercher1.toString());
			} else {
				System.out.println("objetARechercher1 : NULL");
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIEVE************************** */		
			objetPersisteTrouve1 = dao.retrieve(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1 != null) {
					System.out.println("objetPersisteTrouve1 : " + objetPersisteTrouve1.toString());
				} else {
					System.out.println("objetPersisteTrouve1 : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIEVE(EXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que retrieve(existant) retourne l'objet 
			 * persistant récupéré dans le stockage. */
			assertNotNull(
					"retrieve(existant) doit retourner l'objet persisté : "
						, objetPersisteTrouve1);
			
			assertEquals(
					"l'objet persistant doit être equals à l'objet recherché : "
						, objetARechercher1
							, objetPersisteTrouve1);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_RETRIEVE);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testRetrieve().____________________________________________
	

	
	/**
	 * Teste la méthode <b>findById(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que findById(null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindByIdNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testFindByIdNull() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_FINDBYID_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT FINDBYID(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final Long objetARechercher1Id = null;
		IContactSimple objetPersisteTrouve1 = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("ID DE L'OBJET METIER A RECHERCHER : ");
			System.out.println("objetARechercher1Id : NULL");

		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************FINDBYID************************** */		
			objetPersisteTrouve1 = dao.findById(objetARechercher1Id);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1 != null) {
					System.out.println("objetPersisteTrouve1 : " + objetPersisteTrouve1.toString());
				} else {
					System.out.println("objetPersisteTrouve1 : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES FINDBYID(NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que findById(null) retourne null. */
			assertNull(
					"findById(null) doit retourner null : "
						, objetPersisteTrouve1);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_FINDBYID_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testFindByIdNull().________________________________________
	

	
	/**
	 * Teste la méthode <b>findById(inexistant)</b>.<br/>
	 * <ul>
	 * <li>garantit que findById(inexistant) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindByIdInexistant() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testFindByIdInexistant() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_FINDBYID_INEXISTANT);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT FINDBYID(INEXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final Long objetARechercher1Id = 17L;
		IContactSimple objetPersisteTrouve1 = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("ID DE L'OBJET METIER A RECHERCHER : ");			
			System.out.println("objetARechercher1Id : " + objetARechercher1Id.toString());			
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************FINDBYID************************** */		
			objetPersisteTrouve1 = dao.findById(objetARechercher1Id);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1 != null) {
					System.out.println("objetPersisteTrouve1 : " + objetPersisteTrouve1.toString());
				} else {
					System.out.println("objetPersisteTrouve1 : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES FINDBYID(INEXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que findById(inexistant) retourne null. */
			assertNull(
					"findById(inexistant) doit retourner null : "
						, objetPersisteTrouve1);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_FINDBYID_INEXISTANT);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testFindByIdInexistant().__________________________________
	

	
	/**
	 * Teste la méthode <b>findById(existant)</b>.<br/>
	 * <ul>
	 * <li>garantit que findById(existant) retourne l'objet 
	 * persistant récupéré dans le stockage.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindById() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testFindById() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_FINDBYID);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT FINDBYID(EXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final Long objetARechercher1Id = 3L;
		IContactSimple objetPersisteTrouve1 = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("ID DE L'OBJET METIER A RECHERCHER : ");			
			System.out.println("objetARechercher1Id : " + objetARechercher1Id.toString());
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************FINDBYID************************** */		
			objetPersisteTrouve1 = dao.findById(objetARechercher1Id);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1 != null) {
					System.out.println("objetPersisteTrouve1 : " + objetPersisteTrouve1.toString());
				} else {
					System.out.println("objetPersisteTrouve1 : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES FINDBYID(EXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que findById(existant) retourne l'objet 
			 * persistant récupéré dans le stockage. */
			assertNotNull(
					"findById(existant) doit retourner l'objet persisté : "
						, objetPersisteTrouve1);
						
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_FINDBYID);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testFindById().____________________________________________
	

	
	/**
	 * Teste la méthode <b>retrieveId(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que retrieveId(null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRetrieveIdNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testRetrieveIdNull() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_RETRIEVEID_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT RETRIVEID(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = null;
		Long objetPersisteTrouve1Id = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJET METIER A RECHERCHER : ");
			System.out.println("objetARechercher1 : NULL");

		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIVEID************************** */		
			objetPersisteTrouve1Id = dao.retrieveId(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("ID DE L'OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1Id != null) {
					System.out.println("objetPersisteTrouve1Id : " + objetPersisteTrouve1Id.toString());
				} else {
					System.out.println("objetPersisteTrouve1Id : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIVEID(NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que retrieveId(null) retourne null. */
			assertNull(
					"retrieveId(null) doit retourner null : "
						, objetPersisteTrouve1Id);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_RETRIEVEID_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testRetrieveIdNull().________________________________________
	

	
	/**
	 * Teste la méthode <b>retrieveId(objet null)</b>.<br/>
	 * <ul>
	 * <li>garantit que retrieveId(objet null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRetrieveIdObjetNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testRetrieveIdObjetNull() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_RETRIEVEID_OBJET_NULL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT RETRIVEID(OBJET NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = objetNull1;
		Long objetPersisteTrouve1Id = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJET METIER A RECHERCHER : ");
			if (objetARechercher1 != null) {
				System.out.println("objetARechercher1 : " + objetARechercher1.toString());
			} else {
				System.out.println("objetARechercher1 : NULL");
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIVEID************************** */		
			objetPersisteTrouve1Id = dao.retrieveId(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("ID DE L'OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1Id != null) {
					System.out.println("objetPersisteTrouve1Id : " + objetPersisteTrouve1Id.toString());
				} else {
					System.out.println("objetPersisteTrouve1Id : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIVEID(OBJET NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que retrieveId(objet null) retourne null. */
			assertNull(
					"retrieveId(objet null) doit retourner null : "
						, objetPersisteTrouve1Id);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_RETRIEVEID_OBJET_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testRetrieveIdObjetNull().___________________________________
	

	
	/**
	 * Teste la méthode <b>retrieveId(inexistant)</b>.<br/>
	 * <ul>
	 * <li>garantit que retrieveId(inexistant) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRetrieveIdInexistant() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testRetrieveIdInexistant() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_RETRIEVEID_INEXISTANT);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT RETRIVEID(INEXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = objetInexistant;
		Long objetPersisteTrouve1Id = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJET METIER A RECHERCHER : ");
			if (objetARechercher1 != null) {
				System.out.println("objetARechercher1 : " + objetARechercher1.toString());
			} else {
				System.out.println("objetARechercher1 : NULL");
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIVEID************************** */		
			objetPersisteTrouve1Id = dao.retrieveId(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("ID DE L'OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1Id != null) {
					System.out.println("objetPersisteTrouve1Id : " + objetPersisteTrouve1Id.toString());
				} else {
					System.out.println("objetPersisteTrouve1Id : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIVEID(INEXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que retrieveId(inexistant) retourne null. */
			assertNull(
					"retrieveId(inexistant) doit retourner null : "
						, objetPersisteTrouve1Id);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_RETRIEVEID_INEXISTANT);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testRetrieveIdInexistant().__________________________________
	

	
	/**
	 * Teste la méthode <b>retrieveId(existant)</b>.<br/>
	 * <ul>
	 * <li>garantit que retrieveId(existant) retourne l'ID de 
	 * l'objet persistant récupéré dans le stockage.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testRetrieveId() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode testRetrieveId() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_RETRIEVEID);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT RETRIVEID(EXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = objetRemplirStockage1;
		Long objetPersisteTrouve1Id = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJET METIER A RECHERCHER : ");
			if (objetARechercher1 != null) {
				System.out.println("objetARechercher1 : " + objetARechercher1.toString());
			} else {
				System.out.println("objetARechercher1 : NULL");
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIVEID************************** */		
			objetPersisteTrouve1Id = dao.retrieveId(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("ID DE L'OBJET PERSISTANT TROUVE : ");
				if (objetPersisteTrouve1Id != null) {
					System.out.println("objetPersisteTrouve1Id : " + objetPersisteTrouve1Id.toString());
				} else {
					System.out.println("objetPersisteTrouve1Id : NULL");
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIVEID(EXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que retrieveId(existant) retourne l'objet 
			 * persistant récupéré dans le stockage. */
			assertNotNull(
					"retrieveId(existant) doit retourner l'ID de l'objet persisté : "
						, objetPersisteTrouve1Id);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_RETRIEVEID);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testRetrieveId().____________________________________________
	
	
	
	/**
	 * <b>convertit une Liste d'Objets Metier en liste 
	 * d'Entities</b>.<br/>
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
	 * <b>Instancie une Entity JAXB ListeContactSimplesEntityJAXB à partir 
	 * d'une Liste de MODEL List&lt;IContactSimple&gt; pList</b>.<br/>
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
	
	
	
	/**
	 * <b>Vide d'abord puis Remplit le STOCKAGE 
	 * avec 4 enregistrements</b>.<br/>
	 * <ul>
	 * <li>4 enregistrements IContactSimple</li>
	 * </ul>
	 * 
	 * @param pAffichage : boolean.<br/>
	 * 
	 * @throws Exception 
	 */
	private void remplirStockage(
			final boolean pAffichage) throws Exception {
			
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = pAffichage;
		// **********************************
	
		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		/* vide le stockage*/
		this.viderStockage();
		
		/* Constitution d'un lot d'objets. */
		final List<IContactSimple> lot 
			= InitialiseurDeData.getListeContactSimples();
		
		List<IContactSimple> lotPersistant = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode remplirStockage(boolean) ********** ");
		}
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsinitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && pAffichage) {
			System.out.println(NBRE_OBJET_INITIAL + nombreObjetsinitial);
			System.out.println();
		}

		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			lotPersistant = (List<IContactSimple>) dao.save(lot);
			/* *********************************************** */
			
			nombreObjetsFinal = dao.count();
			
			/* garantit que save(Lot pObjects) 
			 * insère des objets dans le stockage.*/
			assertEquals(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_TROIS
					, Long.valueOf(nombreObjetsinitial + 4)
						, nombreObjetsFinal);
			
		}
		catch (AbstractDaoException e) {
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && pAffichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("remplirTable(boolean)");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES save(Lot) : " + nombreObjetsFinal);
			System.out.println("LOT D'ENREGISTREMENTS dans le stockage APRES remplirTable(boolean) : ");
			System.out.println(dao.afficherListeObjetsMetier(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();

		}

	} // Fin de remplirStockage(...).______________________________________
	

	
	/**
	 * <b>Vide le stockage</b>.<br/>
	 *
	 * @throws AbstractDaoException
	 */
	private void viderStockage() throws AbstractDaoException {
		
		dao.deleteAll();
		
		final Long nbreObjetsFinal = dao.count();
		
		assertEquals("Le stockage doit être vide : "
				, Long.valueOf(0L), nbreObjetsFinal);
		
	} // Fin de viderStockage().___________________________________________
	

	
	/**
	 * <ul>
	 * Affiche à la console :
	 * <li>Le nombre d'objets pNbreObjetsInitial initialement 
	 * dans le stockage avant le test.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pNbreObjetsInitial : Long : 
	 * Nombre d'objets initialement dans le stockage.<br/>
	 */
	private void afficherNbreObjetsInitial(
						final Long pNbreObjetsInitial) {
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("nombre d'objets initialement dans le stockage = " 
				+ pNbreObjetsInitial);
		System.out.println(TIRETS);
		System.out.println();

	} // Fin de afficherNbreObjetsInitial(...).____________________________
	

	
	/**
	 * <ul>
	 * Affiche à la console :
	 * <li>Le nombre d'objets pNbreObjetsFinal finalement 
	 * dans le stockage après le test.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pNbreObjetsFinal : Long : 
	 * Nombre d'objets finalement dans le stockage.<br/>
	 */
	private void afficherNbreObjetsFinal(
						final Long pNbreObjetsFinal) {
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("nombre d'objets finalement dans le stockage = " 
				+ pNbreObjetsFinal);
		System.out.println(TIRETS);
		System.out.println();

	} // Fin de afficherNbreObjetsFinal(...).______________________________
	
	
	
	/**
	 * <ul>
	 * Affiche à la console :
	 * <li>l'objet pObjetPersistant persisté dans le stockage.</li>
	 * <li>Le nombre d'objets pNbreObjetsFinal finalement 
	 * dans le stockage après le test.</li>
	 * </ul>
	 *
	 * @param pObjetPersistant : IContactSimple : 
	 * Objet persistant dans le stockage.<br/>
	 * @param pNbreObjetsFinal : Long : 
	 * Nombre d'objets finalement dans le stockage.<br/>
	 */
	private void afficherObjetPersistant(
			final IContactSimple pObjetPersistant
				, final Long pNbreObjetsFinal) {
		
		if (pObjetPersistant != null) {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("objet persistant : " 
					+ pObjetPersistant.toString());
			System.out.println("nombre d'objets finalement dans le stockage = " 
					+ pNbreObjetsFinal);
			System.out.println(TIRETS);
			System.out.println();
			
		} else {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("objetPersistant est NULL");
			System.out.println("nombre d'objets finalement dans le stockage = " 
					+ pNbreObjetsFinal);
			System.out.println(TIRETS);
			System.out.println();
			
		}
		
	} // Fin de afficherObjetPersistant(...).______________________________
	
	

	/**
	 * method afficherAbstractDaoException(
	 * AbstractDaoException pE) :<br/>
	 * <ul>
	 * Affiche à la console :
	 * <li>le message Utilisateur d'une AbstractDaoException pE.</li>
	 * <li>le message Technique d'une AbstractDaoException pE.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pE : AbstractDaoException.<br/>
	 */
	private void afficherAbstractDaoException(
			final AbstractDaoException pE) {
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("MESSAGE UTILISATEUR : " 
				+ pE.getMessageUtilisateur());
		System.out.println();
		System.out.println("MESSAGE TECHNIQUE : " 
				+ pE.getMessageTechnique());
		System.out.println(TIRETS);
		System.out.println();

	} // Fin de afficherAbstractDaoException(...)._________________________
	

			
	/**
	 * Affiche à la console de
	 * <b>"DAO NON INSTANCIE - dao est NULL"</b>.<br/>
	 * <br/>
	 */
	private void afficherDAONonInstancie() {
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("DAO NON INSTANCIE "
				+ "- dao est NULL");
		System.out.println(TIRETS);
		System.out.println();
		
	} // Fin de afficherDAONonInstancie()._________________________________


	
	/**
	 * <b>fournit une String pour l'affichage à la console 
	 * d'une Liste d'OBJETS METIER</b>.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	private String afficherListeObjetsMetier(
			final List<IContactSimple> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final IContactSimple contactSimple : pList) {
			
			stb.append(contactSimple.toString());
			stb.append(SAUT_LIGNE_PLATEFORME);
			
		}
		
		return stb.toString();
		
	} // Fin de afficherListeContactSimple(...).________________________________

	
	
	/**
	 * <b>Instancie et retourne une LocalDate à partir d'une String 
	 * sous la forme "dd/MM/yyyy"</b>.<br/>
	 * <ul>
	 * <li>Par exemple, <code>fournirLocalDate("05/01/1976")</code> 
	 * retourne une LocalDate située le 05 janvier 1976.</li>
	 * <li>utilise <code>dateFormatterSaisie.<b>parse</b>(pString
	 * , LocalDate::from);</code></li>
	 * <li>vérifie que pString est au format "23/07/1972" 
	 * (format REGEX "^\\d{2}/\\d{2}/\\d{4}").<br/>
	 * retourne null si ce n'est pas le cas.</li>
	 * </ul>
	 * - retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String : 
	 * String au format "05/01/1976" ou "19/02/1961".<br/>
	 * 
	 * @return : LocalDate.<br/>
	 */
	private static LocalDate fournirLocalDate(
			final String pString) {
		
		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		final DateTimeFormatter dateFormatterSaisie 
			= DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
		/* motif REGEX d'une date sous la forme 05/01/1976. */
		final String motifRegex = "^\\d{2}/\\d{2}/\\d{4}";
		final Pattern pattern = Pattern.compile(motifRegex);
		final Matcher matcher = pattern.matcher(pString);
		
		LocalDate resultat = null;
		
		/* vérifie que pString est au format "23/07/1972" 
		 * (format REGEX "^\\d{2}/\\d{2}/\\d{4}"). */
		if (matcher.matches()) {
			
			/* instancie une LocalDate à partir d'une String 
			 * sous la forme 05/01/1976. */
			resultat = dateFormatterSaisie.parse(pString, LocalDate::from);
						
			return resultat;
		}

		return null;
		
	} // Fin de fournirLocalDate(...)._____________________________________
	
	
	
	/**
	 * method avantTests() :<br/>
	 * <ul>
	 * <li>instructions exécutées <b>avant l'ensemble des tests</b> 
	 * de la classe JUnit.</li>
	 * <li><b>A REMPLIR A LA MAIN</b></li>
	 * </ul>
	 * @throws Exception 
	 */
	@BeforeClass
   public static void avantTests() throws Exception {
		
		dao = new ContactSimpleDaoJAXB();
		
	} // Fin de avantTests().______________________________________________
	

	

} // FIN DE LA CLASSE ContactSimpleDaoJAXBTest.-----------------------------------
