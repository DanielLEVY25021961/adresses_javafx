package levy.daniel.application.apptechnic.configurationmanagers.gestionnairespreferences;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Path;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import levy.daniel.application.apptechnic.configurationmanagers.LocaleManager;
import levy.daniel.application.apptechnic.configurationmanagers.gestionnairestemplates.IGestionnaireTemplates;
import levy.daniel.application.apptechnic.configurationmanagers.gestionnairestemplates.impl.GestionnaireTemplates;


/**
 * CLASSE GestionnairePropertiesTest :<br/>
 * Test JUnit de la classe GestionnaireProperties.<br/>
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
 * @since 14 juil. 2018
 *
 */
public class GestionnairePropertiesTest {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	/**
	 * " : ".<br/>
	 */
	public static final String DEUX_POINTS = " : ";

	/**
	 * "labels".<br/>
	 */
	public static final String NOM_BASE_LABEL = "labels";
	
	/**
	 * "messages".<br/>
	 */
	public static final String NOM_BASE_MESSAGE = "messages";
	
	/**
	 * "anglais (Etats-Unis)".<br/>
	 */
	public static final String LOCALE_US_STRING = "anglais (Etats-Unis)";
	
	/**
	 * "français (France)".<br/>
	 */
	public static final String LOCALE_FR_STRING = "français (France)";
	
	/**
	 * IGestionnaireTemplates.<br/>
	 */
	private static transient IGestionnaireTemplates gestionnaireTemplate;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(GestionnairePropertiesTest.class);
	

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public GestionnairePropertiesTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * Teste le constructeur complet 
	 * et le constructeur d'arité nulle.<br/>
	 * <ul>
	 * <li>garantit que le constructeur complet 
	 * alimente pathAbsoluFichierProperties.</li>
	 * <li>garantit que le constructeur complet 
	 * alimente fichierProperties.</li>
	 * <li>garantit que le constructeur complet pointe 
	 * sur le bon properties.</li>
	 * <li>garantit que le constructeur d'arité nulle + setters 
	 * alimente pathAbsoluFichierProperties.</li>
	 * <li>garantit que le constructeur d'arité nulle + setters 
	 * alimente fichierProperties.</li>
	 * <li>garantit que le constructeur d'arité nulle + setters 
	 * pointe sur le bon properties.</li>
	 * <li>garantit que les setters modifient 
	 * les attributs calculés.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testConstructeurs() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GestionnairePropertiesTest - méthode testConstructeurs() ********** ");
		}

		
		// CONSTRUCTION AVEC LE CONSTRUCTEUR COMPLET
		// ET LE LANGAGE ANGLAIS US. ****************************************
		final String nomBaseFichierProperties = NOM_BASE_LABEL;
		LocaleManager.selectionnerLocaleApplication(LOCALE_US_STRING);
		// Récupération de la Locale courante auprès du LocaleManager.
		final Locale localeCouranteUS = LocaleManager.getLocaleApplication();
		
		/* Instanciation du Gestionnaire avec le constructeur complet. */
		final GestionnaireProperties gestionnairePropertiesCompletUS 
			= new GestionnaireProperties(nomBaseFichierProperties, localeCouranteUS);
		
		/* récupération du path du properties auprès du gestionnaire. */
		final Path pathPropCompletUS 
			= gestionnairePropertiesCompletUS.getPathAbsoluFichierProperties();
		/* récupération du File properties auprès du gestionnaire. */
		final File filePropCompletUS 
			= gestionnairePropertiesCompletUS.getFichierProperties();
					
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(
					"CONSTRUCTEUR COMPLET - path absolu du properties avec la Locale "  
						+ localeCouranteUS.toString() 
							+ DEUX_POINTS
							+ pathPropCompletUS.toString());
		}

		/* garantit que le constructeur complet 
		 * alimente pathAbsoluFichierProperties. */
		assertNotNull(
				"Le path du properties US ne doit pas être null : "
					, pathPropCompletUS);
		/* garantit que le constructeur complet 
		 * alimente fichierProperties. */
		assertNotNull(
				"Le file du properties US ne doit pas être null : "
					, filePropCompletUS);
		/* garantit que le constructeur complet 
		 * pointe sur le bon properties. */
		assertEquals(
				"le nom du filePropCompletUS doit être labels_en_US.properties : "
					, "labels_en_US.properties"
						, filePropCompletUS.getName());
		
		
		// CONSTRUCTION AVEC LE CONSTRUCTEUR D'ARITE NULLE
		// ET LE LANGAGE ANGLAIS US. ****************************************
		/* Instanciation du Gestionnaire avec le constructeur d'arité nulle. */
		final GestionnaireProperties gestionnairePropertiesAriteNulle 
			= new GestionnaireProperties();
		/* utilisation des setters. */
		gestionnairePropertiesAriteNulle
			.setNomBaseFichierProperties(nomBaseFichierProperties);
		gestionnairePropertiesAriteNulle.setLocale(localeCouranteUS);
		
		/* récupération du path du properties auprès du gestionnaire. */
		final Path pathPropUsAriteNulle 
			= gestionnairePropertiesAriteNulle
				.getPathAbsoluFichierProperties();
		/* récupération du File properties auprès du gestionnaire. */
		final File filePropUSAriteNulle 
			= gestionnairePropertiesAriteNulle
				.getFichierProperties();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(
					"CONSTRUCTEUR NULL - path absolu du properties avec la Locale "  
						+ localeCouranteUS.toString() 
							+ DEUX_POINTS
							+ pathPropUsAriteNulle.toString());
		}
		
		/* garantit que le constructeur d'arité nulle + setters 
		 * alimente pathAbsoluFichierProperties. */
		assertNotNull(
				"Le path du properties US ne doit pas être null : "
					, pathPropUsAriteNulle);
		/* garantit que le constructeur d'arité nulle + setters 
		 * alimente fichierProperties. */
		assertNotNull(
				"Le file du properties US ne doit pas être null : "
					, filePropUSAriteNulle);
		/* garantit que le constructeur d'arité nulle + setters 
		 * pointe sur le bon properties. */
		assertEquals(
				"le nom du filePropCompletUS doit être labels_en_US.properties : "
					, "labels_en_US.properties"
						, filePropUSAriteNulle.getName());

		
		// CHANGEMENT DE LOCALE AVEC LE CONSTRUCTEUR D'ARITE NULLE
		// PASSAGE AU LANGAGE FRANCAIS FR. ****************************************
		LocaleManager.selectionnerLocaleApplication(LOCALE_FR_STRING);
		// Récupération de la Locale courante auprès du LocaleManager.
		final Locale localeCouranteFR = LocaleManager.getLocaleApplication();
		
		/* utilisation des setters. */
		gestionnairePropertiesAriteNulle.setLocale(localeCouranteFR);
		
		/* récupération du path du properties auprès du gestionnaire. */
		final Path pathPropFRAriteNulle 
			= gestionnairePropertiesAriteNulle
				.getPathAbsoluFichierProperties();
		
		/* récupération du File properties auprès du gestionnaire. */
		final File filePropFRAriteNulle 
			= gestionnairePropertiesAriteNulle
				.getFichierProperties();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(
					"CONSTRUCTEUR NULL - path absolu du properties avec la Locale "  
						+ localeCouranteFR.toString() 
							+ DEUX_POINTS
							+ pathPropFRAriteNulle.toString());
		}
		
		/* garantit que les setters modifient les attributs calculés. */
		assertEquals(
				"le nom du filePropCompletUS doit être labels_fr_FR.properties après setLocale(française) : "
					, "labels_fr_FR.properties"
						, filePropFRAriteNulle.getName());

	} // Fin de testConstructeurs()._______________________________________


	
	/**
	 * Teste l'équivalence entre le constructeur complet 
	 * et le constructeur d'arité nulle + setters.<br/>
	 * <ul>
	 * <li>garantit que les gestionnaires instanciés 
	 * via le constructeur complet ou d'arité nulle + setters 
	 * sont equals().</li>
	 * <li>garantit que les pathAbsoluFichierProperties générés 
	 * par le constructeur complet ou d'arité nulle + setters 
	 * sont equals().</li>
	 * <li>garantit que les fichierProperties générés 
	 * par le constructeur complet ou d'arité nulle + setters 
	 * sont equals().</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@Test
	public void testEgaliteConstructeurs() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GestionnairePropertiesTest - méthode testEgaliteConstructeurs() ********** ");
		}

		
		final String nomBaseFichierProperties = NOM_BASE_MESSAGE;
		LocaleManager.selectionnerLocaleApplication(LOCALE_FR_STRING);
		// Récupération de la Locale courante auprès du LocaleManager.
		final Locale localeCouranteFR = LocaleManager.getLocaleApplication();
		
		// CONSTRUCTION AVEC LE CONSTRUCTEUR COMPLET
		// ET LE LANGAGE FRANCAIS FR. ****************************************
		/* Instanciation du Gestionnaire avec le constructeur complet. */
		final GestionnaireProperties gestionnairePropertiesCompletFR 
			= new GestionnaireProperties(
					nomBaseFichierProperties, localeCouranteFR);
		
		/* récupération du path. */
		final Path pathCompletFR 
			= gestionnairePropertiesCompletFR
				.getPathAbsoluFichierProperties();
		
		/* récupération du File. */
		final File filePropertiesCompletFR 
			= gestionnairePropertiesCompletFR.getFichierProperties();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(
					"CONSTRUCTEUR COMPLET - path absolu du properties avec la Locale "  
						+ localeCouranteFR.toString() 
							+ DEUX_POINTS
							+ pathCompletFR.toString());
		}
		
		
		// CONSTRUCTION AVEC LE CONSTRUCTEUR D'ARITE NULLE + SETTERS
		// ET LE LANGAGE FRANCAIS FR. ****************************************
		/* Instanciation du Gestionnaire avec 
		 * le constructeur d'arité nulle + setters. */
		final GestionnaireProperties gestionnairePropertiesAriteNulleFR 
			= new GestionnaireProperties();
		
		/* utilisation des setters. */
		gestionnairePropertiesAriteNulleFR
			.setNomBaseFichierProperties(nomBaseFichierProperties);
		gestionnairePropertiesAriteNulleFR.setLocale(localeCouranteFR);
		
		/* récupération du path. */
		final Path pathAriteNulleFR 
			= gestionnairePropertiesAriteNulleFR
				.getPathAbsoluFichierProperties();
		
		/* récupération du File. */
		final File filePropertiesAriteNulleFR 
			= gestionnairePropertiesAriteNulleFR.getFichierProperties();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(
					"CONSTRUCTEUR NULL - path absolu du properties avec la Locale "  
						+ localeCouranteFR.toString() 
							+ DEUX_POINTS
							+ pathAriteNulleFR.toString());
		}

		
		/* garantit que les gestionnaires instanciés via le 
		 * constructeur complet ou d'arité nulle + setters sont equals(). */
		assertEquals("les gestionnaires instanciés via le constructeur complet "
				+ "ou d'arité nulle + setters doivent être equals() : "
				, gestionnairePropertiesCompletFR
					, gestionnairePropertiesAriteNulleFR);
		
		/* garantit que les pathAbsoluFichierProperties générés 
		 * par le constructeur complet ou d'arité nulle + setters 
		 * sont equals(). */
		assertEquals("Les path générés doivent être equals : "
				, pathCompletFR
					, pathAriteNulleFR);
		
		/* garantit que les fichierProperties générés 
		 * par le constructeur complet ou d'arité nulle + setters 
		 * sont equals(). */
		assertEquals("Les fichiers properties générés doivent être equals : "
				, filePropertiesCompletFR
					, filePropertiesAriteNulleFR);

	} // Fin de testEgaliteConstructeurs().________________________________
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @throws Exception :  :  .<br/>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testCrea() throws Exception {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GestionnairePropertiesTest - méthode testEgaliteConstructeurs() ********** ");
		}
		
		final String nomBaseFichierProperties = "properties_test";
		LocaleManager.selectionnerLocaleApplication(LOCALE_FR_STRING);
		// Récupération de la Locale courante auprès du LocaleManager.
		final Locale localeCouranteFR = LocaleManager.getLocaleApplication();
		
		// CONSTRUCTION AVEC LE CONSTRUCTEUR COMPLET
		// ET LE LANGAGE FRANCAIS FR. ****************************************
		/* Instanciation du Gestionnaire avec le constructeur complet. */
		final GestionnaireProperties gestionnairePropertiesCompletFR 
			= new GestionnaireProperties(
					nomBaseFichierProperties, localeCouranteFR);
		
		/* récupération du path. */
		final Path pathCompletFR 
			= gestionnairePropertiesCompletFR
				.getPathAbsoluFichierProperties();
		
		/* récupération du File. */
		final File filePropertiesCompletFR 
			= gestionnairePropertiesCompletFR.getFichierProperties();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(
					"CONSTRUCTEUR COMPLET - path absolu du properties avec la Locale "  
						+ localeCouranteFR.toString() 
							+ DEUX_POINTS
							+ pathCompletFR.toString());
		}
		
		gestionnairePropertiesCompletFR.creerFichierSurDisque(filePropertiesCompletFR);
		
		/* chemin relatif du template par rapport aux ressources internes src/main/resources. */
		final String cheminRelatifTemplate = "commentaires_properties/commentaires_labels_properties.txt";
		/* variable à substituer dans le template. */
		final String variable = "{$Locale}";
		/* valeur de substitution. */
		final String substituant = localeCouranteFR.toString();
		
		/* Obtention du template substitué sous forme de String dans le code java. */
		final String commentaire 
			= gestionnaireTemplate.fournirTemplateSubstitueSousFormeString(
					cheminRelatifTemplate, variable, substituant);
		
		/* injection du template substitué dans le code java. */
		gestionnairePropertiesCompletFR.remplirEnDurFichierProperties(commentaire);

	}
	

	
	/**
	 * Avant tout test.<br/>
	 * @throws Exception 
	 */
	@BeforeClass
	public static final void setup() throws Exception {
		gestionnaireTemplate = new GestionnaireTemplates();
	}
	
} // FIN DE LA CLASSE GestionnairePropertiesTest.----------------------------
