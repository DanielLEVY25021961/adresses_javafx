package levy.daniel.application.model.utilitaires.spring.configurateurspring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;

import levy.daniel.application.model.persistence.metier.contactsimple.IContactSimpleDAO;
import levy.daniel.application.model.persistence.metier.contactsimple.dao.jpaspring.impl.ContactSimpleDAOJPASpring;

/**
 * CLASSE ConfigurateurSpringFrmkAnnotationJPAH2Memory :<br/>
 *  Classe <b>annotée Configuration</b> chargée de configurer 
 * le Contexte SPRING FRAMEWORK.<br/>
 * <ul>
 * <li>instancie les Beans (Controllers, Services, DAOs, ...).</li>
 * <li>délègue la configuration de la persistence 
 * à une classe de configuration dédiée via le mécanisme d'import.</li>
 * <li><b>PERSISTENCE : Base H2 en MODE MEMORY</b>.</li>
 * </ul>
 * <ul>
 * <li>appelée par <code>ApplicationContext contexteSpring 
 * = new AnnotationConfigApplicationContext(
 * ConfigurateurSpringFrmkAnnotationJPAH2Memory.class);</code></li>
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
//@Configuration(value="ConfigurateurSpringFrmkAnnotationJPAH2Memory")
//@Import({levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring.ConfigurateurJPAH2Memory.class})
//@EnableAspectJAutoProxy
//@EnableTransactionManagement
//@ComponentScans({@ComponentScan("levy.daniel.application")})
public class ConfigurateurSpringFrmkAnnotationJPAH2Memory {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ConfigurateurSpringFrmkAnnotationJPAH2Memory.class);

	// *************************METHODES************************************/
	

	/**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public ConfigurateurSpringFrmkAnnotationJPAH2Memory() {
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

		
	
} // FIN DE LA CLASSE ConfigurateurSpringFrmkAnnotationJPAH2Memory.-----------
