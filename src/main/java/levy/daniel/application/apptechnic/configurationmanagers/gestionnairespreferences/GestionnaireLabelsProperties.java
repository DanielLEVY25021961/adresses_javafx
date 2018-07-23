package levy.daniel.application.apptechnic.configurationmanagers.gestionnairespreferences;

import java.io.File;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * CLASSE GestionnaireLabelsProperties :<br/>
 * 
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Preferences, preferencces, properties, Properties,<br/>
 * sauver Properties, br/>
 * fichier properties, fichier Properties, <br/>
 * créer fichier sur disque dur, HDD, créer arborescence sur disque dur,<br/>
 * enregistrer Properties dans fichier .properties,<br/>
 * lire fichier .properties, <br/>
 * fournir nom properties, reconstituer nom properties Locale,<br/>
 * fournirNomFichierProperties(Locale pLocale), <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 14 juil. 2018
 *
 */
public class GestionnaireLabelsProperties {
	


	private static Properties properties;
	
	/**
	 * <b>nom de base du fichier .properties externe</b> paramétrable 
	 * situé dans le répertoire <i>hors classpath</i> 
	 * ("ressources_externes" par exemple) 
	 * indiqué par le centre-serveur dans 
	 * "configuration_ressources_externes.properties".<br/>
	 * "labels"<br/>
	 */
	private static String nomBaseFichierProperties = "labels";
	
	private static Path pathAbsoluFichierProperties;
	
	private static File fichierProperties;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(GestionnaireLabelsProperties.class);
	
	// *************************METHODES************************************/
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pLocale :  :  .<br/>
	 */
	public static void creerFichierProperties(Locale pLocale) {
		
		/**/
		
	}
	

	
} // FIN DE LA CLASSE GestionnaireLabelsProperties.--------------------------
