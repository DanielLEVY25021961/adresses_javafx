package levy.daniel.application.model.dto.metier.contactsimple.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.contactsimple.IContactSimpleDTO;


/**
 * CLASSE ContactSimpleDTO :<br/>
 * CLASSE CONCRETE <b>ContactSimpleDTO</b> sous MODEL/DTO/METIER :<br/>
 * Les DTO ne servent qu'à véhiculer de l'information 
 * entre les couches VUE, CONTROLLER et MODEL.<br/>
 * 
 * <p>
 * <b>ContactSimpleDTO</b> modélise un <i>concept</i> de <b>Contact</b> 
 * (Personne avec des coordonnées) avec un nomString, un prénom et des coordonnées
 * <i>simples</i>.<br/>
 * Un ContactSimpleDTO ne possède qu'une seule adresse, 
 * un seul numéro de téléphone, et un seul mailString.
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
 * <li><b>idString</b> pour la mise en base.</li>
 * <li><b>prenomString</b>.</li>
 * <li><b>nomString</b>.</li>
 * <li><b>rueString</b>.</li>
 * <li><b>rue2String</b>.</li>
 * <li><b>codePostalString</b>.</li>
 * <li><b>villeString</b>.</li>
 * <li><b>paysString</b>.</li>
 * <li><b>telephoneString</b>.</li>
 * <li><b>mailString</b>.</li>
 * <li><b>dateNaissanceString</b>.</li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <ul>
 * <li>L'<b>égalité metier</b> d'un IContactSimple est vérifiée sur :</li>
  * <ul>
 * <li><b>nomString</b> (insensible à la casse).</li>
 * <li><b>prenomString</b> (insensible à la casse).</li>
 * <li><b>dateNaissanceString</b>.</li>
 * </ul>
 * </ul>
 *  
 * <p>
 * <span style="text-decoration: underline;">COMPARAISON</span>
 * </p>
 * <ul>
 * <li>La <b>comparaison</b> d'un IContactSimple est réalisée sur :</li>
  * <ol>
 * <li><b>nomString</b> (insensible à la casse).</li>
 * <li><b>prenomString</b> (insensible à la casse).</li>
 * <li><b>dateNaissanceString</b> (le plus jeune en premier).</li>
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
 * prenomString
 * </td>
 * <td>
 * "RG_NOMMAGE_PRENOM_RENSEIGNE_01
 *  : le prénom du ContactSimpleDTO 
 *  doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_PRENOM_LITTERAL_02
 *  : le prénom du ContactSimpleDTO 
 *  ne doit contenir que des lettres ou des caractères spéciaux 
 *  '-', '_', ... (aucun chiffre)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_PRENOM_LONGUEUR_03
 *  : le prénom du ContactSimpleDTO 
 *  doit contenir entre [1] et [50] lettres"
 * </td>
 * </tr>

 * <tr>
 * <td rowspan="3">
 * nomString
 * </td>
 * <td>
 * "RG_NOMMAGE_NOM_RENSEIGNE_04 : 
 * le nomString du ContactSimpleDTO 
 * doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_NOM_LITTERAL_05 : 
 * le nomString du ContactSimpleDTO 
 * ne doit contenir que des lettres ou des 
 * caractères spéciaux '-', '_', ... (aucun chiffre)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_NOM_LONGUEUR_06 : 
 * le nomString du ContactSimpleDTO 
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
public class ContactSimpleDTO implements IContactSimpleDTO {

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
	 * idString en base.<br/>
	 */
	private String idString;
	
	/**
	 * prenomString.<br/>
	 */
	private String prenomString;

	/**
	 * nomString.<br/>
	 */
	private String nomString;

	/**
	 * rueString.<br/>
	 */
	private String rueString;

	/**
	 * rue2String.<br/>
	 */
	private String rue2String;

	/**
	 * code postal.<br/>
	 */
	private String codePostalString;

	/**
	 * villeString.<br/>
	 */
	private String villeString;

	/**
	 * paysString.
	 */
	private String paysString;
	
	/**
	 * telephoneString.
	 */
	private String telephoneString;
	
	/**
	 * mailString.
	 */
	private String mailString;
	
	/**
	 * date de naissance sous forme de String.<br/>
	 */
	private String dateNaissanceString;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ContactSimpleDTO.class);


	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ContactSimpleDTO() {
		this(null, null, null, null, null, null, null, null, null, null, null);
	} // Fin de ContactSimpleDTO().________________________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pPrenomString : String : prénom.<br/>
	 * @param pNomString : String : nomString.<br/> 
	 * @param pRueString : String : rueString.<br/>
	 * @param pRue2String : String : rue2String.<br/>
	 * @param pCodePostalString : String : code postal.<br/>
	 * @param pVilleString : String : villeString.<br/>
	 * @param pPaysString : String : paysString.<br/>
	 * @param pTelephoneString : String : telephoneString.<br/>
	 * @param pMailString : String : mailString.<br/>
	 * @param pDateNaissanceString : String : 
	 * date de naissance sous forme de String.<br/>
	 */
	public ContactSimpleDTO(
			final String pPrenomString
			, final String pNomString
			, final String pRueString
			, final String pRue2String
				, final String pCodePostalString
					, final String pVilleString
						, final String pPaysString
			, final String pTelephoneString
				, final String pMailString
			, final String pDateNaissanceString) {
		
		this(null
				, pPrenomString, pNomString
				, pRueString, pRue2String
				, pCodePostalString, pVilleString
				, pPaysString
				, pTelephoneString, pMailString
				, pDateNaissanceString);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________

	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 *
	 * @param pIdString : String : idString en base.<br/>
	 * @param pPrenomString : String : prénom.<br/>
	 * @param pNomString : String : nomString.<br/> 
	 * @param pRueString : String : rueString.<br/>
	 * @param pRue2String : String : rue2String.<br/>
	 * @param pCodePostalString : String : code postal.<br/>
	 * @param pVilleString : String : villeString.<br/>
	 * @param pPaysString : String : paysString.<br/>
	 * @param pTelephoneString : String : telephoneString.<br/>
	 * @param pMailString : String : mailString.<br/>
	 * @param pDateNaissanceString : String : 
	 * date de naissance sous forme de String.<br/>
	 */
	public ContactSimpleDTO(
			final String pIdString
				, final String pPrenomString
					, final String pNomString
			, final String pRueString
			, final String pRue2String
				, final String pCodePostalString
					, final String pVilleString
						, final String pPaysString
			, final String pTelephoneString
				, final String pMailString
			, final String pDateNaissanceString) {

		super();
		
		this.idString = pIdString;
		this.prenomString = pPrenomString;
		this.nomString = pNomString;
		this.rueString = pRueString;
		this.rue2String = pRue2String;
		this.codePostalString = pCodePostalString;
		this.villeString = pVilleString;
		this.paysString = pPaysString;
		this.telephoneString = pTelephoneString;
		this.mailString = pMailString;
		this.dateNaissanceString = pDateNaissanceString;
		
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
	public final String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("ContactSimpleDTO [");
		
		builder.append("idString=");
		if (this.idString != null) {			
			builder.append(this.idString);
		} else {
			builder.append(NULL);
		}		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("prenomString=");
		if (this.prenomString != null) {			
			builder.append(this.prenomString);
		} else {
			builder.append(NULL);
		}		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("nomString=");
		if (this.nomString != null) {			
			builder.append(this.nomString);
		} else {
			builder.append(NULL);
		}		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("rueString=");
		if (this.rueString != null) {
			builder.append(this.rueString);
		} else {
			builder.append(NULL);
		}		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("rue2String=");
		if (this.rue2String != null) {
			builder.append(this.rue2String);
		} else {
			builder.append(NULL);
		}		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("codePostalString=");
		if (this.codePostalString != null) {			
			builder.append(this.codePostalString);
		} else {
			builder.append(NULL);
		}		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("villeString=");
		if (this.villeString != null) {			
			builder.append(this.villeString);
		} else {
			builder.append(NULL);
		}		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("paysString=");
		if (this.paysString != null) {			
			builder.append(this.paysString);
		} else {
			builder.append(NULL);
		}		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("telephoneString=");
		if (this.telephoneString != null) {			
			builder.append(this.telephoneString);
		} else {
			builder.append(NULL);
		}		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("mailString=");
		if (this.mailString != null) {			
			builder.append(this.mailString);
		} else {
			builder.append(NULL);
		}		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("dateNaissanceString=");
		if (this.dateNaissanceString != null) {		
			builder.append(this.dateNaissanceString);
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
	public final String getIdString() {	
		return this.idString;
	} // Fin de getIdString()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setIdString(
			final String pIdString) {	
		this.idString = pIdString;
	} // Fin de setIdString(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getPrenomString() {	
		return this.prenomString;
	} // Fin de getPrenomString()._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPrenomString(
			final String pPrenomString) {	
		this.prenomString = pPrenomString;
	} // Fin de setPrenomString(...).______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getNomString() {	
		return this.nomString;
	} // Fin de getNomString().____________________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setNomString(
			final String pNomString) {	
		this.nomString = pNomString;	} // Fin de setNomString(...)._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getRueString() {	
		return this.rueString;
	} // Fin de getRueString().____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRueString(
			final String pRueString) {	
		this.rueString = pRueString;
	} // Fin de setRueString(...)._________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getRue2String() {
		return this.rue2String;
	} // Fin de getRue2String().___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setRue2String(
			final String pRue2String) {
		this.rue2String = pRue2String;
	} // Fin de setRue2String(...).________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getCodePostalString() {	
		return this.codePostalString;
	} // Fin de getCodePostalString()._____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setCodePostalString(
			final String pCodePostalString) {	
		this.codePostalString = pCodePostalString;
	} // Fin de setCodePostalString(...).__________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getVilleString() {	
		return this.villeString;
	} // Fin de getVilleString().__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setVilleString(
			final String pVilleString) {	
		this.villeString = pVilleString;
	} // Fin de setVilleString(...)._______________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getPaysString() {
		return this.paysString;
	} // Fin de getPaysString().___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPaysString(
			final String pPaysString) {
		this.paysString = pPaysString;
	} // Fin de setPaysString(...).________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getTelephoneString() {
		return this.telephoneString;
	} // Fin de getTelephoneString().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setTelephoneString(
			final String pTelephoneString) {
		this.telephoneString = pTelephoneString;
	} // Fin de setTelephoneString(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getMailString() {
		return this.mailString;
	} // Fin de getMailString().___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setMailString(
			final String pMailString) {
		this.mailString = pMailString;
	} // Fin de setMailString(...).________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getDateNaissanceString() {	
		return this.dateNaissanceString;
	} // Fin de getDateNaissanceString().__________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setDateNaissanceString(
			final String pDateNaissanceString) {	
		this.dateNaissanceString = pDateNaissanceString;
	} // Fin de setDateNaissanceString(...)._______________________________
	

	
} // FIN DE LA CLASSE ContactSimpleDTO.--------------------------------------
