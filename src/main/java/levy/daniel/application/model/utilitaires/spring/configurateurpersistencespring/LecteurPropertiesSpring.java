package levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring;

import javax.persistence.spi.PersistenceUnitTransactionType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

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
	 * "javax.persistence.jdbc.persistence-unit.name".
	 */
	public static final String PERSISTENCE_UNIT_NAME_KEY 
		= "javax.persistence.jdbc.persistence-unit.name";
	
	/**
	 * javax.persistence.jdbc.persistence-unit.transaction-type.
	 */
	public static final String TRANSACTION_TYPE 
		= "javax.persistence.jdbc.persistence-unit.transaction-type";
	
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
	 * <li>lit le nom de l'unité de persistence (persistenceUnitName) </li>
	 * <li></li>
	 * <li></li>
	 * <li></li>
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
		
		/* transactionType*/
		this.persistenceUnitInfoJPASansXML
			.setTransactionType(this.lireTransactionType());
		
	}
	

	
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
						TRANSACTION_TYPE);
			
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
	
	
	
}
