package levy.daniel.application.model.dto.metier.contactsimple.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.dto.metier.contactsimple.ContactSimpleConvertisseurMetierDTO;
import levy.daniel.application.model.dto.metier.contactsimple.IContactSimpleDTO;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;

/**
 * CLASSE ContactSimpleDTOTest :<br/>
 * Test JUnit de la classe ContactSimpleDTO.<br/>
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
public class ContactSimpleDTOTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	/**
	 * "unused".<br/>
	 */
	public static final String UNUSED = "unused";
	
	
	/**
	 * Objet Metier.
	 */
	public static transient IContactSimple objet1 
		= new ContactSimple(
				70L
				, "prenomTest", "nomTest"
				, "17 rue de la Pompe"
				, "Bâtiment 50"
				, "73 000", "Chambéry"
				, "France"
				, "04 79 84 75 07", "prenomTest.nomTest@aol.com"
				, LocalDate.of(1960, 2, 17));

	/**
	 * DTO.<br/>
	 */
	public static transient IContactSimpleDTO objet1DTO 
		= new ContactSimpleDTO(
				"70"
				, "prenomTest", "nomTest"
				, "17 rue de la Pompe"
				, "Bâtiment 50"
				, "73 000", "Chambéry"
				, "France"
				, "04 79 84 75 07", "prenomTest.nomTest@aol.com"
				, "17/02/1960");

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleDTOTest.class);
	

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ContactSimpleDTOTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	
	/**
	 * <b>Teste les transformateurs</b>.<br/>
	 * <ul>
	 * <li>vérifie que le constructeur transformateur de DTO 
	 * dans l'objet métier fonctionne.</li>
	 * <li>vérifie que le constructeur transformateur d'objet métier 
	 * dans le DTO fonctionne.</li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testTransformateur() {
					
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE ContactSimpleDTOTest - méthode testTransformateur() ********** ");		
		}
		
		final IContactSimple objetTransforme1 
			= ContactSimpleConvertisseurMetierDTO.convertirDTOEnObjetMetier(objet1DTO);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("DTO : " + objet1DTO.toString());
			System.out.println("Objet créé en transformant le DTO : " 
						+ objetTransforme1.toString());
			System.out.println("objet1 : " + objet1.toString());
		}
		
		/* vérifie que le constructeur transformateur de DTO 
		 * dans l'objet métier fonctionne. */
		assertEquals("objetTransforme1 equals objet1 : "
				, objet1, objetTransforme1);
		
		final IContactSimpleDTO dtoTransforme1 
			= ContactSimpleConvertisseurMetierDTO.convertirObjetMetierEnDTO(objet1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("OBJET METIER : " + objet1.toString());
			System.out.println("DTO créé en transformant l'objet métier : " 
						+ dtoTransforme1.toString());
			System.out.println("objet1DTO : " + objet1DTO);
		}
		
		/* vérifie que le constructeur transformateur d'objet métier 
		 * dans le DTO fonctionne. */
		assertEquals("dtoTransforme1 equals objet1DTO : "
				, objet1DTO, dtoTransforme1);

	} // Fin de testTransformateur().______________________________________
	

	
	/**
	 * teste la méthode fournirLodalDate(String).<br/>
	 * <ul>
	 * <li>garantit que fournirLocalDate(null) retourne null.</li>
	 * <li>garantit que fournirLocalDate("dd MMMM yyyy") (12 février 1960) 
	 * n'est pas null et vaut la bonne date.</li>
	 * <li>garantit que fournirLocalDate("dd/MM/yyyy") (12/02/1960) 
	 * n'est pas null et vaut la bonne date.</li>
	 * <li>garantit que fournirLocalDate("yyyy-MMM-dd") (1960-févr.-12) 
	 * n'est pas null et vaut la bonne date.</li>
	 * <li>garantit que fournirLocalDate("yyyy-MM-dd") (1960-02-12) 
	 * n'est pas null et vaut la bonne date.</li>
	 * <li>garantit que fournirLocalDate(dateInexistante) retourne null.</li>
	 * </ul>
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testFournirLocalDate() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE ContactSimpleDTOTest - méthode testFournirLocalDate() ********** ");		
		}
		
		final DateTimeFormatter dateFormatterAffichage 
			= DateTimeFormatter.ofPattern("dd MMMM yyyy")
				.withLocale(Locale.getDefault());
		
		final String dateNullString = null;
		final String dateAffichageString = "12 février 1960";
		final String dateSaisieString = "12/02/1960";
		final String dateIso1String = "1960-févr.-12";
		final String dateIsoString = "1960-02-12";
		final String dateInexistanteString = "toto";
		
		final LocalDate dateNull = fournirLocalDate(dateNullString);
		final LocalDate dateAffichage = fournirLocalDate(dateAffichageString);
		final LocalDate dateSaisie = fournirLocalDate(dateSaisieString);
		final LocalDate dateIso1 = fournirLocalDate(dateIso1String);
		final LocalDate dateIso = fournirLocalDate(dateIsoString);
		final LocalDate dateInexistante = fournirLocalDate(dateInexistanteString);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			if (dateNull != null) {
				System.out.println("dateNull (null) = " + dateFormatterAffichage.format(dateNull));
			} else {
				System.out.println("dateNull (null) = null");
			}
			
			if (dateAffichage != null) {
				System.out.println("dateAffichage (12 février 1960) = " + dateFormatterAffichage.format(dateAffichage));
			} else {
				System.out.println("dateAffichage (12 février 1960) = null");
			}
			
			if (dateSaisie != null) {
				System.out.println("dateSaisie (12/02/1960) = " + dateFormatterAffichage.format(dateSaisie));
			} else {
				System.out.println("dateSaisie (12/02/1960) = null");
			}
			
			if (dateIso1 != null) {
				System.out.println("dateIso1 (1960-févr.-12) = " + dateFormatterAffichage.format(dateIso1));
			} else {
				System.out.println("dateIso1 (1960-févr.-12) = null");
			}
			
			if (dateIso != null) {
				System.out.println("dateIso (1960-02-12) = " + dateFormatterAffichage.format(dateIso));
			} else {
				System.out.println("dateIso (1960-02-12) = null");
			}
			
			if (dateInexistante != null) {
				System.out.println("dateInexistante (toto) = " + dateFormatterAffichage.format(dateInexistante));
			} else {
				System.out.println("dateInexistante (toto) = null");
			}
			
		}

		/* garantit que fournirLocalDate(null) retourne null. */
		assertNull("dateNull doit être null : ", dateNull);
		
		/* garantit que fournirLocalDate("dd MMMM yyyy") (12 février 1960) n'est pas null et vaut la bonne date. */
		assertNotNull("dateAffichage ne doit pas être null : ", dateAffichage);
		assertEquals("", LocalDate.of(1960, 2, 12), dateAffichage);
		
		/* garantit que fournirLocalDate("dd/MM/yyyy") (12/02/1960) n'est pas null et vaut la bonne date. */
		assertNotNull("dateSaisie ne doit pas être null : ", dateSaisie);
		assertEquals("", LocalDate.of(1960, 2, 12), dateSaisie);
		
		/* garantit que fournirLocalDate("yyyy-MMM-dd") (1960-févr.-12) n'est pas null et vaut la bonne date. */
		assertNotNull("dateIso1 ne doit pas être null : ", dateIso1);
		assertEquals("", LocalDate.of(1960, 2, 12), dateIso1);
		
		/* garantit que fournirLocalDate("yyyy-MM-dd") (1960-02-12) n'est pas null et vaut la bonne date. */
		assertNotNull("dateIso ne doit pas être null : ", dateIso);
		assertEquals("", LocalDate.of(1960, 2, 12), dateIso);
		
		/* garantit que fournirLocalDate(dateInexistante) retourne null. */
		assertNull("dateInexistante doit être null : ", dateInexistante);
		
	} // Fin de testFournirLocalDate().____________________________________
	
	
	
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
						
	} // Fin de fournirLocalDate(...)._____________________________________
	


} // FIN DE LA CLASSE ContactSimpleDTOTest.----------------------------------
