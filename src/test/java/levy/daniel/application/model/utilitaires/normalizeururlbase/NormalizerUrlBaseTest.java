package levy.daniel.application.model.utilitaires.normalizeururlbase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * CLASSE NormalizerUrlBaseTest :<br/>
 * Test JUnit de la classe NormalizerUrlBase.<br/>
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
 * @since 24 janv. 2019
 *
 */
public class NormalizerUrlBaseTest {

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
	 * " : \n".
	 */
	public static final String DEUX_POINTS_LIGNE = " : \n";
	
	/**
	 * "jdbc:hsqldb:file:D:/Donnees/eclipse/eclipseworkspace/adresses_javafx/data/base-adresses_javafx-hsqldb/base-adresses_javafx;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE;DB_CLOSE_DELAY=-1;".
	 */
	public static final String URL_FILE1 
		= "jdbc:hsqldb:file:D:/Donnees/eclipse/eclipseworkspace/adresses_javafx/data/base-adresses_javafx-hsqldb/base-adresses_javafx;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE;DB_CLOSE_DELAY=-1;";
	
	/**
	 * "jdbc:hsqldb:file:./data/base-adresses_javafx-h2/base-adresses_javafx;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE;DB_CLOSE_DELAY=-1;".
	 */
	public static final String URL_FILE2 
		= "jdbc:hsqldb:file:./data/base-adresses_javafx-h2/base-adresses_javafx;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE;DB_CLOSE_DELAY=-1;";
	
	/**
	 * "jdbc:h2:file:./data/base-adresses_javafx-h2/base-adresses_javafx".
	 */
	public static final String URL_FILE3 
		= "jdbc:h2:file:./data/base-adresses_javafx-h2/base-adresses_javafx";
	
	/**
	 * "jdbc:h2:file:D:/Donnees/eclipse/eclipseworkspace/adresses_javafx/data/base-adresses_javafx-h2/base-adresses_javafx".
	 */
	public static final String URL_FILE4 
		= "jdbc:h2:file:D:/Donnees/eclipse/eclipseworkspace/adresses_javafx/data/base-adresses_javafx-h2/base-adresses_javafx";
	
	/**
	 * "jdbc:hsqldb:mem:base-adresses_javafx".
	 */
	public static final String URL_MEM1 
		= "jdbc:hsqldb:mem:base-adresses_javafx";
	
	/**
	 * "jdbc:h2:mem:base-adresses_javafx".
	 */
	public static final String URL_MEM2 
		= "jdbc:h2:mem:base-adresses_javafx";
	
	/**
	 * "jdbc:postgresql://localhost:5432/base-adresses_javafx".
	 */
	public static final String URL_SERVEUR1 
		= "jdbc:postgresql://localhost:5432/base-adresses_javafx";
	
	/**
	 * "jdbc:mysql://localhost:3306/base-adresses_javafx".
	 */
	public static final String URL_SERVEUR2 
		= "jdbc:mysql://localhost:3306/base-adresses_javafx";
	
	/**
	 * "base-adresses_javafx".
	 */
	public static final String BD = "base-adresses_javafx";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(NormalizerUrlBaseTest.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public NormalizerUrlBaseTest() {		
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * .<br/>
	 * <br/>
	 * : void :  .<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreerUrlEncapsulationModeFile() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE NormalizerUrlBaseTest - méthode testCreerUrlEncapsulationModeFile() ********** ");
		}

		final UrlEncapsulation urlFile1 
			= NormalizerUrlBase.creerUrlEncapsulationModeFile(URL_FILE1, BD);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(urlFile1.toString());
		}
		
		assertEquals("le mode doit être FILE : "
				, EnumModesBase.FILE
					, urlFile1.getMode());
		
		assertFalse("le chemin dans URL_FILE1 ne doit pas être relatif : "
				, urlFile1.isCheminRelatif());
		
		final UrlEncapsulation urlFile2 
		= NormalizerUrlBase.creerUrlEncapsulationModeFile(URL_FILE2, BD);
	
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(urlFile2.toString());
		}
		
		assertEquals("le mode doit être FILE : "
				, EnumModesBase.FILE
					, urlFile2.getMode());
		
		assertTrue("le chemin dans URL_FILE2 doit être relatif : "
				, urlFile2.isCheminRelatif());
		
	} // Fin de testCreerUrlEncapsulationModeFile()._______________________
	

	
	@SuppressWarnings(UNUSED)
	@Test
	public void testCreerUrlEncapsulationModeMem() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE NormalizerUrlBaseTest - méthode testCreerUrlEncapsulationModeMem() ********** ");
		}
		
		final UrlEncapsulation urlMem1 
			= NormalizerUrlBase.creerUrlEncapsulationModeMemoire(URL_MEM1, BD);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(urlMem1.toString());
		}

		assertEquals("le mode doit être MEMOIRE : "
				, EnumModesBase.MEMOIRE
					, urlMem1.getMode());
		
		final UrlEncapsulation urlMem2 
			= NormalizerUrlBase.creerUrlEncapsulationModeMemoire(URL_MEM2, BD);
	
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(urlMem2.toString());
		}
	
		assertEquals("le mode doit être MEMOIRE : "
				, EnumModesBase.MEMOIRE
					, urlMem2.getMode());
		
	} // Fin de testCreerUrlEncapsulationModeMem().________________________
	

	
	/**
	 * teste la méthode determinerMode(String pUrl).<br/>
	 * <ul>
	 * <li>garantit que determinerMode(String pUrl) retourne 
	 * le bon mode de fonctionnement de la base.</li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testDeterminerMode() {
					
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE NormalizerUrlBaseTest - méthode testDeterminerMode() ********** ");
		}

		final EnumModesBase modeFile1 = NormalizerUrlBase.determinerMode(URL_FILE1);
		final EnumModesBase modeFile2 = NormalizerUrlBase.determinerMode(URL_FILE2);
		final EnumModesBase modeFile3 = NormalizerUrlBase.determinerMode(URL_FILE3);
		final EnumModesBase modeFile4 = NormalizerUrlBase.determinerMode(URL_FILE4);
		
		final EnumModesBase modeMem1 = NormalizerUrlBase.determinerMode(URL_MEM1);
		final EnumModesBase modeMem2 = NormalizerUrlBase.determinerMode(URL_MEM2);
		
		final EnumModesBase modeServeur1 = NormalizerUrlBase.determinerMode(URL_SERVEUR1);
		final EnumModesBase modeServeur2 = NormalizerUrlBase.determinerMode(URL_SERVEUR2);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println("- MODE DE L'URL URL_FILE1 : " + URL_FILE1 + DEUX_POINTS_LIGNE + modeFile1.toString());
			System.out.println("- MODE DE L'URL URL_FILE2 : " + URL_FILE2 + DEUX_POINTS_LIGNE + modeFile2.toString());
			System.out.println("- MODE DE L'URL URL_FILE3 : " + URL_FILE3 + DEUX_POINTS_LIGNE + modeFile3.toString());
			System.out.println("- MODE DE L'URL URL_FILE4 : " + URL_FILE4 + DEUX_POINTS_LIGNE + modeFile4.toString());
			
			System.out.println("- MODE DE L'URL URL_MEM1 : " + URL_MEM1 + DEUX_POINTS_LIGNE + modeMem1.toString());
			System.out.println("- MODE DE L'URL URL_MEM2 : " + URL_MEM2 + DEUX_POINTS_LIGNE + modeMem2.toString());
			
			System.out.println("- MODE DE L'URL URL_SERVEUR1 : " + URL_SERVEUR1 + DEUX_POINTS_LIGNE + modeServeur1.toString());
			System.out.println("- MODE DE L'URL URL_SERVEUR2 : " + URL_SERVEUR2 + DEUX_POINTS_LIGNE + modeServeur2.toString());
		}
		
		assertEquals("URL_FILE1 doit être en mode FILE : "
				, EnumModesBase.FILE
					, modeFile1);
		
		assertEquals("URL_FILE2 doit être en mode FILE : "
				, EnumModesBase.FILE
					, modeFile2);
		
		assertEquals("URL_FILE3 doit être en mode FILE : "
				, EnumModesBase.FILE
					, modeFile3);
		
		assertEquals("URL_FILE4 doit être en mode FILE : "
				, EnumModesBase.FILE
					, modeFile4);
		
		assertEquals("URL_MEM1 doit être en mode MEMOIRE : "
				, EnumModesBase.MEMOIRE
					, modeMem1);

		assertEquals("URL_MEM2 doit être en mode MEMOIRE : "
				, EnumModesBase.MEMOIRE
					, modeMem2);
		
		assertEquals("URL_SERVEUR1 doit être en mode SERVEUR : "
				, EnumModesBase.SERVEUR
					, modeServeur1);

		assertEquals("URL_SERVEUR2 doit être en mode SERVEUR : "
				, EnumModesBase.SERVEUR
					, modeServeur2);

	} // Fin de testDeterminerMode().______________________________________


	
	
} // FIN DE LA CLASSE NormalizerUrlBaseTest.---------------------------------
