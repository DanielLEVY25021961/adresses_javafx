package levy.daniel.application.model.dto.metier.contactsimple;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.contactsimple.impl.ContactSimpleDTO;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;

/**
 * CLASSE ContactSimpleConvertisseurMetierDTO :<br/>
 * classe <b>utilitaire</b> chargée de <b>convertir 
 * un DTO en OBJET METIER</b> et de <b>convertir un
 * OBJET METIER en DTO</b>.<br/>
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
 * @since 28 déc. 2018
 *
 */
public final class ContactSimpleConvertisseurMetierDTO {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleConvertisseurMetierDTO.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	private ContactSimpleConvertisseurMetierDTO() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * <b>convertit un DTO en OBJET METIER</b>.<br/>
	 * <ul>
	 * <li>retourne null si pDTO == null.</li>
	 * <li>récupère les valeurs String dans le DTO.</li>
	 * <li>convertit les String du DTO en types de l'Objet métier.</li>
	 * <li>injecte les valeurs typées dans un OBJET METIER 
	 * et le retourne.</li>
	 * <li>accepte les formats [dd MMMM yyyy][dd/MM/yyyy][yyyy-MM-dd]
	 * [yyyy-MMM-dd] pour le parse des dates</li>
	 * </ul>
	 *
	 * @param pDTO : IContactSimpleDTO.<br/>
	 * 
	 * @return : IContactSimple : Objet métier.<br/>
	 */
	public static IContactSimple convertirDTOEnObjetMetier(
			final IContactSimpleDTO pDTO) {
		
		synchronized (ContactSimpleConvertisseurMetierDTO.class) {
			
			IContactSimple resultat = null;
			
			if (pDTO != null) {
				
				/* récupère les valeurs String dans le DTO. */
				final String idString = pDTO.getIdString();
				final String prenomString = pDTO.getPrenomString();
				final String nomString = pDTO.getNomString();
				final String rueString = pDTO.getRueString();
				final String rue2String = pDTO.getRue2String();
				final String codePostalString = pDTO.getCodePostalString();
				final String villeString = pDTO.getVilleString();
				final String paysString = pDTO.getPaysString();
				final String telephoneString = pDTO.getTelephoneString();
				final String mailString = pDTO.getMailString();
				final String dateNaissanceString 
					= pDTO.getDateNaissanceString();
				
				/* convertit les String du DTO en types de l'Objet métier. */
				Long id = null;
				
				if (!StringUtils.isBlank(idString)) {
					try {
						id = Long.valueOf(idString);
					} catch (NumberFormatException e) {
						id = null;
					}
				}
				
				final String prenom = prenomString;
				final String nom = nomString;
				final String rue = rueString;
				final String rue2 = rue2String;
				final String codePostal = codePostalString;
				final String ville = villeString;
				final String pays = paysString;
				final String telephone = telephoneString;
				final String mail = mailString;
				LocalDate dateNaissance = null;
				
				if (!StringUtils.isBlank(dateNaissanceString)) {
					dateNaissance = fournirLocalDate(dateNaissanceString);					
				}
				
				/* injecte les valeurs typées dans un OBJET METIER. */
				resultat 
					= new ContactSimple(
							id
							, prenom, nom
							, rue, rue2
							, codePostal, ville, pays
							, telephone, mail
							, dateNaissance);
			}
			
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirDTOEnObjetMetier(...).____________________________
	

	
	/**
	 * <b>convertit un OBJET METIER en DTO</b>.<br/>
	 * <ul>
	 * <li>retourne null si pObject == null.</li>
	 * <li>récupère les valeurs typées dans l'objet métier.</li>
	 * <li>convertit les types de l'Objet métier en String du DTO.</li>
	 * <li>injecte les valeurs String dans un DTO 
	 * et le retourne.</li>
	 * <li>formate les LocalDate au format "dd MMMM yyyy" 
	 * (12 février 1962).</li>
	 * </ul>
	 *
	 * @param pObject : IContactSimple : 
	 * Objet métier.<br/>
	 * 
	 * @return : IContactSimpleDTO : DTO.<br/>
	 */
	public static IContactSimpleDTO convertirObjetMetierEnDTO(
			final IContactSimple pObject) {
		
		synchronized (ContactSimpleConvertisseurMetierDTO.class) {
			
			IContactSimpleDTO resultat = null;
			
			if (pObject != null) {
				
				/* 12 février 1962. */
				final DateTimeFormatter dateFormatterAffichage 
					= DateTimeFormatter.ofPattern("dd MMMM yyyy")
						.withLocale(Locale.getDefault());
				
				/* récupère les valeurs typées dans l'objet métier. */
				final Long id = pObject.getId();
				final String nom = pObject.getNom();
				final String prenom = pObject.getPrenom();
				final String rue = pObject.getRue();
				final String rue2 = pObject.getRue2();
				final String codePostal = pObject.getCodePostal();
				final String ville = pObject.getVille();
				final String pays = pObject.getPays();
				final String telephone = pObject.getTelephone();
				final String mail = pObject.getMail();
				final LocalDate dateNaissance = pObject.getDateNaissance();
				
				/* convertit les types de l'Objet métier en String du DTO. */
				final String idString = String.valueOf(id);
				final String nomString = nom;
				final String prenomString = prenom;
				final String rueString = rue;
				final String rue2String = rue2;
				final String codePostalString = codePostal;
				final String villeString = ville;
				final String paysString = pays;
				final String telephoneString = telephone;
				final String mailString = mail;
				String dateNaissanceString = null;
				
				if (dateNaissance != null) {
					dateNaissanceString 
						= dateFormatterAffichage.format(dateNaissance);
				} 
				
				/* injecte les valeurs String dans un DTO. */
				resultat 
					= new ContactSimpleDTO(
							idString
							, prenomString, nomString
							, rueString
							, rue2String
							, codePostalString, villeString
							, paysString
							, telephoneString, mailString
							, dateNaissanceString);
				
			}
						
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirObjetMetierEnDTO(...).____________________________
	
	
	
	/**
	 * <b>Instancie et retourne une LocalDate à partir d'une String 
	 * SAISIE soit <br/>
	 * - sous la forme "dd MMMM yyyy" comme 12 février 1962,<br/>
	 * - soit sous la forme "dd/MM/yyyy" comme 12/02/1962,<br/>
	 * - soit sous la forme ISO "yyyy-MMM-dd" comme 1962-02-12</b>.<br/>
	 * <ul>
	 * <li>Par exemple, <code>fournirLocalDate("05/01/1976")</code> 
	 * retourne une LocalDate située le 05 janvier 1976.</li>
	 * <li>utilise <code>dateFormatterSaisie.<b>parse</b>(pString
	 * , LocalDate::from);</code></li>
	 * <li>essaie d'abord avec le format d'affichage 12 février 1962.</li>
	 * <li>essaie ensuite avec le format d'affichage 12/02/1962.</li>
	 * <li>essaie finalement avec le format d'affichage ISO 1962-02-12.</li>
	 * <li>retourne null si pString n'est conforme à aucun de ces formats.</li>
	 * </ul>
	 * - retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String : 
	 * date sous forme de String au format "dd MMMM yyyy"
	 * , "dd/MM/yyyy" ou ISO "yyyy-MMM-dd".<br/>
	 * 
	 * @return : LocalDate.<br/>
	 */
	private static LocalDate fournirLocalDate(
							final String pString) {
		
		synchronized (ContactSimpleConvertisseurMetierDTO.class) {
			
			/* retourne null si pString est blank. */
			if (StringUtils.isBlank(pString)) {
				return null;
			}

			/* 12 février 1962. */
			final DateTimeFormatter dateFormatterAffichage 
				= DateTimeFormatter.ofPattern("dd MMMM yyyy")
					.withLocale(Locale.getDefault());
			
			/* 12/02/1962. */
			final DateTimeFormatter dateFormatterSaisie 
			= DateTimeFormatter.ofPattern("dd/MM/yyyy")
				.withLocale(Locale.getDefault());
			
			/* 1962-02-12. */
			final DateTimeFormatter dateFormatterIso 
				= DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy-MMM-dd]")
					.withLocale(Locale.getDefault());
						
			LocalDate resultat = null;
			
			/* essaie d'abord avec le format d'affichage 12 février 1962. */
			try {
				
				resultat 
					= dateFormatterAffichage.parse(pString, LocalDate::from);
				
			} catch (Exception e) {
				
				/* essaie ensuite avec le format d'affichage 12/02/1962. */			
				try {
					
					resultat 
						= dateFormatterSaisie.parse(pString, LocalDate::from);
					
				} catch (Exception e1) {
					
					/* essaie finalement avec le format d'affichage 
					 * ISO 1962-02-12. */			
					try {
						resultat 
						= dateFormatterIso.parse(pString, LocalDate::from);
					} catch (Exception e2) {
						
						/* retourne null si pString n'est conforme 
						 * à aucun de ces formats. */
						return null;
					}
				}
			}
			
			return resultat;
						
		} // Fin de synchronized._______________________
		
	} // Fin de fournirLocalDate(...)._____________________________________
	
	
	
} // FIN DE LA CLASSE ContactSimpleConvertisseurMetierDTO.-------------------
