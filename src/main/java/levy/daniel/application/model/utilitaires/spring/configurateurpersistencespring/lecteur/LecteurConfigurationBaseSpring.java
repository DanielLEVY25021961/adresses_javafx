package levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring.lecteur;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.env.Environment;

/**
 * CLASSE LecteurConfigurationBaseSpring :<br/>
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
 * @since 30 janv. 2019
 *
 */
public class LecteurConfigurationBaseSpring {

	// ************************ATTRIBUTS************************************/

	/**
	 * "Classe LecteurConfigurationBaseSpring".
	 */
	public static final String CLASSE_LECTEUR_CONFIGURATION_BASE_SPRING 
		= "Classe LecteurConfigurationBaseSpring";
	
	
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
	 * saut de ligne de la plateforme.<br/>
	 * System.getProperty("line.separator")
	 */
	public static final String SAUT_LIGNE_PLATEFORME 
		= System.getProperty("line.separator");
	
	/**
	 * Locale.getDefault().
	 */
	public static final Locale LOCALE_PLATEFORME 
		= Locale.getDefault();
	
	/**
	 * "%1$-40s : %2$-45s".
	 */
	public static final String FORMAT_TOSTRING 
		= "%1$70s : %2$-72s";
	
	/**
	 * "%1$-5d  clé : %2$-35s - valeur : %3$s".
	 */
	public static final String FORMAT_PROPERTIES 
		= "%1$-5d  clé : %2$-35s - valeur : %3$s";
	
	/**
	 * "Méthode lirePersistenceUnitName()".
	 */
	public static final String METHODE_LIRE_PERSISTENCE_UNIT_NAME 
		= "Méthode lirePersistenceUnitName()";
	
	/**
	 * "Méthode lireTransactionType()".
	 */
	public static final String METHODE_LIRE_TRANSACTION_TYPE 
		= "Méthode lireTransactionType()";
	
	/**
	 * "Méthode lireDialect()".
	 */
	public static final String METHODE_LIRE_DIALECT 
		= "Méthode lireDialect()";

	/**
	 * "Méthode lireShowSql()".
	 */
	public static final String METHODE_LIRE_SHOWSQL 
		= "Méthode lireShowSql()";
	
	/**
	 * "Méthode lireFormatSql()".
	 */
	public static final String METHODE_LIRE_FORMATSQL 
		= "Méthode lireFormatSql()";
	
	/**
	 * "Méthode lireUseSqlComments".
	 */
	public static final String METHODE_LIRE_USESQLCOMMENTS 
		= "Méthode lireUseSqlComments";
	
	/**
	 * "Méthode lireGenerateStatistics()".
	 */
	public static final String METHODE_LIRE_GENERATESTATISTICS 
		= "Méthode lireGenerateStatistics()";
	
	/**
	 * "Méthode lireNoCacheProviderClass()".
	 */
	public static final String METHODE_LIRE_NOCACHEPROVIDERCLASS 
		= "Méthode lireNoCacheProviderClass()";
	
	/**
	 * "Méthode lireCacheProviderClass()".
	 */
	public static final String METHODE_LIRE_CACHEPROVIDERCLASS 
		= "Méthode lireCacheProviderClass()";
	
	/**
	 * "Méthode lireCacheUseSecondLevelCache()".
	 */
	public static final String METHODE_LIRE_CACHEUSESECONDLEVELCACHE 
		= "Méthode lireCacheUseSecondLevelCache()";
	
	/**
	 * "Méthode lireCacheUseQueryCache()".
	 */
	public static final String METHODE_LIRE_CACHEUSEQUERYCACHE 
		= "Méthode lireCacheUseQueryCache()";
	
	/**
	 * "Méthode lireResourceCache()".
	 */
	public static final String METHODE_LIRE_RESOURCECACHE 
		= "Méthode lireResourceCache()";
	
	/**
	 * "environmentSpring NON INJECTE !!!".
	 */
	public static final String ENVT_SPRING_NON_INJECTE 
		= "environmentSpring NON INJECTE !!!";
	
	/**
	 * "javax.persistence.jdbc.persistence-unit.name".
	 */
	public static final String PERSISTENCE_UNIT_NAME_KEY 
		= "javax.persistence.jdbc.persistence-unit.name";
	
	/**
	 * javax.persistence.jdbc.persistence-unit.transaction-type.
	 */
	public static final String TRANSACTION_TYPE_KEY 
		= "javax.persistence.jdbc.persistence-unit.transaction-type";
	
	/**
	 * "spring.jpa.properties.hibernate.dialect".
	 */
	public static final String DIALECT_KEY 
		= "spring.jpa.properties.hibernate.dialect";

	/**
	 * "spring.jpa.properties.hibernate.show_sql".
	 */
	public static final String SHOWSQL_KEY 
		= "spring.jpa.properties.hibernate.show_sql";
	
	/**
	 * "spring.jpa.properties.hibernate.format_sql".
	 */
	public static final String FORMATSQL_KEY 
		= "spring.jpa.properties.hibernate.format_sql";

	/**
	 * "spring.jpa.properties.hibernate.use_sql_comments".
	 */
	public static final String USESQLCOMMENTS_KEY 
		= "spring.jpa.properties.hibernate.use_sql_comments";
	
	/**
	 * "spring.jpa.properties.hibernate.generate_statistics".
	 */
	public static final String GENERATESTATISTICS_KEY 
		= "spring.jpa.properties.hibernate.generate_statistics";
	
	/**
	 * "spring.jpa.properties.cache.NoCacheProvider".
	 */
	public static final String NOCACHEPROVIDERCLASS_KEY 
		= "spring.jpa.properties.cache.NoCacheProvider";
	
	/**
	 * "spring.jpa.properties.cache.provider_class".
	 */
	public static final String CACHEPROVIDERCLASS_KEY 
		= "spring.jpa.properties.cache.provider_class";
	
	/**
	 * "spring.jpa.properties.cache.use_second_level_cache".
	 */
	public static final String CACHEUSESECONDLEVELCACHE_KEY 
		= "spring.jpa.properties.cache.use_second_level_cache";
	
	/**
	 * "spring.jpa.properties.cache.use_query_cache".
	 */
	public static final String CACHEUSEQUERYCACHE_KEY 
		= "spring.jpa.properties.cache.use_query_cache";
	
	/**
	 * "net.sf.ehcache.configurationResourcename".
	 */
	public static final String RESOURCECACHE_KEY 
		= "net.sf.ehcache.configurationResourcename";
	
	/**
	 * "cache.provider_class".<br/>
	 */
	public static final String CACHE_PROVIDER_CLASS 
		= "cache.provider_class";
		
	/**
	 * <b>lecteur SPRING du fichier properties 
	 * de configuration de la base</b>.
	 * <ul>
	 * <li>org.springframework.core.env.Environment</li>
	 * </ul>
	 */
	private Environment environmentSpring;
	
	/**
	 * <b>nom de l'unité de persistence</b>.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.persistence-unit.name</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : 
	 * <code>persistence-unit.name</code> dans un persistence.xml 
	 * préconisé par JPA.</li>
	 * <li>clé : 
	 * <code>hibernate.ejb.persistenceUnitName</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String persistenceUnitName;
	
	/**
	 * <b>type de transaction (sous forme de String)</b> 
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.persistence-unit.transaction-type</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : <code>persistence-unit.transaction-type</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.transaction.coordinator</code> 
	 * dans un EntityManagerFactory créé par le PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String typeTransaction;

	/**
	 * <b>Lecteur SPRING spécialisé dans la lecture des valeurs JPA 
	 * d'une DataSource [URL, Driver, Login, Password]</b>.<br/>.
	 */
	private transient LecteurJPADataSourceSpring lecteurJPADataSourceSpring;
	
	/**
	 * URL de la BASE.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.connexion.url</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.url</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.url</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String url;
	
	/**
	 * DRIVER JDBC de la BASE (sous forme de String).
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.driver</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.driver</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.driver</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String driver;
	
	/**
	 * LOGIN de la BASE.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.connection.username</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.user</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.user</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String userName;
	
	/**
	 * MOT DE PASSE de la BASE.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.connection.password</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.password</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.password</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String password;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(LecteurConfigurationBaseSpring.class);

	// *************************METHODES************************************/
	
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public LecteurConfigurationBaseSpring() {		
		this(null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	 /**
	 * CONSTRUCTEUR D'ARITE 1.<br/>
	 * <ul>
	 * <li>passe le paramètre pEnvironmentSpring 
	 * à this.environmentSpring</li>
	 * <li>alimente tous les attributs de la classe 
	 * via this.lireProperties()</li>
	 * </ul>
	 * 
	 * @param pEnvironmentSpring : 
	 * org.springframework.core.env.Environment
	 */
	public LecteurConfigurationBaseSpring(
			final Environment pEnvironmentSpring) {
		
		super();
				
		this.environmentSpring = pEnvironmentSpring;
		
		/* alimente tous les attributs de la classe. */
		this.lireProperties();
		
	} // Fin de CONSTRUCTEUR D'ARITE 1.____________________________________


	
	/**
	 * <b>Lit le fichier properties SPRING de configuration de la base 
	 * encapsulé dans <code>this.environmentSpring</code></b>.
	 * <ul>
	 * <li>automatiquement appelé par le constructeur d'arité 1</li>
	 * <ul>
	 * <li>lit le nom de l'unité de persistence (persistenceUnitName).</li>
	 * <li>lit le type de transaction (typeTransaction).</li>
	 * 
	 * <li>délègue à un LecteurJPADataSourceSpring 
	 * la lecture des valeurs de la DataSource.</li>
	 * <ul>
	 * <li>lit l'URL de la base (url).</li>
	 * <li>lit le DRIVER de la Base (driver).</li>
	 * <li>lit le LOGIN de la Base (userName).</li>
	 * <li>lit le PASSWORD de la Base (password).</li>
	 * </ul>
	 * 
	 * <li>passe une liste vide au CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * pour mapping-files.</li>
	 * <li>passe une liste vide au CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * pour jarFileUrls.</li>
	 * <li>passe null au CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * pour persistenceUnitRootUrl.</li>
	 * <li>passe une liste vide au CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * pour managedClassNames.</li>
	 * <li>passe une liste vide au CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * pour managedPackages.</li>
	 * <li>passe false au CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * pour excludeUnlistedClasses.</li>
	 * <li>passe UNSPECIFIED au CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * pour sharedCacheMode.</li>
	 * <li>passe AUTO au CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * pour validationMode.</li>
	 *<li>passe 2.1 au CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * pour persistenceXMLSchemaVersion.</li>
	 * <li>passe null au CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * pour persistenceProviderPackageName.</li>
	 * 
	 * 
	 * <li>lit le DIALECTE de la base (dialect).</li>
	 * <li>lit le SHOW_SQL (showSql).</li>
	 * <li>lit le FORMAT_SQL (formatSql).</li>
	 * <li>lit le USE_SQL_COMMENTS (useSqlComments).</li>
	 * <li>lit le GENERATE_STATISTICS (generateStatistics).</li>
	 * <li>lit le NO_CACHE_PROVIDER_CLASS (noCacheProviderClass).</li>
	 * <li>lit le CACHE_PROVIDER_CLASS (cacheProviderClass).</li>
	 * <li>lit le CACHE-USE_SECOND_LEVEL_CACHE (cacheUseSecondLevelCache).</li>
	 * <li>lit le CACHE-USE_QUERY_CACHE (cacheUseQueryCache).</li>
	 * <li>lit le RESOURCE_CACHE (resourceCache).</li>
	 * <li>lit les valeurs du Pool de connexion.</li>
	 * <li>lit l'interrupteur generateDdl.</li>
	 * <li>lit le DDL-AUTO (ddlAuto).</li>
	 * <li>lit le springH2ConsoleEnabled.</li>
	 * <li>lit le springH2ConsolePath.</li>
	 * <li>alimente <code>this.propertiesConteneur</code> 
	 * avec le java.util.Properties contenu dans le 
	 * CONTENEUR <code>this.persistenceUnitInfoJPASansXML</code>.</li>
	 * </ul>
	 * </ul>
	 */
	private void lireProperties() {
		
		/* persistenceUnitName. */
		this.lirePersistenceUnitName();
		
		/* typeTransaction. */
		this.lireTypeTransaction();
		
		// DATASOURCE
		this.lecteurJPADataSourceSpring 
			= new LecteurJPADataSourceSpring(this.environmentSpring);
		/* URL. */
		this.url = this.lecteurJPADataSourceSpring.getUrl();
		
		/* DRIVER. */
		this.driver = this.lecteurJPADataSourceSpring.getDriver();
		
		/* userName. */
		this.userName = this.lecteurJPADataSourceSpring.getUserName();
		
		/* password. */
		this.password = this.lecteurJPADataSourceSpring.getPassword();
		
//		/* jtaDataSource et nonJtaDataSource. */
//		this.determinerTypeDataSource();
//		
//		/* mapping-files. */
//		this.persistenceUnitInfoJPASansXML
//			.setMappingFileNames(this.mappingFileNames);
//		
//		/* jarFileUrls. */
//		this.persistenceUnitInfoJPASansXML
//			.setJarFileUrls(this.jarFileUrls);
//		
//		/* persistenceUnitRootUrl. */
//		this.persistenceUnitInfoJPASansXML
//			.setPersistenceUnitRootUrl(this.persistenceUnitRootUrl);
//		
//		/* managedClassNames. */
//		this.persistenceUnitInfoJPASansXML
//			.setManagedClassNames(this.managedClassNames);
//		
//		/* managedPackages. */
//		this.persistenceUnitInfoJPASansXML
//			.setManagedPackages(this.managedPackages);
//		
//		/* excludeUnlistedClasses. */
//		this.persistenceUnitInfoJPASansXML
//			.setExcludeUnlistedClasses(this.excludeUnlistedClasses);
//		
//		/* sharedCacheMode. */
//		this.persistenceUnitInfoJPASansXML
//			.setSharedCacheMode(this.sharedCacheMode);
//		
//		/* validationMode. */
//		this.persistenceUnitInfoJPASansXML
//			.setValidationMode(this.validationMode);
//		
//		/* persistenceXMLSchemaVersion. */
//		this.persistenceUnitInfoJPASansXML
//			.setPersistenceXMLSchemaVersion(
//					this.persistenceXMLSchemaVersion);
//
//		/* persistenceProviderPackageName. */
//		this.persistenceUnitInfoJPASansXML
//			.setPersistenceProviderPackageName(
//					this.persistenceProviderPackageName);
//		
//		
//		
//		this.persistenceUnitInfoJPASansXML
//			.setProperties(new Properties());
//		
//		/* dialect. */
//		this.lireDialect();
//		
//		/* showSql. */
//		this.lireShowSql();
//		
//		/* formatSql. */
//		this.lireFormatSql();
//		
//		/* useSqlComments. */
//		this.lireUseSqlComments();
//		
//		/* generateStatistics. */
//		this.lireGenerateStatistics();
//		
//		/* noCacheProviderClass. */
//		this.lireNoCacheProviderClass();
//		
//		/* cacheProviderClass. */
//		this.lireCacheProviderClass();
//		
//		/* cacheUseSecondLevelCache. */
//		this.lireCacheUseSecondLevelCache();
//		
//		/* cacheUseQueryCache. */
//		this.lireCacheUseQueryCache();
//		
//		/* resourceCache. */
//		this.lireResourceCache();
//		
//		/* pool. */
//		this.lirePoolMinSize();
//		this.lirePoolMaxSize();
//		this.lirePoolTimeOut();
//		this.lirePoolMaxStatements();
//		this.lirePoolIdleTestPeriod();
//		this.lirePoolAcquireIncrement();
//		
//		/* generateDdl. */
//		this.lireGenerateDdl();
//		
//		/* ddlAuto. */
//		this.lireDdlAuto();
//		
//		/* springH2ConsoleEnabled. */
//		this.lireSpringH2ConsoleEnabled();
//		
//		/* springH2ConsolePath. */
//		this.lireSpringH2ConsolePath();
//		
//		/* alimente this.propertiesConteneur 
//		 * avec le java.util.Properties contenu 
//		 * dans this.persistenceUnitInfoJPASansXML. */
//		this.propertiesConteneur 
//			= this.persistenceUnitInfoJPASansXML.getProperties();
		
	} // Fin de lireProperties().__________________________________________
	
	
		
	/**
	 * <b>lit la valeur de persistenceUnitName 
	 * dans le properties SPRING fourni par l'Environment.</b>
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.persistence-unit.name</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : 
	 * <code>persistence-unit.name</code> dans un persistence.xml 
	 * préconisé par JPA.</li>
	 * <li>clé : 
	 * <code>hibernate.ejb.persistenceUnitName</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return this.persistenceUnitName : String : 
	 * nom de l'unité de persistance.<br/>
	 */
	private String lirePersistenceUnitName() {
		
		if (this.environmentSpring != null) {
			
			this.persistenceUnitName 
				= this.environmentSpring.getProperty(
					PERSISTENCE_UNIT_NAME_KEY);
			
		} else {
			
			final String message 
				= CLASSE_LECTEUR_CONFIGURATION_BASE_SPRING
				+ TIRET_ESPACE
				+ METHODE_LIRE_PERSISTENCE_UNIT_NAME
				+ TIRET_ESPACE
				+ ENVT_SPRING_NON_INJECTE;
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message);
			}
		}
		
		return this.persistenceUnitName;
		
	} // Fin de lirePersistenceUnitName()._________________________________
	

	
	/**
	 * <b>lit la valeur de typeTransaction 
	 * dans le properties SPRING fourni par l'Environment.</b>
	 *
	 * @return this.typeTransaction : String : 
	 * type de transaction.<br/>
	 */
	private String lireTypeTransaction() {
		
		if (this.environmentSpring != null) {
			
			this.typeTransaction 
				= this.environmentSpring.getProperty(
						TRANSACTION_TYPE_KEY);
						
		} else {
			
			final String message 
				= CLASSE_LECTEUR_CONFIGURATION_BASE_SPRING
				+ TIRET_ESPACE
				+ METHODE_LIRE_TRANSACTION_TYPE
				+ TIRET_ESPACE
				+ ENVT_SPRING_NON_INJECTE;
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message);
			}
		}
		
		return this.typeTransaction;
		
	} // Fin de lireTypeTransaction()._____________________________________


	
	/**
	 * Getter du <b>nom de l'unité de persistence</b>.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.persistence-unit.name</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : 
	 * <code>persistence-unit.name</code> dans un persistence.xml 
	 * préconisé par JPA.</li>
	 * <li>clé : 
	 * <code>hibernate.ejb.persistenceUnitName</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return this.persistenceUnitName : String.<br/>
	 */
	public final String getPersistenceUnitName() {
		return this.persistenceUnitName;
	} // Fin de getPersistenceUnitName().__________________________________
	
	
	
	/**
	 * Getter du <b>type de transaction (sous forme de String)</b> 
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.persistence-unit.transaction-type</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : <code>persistence-unit.transaction-type</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.transaction.coordinator</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return this.typeTransaction : String.<br/>
	 */
	public final String getTypeTransaction() {
		return this.typeTransaction;
	} // Fin de getTypeTransaction().______________________________________

	
		
	/**
	 * Getter du <b>Lecteur SPRING spécialisé dans la lecture 
	 * des valeurs JPA 
	 * d'une DataSource [URL, Driver, Login, Password]</b>.<br/>.
	 *
	 * @return this.lecteurJPADataSourceSpring : 
	 * LecteurJPADataSourceSpring.<br/>
	 */
	public final LecteurJPADataSourceSpring getLecteurJPADataSourceSpring() {
		return this.lecteurJPADataSourceSpring;
	} // Fin de getLecteurJPADataSourceSpring().___________________________



	/**
	 * Getter de l'URL de la BASE.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.connexion.url</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.url</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.url</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return this.url : String.<br/>
	 */
	public final String getUrl() {
		return this.url;
	} // Fin de getUrl().__________________________________________________


	
	/**
	 * Getter du DRIVER JDBC de la BASE (sous forme de String).
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.driver</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.driver</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.driver</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return this.driver : String.<br/>
	 */
	public final String getDriver() {
		return this.driver;
	} // Fin de getDriver()._______________________________________________


	
	/**
	 * Getter du LOGIN de la BASE.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.connection.username</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.user</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.user</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return this.userName : String.<br/>
	 */
	public final String getUserName() {
		return this.userName;
	} // Fin de getUserName()._____________________________________________


	
	/**
	 * Getter du MOT DE PASSE de la BASE.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.connection.password</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.password</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.password</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return this.password : String.<br/>
	 */
	public final String getPassword() {
		return this.password;
	} // Fin de getPassword()._____________________________________________



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
	 * <li>org.springframework.core.env.Environment</li>
	 * </ul>
	*
	* @param pEnvironmentSpring : 
	* org.springframework.core.env.Environment. : 
	* valeur à passer à this.environmentSpring.<br/>
	*/
	public final void setEnvironmentSpring(
			final Environment pEnvironmentSpring) {
		this.environmentSpring = pEnvironmentSpring;
	} // Fin de setEnvironmentSpring(...)._________________________________

	
	
} // FIN DE LA CLASSE LecteurConfigurationBaseSpring.------------------------
