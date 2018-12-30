package levy.daniel.application.model.dao.metier.contactsimple.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
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
	 * DAO.<br/>
	 */
	private static transient ContactSimpleDaoJAXB dao;
				
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
	 * "testPersistSousClasseNull()".<br/>
	 */
	public static final String TEST_PERSIST_SOUSCLASSE_NULL 
	= "testPersistSousClasseNull()";

	/**
	 * "testPersistSousClasse()".<br/>
	 */
	public static final String TEST_PERSIST_SOUSCLASSE 
		= "testPersistSousClasse()";
	
	/**
	 * "testPersistSousClasseDoublon()".<br/>
	 */
	public static final String TEST_PERSIST_SOUSCLASSE_DOUBLON 
		= "testPersistSousClasseDoublon()";
	
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
	 * TEST_SAVELOT : String :<br/>
	 * "testSaveLot()".<br/>
	 */
	public static final String TEST_SAVELOT 
		= "testSaveLot()";
	
	/**
	 * TEST_RETRIEVE : String :<br/>
	 * "testRetrieve()".<br/>
	 */
	public static final String TEST_RETRIEVE 
		= "testRetrieve()";

	
	/**
	 * TEST_FINDBYID : String :<br/>
	 * "testFindById()".<br/>
	 */
	public static final String TEST_FINDBYID 
		= "testFindById()";

	
	/**
	 * TEST_FINDALL : String :<br/>
	 * "testFindAll()".<br/>
	 */
	public static final String TEST_FINDALL 
		= "testFindAll()";

	
	/**
	 * TEST_FINDALLMAX : String :<br/>
	 * "testFindAllMax()".<br/>
	 */
	public static final String TEST_FINDALLMAX 
		= "testFindAllMax()";
	
	
	/**
	 * TEST_FINDALLITERABLE : String :<br/>
	 * "testFindAllIterable()".<br/>
	 */
	public static final String TEST_FINDALLITERABLE 
		= "testFindAllIterable()";
	
	
	/**
	 * TEST_UPDATE_INEXISTANT : String :<br/>
	 * "testUpdateInexistant()".<br/>
	 */
	public static final String TEST_UPDATE_INEXISTANT 
		= "testUpdateInexistant()";
	
	
	/**
	 * TEST_UPDATE : String :<br/>
	 * "testUpdate()".<br/>
	 */
	public static final String TEST_UPDATE 
		= "testUpdate()";
	

	/**
	 * TEST_DELETE_INEXISTANT : String :<br/>
	 * "testDeleteInexistant()".<br/>
	 */
	public static final String TEST_DELETE_INEXISTANT 
		= "testDeleteInexistant()";

	
	/**
	 * TEST_DELETE : String :<br/>
	 * "testDelete()".<br/>
	 */
	public static final String TEST_DELETE 
		= "testDelete()";
	
	
	/**
	 * TEST_DELETEBYID_INEXISTANT : String :<br/>
	 * "testDeleteByIdInexistant()".<br/>
	 */
	public static final String TEST_DELETEBYID_INEXISTANT 
		= "testDeleteByIdInexistant()";

		
	/**
	 * TEST_DELETEBYID : String :<br/>
	 * "testDeleteById()".<br/>
	 */
	public static final String TEST_DELETEBYID 
		= "testDeleteById()";

	
	/**
	 * TEST_DELETEBYIDBOOLEAN_INEXISTANT : String :<br/>
	 * "testDeleteByIdBooleanInexistant()".<br/>
	 */
	public static final String TEST_DELETEBYIDBOOLEAN_INEXISTANT 
		= "testDeleteByIdBooleanInexistant()";

		
	/**
	 * TEST_DELETEBYIDBOOLEAN : String :<br/>
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
	 * "NOMBRE D'OBJETS INITIALEMENT EN BASE : ".<br/>
	 */
	public static final String NBRE_OBJET_INITIAL 
		= "NOMBRE D'OBJETS INITIALEMENT EN BASE : ";
	
		
	/**
	 * NBRE_OBJETS_FINAL_DOIT : String :<br/>
	 * "nombreObjetsFinal doit valoir ".<br/>
	 */
	public static final String NBRE_OBJETS_FINAL_DOIT 
		= "nombreObjetsFinal doit valoir ";
	
	
	/**
	 * NBRE_INITIAL_PLUS_ZERO : String :<br/>
	 * "nombreObjetsinitial + 0 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_ZERO 
		= "nombreObjetsinitial + 0 : ";
	
	
	/**
	 * NBRE_INITIAL_PLUS_UN : String :<br/>
	 * "nombreObjetsinitial + 1 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_UN 
		= "nombreObjetsinitial + 1 : ";

	
	/**
	 * NBRE_INITIAL_PLUS_DEUX : String :<br/>
	 * "nombreObjetsinitial + 2 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_DEUX 
		= "nombreObjetsinitial + 2 : ";

	
	/**
	 * NBRE_INITIAL_PLUS_TROIS : String :<br/>
	 * "nombreObjetsinitial + 3 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_TROIS 
	= "nombreObjetsinitial + 3 : ";


	/**
	 * OBJET1_NON_PERSISTANT : String :<br/>
	 * "OBJET1 NON PERSISTANT : ".<br/>
	 */
	public static final String OBJET1_NON_PERSISTANT 
		= "OBJET1 NON PERSISTANT : ";
	
	/**
	 * OBJET2_NON_PERSISTANT_DOUBLON1 : String :<br/>
	 * "OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : ".<br/>
	 */
	public static final String OBJET2_NON_PERSISTANT_DOUBLON1 
		= "OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : ";
	
	
	/**
	 * LOT_OBJET_INITIAL : String :<br/>
	 * "LOT D'OBJETS INITIALEMENT EN BASE : ".<br/>
	 */
	public static final String LOT_OBJET_INITIAL 
	= "LOT D'OBJETS INITIALEMENT EN BASE : ";
	
	
	/**
	 * LOT_OBJETS_APRES_DELETE : String :<br/>
	 * "LOT D'OBJETS EN BASE APRES DELETE : ".<br/>
	 */
	public static final String LOT_OBJETS_APRES_DELETE 
		= "LOT D'OBJETS EN BASE APRES DELETE : ";

	
	
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
	 * <li>garantit que create(null) ne fait rien 
	 * et retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreateNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
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
			
		} // Fin de daoCiviliteAbregee NON INJECTE._______________

		
		/* Vide le stockage. */
		this.viderStockage();

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final IContactSimple objet1 = null;
		IContactSimple objet1Persistant = null;
						
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = dao.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			this.afficherNbreObjetsInitial(nombreObjetsinitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = dao.create(objet1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets en base après le traitement. */
			nombreObjetsFinal = dao.count();
			
			/* garantit que create(null) ne fait rien et retourne null. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsinitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATE_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			this.afficherObjetPersistant(
					objet1Persistant, nombreObjetsFinal);						
		}

	} // Fin de testCreateNull().__________________________________________
	
	
		

	
	/**
	 * Teste la méthode create(IContactSimple, File).<br/>
	 * <ul>
	 * <li>garantit que create rajoute la ContactSimple à la liste des MODEL.</li>
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
		
		final List<IContactSimple> contactsContactSimple 
		= InitialiseurDeData.getListeContactSimples();
	
		/* enregistrement. */
		dao.enregistrer(contactsContactSimple, FILE);
		
		/* récupération. */
		final List<IContactSimple> contacts = dao.recupererListeModeles(FILE);
		
		final int tailleInitiale = contacts.size();

		/* ajout d'une IContactSimple. */
		final IContactSimple contactSimpleEnPlus 
			= new ContactSimple(2L
					, "Michael", "Caine"
					, "75, 5th Avenue"
					, null
					, "NY", "New York"
					, "USA"
					, "00 33 322 56 98"
					, "michael.caine@aol.com"
					, LocalDate.of(1950, 2, 20));
		
		final IContactSimple contactSimpleCreee 
			= dao.create(contactSimpleEnPlus);
		
		/* récupération. */
		final List<IContactSimple> contactsFinaux = dao.recupererListeModeles(FILE);
		
		final int tailleFinale = contactsFinaux.size();
		
		/* garantit que create rajoute la ContactSimple à la liste des MODEL. */
		assertEquals("Taille finale vaut taille initiale + 1 : "
				, tailleFinale
					, tailleInitiale + 1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(contactSimpleCreee.toString());
		}
		
	} // Fin de testCreate().______________________________________________
	
	
	
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
	
	
	
	/**
	 * Remplit le STOCKAGE avec 6 enregistrements.<br/>
	 * <ul>
	 * <li>3 enregistrements CiviliteAbregee</li>
	 * <li>3 enregistrements CiviliteComplete</li>
	 * </ul>>
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
		
		/* Constitution d'un lot d'objets. */
		final List<IContactSimple> contactsContactSimple 
			= InitialiseurDeData.getListeContactSimples();
	
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJAXBTest - méthode remplirStockage(boolean) ********** ");
		}
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && pAffichage) {

			System.out.println(NBRE_OBJET_INITIAL + nombreObjetsinitial);
			System.out.println(OBJET1_NON_PERSISTANT + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT : " + objet2.toString());
			System.out.println("OBJET3 NON PERSISTANT : " + objet3.toString());
			System.out.println("OBJET4 NON PERSISTANT : " + objet4.toString());
			System.out.println("OBJET5 NON PERSISTANT : " + objet5.toString());
			System.out.println("OBJET6 NON PERSISTANT : " + objet6.toString());
			System.out.println(TIRETS);
			System.out.println();
		}

		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			lotPersistant = (List<ICivilite>) this.daoCiviliteAbregee.save(lot);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCiviliteAbregee.countSousClasse();
			
			/* garantit que save(Lot pObjects) 
			 * insère des objets en base.*/
			assertEquals(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_TROIS
					, Long.valueOf(nombreObjetsinitial + 3)
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
			System.out.println("LOT D'ENREGISTREMENTS EN BASE APRES remplirTable(boolean) : ");
			System.out.println(this.daoCiviliteAbregee.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();

		}

		final Long nbeObjetsFinal = this.daoCiviliteAbregee.countSousClasse();
		
		assertEquals("Le stockage doit être contenir 3 enregistements : "
				, Long.valueOf(3L), nbeObjetsFinal);
		
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
	 * method afficherNbreObjetsInitial(
	 * Long pNbreObjetsInitial) :<br/>
	 * <ul>
	 * Affiche à la console :
	 * <li>Le nombre d'objets pNbreObjetsInitial initialement 
	 * en base avant le test.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pNbreObjetsInitial : Long : 
	 * Nombre d'objets initialement en base.<br/>
	 */
	private void afficherNbreObjetsInitial(
						final Long pNbreObjetsInitial) {
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("nombre d'objets initialement en base = " 
				+ pNbreObjetsInitial);
		System.out.println(TIRETS);
		System.out.println();

	} // Fin de afficherNbreObjetsInitial(...).____________________________
	

	
	/**
	 * <ul>
	 * Affiche à la console :
	 * <li>l'objet pObjetPersistant persisté en base.</li>
	 * <li>Le nombre d'objets pNbreObjetsFinal finalement 
	 * en base après le test.</li>
	 * </ul>
	 *
	 * @param pObjetPersistant : IContactSimple : 
	 * Objet persistant en base.<br/>
	 * @param pNbreObjetsFinal : Long : 
	 * Nombre d'objets finalement en base.<br/>
	 */
	private void afficherObjetPersistant(
			final IContactSimple pObjetPersistant
				, final Long pNbreObjetsFinal) {
		
		if (pObjetPersistant != null) {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("objet persistant : " 
					+ pObjetPersistant.toString());
			System.out.println("nombre d'objets finalement en base = " 
					+ pNbreObjetsFinal);
			System.out.println(TIRETS);
			System.out.println();
			
		} else {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("objetPersistant est NULL");
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
