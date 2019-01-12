package levy.daniel.application;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import levy.daniel.application.model.persistence.metier.contactsimple.IContactSimpleDAO;
import levy.daniel.application.model.persistence.metier.contactsimple.dao.jpaspring.impl.ContactSimpleDAOJPASpring;

/**
 * CLASSE ConfigurationSpringFrameworkAnnotation :<br/>
 * <ul>
 * <li>l'annotation <b>Configuration</b>
 * (org.springframework.context.annotation.Configuration) précise qu'il s'agit
 * d'une classe de CONFIGURATION SPRING.</li>
 * <li>l'annotation <b>ComponentScan</b>
 * (org.springframework.context.annotation.ComponentScan) permet de préciser un
 * tableau de PACKAGES (sous forme de String) à scanner.</li>
 * </ul>
 *
 * - Exemple d'utilisation :<br/>
 * <br/>
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
 * @since 10 janv. 2019
 *
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScans({@ComponentScan("levy.daniel.application")})
public class ConfigurationSpringFrameworkAnnotation {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ConfigurationSpringFrameworkAnnotation.class);

	// *************************METHODES************************************/

	/**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public ConfigurationSpringFrameworkAnnotation() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @return : ContactSimpleDAOJPASpring : .<br/>
	 */
	@Bean(value = "ContactSimpleDAOJPASpring")
	public IContactSimpleDAO contactSimpleDAOJPASpring() {
		return new ContactSimpleDAOJPASpring();
	}

	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>le nom de la méthode (ici entityManagerFactory()) 
	 * est le nom du Bean injecté dans le contexte SPRING. 
	 * Donc si la méthode s'appelait "toto()", 
	 * le bean s'appellerait "toto" dans le contexte.</li>
	 * </ul>
	 *
	 * @return : LocalContainerEntityManagerFactoryBean : .<br/>
	 * 
	 * @throws Exception 
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() 
															throws Exception {
		
		final LocalContainerEntityManagerFactoryBean entityManagerFactory 
			= new LocalContainerEntityManagerFactoryBean();

//		entityManagerFactory.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");
//		entityManagerFactory.setPersistenceXmlLocation("D:\\Donnees\\eclipse\\eclipseworkspace\\adresses_javafx\\src\\test\\resources\\META-INF\\persistence-test.xml");
		entityManagerFactory.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");
//		entityManagerFactory.setPersistenceUnitName("persistence_unit_base-adresses_javafx");
		
//		entityManagerFactory.setPersistenceUnitName("persistence_unit_base-adresses_javafx");

//	      final JpaVendorAdapter vendorAdapter 
//	      	= new HibernateJpaVendorAdapter();
//	      
//	      entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
//
//	      entityManagerFactory.setDataSource(this.dataSource());
//	      
//	      entityManagerFactory.setPackagesToScan(
//	    		  new String[] {"levy.daniel.application.model"});
//	 
//
//	      entityManagerFactory.setJpaProperties(additionalProperties());

//		EntityManagerFactory entityManagerFactoryJPA = entityManagerFactory.;
//		
//		System.out.println("*****************************************");
//		System.out.println(afficherPrincipalesProperties(entityManagerFactoryJPA));
		
		
		return entityManagerFactory;
	}

	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @return : DataSource : .<br/>
	 */
	@Bean
	public DataSource dataSource() {

		final DriverManagerDataSource dataSource 
			= new DriverManagerDataSource();

		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:base-adresses_javafx");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		return dataSource;
	}

	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @param pEntityManagerFactory
	 * @return : PlatformTransactionManager : .<br/>
	 */
	@Bean
	public PlatformTransactionManager transactionManager(
			final EntityManagerFactory pEntityManagerFactory) {

		final JpaTransactionManager transactionManager 
			= new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(pEntityManagerFactory);

		return transactionManager;
	}

	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @return : PersistenceExceptionTranslationPostProcessor : .<br/>
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @return : Properties : .<br/>
	 */
	public Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		return properties;
	}
	
	

} // FIN DE LA CLASSE ConfigurationSpringFrameworkAnnotation.----------------
