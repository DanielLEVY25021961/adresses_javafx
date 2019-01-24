package levy.daniel.application.model.utilitaires.normalizeururlbase;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE NormalizerUrlBase :<br/>
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
 * @since 24 janv. 2019
 *
 */
public final class NormalizerUrlBase {

	// ************************ATTRIBUTS************************************/

	/**
	 * motif pour déterminer si une URL correspond au mode FILE.<br/>
	 * "^jdbc:(.+):file:".
	 */
	public static final String MOTIF_REGEX_PREFIX_FILE 
		= "^jdbc:(.+):file:";
	
	/**
	 * motif pour déterminer si une URL correspond au mode SERVEUR.<br/>
	 * "^jdbc:(.+)://".
	 */
	public static final String MOTIF_REGEX_PREFIX_SERVEUR 
		= "^jdbc:(.+)://";

	/**
	 * motif pour déterminer si une URL correspond au mode MEMOIRE.<br/>
	 * "^jdbc:(.+):mem:".
	 */
	public static final String MOTIF_REGEX_PREFIX_MEMOIRE 
		= "^jdbc:(.+):mem:";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(NormalizerUrlBase.class);

	// *************************METHODES************************************/

	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	private NormalizerUrlBase() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * <b>crée et retourne une UrlEncapsulation contenant 
	 * tous les renseignements concernant l'URL de connexion 
	 * à la base pBase en mode FILE</b>.<br/>
	 * <ul>
	 * <li>utilise une expression régulière (Regex) 
	 * pour extraire les données de pUrl.</li>
	 * <li>retourne null si pUrl ne matche pas 
	 * avec une URL en mode FILE.</li>
	 * </ul>
	 * - retourne null si pUrl est blank.<br/>
	 * - retourne null si pBase est blank.<br/>
	 * <br/>
	 *
	 * @param pUrl : String : 
	 * URL fournie pour une connexion à une BD en mode FILE.
	 * @param pBase : String : 
	 * nom de la Base de Données à laquelle se connecter.
	 * 
	 * @return : UrlEncapsulation.<br/>
	 */
	public static UrlEncapsulation creerUrlEncapsulationModeFile(
			final String pUrl, final String pBase) {
		
		synchronized (NormalizerUrlBase.class) {
			
			/* retourne null si pUrl est blank. */
			if (StringUtils.isBlank(pUrl)) {
				return null;
			}
			
			/* retourne null si pBase est blank. */
			if (StringUtils.isBlank(pBase)) {
				return null;
			}
			
			final String motifRegexFile 
				= "^(jdbc:(.+):file:)(((\\.{0,1})(.+" + pBase + "))(.*))$";
			
			final Pattern patternFile = Pattern.compile(motifRegexFile);
			
			final Matcher matcherFile = patternFile.matcher(pUrl);
			
			if (matcherFile.matches()) {
				
				final String urlFournie = matcherFile.group(0);
				final String prefixeUrl = matcherFile.group(1);
				final String marqueBd = matcherFile.group(2);
				final String finUrlFournie = matcherFile.group(3);
				
				boolean cheminRelatif = false;
				String cheminRelatifUrl = null;
				String cheminNormaliseUrl = matcherFile.group(6);
				
				if (!StringUtils.isBlank(matcherFile.group(5))) {
					cheminRelatif = true;
					cheminRelatifUrl = matcherFile.group(4);
					cheminNormaliseUrl 
						= absolutiserCheminDansUrlFile(cheminRelatifUrl);
				}
				
				final String commandesSupplementaires 
					= matcherFile.group(7);
				
				final String urlNormalisee 
					= normaliserUrlFile(
							prefixeUrl
								, cheminNormaliseUrl
									, commandesSupplementaires);
				
				final UrlEncapsulation urlEncapsulation 
					= new UrlEncapsulation(
							urlFournie
							, prefixeUrl
							, marqueBd
							, EnumModesBase.FILE
							, finUrlFournie
							, cheminRelatif
							, cheminRelatifUrl
							, cheminNormaliseUrl
							, null
							, null
							, pBase
							, commandesSupplementaires
							, urlNormalisee);
				
				return urlEncapsulation;
				
			} 
			
			return null;
			
		} // Fin de synchronized.________________________________
		
	} // Fin de creerUrlEncapsulationModeFile(...).________________________
	
	
	
	public static UrlEncapsulation creerUrlEncapsulationModeMemoire(
			final String pUrl, final String pBase) {
		
		synchronized (NormalizerUrlBase.class) {
						
			/* retourne null si pUrl est blank. */
			if (StringUtils.isBlank(pUrl)) {
				return null;
			}
			
			/* retourne null si pBase est blank. */
			if (StringUtils.isBlank(pBase)) {
				return null;
			}
			
			final String motifRegexMem 
				= "^(jdbc:(.+):mem:)(" + pBase + ")$";
			
			final Pattern patternMem = Pattern.compile(motifRegexMem);
			
			final Matcher matcherMem = patternMem.matcher(pUrl);
			
			if (matcherMem.matches()) {
				
				final String urlFournie = matcherMem.group(0);
				final String prefixeUrl = matcherMem.group(1);
				final String marqueBd = matcherMem.group(2);
				final String finUrlFournie = matcherMem.group(3);
				
				final boolean cheminRelatif = false;
				final String cheminRelatifUrl = null;
				final String cheminNormaliseUrl = matcherMem.group(3);
								
				final String commandesSupplementaires = null;
				
				final String urlNormalisee 
					= normaliserUrlFile(
							prefixeUrl
								, cheminNormaliseUrl
									, commandesSupplementaires);
				
				final UrlEncapsulation urlEncapsulation 
					= new UrlEncapsulation(
							urlFournie
							, prefixeUrl
							, marqueBd
							, EnumModesBase.MEMOIRE
							, finUrlFournie
							, cheminRelatif
							, cheminRelatifUrl
							, cheminNormaliseUrl
							, null
							, null
							, pBase
							, commandesSupplementaires
							, urlNormalisee);
				
				return urlEncapsulation;
				
			} 
			
			return null;
					
		} // Fin de synchronized.________________________________
			
	} // Fin de creerUrlEncapsulationModeMemoire(...)._____________________

	
	
	/**
	 * <b>détermine et retourne sous forme d'énumération EnumModesBase 
	 * le mode d'utilisation d'une base dans une URL</b>.<br/>
	 * <ul>
	 * <li>utilise une expression régulière (Regex) 
	 * pour déterminer le mode dans le préfixe de l'URL.</li>
	 * </ul>
	 * - retourne null si l'URL ne respecte pas la regex.<br/>
	 * <br/>
	 *
	 * @param pUrl : String : URL d'une base dans un persistence.xml.<br/>
	 * 
	 * @return : EnumModesBase : mode de fonctionnement de la base 
	 * (FILE, SERVEUR ou MEMOIRE).<br/>
	 */
	public static EnumModesBase determinerMode(
			final String pUrl) {
		
		synchronized (NormalizerUrlBase.class) {
			
			final Pattern patternFile 
			= Pattern.compile(MOTIF_REGEX_PREFIX_FILE);
		
			final Pattern patternMem 
				= Pattern.compile(MOTIF_REGEX_PREFIX_MEMOIRE);
			
			final Pattern patternServeur 
				= Pattern.compile(MOTIF_REGEX_PREFIX_SERVEUR);
			
			final Matcher matcherFile = patternFile.matcher(pUrl);
			final Matcher matcherMem = patternMem.matcher(pUrl);
			final Matcher matcherServeur = patternServeur.matcher(pUrl);
			
			if (matcherFile.find()) {
				return EnumModesBase.FILE;
			} else if (matcherMem.find()) {
				return EnumModesBase.MEMOIRE;
			} else if (matcherServeur.find()) {
				return EnumModesBase.SERVEUR;
			} else {
				return null;
			}
			
		} // Fin de synchronized.________________________________
					
	} // Fin de determinerMode(...)._______________________________________
	

	
	/**
	 * <b>transforme un chemin relatif en chemin absolu normalisé</b>.<br/>
	 * Par exemple :
	 * <ul>
	 * <li>./data/base-adresses_javafx-h2/base-adresses_javafx</li>
	 * devient
	 * <li>D:\Donnees\eclipse\eclipseworkspace\adresses_javafx\
	 * data\base-adresses_javafx-h2\base-adresses_javafx</li>
	 * </ul>
	 * - retourne null si pCheminRelatifUrl ne correspond pas à un Path.<br/>
	 * <br/>
	 *
	 * @param pCheminRelatifUrl : String : 
	 * chemin relatif dans une URL.<br/>
	 * 
	 * @return : String : 
	 * chemin absolu en fonction de la plateforme (Windows, Linux, ...).<br/>
	 */
	private static String absolutiserCheminDansUrlFile(
			final String pCheminRelatifUrl) {

		synchronized (NormalizerUrlBase.class) {
			
			final Path cheminAbsoluNormalisePath 
				= Paths.get(pCheminRelatifUrl)
					.toAbsolutePath().normalize();
			
			if (cheminAbsoluNormalisePath != null) {
				return cheminAbsoluNormalisePath.toString();
			}
			
			return null;
		
		} // Fin de synchronized.________________________________
				
	} // Fin de absolutiserCheminDansUrlFile(...)._________________________
	
	
	
	/**
	 * <b>crée une URL normalisée quelle que soit la plateforme 
	 * (Windows, Linux, ...) en agrégeant un 
	 * préfixe, un chemin absolu normalisé et d'éventuelles 
	 * commandes supplémentaires</b>.<br/>
	 * <ul>
	 * <li> Par exemple, agrège l'URL :<br/>
	 * jdbc:h2:file:D:\Donnees\eclipse\eclipseworkspace\adresses_javafx\
	 * data\base-adresses_javafx-h2\base-adresses_javafx;
	 * DB_CLOSE_ON_EXIT=FALSE</li>
	 * </ul>
	 *
	 * @param pPrefixe : String : 
	 * préfixe de l'URL.
	 * @param pCheminNormaliseUrl : 
	 * chemin absolu et normalisé vers la Base de Données.
	 * @param pCommandesSupplementaires : 
	 * commandes supplémentaires pour la BD.
	 * 
	 * @return : String : 
	 * [préfixe + chemin absolu normalisé + commandes].<br/>
	 */
	private static String normaliserUrlFile(
			final String pPrefixe
				, final String pCheminNormaliseUrl
					, final String pCommandesSupplementaires) {
		
		synchronized (NormalizerUrlBase.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			if (pPrefixe != null) {
				stb.append(pPrefixe);
			}
			
			if (pCheminNormaliseUrl != null) {
				stb.append(pCheminNormaliseUrl);
			}
			
			if (pCommandesSupplementaires != null) {
				stb.append(pCommandesSupplementaires);
			}
			
			return stb.toString();
			
		} // Fin de synchronized.________________________________
		
	} // Fin de normaliserUrlFile(...).____________________________________
	
	
	
} // FIN DE LA CLASSE NormalizerUrlBase.-------------------------------------
