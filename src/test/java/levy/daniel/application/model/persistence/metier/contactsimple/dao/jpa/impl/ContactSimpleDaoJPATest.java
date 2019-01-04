package levy.daniel.application.model.persistence.metier.contactsimple.dao.jpa.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import levy.daniel.application.model.persistence.metier.contactsimple.IContactSimpleDAO;
import levy.daniel.application.model.persistence.metier.contactsimple.InitialiseurDeData;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ContactSimpleEntityJAXB;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ListeContactSimplesEntityJAXB;

/**
 * CLASSE ContactSimpleDaoJPATest :<br/>
 * Test JUnit de la classe ContactSimpleDaoJPA.<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 4 janv. 2019
 *
 */
public class ContactSimpleDaoJPATest {

	// ************************ATTRIBUTS************************************/

	/**
	 * DAO.<br/>
	 * Instancié dans avantTests() ou injecté par Spring.
	 */
	private static transient IContactSimpleDAO dao;

	/**
	 * boolean qui spécifie si le DAO testé est de type JPA 
	 * (utilise Hibernate et merge()) ou pas (JAXB, ...).<br/>
	 */
	private static final transient boolean DAO_JPA = true;
	
	/**
	 * "nomTest".<br/>
	 */
	public static final String NOMTEST = "nomTest";

	/**
	 * "France".<br/>
	 */
	public static final String FRANCE = "France";
					
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
	 * "testSaveIterableNull()".<br/>
	 */
	public static final String TEST_SAVEITERABLE_NULL 
		= "testSaveIterableNull()";

	/**
	 * testSaveIterableObjetsNull().
	 */
	public static final String TEST_SAVEITERABLE_OBJETS_NULL 
		= "testSaveIterableObjetsNull()";

	/**
	 * "testSaveIterable()".<br/>
	 */
	public static final String TEST_SAVEITERABLE 
		= "testSaveIterable()";
		
	/**
	 * "testSaveIterableDoublon()".<br/>
	 */
	public static final String TEST_SAVEITERABLE_DOUBLON 
		= "testSaveIterableDoublon()";
	
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
	 * "testFindAllMaxOut()".<br/>
	 */
	public static final String TEST_FINDALLMAX_OUT 
		= "testFindAllMaxOut()";
	
	/**
	 * "testFindAllMax()".<br/>
	 */
	public static final String TEST_FINDALLMAX 
		= "testFindAllMax()";
		
	/**
	 * "testFindAllIterableNull()".<br/>
	 */
	public static final String TEST_FINDALLITERABLE_NULL 
		= "testFindAllIterableNull()";
		
	/**
	 * "testFindAllIterableOut()".<br/>
	 */
	public static final String TEST_FINDALLITERABLE_OUT 
		= "testFindAllIterableOut()";
	
	/**
	* "testFindAllIterable()".<br/>
	*/
	public static final String TEST_FINDALLITERABLE 
	= "testFindAllIterable()";

	/**
	 * "testUpdateNull()".<br/>
	 */
	public static final String TEST_UPDATE_NULL 
		= "testUpdateNull()";

	/**
	 * "testUpdateInexistant()".<br/>
	 */
	public static final String TEST_UPDATE_INEXISTANT 
		= "testUpdateInexistant()";

	/**
	 * "testUpdateDoublon()".<br/>
	 */
	public static final String TEST_UPDATE_DOUBLON 
		= "testUpdateDoublon()";

	/**
	 * "testUpdate()".<br/>
	 */
	public static final String TEST_UPDATE 
		= "testUpdate()";

	/**
	 * "testUpdateIdNull()".<br/>
	 */
	public static final String TEST_UPDATEID_NULL 
		= "testUpdateIdNull()";

	/**
	 * "testUpdateIdInexistant()".<br/>
	 */
	public static final String TEST_UPDATEID_INEXISTANT 
		= "testUpdateIdInexistant()";

	/**
	 * "testUpdateIdDoublon()".<br/>
	 */
	public static final String TEST_UPDATEID_DOUBLON 
		= "testUpdateIdDoublon()";
	
	/**
	 * "testUpdateId()".<br/>
	 */
	public static final String TEST_UPDATEID 
		= "testUpdateId()";

	/**
	 * "testDeleteNull()".<br/>
	 */
	public static final String TEST_DELETE_NULL 
		= "testDeleteNull()";
	
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
	 * "testDeleteByIdNull()".<br/>
	 */
	public static final String TEST_DELETEBYID_NULL 
		= "testDeleteByIdNull()";

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
	 * "testDeleteByIdBooleanNull()".<br/>
	 */
	public static final String TEST_DELETEBYIDBOOLEAN_NULL 
		= "testDeleteByIdBooleanNull()";

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
	 * "testDeleteAll()".<br/>
	 */
	public static final String TEST_DELETEALL 
		= "testDeleteAll()";
	
	/**
	 * "testDeleteAllBoolean()".<br/>
	 */
	public static final String TEST_DELETEALLBOOLEAN 
		= "testDeleteAllBoolean()";
	
	/**
	 * "testDeleteIterable()".<br/>
	 */
	public static final String TEST_DELETEITERABLE 
		= "testDeleteIterable()";
	
	/**
	 * "testDeleteIterableBoolean()".<br/>
	 */
	public static final String TEST_DELETEITERABLEBOOLEAN 
		= "testDeleteIterableBoolean()";

	/**
	 * "testExists".
	 */
	public static final String TEST_EXISTS 
		= "testExists";
	
	/**
	 * "testExistsId".
	 */
	public static final String TEST_EXISTS_ID 
		= "testExistsId";
	
	/**
	 * "testCount".
	 */
	public static final String TEST_COUNT 
		= "testCount";
	
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
	 * "nombreObjetsFinal vaut nombreObjetsInitial + 1 : ".<br/>
	 */
	public static final String FINAL_VAUT_INITIAL_PLUS_1 
		= "nombreObjetsFinal vaut nombreObjetsInitial + 1 : ";
	
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
	 * "objet1 : ".<br/>
	 */
	public static final String OBJET1 
		= "objet1 : ";

	/**
	 * "objet1MemeInstance : ".<br/>
	 */
	public static final String OBJET1_MEME_INSTANCE 
		= "objet1MemeInstance : ";
	
	/**
	 * "objet2EqualsObj1 : ".<br/>
	 */
	public static final String OBJET2_EQUALS_OBJET1 
		= "objet2EqualsObj1 : ";

	/**
	 * "objet3EqualsObj1 : ".<br/>
	 */
	public static final String OBJET3_EQUALS_OBJET1 
		= "objet3EqualsObj1 : ";
	
	/**
	 * "OBJET PERSISTANT TROUVE : ".<br/>
	 */
	public static final String OBJET_PERSISTANT_TROUVE 
		= "OBJET PERSISTANT TROUVE : ";
	
	/**
	 * "OBJET METIER A RECHERCHER : ".<br/>
	 */
	public static final String OBJET_METIER_A_RECHERCHER 
		= "OBJET METIER A RECHERCHER : ";

	/**
	 * "objetPersisteTrouve1Id : ".<br/>
	 */
	public static final String OBJET_PERSISTE_TROUVE1_ID 
		= "objetPersisteTrouve1Id : ";
	
	/**
	 * "objetPersisteTrouve1Id : NULL".<br/>
	 */
	public static final String OBJET_PERSISTE_TROUVE1_ID_NULL 
		= "objetPersisteTrouve1Id : NULL";

	/**
	 * "objetARechercher1 : ".<br/>
	 */
	public static final String OBJET_A_RECHERCHER1 
		= "objetARechercher1 : ";
	
	/**
	 * "objetARechercher1 : NULL".<br/>
	 */
	public static final String OBJET_A_RECHERCHER1_NULL 
		= "objetARechercher1 : NULL";
	
	/**
	 * "objetPersisteTrouve1 : ".<br/>
	 */
	public static final String OBJET_PERSISTE_TROUVE1 
		= "objetPersisteTrouve1 : ";	
	
	/**
	 * "objetPersisteTrouve1 : NULL".<br/>
	 */
	public static final String OBJET_PERSISTE_TROUVE_NULL 
		= "objetPersisteTrouve1 : NULL";

	/**
	 * "LISTE D'OBJETS METIER A CREER : ".<br/>
	 */
	public static final String LISTE_OBJETS_METIER_A_CREER 
		= "LISTE D'OBJETS METIER A CREER : ";

	/**
	 * "LISTE D'OBJETS PERSISTES : ".<br/>
	 */
	public static final String LISTE_OBJETS_PERSISTES 
		= "LISTE D'OBJETS PERSISTES : ";

	/**
	 * "LISTE D'OBJETS PERSISTES : NULL".<br/>
	 */
	public static final String LISTE_OBJETS_PERSISTES_NULL 
		= "LISTE D'OBJETS PERSISTES : NULL";

	/**
	 * "LISTE D'OBJETS APRES CREATE : ".<br/>
	 */
	public static final String LISTE_OBJETS_APRES_CREATE 
		= "LISTE D'OBJETS APRES CREATE : ";
	
	/**
	 * "OBJETS TROUVES : ".<br/>
	 */
	public static final String OBJETS_TROUVES 
		= "OBJETS TROUVES : ";	

	/**
	 * "ID DE L'OBJET PERSISTANT TROUVE : ".<br/>
	 */
	public static final String ID_OBJET_PERSISTANT_TROUVE 
		= "ID DE L'OBJET PERSISTANT TROUVE : ";
	
	/**
	 * "findAll() doit retourner 0 enregistrements : ".<br/>
	 */
	public static final String FINDALL_DOIT_RETOURNER_0_ENREGISTREMENTS 
		= "findAll() doit retourner 0 enregistrements : ";
	
	/**
	 * "findAll() doit retourner 2 enregistrements : ".<br/>
	 */
	public static final String FINDALL_DOIT_RETOURNER_2_ENREGISTREMENTS 
		= "findAll() doit retourner 2 enregistrements : ";
	
	/**
	 * "findAll() doit retourner 3 enregistrements : ".<br/>
	 */
	public static final String FINDALL_DOIT_RETOURNER_3_ENREGISTREMENTS 
		= "findAll() doit retourner 3 enregistrements : ";
	
	/**
	 * "findAll() doit retourner 4 enregistrements : ".<br/>
	 */
	public static final String FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS 
		= "findAll() doit retourner 4 enregistrements : ";
		
	/**
	 * "OBJET METIER A MODIFIER : ".<br/>
	 */
	public static final String OBJET_METIER_A_MODIFIER 
		= "OBJET METIER A MODIFIER : ";
	
	/**
	 * "OBJET METIER A MODIFIER : NULL".<br/>
	 */
	public static final String OBJET_METIER_A_MODIFIER_NULL 
		= "OBJET METIER A MODIFIER : NULL";

	/**
	 * "ID DE L'OBJET A MODIFIER : ".<br/>
	 */
	public static final String ID_OBJET_A_MODIFIER 
		= "ID DE L'OBJET A MODIFIER : ";
	
	/**
	 * "ID DE L'OBJET A MODIFIER : NULL".<br/>
	 */
	public static final String ID_OBJET_A_MODIFIER_NULL 
		= "ID DE L'OBJET A MODIFIER : NULL";

	/**
	 * "OBJET MODIFIE : ".<br/>
	 */
	public static final String OBJET_MODIFIE 
		= "OBJET MODIFIE : ";

	/**
	 * "OBJET MODIFIE : NULL".<br/>
	 */
	public static final String OBJET_MODIFIE_NULL 
		= "OBJET MODIFIE : NULL";

	/**
	 * "ID DE L'OBJET A DELETER : ".
	 */
	public static final String ID_OBJET_A_DELETER 
		= "ID DE L'OBJET A DELETER : ";
	
	/**
	 * "ID DE L'OBJET A DELETER : NULL".
	 */
	public static final String ID_OBJET_A_DELETER_NULL 
		= "ID DE L'OBJET A DELETER : NULL";
	
	/**
	 * "OBJET METIER A DELETER : ".<br/>
	 */
	public static final String OBJET_A_DELETER 
		= "OBJET METIER A DELETER : ";
	
	/**
	 * "OBJET METIER A DELETER : NULL".<br/>
	 */
	public static final String OBJET_A_DELETER_NULL 
		= "OBJET METIER A DELETER : NULL";

	/**
	 * "L'OBJET METIER A-T-IL ETE DETRUIT ? : ".<br/>
	 */
	public static final String OBJET_DETRUIT 
		= "L'OBJET METIER A-T-IL ETE DETRUIT ? : ";
	
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
	 * Ne doit pas causer de doublon avec les objetRemplirStockage.
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
	 * Ne doit pas causer de doublon avec les objetRemplirStockage.
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
		= new ContactSimple("prenomTest", NOMTEST
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
		=  new ContactSimple("prenomTest", NOMTEST
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
		= new ContactSimple("prenomTest", NOMTEST
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
	 * Objet modifiant objetRemplirStockage1 
	 * sans toucher à son id et sans créer 
	 * de doublon dans le stockage.<br/>
	 */
	public static transient IContactSimple objetModifieCorrect
		= new ContactSimple(
			"Horace modifié", "Silver modifié"
			, "17, rue de la Plomberie"
			, null
			, "73 698", "Chambéry"
			, FRANCE
			, "04 79 85 54 63"
			, "horace.silver@free.fr"
			, LocalDate.of(1950, 1, 17));
	
	/**
	 * Objet modifiant objetRemplirStockage2 
	 * sans toucher à son id et créant 
	 * un doublon avec objetRemplirStockage1 dans le stockage.<br/>
	 */
	public static transient IContactSimple objetModifieDoublon
		= new ContactSimple(
			"Horace", "Silver"
			, "7, avenue des Zozos"
			, "Bâtiment les Etoiles"
			, "75 001", "Paris"
			, FRANCE
			, "01 44 85 54 63"
			, "johnny.halliday@free.fr"
			, LocalDate.of(1950, 1, 17));

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleDaoJPATest.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ContactSimpleDaoJPATest() {
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testCreateNull() ********** ");
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
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT CREATE(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		
		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final IContactSimple objetVraimentNull1 = null;
		
		
		
		
		IContactSimple objetVraimentNull1Persistant = null;
						
		
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testCreateObjetNull() ********** ");
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
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT CREATE( OBJET NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		
		IContactSimple objetNull1Persistant = null;
		IContactSimple objetNull2Persistant = null;
						
		
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
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreate() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testCreate() ********** ");
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

		// ETAT INITIAL
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
				System.out.println(LISTE_OBJETS_APRES_CREATE);
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
						
			/* garantit que create rajoute l'objet métier dans le stockage. */
			assertEquals(FINAL_VAUT_INITIAL_PLUS_1
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
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreateDoublon() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testCreateDoublon() ********** ");
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
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT CREATE DOUBLON : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
			
			System.out.println();
			System.out.println(LISTE_OBJETS_METIER_A_CREER);
			System.out.println(OBJET1 + objet1.toString());
			System.out.println(OBJET1_MEME_INSTANCE + objet1MemeInstance.toString());
			System.out.println(OBJET2_EQUALS_OBJET1 + objet2EqualsObj1.toString());
			System.out.println(OBJET3_EQUALS_OBJET1 + objet3EqualsObj1.toString());
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
				System.out.println(LISTE_OBJETS_APRES_CREATE);
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
						
			/* garantit que create rajoute l'objet métier dans le stockage. */
			/* garantit que create(Doublon) ne rajoute rien dans le stockage. */
			assertEquals(FINAL_VAUT_INITIAL_PLUS_1
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testPersistNull() ********** ");
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testPersistObjetNull() ********** ");
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
	@SuppressWarnings(UNUSED)
	@Test
	public void testPersist() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testPersist() ********** ");
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
			assertEquals(FINAL_VAUT_INITIAL_PLUS_1
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
	@SuppressWarnings(UNUSED)
	@Test
	public void testPersistDoublon() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testPersistDoublon() ********** ");
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
			System.out.println(LISTE_OBJETS_METIER_A_CREER);
			System.out.println(OBJET1 + objet1.toString());
			System.out.println(OBJET1_MEME_INSTANCE + objet1MemeInstance.toString());
			System.out.println(OBJET2_EQUALS_OBJET1 + objet2EqualsObj1.toString());
			System.out.println(OBJET3_EQUALS_OBJET1 + objet3EqualsObj1.toString());
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
			assertEquals(FINAL_VAUT_INITIAL_PLUS_1
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testCreateReturnIdNull() ********** ");
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testCreateReturnIdObjetNull() ********** ");
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
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreateReturnId() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testCreateReturnId() ********** ");
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
				System.out.println(LISTE_OBJETS_APRES_CREATE);
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
						
			/* garantit que createReturnId rajoute l'objet métier dans le stockage. */
			assertEquals(FINAL_VAUT_INITIAL_PLUS_1
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
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreateReturnIdDoublon() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testCreateReturnIdDoublon() ********** ");
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
			System.out.println(LISTE_OBJETS_METIER_A_CREER);
			System.out.println(OBJET1 + objet1.toString());
			System.out.println(OBJET1_MEME_INSTANCE + objet1MemeInstance.toString());
			System.out.println(OBJET2_EQUALS_OBJET1 + objet2EqualsObj1.toString());
			System.out.println(OBJET3_EQUALS_OBJET1 + objet3EqualsObj1.toString());
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
				System.out.println(LISTE_OBJETS_APRES_CREATE);
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
						
			/* garantit que createReturnId rajoute l'objet métier dans le stockage. */
			/* garantit que createReturnId(Doublon) ne rajoute rien dans le stockage. */
			assertEquals(FINAL_VAUT_INITIAL_PLUS_1
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
	 * Teste la méthode <b>saveIterable(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que saveIterable(null) ne stocke rien.</li>
	 * <li>garantit que saveIterable(null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testSaveIterableNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testSaveIterableNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVEITERABLE_NULL);
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
			listVraimentNull1Persistant = (List<IContactSimple>) dao.saveIterable(listVraimentNull1);
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
					System.out.println(LISTE_OBJETS_PERSISTES);
					System.out.println(this.afficherListeObjetsMetier(
									listVraimentNull1Persistant));
				} else {
					System.out.println(LISTE_OBJETS_PERSISTES_NULL);
				}
					
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
			
			/* garantit que saveIterable(null) retourne null. */
			assertNull(
					"saveIterable(null) doit retourner null : "
						, listVraimentNull1Persistant);
			
			/* garantit que saveIterable(null) ne stocke rien. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsInitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVEITERABLE_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testSaveIterableNull().____________________________________
	
	
	
	/**
	 * Teste la méthode <b>saveIterable(objets Null)</b>.<br/>
	 * <ul>
	 * <li>garantit que saveIterable(objets null) ne stocke rien.</li>
	 * <li>garantit que saveIterable(objets null) retourne une liste vide.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testSaveIterableObjetsNull() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testSaveIterableObjetsNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVEITERABLE_OBJETS_NULL);
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
			System.out.println(LISTE_OBJETS_METIER_A_CREER);
			System.out.println("objetNull1 : " + objetNull1.toString());
			System.out.println("objetNull2 : " + objetNull2.toString());
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			listAvecNull1Persistant = (List<IContactSimple>) dao.saveIterable(listAvecNull1);
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
					System.out.println(LISTE_OBJETS_PERSISTES);
					System.out.println(this.afficherListeObjetsMetier(
									listAvecNull1Persistant));
				} else {
					System.out.println(LISTE_OBJETS_PERSISTES_NULL);
				}
					
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
			
			/* garantit que saveIterable(objets null) retourne une liste vide. */
			if (listAvecNull1Persistant != null) {
				
				assertTrue(
						"saveIterable(objets null) doit retourner unue liste vide : "
							, listAvecNull1Persistant.isEmpty());
			}
			
			
			/* garantit que saveIterable(objets null) ne stocke rien. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsInitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVEITERABLE_OBJETS_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testSaveIterableObjetsNull().______________________________
	
	
	
	/**
	 * Teste la méthode <b>saveIterable(objets corrects)</b>.<br/>
	 * <ul>
	 * <li>garantit que saveIterable(objets corrects) stocke.</li>
	 * <li>garantit que saveIterable(objets corrects) 
	 * retourne une liste des objets stockés.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testSaveIterable() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testSaveIterable() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVEITERABLE);
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
			System.out.println(LISTE_OBJETS_METIER_A_CREER);
			System.out.println("objetACreer1 : " + objetACreer1.toString());
			System.out.println("objetACreer2 : " + objetACreer2.toString());
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			list1Persistante = (List<IContactSimple>) dao.saveIterable(list1);
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
					System.out.println(LISTE_OBJETS_PERSISTES);
					System.out.println(this.afficherListeObjetsMetier(
									list1Persistante));
				} else {
					System.out.println(LISTE_OBJETS_PERSISTES_NULL);
				}
					
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
			
			/* garantit que saveIterable(objets corrects) retourne une liste non vide. */
			if (list1Persistante != null) {
				
				assertFalse(
						"saveIterable(objets null) doit retourner une liste NON vide : "
							, list1Persistante.isEmpty());
			}
			
			
			/* garantit que saveIterable(objets corrects) stocke. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_DEUX
					, nombreObjetsFinal == nombreObjetsInitial + 2);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVEITERABLE);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testSaveIterable().________________________________________
	
	
	
	/**
	 * Teste la méthode <b>saveIterable(doublons)</b>.<br/>
	 * <ul>
	 * <li>garantit que saveIterable(doublons) ne stocke pas de doublon.</li>
	 * <li>garantit que saveIterable(doublons) 
	 * retourne une liste des objets stockés.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testSaveIterableDoublon() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testSaveIterableDoublon() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVEITERABLE_DOUBLON);
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
			System.out.println(LISTE_OBJETS_METIER_A_CREER);
			System.out.println(OBJET1 + objet1.toString());
			System.out.println(OBJET1_MEME_INSTANCE + objet1MemeInstance.toString());
			System.out.println(OBJET2_EQUALS_OBJET1 + objet2EqualsObj1.toString());
			System.out.println(OBJET3_EQUALS_OBJET1 + objet3EqualsObj1.toString());
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			list1Persistante = (List<IContactSimple>) dao.saveIterable(list1);
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
					System.out.println(LISTE_OBJETS_PERSISTES);
					System.out.println(this.afficherListeObjetsMetier(
									list1Persistante));
				} else {
					System.out.println(LISTE_OBJETS_PERSISTES_NULL);
				}
					
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}
			
			/* garantit que saveIterable(doublon) retourne une liste non vide. */
			if (list1Persistante != null) {
				
				assertFalse(
						"saveIterable(objets null) doit retourner une liste NON vide : "
							, list1Persistante.isEmpty());
			}
			
			
			/* garantit que saveIterable(doublon) stocke mais aucun doublon. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsInitial + 1);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVEITERABLE_DOUBLON);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
	} // Fin de testSaveIterableDoublon()._________________________________
	

	
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testRetrieveNull() ********** ");
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
			System.out.println(OBJET_METIER_A_RECHERCHER);
			System.out.println(OBJET_A_RECHERCHER1_NULL);

		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIEVE************************** */		
			objetPersisteTrouve1 = dao.retrieve(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1 != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1 + objetPersisteTrouve1.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE_NULL);
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testRetrieveObjetNull() ********** ");
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
			System.out.println(OBJET_METIER_A_RECHERCHER);
			if (objetARechercher1 != null) {
				System.out.println(OBJET_A_RECHERCHER1 + objetARechercher1.toString());
			} else {
				System.out.println(OBJET_A_RECHERCHER1_NULL);
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIEVE************************** */		
			objetPersisteTrouve1 = dao.retrieve(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1 != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1 + objetPersisteTrouve1.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE_NULL);
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testRetrieveInexistant() ********** ");
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
			System.out.println(OBJET_METIER_A_RECHERCHER);
			if (objetARechercher1 != null) {
				System.out.println(OBJET_A_RECHERCHER1 + objetARechercher1.toString());
			} else {
				System.out.println(OBJET_A_RECHERCHER1_NULL);
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIEVE************************** */		
			objetPersisteTrouve1 = dao.retrieve(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1 != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1 + objetPersisteTrouve1.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE_NULL);
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testRetrieve() ********** ");
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
			System.out.println(OBJET_METIER_A_RECHERCHER);
			if (objetARechercher1 != null) {
				System.out.println(OBJET_A_RECHERCHER1 + objetARechercher1.toString());
			} else {
				System.out.println(OBJET_A_RECHERCHER1_NULL);
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIEVE************************** */		
			objetPersisteTrouve1 = dao.retrieve(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1 != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1 + objetPersisteTrouve1.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE_NULL);
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testFindByIdNull() ********** ");
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
				System.out.println(OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1 != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1 + objetPersisteTrouve1.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE_NULL);
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testFindByIdInexistant() ********** ");
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
				System.out.println(OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1 != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1 + objetPersisteTrouve1.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE_NULL);
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testFindById() ********** ");
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
				System.out.println(OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1 != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1 + objetPersisteTrouve1.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE_NULL);
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testRetrieveIdNull() ********** ");
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
			System.out.println("LISTE D'OBJETS AVANT RETRIEVEID(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = null;
		Long objetPersisteTrouve1Id = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_METIER_A_RECHERCHER);
			System.out.println(OBJET_A_RECHERCHER1_NULL);

		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIVEID************************** */		
			objetPersisteTrouve1Id = dao.retrieveId(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(ID_OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1Id != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1_ID + objetPersisteTrouve1Id.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE1_ID_NULL);
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIEVEID(NULL) : ");
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

	} // Fin de testRetrieveIdNull().______________________________________
	

	
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testRetrieveIdObjetNull() ********** ");
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
			System.out.println("LISTE D'OBJETS AVANT RETRIEVEID(OBJET NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = objetNull1;
		Long objetPersisteTrouve1Id = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_METIER_A_RECHERCHER);
			if (objetARechercher1 != null) {
				System.out.println(OBJET_A_RECHERCHER1 + objetARechercher1.toString());
			} else {
				System.out.println(OBJET_A_RECHERCHER1_NULL);
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIVEID************************** */		
			objetPersisteTrouve1Id = dao.retrieveId(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(ID_OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1Id != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1_ID + objetPersisteTrouve1Id.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE1_ID_NULL);
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIEVEID(OBJET NULL) : ");
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

	} // Fin de testRetrieveIdObjetNull()._________________________________
	

	
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testRetrieveIdInexistant() ********** ");
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
			System.out.println("LISTE D'OBJETS AVANT RETRIEVEID(INEXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = objetInexistant;
		Long objetPersisteTrouve1Id = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_METIER_A_RECHERCHER);
			if (objetARechercher1 != null) {
				System.out.println(OBJET_A_RECHERCHER1 + objetARechercher1.toString());
			} else {
				System.out.println(OBJET_A_RECHERCHER1_NULL);
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIVEID************************** */		
			objetPersisteTrouve1Id = dao.retrieveId(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(ID_OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1Id != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1_ID + objetPersisteTrouve1Id.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE1_ID_NULL);
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIEVEID(INEXISTANT) : ");
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

	} // Fin de testRetrieveIdInexistant().________________________________
	

	
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testRetrieveId() ********** ");
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
			System.out.println("LISTE D'OBJETS AVANT RETRIEVEID(EXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		final IContactSimple objetARechercher1 = objetRemplirStockage1;
		Long objetPersisteTrouve1Id = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_METIER_A_RECHERCHER);
			if (objetARechercher1 != null) {
				System.out.println(OBJET_A_RECHERCHER1 + objetARechercher1.toString());
			} else {
				System.out.println(OBJET_A_RECHERCHER1_NULL);
			}
		}

		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIVEID************************** */		
			objetPersisteTrouve1Id = dao.retrieveId(objetARechercher1);
			/* ********************************************************* */

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(ID_OBJET_PERSISTANT_TROUVE);
				if (objetPersisteTrouve1Id != null) {
					System.out.println(OBJET_PERSISTE_TROUVE1_ID + objetPersisteTrouve1Id.toString());
				} else {
					System.out.println(OBJET_PERSISTE_TROUVE1_ID_NULL);
				}
			}
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();
			
			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES RETRIEVEID(EXISTANT) : ");
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

	} // Fin de testRetrieveId().__________________________________________
	

	
	/**
	 * Teste la méthode <b>findAll()</b>.<br/>
	 * <ul>
	 * <li>garantit que findAll() retourne tout le stockage.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindAll() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testFindAll() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_FINDALL);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		List<IContactSimple> stockageList = null;
		
		try {
			
			/* ********************************************************* */
			/* ***********************RETRIVEID************************** */		
			stockageList = dao.findAll();
			/* ********************************************************* */

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			final Long nombreObjetsFinal = dao.count();
			
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES FINDALL() : ");
				System.out.println(dao.afficherListeObjetsMetier(stockageList));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
					, Long.valueOf(4L)
						, nombreObjetsFinal);
			
		} catch (AbstractDaoException e) {
			
			System.out.println(TEST_FINDALL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
			
		}

	} // Fin de testFindAll()._____________________________________________
	

	
	/**
	 * Teste la méthode <b>findAllMax(out)</b>.<br/>
	 * <ul>
	 * <li>garantit que findAllMax(out) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindAllMaxOut() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testFindAllMaxOut() ********** ");
		}
		
		/* dao NON INJECTE. */
		if (dao == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_FINDALLMAX_OUT);
				this.afficherDAONonInstancie();
			}
			
			return;
			
		} // Fin de dao NON INJECTE._____________________
		
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		List<IContactSimple> resultat = null;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT FINDALLMAX(OUT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// STARTPOSITION HORS DES CLOUS.
		final int startPosition = 4;
		final int maxResult = 3;
		
		try {

			/* ********************************************************* */
			/* *********************FINDALLMAX************************** */
			resultat = dao.findAllMax(startPosition, maxResult);
			/* ********************************************************* */

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJETS_TROUVES);
				System.out.println(dao.afficherListeObjetsMetier(resultat));
			}

			/* garantit que findAllMax(out) retourne null. */
			assertNull(
					"findAllMax(out) doit retourner null : "
						, resultat);

			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES FINDALLMAX(OUT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);

		} catch (AbstractDaoException e) {

			System.out.println(TEST_FINDALLMAX_OUT);
			this.afficherAbstractDaoException(e);
			e.printStackTrace();

		}

	} // Fin de testFindAllMaxOut()._______________________________________

	
	
	/**
	 * Teste la méthode <b>findAllMax()</b>.<br/>
	 * <ul>
	 * <li>garantit que findAllMax() retourne 
	 * la liste d'objets trouvés.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindAllMax() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testFindAllMax() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_FINDALLMAX);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		List<IContactSimple> resultat = null;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT FINDALLMAX() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// STARTPOSITION DANS LES CLOUS.
		final int startPosition = 2;
		final int maxResult = 7;
				
		
		try {

			/* ********************************************************* */
			/* *********************FINDALLMAX************************** */
			resultat = dao.findAllMax(startPosition, maxResult);
			/* ********************************************************* */

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJETS_TROUVES);
				System.out.println(dao.afficherListeObjetsMetier(resultat));
			}

			/* garantit que findAllMax() retourne 
			 * la liste d'objets trouvés. */
			assertNotNull(
					"findAllMax() doit retourner la liste d'objets trouvés : "
						, resultat);
			
			assertEquals(
					"findAllMax() doit retourner nombreObjetsInitial - startPosition objets : "
					, nombreObjetsInitial - startPosition 
						, resultat.size());
			
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES FINDALLMAX() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);

		} catch (AbstractDaoException e) {

			System.out.println(TEST_FINDALLMAX);
			this.afficherAbstractDaoException(e);
	
		}

	} // Fin de testFindAllMax().__________________________________________
	
	
	
	/**
	 * Teste la méthode <b>findAllIterable(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que findAllIterable(null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindAllIterableNull() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testFindAllIterableNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_FINDALLITERABLE_NULL);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		List<IContactSimple> resultat = null;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT FINDALLITERABLE(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// ITERABLE NULL.
		final Iterable<Long> ids = null;
				
		try {

			/* ********************************************************* */
			/* ********************FINDALLITERABLE********************** */
			resultat = (List<IContactSimple>) dao.findAllIterable(ids);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJETS_TROUVES + dao.afficherListeObjetsMetier(resultat));
				} else {
					System.out.println("OBJETS TROUVES : NULL");
				}				
			}

			/* garantit que findAllIterable(null) retourne null. */
			assertNull(
					"findAllIterable(null) doit retourner null : "
						, resultat);
			
					
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES FINDALLITERABLE(NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);

		} catch (AbstractDaoException e) {

			System.out.println(TEST_FINDALLITERABLE_NULL);
			this.afficherAbstractDaoException(e);

		}

	} // Fin de testFindAllIterableNull()._________________________________
	
	
	
	/**
	 * Teste la méthode <b>findAllIterable(out)</b>.<br/>
	 * <ul>
	 * <li>garantit que findAllIterable(out) retourne une liste vide.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindAllIterableOut() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testFindAllIterableOut() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_FINDALLITERABLE_OUT);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		List<IContactSimple> resultat = null;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT FINDALLITERABLE(OUT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// ITERABLE OUT.
		final List<Long> ids = new ArrayList<Long>();
		ids.add(17L);
		ids.add(20L);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("LISTE DES IDS A RECHERCHER : ");
			for (final Long id : ids) {
				System.out.println(id.toString());
			}
		}
				
		try {

			/* ********************************************************* */
			/* ********************FINDALLITERABLE********************** */
			resultat = (List<IContactSimple>) dao.findAllIterable(ids);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJETS_TROUVES);
					System.out.println(dao.afficherListeObjetsMetier(resultat));
				} else {
					System.out.println("OBJETS TROUVES : NULL");
				}				
			}

			/* garantit que findAllIterable(out) retourne une liste vide. */
			if (resultat != null) {
				assertTrue(
						"findAllIterable(out) doit retourner une liste vide : "
							, resultat.isEmpty());
			}
								
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES FINDALLITERABLE(OUT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);

		} catch (AbstractDaoException e) {

			System.out.println(TEST_FINDALLITERABLE_OUT);
			this.afficherAbstractDaoException(e);

		}

	} // Fin de testFindAllIterableOut().__________________________________
	
	
	
	/**
	 * Teste la méthode <b>findAllIterable()</b>.<br/>
	 * <ul>
	 * <li>garantit que findAllIterable() retourne la liste des objets.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFindAllIterable() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testFindAllIterable() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_FINDALLITERABLE);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		List<IContactSimple> resultat = null;

		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT FINDALLITERABLE() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// ITERABLE CORRECT.
		final List<Long> ids = new ArrayList<Long>();
		ids.add(2L);
		ids.add(3L);
		ids.add(17L);
		ids.add(20L);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("LISTE DES IDS A RECHERCHER : ");
			for (final Long id : ids) {
				System.out.println(id.toString());
			}
		}
				
		try {

			/* ********************************************************* */
			/* ********************FINDALLITERABLE********************** */
			resultat = (List<IContactSimple>) dao.findAllIterable(ids);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJETS_TROUVES);
					System.out.println(dao.afficherListeObjetsMetier(resultat));
				} else {
					System.out.println("OBJETS TROUVES : NULL");
				}				
			}

			/* garantit que findAllIterable() retourne une liste non vide. */
			if (resultat != null) {
				assertFalse(
						"findAllIterable() doit retourner une liste NON vide : "
							, resultat.isEmpty());
			}
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES FINDALLITERABLE() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);

		} catch (AbstractDaoException e) {

			System.out.println(TEST_FINDALLITERABLE);
			this.afficherAbstractDaoException(e);

		}

	} // Fin de testFindAllIterable()._____________________________________
	

	
	/**
	 * teste la méthode <b>update(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que update(null) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testUpdateNull() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testUpdateNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_UPDATE_NULL);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		IContactSimple resultat = null;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTUPDATE(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final IContactSimple objetAModifier = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_METIER_A_MODIFIER_NULL);
		}
		
		
		try {

			/* ********************************************************* */
			/* ***********************UPDATE**************************** */
			resultat = dao.update(objetAModifier);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJET_MODIFIE + resultat.toString());
				} else {
					System.out.println(OBJET_MODIFIE_NULL);
				}
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que update(null) retourne null. */
			assertNull(
					"update(null) doit retourner null : "
						, resultat);
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTUPDATE(NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
			
		} catch (AbstractDaoException e) {

			System.out.println(TEST_UPDATE_NULL);
			this.afficherAbstractDaoException(e);

		}
				
	} // Fin de testUpdateNull().__________________________________________
	

	
	/**
	 * teste la méthode <b>update(inexistant)</b>.<br/>
	 * <ul>
	 * <li>garantit que update(inexistant) ne fait rien 
	 * et retourne l'objetAModifier pour un DAO JPA.</li>
	 * <li>garantit que update(inexistant) retourne null 
	 * pour un DAO non JPA.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testUpdateInexistant() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testUpdateInexistant() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_UPDATE_INEXISTANT);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		IContactSimple resultat = null;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTUPDATE(INEXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final IContactSimple objetAModifier = objetInexistant;

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_METIER_A_MODIFIER + objetAModifier.toString());
		}
		
		
		try {

			/* ********************************************************* */
			/* ***********************UPDATE**************************** */
			resultat = dao.update(objetAModifier);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJET_MODIFIE + resultat.toString());
				} else {
					System.out.println(OBJET_MODIFIE_NULL);
				}
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			if (DAO_JPA) {
				/* garantit que update(inexistant) ne fait rien 
				 * et retourne l'objetAModifier pour un DAO JPA. */
				assertEquals(
						"update(inexistant) ne fait rien et doit "
						+ "retourner l'objetAModifier pour un DAO JPA : "
						, objetAModifier
							, resultat);
			} else {
				/* garantit que update(inexistant) retourne null 
				 * pour un DAO non JPA. */
				assertNull(
						"update(inexistant) doit retourner "
						+ "null pour un DAO non JPA : "
							, resultat);
			}
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTUPDATE(INEXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
			
			
		} catch (AbstractDaoException e) {

			System.out.println(TEST_UPDATE_INEXISTANT);
			this.afficherAbstractDaoException(e);

		}
				
	} // Fin de testUpdateInexistant().____________________________________
	
	
	
	/**
	 * teste la méthode <b>update(doublon)</b>.<br/>
	 * <ul>
	 * <li>garantit que update(doublon) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testUpdateDoublon() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testUpdateDoublon() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_UPDATE_DOUBLON);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		IContactSimple resultat = null;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTUPDATE(DOUBLON) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final IContactSimple objetAModifier = objetRemplirStockage1;
		/* modifier et créer un doublon. */
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_METIER_A_MODIFIER + objetAModifier.toString());
		}
		
		
		try {

			/* ********************************************************* */
			/* ***********************UPDATE**************************** */
			resultat = dao.update(objetAModifier);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJET_MODIFIE + resultat.toString());
				} else {
					System.out.println(OBJET_MODIFIE_NULL);
				}
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que update(doublon) retourne null. */
			assertNull(
					"update(doublon) doit retourner null : "
						, resultat);
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTUPDATE(DOUBLON) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
			
			
		} catch (AbstractDaoException e) {

			System.out.println(TEST_UPDATE_DOUBLON);
			this.afficherAbstractDaoException(e);

		}
						
	} // Fin de testUpdateDoublon()._______________________________________
	

	
	/**
	 * teste la méthode <b>update()</b>.<br/>
	 * <ul>
	 * <li>garantit que update() modifie 
	 * et retourne l'objet modifié pour un DAO JPA.</li>
	 * <li>garantit que update() retourne null 
	 * pour un DAO non JPA.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testUpdate() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testUpdate() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_UPDATE);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		IContactSimple resultat = null;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTUPDATE() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final IContactSimple objetAModifier = objetRemplirStockage1;
		/* modifier sans créer de doublon. */

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_METIER_A_MODIFIER + objetAModifier.toString());
		}
		
		
		try {

			/* ********************************************************* */
			/* ***********************UPDATE**************************** */
			resultat = dao.update(objetAModifier);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJET_MODIFIE + resultat.toString());
				} else {
					System.out.println(OBJET_MODIFIE_NULL);
				}
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			if (DAO_JPA) {
				/* garantit que update() modifie 
				 * et retourne l'objet modifié pour un DAO JPA. */
				assertEquals(
						"update() modifie et doit "
						+ "retourner l'objet modifié pour un DAO JPA : "
						, objetAModifier
							, resultat);
			} else {
				/* garantit que update() retourne null 
				 * pour un DAO non JPA. */
				assertNull(
						"update() doit retourner null "
						+ "pour un DAO non JPA : "
							, resultat);
			}
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTUPDATE() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
						
		} catch (AbstractDaoException e) {

			System.out.println(TEST_UPDATE);
			this.afficherAbstractDaoException(e);

		}
				
	} // Fin de testUpdate().______________________________________________
	

	
	/**
	 * teste la méthode <b>updateById(id null, objet correct)</b>.<br/>
	 * <ul>
	 * <li>garantit que updateById(id null, objet correct) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */	
	@SuppressWarnings(UNUSED)
	@Test
	public void testUpdateIdNull() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testUpdateIdNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_UPDATEID_NULL);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		IContactSimple resultat = null;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTUPDATEID(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final Long idObjetAModifier = null;
		final IContactSimple objetAModifier = dao.findById(idObjetAModifier);
		final IContactSimple objetModifie = objetModifieCorrect;

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(ID_OBJET_A_MODIFIER_NULL);
			if (objetAModifier != null) {
				System.out.println(OBJET_METIER_A_MODIFIER + objetAModifier.toString());
			} else {
				System.out.println(OBJET_METIER_A_MODIFIER_NULL);
			}			
		}
		
		
		try {

			/* ********************************************************* */
			/* **********************UPDATEID*************************** */
			resultat = dao.updateById(idObjetAModifier, objetModifie);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJET_MODIFIE + resultat.toString());
				} else {
					System.out.println(OBJET_MODIFIE_NULL);
				}
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que updateById(id null, objet correct) retourne null. */
			assertNull(
					"updateById(id null, objet correct) doit retourner null : "
						, resultat);
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTUPDATEID(NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
			
		} catch (AbstractDaoException e) {

			System.out.println(TEST_UPDATEID_NULL);
			this.afficherAbstractDaoException(e);

		}
				
	} // Fin de testUpdateIdNull().________________________________________
	

	
	/**
	 * teste la méthode <b>updateById(id inexistant, objet correct)</b>.<br/>
	 * <ul>
	 * <li>garantit que updateById(id inexistant, objet correct) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */	
	@SuppressWarnings(UNUSED)
	@Test
	public void testUpdateIdInexistant() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testUpdateIdInexistant() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_UPDATEID_INEXISTANT);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		IContactSimple resultat = null;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTUPDATEID(INEXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		/* ID inexistant. */
		final Long idObjetAModifier = 17L;
		final IContactSimple objetAModifier = dao.findById(idObjetAModifier);
		final IContactSimple objetModifie = objetModifieCorrect;

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(ID_OBJET_A_MODIFIER + idObjetAModifier.toString());
			if (objetAModifier != null) {
				System.out.println(OBJET_METIER_A_MODIFIER + objetAModifier.toString());
			} else {
				System.out.println(OBJET_METIER_A_MODIFIER_NULL);
			}			
		}
		
		
		try {

			/* ********************************************************* */
			/* **********************UPDATEID*************************** */
			resultat = dao.updateById(idObjetAModifier, objetModifie);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJET_MODIFIE + resultat.toString());
				} else {
					System.out.println(OBJET_MODIFIE_NULL);
				}
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que updateById(id inexistant, objet correct) retourne null. */
			assertNull(
					"updateById(id inexistant, objet correct) doit retourner null : "
						, resultat);
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTUPDATEID(INEXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
									
		} catch (AbstractDaoException e) {

			System.out.println(TEST_UPDATEID_INEXISTANT);
			this.afficherAbstractDaoException(e);

		}
				
	} // Fin de testUpdateIdInexistant().__________________________________
	

	
	/**
	 * teste la méthode <b>updateById(id correct, objet doublon)</b>.<br/>
	 * <ul>
	 * <li>garantit que updateById(id correct, objet doublon) retourne null.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */	
	@SuppressWarnings(UNUSED)
	@Test
	public void testUpdateIdDoublon() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testUpdateIdDoublon() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_UPDATEID_DOUBLON);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		IContactSimple resultat = null;
		
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTUPDATEID(DOUBLON) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final Long idObjetAModifier = 1L;
		final IContactSimple objetAModifier = dao.findById(idObjetAModifier);
		final IContactSimple objetModifie = objetModifieDoublon;

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(ID_OBJET_A_MODIFIER + idObjetAModifier.toString());
			if (objetAModifier != null) {
				System.out.println(OBJET_METIER_A_MODIFIER + objetAModifier.toString());
			} else {
				System.out.println(OBJET_METIER_A_MODIFIER_NULL);
			}			
		}
		
		
		try {

			/* ********************************************************* */
			/* **********************UPDATEID*************************** */
			resultat = dao.updateById(idObjetAModifier, objetModifie);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJET_MODIFIE + resultat.toString());
				} else {
					System.out.println(OBJET_MODIFIE_NULL);
				}
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que updateById(id correct, objet doublon) retourne null. */
			assertNull(
					"updateById(id correct, objet doublon) doit retourner null : "
						, resultat);
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTUPDATEID(DOUBLON) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
									
		} catch (AbstractDaoException e) {

			System.out.println(TEST_UPDATEID_DOUBLON);
			this.afficherAbstractDaoException(e);

		}
				
	} // Fin de testUpdateIdDoublon()._____________________________________
	

	
	/**
	 * teste la méthode <b>updateById(id correct, objet correct)</b>.<br/>
	 * <ul>
	 * <li>garantit que updateById(id correct, objet correct) 
	 * retourne l'instance modifiée.</li>
	 * <li>garantit que l'ID de l'objet modifié vaut pId.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */	
	@SuppressWarnings(UNUSED)
	@Test
	public void testUpdateId() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testUpdateId() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_UPDATEID);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		IContactSimple resultat = null;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTUPDATEID() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final Long idObjetAModifier = 0L;
		final IContactSimple objetAModifier = dao.findById(idObjetAModifier);
		final IContactSimple objetModifie = objetModifieCorrect;

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(ID_OBJET_A_MODIFIER + idObjetAModifier.toString());
			if (objetAModifier != null) {
				System.out.println(OBJET_METIER_A_MODIFIER + objetAModifier.toString());
			} else {
				System.out.println(OBJET_METIER_A_MODIFIER_NULL);
			}			
		}
		
		
		try {

			/* ********************************************************* */
			/* **********************UPDATEID*************************** */
			resultat = dao.updateById(idObjetAModifier, objetModifie);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				if (resultat != null) {
					System.out.println(OBJET_MODIFIE + resultat.toString());
				} else {
					System.out.println(OBJET_MODIFIE_NULL);
				}
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que updateById(id correct, objet correct) 
			 * retourne l'instance modifiée. */
			assertNotNull(
					"updateById(id correct, objet correct) doit "
					+ "retourner l'instance modifiée : "
						, resultat);
			
			assertEquals(
					"updateById(id correct, objet correct) doit "
					+ "retourner l'instance modifiée : "
						, objetModifie
							, resultat);
			
			/* garantit que l'ID de l'objet modifié vaut pId. */
			assertEquals(
					"ID de l'objet modifié doit valoir pId : "
						, idObjetAModifier
							, dao.retrieveId(resultat));
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTUPDATEID(DOUBLON) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
									
		} catch (AbstractDaoException e) {

			System.out.println(TEST_UPDATEID);
			this.afficherAbstractDaoException(e);

		}
				
	} // Fin de testUpdateId().____________________________________________


	
	/**
	 * teste la méthode <b>delete(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que delete(null) retourne false.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteNull() throws Exception {	
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETE_NULL);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		boolean resultat = false;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETE(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final IContactSimple objetADeleter = null;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_A_DELETER_NULL);
		}

		
		try {

			/* ********************************************************* */
			/* ***********************DELETE**************************** */
			resultat = dao.delete(objetADeleter);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJET_DETRUIT + resultat);
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que delete(null) retourne false. */
			assertFalse(
					"delete(null) doit retourner false : "
						, resultat);
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETE(NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
												
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETE_NULL);
			this.afficherAbstractDaoException(e);

		}
		
	} // Fin de testDeleteNull().__________________________________________


	
	/**
	 * teste la méthode <b>delete(inexistant)</b>.<br/>
	 * <ul>
	 * <li>garantit que delete(inexistant) retourne false.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteInexistant() throws Exception {	
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteInexistant() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETE_INEXISTANT);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		boolean resultat = false;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETE(INEXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final IContactSimple objetADeleter = objetInexistant;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_A_DELETER + objetADeleter.toString());
		}

		
		try {

			/* ********************************************************* */
			/* ***********************DELETE**************************** */
			resultat = dao.delete(objetADeleter);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJET_DETRUIT + resultat);
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que delete(inexistant) retourne false. */
			assertFalse(
					"delete(inexistant) doit retourner false : "
						, resultat);
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETE(INEXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
												
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETE_NULL);
			this.afficherAbstractDaoException(e);

		}
						
	} // Fin de testDeleteInexistant().____________________________________


	
	/**
	 * teste la méthode <b>delete()</b>.<br/>
	 * <ul>
	 * <li>garantit que delete() retourne true.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDelete() throws Exception {	
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDelete() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETE);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		boolean resultat = false;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETE() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final IContactSimple objetADeleter = objetRemplirStockage1;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(OBJET_A_DELETER + objetADeleter.toString());
		}

		
		try {

			/* ********************************************************* */
			/* ***********************DELETE**************************** */
			resultat = dao.delete(objetADeleter);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJET_DETRUIT + resultat);
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que delete(existant) retourne true. */
			assertTrue(
					"delete(existant) doit retourner true : "
						, resultat);
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETE() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			assertEquals(
					FINDALL_DOIT_RETOURNER_3_ENREGISTREMENTS
						, Long.valueOf(3L)
							, nombreObjetsFinal);
												
			
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETE_NULL);
			this.afficherAbstractDaoException(e);

		}
		
	} // Fin de testDelete().______________________________________________
	

	
	/**
	 * teste la méthode <b>deleteById(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que deleteById(null) ne fait rien.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteByIdNull() throws Exception {	

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteByIdNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETEBYID_NULL);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETEBYID(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final Long idObjetADeleter = null;
		
		final IContactSimple objetADeleter = dao.findById(idObjetADeleter);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			
			System.out.println(ID_OBJET_A_DELETER_NULL);
						
			if (objetADeleter != null) {
				System.out.println(OBJET_A_DELETER + objetADeleter.toString());
			} else {
				System.out.println(OBJET_A_DELETER_NULL);
			}			
		}

		
		try {

			/* ********************************************************* */
			/* *********************DELETEBYID************************** */
			dao.deleteById(idObjetADeleter);
			/* ********************************************************* */
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETEBYID(NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que deleteById(null) ne fait rien. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
															
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETEBYID_NULL);
			this.afficherAbstractDaoException(e);

		}
		
	} // Fin de testDeleteByIdNull().______________________________________
	

	
	/**
	 * teste la méthode <b>deleteById(inexistant)</b>.<br/>
	 * <ul>
	 * <li>garantit que deleteById(inexistant) ne fait rien.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteByIdInexistant() throws Exception {	

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteByIdInexistant() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETEBYID_INEXISTANT);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETEBYID(INEXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final Long idObjetADeleter = 17L;
		
		final IContactSimple objetADeleter = dao.findById(idObjetADeleter);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
						
			System.out.println(ID_OBJET_A_DELETER + idObjetADeleter.toString());
						
			if (objetADeleter != null) {
				System.out.println(OBJET_A_DELETER + objetADeleter.toString());
			} else {
				System.out.println(OBJET_A_DELETER_NULL);
			}			
		}

		
		try {

			/* ********************************************************* */
			/* *********************DELETEBYID************************** */
			dao.deleteById(idObjetADeleter);
			/* ********************************************************* */
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETEBYID(INEXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que deleteById(inexistant) ne fait rien. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
														
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETEBYID_INEXISTANT);
			this.afficherAbstractDaoException(e);

		}
				
	} // Fin de testDeleteByIdInexistant().________________________________
	

	
	/**
	 * teste la méthode <b>deleteById()</b>.<br/>
	 * <ul>
	 * <li>garantit que deleteById() supprime un enregistrement.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteById() throws Exception {	

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteById() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETEBYID);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETEBYID() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final Long idObjetADeleter = 0L;
		
		final IContactSimple objetADeleter = dao.findById(idObjetADeleter);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
						
			System.out.println(ID_OBJET_A_DELETER + idObjetADeleter.toString());
						
			if (objetADeleter != null) {
				System.out.println(OBJET_A_DELETER + objetADeleter.toString());
			} else {
				System.out.println(OBJET_A_DELETER_NULL);
			}			
		}

		
		try {

			/* ********************************************************* */
			/* *********************DELETEBYID************************** */
			dao.deleteById(idObjetADeleter);
			/* ********************************************************* */
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETEBYID() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que deleteById() supprime un enregistrement. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_3_ENREGISTREMENTS
						, Long.valueOf(3L)
							, nombreObjetsFinal);
															
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETEBYID);
			this.afficherAbstractDaoException(e);

		}
						
	} // Fin de testDeleteById().__________________________________________
	

	
	/**
	 * teste la méthode <b>deleteByIdBoolean(null)</b>.<br/>
	 * <ul>
	 * <li>garantit que deleteByIdBoolean(null) 
	 * ne fait rien et retourne false.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteByIdBooleanNull() throws Exception {	

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteByIdBooleanNull() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETEBYIDBOOLEAN_NULL);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		boolean resultat = false;

		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETEBYIDBOOLEAN(NULL) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final Long idObjetADeleter = null;
		
		final IContactSimple objetADeleter = dao.findById(idObjetADeleter);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			
			System.out.println(ID_OBJET_A_DELETER_NULL);
						
			if (objetADeleter != null) {
				System.out.println(OBJET_A_DELETER + objetADeleter.toString());
			} else {
				System.out.println(OBJET_A_DELETER_NULL);
			}			
		}

		
		try {

			/* ********************************************************* */
			/* ***************DELETEBYIDBOOLEAN************************* */
			resultat = dao.deleteByIdBoolean(idObjetADeleter);
			/* ********************************************************* */
						
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJET_DETRUIT + resultat);
			}

			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que deleteByIdBoolean(null) retourne false. */
			assertFalse(
					"deleteByIdBoolean(null) doit retourner false : "
						, resultat);
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETEBYIDBOOLEAN(NULL) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que deleteByIdBoolean(null) ne fait rien. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
															
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETEBYIDBOOLEAN_NULL);
			this.afficherAbstractDaoException(e);

		}
		
	} // Fin de testDeleteByIdBooleanNull()._______________________________
	

	
	/**
	 * teste la méthode <b>deleteByIdBoolean(inexistant)</b>.<br/>
	 * <ul>
	 * <li>garantit que deleteByIdBoolean(inexistant) ne fait rien 
	 * et retourne false.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteByIdBooleanInexistant() throws Exception {	

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteByIdBooleanInexistant() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETEBYIDBOOLEAN_INEXISTANT);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		boolean resultat = false;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETEBYIDBOOLEAN(INEXISTANT) : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final Long idObjetADeleter = 17L;
		
		final IContactSimple objetADeleter = dao.findById(idObjetADeleter);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
						
			System.out.println(ID_OBJET_A_DELETER + idObjetADeleter.toString());
						
			if (objetADeleter != null) {
				System.out.println(OBJET_A_DELETER + objetADeleter.toString());
			} else {
				System.out.println(OBJET_A_DELETER_NULL);
			}			
		}

		
		try {

			/* ********************************************************* */
			/* ***************DELETEBYIDBOOLEAN************************* */
			resultat = dao.deleteByIdBoolean(idObjetADeleter);
			/* ********************************************************* */
						
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJET_DETRUIT + resultat);
			}
			
			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que deleteByIdBoolean(inexistant) retourne false. */
			assertFalse(
					"deleteByIdBoolean(inexistant) doit retourner false : "
						, resultat);

			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETEBYIDBOOLEAN(INEXISTANT) : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que deleteByIdBoolean(inexistant) ne fait rien. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
														
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETEBYIDBOOLEAN_INEXISTANT);
			this.afficherAbstractDaoException(e);

		}
				
	} // Fin de testDeleteByIdBooleanInexistant()._________________________
	

	
	/**
	 * teste la méthode <b>deleteByIdBoolean()</b>.<br/>
	 * <ul>
	 * <li>garantit que deleteByIdBoolean() 
	 * supprime un enregistrement et retourne true.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteByIdBoolean() throws Exception {	

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteByIdBoolean() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETEBYIDBOOLEAN);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________
		
		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		boolean resultat = false;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETEBYIDBOOLEAN() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final Long idObjetADeleter = 0L;
		
		final IContactSimple objetADeleter = dao.findById(idObjetADeleter);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
						
			System.out.println(ID_OBJET_A_DELETER + idObjetADeleter.toString());
						
			if (objetADeleter != null) {
				System.out.println(OBJET_A_DELETER + objetADeleter.toString());
			} else {
				System.out.println(OBJET_A_DELETER_NULL);
			}			
		}

		
		try {

			/* ********************************************************* */
			/* ***************DELETEBYIDBOOLEAN************************* */
			resultat = dao.deleteByIdBoolean(idObjetADeleter);
			/* ********************************************************* */
									
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println(OBJET_DETRUIT + resultat);
			}
			
			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que deleteByIdBoolean() retourne true. */
			assertTrue(
					"deleteByIdBoolean() doit retourner true : "
						, resultat);
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETEBYIDBOOLEAN() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que deleteByIdBoolean() supprime un enregistrement. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_3_ENREGISTREMENTS
						, Long.valueOf(3L)
							, nombreObjetsFinal);
															
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETEBYIDBOOLEAN);
			this.afficherAbstractDaoException(e);

		}
						
	} // Fin de testDeleteByIdBoolean().___________________________________
	
	
	
	/**
	 * teste la méthode <b>deleteAll()</b>.<br/>
	 * <ul>
	 * <li>garantit que deleteAll() détruit 
	 * tous les enregistrements dans le stockage.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteAll() throws Exception {	
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteAll() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETEALL);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETEALL() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		try {

			/* ********************************************************* */
			/* *********************DELETEBYID************************** */
			dao.deleteAll();
			/* ********************************************************* */
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETEALL() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que deleteAll() supprime tous les enregistrements. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_0_ENREGISTREMENTS
						, Long.valueOf(0L)
							, nombreObjetsFinal);
															
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETEALL);
			this.afficherAbstractDaoException(e);

		}
						
		
	} // Fin de testDeleteAll().___________________________________________
	
	
	
	/**
	 * teste la méthode <b>deleteAllBoolean()</b>.<br/>
	 * <ul>
	 * <li>garantit que deleteAllBoolean() détruit 
	 * tous les enregistrements dans le stockage et retourne true.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteAllBoolean() throws Exception {	
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteAllBoolean() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETEALLBOOLEAN);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);

		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		boolean resultat = false;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT TESTDELETEALLBOOLEAN() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		
		try {

			/* ********************************************************* */
			/* *********************DELETEBYID************************** */
			resultat = dao.deleteAllBoolean();
			/* ********************************************************* */
						
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LE STOCKAGE A-T-IL ETE VIDE ? : " + resultat);
			}
						
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que deleteAllBoolean() retourne true. */
			assertTrue(
					"deleteAllBoolean() doit retourner true : "
						, resultat);
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES TESTDELETEALLBOOLEAN() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que deleteAllBoolean() supprime tous les enregistrements. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_0_ENREGISTREMENTS
						, Long.valueOf(0L)
							, nombreObjetsFinal);
															
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETEALLBOOLEAN);
			this.afficherAbstractDaoException(e);

		}
								
	} // Fin de testDeleteAllBoolean().____________________________________
	

	
	/**
	 * teste la méthode <b>deleteIterable()</b>.<br/>
	 * <ul>
	 * <li>garantit que deleteIterable() supprime tous les 
	 * enregistrements persistés de l'iterable.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteIterable() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteIterable() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETEITERABLE);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);


		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT DELETEITERABLE() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final List<IContactSimple> list1 = new ArrayList<IContactSimple>();
		list1.add(objetRemplirStockage1);
		list1.add(objetRemplirStockage2);
		list1.add(objetNull2);
		list1.add(objetInexistant);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("LISTE D'OBJETS A DETRUIRE");
			for (final IContactSimple objet : list1) {
				System.out.println(objet.toString());
			}
		}
		
		
		try {

			/* ********************************************************* */
			/* *********************DELETEITERABLE********************* */
			dao.deleteIterable(list1);
			/* ********************************************************* */
			
			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES DELETEITERABLE() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que deleteIterable() supprime tous les enregistrements 
			 * persistés de l'iterable. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_2_ENREGISTREMENTS
						, Long.valueOf(2L)
							, nombreObjetsFinal);
															
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETEITERABLE);
			this.afficherAbstractDaoException(e);

		}
								
	} // Fin de testDeleteIterable().______________________________________
	

	
	/**
	 * teste la méthode <b>deleteIterableBoolean()</b>.<br/>
	 * <ul>
	 * <li>garantit que deleteIterableBoolean() supprime tous les 
	 * enregistrements persistés de l'iterable et retourne true.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeleteIterableBoolean() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testDeleteIterableBoolean() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_DELETEITERABLEBOOLEAN);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);


		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		boolean resultat = false;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT DELETEITERABLEBOOLEAN() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final List<IContactSimple> list1 = new ArrayList<IContactSimple>();
		list1.add(objetRemplirStockage1);
		list1.add(objetRemplirStockage2);
		list1.add(objetNull2);
		list1.add(objetInexistant);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("LISTE D'OBJETS A DETRUIRE");
			for (final IContactSimple objet : list1) {
				System.out.println(objet.toString());
			}
		}
		
		
		try {

			/* ********************************************************* */
			/* *****************DELETEITERABLEBOOLEAN******************* */
			resultat = dao.deleteIterableBoolean(list1);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LES OBJETS DE L'ITERABLE ONT BIEN ETE DETRUITS ? : " + resultat);
			}
			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que deleteIterableBoolean() retourne true. */
			assertTrue(
					"deleteIterableBoolean() doit retourner true : "
						, resultat);

			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES DELETEITERABLEBOOLEAN() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que deleteIterableBoolean() supprime tous les enregistrements 
			 * persistés de l'iterable. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_2_ENREGISTREMENTS
						, Long.valueOf(2L)
							, nombreObjetsFinal);
															
		} catch (AbstractDaoException e) {

			System.out.println(TEST_DELETEITERABLEBOOLEAN);
			this.afficherAbstractDaoException(e);

		}
								
	} // Fin de testDeleteIterableBoolean()._______________________________
	

	
	/**
	 * teste la méthode <b>exists(objet)</b>.<br/>
	 * <ul>
	 * <li>garantit que exists(existant) retourne true.</li>
	 * <li>garantit que exists(inexistant) retourne false.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testExists() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testExists() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_EXISTS);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);


		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		boolean resultatExistant = false;
		boolean resultatInexistant = false;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT EXISTS() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final IContactSimple objetExistantTest = objetRemplirStockage1;
		final IContactSimple objetInexistantTest = objetInexistant;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJETS DE TEST : ");
			System.out.println("objetExistantTest : " 
					+ objetExistantTest.toString());
			System.out.println("objetInexistantTest : " 
					+ objetInexistantTest.toString());
		}
		
		try {

			/* ********************************************************* */
			/* ************************EXISTS*************************** */
			resultatExistant = dao.exists(objetExistantTest);
			resultatInexistant = dao.exists(objetInexistantTest);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("objetExistantTest EXISTE ? : " + resultatExistant);
				System.out.println("objetInexistantTest EXISTE ? : " + resultatInexistant);
			}
	
			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que exists(existant) retourne true. */
			assertTrue(
					"exists(existant) doit retourner true : "
						, resultatExistant);
			/* garantit que exists(inexistant) retourne false. */
			assertFalse(
					"exists(inexistant) doit retourner false : "
						, resultatInexistant);

			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES EXISTS() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que exists() ne touche à rien. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
															
		} catch (AbstractDaoException e) {

			System.out.println(TEST_EXISTS);
			this.afficherAbstractDaoException(e);

		}

	} // Fin de testExists().______________________________________________
	

	
	/**
	 * teste la méthode <b>existsId(id)</b>.<br/>
	 * <ul>
	 * <li>garantit que existsId(existant) retourne true.</li>
	 * <li>garantit que existsId(inexistant) retourne false.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testExistsId() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testExistsId() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_EXISTS_ID);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);


		Long nombreObjetsInitial = 0L;
		Long nombreObjetsFinal = 0L;

		boolean resultatExistant = false;
		boolean resultatInexistant = false;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS AVANT EXISTS_ID() : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		

		/* ************************* */
		// CONDITIONS DE TEST
		/* ************************* */
		final Long objetExistantTestId = 0L;
		final Long objetInexistantTestId = 17L;
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("ID DES OBJETS DE TEST : ");
			System.out.println("objetExistantTestId : " 
					+ objetExistantTestId.toString());
			System.out.println("objetInexistantTestId : " 
					+ objetInexistantTestId.toString());
		}
		
		try {

			/* ********************************************************* */
			/* ************************EXISTS_ID*************************** */
			resultatExistant = dao.existsId(objetExistantTestId);
			resultatInexistant = dao.existsId(objetInexistantTestId);
			/* ********************************************************* */
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("objetExistantTest EXISTE ? : " + resultatExistant);
				System.out.println("objetInexistantTest EXISTE ? : " + resultatInexistant);
			}
	
			
			/* *********** */
			// ASSERTIONS
			/* *********** */
			/* garantit que existsId(existant) retourne true. */
			assertTrue(
					"existsId(existant) doit retourner true : "
						, resultatExistant);
			/* garantit que existsId(inexistant) retourne false. */
			assertFalse(
					"existsId(inexistant) doit retourner false : "
						, resultatInexistant);

			
			// ETAT FINAL
			/* récupération. */
			final List<IContactSimple> objetsFinaux = dao.findAll();

			/* Calcul du nombre d'objets dans le stockage après le traitement. */
			nombreObjetsFinal = dao.count();

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println();
				System.out.println("LISTE D'OBJETS APRES EXISTS_ID() : ");
				System.out.println(dao.afficherListeObjetsMetier(objetsFinaux));
				this.afficherNbreObjetsFinal(nombreObjetsFinal);
			}

			/* garantit que exists() ne touche à rien. */
			assertEquals(
					FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
						, Long.valueOf(4L)
							, nombreObjetsFinal);
															
		} catch (AbstractDaoException e) {

			System.out.println(TEST_EXISTS_ID);
			this.afficherAbstractDaoException(e);

		}

	} // Fin de testExistsId().______________________________________________
	

	
	/**
	 * teste la méthode <b>count()</b>.<br/>
	 * <ul>
	 * <li>garantit que count() retourne 
	 * le bon nombre d'enregistrements.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCount() throws Exception {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode testCount() ********** ");
		}

		/* dao NON INJECTE. */
		if (dao == null) {

			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_COUNT);
				this.afficherDAONonInstancie();
			}

			return;

		} // Fin de dao NON INJECTE._____________________

		/* vide et remplit le stockage. */
		this.remplirStockage(false);
		
		Long nombreObjetsInitial = 0L;
		
		// ETAT INITIAL
		/* récupération. */
		final List<IContactSimple> objetInitiaux = dao.findAll();

		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsInitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("LISTE D'OBJETS DANS LE STOCKAGE : ");
			System.out.println(dao.afficherListeObjetsMetier(objetInitiaux));
			this.afficherNbreObjetsInitial(nombreObjetsInitial);
		}
		
		/* garantit que count() retourne le bon nombre d'enregistrements. */
		assertEquals(
				FINDALL_DOIT_RETOURNER_4_ENREGISTREMENTS
					, Long.valueOf(4L)
						, nombreObjetsInitial);
		
	} // Fin de testCount()._______________________________________________

	
	
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
			System.out.println("********** CLASSE ContactSimpleDaoJPATest - méthode remplirStockage(boolean) ********** ");
		}
		
		/* Compte du nombre d'Objets initialement dans le stockage. */
		nombreObjetsinitial = dao.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && pAffichage) {
			System.out.println(NBRE_OBJET_INITIAL + nombreObjetsinitial);
			System.out.println();
		}

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && pAffichage) {
			System.out.println();
			System.out.println("OBJETS METIER A STOCKER : ");
			for (final IContactSimple objet : lot) {
				System.out.println(objet.toString());
			}
		}
		
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			lotPersistant = (List<IContactSimple>) dao.saveIterable(lot);
			/* *********************************************** */
			
			nombreObjetsFinal = dao.count();
			
			/* garantit que save(Lot pObjects) 
			 * insère des objets dans le stockage.*/
			assertEquals(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_QUATRE
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
	 * @throws Exception
	 */
	private void viderStockage() throws Exception {
		
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
		
		dao = new ContactSimpleDaoJPA();
		
	} // Fin de avantTests().______________________________________________
	

	
} // FIN DE LA CLASSE ContactSimpleDaoJPATest.-------------------------------
