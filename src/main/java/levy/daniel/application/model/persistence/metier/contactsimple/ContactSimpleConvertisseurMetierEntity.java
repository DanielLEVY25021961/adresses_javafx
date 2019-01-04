package levy.daniel.application.model.persistence.metier.contactsimple;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jpa.ContactSimpleEntityJPA;

/**
 * CLASSE ContactSimpleConvertisseurMetierEntity :<br/>
 * classe <b>utilitaire</b> chargée de <b>convertir 
 * une ENTITY en OBJET METIER</b> et de <b>convertir un
 * OBJET METIER en ENTITY</b>.<br/>
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
public final class ContactSimpleConvertisseurMetierEntity {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleConvertisseurMetierEntity.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	private ContactSimpleConvertisseurMetierEntity() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * <b>convertit une ENTITY JPA en OBJET METIER</b>.<br/>
	 * <ul>
	 * <li>retourne null si pEntity == null.</li>
	 * <li>récupère les valeurs dans le pEntity.</li>
	 * <li>injecte les valeurs de l'ENTITY dans un OBJET METIER.</li>
	 * </ul>
	 *
	 * @param pEntity : ContactSimpleEntityJPA.<br/>
	 * 
	 * @return : IContactSimple : Objet métier.<br/>
	 */
	public static IContactSimple convertirEntityJPAEnObjetMetier(
			final ContactSimpleEntityJPA pEntity) {
		
		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			IContactSimple resultat = null;
			
			if (pEntity != null) {
				
				/* récupère les valeurs dans l'Entity. */
				/* injecte les valeurs typées dans un OBJET METIER. */
				resultat 
					= new ContactSimple(
							pEntity.getId()
							, pEntity.getPrenom(), pEntity.getNom()
							, pEntity.getRue(), pEntity.getRue2()
							, pEntity.getCodePostal(), pEntity.getVille()
							, pEntity.getPays()
							, pEntity.getTelephone(), pEntity.getMail()
							, pEntity.getDateNaissance());
			}
			
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirEntityJPAEnObjetMetier(...).______________________
	

	
	/**
	 * <b>convertit un OBJET METIER en ENTITY JPA</b>.<br/>
	 * <ul>
	 * <li>retourne null si pObject == null.</li>
	 * <li>récupère les valeurs typées dans l'objet métier.</li>
	 * <li>injecte les valeurs de l'objet métier dans une ENTITY.</li>
	 * </ul>
	 *
	 * @param pObject : Objet métier.<br/>
	 * 
	 * @return : ContactSimpleEntityJPA : ENTITY JPA.<br/>
	 */
	public static ContactSimpleEntityJPA convertirObjetMetierEnEntityJPA(
			final IContactSimple pObject) {
		
		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			ContactSimpleEntityJPA resultat = null;
			
			if (pObject != null) {
								
				/* injecte les valeurs String dans un DTO. */
				resultat 
					= new ContactSimpleEntityJPA(
							pObject.getId()
							, pObject.getPrenom(), pObject.getNom()
							, pObject.getRue()
							, pObject.getRue2()
							, pObject.getCodePostal(), pObject.getVille()
							, pObject.getPays()
							, pObject.getTelephone(), pObject.getMail()
							, pObject.getDateNaissance());
				
			}
						
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirObjetMetierEnEntityJPA(...).______________________
	
	
	
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
		
		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
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
	
	
	
} // FIN DE LA CLASSE ContactSimpleConvertisseurMetierEntity.----------------
