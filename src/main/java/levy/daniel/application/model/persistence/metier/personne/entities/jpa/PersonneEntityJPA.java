package levy.daniel.application.model.persistence.metier.personne.entities.jpa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.IPersonne;


/**
 * CLASSE PersonneEntityJPA :<br/>
 * Modelisation metier d'une PersonneEntityJPA.<br/>
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
@Entity(name="PersonneEntityJPA")
@Table(name="PERSONNES", schema="PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_PRENOM_NOM_DATENAISSANCE"
, columnNames={"PRENOM", "NOM", "DATENAISSANCE"})
, indexes={@Index(name="INDEX_NOM_PRENOM", columnList="NOM, PRENOM")})
public class PersonneEntityJPA implements IPersonne {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
	
	/**
	 * id : Long :<br/>
	 * id en base.<br/>
	 */
	private Long id;

	
	/**
	 * prenom : String :<br/>
	 * prenom.<br/>
	 */
	private String prenom;


	/**
	 * nom : String :<br/>
	 * nom.<br/>
	 */
	private String nom;


	/**
	 * rue : String :<br/>
	 * rue.<br/>
	 */
	private String rue;


	/**
	 * codePostal : String :<br/>
	 * code postal.<br/>
	 */
	private String codePostal;


	/**
	 * ville : String :<br/>
	 * ville.<br/>
	 */
	private String ville;


	/**
	 * dateNaissance : LocalDate :<br/>
	 * date de naissance.<br/>
	 */
	private LocalDate dateNaissance;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(PersonneEntityJPA.class);


	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR PersonneEntityJPA() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public PersonneEntityJPA() {
		this(null, null, null, null, null, null, null);
	} // Fin de PersonneEntityJPA().________________________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR PersonneEntityJPA(...) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pPrenom : String : prénom.<br/>
	 * @param pNom : String : nom.<br/> 
	 * @param pRue : String : rue.<br/>
	 * @param pCodePostal : String : code postal.<br/>
	 * @param pVille : String : ville.<br/>
	 * @param pDateNaissance : LocalDate : date de naissance.<br/>
	 */
	public PersonneEntityJPA(
			final String pPrenom
				, final String pNom
			, final String pRue
				, final String pCodePostal
					, final String pVille
			, final LocalDate pDateNaissance) {
		
		this(null
			, pPrenom, pNom, pRue, pCodePostal, pVille, pDateNaissance);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________

	
	
	 /**
	 * method CONSTRUCTEUR PersonneEntityJPA(...) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Long : id en base.<br/>
	 * @param pPrenom : String : prénom.<br/>
	 * @param pNom : String : nom.<br/> 
	 * @param pRue : String : rue.<br/>
	 * @param pCodePostal : String : code postal.<br/>
	 * @param pVille : String : ville.<br/>
	 * @param pDateNaissance : LocalDate : date de naissance.<br/>
	 */
	public PersonneEntityJPA(
			final Long pId
				, final String pPrenom
					, final String pNom
			, final String pRue
				, final String pCodePostal
					, final String pVille
			, final LocalDate pDateNaissance) {

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
	 * method CONSTRUCTEUR PersonneEntityJPA(
	 * IPersonne pPersonne) :<br/>
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * <br/>
	 *
	 * @param pPersonne : IPersonne.<br/>
	 */
	public PersonneEntityJPA(
			final IPersonne pPersonne) {
		
		super();
		
		this.id = pPersonne.getId();
		this.prenom = pPersonne.getPrenom();
		this.nom = pPersonne.getNom();
		this.rue = pPersonne.getRue();
		this.codePostal = pPersonne.getCodePostal();
		this.ville = pPersonne.getVille();
		this.dateNaissance = pPersonne.getDateNaissance();
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR._______________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {

		final int prime = 31;
		int result = 1;
		
		result 
		= prime * result 
		+ ((this.dateNaissance == null) ? 0 : this.dateNaissance.hashCode());
		result 
		= prime * result 
		+ ((this.nom == null) ? 0 : this.nom.hashCode());
		result 
		= prime * result 
		+ ((this.prenom == null) ? 0 : this.prenom.hashCode());
		
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
		if (!(pObjet instanceof PersonneEntityJPA)) {
			return false;
		}
		
		final PersonneEntityJPA other = (PersonneEntityJPA) pObjet;

		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		}
		else if (!this.nom.equals(other.nom)) {
			return false;
		}
		
		if (this.prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		}
		else if (!this.prenom.equals(other.prenom)) {
			return false;
		}
		
		if (this.dateNaissance == null) {
			if (other.dateNaissance != null) {
				return false;
			}
		}
		else if (!this.dateNaissance.equals(other.dateNaissance)) {
			return false;
		}

		return true;
		
	} // Fin de equals(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final IPersonne pObjet) {
		
		if (this == pObjet) {
			return 0;
		}

		if (pObjet == null) {
			return -1;
		}

		int compareNom = 0;
		int comparePrenom = 0;
		int compareDateNaissance = 0;
		
		/* nom. */
		if (this.getNom() == null) {
			if (pObjet.getNom() != null) {
				return +1;
			}
		} else {
			if (pObjet.getNom() == null) {
				return -1;
			}
		}
		
		compareNom 
			= this.getNom().compareToIgnoreCase(pObjet.getNom());
		
		if (compareNom != 0) {
			return compareNom;
		}
		
		/* prenom. */
		if (this.getPrenom() == null) {
			if (pObjet.getPrenom() != null) {
				return +1;
			}
		} else {
			if (pObjet.getPrenom() == null) {
				return -1;
			}
		}
		
		comparePrenom 
			= this.getPrenom().compareToIgnoreCase(pObjet.getPrenom());
		
		if (comparePrenom != 0) {
			return comparePrenom;
		}
		
		/* dateNaissance. */
		if (this.getDateNaissance() == null) {
			if (pObjet.getDateNaissance() != null) {
				return +1;
			}
			
			return 0;
		}
		if (pObjet.getDateNaissance() == null) {
			return -1;
		}
		
		compareDateNaissance 
			= this.dateNaissance.compareTo(pObjet.getDateNaissance());
		
		return compareDateNaissance;
		
	} // Fin de compareTo(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final PersonneEntityJPA clone() throws CloneNotSupportedException {
		
		final IPersonne personneClone = (IPersonne) super.clone();
		
		/* Clonage profond de la date. */
		final LocalDate dateNaissanceClone 
			= LocalDate.from(this.dateNaissance);
		
		personneClone.setId(this.getId());
		personneClone.setNom(this.getNom());
		personneClone.setPrenom(this.getPrenom());
		personneClone.setRue(this.getRue());
		personneClone.setCodePostal(this.getCodePostal());
		personneClone.setVille(this.getVille());
		personneClone.setDateNaissance(dateNaissanceClone);
		
		return (PersonneEntityJPA) personneClone;
		
	} // Fin de clone().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {

		final StringBuilder builder = new StringBuilder();
		
		final DateTimeFormatter formatter 
			= DateTimeFormatter.ofPattern("dd MMMM yyyy");
		
		builder.append("PersonneEntityJPA [");
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
			builder.append(formatter.format(this.dateNaissance));
		}
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public final String fournirEnTeteCsv() {
		return "id;nom;prénom;rue;code postal;ville;date de naissance;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirStringCsv() {
		
		final StringBuilder stb = new StringBuilder();

		final DateTimeFormatter formatter 
			= DateTimeFormatter.ofPattern("dd MMM yyyy");

		stb.append(this.getId());
		stb.append(POINT_VIRGULE);
		stb.append(this.getNom());
		stb.append(POINT_VIRGULE);
		stb.append(this.getPrenom());
		stb.append(POINT_VIRGULE);
		stb.append(this.getRue());
		stb.append(POINT_VIRGULE);
		stb.append(this.getCodePostal());
		stb.append(POINT_VIRGULE);
		stb.append(this.getVille());
		stb.append(POINT_VIRGULE);
		stb.append(formatter.format(this.getDateNaissance()));
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Transient
	@Override
	public final String fournirEnTeteColonne(
			final int pI) {
		
		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "nom";
			break;

		case 2:
			entete = "prénom";
			break;

		case 3:
			entete = "rue";
			break;
			
		case 4:
			entete = "code postal";
			break;
			
		case 5:
			entete = "ville";
			break;
			
		case 6:
			entete = "date de naissance";
			break;
			
		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object fournirValeurColonne(
			final int pI) {
		
		Object valeur = null;

		final DateTimeFormatter formatter 
			= DateTimeFormatter.ofPattern("dd MMM yyyy");

		switch (pI) {

		case 0:
			valeur = this.getId();
			break;

		case 1:
			valeur = this.getNom();
			break;

		case 2:
			valeur = this.getPrenom();
			break;

		case 3:
			valeur = this.getRue();
			break;
			
		case 4:
			valeur = this.getCodePostal();
			break;
			
		case 5:
			valeur = this.getVille();
			break;
			
		case 6:
			valeur = formatter.format(this.getDateNaissance());
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de getValeurColonne(...)._____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	@Override
	public Long getId() {	
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {	
		this.id = pId;
	} // Fin de setId(...).________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="PRENOM"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	@Override
	public String getPrenom() {	
		return this.prenom;
	} // Fin de getPrenom()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPrenom(
			final String pPrenom) {	
		this.prenom = pPrenom;
	} // Fin de setPrenom(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="NOM"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	@Override
	public String getNom() {	
		return this.nom;
	} // Fin de getNom().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNom(
			final String pNom) {	
		this.nom = pNom;
	} // Fin de setNom(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="RUE"
			, unique = false, updatable = true
			, insertable = true, nullable = true)
	@Override
	public String getRue() {	
		return this.rue;
	} // Fin de getRue().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRue(
			final String pRue) {	
		this.rue = pRue;
	} // Fin de setRue(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="CODEPOSTAL"
			, unique = false, updatable = true
			, insertable = true, nullable = true)
	@Override
	public String getCodePostal() {	
		return this.codePostal;
	} // Fin de getCodePostal().___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCodePostal(
			final String pCodePostal) {	
		this.codePostal = pCodePostal;
	} // Fin de setCodePostal(...).________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="VILLE"
			, unique = false, updatable = true
			, insertable = true, nullable = true)
	@Override
	public String getVille() {	
		return this.ville;
	} // Fin de getVille().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setVille(
			final String pVille) {	
		this.ville = pVille;
	} // Fin de setVille(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name="DATENAISSANCE"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	@Override
	public LocalDate getDateNaissance() {	
		return this.dateNaissance;
	} // Fin de getDateNaissance().________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDateNaissance(
			final LocalDate pDateNaissance) {	
		this.dateNaissance = pDateNaissance;
	} // Fin de setDateNaissance(...)._____________________________________
	

	
} // FIN DE LA CLASSE PersonneEntityJPA.----------------------------------------------
