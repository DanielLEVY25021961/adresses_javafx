package levy.daniel.application.apptechnic.configurationmanagers.gestionnairespreferences;

import static org.junit.Assert.assertNotNull;

import java.nio.charset.Charset;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


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
	@Test
	public void testCharsetName() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
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
	
	
	
} // FIN DE LA CLASSE GestionnairePreferencesTest.---------------------------
