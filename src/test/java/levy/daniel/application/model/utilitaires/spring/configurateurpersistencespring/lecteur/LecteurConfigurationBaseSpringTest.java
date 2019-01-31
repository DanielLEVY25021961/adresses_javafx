package levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring.lecteur;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * CLASSE LecteurConfigurationBaseSpringTest :<br/>
 * Test JUnit de la classe LecteurConfigurationBaseSpring.<br/>
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
 * @since 31 janv. 2019
 *
 */
public class LecteurConfigurationBaseSpringTest {

	// ************************ATTRIBUTS************************************/
		
	/**
	* Boolean qui commande l'affichage pour tous les tests.<br/>
	*/
	public static final Boolean AFFICHAGE_GENERAL = true;
	
	/**
	* "unused".<br/>
	*/
	public static final String UNUSED = "unused";
	
	/**
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
	/**
	 * ", ".<br/>
	 */
	public static final String VIRGULE_ESPACE = ", ";
	
	/**
	 * "null".<br/>
	 */
	public static final String NULL = "null";
	
	/**
	 * " - ".
	 */
	public static final String TIRET_ESPACE = " - ";
	
	/**
	 * "BIDON : ".<br/>
	 */
	public static final String BIDON 
		= "BIDON : ";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(LecteurConfigurationBaseSpringTest.class);

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public LecteurConfigurationBaseSpringTest() {		
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________


	/**
	 * .<br/>
	 * <br/>
	 * : void :  .<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFonctionnement() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE LecteurConfigurationBaseSpringTest - méthode testFonctionnement() ********** ");
		}

	}


	
} // FIN DE LA CLASSE LecteurConfigurationBaseSpringTest.--------------------
