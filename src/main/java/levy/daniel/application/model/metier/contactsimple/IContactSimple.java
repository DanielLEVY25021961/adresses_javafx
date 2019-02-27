package levy.daniel.application.model.metier.contactsimple;

import java.io.Serializable;
import java.time.LocalDate;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;



/**
 * INTERFACE IContactSimple :<br/>
 * <p>
 * <b>IContactSimple</b> modélise un un <i>concept</i> de <b>Contact</b> 
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
 * <img src="../../../../../../../../../javadoc/images/model/metier/contactsimple/vue_simplifiee_ContactSimple.png" 
 * alt="vue simplifiée d'un ContactSimple" border="1" align="center" />
 * </p>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * HERITE de :
 * </span>
 * </p>
 * <li><b>IExportateurCsv</b> pour l'export d'un Objet 
 * métier en csv.</li>
 * <li><b>IExportateurJTable</b> pour l'affichage dans 
 * une JTable (Swing).</li>
 * <li><b>Comparable</b> pour l'affichage des Collections 
 * sous forme triée.</li>
 * <li><b>Cloneable</b> pour garantir que tout objet métier 
 * implémentant cette interface saura se cloner.</li>
 * <li><b>Serializable</b> pour garantir que tout objet métier 
 * implémentant cette interface pourra être serialisé.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout IContactSimple sait :
 * </span>
 * </p>
 * <li>se <b>comparer</b> à un autre IContactSimple.</li>
 * <li>se <b>cloner</b>.</li>
 * <li>s'exporter sous forme <b>csv</b>.</li>
 * <li>s'exporter sous forme <b>JTable</b>.</li>
 * </ul>
 * 
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout IContactSimple possède à minima :
 * </span>
 * </p>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>prenom</b>.</li>
 * <li><b>nom</b>.</li>
 * <li><b>rue</b>.</li>
 * <li><b>rue2</b>.</li>
 * <li><b>codePostal</b>.</li>
 * <li><b>ville</b>.</li>
 * <li><b>pays</b>.</li>
 * <li><b>telephone</b>.</li>
 * <li><b>mail</b>.</li>
 * <li><b>dateNaissance</b>.</li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <ul>
 * <li>L'<b>égalité metier</b> d'un IContactSimple est vérifiée sur :</li>
  * <ul>
 * <li><b>nom</b> (insensible à la casse).</li>
 * <li><b>prenom</b> (insensible à la casse).</li>
 * <li><b>dateNaissance</b>.</li>
 * </ul>
 * </ul>
 *  
 * <p>
 * <span style="text-decoration: underline;">COMPARAISON</span>
 * </p>
 * <ul>
 * <li>La <b>comparaison</b> d'un IContactSimple est réalisée sur :</li>
  * <ol>
 * <li><b>nom</b> (insensible à la casse).</li>
 * <li><b>prenom</b> (insensible à la casse).</li>
 * <li><b>dateNaissance</b> (le plus jeune en premier).</li>
 * </ol>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">DIAGRAMME DE CLASSES D'IMPLEMENTATION</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../javadoc/images/model/metier/contactsimple/diagramme_classes_contactsimple.png" 
 * alt="classes d'implémentation des IContactSimple" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">REGLES DE GESTION</span>
 * </p>
 * <ul>
 * <li>
 * Les <b>Règles de Gestion (RG)</b> applicables aux attributs 
 * d'un IContactSimple sont les suivantes :
 * </li>
 * <br/>
 * <table border="1">
 * <tr>
 * <th>Attribut</th><th>Règle de Gestion</th>
 * </tr>
 * 
 *  
 * <tr>
 * <td rowspan="3">
 * prenom
 * </td>
 * <td>
 * "RG_NOMMAGE_PRENOM_RENSEIGNE_01
 *  : le prénom du ContactSimple 
 *  doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_PRENOM_LITTERAL_02
 *  : le prénom du ContactSimple 
 *  ne doit contenir que des lettres ou des caractères spéciaux 
 *  '-', '_', ... (aucun chiffre)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_PRENOM_LONGUEUR_03
 *  : le prénom du ContactSimple 
 *  doit contenir entre [1] et [50] lettres"
 * </td>
 * </tr>

 * <tr>
 * <td rowspan="3">
 * nom
 * </td>
 * <td>
 * "RG_NOMMAGE_NOM_RENSEIGNE_04 : 
 * le nom du ContactSimple 
 * doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_NOM_LITTERAL_05 : 
 * le nom du ContactSimple 
 * ne doit contenir que des lettres ou des 
 * caractères spéciaux '-', '_', ... (aucun chiffre)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_NOM_LONGUEUR_06 : 
 * le nom du ContactSimple 
 * doit contenir entre [1] et [50] lettres"
 * </td>
 * </tr>
 * 
 * </table>
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
 * @since 9 mai 2018
 *
 */
public interface IContactSimple extends Comparable<IContactSimple>
						, Serializable, Cloneable
								, IExportateurCsv, IExportateurJTable {

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	int hashCode();

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean equals(Object pObjet);


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	int compareTo(IContactSimple pObjet);



	/**
	 * clone.<br/>
	 *
	 * @return IContactSimple
	 * 
	 * @throws CloneNotSupportedException
	 */
	IContactSimple clone() throws CloneNotSupportedException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	String toString();



	/**
	 * {@inheritDoc}
	 * <b>enTete CSV pour un ContactSimple</b> :<br/>
	 * "id;nom;prenom;rue;rue2;codePostal;ville;pays;téléphone;mail;dateNaissance;".<br/>
	 * <br/>
	 */
	@Override
	String fournirEnTeteCsv();



	/**
	 * {@inheritDoc}
	 * <b>enTete CSV pour un ContactSimple</b> :<br/>
	 * "id;nom;prenom;rue;rue2;codePostal;ville;pays;téléphone;mail;dateNaissance;".<br/>
	 * <br/>
	 */
	@Override
	String fournirStringCsv();



	/**
	 * {@inheritDoc}
	 * <b>enTete CSV pour un ContactSimple</b> :<br/>
	 * "id;nom;prenom;rue;rue2;codePostal;ville;pays;téléphone;mail;dateNaissance;".<br/>
	 * <br/>
	 */
	@Override
	String fournirEnTeteColonne(int pI);



	/**
	 * {@inheritDoc}
	 * <b>enTete CSV pour un ContactSimple</b> :<br/>
	 * "id;nom;prenom;rue;rue2;codePostal;ville;pays;téléphone;mail;dateNaissance;".<br/>
	 * <br/>
	 */
	@Override
	Object fournirValeurColonne(int pI);



	/**
	 * Getter de l'ID en base.<br/>
	 *
	 * @return this.id : Long.<br/>
	 */
	Long getId();



	/**
	* Setter de l'ID en base.<br/>
	*
	* @param pId : Long : 
	* valeur à passer à this.id.<br/>
	*/
	void setId(Long pId);



	/**
	 * Getter du prénom.<br/>
	 *
	 * @return this.prenom : String.<br/>
	 */
	String getPrenom();



	/**
	* Setter du prénom.<br/>
	*
	* @param pPrenom : String : 
	* valeur à passer à this.prenom.<br/>
	*/
	void setPrenom(String pPrenom);



	/**
	 * method getNom() :<br/>
	 * Getter du nom.<br/>
	 * <br/>
	 *
	 * @return nom : String.<br/>
	 */
	String getNom();



	/**
	* method setNom(
	* String pNom) :<br/>
	* Setter du nom.<br/>
	* <br/>
	*
	* @param pNom : String : valeur à passer à nom.<br/>
	*/
	void setNom(String pNom);



	/**
	 * method getRue() :<br/>
	 * Getter de la rue.<br/>
	 * <br/>
	 *
	 * @return rue : String.<br/>
	 */
	String getRue();



	/**
	* method setRue(
	* String pRue) :<br/>
	* Setter de la rue.<br/>
	* <br/>
	*
	* @param pRue : String : valeur à passer à rue.<br/>
	*/
	void setRue(String pRue);
	

	
	/**
	 * Getter de rue2.
	 *
	 * @return this.rue2 : String.<br/>
	 */
	String getRue2();
	

	
	/**
	* Setter de rue2.
	*
	* @param pRue2 : String : 
	* valeur à passer à this.rue2.<br/>
	*/
	void setRue2(String pRue2);
	
	
	
	/**
	 * method getCodePostal() :<br/>
	 * Getter du code postal.<br/>
	 * <br/>
	 *
	 * @return codePostal : String.<br/>
	 */
	String getCodePostal();



	/**
	* method setCodePostal(
	* String pCodePostal) :<br/>
	* Setter du code postal.<br/>
	* <br/>
	*
	* @param pCodePostal : String : valeur à passer à codePostal.<br/>
	*/
	void setCodePostal(String pCodePostal); 



	/**
	 * method getVille() :<br/>
	 * Getter de la ville.<br/>
	 * <br/>
	 *
	 * @return ville : String.<br/>
	 */
	String getVille();



	/**
	* method setVille(
	* String pVille) :<br/>
	* Setter de la ville.<br/>
	* <br/>
	*
	* @param pVille : String : valeur à passer à ville.<br/>
	*/
	void setVille(String pVille);


	
	/**
	 * Getter du pays.
	 *
	 * @return this.pays : String.<br/>
	 */
	String getPays();


	
	/**
	* Setter du pays.
	*
	* @param pPays : String : 
	* valeur à passer à this.pays.<br/>
	*/
	void setPays(String pPays);


	
	/**
	 * Getter du téléphone.
	 *
	 * @return this.telephone : String.<br/>
	 */
	String getTelephone();


	
	/**
	* Setter du téléphone.
	*
	* @param pTelephone : String : 
	* valeur à passer à this.telephone.<br/>
	*/
	void setTelephone(String pTelephone);


	
	/**
	 * Getter du mail.
	 *
	 * @return this.mail : String.<br/>
	 */
	String getMail();


	
	/**
	* Setter du mail.
	*
	* @param pMail : String : 
	* valeur à passer à this.mail.<br/>
	*/
	void setMail(String pMail);
	


	/**
	 * method getDateNaissance() :<br/>
	 * Getter de la date de naissance.<br/>
	 * <br/>
	 *
	 * @return dateNaissance : LocalDate.<br/>
	 */
	LocalDate getDateNaissance();



	/**
	* method setDateNaissance(
	* LocalDate pDateNaissance) :<br/>
	* Setter de la date de naissance.<br/>
	* <br/>
	*
	* @param pDateNaissance : LocalDate : 
	* valeur à passer à dateNaissance.<br/>
	*/
	void setDateNaissance(LocalDate pDateNaissance);

	
	
} // FIN de L'INTERFACE IContactSimple.--------------------------------------
