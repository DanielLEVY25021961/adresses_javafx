package levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * CLASSE LecteurPropertiesSpringTest :<br/>
 * Test JUnit de la classe LecteurPropertiesSpring.<br/>
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
 * @since 20 janv. 2019
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {LecteurPropertiesSpring.class})
public class LecteurPropertiesSpringTest {

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
	 * .
	 */
	private LecteurPropertiesSpring lecteurPropertiesSpring;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(LecteurPropertiesSpringTest.class);
	

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public LecteurPropertiesSpringTest() {		
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * .<br/>
	 * <br/>
	 * : void :  .<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testLireProperties() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE LecteurPropertiesSpringTest - méthode testLireProperties() ********** ");
		}

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println(
					"NOM DE L'UNITE DE PERSISTENCE DANS LE CONTENEUR LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPersistenceUnitName());
			
			System.out.println(
					"TYPE DE TRANSACTION DANS LE CONTENEUR LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getTransactionType());
			
			System.out.println(
					"PROVIDER DE PERSISTENCE DANS LE CONTENEUR LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPersistenceProviderClassName());
			
			System.out.println(
					"URL DANS LE CONTENEUR LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getUrl());
		}
			

	} // Fin de testLireProperties().________________________________________


	/**
	 * .<br/>
	 * <br/>
	 * : void :  .<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testNormaliser() {
		
		final String urlFile1 = "jdbc:hsqldb:file:D:/Donnees/eclipse/eclipseworkspace/adresses_javafx/data/base-adresses_javafx-hsqldb/base-adresses_javafx;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE;DB_CLOSE_DELAY=-1;";
		final String urlFile2 = "jdbc:hsqldb:file:./data/base-adresses_javafx-h2/base-adresses_javafx;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE;DB_CLOSE_DELAY=-1;";
		final String urlFile3 = "jdbc:h2:file:./data/base-adresses_javafx-h2/base-adresses_javafx";
		final String urlFile4 = "jdbc:h2:file:D:/Donnees/eclipse/eclipseworkspace/adresses_javafx/data/base-adresses_javafx-h2/base-adresses_javafx";
		
		final String urlMem1 = "jdbc:hsqldb:mem:base-adresses_javafx";
		final String urlMem2 = "jdbc:h2:mem:base-adresses_javafx";
		
		final String urlServeur1 = "jdbc:postgresql://localhost:5432/base-adresses_javafx";
		final String urlServeur2 = "jdbc:mysql://localhost:3306/base-adresses_javafx";
		
		this.normaliser(urlFile2, "base-adresses_javafx");
	}

	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @param pUrl
	 * @param pBase 
	 * 
	 * @return : String :  .<br/>
	 */
	public String normaliser(final String pUrl, final String pBase) {
		
		final String motifRegexFile = "^(jdbc:(.+):file:)(((\\.{0,1})(.+" + pBase + "))(.*))$";
		final String motifRegexMem = "^(jdbc:(.+):mem:)";
		final String motifRegexServeur = "^(jdbc:(.+)://)";
		
		final Pattern patternFile = Pattern.compile(motifRegexFile);
		final Pattern patternMem = Pattern.compile(motifRegexMem);
		final Pattern patternServeur = Pattern.compile(motifRegexServeur);
		
		final Matcher matcherFile = patternFile.matcher(pUrl);
		final Matcher matcherMem = patternMem.matcher(pUrl);
		final Matcher matcherServeur = patternServeur.matcher(pUrl);
		
		if (matcherFile.find()) {
			System.out.println("MODE FILE");
		} else if (matcherMem.find()) {
			System.out.println("MODE MEMOIRE");
		} else if (matcherServeur.find()) {
			System.out.println("MODE SERVEUR");
		} else {
			System.out.println("PROBLEME");
		}
		
		if (matcherFile.matches()) {
			
			System.out.println("MODE FILE");
			
			for (int i = 0; i <= matcherFile.groupCount(); i++) {
				System.out.println("GROUP(" + i + ") = " + matcherFile.group(i));
			}
			
		} else if (matcherMem.find()) {
			System.out.println("MODE MEMOIRE");
		} else if (matcherServeur.find()) {
			System.out.println("MODE SERVEUR");
		} else {
			System.out.println("PROBLEME");
		}
		
		return null;
	}

	
	
	
	/**
	 * Getter .
	 *
	 * @return this.lecteurPropertiesSpring : LecteurPropertiesSpring.<br/>
	 */
	public LecteurPropertiesSpring getLecteurPropertiesSpring() {
		return this.lecteurPropertiesSpring;
	}



	
	/**
	* .
	*
	* @param pLecteurPropertiesSpring : LecteurPropertiesSpring : 
	* valeur à passer à this.lecteurPropertiesSpring.<br/>
	*/
	@Autowired(required=true)
    @Qualifier("LecteurPropertiesSpring")
	public void setLecteurPropertiesSpring(
			final LecteurPropertiesSpring pLecteurPropertiesSpring) {
		this.lecteurPropertiesSpring = pLecteurPropertiesSpring;
	}
	
	
	
	


} // FIN DE LA CLASSE LecteurPropertiesSpringTest.---------------------------
