package levy.daniel.application.apptechnic.configurationmanagers.gestionnairespreferences;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.ConfigurationApplicationManager;


/**
 * CLASSE <b>GestionnairePreferences</b> :<br/>
 * Classe Utilitaire chargée de gérer les 
 * <b>préférences de l'application</b>.<br/>
 * <br/>
 * Les préférences de l'application sont des données très générales 
 * qu'un <b>administrateur doit pouvoir paramétrer</b>. Par exemple :
 * <ul>
 * <li>La langue par défaut de l'application (Locale par défaut)</li>
 * <li>L'encodage par défaut de l'application (Charset par défaut)</li>
 * <li>...</li>
 * </ul>
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
 * @since 24 juil. 2018
 *
 */
public final class GestionnairePreferences {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * EGAL : char :<br/>
	 * '='.<br/>
	 */
	public static final char EGAL = '=';
	
	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';

	/**
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");
	
	/**
	 * clé du charset de l'application dans le properties
	 * "application.charset".<br/>
	 */
	public static final String KEY_CHARSET_APPLICATION 
		= "application.charset";
	
	/**
	 * CHARSET_STRING_PAR_DEFAUT_EN_DUR : String :<br/>
	 * Charset par défaut de l'application en dur.<br/>
	 * N'est utilisé que si l'application ne peut lire le Charset 
	 * indiqué dans preferences.properties.<br/>
	 * "UTF-8".<br/>
	 */
	public static final String CHARSET_STRING_PAR_DEFAUT_EN_DUR 
		= CHARSET_UTF8.name();
	

	/**
	 * preferences : Properties :<br/>
	 * Properties encapsulant les préférences.<br/>
	 */
	private static Properties preferences = new Properties();
	
	/**
	 * pathAbsoluPreferencesProperties : Path :<br/>
	 * Path absolu vers preferences.properties.<br/>
	 */
	private static Path pathAbsoluPreferencesProperties;
	
	/**
	 * filePreferencesProperties : File :<br/>
	 * fichier preferences.properties.<br/>
	 */
	private static File filePreferencesProperties;
		
	/**
	 * <b>SINGLETON de Charset couramment sélectionné 
	 * dans l'application</b>.<br/>
	 */
	private static Charset charsetApplication;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(GestionnairePreferences.class);
	
	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * private pour bloquer l'instanciation<br/>
	 */
	private GestionnairePreferences() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * <b>sauvegarde sur disque un fichier 
	 * preferences.properties initial</b> alimenté par des propriétés.<br/>
	 * <ul>
	 * <li>remplit le fichier preferences.properties 
	 * avec des Properties stockées en dur dans la classe.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	private static void creerFichierPropertiesInitial() 
											throws Exception {
		
		synchronized (GestionnairePreferences.class) {
			
			/* Ajoute les propriétés initiales à preferences. */
			ajouterPropertiesEnDur();
			
			/* initialise les fichiers preferences. */
			instancierAttributsFichierProperties();
			
			/* ECRITURE SUR DISQUE. */
			/* try-with-resource qui se charge du close(). */
			try (Writer writer = Files.newBufferedWriter(
					pathAbsoluPreferencesProperties, CHARSET_UTF8)) {
				
				/* enregistre le Properties preferences sur disque dur 
				 * dans le fichier .properties correspondant. */
				preferences.store(writer, null);
				
			}
			
		} // Fin du bloc synchronized.__________________
		
	} // Fin de creerFichierPropertiesInitial().___________________________

	

	/**
	 * <b>Ajoute des propriétés initiales stockées en dur</b> 
	 * dans la classe au Properties <b>preferences</b>.<br/>
	 */
	private static void ajouterPropertiesEnDur() {
		
		synchronized (GestionnairePreferences.class) {
			
			preferences.setProperty(
					KEY_CHARSET_APPLICATION
						, CHARSET_STRING_PAR_DEFAUT_EN_DUR);
			
		} // Fin du bloc synchronized.__________________
		
	} // Fin de ajouterProperties()._______________________________________
	

	
	/**
	 * <b>Instancie tous les attributs</b> relatifs 
	 * au fichier de preferences <b>si ils sont null</b>.<br/>
	 * <b>Crée le fichier properties vide</b> (et son arborescence) 
	 * sur HDD <b>si il n'existe pas déjà</b>.<br/>
	 * <b>obtient le path du preferences.properties</b> 
	 * dans les ressources externes auprès du 
	 * <b>ConfigurationApplicationManager</b>.<br/>
	 * <ul>
	 * <li>instancie pathAbsoluPreferencesProperties.</li>
	 * <li>instancie filePreferencesProperties.</li>
	 * <li>Crée sur le disque dur l'arborescence et le fichier 
	 * filePreferencesProperties si nécessaire.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	private static void instancierAttributsFichierProperties() 
			throws Exception {
		
		synchronized (GestionnairePreferences.class) {
			
			/* obtient le path du properties dans les 
			 * ressources externes auprès du 
			 * ConfigurationApplicationManager. */
			final Path pathRessourcesExternes 
			= Paths.get(ConfigurationApplicationManager
					.getPathRessourcesExternes());
		
			if (pathAbsoluPreferencesProperties == null) {
				pathAbsoluPreferencesProperties 
				= pathRessourcesExternes
					.resolve("preferences/preferences.properties");
			}
			
			if (filePreferencesProperties == null) {
				filePreferencesProperties 
				= pathAbsoluPreferencesProperties.toFile();
				
				if (!filePreferencesProperties.exists()) {
					creerRepertoiresArbo(filePreferencesProperties);
					Files.createFile(pathAbsoluPreferencesProperties);
				}				
			}
			
		} // Fin du bloc synchronized.__________________
		
	} // Fin de instancierAttributsFichierProperties().____________________
	

	
	/**
	 * Crée sur disque dur l'arborescence des répertoires 
	 * parent de pFile si elle n'existe pas déjà.<br/>
	 * <ul>
	 * <li><code>Files.createDirectories(pathParent);</code></li>
	 * </ul>
	 * - ne fait rien si pFile == null.<br/>
	 * - ne fait rien si pFile est une racine (pas de parent).<br/>
	 * </br/>
	 *
	 * @param pFile : File : 
	 * fichier dont on veut créer l'arborescence sur disque dur.<br/>
	 * 
	 * @throws IOException
	 */
	private static void creerRepertoiresArbo(
			final File pFile) throws IOException {
		
		synchronized (GestionnairePreferences.class) {
			
			/* ne fait rien si pFile == null. */
			if (pFile == null) {
				return;
			}
			
			final Path pathFile = pFile.toPath();
			final Path pathParent = pathFile.getParent();
			
			/* ne fait rien si pFile est une racine (pas de parent). */
			if (pathParent != null) {
				Files.createDirectories(pathParent);
			}

		} // Fin du bloc synchronized.__________________
						
	} // Fin de creerRepertoiresArbo(...)._________________________________
	
	
	
	/**
	 * <b>lit le fichier 
	 * ressources_externes/preferences/preferences.properties</b> 
	 * et alimente le <i>Properties</i> <b>preferences</b> 
	 * en le décodant en UTF8.<br/>
	 * <ul>
	 * <li>initialise les attributs relatifs 
	 * aux fichiers preferences.</li>
	 * <li>décode le fichier .properties en UTF8 et le charge 
	 * dans le Properties preferences.</li>
	 * <li><code>preferences.load(inputStream);</code></li>
	 * </ul>
	 * @throws Exception 
	 */
	private static void lireFichierPreferencesProperties() 
												throws Exception {

		synchronized (GestionnairePreferences.class) {
			
			/* initialise les attributs relatifs aux fichiers preferences. */
			instancierAttributsFichierProperties();
					
			/* try-with-resource qui se charge du close(). */
			try (Reader reader = Files.newBufferedReader(
					pathAbsoluPreferencesProperties, CHARSET_UTF8)) {
				
				/* décode le fichier .properties en UTF8 
				 * et le charge dans le Properties preferences. */
				preferences.load(reader);
		
			}

		} // Fin du bloc synchronized.__________________
				
	} // Fin de lireFichierPreferences().__________________________________


	
	/**
	 * <b>Enregistre en UTF8</b> le <i>Properties</i> preferences dans 
	 * le <i>fichier</i> <b>ressources_externes/preferences/
	 * preferences.properties</b>.<br/>
	 * <ul>
	 * <li>initialise le <i>Properties</i> <b>preferences</b> 
	 * et remplit le <i>fichier</i> .properties si nécessaire.</li>
	 * <li>enregistre le <i>Properties</i> <b>preferences</b> 
	 * sur disque dur dans le <i>fichier</i> 
	 * .properties correspondant.</li>
	 * <li>Prise en compte (stockage) 
	 * d'une modification d'une Property.</li>
	 * <li><code>preferences.store(writer, null);</code></li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	private static void enregistrerFichierPreferencesProperties() 
			throws Exception {
		
		synchronized (GestionnairePreferences.class) {
			
			/* crée le Properties preferences et 
			 * le remplit avec des valeurs en dur si nécessaire. */
			if (filePreferencesProperties == null 
					|| !filePreferencesProperties.exists()) {
				creerFichierPropertiesInitial();
			}
			
			/* initialise les fichiers preferences si nécessaire. */
			instancierAttributsFichierProperties();
			
			/* try-with-resource qui se charge du close(). */
			try (Writer writer = Files.newBufferedWriter(
					pathAbsoluPreferencesProperties, CHARSET_UTF8)) {
				
				/* enregistre le Properties preferences sur disque dur 
				 * dans le fichier .properties correspondant. */
				preferences.store(writer, null);
				
			}

		} // Fin du bloc synchronized.__________________
		
	} // Fin de enregistrerFichierPreferences().___________________________
	

	
	/**
	 * <b>Crée ou met à jour une Property</b> dans 
	 * le <i>Properties</i> <b>preferences</b>.<br/>
	 * <ul>
	 * <li>initialise le <i>Properties</i> <b>preferences</b> 
	 * et remplit le <i>fichier</i> .properties si nécessaire.</li>
	 * <li>Crée ou maj dans l'objet Properties <b>preferences</b> 
	 * <i>sans enregistrer la modification sur le disque dur</i>.</li>
	 * <li>preferences.setProperty(pKey, pValue);</li>
	 * </ul>
	 * - retourne false si pKey == null.<br/>
	 * - retourne false si pValue == null.<br/>
	 * <br/>
	 *
	 * @param pKey : String : Clé.<br/>
	 * @param pValue : String : Valeur.<br/>
	 * 
	 * @return : boolean : true si la property a été créée.<br/>
	 * 
	 * @throws Exception 
	 */
	public static boolean creerOuModifierProperty(
			final String pKey
				, final String pValue) throws Exception {
		
		synchronized (GestionnairePreferences.class) {
			
			/* crée le Properties preferences et 
			 * le remplit avec des valeurs en dur si nécessaire. */
			if (filePreferencesProperties == null 
					|| !filePreferencesProperties.exists()) {
				creerFichierPropertiesInitial();
			}
			
			/* retourne false si pKey == null. */
			if (pKey == null) {
				return false;
			}
			
			/* retourne false si pValue == null. */
			if (pValue == null) {
				return false;
			}
			
			/* crée ou met à jour la Property dans preferences. */
			preferences.setProperty(pKey, pValue);
			
			return true;
			
		} // Fin du bloc synchronized.__________________
				
	} // Fin de creerOuModifierProperty(...).______________________________

	
	
	/**
	 * <b>Retire une Property</b> dans 
	 * le <i>Properties</i> <b>preferences</b>.<br/>
	 * <ul>
	 * <li>initialise le <i>Properties</i> <b>preferences</b> 
	 * et remplit le <i>fichier</i> .properties si nécessaire.</li>
	 * <li>retire dans l'objet Properties <b>preferences</b> 
	 * <i>sans enregistrer la modification sur le disque dur 
	 * (.properties)</i>.</li>
	 * <li><code>preferences.remove(pKey);</code>.</li>
	 * </ul>
	 * - retourne false si pKey == null.<br/>
	 * <br/>
	 *
	 * @param pKey : String : Clé.<br/>
	 * 
	 * @return : boolean : true si la property a été retirée.<br/>
	 * 
	 * @throws Exception 
	 */
	public static boolean retirerProperty(
			final String pKey) 
					throws Exception {
		
		synchronized (GestionnairePreferences.class) {
			
			/* crée le Properties preferences et 
			 * le remplit avec des valeurs en dur si nécessaire. */
			if (filePreferencesProperties == null 
					|| !filePreferencesProperties.exists()) {
				creerFichierPropertiesInitial();
			}
			
			/* retourne false si pKey == null. */
			if (pKey == null) {
				return false;
			}
			
			/* retire la Property de preferences. */
			preferences.remove(pKey);
			
			return true;
			
		} // Fin du bloc synchronized.__________________
				
	} // Fin de retirerProperty(...).______________________________________
	

	
	/**
	 * vide le <i>Properties</i> <b>preferences</b>.<br/>
	 * <ul>
	 * <li>initialise le <i>Properties</i> <b>preferences</b> 
	 * et remplit le <i>fichier</i> .properties si nécessaire.</li>
	 * <li>vide l'objet <i>Properties</i> <b>preferences</b> 
	 * sans vider le <i>fichier</i> .properties correspondant 
	 * sur le disque dur.</li>
	 * <li><code>preferences.remove(cle);</code>.</li>
	 * </ul>
	 * - retourne false si l'ensemble des clés du 
	 * Properties preferences est null.<br/>
	 * <br/>
	 *
	 * @return : boolean : true si preferences a été vidée.<br/>
	 * 
	 * @throws Exception 
	 */
	public static boolean viderPreferences() throws Exception {
		
		synchronized (GestionnairePreferences.class) {
			
			/* crée le Properties preferences et 
			 * le remplit avec des valeurs en dur si nécessaire. */
			if (filePreferencesProperties == null 
					|| !filePreferencesProperties.exists()) {
				creerFichierPropertiesInitial();
			}
				
			final Set<String> clesSet 
				= preferences.stringPropertyNames();
			
			/* retourne false si l'ensemble des clés 
			 * du Properties preferences est null. */
			if (clesSet == null) {
				return false;
			}
			
			/* vidage du Properties preferences. */
			for (final String cle : clesSet) {
				preferences.remove(cle);
			}
			
			return true;
			
		} // Fin du bloc synchronized.__________________
		
	} // Fin de viderPreferences().________________________________________
	
	
	
	/**
	 * retourne le Charset par défaut de l'application.<br/>
	 * <ul>
	 * <li>lit le charset stocké dans preferences.properties 
	 * si il n'est pas null.</li>
	 * <li>UTF-8 sinon (Charset stocké en dur dans a classe).</li>
	 * </ul>
	 *
	 * @return : Charset.<br/>
	 * 
	 * @throws Exception 
	 */
	private static Charset fournirCharsetSortieParDefaut() 
			throws Exception {
		
		synchronized (GestionnairePreferences.class) {
			
			if (preferences.isEmpty()) {
				creerFichierPropertiesInitial();
			}
			
			if (charsetApplication == null) {
				
				/* lecture dans le properties. */
				final String charsetApplicationString 
					= preferences
						.getProperty(
								fournirKeyCharsetApplication());
				
				if (charsetApplicationString != null) {
					try {
						charsetApplication 
						= Charset.forName(charsetApplicationString);
					} catch (Exception e) {
						charsetApplication 
						= Charset.forName(CHARSET_STRING_PAR_DEFAUT_EN_DUR);
					}
					
				}
				else {
					charsetApplication 
						= Charset.forName(CHARSET_STRING_PAR_DEFAUT_EN_DUR);
				}
			}
			
			return charsetApplication;
			
		} // Fin du bloc synchronized.__________________
		
	} // Fin de fournirCharsetSortieParDefaut().___________________________
	

	
	/**
	 * Getter de la clé du charset de l'application 
	 * dans le properties.<br/>
	 * "application.charset".<br/>
	 *
	 * @return KEY_CHARSET_APPLICATION : String.<br/>
	 */
	public static String fournirKeyCharsetApplication() {
		return KEY_CHARSET_APPLICATION;
	} // Fin de fournirKeyCharsetApplication().____________________________



	/**
	 * Getter du <b>SINGLETON de Charset couramment sélectionné 
	 * dans l'application</b>.
	 * <br/>
	 *
	 * @return charsetApplication : Charset.<br/>
	 * 
	 * @throws Exception 
	 */
	public static Charset getCharsetApplication() throws Exception {
		return fournirCharsetSortieParDefaut();
	} // Fin de getCharsetApplication().___________________________________
	

	
	/**
	* Setter du <b>SINGLETON de Charset couramment sélectionné 
	* dans l'application</b>.<br/>
	* <b>Enregistre la valeur sur disque</b>.<br/>
	* <br/>
	* - ne fait rien si pCharsetApplication == null.<br/>
	* <br/>
	*
	* @param pCharsetApplication : Charset : 
	* valeur à passer à charsetApplication.<br/>
	* 
	 * @throws Exception 
	*/
	public static void setCharsetApplication(
			final Charset pCharsetApplication) throws Exception {
		
		synchronized (GestionnairePreferences.class) {
			
			/* ne fait rien si pCharsetApplication == null. */
			if (pCharsetApplication != null) {
				
				charsetApplication = pCharsetApplication;
				
				final String nomCharset 
					= pCharsetApplication.displayName();
				
				if (preferences.isEmpty()) {
					creerFichierPropertiesInitial();
				}
				
				creerOuModifierProperty(
						fournirKeyCharsetApplication(), nomCharset);
				
				enregistrerFichierPreferencesProperties();

			}

		} // Fin du bloc synchronized.__________________
						

	} // Fin de setCharsetApplication(...).________________________________
	
		
	
} // FIN DE LA CLASSE GestionnairePreferences.-------------------------------
