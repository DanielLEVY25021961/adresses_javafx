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
	 * method getId() :<br/>
	 * Getter de la valeur dans la Property id.<br/>
	 * <br/>
	 *
	 * @return this.id.get() : String : valeur dans la property id.<br/>
	 */
	String getId();



	/**
	 * method setId(
	 * String pId) :<br/>
	 * Setter de la valeur dans la Property id.<br/>
	 * <br/>
	 *
	 * @param pId : String : valeur à passer à la property id.<br/>
	 */
	void setId(String pId);



	/**
	 * method getIdProperty() :<br/>
	 * Getter de la property ID en base.<br/>
	 * <br/>
	 *
	 * @return id : StringProperty.<br/>
	 */
	StringProperty getIdProperty();



	/**
	 * method getPrenom() :<br/>
	 * Getter de la valeur dans la Property prenom.<br/>
	 * <br/>
	 *
	 * @return this.prenom.get() : String : 
	 * valeur dans la Property prenom.<br/>
	 */
	String getPrenom();



	/**
	 * method setPrenom(
	 * String pPrenom) :<br/>
	 * Setter de la valeur dans la Property prenom.<br/>
	 * <br/>
	 *
	 * @param pPrenom : String : valeur dans la Property prenom.<br/>
	 */
	void setPrenom(String pPrenom);



	/**
	 * method getPrenomProperty() :<br/>
	 * Getter de la property prenom.<br/>
	 * <br/>
	 *
	 * @return prenom : StringProperty.<br/>
	 */
	StringProperty getPrenomProperty();



	/**
	 * method getNom() :<br/>
	 * Getter de la valeur de la property nom.<br/>
	 * <br/>
	 *
	 * @return this.nom.get() : String : valeur de la property nom.<br/>
	 */
	String getNom();



	/**
	 * method setNom(
	 * String pNom) :<br/>
	 * Setter de la valeur de la property nom.<br/>
	 * <br/>
	 *
	 * @param pNom : String : valeur de la property nom.<br/>
	 */
	void setNom(String pNom);



	/**
	 * method getNomProperty() :<br/>
	 * Getter de la property nom.<br/>
	 * <br/>
	 *
	 * @return nom : StringProperty.<br/>
	 */
	StringProperty getNomProperty();



	/**
	 * method getRue() :<br/>
	 * Getter de la valeur de la property rue.<br/>
	 * <br/>
	 *
	 * @return this.rue.get() : String : valeur de la property rue.<br/>
	 */
	String getRue();



	/**
	 * method setRue(
	 * String pRue) :<br/>
	 * Setter de la valeur de la property rue.<br/>
	 * <br/>
	 *
	 * @param pRue : String : valeur de la property rue.<br/>
	 */
	void setRue(String pRue);



	/**
	 * method getRueProperty() :<br/>
	 * Getter de la property rue.<br/>
	 * <br/>
	 *
	 * @return rue : StringProperty.<br/>
	 */
	StringProperty getRueProperty();



	/**
	 * method getCodePostal() :<br/>
	 * Getter de la valeur de la property codePostal.<br/>
	 * <br/>
	 *
	 * @return this.codePostal.get() : String : 
	 * valeur de la property codePostal.<br/>
	 */
	String getCodePostal();



	/**
	 * method setCodePostal(
	 * String pCodePostal) :<br/>
	 * Setter de la valeur de la property codePostal.<br/>
	 * <br/>
	 *
	 * @param pCodePostal : String : valeur de la property codePostal.<br/>
	 */
	void setCodePostal(String pCodePostal);



	/**
	 * method getCodePostalProperty() :<br/>
	 * Getter de la property codePostal.<br/>
	 * <br/>
	 *
	 * @return codePostal : StringProperty.<br/>
	 */
	StringProperty getCodePostalProperty();
	


	/**
	 * method getVille() :<br/>
	 * Getter de la valeur de la property ville.<br/>
	 * <br/>
	 *
	 * @return this.ville.get() : String : 
	 * valeur de la property ville.<br/>
	 */
	String getVille();



	/**
	 * method setVille(
	 * String pVille) :<br/>
	 * Setter de la valeur de la property ville.<br/>
	 * <br/>
	 *
	 * @param pVille : String : valeur de la property ville.<br/>
	 */
	void setVille(String pVille);



	/**
	 * method getVilleProperty() :<br/>
	 * Getter de la property ville.<br/>
	 * <br/>
	 *
	 * @return ville : StringProperty.<br/>
	 */
	StringProperty getVilleProperty();



	/**
	 * method getDateNaissance() :<br/>
	 * Getter de la valeur de la property dateNaissance.<br/>
	 * <br/>
	 *
	 * @return this.dateNaissance.get() : LocalDate.<br/>
	 */
	LocalDate getDateNaissance();



	/**
	 * method setDateNaissance(
	 * LocalDate pDateNaissance) :<br/>
	 * Setter de la valeur de la property dateNaissance.<br/>
	 * <br/>
	 *
	 * @param pDateNaissance : LocalDate : 
	 * valeur de la property dateNaissance.<br/>
	 */
	void setDateNaissance(LocalDate pDateNaissance);



	/**
	 * method getDateNaissanceProperty() :<br/>
	 * Getter de la property dateNaissance.<br/>
	 * <br/>
	 *
	 * @return dateNaissance : ObjectProperty<LocalDate>.<br/>
	 */
	ObjectProperty<LocalDate> getDateNaissanceProperty();

	
	
} // FIN DE L'INTERFACE IContactSimpleModelObs.---------------------------------
