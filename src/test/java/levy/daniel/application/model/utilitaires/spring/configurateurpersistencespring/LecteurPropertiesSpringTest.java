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
			
			System.out.println();
			System.out.println(
					"NOM DE L'UNITE DE PERSISTENCE DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPersistenceUnitName());
			
			System.out.println(
					"TYPE DE TRANSACTION DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getTransactionType());
			
			System.out.println(
					"PROVIDER DE PERSISTENCE DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPersistenceProviderClassName());
			
			System.out.println(
					"URL DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getUrl());
			
			System.out.println(
					"DRIVER DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getDriver());
			
			System.out.println(
					"LOGIN DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getUserName());

			System.out.println(
					"PASSWORD DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPassword());
			
			System.out.println();
			System.out.println(
					"JTADATASOURCE DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getJtaDataSource());
			
			System.out.println("CONTENU DE LA JTADATASOURCE : ");
			System.out.println(this.lecteurPropertiesSpring
					.afficherDataSource(
							this.lecteurPropertiesSpring.getJtaDataSource()));
			
			System.out.println();
			System.out.println(
					"NON-JTADATASOURCE DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getNonJtaDataSource());
			
			System.out.println("CONTENU DE LA NON-JTADATASOURCE : ");
			System.out.println(this.lecteurPropertiesSpring
					.afficherDataSource(
							this.lecteurPropertiesSpring.getNonJtaDataSource()));
			System.out.println();
	
			
			System.out.println("mappingFileNames DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getMappingFileNames());
			
			System.out.println("jarFileUrls DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getJarFileUrls());
			
			System.out.println("persistenceUnitRootUrl DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPersistenceUnitRootUrl());
			
			System.out.println("managedClassNames DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getManagedClassNames());

			System.out.println("managedPackages DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getManagedPackages());

			System.out.println("excludeUnlistedClasses DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.isExcludeUnlistedClasses());

			System.out.println("sharedCacheMode DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getSharedCacheMode());

			System.out.println("validationMode DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getValidationMode());
			
			System.out.println("persistenceXMLSchemaVersion DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPersistenceXMLSchemaVersion());
			
			System.out.println("persistenceProviderPackageName DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPersistenceProviderPackageName());
			
			
			
			System.out.println(
					"DIALECTE DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getDialect());
			
			System.out.println(
					"SHOW_SQL DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getShowSql());
			
			System.out.println(
					"FORMAT_SQL DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getFormatSql());
			
			System.out.println(
					"USE_SQL_COMMENTS DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getUseSqlComments());
			
			System.out.println(
					"USE_SQL_COMMENTS DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getUseSqlComments());
			
			System.out.println(
					"GENERATE_STATISTICS DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getGenerateSatistics());
			
			System.out.println(
					"NO_CACHE_PROVIDER_CLASS DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getNoCacheProviderClass());
			
			System.out.println(
					"CACHE_PROVIDER_CLASS DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getCacheProviderClass());
			
			System.out.println(
					"CACHE-USE_SECOND_LEVEL_CACHE DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getCacheUseSecondLevelCache());
			
			System.out.println(
					"CACHE-USE_QUERY_CACHE DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getCacheUseQueryCache());
			
			System.out.println(
					"RESOURCE_CACHE DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getResourceCache());
			
			System.out.println(
					"poolMinSize DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPoolMinSize());
			
			System.out.println(
					"poolMaxSize DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPoolMaxSize());
			
			System.out.println(
					"poolTimeOut DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPoolTimeOut());
			
			System.out.println(
					"poolMaxStatements DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPoolMaxStatements());
			
			System.out.println(
					"poolIdleTestPeriod DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getPoolIdleTestPeriod());
			
			System.out.println(
					"generateDdl DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getGenerateDdl());
			
			System.out.println(
					"DDL-AUTO DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getDdlAuto());

			System.out.println(
					"springH2ConsoleEnabled DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getSpringH2ConsoleEnabled());

			System.out.println(
					"springH2ConsolePath DANS LE CONTENEUR persistenceUnitInfoJPASansXML du LecteurPropertiesSpring : " 
					+ this.lecteurPropertiesSpring.getSpringH2ConsolePath());
			
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
