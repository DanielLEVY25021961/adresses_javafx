package levy.daniel.application.vues.desktop.metier.contactsimple.modelobs;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;


/**
 * INTERFACE IContactSimpleModelObs :<br/>
 * Interface factorisant les comportements 
 * des CONTROLLERS ContactSimpleModelObs.<br/>
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
public interface IContactSimpleModelObs 
	extends Serializable, Comparable<IContactSimpleModelObs>, Cloneable {


	
	/**
	 * Getter de la valeur dans la Property id.<br/>
	 *
	 * @return this.id.get() : String : 
	 * valeur dans la property this.id.<br/>
	 */
	String getId();



	/**
	 * Setter de la valeur dans la Property id.<br/>
	 *
	 * @param pId : String : 
	 * valeur à insérer dans la property this.id.<br/>
	 */
	void setId(String pId);



	/**
	 * Getter de la property ID en base.<br/>
	 *
	 * @return this.id : StringProperty.<br/>
	 */
	StringProperty getIdProperty();



	/**
	 * Getter de la valeur dans la Property prenom.<br/>
	 *
	 * @return this.prenom.get() : String : 
	 * valeur dans la Property this.prenom.<br/>
	 */
	String getPrenom();



	/**
	 * Setter de la valeur dans la Property prenom.<br/>
	 *
	 * @param pPrenom : String : 
	 * valeur à insérer dans la Property this.prenom.<br/>
	 */
	void setPrenom(String pPrenom);



	/**
	 * Getter de la property prenom.<br/>
	 *
	 * @return this.prenom : StringProperty.<br/>
	 */
	StringProperty getPrenomProperty();



	/**
	 * Getter de la valeur de la property nom.<br/>
	 *
	 * @return this.nom.get() : String : 
	 * valeur de la property this.nom.<br/>
	 */
	String getNom();



	/**
	 * Setter de la valeur de la property nom.<br/>
	 *
	 * @param pNom : String : 
	 * valeur à insérer dans la property this.nom.<br/>
	 */
	void setNom(String pNom);



	/**
	 * Getter de la property nom.<br/>
	 *
	 * @return this.nom : StringProperty.<br/>
	 */
	StringProperty getNomProperty();



	/**
	 * Getter de la valeur de la property rue.<br/>
	 *
	 * @return this.rue.get() : String : 
	 * valeur de la property this.rue.<br/>
	 */
	String getRue();



	/**
	 * Setter de la valeur de la property rue.<br/>
	 *
	 * @param pRue : String : 
	 * valeur à insérer dans la property this.rue.<br/>
	 */
	void setRue(String pRue);



	/**
	 * Getter de la property rue.<br/>
	 *
	 * @return this.rue : StringProperty.<br/>
	 */
	StringProperty getRueProperty();



	/**
	 * Getter de la valeur de la property rue2.<br/>
	 *
	 * @return this.rue2.get() : String : 
	 * valeur de la property this.rue2.<br/>
	 */
	String getRue2();



	/**
	 * Setter de la valeur de la property rue2.<br/>
	 *
	 * @param pRue2 : String : 
	 * valeur à insérer dans la property this.rue2.<br/>
	 */
	void setRue2(String pRue2);



	/**
	 * Getter de la property rue2.<br/>
	 *
	 * @return this.rue2 : StringProperty.<br/>
	 */
	StringProperty getRue2Property();



	/**
	 * Getter de la valeur de la property codePostal.<br/>
	 *
	 * @return this.codePostal.get() : String : 
	 * valeur de la property this.codePostal.<br/>
	 */
	String getCodePostal();



	/**
	 * Setter de la valeur de la property codePostal.<br/>
	 *
	 * @param pCodePostal : String : 
	 * valeur à insérer dans la property this.codePostal.<br/>
	 */
	void setCodePostal(String pCodePostal);



	/**
	 * Getter de la property codePostal.<br/>
	 *
	 * @return this.codePostal : StringProperty.<br/>
	 */
	StringProperty getCodePostalProperty();
	


	/**
	 * Getter de la valeur de la property ville.<br/>
	 *
	 * @return this.ville.get() : String : 
	 * valeur de la property this.ville.<br/>
	 */
	String getVille();



	/**
	 * Setter de la valeur de la property ville.<br/>
	 *
	 * @param pVille : String : 
	 * valeur à insérer dans la property this.ville.<br/>
	 */
	void setVille(String pVille);



	/**
	 * Getter de la property ville.<br/>
	 *
	 * @return this.ville : StringProperty.<br/>
	 */
	StringProperty getVilleProperty();
	


	/**
	 * Getter de la valeur de la property pays.<br/>
	 *
	 * @return this.pays.get() : String : 
	 * valeur de la property this.pays.<br/>
	 */
	String getPays();



	/**
	 * Setter de la valeur de la property pays.<br/>
	 *
	 * @param pPays : String : 
	 * valeur à insérer dans la property this.pays.<br/>
	 */
	void setPays(String pPays);



	/**
	 * Getter de la property pays.<br/>
	 *
	 * @return this.pays : StringProperty.<br/>
	 */
	StringProperty getPaysProperty();
	


	/**
	 * Getter de la valeur de la property telephone.<br/>
	 *
	 * @return this.telephone.get() : String : 
	 * valeur de la property this.telephone.<br/>
	 */
	String getTelephone();



	/**
	 * Setter de la valeur de la property telephone.<br/>
	 *
	 * @param pTelephone : String : 
	 * valeur à insérer dans la property this.telephone.<br/>
	 */
	void setTelephone(String pTelephone);



	/**
	 * Getter de la property telephone.<br/>
	 *
	 * @return this.telephone : StringProperty.<br/>
	 */
	StringProperty getTelephoneProperty();
	


	/**
	 * Getter de la valeur de la property mail.<br/>
	 *
	 * @return this.mail.get() : String : 
	 * valeur de la property this.mail.<br/>
	 */
	String getMail();



	/**
	 * Setter de la valeur de la property mail.<br/>
	 *
	 * @param pMail : String : 
	 * valeur à insérer dans la property this.mail.<br/>
	 */
	void setMail(String pMail);



	/**
	 * Getter de la property mail.<br/>
	 *
	 * @return this.mail : StringProperty.<br/>
	 */
	StringProperty getMailProperty();



	/**
	 * Getter de la valeur de la property dateNaissance.<br/>
	 *
	 * @return this.dateNaissance.get() : LocalDate.<br/>
	 */
	LocalDate getDateNaissance();



	/**
	 * Setter de la valeur de la property dateNaissance.<br/>
	 *
	 * @param pDateNaissance : LocalDate : 
	 * valeur à insérer dans la property this.dateNaissance.<br/>
	 */
	void setDateNaissance(LocalDate pDateNaissance);



	/**
	 * Getter de la property dateNaissance.<br/>
	 *
	 * @return this.dateNaissance : ObjectProperty&lt;LocalDate&gt;.<br/>
	 */
	ObjectProperty<LocalDate> getDateNaissanceProperty();

	
	
} // FIN DE L'INTERFACE IContactSimpleModelObs.---------------------------------
