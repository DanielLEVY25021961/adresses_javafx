package levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.impl;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;


/**
 * CLASSE ContactSimpleModelObs :<br/>
 * CONTROLLER réagissant aux évènements de la VUE ContactSimpleVue.<br/>
 * <ul>
 * <li>utilise des <b>Property JavaFx</b> pour tracker 
 * les modifications des valeurs dans la VUE.</li>
 * <li>lien entre un <b>model.metier.contactSimple.impl.ContactSimple</b> 
 * et le présent CONTROLLER.</li>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * caster null pour constructor ambiguous,<br/>
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
public class ContactSimpleModelObs implements IContactSimpleModelObs {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
	/**
	 * ", ".<br/>
	 */
	public static final String VIRGULE_ESPACE = ", ";
	
	/**
	 * "null".<br/>
	 */
	public static final String NULL = "null";


	/**
	 * ID en base (StringProperty).<br/>
	 */
	private StringProperty id;
	
	
    /**
     * prénom (StringProperty).<br/>
     */
    private StringProperty prenom;
    
    /**
     * nom (StringProperty).<br/>
     */
    private StringProperty nom;
       
    /**
     * rue (StringProperty).<br/>
     */
    private StringProperty rue;
    
    /**
     * complément de rue (StringProperty).<br/>
     */
    private StringProperty rue2;
    
    /**
     * code postal (StringProperty).<br/>
     */
    private StringProperty codePostal;
    
    /**
     * ville (StringProperty).<br/>
     */
    private StringProperty ville;
    
    /**
     * pays (StringProperty).<br/>
     */
    private StringProperty pays;
    
    /**
     * téléphone (StringProperty).<br/>
     */
    private StringProperty telephone;
    
    /**
     * mail (StringProperty).<br/>
     */
    private StringProperty mail;
    
    /**
     * date de naissance (ObjectProperty&lt;LocalDate&gt;).<br/>
     */
    private ObjectProperty<LocalDate> dateNaissance;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ContactSimpleModelObs.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ContactSimpleModelObs() {
		
		this((StringProperty) 
				null
				, null, null
				, null, null, null, null, null
				, null, null
				, null);
		
	} // Fin de  CONSTRUCTEUR D'ARITE NULLE._______________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pPrenom : StringProperty : prénom.<br/>
	 * @param pNom : StringProperty : nom.<br/>
	 * @param pRue : StringProperty : rue.<br/>
	 * @param pRue2 : StringProperty : complément de rue.<br/>
	 * @param pCodePostal : StringProperty : code postal.<br/>
	 * @param pVille : StringProperty : ville.<br/>
	 * @param pPays : StringProperty : pays.<br/>
	 * @param pTelephone : StringProperty : téléphone.<br/>
	 * @param pMail : StringProperty : mail.<br/>
	 * @param pDateNaissance : ObjectProperty : date de naissance.<br/>
	 */
	public ContactSimpleModelObs(
			final StringProperty pPrenom
				, final StringProperty pNom
			, final StringProperty pRue
			, final StringProperty pRue2
			, final StringProperty pCodePostal
				, final StringProperty pVille
					, final StringProperty pPays
			, final StringProperty pTelephone, final StringProperty pMail
			, final ObjectProperty<LocalDate> pDateNaissance) {
		
		this(null
				, pPrenom, pNom
				, pRue, pRue2, pCodePostal, pVille, pPays
				, pTelephone, pMail
				, pDateNaissance);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pId : StringProperty : ID en base.<br/>
	 * @param pPrenom : StringProperty : prénom.<br/>
	 * @param pNom : StringProperty : nom.<br/>
	 * @param pRue : StringProperty : rue.<br/>
	 * @param pRue2 : StringProperty : complément de rue.<br/>
	 * @param pCodePostal : StringProperty : code postal.<br/>
	 * @param pVille : StringProperty : ville.<br/>
	 * @param pPays : StringProperty : pays.<br/>
	 * @param pTelephone : StringProperty : téléphone.<br/>
	 * @param pMail : StringProperty : mail.<br/>
	 * @param pDateNaissance : ObjectProperty : date de naissance.<br/>
	 */
	public ContactSimpleModelObs(
			final StringProperty pId
				, final StringProperty pPrenom
					, final StringProperty pNom
			, final StringProperty pRue
			, final StringProperty pRue2
				, final StringProperty pCodePostal
					, final StringProperty pVille
						, final StringProperty pPays
			, final StringProperty pTelephone, final StringProperty pMail
			, final ObjectProperty<LocalDate> pDateNaissance) {

		super();
		
		this.id = pId;
		this.prenom = pPrenom;
		this.nom = pNom;
		this.rue = pRue;
		this.rue2 = pRue2;
		this.codePostal = pCodePostal;
		this.ville = pVille;
		this.pays = pPays;
		this.telephone = pTelephone;
		this.mail = pMail;
		this.dateNaissance = pDateNaissance;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
	 /**
	 * method CONSTRUCTEUR ContactSimpleModelObs(
	 * IContactSimple pContactSimple) :<br/>
	 * CONSTRUCTEUR LIEN.<br/>
	 * Fait le lien entre un OBJET METIER
	 * <b>model.metier.contactSimple.impl.ContactSimple</b> 
	 * et le présent DTO OBSERVABLE ContactSimpleModelObs.<br/>
	 * <br/>
	 *
	 * @param pContactSimple : model.metier.contactSimple.IContactSimple.<br/>
	 */
	public ContactSimpleModelObs(
			final IContactSimple pContactSimple) {
		
		super();
		
		if (pContactSimple != null) {
			
			final Long idObjetMetier = pContactSimple.getId();
			final LocalDate dateNaissanceObjetMetier 
				= pContactSimple.getDateNaissance();
			
			if (idObjetMetier != null) {
				this.id 
				= new SimpleStringProperty(String.valueOf(
						idObjetMetier));
			} else {
				this.id = null;
			}			
			this.prenom 
				= new SimpleStringProperty(pContactSimple.getPrenom());
			this.nom 
				= new SimpleStringProperty(pContactSimple.getNom());
			this.rue 
				= new SimpleStringProperty(pContactSimple.getRue());
			this.rue2 
				= new SimpleStringProperty(pContactSimple.getRue2());
			this.codePostal 
				= new SimpleStringProperty(pContactSimple.getCodePostal());
			this.ville 
				= new SimpleStringProperty(pContactSimple.getVille());
			this.pays 
				= new SimpleStringProperty(pContactSimple.getPays());
			this.telephone 
				= new SimpleStringProperty(pContactSimple.getTelephone());
			this.mail 
				= new SimpleStringProperty(pContactSimple.getMail());
			if (dateNaissanceObjetMetier != null) {
				this.dateNaissance 
					= new SimpleObjectProperty<LocalDate>(
							dateNaissanceObjetMetier);
			} else {
				this.dateNaissance = null;
			}
			
			
		} else {
			
			this.id = null;
			this.prenom = null;
			this.nom = null;
			this.rue = null;
			this.rue2 = null;
			this.codePostal = null;
			this.ville = null;
			this.pays = null;
			this.telephone = null;
			this.mail = null;
			this.dateNaissance = null;
		}
		
	} // Fin du CONSTRUCTEUR LIEN._________________________________________
	

			
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {
		
		final int prime = 31;
		
		int result = 1;
		
		result 
		= prime * result 
		+ (this.nom == null || this.nom.get() == null ? 0 : this.nom.get().hashCode());
		result 
		= prime * result 
			+ (this.prenom == null || this.prenom.get() == null ? 0 : this.prenom.get().hashCode());
		result 
		= prime * result 
		+ (this.dateNaissance == null || this.dateNaissance.get() == null ? 0 : this.dateNaissance.get().hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean equals(
			final Object pObjet) {
		
		if (this == pObjet) {
			return true;
		}
		
		if (pObjet == null) {
			return false;
		}
		
		if (!(pObjet instanceof ContactSimpleModelObs)) {
			return false;
		}
		
		final ContactSimpleModelObs other 
			= (ContactSimpleModelObs) pObjet;
		
		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!this.nom.get().equals(other.nom.get())) {
			return false;
		}
		if (this.prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!this.prenom.get().equals(other.prenom.get())) {
			return false;
		}

		if (this.dateNaissance == null) {
			if (other.dateNaissance != null) {
				return false;
			}
		} else if (!this.dateNaissance.get()
				.equals(other.dateNaissance.get())) {
			return false;
		}
		
		return true;
		
	} // Fin de  equals(...).______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final IContactSimpleModelObs pObject) {
		
		if (this == pObject) {
			return 0;
		}

		if (pObject == null) {
			return -1;
		}

		int compareNom = 0;
		int comparePrenom = 0;
		int compareDateNaissance = 0;
		
		/* Nom. */
		if (this.getNomProperty() == null) {
			if (pObject.getNomProperty() != null) {
				return +1;
			}
		} else if (pObject.getNomProperty() == null) {
			return -1;
		}
		
		if (this.getNom() == null) {
			if (pObject.getNom() != null) {
				return +1;
			}
		} else if (pObject.getNom() == null) {
			return -1;
		}
		
		if (this.getNom() != null && pObject.getNom() != null) {
			
			compareNom 
				= this.getNom()
					.compareToIgnoreCase(pObject.getNom());
			
			if (compareNom != 0) {
				return compareNom;
			}
			
		}
		
		
		/* prenom. */
		if (this.getPrenomProperty() == null) {
			if (pObject.getPrenomProperty() != null) {
				return +1;
			}
		} else if (pObject.getPrenomProperty() == null) {
			return -1;
		}
		
		if (this.getPrenom() == null) {
			if (pObject.getPrenom() != null) {
				return +1;
			}
		} else if (pObject.getPrenom() == null) {
			return -1;
		}
		
		if (this.getPrenom() != null && pObject.getPrenom() != null) {
			
			comparePrenom 
				= this.getPrenom()
				.compareToIgnoreCase(pObject.getPrenom());
			
			if (comparePrenom != 0) {
				return comparePrenom;
			}
		}
		
		
		/* dateNaissance. */
		if (this.getDateNaissanceProperty() == null) {
			if (pObject.getDateNaissanceProperty() != null) {
				return +1;
			}
			
			return 0;
			
		} else if (pObject.getDateNaissanceProperty() == null) {
			return -1;
		}
		
		if (this.getDateNaissance() == null) {
			if (pObject.getDateNaissance() != null) {
				return +1;
			}
			
			return 0;
			
		} else if (pObject.getDateNaissance() == null) {
			return -1;
		}
		
		compareDateNaissance 
			= this.getDateNaissance().compareTo(pObject.getDateNaissance());

		return compareDateNaissance;

	} // Fin de compareTo(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ContactSimpleModelObs clone() throws CloneNotSupportedException {

		final ContactSimpleModelObs clone 
			= (ContactSimpleModelObs) super.clone();
		
		clone.id.set(this.id.get());
		clone.prenom.set(this.prenom.get());
		clone.nom.set(this.nom.get());
		clone.rue.set(this.rue.get());
		clone.rue2.set(this.rue2.get());
		clone.codePostal.set(this.codePostal.get());
		clone.ville.set(this.ville.get());
		clone.pays.set(this.pays.get());
		clone.telephone.set(this.telephone.get());
		clone.mail.set(this.mail.get());
		clone.dateNaissance.set(this.dateNaissance.get());
		
		return clone;
		
	} // Fin de clone().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("ContactSimpleModelObs [");
		
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("prenom=");
		if (this.prenom != null) {
			builder.append(this.prenom);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("nom=");
		if (this.nom != null) {			
			builder.append(this.nom);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("rue=");
		if (this.rue != null) {
			builder.append(this.rue);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("rue2=");
		if (this.rue2 != null) {
			builder.append(this.rue2);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("codePostal=");
		if (this.codePostal != null) {
			builder.append(this.codePostal);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("ville=");
		if (this.ville != null) {
			builder.append(this.ville);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("pays=");
		if (this.pays != null) {
			builder.append(this.pays);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("telephone=");
		if (this.telephone != null) {
			builder.append(this.telephone);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("mail=");
		if (this.mail != null) {
			builder.append(this.mail);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("dateNaissance=");
		if (this.dateNaissance != null) {
			builder.append(this.dateNaissance);
		} else {
			builder.append(NULL);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getId() {
		if (this.id != null) {
			return this.id.get();
		}
		return null;
	} // Fin de getId().___________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setId(
			final String pId) {
		if (this.id != null) {
			this.id.set(pId);
		}		
	} // Fin de setId(...).________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty getIdProperty() {	
		return this.id;
	} // Fin de getIdProperty().___________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getPrenom() {
		if (this.prenom != null) {
			return this.prenom.get();
		}
		return null;
	} // Fin de getPrenom()._______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPrenom(
			final String pPrenom) {	
		if (this.prenom != null) {
			this.prenom.set(pPrenom);
		}		
	} // Fin de setPrenom(...).____________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty getPrenomProperty() {	
		return this.prenom;
	} // Fin de getPrenomProperty()._______________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getNom() {
		if (this.nom != null) {
			return this.nom.get();
		}
		return null;
	} // Fin de getNom().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setNom(
			final String pNom) {
		if (this.nom != null) {
			this.nom.set(pNom);
		}		
	} // Fin de setNom(...)._______________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty getNomProperty() {	
		return this.nom;
	} // Fin de getNomProperty().__________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getRue() {
		if (this.rue != null) {
			return this.rue.get();
		}
		return null;
	} // Fin de getRue().__________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRue(
			final String pRue) {
		if (this.rue != null) {
			this.rue.set(pRue);
		}		
	} // Fin de setRue(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty getRueProperty() {	
		return this.rue;
	} // Fin de getRueProperty().__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getRue2() {
		if (this.rue2 != null) {
			return this.rue2.get();
		}
		return null;
	} // Fin de getRue2()._________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRue2(
			final String pRue2) {
		if (this.rue2 != null) {
			this.rue2.set(pRue2);
		}		
	} // Fin de setRue2(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty getRue2Property() {	
		return this.rue2;
	} // Fin de getRue2Property()._________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getCodePostal() {
		if (this.codePostal != null) {
			return this.codePostal.get();
		}
		return null;
	} // Fin de getCodePostal().___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCodePostal(
			final String pCodePostal) {
		if (this.codePostal != null) {
			this.codePostal.set(pCodePostal);
		}		
	} // Fin de setCodePostal(...).________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty getCodePostalProperty() {	
		return this.codePostal;
	} // Fin de getCodePostalProperty().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getVille() {
		if (this.ville != null) {
			return this.ville.get();
		}
		return null;
	} // Fin de getVille().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setVille(
			final String pVille) {
		if (this.ville != null) {
			this.ville.set(pVille);
		}		
	} // Fin de setVille(...)._____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final StringProperty getVilleProperty() {	
		return this.ville;
	} // Fin de getVilleProperty().________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getPays() {
		if (this.pays != null) {
			return this.pays.get();
		}
		return null;
	} // Fin de getPays()._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPays(
			final String pPays) {
		if (this.pays != null) {
			this.pays.set(pPays);
		}		
	} // Fin de setPays(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringProperty getPaysProperty() {
		return this.pays;
	} // Fin de getPaysProperty()._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTelephone() {
		if (this.telephone != null) {
			return this.telephone.get();
		}
		return null;
	} // Fin de getTelephone().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setTelephone(
			final String pTelephone) {
		if (this.telephone != null) {
			this.telephone.set(pTelephone);
		}		
	} // Fin de setTelephone(...)._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringProperty getTelephoneProperty() {
		return this.telephone;
	} // Fin de getTelephoneProperty().____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getMail() {
		if (this.mail != null) {
			return this.mail.get();
		}
		return null;
	} // Fin de getMail().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMail(
			final String pMail) {
		if (this.mail != null) {
			this.mail.set(pMail);
		}		
	} // Fin de setMail(...)._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringProperty getMailProperty() {
		return this.mail;
	} // Fin de getMailProperty().____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final LocalDate getDateNaissance() {	
		if (this.dateNaissance != null) {
			return this.dateNaissance.get();
		}
		return null;
	} // Fin de getDateNaissance().________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setDateNaissance(
			final LocalDate pDateNaissance) {
		if (this.dateNaissance != null) {
			this.dateNaissance.set(pDateNaissance);
		}		
	} // Fin de setDateNaissance(...)._____________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ObjectProperty<LocalDate> getDateNaissanceProperty() {	
		return this.dateNaissance;
	} // Fin de getDateNaissanceProperty().________________________________


	
} // FIN DE LA CLASSE ContactSimpleModelObs.------------------------------------
