package levy.daniel.application.model.utilitaires.spring.afficheurcontexte;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE AfficheurContexteSpring :<br/>
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
 * @since 12 janv. 2019
 *
 */
public class AfficheurContexteSpring {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * saut de ligne de la plateforme.<br/>
	 */
	public static final String SAUT_LIGNE_PLATEFORME 
		= System.getProperty("line.separator");
		
	/**
	 * PROPERTY_PERSISTENCE_UNIT.<br/>
	 */
	public static final String PROPERTY_PERSISTENCE_UNIT 
		= "hibernate.ejb.persistenceUnitName";
	
	/**
	 * "hibernate.transaction.coordinator_class".<br/>
	 */
	public static final String PROPERTY_TRANSACTION_TYPE 
		= "hibernate.transaction.coordinator_class";

	/**
	 * "hibernate.connection.url".<br/>
	 */
	public static final String PROPERTY_HIBERNATE_CONNECTION_URL 
		= "hibernate.connection.url";
	
	/**
	 * "hibernate.connection.username".<br/>
	 */
	public static final String PROPERTY_HIBERNATE_CONNECTION_USERNAME 
		= "hibernate.connection.username";
	
	/**
	 * "hibernate.connection.password".<br/>
	 */
	public static final String PROPERTY_HIBERNATE_CONNECTION_PASSWORD 
		= "hibernate.connection.password";
	
	/**
	 * "javax.persistence.jdbc.driver".<br/>
	 */
	public static final String PROPERTY_DRIVER 
		= "javax.persistence.jdbc.driver";
	
	/**
	 * "hibernate.dialect".<br/>
	 */
	public static final String PROPERTY_HIBERNATE_DIALECT 
		= "hibernate.dialect";
	
	/**
	 * "hibernate.show_sql".<br/>
	 */
	public static final String PROPERTY_SHOW_SQL 
		= "hibernate.show_sql";
	
	/**
	 * "hibernate.format_sql".<br/>
	 */
	public static final String PROPERTY_FORMAT_SQL 
		= "hibernate.format_sql";
	
	/**
	 * "hibernate.use_sql_comments".<br/>
	 */
	public static final String PROPERTY_USE_SQL_COMMENTS 
		= "hibernate.use_sql_comments";
	
	/**
	 * "hibernate.generate_statistics".<br/>
	 */
	public static final String PROPERTY_GENERATE_STATISTICS 
		= "hibernate.generate_statistics";
	
	/**
	 * "cache.provider_class".<br/>
	 */
	public static final String PROPERTY_CACHE_PROVIDER 
		= "cache.provider_class";
	
	/**
	 * "hibernate.hbm2ddl.auto".<br/>
	 */
	public static final String PROPERTY_HBM2DDL_AUTO 
		= "hibernate.hbm2ddl.auto";
	
	/**
	 * "java.specification.version".<br/>
	 */
	public static final String PROPERTY_VERSION_JAVA 
		= "java.specification.version";
	
	/**
	 * "java.class.path".<br/>
	 */
	public static final String PROPERTY_CLASS_PATH 
		= "java.class.path";
	
	/**
	 * "user.timezone".<br/>
	 */
	public static final String PROPERTY_USER_TIMEZONE 
		= "user.timezone";
	
	/**
	 * "os.name".<br/>
	 */
	public static final String PROPERTY_OS_NAME 
		= "os.name";
	
	/**
	 * "os.version".<br/>
	 */
	public static final String PROPERTY_OS_VERSION 
		= "os.version";
	
	/**
	 * "user.language".<br/>
	 */
	public static final String PROPERTY_USER_LANGAGE 
		= "user.language";
	
	/**
	 * "user.country".<br/>
	 */
	public static final String PROPERTY_USER_COUNTRY 
		= "user.country";
	
	/**
	 * "file.encoding".<br/>
	 */
	public static final String PROPERTY_FILE_ENCODING 
		= "file.encoding";
	
	/**
	 * "user.dir".<br/>
	 */
	public static final String PROPERTY_REP_PROJET 
		= "user.dir";

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(AfficheurContexteSpring.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	private AfficheurContexteSpring() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * <b>retourne une String pour l'affichage des principales Properties 
	 * lues par l'EntityManagerFactory</b>.<br/>
	 * <br/>
	 * 
	 * @param pEntityManagerFactory : EntityManagerFactory
	 *
	 * @return : String.<br/>
	 */
	public static String afficherPrincipalesProperties(
			final EntityManagerFactory pEntityManagerFactory) {
		
		synchronized(AfficheurContexteSpring.class) {
			
			
			final StringBuffer stb = new StringBuffer();
			
			final String persistenceUnit 
				= getProperty(PROPERTY_PERSISTENCE_UNIT, pEntityManagerFactory);
			final String transactionType 
				= getProperty(PROPERTY_TRANSACTION_TYPE, pEntityManagerFactory);
			final String url 
				= getProperty(PROPERTY_HIBERNATE_CONNECTION_URL, pEntityManagerFactory);
			final String login
				= getProperty(PROPERTY_HIBERNATE_CONNECTION_USERNAME, pEntityManagerFactory);
			final String mdp
				= getProperty(PROPERTY_HIBERNATE_CONNECTION_PASSWORD, pEntityManagerFactory);
			final String driver
				= getProperty(PROPERTY_DRIVER, pEntityManagerFactory);
			final String dialecte
				= getProperty(PROPERTY_HIBERNATE_DIALECT, pEntityManagerFactory);
			final String showSql
				= getProperty(PROPERTY_SHOW_SQL, pEntityManagerFactory);
			final String formatSql
				= getProperty(PROPERTY_FORMAT_SQL, pEntityManagerFactory);
			final String commentsSql
				= getProperty(PROPERTY_USE_SQL_COMMENTS, pEntityManagerFactory);
			final String statistics
				= getProperty(PROPERTY_GENERATE_STATISTICS, pEntityManagerFactory);
			final String cache
				= getProperty(PROPERTY_CACHE_PROVIDER, pEntityManagerFactory);
			final String generationSchema
				= getProperty(PROPERTY_HBM2DDL_AUTO, pEntityManagerFactory);
			final String versionJava
				= getProperty(PROPERTY_VERSION_JAVA, pEntityManagerFactory);
			final String classPath
				= getProperty(PROPERTY_CLASS_PATH, pEntityManagerFactory);
			final String timeZone
				= getProperty(PROPERTY_USER_TIMEZONE, pEntityManagerFactory);
			final String osName
				= getProperty(PROPERTY_OS_NAME, pEntityManagerFactory);
			final String osVersion
				= getProperty(PROPERTY_OS_VERSION, pEntityManagerFactory);
			final String userLangage
				= getProperty(PROPERTY_USER_LANGAGE, pEntityManagerFactory);
			final String userCountry
				= getProperty(PROPERTY_USER_COUNTRY, pEntityManagerFactory);
			final String encoding
				= getProperty(PROPERTY_FILE_ENCODING, pEntityManagerFactory);
			final String projet
				= getProperty(PROPERTY_REP_PROJET, pEntityManagerFactory);
			
			stb.append("Persistence-Unit : ");
			stb.append(persistenceUnit);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Transaction Type : ");
			stb.append(transactionType);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("URL De connexion à la base : ");
			stb.append(url);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Login : ");
			stb.append(login);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Mdp : ");
			stb.append(mdp);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Driver : ");
			stb.append(driver);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Dialecte : ");
			stb.append(dialecte);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Show SQL : ");
			stb.append(showSql);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Format SQL : ");
			stb.append(formatSql);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Commentaires SQL : ");
			stb.append(commentsSql);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Statistiques Hibernate : ");
			stb.append(statistics);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Cache de premier niveau : ");
			stb.append(cache);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Génération du Schéma de BD : ");
			stb.append(generationSchema);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Version de Java : ");
			stb.append(versionJava);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("ClassPath : ");
			stb.append(classPath);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("TimeZone : ");
			stb.append(timeZone);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("OS : ");
			stb.append(osName);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Version d'OS : ");
			stb.append(osVersion);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Langue : ");
			stb.append(userLangage);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Pays : ");
			stb.append(userCountry);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Encodage du persistence.xml : ");
			stb.append(encoding);
			stb.append(SAUT_LIGNE_PLATEFORME);
			stb.append("Répertoire du projet Java : ");
			stb.append(projet);
			stb.append(SAUT_LIGNE_PLATEFORME);
			
			return stb.toString();
			
		} // Fin du bloc synchronized._____________________
		
	} // Fin de afficherPrincipalesProperties().___________________________
	

	
	/**
	 * <b>Retourne la Property ayant pour clé pKey</b>.<br/>
	 * <ul>
	 * <li>retourne null si pKey == null.</li>
	 * <li>retourne null si pEntityManagerFactory == null.</li>
	 * </ul>
	 *
	 * @param pKey : String.<br/>
	 * @param pEntityManagerFactory : EntityManagerFactory.<br/> 
	 * 
	 * @return : String.<br/>
	 */
	public static String getProperty(
			final String pKey
				, final EntityManagerFactory pEntityManagerFactory) {
		
		synchronized(AfficheurContexteSpring.class) {
			
			/* retourne null si pKey == null. */
			if (pKey == null) {
				return null;
			}

			/* retourne null si pEntityManagerFactory == null. */
			if (pEntityManagerFactory == null) {
				return null;
			}
			
			final Map<String, Object> properties 
				= pEntityManagerFactory.getProperties();
			
			final Object resultat = properties.get(pKey);
			
			if (resultat != null) {
				return resultat.toString();
			}
			
			return null;
			
		} // Fin du bloc synchronized._____________________
				
	} // Fin de getProperty(...).__________________________________________
	
	
	
	/**
	 * <b>retourne une String pour l'affichage de toutes les 
	 * Properties lues par l'EntityManagerFactory</b>.<br/>
	 * <br/>
	 * - retourne null si pEntityManagerFactory == null.<br/>
	 * <br/>
	 * 
	 * @param pEntityManagerFactory : EntityManagerFactory.<br/>  
	 *
	 * @return : String.<br/>
	 */
	public static String afficherProperties(
			final EntityManagerFactory pEntityManagerFactory) {
		
		/* retourne null si pEntityManagerFactory == null. */
		if (pEntityManagerFactory == null) {
			return null;
		}
		
		final Map<String, Object> properties 
			= pEntityManagerFactory.getProperties();
		
		return afficherMapStringObject(properties);
		
	} // Fin de afficherProperties().______________________________________
	
	
	
	/**
	 * <b>Fournit une String pour l'affichage 
	 * d'une Map&lt;String, Object&gt;</b>.<br/>
	 * <ul>
	 * <li>retourne null si pMap == null.</li>
	 * </ul>
	 *
	 * @param pMap : Map&lt;String, Object&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public static String afficherMapStringObject(
			final Map<String, Object> pMap) {
		
		/* retourne null si pMap == null. */
		if (pMap == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		final Set<Entry<String, Object>> entrySet = pMap.entrySet();
		
		final Iterator<Entry<String, Object>> ite = entrySet.iterator();
		
		while (ite.hasNext()) {
			
			final Entry<String, Object> entry = ite.next();
			final String key = entry.getKey();
			final String value = entry.getValue().toString();
			
			stb.append("propriété : ");
			stb.append(key);
			stb.append('\t');
			stb.append("valeur : ");
			stb.append(value);
			stb.append('\n');
		}
		
		return stb.toString();
		
	} // Fin de afficherMapStringObject(...).______________________________
	

	
	/**
	 * <b>Fournit une String pour l'affichage d'un fichier</b>.
	 * <ul>
	 * <li>lit le fichier avec 
	 * <code>Files.readAllLines(pPath);</code></li>
	 * </ul>
	 * - retourne null si pPath == null.<br/>
	 * - retourne null si le fichier visé par pPath n'existe pas.<br/>
	 * - retourne null si le file visé par pPath est un répertoire.<br/> 
	 * <br/>
	 *
	 * @param pPath : Path : chemin du fichier à lire.<br/>
	 * 
	 * @return String.<br/>
	 * 
	 * @throws IOException
	 */
	public static String affichierFichier(
			final Path pPath) throws IOException {
		
		/* retourne null si pPath == null. */
		if (pPath == null) {
			return null;
		}
		
		final File file = pPath.toFile();
		
		/* retourne null si le fichier visé par pPath n'existe pas. */
		if (!file.exists()) {
			return null;
		}
		
		/* retourne null si le file visé par pPath est un répertoire. */
		if (file.isDirectory()) {
			return null;
		}
		
		final List<String> list = Files.readAllLines(pPath);
		
		final StringBuffer stb = new StringBuffer();
		
		for (final String ligne : list) {
			
			stb.append(ligne);
			stb.append(SAUT_LIGNE_PLATEFORME);
		}
		
		return stb.toString();
		
	} // Fin de affichierFichier(...)._____________________________________

}
