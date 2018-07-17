package levy.daniel.application.apptechnic.configurationmanagers.gestionnairestemplates;

import java.util.List;

/**
 * INTERFACE IGestionnaireTemplates :<br/>
 * Interface factorisant les comportements des GestionnaireTemplates.<br/>
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
 * @since 15 juil. 2018
 *
 */
public interface IGestionnaireTemplates {

	/**
	 * <b>Lit un template situé à 
	 * <code>cheminAbsoluMainResources/pCheminRelatifTemplate</code> 
	 * et retourne une String représentant la 
	 * liste de lignes substituées</b>.<br/>
	 * <b>Substitue la variable pVariable dans chaque ligne</b>.
	 * <ul>
	 * <li>lit le fichier template avec le Charset UTF8.</li>
	 * <li><b>Substitue</b> <i>pSubstituant</i> à la 
	 * variable <i>pVariable</i> 
	 * dans chaque ligne de pListe.</li>
	 * <li>Par exemple : <br/>
	 * Substitue "levy.daniel.application.model.metier" 
	 * à {$pathmetier} dans chaque ligne.</li>
	 * </ul>
	 * - retourne null si pCheminRelatifTemplate est blank.<br/>
	 * <br/>
	 *
	 * @param pCheminRelatifTemplate : String : 
	 * chemin relatif du template à lire par rapport à 
	 * cheminAbsoluMainResources (src/main/resources).<br/>
	 * @param pVariable : String : variable à substituer
	 * @param pSubstituant : String : valeur à substituer à variable.<br/>
	 * 
	 * @return : String : template sous forme d'une unique String.<br/>
	 * 
	 * @throws Exception 
	 */
	String fournirTemplateSubstitueSousFormeString(
			String pCheminRelatifTemplate, String pVariable, String pSubstituant)
					throws Exception;



	/**
	 * <b>Lit un template situé à 
	 * <code>cheminAbsoluMainResources/pCheminRelatifTemplate</code> 
	 * et retourne une liste de lignes substituées</b>.<br/>
	 * <b>Substitue la variable pVariable dans chaque ligne</b>.
	 * <ul>
	 * <li>lit le fichier template avec le Charset UTF8.</li>
	 * <li><b>Substitue</b> <i>pSubstituant</i> à la 
	 * variable <i>pVariable</i> 
	 * dans chaque ligne de pListe.</li>
	 * <li>Par exemple : <br/>
	 * Substitue "levy.daniel.application.model.metier" 
	 * à {$pathmetier} dans chaque ligne.</li>
	 * </ul>
	 * - retourne null si pCheminRelatifTemplate est blank.<br/>
	 * <br/>
	 *
	 * @param pCheminRelatifTemplate : String : 
	 * chemin relatif du template à lire par rapport à 
	 * cheminAbsoluMainResources (src/main/resources).<br/>
	 * @param pVariable : String : variable à substituer
	 * @param pSubstituant : String : valeur à substituer à variable.<br/>
	 * 
	 * @return : List&lt;String&gt; : 
	 * Template sous forme de liste de lignes 
	 * avec la variable substituée.<br/>
	 * 
	 * @throws Exception
	 */
	List<String> fournirTemplateSubstitueSousFormeListe(
			String pCheminRelatifTemplate, String pVariable, String pSubstituant) 
					throws Exception;
	
	
	
} // FIN DE L'INTERFACE IGestionnaireTemplates.------------------------------
