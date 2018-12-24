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
 * CONTROLLER réagissant aux évènements de la VUE PersonneVue.<br/>
 * <ul>
 * <li>utilise des <b>Property JavaFx</b> pour tracker 
 * les modifications des valeurs dans la VUE.</li>
 * <li>lien entre un <b>model.metier.personne.impl.Personne</b> 
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
	 * id : StringProperty :<br/>
	 * ID en base.<br/>
	 */
	private StringProperty id;
	
	
    /**
     * prenom : StringProperty :<br/>
     * prénom.<br/>
     */
    private StringProperty prenom;
    
    /**
     * nom : StringProperty :<br/>
     * nom.<br/>
     */
    private StringProperty nom;
       
    /**
     * rue : StringProperty :<br/>
     * rue.<br/>
     */
    private StringProperty rue;
    
    /**
     * codePostal : StringProperty :<br/>
     * code postal.<br/>
     */
    private StringProperty codePostal;
    
    /**
     * ville : StringProperty :<br/>
     * ville.<br/>
     */
    private StringProperty ville;
    
    /**
     * dateNaissance : ObjectProperty<LocalDate> :<br/>
     * date de naissance.<br/>
     */
    private ObjectProperty<LocalDate> dateNaissance;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ContactSimpleModelObs.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR ContactSimpleModelObs() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ContactSimpleModelObs() {
		
		this((StringProperty) null, null, null, null, null, null, null);
		
	} // Fin de  CONSTRUCTEUR D'ARITE NULLE._______________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ContactSimpleModelObs(...) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pPrenom : StringProperty
	 * @param pNom : StringProperty
	 * @param pRue : StringProperty
	 * @param pCodePostal : StringProperty
	 * @param pVille : StringProperty
	 * @param pDateNaissance : ObjectProperty
	 */
	public ContactSimpleModelObs(
			final StringProperty pPrenom
				, final StringProperty pNom
			, final StringProperty pRue
				, final StringProperty pCodePostal
					, final StringProperty pVille
			, final ObjectProperty<LocalDate> pDateNaissance) {
		
		this(null
				, pPrenom, pNom
				, pRue, pCodePostal, pVille
				, pDateNaissance);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ContactSimpleModelObs() :<br/>
	 * CONSTRUCTEUR COMPLET MODEL.<br/>
	 * Fait le lien entre un <b>model.metier.personne.impl.Personne</b> 
	 * et le présent ContactSimpleModelObs.<br/>
	 * <br/>
	 *
	 * @param pPrenom
	 * @param pNom
	 * @param pRue
	 * @param pCodePostal
	 * @param pVille
	 * @param pDateNaissance
	 */
	public ContactSimpleModelObs(
			final String pPrenom
				, final String pNom
			, final String pRue
				, final String pCodePostal
					, final String pVille
			, final LocalDate pDateNaissance) {
		
		this(null
				, pPrenom, pNom
				, pRue, pCodePostal, pVille
				, pDateNaissance);
		
	} // Fin de CONSTRUCTEUR COMPLET MODEL.________________________________

	
	
	 /**
	 * method CONSTRUCTEUR ContactSimpleModelObs(...) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : StringProperty
	 * @param pPrenom : StringProperty
	 * @param pNom : StringProperty
	 * @param pRue : StringProperty
	 * @param pCodePostal : StringProperty
	 * @param pVille : StringProperty
	 * @param pDateNaissance : ObjectProperty
	 */
	public ContactSimpleModelObs(
			final StringProperty pId
				, final StringProperty pPrenom
					, final StringProperty pNom
			, final StringProperty pRue
				, final StringProperty pCodePostal
					, final StringProperty pVille
			, final ObjectProperty<LocalDate> pDateNaissance) {

		super();
		
		this.id = pId;
		this.prenom = pPrenom;
		this.nom = pNom;
		this.rue = pRue;
		this.codePostal = pCodePostal;
		this.ville = pVille;
		this.dateNaissance = pDateNaissance;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


	
	 /**
	 * method CONSTRUCTEUR ContactSimpleModelObs() :<br/>
	 * CONSTRUCTEUR COMPLET BASE MODEL.<br/>
	 * Fait le lien entre les attributs d'un 
	 * <b>model.metier.personne.impl.Personne</b> 
	 * et le présent ContactSimpleModelObs.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pPrenom : String : prenom.<br/>
	 * @param pNom : String : nom.<br/>
	 * @param pRue : String : rue.<br/>
	 * @param pCodePostal : String : code postal.<br/>
	 * @param pVille : String : ville.<br/>
	 * @param pDateNaissance : LocalDate : date de naissance.<br/>
	 */
	public ContactSimpleModelObs(
			final Long pId
				, final String pPrenom
					, final String pNom
			, final String pRue
				, final String pCodePostal
					, final String pVille
			, final LocalDate pDateNaissance) {

		super();
		
		this.id = new SimpleStringProperty(String.valueOf(pId));
		this.prenom = new SimpleStringProperty(pPrenom);
		this.nom = new SimpleStringProperty(pNom);
		this.rue = new SimpleStringProperty(pRue);
		this.codePostal = new SimpleStringProperty(pCodePostal);
		this.ville = new SimpleStringProperty(pVille);
		this.dateNaissance = new SimpleObjectProperty<LocalDate>(pDateNaissance);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE MODEL.___________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ContactSimpleModelObs(
	 * IContactSimple pPersonne) :<br/>
	 * CONSTRUCTEUR LIEN.<br/>
	 * Fait le lien entre un 
	 * <b>model.metier.personne.impl.Personne</b> 
	 * et le présent ContactSimpleModelObs.<br/>
	 * <br/>
	 *
	 * @param pContactSimple : model.metier.personne.IPersonne.<br/>
	 */
	public ContactSimpleModelObs(
			final IContactSimple pContactSimple) {
		
		super();
		
		if (pContactSimple != null) {
			
			this.id 
			= new SimpleStringProperty(String.valueOf(
					pContactSimple.getId()));
			this.prenom 
			= new SimpleStringProperty(pContactSimple.getPrenom());
			this.nom 
			= new SimpleStringProperty(pContactSimple.getNom());
			this.rue 
			= new SimpleStringProperty(pContactSimple.getRue());
			this.codePostal 
			= new SimpleStringProperty(pContactSimple.getCodePostal());
			this.ville 
			= new SimpleStringProperty(pContactSimple.getVille());
			this.dateNaissance 
			= new SimpleObjectProperty<LocalDate>(
					pContactSimple.getDateNaissance());
			
		} else {
			
			this.id = null;
			this.prenom = null;
			this.nom = null;
			this.rue = null;
			this.codePostal = null;
			this.ville = null;
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

		final ContactSimpleModelObs clone = (ContactSimpleModelObs) super.clone();
		
		clone.id.set(this.id.get());
		clone.prenom.set(this.prenom.get());
		clone.nom.set(this.nom.get());
		clone.rue.set(this.rue.get());
		clone.codePostal.set(this.codePostal.get());
		clone.ville.set(this.ville.get());
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
		
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(", ");
		}
		if (this.prenom != null) {
			builder.append("prenom=");
			builder.append(this.prenom);
			builder.append(", ");
		}
		if (this.nom != null) {
			builder.append("nom=");
			builder.append(this.nom);
			builder.append(", ");
		}
		if (this.rue != null) {
			builder.append("rue=");
			builder.append(this.rue);
			builder.append(", ");
		}
		if (this.codePostal != null) {
			builder.append("codePostal=");
			builder.append(this.codePostal);
			builder.append(", ");
		}
		if (this.ville != null) {
			builder.append("ville=");
			builder.append(this.ville);
			builder.append(", ");
		}
		if (this.dateNaissance != null) {
			builder.append("dateNaissance=");
			builder.append(this.dateNaissance);
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
	} // Fini de getIdProperty().__________________________________________


		
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
