package levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring;

import java.sql.Driver;

import javax.persistence.spi.PersistenceUnitTransactionType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import levy.daniel.application.model.utilitaires.normalizerurlbase.NormalizerUrlBase;
import levy.daniel.application.model.utilitaires.normalizerurlbase.UrlEncapsulation;

/**
 * CLASSE LecteurPropertiesSpring :<br/>
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
 * @since 20 janv. 2019
 *
 */
@Configuration(value="LecteurPropertiesSpring")
@PropertySources({@PropertySource("classpath:configurations_bases_jpa/configuration_H2_file.properties")})
public class LecteurPropertiesSpring {

	// ************************ATTRIBUTS************************************/

	/**
	 * "Classe LecteurPropertiesSpring".
	 */
	public static final String CLASSE_LECTEUR_PROPERTIES_SPRING 
		= "Classe LecteurPropertiesSpring";
	
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
	 * "Méthode lireUrl()".
	 */
	public static final String METHODE_LIRE_URL 
		= "Méthode lireUrl()";
	
	/**
	 * "Méthode lireDriver()".
	 */
	public static final String METHODE_LIRE_DRIVER 
		= "Méthode lireDriver()";
	
	/**
	 * "Méthode lireUserName()".
	 */
	public static final String METHODE_LIRE_USERNAME 
		= "Méthode lireUserName()";
	
	/**
	 * "Méthode lirePassword()".
	 */
	public static final String METHODE_LIRE_PASSWORD 
		= "Méthode lirePassword()";

	
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
	 */
	public static final String SAUT_LIGNE_PLATEFORME 
		= System.getProperty("line.separator");
	
	/**
	 * <b>lecteur SPRING du fichier properties</b> proposé 
	 * dans l'annotation sur la présente classe 'PropertySource'.
	 * <ul>
	 * <li>injecté par SPRING via le Setter 
	 * <code>setEnvironmentSpring(Environment pEnvironmentSpring)</code>
	 * .</li>
	 * <li>org.springframework.core.env.Environment</li>
	 * </ul>
	 */
	private Environment environmentSpring;
	
	/**
	 * conteneur de type 
	 * <code>javax.persistence.spi.PersistenceUnitInfo</code> 
	 * pour les valeurs lues dans le properties 
	 * de configuration indiqué dans l'annotation 
	 * PropertySource au dessus de la présente classe.
	 */
	public PersistenceUnitInfoJPASansXML persistenceUnitInfoJPASansXML 
		= new PersistenceUnitInfoJPASansXML();

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
	private String url;
	
	/**
	 * DRIVER de la BASE.
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
	private Driver driver;
	
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
	private String userName;
	
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
	private String password;
	
	/**
	 * DataSource fournie par le conteneur de Servlet (TOMCAT) 
	 * via JNDI en cas de transactions JTA.
	 * <ul>
	 * <li>valeur non lue dans le properties de configuration SPRING</li>
	 * <li>déduite de transactionType 
	 * (jtaDataSource existe si transactionType = JTA).</li>
	 * <li>clé : element <code>jta-data-source</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.connection.datasource</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private SimpleDriverDataSource jtaDataSource;
	
	/**
	 * DataSource de l'application Standalone 
	 * en cas de transactions RESOURCE_LOCAL (pas de TOMCAT).
	 * <ul>
	 * <li>valeur non lue dans le properties de configuration SPRING</li>
	 * <li>déduite de transactionType 
	 * (nonJtaDataSource existe si transactionType 
	 * = RESOURCE_LOCAL ou NULL).</li>
	 * <li>clé : element <code>non-jta-data-source</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.connection.datasource</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private SimpleDriverDataSource nonJtaDataSource;
	
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
	 * "javax.persistence.jdbc.connexion.url".
	 */
	public static final String URL_KEY 
		= "javax.persistence.jdbc.connexion.url";
	
	/**
	 * "javax.persistence.jdbc.driver".
	 */
	public static final String DRIVER_KEY 
		= "javax.persistence.jdbc.driver";
	
	/**
	 * "javax.persistence.jdbc.connection.username".
	 */
	public static final String USERNAME_KEY 
		= "javax.persistence.jdbc.connection.username";
	
	/**
	 * "javax.persistence.jdbc.connection.password".
	 */
	public static final String PASSWORD_KEY 
		= "javax.persistence.jdbc.connection.password";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(LecteurPropertiesSpring.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public LecteurPropertiesSpring() {		
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * <b>Crée un bean nommé "lecteurPropertiesSpring" 
	 * qui retourne la présente instance et la place 
	 * dans le conteneur SPRING</b>.<br/>
	 * <ul>
	 * <li><b>this.environmentSpring</b> 
	 * (org.springframework.core.env.Environment) est 
	 * <i>déjà injecté</i> par SPRING via son setter 
	 * lors de la création de ce présent BEAN.</li>
	 * <li><b>lit le properties</b> proposé dans l'annotation 
	 * sur la présente classe 'PropertySource' 
	 * grace à this.environmentSpring</li>
	 * </ul>
	 *
	 * @return : LecteurPropertiesSpring :  .<br/>
	 */
	@Bean(value = "lecteurPropertiesSpring")
	public LecteurPropertiesSpring lecteurPropertiesSpring() {
		
		this.lireProperties();
		
		return this;
	}


	
	/**
	 * <b>Lit le fichier properties proposé 
	 * dans l'annotation sur la présente classe 'PropertySource' 
	 * et alimente le CONTENEUR 
	 * <code>this.persistenceUnitInfoJPASansXML</code> 
	 * avec toutes les valeurs lues</b>.
	 * <ul>
	 * <li>automatiquement appelé par la méthode de création 
	 * de BEAN SPRING <code>this.lecteurPropertiesSpring()</code></li>
	 * <li>appelée <i>après</i> l'injection de 
	 * <code>this.environmentSpring</code> par SPRING 
	 * dans la présente classe.</li>
	 * <ul>
	 * <li>lit le nom de l'unité de persistence (persistenceUnitName).</li>
	 * <li>lit le type de transaction (transactionType).</li>
	 * <li>passe HIBERNATE pour SPRING comme PersistenceProvider.</li>
	 * <li>lit l'URL de la base (url).</li>
	 * <li>lit le DRIVER de la Base (driver).</li>
	 * <li>lit le LOGIN de la Base (userName).</li>
	 * <li>lit le PASSWORD de la Base (password).</li>
	 * <li>ALIMENTE jtaDataSource et nonJtaDataSource.</li>
	 * <li></li>
	 * <li></li>
	 * <li></li>
	 * <li></li>
	 * <li></li>
	 * </ul>
	 * </ul>
	 */
	private void lireProperties() {
		
		/* persistenceUnitName. */
		this.persistenceUnitInfoJPASansXML
			.setPersistenceUnitName(this.lirePersistenceUnitName());
		
		/* transactionType. */
		this.persistenceUnitInfoJPASansXML
			.setTransactionType(this.lireTransactionType());
		
		/* persistenceProvider. */
		this.persistenceUnitInfoJPASansXML
			.setPersistenceProviderClassName(this.lirePersistenceProvider());
		
		/* URL. */
		this.lireUrl();
		
		/* DRIVER. */
		this.lireDriver();
		
		/* userName. */
		this.lireUserName();
		
		/* password. */
		this.lirePassword();
		
		/* jtaDataSource et nonJtaDataSource. */
		this.determinerTypeDataSource();
		
	} // Fin de lireProperties().__________________________________________
	

	
	/**
	 * <b>lit la valeur de persistenceUnitName dans le properties</b>
	 * <ul>
	 * <li>correspond à l'élément 
	* <code>persistence-unit.name</code> dans un persistence.xml 
	* préconisé par JPA.</li>
	* </ul>
	 *
	 * @return : String : nom de l'unité de persistance.<br/>
	 */
	private String lirePersistenceUnitName() {
		
		String persistenceUnitName = null;
		
		if (this.environmentSpring != null) {
			
			persistenceUnitName 
				= this.environmentSpring.getProperty(
					PERSISTENCE_UNIT_NAME_KEY);
			
		} else {
			
			final String message 
				= CLASSE_LECTEUR_PROPERTIES_SPRING 
				+ TIRET_ESPACE
				+ METHODE_LIRE_PERSISTENCE_UNIT_NAME
				+ TIRET_ESPACE
				+ "environmentSpring NON INJECTE !!!";
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message);
			}
		}
		
		return persistenceUnitName;
		
	} // Fin de lirePersistenceUnitName()._________________________________


	
	/**
	 * <b>lit la valeur de transactionType dans le properties</b>
	 * <ul>
	 * <li>correspond à l'élément 
	* <code>persistence-unit.transaction-type</code> 
	* dans un persistence.xml préconisé par JPA.</li>
	 * </ul>
	 *
	 * @return : PersistenceUnitTransactionType : 
	 * type de transaction.<br/>
	 */
	private PersistenceUnitTransactionType lireTransactionType() {
		
		String transactionTypeString = null;
		PersistenceUnitTransactionType transactionType = null; 
		
		if (this.environmentSpring != null) {
			
			transactionTypeString 
				= this.environmentSpring.getProperty(
						TRANSACTION_TYPE_KEY);
			
			if ("JTA".equalsIgnoreCase(transactionTypeString)) {
				transactionType 
					= PersistenceUnitTransactionType.JTA;
			} else if ("RESOURCE_LOCAL"
					.equalsIgnoreCase(transactionTypeString)) {
				transactionType 
					= PersistenceUnitTransactionType.RESOURCE_LOCAL;
			} else {
				transactionType = null;
			}
			
		} else {
			
			final String message 
				= CLASSE_LECTEUR_PROPERTIES_SPRING 
				+ TIRET_ESPACE
				+ METHODE_LIRE_TRANSACTION_TYPE
				+ TIRET_ESPACE
				+ "environmentSpring NON INJECTE !!!";
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message);
			}
		}
		
		return transactionType;
		
	} // Fin de lireTransactionType()._____________________________________
	

	
	/**
	 * <b>retourne toujours le JpaVendorAdapter HIBERNATE pour SPRING : 
	 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter</b>.<br/>
	 * <ul>
	 * <li>valeur non lue dans le properties de configuration SPRING</li>
	 * <li>un persistence.xml ne comporte pas obligatoirement 
	 * l'élément <code>provider</code> si on 
	 * veut le rendre indépendant de l'ORM.</li>
	 * </ul>
	 *
	 * @return : String : 
	 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter.<br/>
	 */
	private String lirePersistenceProvider() {
		return HibernateJpaVendorAdapter.class.getName();
	} // Fin de lirePersistenceProvider()._________________________________
	
	
	
	/**
	 * <b>lit la valeur de URL dans le properties et la normalise</b>.<br/>
	 * injecte la valeur lue dans <code>this.url</code>.<br/>
	 * <ul>
	 * <li>correspond à l'élément property nommé
	 * <code>javax.persistence.jdbc.url</code> dans un persistence.xml 
	 * préconisé par JPA.</li>
	 * </ul>
	 *
	 * @return this.url : String : URL de la base.<br/>
	 */
	private String lireUrl() {
				
		if (this.environmentSpring != null) {
			
			final String urlFournie 
				= this.environmentSpring.getProperty(
					URL_KEY);
			
			if (urlFournie != null) {
				
				final String bd = "base-adresses_javafx";
				
				String urlNormalisee = null;
				
				final UrlEncapsulation encapsulation 
				 	= NormalizerUrlBase.creerUrlEncapsulation(urlFournie, bd);
				 
				urlNormalisee = encapsulation.getUrlNormalisee();
				
				this.url = urlNormalisee;
				
			}			
			
		} else {
			
			final String message 
				= CLASSE_LECTEUR_PROPERTIES_SPRING 
				+ TIRET_ESPACE
				+ METHODE_LIRE_URL
				+ TIRET_ESPACE
				+ "environmentSpring NON INJECTE !!!";
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message);
			}
		}
		
		return this.url;
		
	} // Fin de lireUrl()._________________________________________________	

		
	
	/**
	 * <b>lit la valeur du Driver de BD dans le properties</b>.<br/>
	 * injecte la valeur lue dans <code>this.driver</code>.<br/>
	 * <ul>
	 * <li>correspond à l'élément property nommé
	 * <code>javax.persistence.jdbc.driver</code> dans un persistence.xml 
	 * préconisé par JPA.</li>
	 * </ul>
	 *
	 * @return : this.driver : java.sql.Driver.<br/>
	 */
	private Driver lireDriver() {
				
		if (this.environmentSpring != null) {
			
			final String driverString 
				= this.environmentSpring.getProperty(
					DRIVER_KEY);
			
			if (driverString != null) {
							
				try {
					
					this.driver 
					= (Driver) Class.forName(driverString).newInstance();
					
				} catch (Exception e) {
					
					final String message 
						= CLASSE_LECTEUR_PROPERTIES_SPRING 
						+ TIRET_ESPACE
						+ METHODE_LIRE_DRIVER
						+ TIRET_ESPACE
						+ "impossible de charger le DRIVER : " 
						+ driverString;
					
					if (LOG.isFatalEnabled()) {
						LOG.fatal(message, e);
					}
				}
								
			}
					
		} else {
			
			final String message 
				= CLASSE_LECTEUR_PROPERTIES_SPRING 
				+ TIRET_ESPACE
				+ METHODE_LIRE_DRIVER
				+ TIRET_ESPACE
				+ "environmentSpring NON INJECTE !!!";
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message);
			}
		}
		
		return this.driver;

	} // Fin de lireDriver().______________________________________________
	

	
	/**
	 * <b>lit la valeur du LOGIN de BD dans le properties</b>.<br/>
	 * injecte la valeur lue dans <code>this.userName</code>.<br/>
	 * <ul>
	 * <li>correspond à l'élément property nommé
	 * <code>javax.persistence.jdbc.user</code> dans un persistence.xml 
	 * préconisé par JPA.</li>
	 * </ul>
	 *
	 * @return : String : this.userName.<br/>
	 */
	private String lireUserName() {
		
		if (this.environmentSpring != null) {
			
			this.userName 
				= this.environmentSpring.getProperty(
						USERNAME_KEY);
			
		} else {
			
			final String message 
				= CLASSE_LECTEUR_PROPERTIES_SPRING 
				+ TIRET_ESPACE
				+ METHODE_LIRE_USERNAME
				+ TIRET_ESPACE
				+ "environmentSpring NON INJECTE !!!";
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message);
			}
		}
		
		return this.userName;
		
	} // Fin de lireUserName().____________________________________________
	

	
	/**
	 * <b>lit la valeur du PASSWORD de BD dans le properties</b>.<br/>
	 * injecte la valeur lue dans <code>this.password</code>.<br/>
	 * <ul>
	 * <li>correspond à l'élément property nommé
	 * <code>javax.persistence.jdbc.password</code> dans un persistence.xml 
	 * préconisé par JPA.</li>
	 * </ul>
	 *
	 * @return : String : this.password.<br/>
	 */
	private String lirePassword() {
		
		if (this.environmentSpring != null) {
			
			this.password 
				= this.environmentSpring.getProperty(
						PASSWORD_KEY);
			
		} else {
			
			final String message 
				= CLASSE_LECTEUR_PROPERTIES_SPRING 
				+ TIRET_ESPACE
				+ METHODE_LIRE_PASSWORD
				+ TIRET_ESPACE
				+ "environmentSpring NON INJECTE !!!";
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message);
			}
		}
		
		return this.password;
		
	} // Fin de lirePassword().____________________________________________


	
	/**
	 * <b>détermine le type de DataSource 
	 * (jtaDataSource ou nonJtaDataSource) 
	 * en fonction du type de transaction transactionType.</b>.<br/>
	 * <ul>
	 * <li>alimente <code>this.jtaDataSource</code> 
	 * et <code>this.nonJtaDataSource</code>.</li>
	 * <li>retourne une nonJtaDataSource alimentée en 
	 * [driver, URL, userName, password] 
	 * si transactionType == null.</li>
	 * <li>retourne une jtaDataSource alimentée en 
	 * [driver, URL, userName, password] 
	 * si transactionType == JTA.</li>
	 * <li>retourne une nonJtaDataSource alimentée en 
	 * [driver, URL, userName, password] 
	 * si transactionType == RESOURCE_LOCAL.</li>
	 * </ul>
	 *
	 * @return : org.springframework.jdbc.datasource.SimpleDriverDataSource : 
	 * this.jtaDataSource ou  this.nonJtaDataSource.<br/>
	 */
	private SimpleDriverDataSource determinerTypeDataSource() {
		
		if (this.getTransactionType() == null) {
			
			this.jtaDataSource = null;
			
			this.nonJtaDataSource 
				= new SimpleDriverDataSource(
						this.driver
						, this.url
						, this.userName, this.password);
			
			return this.nonJtaDataSource;
			
		} else if (this.getTransactionType()
				.equals(PersistenceUnitTransactionType.JTA)) {
			
			this.jtaDataSource 
				= new SimpleDriverDataSource(
					this.driver
					, this.url
					, this.userName, this.password);
			
			this.nonJtaDataSource = null;
			
			return this.jtaDataSource;
			
		} else if (this.getTransactionType()
				.equals(PersistenceUnitTransactionType.RESOURCE_LOCAL)) {
			
			this.jtaDataSource = null;
			
			this.nonJtaDataSource 
				= new SimpleDriverDataSource(
						this.driver
						, this.url
						, this.userName, this.password);
			
			return this.nonJtaDataSource;
		}
		
		this.jtaDataSource = null;
		this.nonJtaDataSource = null;
		
		return null;
		
	} // Fin de determinerTypeDataSource().________________________________
	

	
	/**
	 * <b>fournit une String pour l'affichage 
	 * du contenu d'un SimpleDriverDataSource pDataSource</b>.<br/>
	 * <br/>
	 * - retourne null si pDataSource == null.
	 * <br/>
	 *
	 * @param pDataSource : 
	 * org.springframework.jdbc.datasource.SimpleDriverDataSource.<br/>
	 * 
	 * @return : String : affichage.<br/>
	 */
	public final String afficherDataSource(
			final SimpleDriverDataSource pDataSource) {
		
		/* retourne null si pDataSource == null. */
		if (pDataSource == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		final String driverLocal = pDataSource.getDriver().toString();
		final String urlLocal = pDataSource.getUrl();
		final String userNameLocal = pDataSource.getUsername();
		final String passwordLocal = pDataSource.getPassword();
		
		stb.append("- DRIVER : ");
		stb.append(driverLocal);
		
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		stb.append("- URL : ");
		stb.append(urlLocal);
		
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		stb.append("- USERNAME (LOGIN) : ");
		stb.append(userNameLocal);
		
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		stb.append("- PASSWORD : ");
		stb.append(passwordLocal);
				
		return stb.toString();
		
	} // Fin de afficherDataSource(...).___________________________________
	
	
	
	/**
	 * Getter du <b>lecteur SPRING du fichier properties</b> proposé 
	 * dans l'annotation sur la présente classe 'PropertySource'.
	 * <ul>
	 * <li>injecté par SPRING via le Setter 
	 * <code>setEnvironmentSpring(Environment pEnvironmentSpring)</code>
	 * .</li>
	 * </ul>
	 *
	 * @return this.environmentSpring : 
	 * org.springframework.core.env.Environment.<br/>
	 */
	public final Environment getEnvironmentSpring() {
		return this.environmentSpring;
	} // Fin de getEnvironmentSpring().____________________________________


	
	/**
	* Setter du <b>lecteur SPRING du fichier properties</b> proposé 
	* dans l'annotation sur la présente classe 'PropertySource'.
	* <ul>
	* <li>injecté par SPRING via le Setter 
	* <code>setEnvironmentSpring(Environment pEnvironmentSpring)</code>
	* .</li>
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



	/**
	 * Getter du conteneur de type 
	 * <code>javax.persistence.spi.PersistenceUnitInfo</code> 
	 * <b><code>this.persistenceUnitInfoJPASansXML</code></b>
	 * pour les valeurs lues dans le properties 
	 * de configuration indiqué dans l'annotation 
	 * PropertySource au dessus de la présente classe.
	 *
	 * @return this.persistenceUnitInfoJPASansXML : 
	 * PersistenceUnitInfoJPASansXML.<br/>
	 */
	public final PersistenceUnitInfoJPASansXML getPersistenceUnitInfoJPASansXML() {
		return this.persistenceUnitInfoJPASansXML;
	} // Fin de getPersistenceUnitInfoJPASansXML().________________________


	
	/**
	* Setter du conteneur de type 
	* <code>javax.persistence.spi.PersistenceUnitInfo</code> 
	* <b><code>this.persistenceUnitInfoJPASansXML</code></b>
	* pour les valeurs lues dans le properties 
	* de configuration indiqué dans l'annotation 
	* PropertySource au dessus de la présente classe.
	*
	* @param pPersistenceUnitInfoJPASansXML : PersistenceUnitInfoJPASansXML : 
	* valeur à passer à this.persistenceUnitInfoJPASansXML.<br/>
	*/
	public final void setPersistenceUnitInfoJPASansXML(
			final PersistenceUnitInfoJPASansXML pPersistenceUnitInfoJPASansXML) {
		this.persistenceUnitInfoJPASansXML = pPersistenceUnitInfoJPASansXML;
	} // Fin de setPersistenceUnitInfoJPASansXML(...)._____________________
	
	
	
	/**
	 * <b>retourne le nom de l'unité de persistence (persistenceUnitName) 
	 * stocké dans le conteneur 
	 * <code>this.persistenceUnitInfoJPASansXML</code></b> 
	 * après lecture du properties 
	 * de configuration indiqué dans l'annotation 
	 * PropertySource au dessus de la présente classe<br/>
	 * <ul>
	 * <li>clé : <code>javax.persistence.jdbc.persistence-unit.name</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : <code>persistence-unit.name</code> dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.ejb.persistenceUnitName</code> 
	 * dans un EntityManagerFactory créé par le PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return : String : nom de l'unité de persistence.<br/>
	 */
	public String getPersistenceUnitName() {
		return this.persistenceUnitInfoJPASansXML.getPersistenceUnitName();
	} // Fin de getPersistenceUnitName().__________________________________


	
	/**
	 * <b>retourne le type de transaction (transactionType) 
	 * stocké dans le conteneur 
	 * <code>this.persistenceUnitInfoJPASansXML</code></b> 
	 * après lecture du properties 
	 * de configuration indiqué dans l'annotation 
	 * PropertySource au dessus de la présente classe<br/>
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.persistence-unit.transaction-type</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : <code>persistence-unit.transaction-type</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.transaction.coordinator</code> 
	 * dans un EntityManagerFactory créé par le PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return : PersistenceUnitTransactionType : 
	 * type de transaction.<br/>
	 */
	public PersistenceUnitTransactionType getTransactionType() {
		return this.persistenceUnitInfoJPASansXML.getTransactionType();
	} // Fin de getTransactionType().______________________________________
	

	
	/**
	 * retourne le nom qualifié de l'ORM (HIBERNATE) pour SPRING : 
	 * <i>org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter</i>.<br/>
	 * <ul>
	 * <li>non lu dans le properties SPRING.</li>
	 * <li>clé : <code>provider</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>????</code> 
	 * dans un EntityManagerFactory créé par 
	 * le PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return : String : 
	 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter.<br/>
	 */
	public String getPersistenceProviderClassName() {
		return this.persistenceUnitInfoJPASansXML
				.getPersistenceProviderClassName();
	} // Fin de getPersistenceProviderClassName()._________________________

	
	
	/**
	 * <b>retourne l'URL de la Base 
	 * stocké dans l'objet DataSource du conteneur 
	 * <code>this.persistenceUnitInfoJPASansXML</code></b> 
	 * après lecture du properties 
	 * de configuration indiqué dans l'annotation 
	 * PropertySource au dessus de la présente classe<br/>
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.connexion.url</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.url</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.url</code> 
	 * dans un EntityManagerFactory créé par le PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return : String : this.url.<br/>
	 */
	public String getUrl() {
		return this.url;
	} // Fin de getUrl().__________________________________________________

	
	
	/**
	 * <b>retourne le DRIVER de la Base 
	 * stocké dans l'objet DataSource du conteneur 
	 * <code>this.persistenceUnitInfoJPASansXML</code></b> 
	 * après lecture du properties 
	 * de configuration indiqué dans l'annotation 
	 * PropertySource au dessus de la présente classe<br/>
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
	 * @return : this.driver : java.sql.Driver.<br/>
	 */
	public Driver getDriver() {
		return this.driver;
	} // Fin de getDriver()._______________________________________________
	
	
	
	/**
	 * <b>retourne le LOGIN de la Base 
	 * stocké dans l'objet DataSource du conteneur 
	 * <code>this.persistenceUnitInfoJPASansXML</code></b> 
	 * après lecture du properties 
	 * de configuration indiqué dans l'annotation 
	 * PropertySource au dessus de la présente classe<br/>
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
	 * @return : String : this.userName.<br/>
	 */
	public String getUserName() {
		return this.userName;
	} // Fin de getUserName()._____________________________________________
	
	
	
	/**
	 * <b>retourne le PASSWORD de la Base 
	 * stocké dans l'objet DataSource du conteneur 
	 * <code>this.persistenceUnitInfoJPASansXML</code></b> 
	 * après lecture du properties 
	 * de configuration indiqué dans l'annotation 
	 * PropertySource au dessus de la présente classe<br/>
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
	 * @return : String : this.password.<br/>
	 */
	public String getPassword() {
		return this.password;
	} // Fin de getPassword()._____________________________________________
	

	
	/**
	 * <b>retourne l'objet DataSource jtaDataSource du conteneur 
	 * <code>this.persistenceUnitInfoJPASansXML</code></b> 
	 * après lecture du properties 
	 * de configuration indiqué dans l'annotation 
	 * PropertySource au dessus de la présente classe<br/>
	 * <ul>
	 * <li>valeur non lue dans le properties de configuration SPRING</li>
	 * <li>déduite de transactionType 
	 * (jtaDataSource existe si transactionType = JTA).</li>
	 * <li>clé : element <code>jta-data-source</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.connection.datasource</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return : SimpleDriverDataSource : this.jtaDataSource.<br/>
	 */
	public SimpleDriverDataSource getJtaDataSource() {
		return this.jtaDataSource;
	} // Fin de getJtaDataSource().________________________________________
	

	
	/**
	 * <b>retourne l'objet DataSource nonJtaDataSource du conteneur 
	 * <code>this.persistenceUnitInfoJPASansXML</code></b> 
	 * après lecture du properties 
	 * de configuration indiqué dans l'annotation 
	 * PropertySource au dessus de la présente classe<br/>
	 * <ul>
	 * <li>valeur non lue dans le properties de configuration SPRING</li>
	 * <li>déduite de transactionType 
	 * (nonJtaDataSource existe si transactionType 
	 * = RESOURCE_LOCAL ou NULL).</li>
	 * <li>clé : element <code>non-jta-data-source</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.connection.datasource</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 *
	 * @return : SimpleDriverDataSource : this.nonJtaDataSource.<br/>
	 */
	public SimpleDriverDataSource getNonJtaDataSource() {
		return this.nonJtaDataSource;
	} // Fin de getNonJtaDataSource()._____________________________________

	
	
}
