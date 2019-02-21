package levy.daniel.application.model.persistence.metier.contactsimple;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ContactSimpleEntityJAXB;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ListeContactSimplesEntityJAXB;
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
	 * <b>Crée un OBJET METIER à partir d'une EntityJPA</b>.<br/>
	 * <ul>
	 * <li>retourne un OBJET METIER avec toutes les valeurs 
	 * à null si pEntityJPA == null.</li>
	 * </ul>
	 *
	 * @param pEntityJPA : ContactSimpleEntityJPA.<br/>
	 * 
	 * @return : IContactSimple.<br/>
	 */
	public static IContactSimple creerObjetMetierAPartirEntityJPA(
			final ContactSimpleEntityJPA pEntityJPA) {

		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			final IContactSimple objet 
				= new ContactSimple();
			
			if (pEntityJPA != null) {
				
				objet.setId(pEntityJPA.getId());
				objet.setPrenom(pEntityJPA.getPrenom());
				objet.setNom(pEntityJPA.getNom());
				objet.setRue(pEntityJPA.getRue());
				objet.setRue2(pEntityJPA.getRue2());
				objet.setCodePostal(pEntityJPA.getCodePostal());
				objet.setVille(pEntityJPA.getVille());
				objet.setPays(pEntityJPA.getPays());
				objet.setTelephone(pEntityJPA.getTelephone());
				objet.setMail(pEntityJPA.getMail());
				objet.setDateNaissance(pEntityJPA.getDateNaissance());
				
			}
							
			return objet;
		
		} // Fin de synchronized._______________________
		
	} // Fin de creerObjetMetierAPartirEntityJPA(...)._____________________
	
	
	
	
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
			
			IContactSimple objet = null;
			
			if (pEntity != null) {
				
				/* récupère les valeurs dans l'Entity. */
				/* injecte les valeurs typées dans un OBJET METIER. */
				objet 
					= new ContactSimple(
							pEntity.getId()
							, pEntity.getPrenom(), pEntity.getNom()
							, pEntity.getRue(), pEntity.getRue2()
							, pEntity.getCodePostal(), pEntity.getVille()
							, pEntity.getPays()
							, pEntity.getTelephone(), pEntity.getMail()
							, pEntity.getDateNaissance());
			}
			
			return objet;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirEntityJPAEnObjetMetier(...).______________________
	

	
	/**
	 * convertit une Liste d'ENTITIES JPA 
	 * en liste d'OBJETS METIER.<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;ContactSimpleEntityJPA&gt;.<br/>
	 * 
	 * @return : List&lt;IContactSimple&gt;.<br/>
	 */
	public static List<IContactSimple> convertirListEntitiesJPAEnModel(
			final List<ContactSimpleEntityJPA> pList) {
		
		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			/* retourne null si pList == null. */
			if (pList == null) {
				return null;
			}
			
			final List<IContactSimple> resultat 
				= new ArrayList<IContactSimple>();
			
			for (final ContactSimpleEntityJPA entity : pList) {
				
				if (entity != null) {
					
					final IContactSimple objet 													
						= convertirEntityJPAEnObjetMetier(entity);
					
					resultat.add(objet);
					
				}
			}
			
			return resultat;
			
		} // Fin de synchronized.______________________
		
	} // Fin de convertirListEntitiesJPAEnModel(...).______________________
	
	
		
	/**
	 * <b>crée une ENTITY JPA à partir d'un OBJET METIER</b>.<br/>
	 * <ul>
	 * <li>retourne une Entity JPA avec toutes les valeurs 
	 * à null si pObject == null.</li>
	 * </ul>
	 *
	 * @param pObject : IContactSimple.<br/>
	 *  
	 * @return : ContactSimpleEntityJPA.<br/>
	 */
	public static ContactSimpleEntityJPA creerEntityJPA(
			final IContactSimple pObject) {
		
		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			final ContactSimpleEntityJPA entity 
				= new ContactSimpleEntityJPA();
			
			if (pObject != null) {
				
				entity.setId(pObject.getId());
				entity.setPrenom(pObject.getPrenom());
				entity.setNom(pObject.getNom());
				entity.setRue(pObject.getRue());
				entity.setRue2(pObject.getRue2());
				entity.setCodePostal(pObject.getCodePostal());
				entity.setVille(pObject.getVille());
				entity.setPays(pObject.getPays());
				entity.setTelephone(pObject.getTelephone());
				entity.setMail(pObject.getMail());
				entity.setDateNaissance(pObject.getDateNaissance());
				
			}
			
			return entity;
					
		} // Fin de synchronized.______________________
		
	} // Fin de creerEntityJPA(...)._______________________________________

	
	
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
	 * convertit une Liste d'OBJETS METIER en liste 
	 * d'ENTITIES JPA.<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;
	 * 
	 * @return : List&lt;ContactSimpleEntityJPA&gt;.<br/>
	 */
	public static List<ContactSimpleEntityJPA> convertirListModelEnEntitiesJPA(
			final Iterable<IContactSimple> pList) {
		
		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			/* retourne null si pList == null. */
			if (pList == null) {
				return null;
			}
			
			final List<ContactSimpleEntityJPA> resultat 
				= new ArrayList<ContactSimpleEntityJPA>();
			
			for (final IContactSimple objet : pList) {
				
				if (objet != null) {
					
					final ContactSimpleEntityJPA entity 
						= convertirObjetMetierEnEntityJPA(objet);
					
					resultat.add(entity);
					
				}
			}
			
			return resultat;

		} // Fin de synchronized._______________________
		
	} // Fin de convertirListModelEnEntitiesJPA(...).______________________
	
	
	
	/**
	 * <b>Crée un OBJET METIER à partir d'une EntityJAXB</b>.<br/>
	 * <ul>
	 * <li>retourne un OBJET METIER avec toutes les valeurs 
	 * à null si pObject == null.</li>
	 * </ul>
	 *
	 * @param pEntityJAXB : ContactSimpleEntityJAXB.<br/>
	 * 
	 * @return : IContactSimple.<br/>
	 */
	public static IContactSimple creerObjetMetierAPartirEntityJAXB(
			final ContactSimpleEntityJAXB pEntityJAXB) {
		
		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			final IContactSimple objet 
				= new ContactSimple();
			
			if (pEntityJAXB != null) {
				
				objet.setId(pEntityJAXB.getId());
				objet.setPrenom(pEntityJAXB.getPrenom());
				objet.setNom(pEntityJAXB.getNom());
				objet.setRue(pEntityJAXB.getRue());
				objet.setRue2(pEntityJAXB.getRue2());
				objet.setCodePostal(pEntityJAXB.getCodePostal());
				objet.setVille(pEntityJAXB.getVille());
				objet.setPays(pEntityJAXB.getPays());
				objet.setTelephone(pEntityJAXB.getTelephone());
				objet.setMail(pEntityJAXB.getMail());
				objet.setDateNaissance(pEntityJAXB.getDateNaissance());
				
			}
			
			return objet;
			
		} // Fin de synchronized._______________________
				
	} // Fin de creerObjetMetierAPartirEntityJAXB(...).____________________
	

	
	/**
	 * <b>Crée une ENTITY JAXB à partir d'un OBJET METIER</b>.<br/>
	 * <ul>
	 * <li>retourne null si pObject == null.</li>
	 * <li>récupère les valeurs dans le pObject.</li>
	 * <li>injecte les valeurs de l'OBJET METIER dans une ENTITY JAXB.</li>
	 * </ul>
	 *
	 * @param pObject : IContactSimple.<br/>
	 * 
	 * @return : ContactSimpleEntityJAXB.<br/>
	 */
	public static ContactSimpleEntityJAXB creerEntityJAXBAPartirObjetMetier(
											final IContactSimple pObject) {
		
		synchronized (ContactSimpleConvertisseurMetierEntity.class) {

			ContactSimpleEntityJAXB entity = null;

			if (pObject != null) {

				entity = new ContactSimpleEntityJAXB(
						pObject.getId()
						, pObject.getPrenom(), pObject.getNom(),
						pObject.getRue(), pObject.getRue2()
						, pObject.getCodePostal(), pObject.getVille()
						, pObject.getPays()
						, pObject.getTelephone(), pObject.getMail()
						, pObject.getDateNaissance());

			}

			return entity;

		} // Fin de synchronized._______________________
		
	} // Fin de creerEntityJAXBAPartirObjetMetier(...).____________________
	
	
	
	/**
	 * <b>convertit une ENTITY JAXB en OBJET METIER</b>.<br/>
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
	public static IContactSimple convertirEntityJAXBEnObjetMetier(
			final ContactSimpleEntityJAXB pEntity) {
		
		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			IContactSimple objet = null;
			
			if (pEntity != null) {
				
				/* récupère les valeurs dans l'Entity. */
				/* injecte les valeurs typées dans un OBJET METIER. */
				objet 
					= new ContactSimple(
							pEntity.getId()
							, pEntity.getPrenom(), pEntity.getNom()
							, pEntity.getRue(), pEntity.getRue2()
							, pEntity.getCodePostal(), pEntity.getVille()
							, pEntity.getPays()
							, pEntity.getTelephone(), pEntity.getMail()
							, pEntity.getDateNaissance());
			}
			
			return objet;
						
		} // Fin de synchronized._______________________
		
	} // Fin de creerObjetMetierAPartirEntityJAXB(...).____________________
	
	
	
	/**
	 * <b>convertit une Liste d'OBJETS METIER en liste 
	 * d'Entities JAXB</b>.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;
	 * 
	 * @return : List&lt;ContactSimpleEntityJAXB&gt;.<br/>
	 */
	public static List<ContactSimpleEntityJAXB> convertirListModelEnEntitiesJAXB(
			final List<IContactSimple> pList) {

		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			/* retourne null si pList == null. */
			if (pList == null) {
				return null;
			}
			
			final List<ContactSimpleEntityJAXB> resultat 
				= new ArrayList<ContactSimpleEntityJAXB>();
			
			for (final IContactSimple objet : pList) {
				
				if (objet != null) {
					
					final ContactSimpleEntityJAXB entity 
						= creerEntityJAXBAPartirObjetMetier(objet);
					
					resultat.add(entity);
					
				}
			}
			
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirListModelEnEntitiesJAXB(...)._____________________
	

		
	/**
	 * <b>convertit une Liste d'Entities JAXB 
	 * en liste d'OBJETS METIER</b>.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;ContactSimpleEntityJAXB&gt;.<br/>
	 * 
	 * @return : List&lt;IContactSimple&gt;.<br/>
	 */
	public static List<IContactSimple> convertirListEntitiesJAXBEnModel(
			final List<ContactSimpleEntityJAXB> pList) {
		
		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			/* retourne null si pList == null. */
			if (pList == null) {
				return null;
			}
			
			final List<IContactSimple> resultat 
				= new ArrayList<IContactSimple>();
			
			for (final ContactSimpleEntityJAXB entity : pList) {
				
				if (entity != null) {
					
					final IContactSimple objet 
						= creerObjetMetierAPartirEntityJAXB(
								entity);
					
					resultat.add(objet);
					
				}
			}
			
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirListEntitiesJAXBEnModel(...)._____________________
	
	
	
	/**
	 * <b>Instancie une Entity JAXB ListeContactSimplesEntityJAXB 
	 * <i>(équivalent d'une table SGBDR)</i> à partir 
	 * d'une Liste d'OBJETS METIER 
	 * List&lt;IContactSimple&gt; pList</b>.<br/>
	 * <ul>
	 * <li>retourne null si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IContactSimple&gt; : 
	 * Liste d'OBJETS METIER
	 * à transformer en Entity JAXB en vue de la sérialization.<br/>
	 * 
	 * @return : ListeContactSimplesEntityJAXB : 
	 * Entity JAXB serializable 
	 * sous forme de fichier XML.<br/>
	 */
	public static ListeContactSimplesEntityJAXB creerEntityJAXBList(
			final List<IContactSimple> pList) {

		synchronized (ContactSimpleConvertisseurMetierEntity.class) {
			
			/* retourne null si pList == null. */
			if (pList == null) {
				return null;
			}
			
			final List<ContactSimpleEntityJAXB> liste 
				= convertirListModelEnEntitiesJAXB(pList);
		
			final ListeContactSimplesEntityJAXB listEntityJAXB 
				= new ListeContactSimplesEntityJAXB(liste);
			
			return listEntityJAXB;
			
		} // Fin de synchronized._______________________
		
	} // Fin de creerEntityJAXBList(...).__________________________________

	
	
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
