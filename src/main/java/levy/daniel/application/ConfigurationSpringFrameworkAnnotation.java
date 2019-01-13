package levy.daniel.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import levy.daniel.application.model.persistence.metier.contactsimple.IContactSimpleDAO;
import levy.daniel.application.model.persistence.metier.contactsimple.dao.jpaspring.impl.ContactSimpleDAOJPASpring;

/**
 * CLASSE ConfigurationSpringFrameworkAnnotation :<br/>
 * Classe <b>annotée Configuration</b> chargée de configurer 
 * le Contexte SPRING FRAMEWORK.<br/>
 * <ul>
 * <li>appelée par <code>ApplicationContext contexteSpring 
 * = new AnnotationConfigApplicationContext(
 * ConfigurationSpringFrameworkAnnotation.class);</code></li>
 * <li>l'annotation <b>Configuration</b>
 * (org.springframework.context.annotation.Configuration) précise qu'il s'agit
 * d'une classe de CONFIGURATION SPRING.</li>
 * <li>l'annotation <b>Import</b>
 * (org.springframework.context.annotation.Import) permet de séparer
 * la configuration entre plusieurs classes de Config.</li>
 * <li>l'annotation <b>EnableAspectJAutoProxy</b>
 * (org.springframework.context.annotation.EnableAspectJAutoProxy) 
 * permet .</li>
 * <li>l'annotation <b>EnableTransactionManagement</b>
 * (org.springframework.transaction.annotation.EnableTransactionManagement) 
 * permet d'imposer à SPRING de gérer les transactions.</li>
 * <li>l'annotation <b>ComponentScan</b>
 * (org.springframework.context.annotation.ComponentScan) permet de préciser un
 * tableau de PACKAGES (sous forme de String) à scanner dans lequel SPRING 
 * doit découvrir les classes annotées.</li>
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
//@Configuration(value="ConfigurationSpringFrameworkAnnotation")
//@Import({levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring.ConfigurateurJPAH2Memory.class})
//@EnableAspectJAutoProxy
//@EnableTransactionManagement
//@ComponentScans({@ComponentScan("levy.daniel.application")})
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
	 * <b>configure un bean pour le DAO ContactSimpleDAOJPASpring 
	 * et l'injecte dans le contexte SPRING</b>.<br/>
	 * <ul>
	 * <li>nomme le bean "ContactSimpleDAOJPASpring" 
	 * (au lieu de "contactSimpleDAOJPASpring" provenant 
	 * du nom de la méthode) dans le contexte SPRING
	 * grâce au paramètre value.</li>
	 * <li>le nom choisi correspond au nom donné au DAO 
	 * (via l'annotation Repository).
	 *  Ce nom pourra être utilisé comme Qualifier 
	 *  lors de l'injection du DAO</li>
	 * </ul>
	 *
	 * @return : ContactSimpleDAOJPASpring : IContactSimpleDAO.<br/>
	 */
	@Bean(value = "ContactSimpleDAOJPASpring")
	public IContactSimpleDAO contactSimpleDAOJPASpring() {
		return new ContactSimpleDAOJPASpring();
	} // Fin de contactSimpleDAOJPASpring()._______________________________

	
	
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
//	@Bean
//	public DataSource dataSource() {
//
//		final DriverManagerDataSource dataSource 
//			= new DriverManagerDataSource();
//
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setUrl("jdbc:h2:mem:base-adresses_javafx");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("sa");
//
//		return dataSource;
//	}

	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @param pEntityManagerFactory
	 * @return : PlatformTransactionManager : .<br/>
	 */
//	@Bean
//	public PlatformTransactionManager transactionManager(
//			final EntityManagerFactory pEntityManagerFactory) {
//
//		final JpaTransactionManager transactionManager 
//			= new JpaTransactionManager();
//
//		transactionManager.setEntityManagerFactory(pEntityManagerFactory);
//
//		return transactionManager;
//	}

	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @return : PersistenceExceptionTranslationPostProcessor : .<br/>
	 */
//	@Bean
//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}

	
	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @return : Properties : .<br/>
	 */
//	public Properties additionalProperties() {
//		Properties properties = new Properties();
//		properties.setProperty("hibernate.hbm2ddl.auto", "create");
//		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//		return properties;
//	}
	
	

} // FIN DE LA CLASSE ConfigurationSpringFrameworkAnnotation.----------------
