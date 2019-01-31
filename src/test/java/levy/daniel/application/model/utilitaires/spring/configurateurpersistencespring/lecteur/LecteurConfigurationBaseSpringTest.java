package levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring.lecteur;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import levy.daniel.application.model.utilitaires.spring.configurateurspring.ConfigurateurSpringFrmkAnnotationJPAH2File;

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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ConfigurateurSpringFrmkAnnotationJPAH2File.class})
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
	 * "Classe ContactSimpleDAOJPASpringTest".
	 */
	public static final String CLASSE_CONTACTSIMPLE_DAOJPASPRING_TEST 
		= "Classe ContactSimpleDAOJPASpringTest";
	
	/**
	 * Contexte SPRING injecté par SPRING dès que 
	 * la configuration est terminée.<br/>
	 * <ul>
	 * <li><b>injecté via son SETTER</b>.</li>
	 * <li>injecté <i>après</i> avantTests() (BeforeClass) 
	 * et après le Constructeur du Test.</li>
	 * <li>injecté <i>avant</i> avantChaqueTest() (Before).</li>
	 * </ul>
	 */
    private GenericApplicationContext contextInjectable;	
	
	/**
	 * Contexte SPRING pour les tests.<br/>
	 */
	private static transient GenericApplicationContext contexteSpring;
		
	/**
	 * <b>lecteur SPRING du fichier properties 
	 * de configuration de la base</b>.
	 * <ul>
	 * <li>org.springframework.core.env.Environment</li>
	 * </ul>
	 */
	private Environment environmentSpring;
	
	/**
	 * Lecteur de configuration de base de données SPRING.<br/>
	 * Objet du présent test.
	 */
	private transient LecteurConfigurationBaseSpring lecteurConfigurationBaseSpring;
	
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
		
		this.lecteurConfigurationBaseSpring 
		= new LecteurConfigurationBaseSpring(this.environmentSpring);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(
					this.lecteurConfigurationBaseSpring.toString());
		}

		assertTrue(BIDON, 1 == 1);
		
	} // Fin de testFonctionnement().______________________________________
	

	
	/**
	 * Getter du Contexte SPRING injecté par SPRING dès que 
	 * la configuration est terminée.<br/>
	 * <ul>
	 * <li><b>injecté via son SETTER</b>.</li>
	 * <li>injecté <i>après</i> avantTests() (BeforeClass) 
	 * et après le Constructeur du Test.</li>
	 * <li>injecté <i>avant</i> avantChaqueTest() (Before).</li>
	 * </ul>
	 *
	 * @return this.contextInjectable : GenericApplicationContext.<br/>
	 */
	public GenericApplicationContext getContextInjectable() {
		return this.contextInjectable;
	} // Fin de getContextInjectable().____________________________________



	/**
	* Setter du Contexte SPRING injecté par SPRING dès que 
	* la configuration est terminée.<br/>
	* <ul>
	* <li><b>injecté via son SETTER</b>.</li>
	* <li>injecté <i>après</i> avantTests() (BeforeClass) 
	* et après le Constructeur du Test.</li>
	* <li>injecté <i>avant</i> avantChaqueTest() (Before).</li>
	* </ul>
	*
	* @param pContextInjectable : GenericApplicationContext : 
	* valeur à passer à this.contextInjectable.<br/>
	*/
	@Autowired
	public void setContextInjectable(
			final GenericApplicationContext pContextInjectable) {
		
		this.contextInjectable = pContextInjectable;
		
		/* instancie le contexteSpring STATIC la première fois. */
		if (contexteSpring == null || !contexteSpring.isActive()) {
			contexteSpring = this.contextInjectable;
		}
		
	} // Fin de setContextInjectable(...)._________________________________



	/**
	 * Getter du <b>lecteur SPRING du fichier properties 
	 * de configuration de la base</b>.
	 * <ul>
	 * <li>org.springframework.core.env.Environment</li>
	 * </ul>
	 *
	 * @return this.environmentSpring : 
	 * org.springframework.core.env.Environment.<br/>
	 */
	public final Environment getEnvironmentSpring() {
		return this.environmentSpring;
	} // Fin de getEnvironmentSpring().____________________________________


	
	/**
	* Setter du <b>lecteur SPRING du fichier properties 
	* de configuration de la base</b>.
	* <ul>
	* <li><b>injecté via son SETTER</b>.</li>
	* <li>injecté <i>après</i> avantTests() (BeforeClass) 
	* et après le Constructeur du Test.</li>
	* <li>injecté <i>avant</i> avantChaqueTest() (Before).</li>
	* </ul>
	*
	* @param pEnvironmentSpring : 
	* org.springframework.core.env.Environment. : 
	* valeur à passer à this.environmentSpring.<br/>
	*/
	@Autowired(required=true)
	public final void setEnvironmentSpring(
			final Environment pEnvironmentSpring) {
		this.environmentSpring = pEnvironmentSpring;
	} // Fin de setEnvironmentSpring(...)._________________________________

	
	
} // FIN DE LA CLASSE LecteurConfigurationBaseSpringTest.--------------------
