/**
 * CLASSE package-info :<br/>
 * Ce package contient toutes les classes nécessaires 
 * à la <b>gestion des préférences de l'application</b> et des 
 * <b>fichiers properties externes paramétrables par la MOA</b> 
 * et gérés comme des préférences.<br/>
 * <br/>
 * Les préférences de l'application sont des données très générales 
 * qu'un <b>administrateur doit pouvoir paramétrer</b>. Par exemple :
 * <ul>
 * <li>La langue par défaut de l'application (Locale par défaut)</li>
 * <li>L'encodage par défaut de l'application (Charset par défaut)</li>
 * <li>...</li>
 * </ul>
 * <p>Plus généralement, les préférences de l'application sont tous 
 * les <b>paramètres</b> que l'administrateur doit ne 
 * <b>saisir qu'une seule fois</b> 
 * et qui doivent rester <b>mémorisés dans l'application</b> tant que 
 * l'Administrateur n'a pas décidé d'en changer.</p>
 * <p>Les préférences doivent être automatiquement 
 * initialisées avec des valeurs d'usine "en dur" au cas où 
 * se produirait un défaut de livraison de leur stockage.</p>
 * 
 * <p><span style="text-decoration: underline;"><b>Rôle du Gestionnaire des préférences</b></span></p>
 * <br/>
 * <img src="../../../../../../../../../javadoc/images/gestionnaire_preferences_role.png" 
 * alt="rôle des préférences" border="1" align="center" />
 * <br/><br/>
 * 
 * <p><span style="text-decoration: underline;"><b>Initialisation des préférences</b></span></p>
 * <div>
 * <p>L'application doit pouvoir pallier à un défaut de livraison ou 
 * d'installation du stockage des préférences (preferences.properties par exemple).</p>
 * <p>L'application doit donc créer son stockage 
 * (preferences.properties par exemple) 
 * avec des valeurs stockées "en dur" si il est manquant.<br/>
 * L'application doit pouvoir servir des valeurs de préférences 
 * "en dur" si la création du stockage échoue pour 
 * des motifs de protection de disque, ...
 * </p>
 * <br/>
 * <img src="../../../../../../../../../javadoc/images/gestionnaire_preferences_activites.png" 
 * alt="cinématique de l'initialisation des préférences" border="1" align="center" />
 * <br/><br/>
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
 * @since 14 juil. 2018
 *
 */
package levy.daniel.application.apptechnic.configurationmanagers.gestionnairespreferences;
