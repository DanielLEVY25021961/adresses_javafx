/**
 * class package-info :<br/>
 * Ce package contient toutes les classes métier CONCRETES, c'est à dire 
 * les <b>Objets métier</b> (aussi appelés <i>Objets du Domaine</i>) 
 * <b>relatifs aux Contacts Simples</b>.
 * 
 * <ul>
 * <li>Ces objets métier ou objets du domaine <i>transitent dans 
 * toutes les couches</i> [<b>VUES</b> + <b>CONTROLLERS</b> 
 * + <b>MODEL</b>(Services + Métier + DAOs)].</li>
 * <li>
 * La COUCHE <b>METIER</b> fait partie intégrante de la 
 * <b>logique métier (MODEL)</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <b>ContactSimple</b> modélise un <i>concept</i> de <b>Contact</b> 
 * (Personne avec des coordonnées) avec un nom, un prénom et des coordonnées
 * <i>simples</i>.<br/>
 * Un ContactSimple ne possède qu'une seule adresse, 
 * un seul numéro de téléphone, et un seul mail.
 * </p>
 * 
 * <p>
 * <b><span style="text-decoration: underline;">
 * Représentation schématique d'un ContactSimple :
 * </span></b>
 * </p>
 * <p>
 * <img src="../../../../../../../../../../javadoc/images/model/metier/contactsimple/vue_simplifiee_ContactSimple.png" 
 * alt="vue simplifiée d'un ContactSimple" border="1" align="center" />
 * </p>
 * 
 * <br/>
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
 * @since 9 mai 2018
 *
 */
package levy.daniel.application.model.metier.contactsimple.impl;
