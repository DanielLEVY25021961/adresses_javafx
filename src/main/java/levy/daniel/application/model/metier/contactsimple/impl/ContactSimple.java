package levy.daniel.application.model.metier.contactsimple.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;


/**
 * CLASSE ContactSimple :<br/>
 * CLASSE CONCRETE <b>ContactSimple</b> sous MODEL/METIER :<br/>
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
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * HERITE de :
 * </span>
 * </p>
 * <li><b>IContactSimple</b></li>
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
 * <img src="../../../../../../../../../../javadoc/images/model/metier/contactsimple/diagramme_classes_contactsimple.png" 
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
 * d'un ICountry sont les suivantes :
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
 * parser une String pour LocalDate, <br/>
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
public class ContactSimple implements IContactSimple {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
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
	 * id en base.<br/>
	 */
	private Long id;
	
	/**
	 * prenom.<br/>
	 */
	private String prenom;

	/**
	 * nom.<br/>
	 */
	private String nom;

	/**
	 * rue.<br/>
	 */
	private String rue;

	/**
	 * rue2.<br/>
	 */
	private String rue2;

	/**
	 * code postal.<br/>
	 */
	private String codePostal;

	/**
	 * ville.<br/>
	 */
	private String ville;

	/**
	 * pays.
	 */
	private String pays;
	
	/**
	 * telephone.
	 */
	private String telephone;
	
	/**
	 * mail.
	 */
	private String mail;
	
	/**
	 * date de naissance.<br/>
	 */
	private LocalDate dateNaissance;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ContactSimple.class);


	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ContactSimple() {
		this(null, null, null, null, null, null, null, null, null, null, null);
	} // Fin de ContactSimple().________________________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pPrenom : String : prénom.<br/>
	 * @param pNom : String : nom.<br/> 
	 * @param pRue : String : rue.<br/>
	 * @param pRue2 : String : rue2.<br/>
	 * @param pCodePostal : String : code postal.<br/>
	 * @param pVille : String : ville.<br/>
	 * @param pPays : String : pays.<br/>
	 * @param pTelephone : String : telephone.<br/>
	 * @param pMail : String : mail.<br/>
	 * @param pDateNaissance : LocalDate : date de naissance.<br/>
	 */
	public ContactSimple(
			final String pPrenom
				, final String pNom
			, final String pRue
			, final String pRue2
				, final String pCodePostal
					, final String pVille
						, final String pPays
			, final String pTelephone
				, final String pMail
			, final LocalDate pDateNaissance) {
		
		this(null
			, pPrenom, pNom
			, pRue, pRue2, pCodePostal, pVille, pPays
			, pTelephone, pMail
			, pDateNaissance);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________

	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pId : Long : id en base.<br/>
	 * @param pPrenom : String : prénom.<br/>
	 * @param pNom : String : nom.<br/> 
	 * @param pRue : String : rue.<br/>
	 * @param pRue2 : String : rue2.<br/>
	 * @param pCodePostal : String : code postal.<br/>
	 * @param pVille : String : ville.<br/>
	 * @param pPays : String : pays.<br/>
	 * @param pTelephone : String : telephone.<br/>
	 * @param pMail : String : mail.<br/>
	 * @param pDateNaissance : LocalDate : date de naissance.<br/>
	 */
	public ContactSimple(
			final Long pId
				, final String pPrenom
					, final String pNom
			, final String pRue
			, final String pRue2
				, final String pCodePostal
					, final String pVille
						, final String pPays
			, final String pTelephone
				, final String pMail
			, final LocalDate pDateNaissance) {

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
	 * <b>Instancie et retourne une LocalDate à partir d'une String 
	 * SAISIE sous la forme "dd/MM/yyyy"</b>.<br/>
	 * <ul>
	 * <li>Par exemple, <code>fournirLocalDate("05/01/1976")</code> 
	 * retourne une LocalDate située le 05 janvier 1976.</li>
	 * <li>utilise <code>dateFormatterSaisie.<b>parse</b>(pString
	 * , LocalDate::from);</code></li>
	 * <li>vérifie que pString est au format "23/07/1972" 
	 * (format REGEX "^\\d{2}/\\d{2}/\\d{4}").<br/>
	 * retourne null si ce n'est pas le cas.</li>
	 * </ul>
	 * - retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String : 
	 * String au format "05/01/1976" ou "19/02/1961".<br/>
	 * 
	 * @return : LocalDate.<br/>
	 */
	private LocalDate fournirLocalDate(
			final String pString) {
		
		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		final DateTimeFormatter dateFormatterSaisie 
			= DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
		/* motif REGEX d'une date sous la forme 05/01/1976. */
		final String motifRegex = "^\\d{2}/\\d{2}/\\d{4}";
		final Pattern pattern = Pattern.compile(motifRegex);
		final Matcher matcher = pattern.matcher(pString);
		
		LocalDate resultat = null;
		
		/* vérifie que pString est au format "23/07/1972" 
		 * (format REGEX "^\\d{2}/\\d{2}/\\d{4}"). */
		if (matcher.matches()) {
			
			/* instancie une LocalDate à partir d'une String 
			 * sous la forme 05/01/1976. */
			resultat = dateFormatterSaisie.parse(pString, LocalDate::from);
						
			return resultat;
		}

		return null;
		
	} // Fin de fournirLocalDate(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {

		final int prime = 31;
		int result = 1;
		
		result 
			= prime * result 
				+ ((this.nom == null) ? 0 : this.nom.hashCode());
		result 
			= prime * result 
				+ ((this.prenom == null) ? 0 : this.prenom.hashCode());
		result 
			= prime * result 
		+ ((this.dateNaissance == null) ? 0 : this.dateNaissance.hashCode());
		
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
		if (!(pObjet instanceof IContactSimple)) {
			return false;
		}
		
		final IContactSimple other = (IContactSimple) pObjet;

		/* nom. */
		if (this.getNom() == null) {
			if (other.getNom() != null) {
				return false;
			}
		}
		else if (!this.getNom().equalsIgnoreCase(other.getNom())) {
			return false;
		}
		
		/* prenom. */
		if (this.getPrenom() == null) {
			if (other.getPrenom() != null) {
				return false;
			}
		}
		else if (!this.getPrenom().equalsIgnoreCase(other.getPrenom())) {
			return false;
		}
		
		/* date de naissance. */
		if (this.getDateNaissance() == null) {
			if (other.getDateNaissance() != null) {
				return false;
			}
		}
		else if (!this.getDateNaissance()
					.equals(other.getDateNaissance())) {
			return false;
		}

		return true;
		
	} // Fin de equals(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final IContactSimple pObjet) {
		
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
			
			compareNom 
			= this.getNom().compareToIgnoreCase(pObjet.getNom());
		
			if (compareNom != 0) {
				return compareNom;
			}
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
			
			comparePrenom 
			= this.getPrenom().compareToIgnoreCase(pObjet.getPrenom());
		
			if (comparePrenom != 0) {
				return comparePrenom;
			}
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
			= this.getDateNaissance().compareTo(pObjet.getDateNaissance());
		
		return compareDateNaissance;
		
	} // Fin de compareTo(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ContactSimple clone() throws CloneNotSupportedException {
		
		final IContactSimple contactSimpleClone = (IContactSimple) super.clone();
		
		/* Clonage profond de la date. */
		LocalDate dateNaissanceClone = null;
		
		if (this.dateNaissance != null) {
			dateNaissanceClone 
				= LocalDate.from(this.dateNaissance);
		}
		
		contactSimpleClone.setId(this.getId());
		contactSimpleClone.setNom(this.getNom());
		contactSimpleClone.setPrenom(this.getPrenom());
		contactSimpleClone.setRue(this.getRue());
		contactSimpleClone.setRue2(this.getRue2());
		contactSimpleClone.setCodePostal(this.getCodePostal());
		contactSimpleClone.setVille(this.getVille());
		contactSimpleClone.setPays(this.getPays());
		contactSimpleClone.setTelephone(this.getTelephone());
		contactSimpleClone.setMail(this.getMail());
		contactSimpleClone.setDateNaissance(dateNaissanceClone);
		
		return (ContactSimple) contactSimpleClone;
		
	} // Fin de clone().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {

		final StringBuilder builder = new StringBuilder();
		
		final DateTimeFormatter formatter 
			= DateTimeFormatter.ofPattern("dd MMMM yyyy");
		
		builder.append("ContactSimple [");
		
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
			builder.append(formatter.format(this.dateNaissance));
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
	public final String fournirEnTeteCsv() {
		return "id;nom;prenom;rue;rue2;codePostal;ville;pays;téléphone;mail;dateNaissance;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirStringCsv() {
		
		final StringBuilder stb = new StringBuilder();

		final DateTimeFormatter formatter 
			= DateTimeFormatter.ofPattern("dd MMMM yyyy");

		stb.append(this.getId());
		stb.append(POINT_VIRGULE);
		stb.append(this.getNom());
		stb.append(POINT_VIRGULE);
		stb.append(this.getPrenom());
		stb.append(POINT_VIRGULE);
		stb.append(this.getRue());
		stb.append(POINT_VIRGULE);
		stb.append(this.getRue2());
		stb.append(POINT_VIRGULE);
		stb.append(this.getCodePostal());
		stb.append(POINT_VIRGULE);
		stb.append(this.getVille());
		stb.append(POINT_VIRGULE);
		stb.append(this.getPays());
		stb.append(POINT_VIRGULE);
		stb.append(this.getTelephone());
		stb.append(POINT_VIRGULE);
		stb.append(this.getMail());
		stb.append(POINT_VIRGULE);
		if (this.getDateNaissance() != null) {
			stb.append(formatter.format(this.getDateNaissance()));
		} else {
			stb.append(NULL);
		}		
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
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
			entete = "rue2";
			break;
			
		case 5:
			entete = "code postal";
			break;
			
		case 6:
			entete = "ville";
			break;
			
		case 7:
			entete = "pays";
			break;
			
		case 8:
			entete = "telephone";
			break;
			
		case 9:
			entete = "mail";
			break;
			
		case 10:
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
			= DateTimeFormatter.ofPattern("dd MMMM yyyy");

		switch (pI) {

		case 0:
			if (this.getId() != null) {
				valeur = String.valueOf(this.getId());
			}
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
			valeur = this.getRue2();
			break;
			
		case 5:
			valeur = this.getCodePostal();
			break;
			
		case 6:
			valeur = this.getVille();
			break;
			
		case 7:
			valeur = this.getPays();
			break;
			
		case 8:
			valeur = this.getTelephone();
			break;
			
		case 9:
			valeur = this.getMail();
			break;
			
		case 10:
			if (this.getDateNaissance() != null) {
				valeur = formatter.format(this.getDateNaissance());
			}			
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
	@Override
	public String getRue2() {
		return this.rue2;
	} // Fin de getRue2()._________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRue2(
			final String pRue2) {
		this.rue2 = pRue2;
	} // Fin de setRue2(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
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
	@Override
	public String getPays() {
		return this.pays;
	} // Fin de getPays()._________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPays(
			final String pPays) {
		this.pays = pPays;
	} // Fin de setPays(...).______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTelephone() {
		return this.telephone;
	} // Fin de getTelephone().____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setTelephone(
			final String pTelephone) {
		this.telephone = pTelephone;
	} // Fin de setTelephone(...)._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getMail() {
		return this.mail;
	} // Fin de getMail()._________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMail(
			final String pMail) {
		this.mail = pMail;
	} // Fin de setMail(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
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
	

	
} // FIN DE LA CLASSE ContactSimple.-----------------------------------------
