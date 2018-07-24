package levy.daniel.application.apptechnic.configurationmanagers.gestionnairespreferences;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.ConfigurationApplicationManager;


/**
 * CLASSE GestionnairePreferencesTest :<br/>
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
 * @since 24 juil. 2018
 *
 */
public class GestionnairePreferencesTest {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	/**
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");

	/**
	 * Charset.forName("Windows-1252").<br/>
	 * Charset ANSI.<br/>
	 */
	public static final Charset CHARSET_ANSI 
		= Charset.forName("Windows-1252");
	
	/**
	 * fichier preferences.properties.<br/>
	 */
	public File filePreferencesProperties;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(GestionnairePreferencesTest.class);

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public GestionnairePreferencesTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * test bidon.<br/>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testCharsetName() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GestionnairePreferencesTest - méthode testCharsetName() ********** ");
		}

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println("CHARSET_UTF8.name() : " + CHARSET_UTF8.name());
			System.out.println("CHARSET_UTF8.displayName(Locale.FRANCE) : " + CHARSET_UTF8.displayName(Locale.FRANCE));
			
			System.out.println("CHARSET_ANSI.name() : " + CHARSET_ANSI.name());
			System.out.println("CHARSET_ANSI.displayName(Locale.FRANCE) : " + CHARSET_ANSI.displayName(Locale.FRANCE));
		}
		
		assertNotNull("CHARSET_UTF8.name() n'est pas null : ", CHARSET_UTF8.name());
		
	} // Fin de testCharsetName()._________________________________________
	

	
	/**
	 * Vérifie la création automatique de preferences.properties 
	 * si il n'existe pas.<br/>
	 * 
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@Test
	public void testInitialisation() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GestionnairePreferencesTest - méthode testInitialisation() ********** ");
		}
		
		this.filePreferencesProperties = this.fournirFilePreferencesProperties();
		
		if (this.filePreferencesProperties.exists()) {
			final boolean detruit = this.filePreferencesProperties.delete();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("preferences.properties détruit : " + detruit);
			}
			
			assertFalse(
					"le fichier preferences.properties doit avoir été détruit : "
						, this.filePreferencesProperties.exists());
		}
		
		final Charset charsetApplication 
			= GestionnairePreferences.getCharsetApplication();
		
		assertTrue("this.filePreferencesProperties.exists() : "
				, this.filePreferencesProperties.exists());
		
	} // Fin de testInitialisation().______________________________________
	

	/**
	 * Garantit que les setters permettent de modifier 
	 * preferences.properties.<br/>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@Test
	public void testParamétrage() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GestionnairePreferencesTest - méthode testParamétrage() ********** ");
		}
		
		/* UTILISATION DU SETTER (paramétrage). */
		GestionnairePreferences.setCharsetApplication(CHARSET_ANSI);
		
		final Charset charsetAppliqueANSI 
			= GestionnairePreferences.getCharsetApplication();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Charset courant : " + charsetAppliqueANSI.displayName());
		}
		
		assertEquals(
				"Le Charset paramétré doit être CHARSET_ANSI : "
					, CHARSET_ANSI, charsetAppliqueANSI);
		
		/* UTILISATION DU SETTER (paramétrage). */
		GestionnairePreferences.setCharsetApplication(CHARSET_UTF8);
		
		final Charset charsetAppliqueUTF8 
			= GestionnairePreferences.getCharsetApplication();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Charset courant : " + charsetAppliqueUTF8.displayName());
		}
		
		assertEquals(
				"Le Charset paramétré doit être CHARSET_UTF8 : "
					, CHARSET_UTF8, charsetAppliqueUTF8);
		
	} // Fin de testParamétrage()._________________________________________
	
	
	
	/**
	 * retourne le File preferences.properties.<br/>
	 *
	 * @return File : preferences.properties
	 * 
	 * @throws Exception
	 */
	private File fournirFilePreferencesProperties() throws Exception {
		
		/* obtient le path du properties dans les 
		 * ressources externes auprès du 
		 * ConfigurationApplicationManager. */
		final Path pathRessourcesExternes 
		= Paths.get(ConfigurationApplicationManager
				.getPathRessourcesExternes());
	
		
		final Path pathAbsoluPreferencesProperties 
			= pathRessourcesExternes
				.resolve("preferences/preferences.properties");
				
		final File filePreferencesPropertiesLocal 
			= pathAbsoluPreferencesProperties.toFile();
		
		return filePreferencesPropertiesLocal;
		
	} // Fin de fournirFilePreferencesProperties().________________________
		
		
} // FIN DE LA CLASSE GestionnairePreferencesTest.---------------------------
