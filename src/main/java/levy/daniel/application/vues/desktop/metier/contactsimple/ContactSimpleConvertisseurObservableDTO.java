package levy.daniel.application.vues.desktop.metier.contactsimple;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import levy.daniel.application.model.dto.metier.contactsimple.IContactSimpleDTO;
import levy.daniel.application.model.dto.metier.contactsimple.impl.ContactSimpleDTO;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.impl.ContactSimpleModelObs;

/**
 * CLASSE ContactSimpleConvertisseurObservableDTO :<br/>
 * .<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 27 déc. 2018
 *
 */
public final class ContactSimpleConvertisseurObservableDTO {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleConvertisseurObservableDTO.class);

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	private ContactSimpleConvertisseurObservableDTO() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * <b>convertit un DTO en OBSERVABLE</b>.<br/>
	 * <ul>
	 * <li>retourne null si pDTO == null.</li>
	 * <li>transforme une <code>String</code> en 
	 * OBSERVABLE <code>StringProperty</code> 
	 * à l'aide de <code>new SimpleStringProperty(String)</code>.</li>
	 * <li>transforme une <code>String</code> en <code>LocalDate</code> 
	 * à l'aide de <code>formatter.<b>parse</b>(pString
	 * , LocalDate::from);</code></li>
	 * <li>transforme une <code>String</code> en 
	 * OBSERVABLE <code>ObjectProperty&lt;LocalDate&gt;</code> 
	 * à l'aide de 
	 * <code>new SimpleObjectProperty&lt;LocalDate&gt;(LocalDate)</code>.</li>
	 * </ul>
	 *
	 * @param pDTO : IContactSimpleDTO.<br/>
	 * 
	 * @return : IContactSimpleModelObs : OBSERVABLE.<br/>
	 */
	public static IContactSimpleModelObs convertirDTOEnObservable(
										final IContactSimpleDTO pDTO) {
		
		synchronized (ContactSimpleConvertisseurObservableDTO.class) {
			
			IContactSimpleModelObs resultat = null;
			
			if (pDTO != null) {
				
				/* récupération de la date 
				 * sous forme de String dans le DTO. */
				final String localDateDTOString 
					= pDTO.getDateNaissanceString();
				
				LocalDate localDateDTO = null;
				
				if (!StringUtils.isBlank(localDateDTOString)) {
					
					/* instanciation d'une LocalDate 
					 * à l'aide d'un parseur. */
					localDateDTO 
						= fournirLocalDate(localDateDTOString);
				}
				
				
				/* Instanciation des StringProperty 
				 * à partir des String. */
				final StringProperty idStringProperty 
					= new SimpleStringProperty(pDTO.getIdString());
				final StringProperty prenomStringProperty 
					= new SimpleStringProperty(pDTO.getPrenomString());
				final StringProperty nomStringProperty 
					= new SimpleStringProperty(pDTO.getNomString());
				final StringProperty rueStringProperty 
					= new SimpleStringProperty(pDTO.getRueString());
				final StringProperty rue2StringProperty 
					= new SimpleStringProperty(pDTO.getRue2String());
				final StringProperty codePostalStringProperty 
					= new SimpleStringProperty(pDTO.getCodePostalString());
				final StringProperty villeStringProperty 
					= new SimpleStringProperty(pDTO.getVilleString());
				final StringProperty paysStringProperty 
					= new SimpleStringProperty(pDTO.getPaysString());
				final StringProperty telephoneStringProperty 
					= new SimpleStringProperty(pDTO.getTelephoneString());
				final StringProperty mailStringProperty 
					= new SimpleStringProperty(pDTO.getMailString());
				final ObjectProperty<LocalDate> dateNaissanceStringProperty 
					= new SimpleObjectProperty<LocalDate>(localDateDTO);
				
				resultat 
					= new ContactSimpleModelObs(idStringProperty
							, prenomStringProperty, nomStringProperty
							, rueStringProperty
							, rue2StringProperty
							, codePostalStringProperty, villeStringProperty
							, paysStringProperty
							, telephoneStringProperty, mailStringProperty
							, dateNaissanceStringProperty);
				
			}
			
			/* retourne null si pDTO == null. */
			return resultat;
			
		} // Fin de synchronized._______________________________________
		
	} // Fin de convertirDTOEnObservable(...)._____________________________
	

	
	/**
	 * <b>convertit un OBSERVABLE en DTO</b>.<br/>
	 * <ul>
	 * <li>retourne null si pObservable == null.</li>
	 * <li>récupère les valeurs dans les Properties de l'OBSERVABLE.</li>
	 * <li>instancie un DTO avec les valeurs dans l'OBSERVABLE.</li>
	 * </ul>
	 *
	 * @param pObservable : IContactSimpleModelObs.<br/>
	 * 
	 * @return : IContactSimpleDTO.<br/>
	 */
	public static IContactSimpleDTO convertirObservableEnDTO(
							final IContactSimpleModelObs pObservable) {
		
		synchronized (ContactSimpleConvertisseurObservableDTO.class) {
			
			IContactSimpleDTO resultat = null;
			
			final DateTimeFormatter dateFormatterAffichage 
				= DateTimeFormatter.ofPattern("dd MMMM yyyy");
			
			if (pObservable != null) {
				
				String localDateString = null;
				
				final LocalDate localDate 
					= pObservable.getDateNaissance();
				
				if (localDate != null) {
					localDateString 
						= dateFormatterAffichage.format(localDate);
				}
				
				/* récupère les valeurs dans les Properties 
				 * de l'OBSERVABLE. */
				final String idString = pObservable.getId();
				final String prenomString = pObservable.getPrenom();
				final String nomString = pObservable.getNom();
				final String rueString = pObservable.getRue();
				final String rue2String = pObservable.getRue2();
				final String codePostalString = pObservable.getCodePostal();
				final String villeString = pObservable.getVille();
				final String paysString = pObservable.getPays();
				final String telephoneString = pObservable.getTelephone();
				final String mailString = pObservable.getMail();
				final String dateNaissanceString = localDateString;
				
				/* instancie un DTO avec les valeurs dans l'OBSERVABLE. */
				resultat 
					= new ContactSimpleDTO(
						idString
						, prenomString, nomString
						, rueString, rue2String
						, codePostalString, villeString
						, paysString
						, telephoneString, mailString
						, dateNaissanceString);
				
			}
			
			/* retourne null si pObservable == null. */
			return resultat;
			
		} // Fin de synchronized._______________________________________
		
	} // Fin de convertirObservableEnDTO(...)._____________________________
	
	
	
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
	private static LocalDate fournirLocalDate(
			final String pString) {

		synchronized (ContactSimpleConvertisseurObservableDTO.class) {
			
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
			

		} // Fin de synchronized._______________________________________
		
	} // Fin de fournirLocalDate(...)._____________________________________

	
	
} // FIN DE LA CLASSE ContactSimpleConvertisseurObservableDTO.---------------
