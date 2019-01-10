package levy.daniel.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import levy.daniel.application.model.persistence.metier.contactsimple.dao.jpaspring.impl.ContactSimpleDAOJPASpring;

/**
 * CLASSE ConfigurationSpringFrameworkAnnotation :<br/>
 * <ul>
 * <li>l'annotation <b>Configuration</b> 
 * (org.springframework.context.annotation.Configuration) 
 * précise qu'il s'agit d'une classe de CONFIGURATION SPRING.</li>
 * <li>l'annotation <b>ComponentScan</b> 
 * (org.springframework.context.annotation.ComponentScan) 
 * permet de préciser un tableau de PACKAGES (sous forme de String) à scanner.</li>
 * </ul>
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
 * @since 10 janv. 2019
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"levy.daniel.application"})
public class ConfigurationSpringFrameworkAnnotation {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
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
	 * @return : ContactSimpleDAOJPASpring :  .<br/>
	 */
	@Bean
	public ContactSimpleDAOJPASpring contactSimpleDAOJPASpring() {
		return new ContactSimpleDAOJPASpring();
	}
	
} // FIN DE LA CLASSE ConfigurationSpringFrameworkAnnotation.----------------
