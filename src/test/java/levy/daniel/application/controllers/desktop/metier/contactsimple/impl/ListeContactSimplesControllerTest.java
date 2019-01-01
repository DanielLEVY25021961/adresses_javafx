package levy.daniel.application.controllers.desktop.metier.contactsimple.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IListeContactSimplesModelObs;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.impl.ListeContactSimplesModelObs;

/**
 * CLASSE ListeContactSimplesControllerTest :<br/>
 * Test JUnit de la Classe ListeContactSimplesModelObs.<br/>
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
 * @since 16 mai 2018
 *
 */
public class ListeContactSimplesControllerTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * "France".<br/>
	 */
	public static final String FRANCE = "France";
	
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * NOMBRE_INITIAL_ZERO : String :<br/>
	 * "le nombre initial d'objets dans la liste vaut 0 : ".<br/>
	 */
	public static final String NOMBRE_INITIAL_ZERO 
		= "le nombre initial d'objets dans la liste vaut 0 : ";
	
	/**
	 * INSTANCE_LISTE : String :<br/>
	 * "l'instance de liste dans le Controller doit être this.listeContactSimples : ".<br/>
	 */
	public static final String INSTANCE_LISTE 
		= "l'instance de liste dans le Controller doit être this.listeContactSimples : ";
	
	/**
	 * NOMBRE_INITIAL : String :<br/>
	 * "nombreInitial : ".<br/>
	 */
	public static final String NOMBRE_INITIAL 
		= "nombreInitial : ";
		
	/**
	 * NOMBRE_FINAL : String :<br/>
	 * NOMBRE_FINAL.<br/>
	 */
	public static final String NOMBRE_FINAL 
		= "nombreFinal : ";
	
	/**
	 * NOMBRE_FINAL_PLUS_3 : String :<br/>
	 * "le nombre final d'objets dans la liste vaut nombreInitial + 3 : ".<br/>
	 */
	public static final String NOMBRE_FINAL_PLUS_3 
		= "le nombre final d'objets dans la liste vaut nombreInitial + 3 : ";
	
	/**
	 * CONTENU_LISTE : String :<br/>
	 * "CONTENU DE LA LISTE : ".<br/>
	 */
	public static final String CONTENU_LISTE 
		= "CONTENU DE LA LISTE : ";

	
	
	/**
	 * listeContactSimples : ObservableList<IContactSimpleModelObs> :<br/>
	 * liste des ContactSimpleModelObs.<br/>
	 */
	public transient ObservableList<IContactSimpleModelObs> listeContactSimples 
		= FXCollections.observableArrayList();	
	

	/**
	 * listeContactSimpleController : IListeContactSimplesModelObs :<br/>
	 * .<br/>
	 */
	public transient IListeContactSimplesModelObs listeContactSimpleController 
		= new ListeContactSimplesModelObs(null, null, this.listeContactSimples);
	
	
	
	/**
	 * contactSimple1 : IContactSimple :<br/>
	 * .<br/>
	 */
	public transient IContactSimple contactSimple1 
		= new ContactSimple(
				"Zorro", "Halliday"
				, "2, rue de la Pompe"
				, null
				, "73 850", "Chambéry"
				, FRANCE
				, "04 75 98 65 32"
				, "zorro.halliday@sfr.com"
				, LocalDate.of(1900, 2, 25));

	/**
	 * contactSimple1 : IContactSimple :<br/>
	 * .<br/>
	 */
	public transient IContactSimple contactSimple1Equals 
		= new ContactSimple(
				"Zorro", "Halliday"
				, "17, rue de la Mélodie"
				, null
				, "77 850", "Provins"
				, FRANCE
				, "04 75 98 65 32"
				, "zorro.halliday@sfr.com"
				, LocalDate.of(1900, 2, 25));
	
	/**
	 * contactSimple2 : IContactSimple :<br/>
	 * .<br/>
	 */
	public transient IContactSimple contactSimple2 
		= new ContactSimple(
			"Papy", "Gonzales"
			, "7, avenue du Sentier"
			, null
			, "75 008", "Paris"
			, FRANCE
			, "01 75 98 65 32"
			, "papy.gonzales@free.fr"
			, LocalDate.of(1961, 2, 25));
	
	/**
	 * contactSimple3 : IContactSimple :<br/>
	 * .<br/>
	 */
	public transient IContactSimple contactSimple3 
		= new ContactSimple(
			"Benito", "De la Roza"
			, "3, rue de la Pompe"
			, "Bâtiment 4, appartement 563"
			, "74 850", "Annecy"
			, FRANCE
			, "04 79 85 64 32"
			, "benito.delaRoza@orange.fr"
			, LocalDate.of(2000, 2, 25));

	/**
	 * contactSimple4 : IContactSimple :<br/>
	 * .<br/>
	 */
	public transient IContactSimple contactSimple4 
		= new ContactSimple(
			"Maléna", "Rozita"
			, "2, rue de la Pompe"
			, "impasse des clercs"
			, "74 950", "Annecy-le-Vieux"
			, FRANCE
			, "04 79 85 64 32"
			, "malena.rozita@orange.fr"
			, LocalDate.of(2000, 2, 25));
	
	/**
	 * contactSimple5 : IContactSimple :<br/>
	 * .<br/>
	 */
	public transient IContactSimple contactSimple5 
		= new ContactSimple(
			"Concerto", "D'Aranjuez"
			, "2, rue de la Pompe"
			, null
			, "73 850", "Chambéry"
			, FRANCE
			, "04 79 77 64 32"
			, "concerto.aranjuez@orange.fr"
			, LocalDate.of(2000, 2, 25));


	/**
	 * listeContactSimplesAAjouter : List<IContactSimple> :<br/>
	 * .<br/>
	 */
	public transient List<IContactSimple> listeContactSimplesAAjouter;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ListeContactSimplesControllerTest.class);

	// *************************METHODES************************************/
	

	/**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ListeContactSimplesControllerTest() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * Teste la méthode ajouterContactSimpleAList(IContactSimple pContactSimple).<br/>
	 * garantit que :<br/>
	 * <ul>
	 * <li>l'instance de liste dans le Controller doit être this.listeContactSimples.</li>
	 * <li>le nombre initial d'objets dans la liste vaut 0.</li>
	 * <li>le nombre final d'objets dans la liste vaut nombreInitial + 3.</li>
	 * <li>L'ajout dans la liste du CONTROLLER se passe bien.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused") 
	@Test
	public void testAjouterContactSimpleAList() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** méthode testAjouterContactSimpleAList() ********** ");
		}
		
		
		/* l'instance de liste dans le Controller doit être this.listeContactSimples. */
		assertSame(INSTANCE_LISTE
				, this.listeContactSimples, this.listeContactSimpleController.getListeContactSimples());
		
		assertEquals(
				INSTANCE_LISTE
				, this.listeContactSimples
				, this.listeContactSimpleController.getListeContactSimples());
		
		final int nombreInitial = this.listeContactSimpleController.getListeContactSimples().size();
		
		/* le nombre initial d'objets dans la liste vaut 0. */
		assertEquals(
				NOMBRE_INITIAL_ZERO
					, 0
						, nombreInitial);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(NOMBRE_INITIAL + nombreInitial);
		}
		
		/* AJOUT D'OBJETS. */
		this.ajouterContactSimples();
		
		final int nombreFinal = this.listeContactSimpleController.count();

		/* le nombre final d'objets dans la liste vaut nombreInitial + 3. */
		assertEquals(
				NOMBRE_FINAL_PLUS_3
					, nombreInitial + 3
						, nombreFinal);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(NOMBRE_FINAL + nombreFinal);
			
			System.out.println();
			System.out.println(CONTENU_LISTE);
			System.out.println(this.listeContactSimpleController.afficherListe());
		}
		
	} // Fin de testAjouterContactSimpleAList().________________________________
	

	
	/**
	 * Teste la méthode retirerContactSimpleAList(IContactSimple pContactSimple).<br/>
	 * garantit que :<br/>
	 * <ul>
	 * <li>le nombre final d'objets dans la liste vaut nombreInitial - 1.</li>
	 * <li>le retrait dans la liste du CONTROLLER se passe bien.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testRetirerContactSimpleAList() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** méthode testRetirerContactSimpleAList() ********** ");
		}
		
		/* AJOUT D'OBJETS. */
		this.ajouterContactSimples();

		final int nombreInitial 
			= this.listeContactSimpleController.getListeContactSimples().size();
		
		/* le nombre initial d'objets dans la liste vaut 3. */
		assertEquals(
				"le nombre initial d'objets dans la liste vaut 3 : "
					, 3
						, nombreInitial);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(NOMBRE_INITIAL + nombreInitial);
			
			System.out.println();
			System.out.println(CONTENU_LISTE);
			System.out.println(this.listeContactSimpleController.afficherListe());
		}
		
		/* RETRAIT D'OBJET. */
		final boolean retrait 
			= this.listeContactSimpleController.retirerContactSimpleAList(this.contactSimple3);
		
		assertTrue("le retrait dans la liste du CONTROLLER se passe bien : "
					, retrait);
		
		final int nombreFinal = this.listeContactSimpleController.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(NOMBRE_FINAL + nombreFinal);
			
			System.out.println();
			System.out.println(CONTENU_LISTE);
			System.out.println(this.listeContactSimpleController.afficherListe());
		}
		
		/* le nombre final d'objets dans la liste vaut nombreInitial - 1. */
		assertEquals(
				"le nombre final d'objets dans la liste vaut nombreInitial - 1 : "
					, nombreInitial - 1
						, nombreFinal);
		
	} // Fin de testRetirerContactSimpleAList().________________________________


	
	/**
	 * Teste la méthode ajouterListeContactSimplesAList(...).<br/>
	 *  garantit que :<br/>
	 * <ul>
	 * <li>le nombre final d'objets dans la liste vaut nombreInitial + 2.</li>
	 * <li>L'ajout dans la liste du CONTROLLER se passe bien.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testAjouterListeContactSimplesAList() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** méthode testAjouterListeContactSimplesAList() ********** ");
		}
		
		final int nombreInitial 
			= this.listeContactSimpleController.getListeContactSimples().size();
		
		/* le nombre initial d'objets dans la liste vaut 0. */
		assertEquals(
				NOMBRE_INITIAL_ZERO
					, 0
						, nombreInitial);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(NOMBRE_INITIAL + nombreInitial);
		}
		
		/* AJOUT D'UNE LISTE D'OBJETS. */
		this.constituerLIsteContactSimplesAAjouter();
		this.listeContactSimpleController.ajouterListeContactSimplesAList(this.listeContactSimplesAAjouter);
		
		final int nombreFinal = this.listeContactSimpleController.count();

		/* le nombre final d'objets dans la liste vaut nombreInitial + 2. */
		assertEquals(
				"le nombre final d'objets dans la liste vaut nombreInitial + 2 : "
					, nombreInitial + 2
						, nombreFinal);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(NOMBRE_FINAL + nombreFinal);
			
			System.out.println();
			System.out.println(CONTENU_LISTE);
			System.out.println(this.listeContactSimpleController.afficherListe());
		}

	} // Fin de testAjouterListeContactSimplesAList().__________________________


	
	/**
	 * Teste la méthode retirerListeContactSimplesAList().<br/>
	 * garantit que :<br/>
	 * <ul>
	 * <li>le nombre final d'objets dans la liste vaut nombreInitial - 2.</li>
	 * <li>le retrait dans la liste du CONTROLLER se passe bien.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testRetirerListeContactSimplesAList() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** méthode testRetirerListeContactSimplesAList() ********** ");
		}
		
		/* AJOUT D'OBJETS. */
		this.ajouterContactSimples();

		final int nombreInitial 
			= this.listeContactSimpleController.getListeContactSimples().size();
		
		/* le nombre initial d'objets dans la liste vaut 3. */
		assertEquals(
				"le nombre initial d'objets dans la liste vaut 3 : "
					, 3
						, nombreInitial);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(NOMBRE_INITIAL + nombreInitial);
			
			System.out.println();
			System.out.println(CONTENU_LISTE);
			System.out.println(this.listeContactSimpleController.afficherListe());
		}
		
		/* RETRAIT D'OBJET. */
		final List<IContactSimple> listeRetrait = new ArrayList<IContactSimple>();
		listeRetrait.add(this.contactSimple2);
		listeRetrait.add(this.contactSimple3);
		
		final boolean retrait 
			= this.listeContactSimpleController.retirerListeContactSimplesAList(listeRetrait);
		
		assertTrue("le retrait dans la liste du CONTROLLER se passe bien : "
					, retrait);
		
		final int nombreFinal = this.listeContactSimpleController.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(NOMBRE_FINAL + nombreFinal);
			
			System.out.println();
			System.out.println(CONTENU_LISTE);
			System.out.println(this.listeContactSimpleController.afficherListe());
		}
		
		/* le nombre final d'objets dans la liste vaut nombreInitial - 2. */
		assertEquals(
				"le nombre final d'objets dans la liste vaut nombreInitial - 2 : "
					, nombreInitial - 2
						, nombreFinal);
		
	}
	
	
	
	/**
	 * Ajoute des ContactSimple à la liste de 
	 * this.listeContactSimpleController.<br/>
	 */
	private void ajouterContactSimples() {
		
		this.listeContactSimpleController.ajouterContactSimpleAList(this.contactSimple1);
		this.listeContactSimpleController.ajouterContactSimpleAList(this.contactSimple2);
		this.listeContactSimpleController.ajouterContactSimpleAList(this.contactSimple3);
		
	} // Fin de ajouterContactSimples().________________________________________
	

	
	/**
	 * Instancie this.listeContactSimplesAAjouter.<br/>
	 * Ajoute this.contactSimple4 et this.contactSimple5 
	 * à this.listeContactSimplesAAjouter.<br/>
	 */
	private void constituerLIsteContactSimplesAAjouter() {
		
		this.listeContactSimplesAAjouter = new ArrayList<IContactSimple>();
		this.listeContactSimplesAAjouter.add(this.contactSimple4);
		this.listeContactSimplesAAjouter.add(this.contactSimple5);
		
	} // Fin de constituerLIsteContactSimplesAAjouter().________________________
	
	
	
} // Fin de CLASSE ListeContactSimplesControllerTest.-----------------------------
