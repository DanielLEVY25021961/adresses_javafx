package levy.daniel.application.model.metier.contactsimple;

import java.io.Serializable;
import java.time.LocalDate;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;



/**
 * INTERFACE IContactSimple :<br/>
 * Interface factorisant les comportements 
 * des ContactSimple de MODEL/METIER.<br/>
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
	, Serializable, Cloneable, IExportateurCsv, IExportateurJTable {

	
	
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
	 * method clone() :<br/>
	 * clone.<br/>
	 * <br/>
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
	 * <br/>
	 * "id;nom;prenom;rue;codePostal;ville;dateNaissance;".<br/>
	 */
	@Override
	String fournirEnTeteCsv();



	/**
	 * {@inheritDoc}
	 * <br/>
	 * "id;nom;prenom;rue;codePostal;ville;dateNaissance;".<br/>
	 */
	@Override
	String fournirStringCsv();



	/**
	 * {@inheritDoc}
	 * "id;nom;prenom;rue;codePostal;ville;dateNaissance;".<br/>
	 */
	@Override
	String fournirEnTeteColonne(int pI);



	/**
	 * {@inheritDoc}
	 * "id;nom;prenom;rue;codePostal;ville;dateNaissance;".<br/>
	 */
	@Override
	Object fournirValeurColonne(int pI);



	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Long.<br/>
	 */
	Long getId();



	/**
	* method setId(
	* Long pId) :<br/>
	* Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Long : valeur à passer à id.<br/>
	*/
	void setId(Long pId);



	/**
	 * method getPrenom() :<br/>
	 * Getter du prénom.<br/>
	 * <br/>
	 *
	 * @return prenom : String.<br/>
	 */
	String getPrenom();



	/**
	* method setPrenom(
	* String pPrenom) :<br/>
	* Setter du prénom.<br/>
	* <br/>
	*
	* @param pPrenom : String : valeur à passer à prenom.<br/>
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

	
	
} // FIN de L'INTERFACE IContactSimple.-------------------------------------------
