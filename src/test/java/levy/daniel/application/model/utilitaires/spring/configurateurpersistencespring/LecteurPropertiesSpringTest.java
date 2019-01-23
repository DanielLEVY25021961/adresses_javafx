package levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring;

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
		}
			

	} // Fin de testLireProperties().________________________________________



	
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
