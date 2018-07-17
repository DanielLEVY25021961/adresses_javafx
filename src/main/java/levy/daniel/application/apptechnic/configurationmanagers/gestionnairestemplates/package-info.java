/**
 * CLASSE package-info :<br/>
 * Les templates sont des bouts de code "tout faits" 
 * comportant des variables.<br/>
 * L'objectif est d'injecter ces bouts de code "tout faits" 
 * avec leurs variables substituées dans le code que l'on développe.<br/>
 * <br/>
 * Les templates sont stockés sous forme de fichiers .txt 
 * dans les ressources internes (sous le classpath) de l'application.<br/>
 * <br/><br/>
 * <img src="../../../../../../../../../javadoc/images/gestion_templates.png" 
 * alt="Gestion des templates" border="1" align="center" />
 * <br/><br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code><i>// chemin relatif du template par rapport aux ressources 
 * internes src/main/resources.</i></code><br/>
 * <code>final String cheminRelatifTemplate 
 * = "commentaires_properties/commentaires_labels_properties.txt"
 * ;</code><br/>
 * <code><i>// variable à substituer dans le template.</i></code><br/>
 * <code>final String variable = "{$Locale}";</code><br/>
 * <code><i>// valeur de substitution.</i></code><br/>
 * <code>final String substituant = localeCouranteFR.toString();
 * </code><br/>
 * <br/>	
 * <code><i>// Obtention du template substitué sous forme de String 
 * dans le code java auprès du Gestionaire de Templates.</i></code><br/>
 * <code>final String commentaire = 
 * gestionnaireTemplate.fournirTemplateSubstitueSousFormeString(
 * cheminRelatifTemplate, variable, substituant);</code><br/>
 * <br/>		
 * <code><i>// injection du template substitué dans le 
 * code java.</i></code><br/>
 * <code>gestionnairePropertiesCompletFR.
 * remplirEnDurFichierProperties(commentaire);</code><br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * template, Template, liste de lignes à partir d'un fichier txt, <br/>
 * lire un fichier .txt, lire un fichier txt,<br/>
 * liste lignes à partir d'un fichier .txt, ListeLignes txt, <br/>
 * lire un template txt, lire un template .txt, obtenir liste lignes,<br/>
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
package levy.daniel.application.apptechnic.configurationmanagers.gestionnairestemplates;
