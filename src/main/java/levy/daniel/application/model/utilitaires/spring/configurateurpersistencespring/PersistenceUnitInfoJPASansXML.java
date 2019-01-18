package levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE PersistenceUnitInfoJPASansXML :<br/>
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
 * @since 15 janv. 2019
 *
 */
public class PersistenceUnitInfoJPASansXML implements PersistenceUnitInfo {

	// ************************ATTRIBUTS************************************/

	/**
	 * nom de l'unité de persistance.
	 */
	private String persistenceUnitName;
	
	/**
	 * nom qualifié de l'ORM (HIBERNATE).<br/>
	 * Par exemple : 
	 * org.hibernate.jpa.HibernatePersistenceProvider.class.getName().
	 */
	private String persistenceProviderClassName;

	/**
	 * Type de transaction.
	 * <ul>
	 * <li>RESOURCE_LOCAL pour une application STANDALONE 
	 * qui gère les transactions.</li>
	 * <li>JTA pour une application WEB dans laquelle 
	 * le conteneur de Servlet (TOMCAT) gère les transactions.</li>
	 * <li>Ne pas utiliser ce tag pour une application gérée par SPRING 
	* (qui gère lui même les transactions)</li>
	 * </ul>
	 */
	private PersistenceUnitTransactionType transactionType;
	
	/**
	 * DataSource fournie par le conteneur de Servlet (TOMCAT) 
	 * via JNDI en cas de transactions JTA.
	 */
	private DataSource jtaDataSource;
	
	/**
	 * DataSource de l'application Standalone 
	 * en cas de transactions RESOURCE_LOCAL (pas de TOMCAT).
	 */
	private DataSource nonJtaDataSource;

	/**
	 * liste des <b>noms qualifiés</b> des 
	 * classes Entities JPA mappées pour management 
	 * par JPA dans un persistence.xml.<br/>
	 * <ul>
	 * <li>Correspond au <code>mapping-file</code> element 
	 * dans un persistence.xml.</li>
	 * <li>Sans Objet lorsque l'on utilise des Entities JPA 
	 * <b>annotées</b>.</li>
	 * </ul>
	 */
	private List<String> mappingFileNames;
	
	/**
	 * liste des URL des jar que l'ORM doit inspecter.<br/>
	 * chaque URL Correspond au <code>jar-file</code> element 
	 * dans un persistence.xml.
	 */
	private List<URL> jarFileUrls;
	
	/**
	 * URL référençant un jar ou un répertoire <b>racine</b> 
	 * de l'unité de persistence.
	 */
	private URL persistenceUnitRootUrl;
	
	/**
	 * liste des <b>noms</b> des 
	 * classes Entities JPA mappées pour management 
	 * par JPA dans un persistence.xml.<br/>
	 * <ul>
	 * <li>Correspond au <code>class</code> element 
	 * dans un persistence.xml.</li>
	 * <li>Sans Objet lorsque l'on utilise des Entities JPA 
	 * <b>annotées</b>.</li>
	 * </ul>
	 */
	private List<String> managedClassNames;

	 
	/**
	 * boolean qui stipule que l'ORM ne doit manager 
	 * que les classes Entities JPA listées dans le persistence.xml 
	 * si il est à true.<br/>
	 * <ul>
	 * <li>correspond au <code>exclude-unlisted-classes</code> 
	 * element dans un persistence.xml</li>
	 * <li>toujours false si on utilise les classes annotées. </li>
	 * </ul>
	 */
	private boolean excludeUnlistedClasses;
	
	
	/**
	 * mode d'utilisation du cache de 2nd niveau par l'ORM.
	 * <ul>
	 * <li>correspond au <code>shared-cache-mode</code> 
	 * element dans un persistence.xml</li>
	 * </ul>
	 */
	private SharedCacheMode sharedCacheMode;
	
	/**
	 * mode de validation utilisé par l'ORM.
	 * <ul>
	 * <li>correspond au <code>validation-mode</code> element 
	 * dans un persistence.xml</li>
	 * </ul>
	 */
	private ValidationMode validationMode;
	
	/**
	 * <b>propriétés de <b>connexion à la base</b> 
	 * éventuellement spécifiques 
	 * à l'ORM, à SPRING, à H2, ...</b> 
	 * comme par exemple le dialecte HIBERNATE.<br/>
	 * <ul>
	 * <li>correspond au <code>properties</code> element 
	 * dans un persistence.xml</li>
	 * <li>chaque Property de properties correspond au 
	 * <code>property</code> element dans un persistence.xml</li>
	 * <li><code>hibernate.connection.url</code> 
	 * (URL de connexion à la base), 
	 * <code>javax.persistence.jdbc.driver</code> 
	 * (driver de connexion à la base) sont des Property...</li>
	 * </ul>
	 */
	private Properties properties;

	/**
	 * version de JPA utilisée dans le persistence.xml (2.1, 3.0, ...).
	 */
	private String persistenceXMLSchemaVersion;
	
	/**
	 * ClassLoader utilisé par l'ORM pour charger les Entities JPA, ....
	 */
	private ClassLoader classLoader;
	
	/**
	 * ClassLoader utilisé temporairement 
	 * par l'ORM pour charger les Entities JPA, ....
	 */
	private ClassLoader newTempClassLoader;
	
	/**
	 * "2.1"
	 */
	public static final String JPA_VERSION = "2.1";

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(PersistenceUnitInfoJPASansXML.class);
	

	// *************************METHODES************************************/
	
	
	
	 /**
	 * CONSTRUCTEUR MALIN.
	 * 
	 * @param pPersistenceUnitName : String : 
	 * nom de l'unité de persistance.
	 * @param pPersistenceProviderClassName : String : 
	 * nom qualifié de l'ORM (HIBERNATE).
	 * @param pTransactionType : PersistenceUnitTransactionType : 
	 * Type de transaction.
	 * @param pJtaDataSource : DataSource :
	 * DataSource fournie par le conteneur de Servlet (TOMCAT) 
	 * via JNDI en cas de transactions JTA.
	 * @param pNonJtaDataSource : DataSource : 
	 * DataSource de l'application Standalone 
	 * en cas de transactions RESOURCE_LOCAL (pas de TOMCAT).
	 * @param pProperties : Properties : 
	 * <b>propriétés de <b>connexion à la base</b> 
	 * éventuellement spécifiques 
	 * à l'ORM, à SPRING, à H2, ...</b> 
	 * comme par exemple le dialecte HIBERNATE.
	 */
	public PersistenceUnitInfoJPASansXML(
			final String pPersistenceUnitName
			, final String pPersistenceProviderClassName
			, final PersistenceUnitTransactionType pTransactionType
			, final DataSource pJtaDataSource
			, final DataSource pNonJtaDataSource
			, final Properties pProperties) {
		
        this(
        		pPersistenceUnitName
        		, pPersistenceProviderClassName
        		, pTransactionType
        		, pJtaDataSource
        		, pNonJtaDataSource
        		, null
        		, null
        		, null
        		, null
        		, false
        		, null
        		, null
        		, pProperties
        		, null
        		, null
        		, null);
        
    } // Fin de CONSTRUCTEUR MALIN.________________________________________

	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * 
	 * @param pPersistenceUnitName : String : 
	 * nom de l'unité de persistance.
	 * @param pPersistenceProviderClassName : String : 
	 * nom qualifié de l'ORM (HIBERNATE).
	 * @param pTransactionType : PersistenceUnitTransactionType : 
	 * Type de transaction.
	 * @param pJtaDataSource : DataSource :
	 * DataSource fournie par le conteneur de Servlet (TOMCAT) 
	 * via JNDI en cas de transactions JTA.
	 * @param pNonJtaDataSource : DataSource : 
	 * DataSource de l'application Standalone 
	 * en cas de transactions RESOURCE_LOCAL (pas de TOMCAT).
	 * @param pMappingFileNames : List&lt;String&gt; : 
	 * liste des <b>noms qualifiés</b> des 
	 * classes Entities JPA mappées pour management 
	 * par JPA dans un persistence.xml.<br/>
	 * @param pJarFileUrls : List&lt;URL&gt; : 
	 * liste des URL des jar que l'ORM doit inspecter.
	 * @param pPersistenceUnitRootUrl : URL : 
	 * URL référençant un jar ou un répertoire <b>racine</b> 
	 * de l'unité de persistence.
	 * @param pManagedClassNames : List&lt;String&gt; : 
	 * liste des <b>noms</b> des 
	 * classes Entities JPA mappées pour management 
	 * par JPA dans un persistence.xml.
	 * @param pExcludeUnlistedClasses : boolean : 
	 * boolean qui stipule que l'ORM ne doit manager 
	 * que les classes Entities JPA listées dans le persistence.xml 
	 * si il est à true.
	 * @param pSharedCacheMode : SharedCacheMode : 
	 * mode d'utilisation du cache de 2nd niveau par l'ORM.
	 * @param pValidationMode : ValidationMode : 
	 * mode de validation utilisé par l'ORM.
	 * @param pProperties : Properties : 
	 * <b>propriétés de <b>connexion à la base</b> 
	 * éventuellement spécifiques 
	 * à l'ORM, à SPRING, à H2, ...</b> 
	 * comme par exemple le dialecte HIBERNATE.
	 * @param pPersistenceXMLSchemaVersion : String : 
	 * version de JPA utilisée dans le persistence.xml (2.1, 3.0, ...).
	 * @param pClassLoader : ClassLoader : 
	 * ClassLoader utilisé par l'ORM pour charger les Entities JPA, ....
	 * @param pNewTempClassLoader : ClassLoader : 
	 * ClassLoader utilisé temporairement 
	 * par l'ORM pour charger les Entities JPA, ....
	 */
	public PersistenceUnitInfoJPASansXML(
			final String pPersistenceUnitName
			, final String pPersistenceProviderClassName
			, final PersistenceUnitTransactionType pTransactionType
			, final DataSource pJtaDataSource
			, final DataSource pNonJtaDataSource
			, final List<String> pMappingFileNames
			, final List<URL> pJarFileUrls
			, final URL pPersistenceUnitRootUrl
			, final List<String> pManagedClassNames
			, final boolean pExcludeUnlistedClasses
			, final SharedCacheMode pSharedCacheMode
			, final ValidationMode pValidationMode
			, final Properties pProperties
			, final String pPersistenceXMLSchemaVersion
			, final ClassLoader pClassLoader
			, final ClassLoader pNewTempClassLoader) {
		
		super();
		
		this.persistenceUnitName = pPersistenceUnitName;
		this.persistenceProviderClassName = pPersistenceProviderClassName;
		this.transactionType = pTransactionType;
		this.jtaDataSource = pJtaDataSource;
		this.nonJtaDataSource = pNonJtaDataSource;
		this.mappingFileNames = pMappingFileNames;
		
		if (pJarFileUrls == null) {
			this.jarFileUrls = Collections.emptyList(); 
		} else {
			this.jarFileUrls = pJarFileUrls;
		}
		

		
		this.persistenceUnitRootUrl = pPersistenceUnitRootUrl;
		this.managedClassNames = pManagedClassNames;
		this.excludeUnlistedClasses = pExcludeUnlistedClasses;
		this.sharedCacheMode = pSharedCacheMode;
		this.validationMode = pValidationMode;
		this.properties = pProperties;
		this.persistenceXMLSchemaVersion = pPersistenceXMLSchemaVersion;
		this.classLoader = pClassLoader;
		this.newTempClassLoader = pNewTempClassLoader;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersistenceUnitInfoJPASansXML [");
		if (this.persistenceUnitName != null) {
			builder.append("persistenceUnitName=");
			builder.append(this.persistenceUnitName);
			builder.append(", ");
		}
		if (this.persistenceProviderClassName != null) {
			builder.append("persistenceProviderClassName=");
			builder.append(this.persistenceProviderClassName);
			builder.append(", ");
		}
		if (this.transactionType != null) {
			builder.append("transactionType=");
			builder.append(this.transactionType);
			builder.append(", ");
		}
		if (this.jtaDataSource != null) {
			builder.append("jtaDataSource=");
			builder.append(this.jtaDataSource);
			builder.append(", ");
		}
		if (this.nonJtaDataSource != null) {
			builder.append("nonJtaDataSource=");
			builder.append(this.nonJtaDataSource);
			builder.append(", ");
		}
		if (this.mappingFileNames != null) {
			builder.append("mappingFileNames=");
			builder.append(this.mappingFileNames);
			builder.append(", ");
		}
		if (this.jarFileUrls != null) {
			builder.append("jarFileUrls=");
			builder.append(this.jarFileUrls);
			builder.append(", ");
		}
		if (this.persistenceUnitRootUrl != null) {
			builder.append("persistenceUnitRootUrl=");
			builder.append(this.persistenceUnitRootUrl);
			builder.append(", ");
		}
		if (this.managedClassNames != null) {
			builder.append("managedClassNames=");
			builder.append(this.managedClassNames);
			builder.append(", ");
		}
		builder.append("excludeUnlistedClasses=");
		builder.append(this.excludeUnlistedClasses);
		builder.append(", ");
		if (this.sharedCacheMode != null) {
			builder.append("sharedCacheMode=");
			builder.append(this.sharedCacheMode);
			builder.append(", ");
		}
		if (this.validationMode != null) {
			builder.append("validationMode=");
			builder.append(this.validationMode);
			builder.append(", ");
		}
		if (this.properties != null) {
			builder.append("properties=");
			builder.append(this.properties);
			builder.append(", ");
		}
		if (this.persistenceXMLSchemaVersion != null) {
			builder.append("persistenceXMLSchemaVersion=");
			builder.append(this.persistenceXMLSchemaVersion);
			builder.append(", ");
		}
		if (this.classLoader != null) {
			builder.append("classLoader=");
			builder.append(this.classLoader);
			builder.append(", ");
		}
		if (this.newTempClassLoader != null) {
			builder.append("newTempClassLoader=");
			builder.append(this.newTempClassLoader);
		}
		builder.append("]");
		return builder.toString();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPersistenceUnitName() {
		return this.persistenceUnitName;
	} // Fin de getPersistenceUnitName().__________________________________

	

	/**
	* Setter du nom de l'unité de persistance.
	*
	* @param pPersistenceUnitName : String : 
	* valeur à passer à this.persistenceUnitName.<br/>
	*/
	public void setPersistenceUnitName(
			final String pPersistenceUnitName) {
		this.persistenceUnitName = pPersistenceUnitName;
	} // Fin de setPersistenceUnitName(...)._______________________________


	/**
	 * {@inheritDoc}
	 * <br/>
	 * - nom qualifié de l'ORM (HIBERNATE).<br/>
	 * Par exemple : 
	 * org.hibernate.jpa.HibernatePersistenceProvider.class.getName().
	 */
	@Override
	public String getPersistenceProviderClassName() {
		return this.persistenceProviderClassName;
	} // Fin de getPersistenceProviderClassName()._________________________
	
	
		
	/**
	* setter du nom qualifié de l'ORM (HIBERNATE).<br/>
	 * Par exemple : 
	 * org.hibernate.jpa.HibernatePersistenceProvider.class.getName().
	*
	* @param pPersistenceProviderClassName : String : 
	* valeur à passer à this.persistenceProviderClassName.<br/>
	*/
	public void setPersistenceProviderClassName(
			final String pPersistenceProviderClassName) {
		this.persistenceProviderClassName = pPersistenceProviderClassName;
	} // Fin de setPersistenceProviderClassName(...).______________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public PersistenceUnitTransactionType getTransactionType() {
		return this.transactionType;		
	} // Fin de getTransactionType().______________________________________

	
		
	/**
	* Setter du Type de transaction.
	* <ul>
	* <li>RESOURCE_LOCAL pour une application STANDALONE 
	* qui gère les transactions.</li>
	* <li>JTA pour une application WEB dans laquelle 
	* le conteneur de Servlet (TOMCAT) gère les transactions.</li>
	* <li>Ne pas utiliser ce tag pour une application gérée par SPRING 
	* (qui gère lui même les transactions)</li>
	* </ul>.
	*
	* @param pTransactionType : PersistenceUnitTransactionType : 
	* valeur à passer à this.transactionType.<br/>
	*/
	public void setTransactionType(
			final PersistenceUnitTransactionType pTransactionType) {
		this.transactionType = pTransactionType;
	} // Fin de setTransactionType(...).___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataSource getJtaDataSource() {
		return this.jtaDataSource;
	} // Fin de getJtaDataSource().________________________________________

	
	
	/**
	* setter de la DataSource fournie par le conteneur de Servlet (TOMCAT) 
	 * via JNDI en cas de transactions JTA.
	*
	* @param pJtaDataSource : DataSource : 
	* valeur à passer à this.jtaDataSource.<br/>
	*/
	public void setJtaDataSource(
			final DataSource pJtaDataSource) {
		this.jtaDataSource = pJtaDataSource;
	} // Fin de setJtaDataSource(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataSource getNonJtaDataSource() {
		return this.nonJtaDataSource;
	} // Fin de getNonJtaDataSource()._____________________________________
	

	
	/**
	* Setter de la DataSource de l'application Standalone 
	 * en cas de transactions RESOURCE_LOCAL (pas de TOMCAT).
	*
	* @param pNonJtaDataSource : DataSource : 
	* valeur à passer à this.nonJtaDataSource.<br/>
	*/
	public void setNonJtaDataSource(
			final DataSource pNonJtaDataSource) {
		this.nonJtaDataSource = pNonJtaDataSource;
	} // Fin de setNonJtaDataSource(...).__________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getMappingFileNames() {
		return this.mappingFileNames;
	} // Fin de getMappingFileNames()._____________________________________
	
	
		
	/**
	* setter de la liste des <b>noms qualifiés</b> des 
	 * classes Entities JPA mappées pour management 
	 * par JPA dans un persistence.xml.<br/>
	 * <ul>
	 * <li>Correspond au <code>mapping-file</code> element 
	 * dans un persistence.xml.</li>
	 * <li>Sans Objet lorsque l'on utilise des Entities JPA 
	 * <b>annotées</b>.</li>
	 * </ul>
	*
	* @param pMappingFileNames : List&lt;String&gt; : 
	* valeur à passer à this.mappingFileNames.<br/>
	*/
	public void setMappingFileNames(
			final List<String> pMappingFileNames) {
		this.mappingFileNames = pMappingFileNames;
	} // Fin de setMappingFileNames(...).__________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * - retourne une liste vide si this.jarFileUrls == null.<br/>
	 */
	@Override
	public List<URL> getJarFileUrls() {
		
		if (this.jarFileUrls == null) {
			this.jarFileUrls = Collections.emptyList(); 
		}
		
		return this.jarFileUrls;
		
	} // Fin de getJarFileUrls().__________________________________________

	
		
	/**
	* setter de la liste des URL des jar que l'ORM doit inspecter.<br/>
	* chaque URL Correspond au <code>jar-file</code> element 
	* dans un persistence.xml.
	*
	* @param pJarFileUrls : List&lt;URL&gt; : 
	* valeur à passer à this.jarFileUrls.<br/>
	*/
	public void setJarFileUrls(
			final List<URL> pJarFileUrls) {
		this.jarFileUrls = pJarFileUrls;
	} // Fin de setJarFileUrls(...)._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public URL getPersistenceUnitRootUrl() {
		return this.persistenceUnitRootUrl;
	} // Fin de getPersistenceUnitRootUrl()._______________________________

	
	
	/**
	* setter de l'URL référençant un jar ou un répertoire <b>racine</b> 
	* de l'unité de persistence.
	*
	* @param pPersistenceUnitRootUrl : URL : 
	* valeur à passer à this.persistenceUnitRootUrl.<br/>
	*/
	public void setPersistenceUnitRootUrl(
			final URL pPersistenceUnitRootUrl) {
		this.persistenceUnitRootUrl = pPersistenceUnitRootUrl;
	} // Fin de setPersistenceUnitRootUrl(...).____________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getManagedClassNames() {
		return this.managedClassNames;
	} // Fin de getManagedClassNames().____________________________________

	
	
	/**
	* setter de la liste des <b>noms</b> des 
	* classes Entities JPA mappées pour management 
	* par JPA dans un persistence.xml.<br/>
	* <ul>
	* <li>Correspond au <code>class</code> element 
	* dans un persistence.xml.</li>
	* <li>Sans Objet lorsque l'on utilise des Entities JPA 
	* <b>annotées</b>.</li>
	* </ul>
	*
	* @param pManagedClassNames : List&lt;String&gt; : 
	* valeur à passer à this.managedClassNames.<br/>
	*/
	public void setManagedClassNames(
			final List<String> pManagedClassNames) {
		this.managedClassNames = pManagedClassNames;
	} // Fin de setManagedClassNames(...)._________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean excludeUnlistedClasses() {		
		return this.excludeUnlistedClasses;
	} // Fin de excludeUnlistedClasses().__________________________________

	
	
	/**
	 * Getter du boolean qui stipule que l'ORM ne doit manager 
	 * que les classes Entities JPA listées dans le persistence.xml 
	 * si il est à true.<br/>
	 * <ul>
	 * <li>correspond au <code>exclude-unlisted-classes</code> 
	 * element dans un persistence.xml</li>
	 * <li>toujours false si on utilise les classes annotées. </li>
	 * </ul>
	 *
	 * @return this.excludeUnlistedClasses : boolean.<br/>
	 */
	public boolean isExcludeUnlistedClasses() {
		return this.excludeUnlistedClasses;
	} // Fin de isExcludeUnlistedClasses().________________________________


	
	/**
	* Setter du boolean qui stipule que l'ORM ne doit manager 
	* que les classes Entities JPA listées dans le persistence.xml 
	* si il est à true.<br/>
	* <ul>
	* <li>correspond au <code>exclude-unlisted-classes</code> 
	* element dans un persistence.xml</li>
	* <li>toujours false si on utilise les classes annotées. </li>
	* </ul>
	* 
	* @param pExcludeUnlistedClasses : boolean : 
	* valeur à passer à this.excludeUnlistedClasses.<br/>
	*/
	public void setExcludeUnlistedClasses(
			final boolean pExcludeUnlistedClasses) {
		this.excludeUnlistedClasses = pExcludeUnlistedClasses;
	} // Fin de setExcludeUnlistedClasses(...).____________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * - retourne UNSPECIFIED si this.sharedCacheMode == null.<br/>
	 */
	@Override
	public SharedCacheMode getSharedCacheMode() {
		
		if (this.sharedCacheMode == null) {
			this.sharedCacheMode = SharedCacheMode.UNSPECIFIED;
		}
		
		return this.sharedCacheMode;
		
	} // Fin de getSharedCacheMode().______________________________________

	
		
	/**
	* setter du mode d'utilisation du cache de 2nd niveau par l'ORM.
	* <ul>
	* <li>correspond au <code>shared-cache-mode</code> 
	* element dans un persistence.xml</li>
	* </ul>
	*
	* @param pSharedCacheMode : SharedCacheMode : 
	* valeur à passer à this.sharedCacheMode.<br/>
	*/
	public void setSharedCacheMode(
			final SharedCacheMode pSharedCacheMode) {
		this.sharedCacheMode = pSharedCacheMode;
	} // Fin de setSharedCacheMode(...).___________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * - retourne AUTO si this.validationMode == null.<br/>
	 */
	@Override
	public ValidationMode getValidationMode() {
		
		if (this.validationMode == null) {
			this.validationMode = ValidationMode.AUTO;
		}
		
		return this.validationMode;
		
	} // Fin de getValidationMode()._______________________________________


		
	/**
	* Setter du mode de validation utilisé par l'ORM.
	* <ul>
	* <li>correspond au <code>validation-mode</code> element 
	* dans un persistence.xml</li>
	* </ul>
	*
	* @param pValidationMode : ValidationMode : 
	* valeur à passer à this.validationMode.<br/>
	*/
	public void setValidationMode(
			final ValidationMode pValidationMode) {
		this.validationMode = pValidationMode;
	} // Fin de setValidationMode(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Properties getProperties() {
		return this.properties;
	} // Fin de getProperties().___________________________________________
	
	
	
	/**
	* setter des <b>propriétés de connexion à la base 
	* éventuellement spécifiques 
	* à l'ORM, à SPRING, à H2, ...</b> 
	* comme par exemple le dialecte HIBERNATE.<br/>
	* <ul>
	* <li>correspond au <code>properties</code> element 
	* dans un persistence.xml</li>
	* <li>chaque Property de properties correspond au 
	* <code>property</code> element dans un persistence.xml</li>
	* <li><code>hibernate.connection.url</code> 
	* (URL de connexion à la base), 
	* <code>javax.persistence.jdbc.driver</code> 
	* (driver de connexion à la base) sont des Property...</li>
	* </ul>
	*
	* @param pProperties : Properties : 
	* valeur à passer à this.properties.<br/>
	*/
	public void setProperties(
			final Properties pProperties) {
		this.properties = pProperties;
	} // Fin de setProperties(...).________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * - retourne JPA_VERSION si 
	 * this.persistenceXMLSchemaVersion == null.<br/>
	 */
	@Override
	public String getPersistenceXMLSchemaVersion() {
		
		if (this.persistenceXMLSchemaVersion == null) {
			this.persistenceXMLSchemaVersion = JPA_VERSION;
		}
		
		return this.persistenceXMLSchemaVersion;
		
	} // Fin de getPersistenceXMLSchemaVersion().__________________________
	
	

	/**
	* setter de la version de JPA utilisée dans le persistence.xml.
	*
	* @param pPersistenceXMLSchemaVersion : String : 
	* valeur à passer à this.persistenceXMLSchemaVersion.<br/>
	*/
	public void setPersistenceXMLSchemaVersion(
			final String pPersistenceXMLSchemaVersion) {
		this.persistenceXMLSchemaVersion = pPersistenceXMLSchemaVersion;
	} // Fin de setPersistenceXMLSchemaVersion(...)._______________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClassLoader getClassLoader() {
		
		if (this.classLoader == null) {
			this.classLoader 
				= Thread.currentThread().getContextClassLoader();
		}
		
		return this.classLoader;
		
	} // Fin de getClassLoader().__________________________________________

		
	
	/**
	* Setter du ClassLoader utilisé par l'ORM 
	* pour charger les Entities JPA, ....
	*
	* @param pClassLoader : ClassLoader : 
	* valeur à passer à this.classLoader.<br/>
	*/
	public final void setClassLoader(
			final ClassLoader pClassLoader) {
		this.classLoader = pClassLoader;
	} // Fin de setClassLoader(...)._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addTransformer(
			final ClassTransformer pTransformer) {
		return;
	} // Fin de addTransformer(...)._______________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClassLoader getNewTempClassLoader() {
		return this.newTempClassLoader;
	} // Fin de getNewTempClassLoader().___________________________________


	
	/**
	* Setter du ClassLoader utilisé temporairement 
	* par l'ORM pour charger les Entities JPA, ....
	*
	* @param pNewTempClassLoader : ClassLoader : 
	* valeur à passer à this.newTempClassLoader.<br/>
	*/
	public final void setNewTempClassLoader(
			final ClassLoader pNewTempClassLoader) {
		this.newTempClassLoader = pNewTempClassLoader;
	} // Fin de setNewTempClassLoader(...).________________________________
	
	
	
}
