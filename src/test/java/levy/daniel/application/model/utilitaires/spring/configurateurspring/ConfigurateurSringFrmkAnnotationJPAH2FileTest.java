package levy.daniel.application.model.utilitaires.spring.configurateurspring;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import levy.daniel.application.model.utilitaires.spring.afficheurcontexte.AfficheurContexteSpring;

/**
 * CLASSE ConfigurateurSringFrmkAnnotationJPAH2FileTest :<br/>
 * Test JUnit de la classe ConfigurateurSpringFrmkAnnotationJPAH2File.<br/>
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
 * @since 13 janv. 2019
 *
 */
public class ConfigurateurSringFrmkAnnotationJPAH2FileTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	/**
	 * UNUSED : String :<br/>
	 * "unused".<br/>
	 */
	private static final String UNUSED ="unused";

	/**
	 * SEP_MOINS_ARERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEP_MOINS_ARERE = " - ";

	/**
	 * "Classe ConfigurateurSringFrmkAnnotationJPAH2FileTest".
	 */
	public static final String CLASSE_CONFIGURATEUR_TEST 
		= "Classe ConfigurateurSringFrmkAnnotationJPAH2FileTest";
	
	/**
	 * Contexte SPRING pour les tests.<br/>
	 */
	private static transient ApplicationContext contexteSpring;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
	= LogFactory.getLog(ConfigurateurSringFrmkAnnotationJPAH2FileTest.class);
	
	// *************************METHODES************************************/

	/**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public ConfigurateurSringFrmkAnnotationJPAH2FileTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * garantit que le contexte est bien instancié.<br/>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testConfig() {
					
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE ConfigurateurSringFrmkAnnotationJPAH2FileTest - méthode testConfig() ********** ");
		}

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("DANS testConfig() FILE AFFICHERCONTEXTE");
			afficherContexte();
		}
		
		assertNotNull("le contexte Spring ne doit pas être null : "
					, contexteSpring);
		
		/* fermeture du contexte. */
		final AnnotationConfigApplicationContext context 
			= (AnnotationConfigApplicationContext) contexteSpring;
		
		context.close();
		
	} // Fin de testConfig().______________________________________________

	
	
	/**
	 * method avantTests() :<br/>
	 * <ul>
	 * <li>instructions exécutées <b>avant l'ensemble des tests</b> 
	 * de la classe JUnit.</li>
	 * <li><b>A REMPLIR A LA MAIN</b></li>
	 * <li>instancie le contexte Spring déclaré par Annotations.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@BeforeClass
   public static void avantTests() throws Exception {
		
		/* instancie le contexte Spring déclaré par Annotations. */
		instancierContexteSpringParAnnotations();
				
	} // Fin de avantTests().______________________________________________


	
	/**
	 * <b>instancie le contexte Spring déclaré par Annotations</b>.<br/>
	 * <ul>
	 * <li>utilise <code>contexteSpring 
	 * = new AnnotationConfigApplicationContext(
	 * ConfigurateurSpringFrmkAnnotationJPAH2File.class);</code></li>
	 * </ul>
	 */
	private static void instancierContexteSpringParAnnotations() {
		
		System.out.println("FILE - INSTANCIE LE CONTEXTE");
		
		contexteSpring 
			= new AnnotationConfigApplicationContext(
					ConfigurateurSpringFrmkAnnotationJPAH2File.class);
		
		final EntityManagerFactory emf 
			= (EntityManagerFactory) contexteSpring.getBean("entityManagerFactory");
		
		final String urlConnexion = (String) emf.getProperties().get("hibernate.connection.url");
		
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("URL DE CONNEXION DANS ENTITYMANAGERFACTORY : " + urlConnexion);
		System.out.println("--------------------------------");
		System.out.println();
		
	} // Fin de instancierContexteSpringParAnnotations().__________________


	
	/**
	 * <b>affiche les propriétés lues par le EMFactory</b>.<br/>
	 * <br/>
	 * - ne fait rien si pEntityManagerFactory == null.<br/>
	 * <br/>
	 *
	 * @param pEntityManagerFactory : EntityManagerFactory.<br/>
	 */
	private static void afficherEMFactory(
			final EntityManagerFactory pEntityManagerFactory) {
		
		/* ne fait rien si pEntityManagerFactory == null. */
		final String propsDansEntityManagerFactory 
		= AfficheurContexteSpring
			.afficherPrincipalesProperties(pEntityManagerFactory);
	
		System.out.println(propsDansEntityManagerFactory);
	
	} // Fin de afficherEMFactory(...).____________________________________
	
	
	
	/**
	 * <b>affiche les propriétés lues par le EMFactory</b>.<br/>
	 * <b>affiche les beans contenus dans le contexte SPRING</b>.<br/>
	 */
	private static void afficherContexte() {
		
		String[] beansTableau = null;
		
		if (contexteSpring != null) {
			
			EntityManagerFactory entityManagerFactory = null;
			
			try {
				
				entityManagerFactory 
					= contexteSpring.getBean(
							"entityManagerFactory"
							, EntityManagerFactory.class);
				
			} catch (BeansException e) {
				e.printStackTrace();
			}
			
			if (entityManagerFactory != null) {
				
				System.out.println("Proprietes du Bean EntityManagerFactory : " + entityManagerFactory.getClass());
				System.out.println();
				
				/* affiche les propriétés lues par le EMFactory. */
				System.out.println("********* PROPRIETES DANS ENTITYMANAGERFACTORY");
				afficherEMFactory(entityManagerFactory);
			}
			
			
			beansTableau = contexteSpring.getBeanDefinitionNames();
			
		} else {
			
			final String message 
				= CLASSE_CONFIGURATEUR_TEST 
					+ " - METHODE avantTests() - " 
						+ "LE CONTEXTE N'A PU ETRE INSTANCIE";
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message);
			}
		}
		
		if (beansTableau != null) {
			System.out.println("***** CONTENU DU CONTEXTE (contexteSpring.getBeanDefinitionNames()) : ");
			
			for (int i = 0; i < beansTableau.length; i++) {
				System.out.println(beansTableau[i]);
			}
		}
		
	} // Fin de afficherContexte().________________________________________
	

	
} // FIN DE LA CLASSE ConfigurateurSringFrmkAnnotationJPAH2FileTest.---------
