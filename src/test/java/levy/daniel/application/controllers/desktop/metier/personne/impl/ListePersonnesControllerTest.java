package levy.daniel.application.controllers.desktop.metier.personne.impl;

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
import levy.daniel.application.controllers.desktop.metier.personne.IListePersonnesController;
import levy.daniel.application.controllers.desktop.metier.personne.IPersonneController;
import levy.daniel.application.model.metier.personne.IPersonne;
import levy.daniel.application.model.metier.personne.impl.Personne;

/**
 * CLASSE ListePersonnesControllerTest :<br/>
 * Test JUnit de la Classe ListePersonnesController.<br/>
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
public class ListePersonnesControllerTest {

	// ************************ATTRIBUTS************************************/


	
	
	/**
	 * listePersonnes : ObservableList<IPersonneController> :<br/>
	 * liste des PersonneController.<br/>
	 */
	public transient ObservableList<IPersonneController> listePersonnes 
		= FXCollections.observableArrayList();	
	

	/**
	 * listePersonneController : IListePersonnesController :<br/>
	 * .<br/>
	 */
	public transient IListePersonnesController listePersonneController 
		= new ListePersonnesController(null, null, this.listePersonnes);
	
	
	/**
	 * personne1 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne1 
		= new Personne(
				"Zorro", "Halliday"
				, "2, rue de la Pompe", "74 850", "Annecy"
				, LocalDate.of(1900, 2, 25));
	
	/**
	 * personne2 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne2 
		= new Personne(
			"Papy", "Gonzales"
			, "7, avenue du Sentier", "75 008", "Paris"
			, LocalDate.of(1961, 2, 25));
	
	/**
	 * personne3 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne3 
		= new Personne(
			"Benito", "De la Roza"
			, "3, rue de la Pompe", "73 850", "Chambéry"
			, LocalDate.of(2000, 2, 25));

	/**
	 * personne4 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne4 
		= new Personne(
			"Maléna", "Rozita"
			, "4, rue de la Pompe", "73 950", "Chambéry"
			, LocalDate.of(2000, 2, 25));
	
	/**
	 * personne5 : IPersonne :<br/>
	 * .<br/>
	 */
	public transient IPersonne personne5 
		= new Personne(
			"Concerto", "D'Aranjuez"
			, "2, rue de la Pompe", "73 850", "Chambéry"
			, LocalDate.of(2000, 2, 25));

	/**
	 * listePersonnesAAjouter : List<IPersonne> :<br/>
	 * .<br/>
	 */
	public transient List<IPersonne> listePersonnesAAjouter;
	
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
	 * "l'instance de liste dans le Controller doit être this.listePersonnes : ".<br/>
	 */
	public static final String INSTANCE_LISTE 
		= "l'instance de liste dans le Controller doit être this.listePersonnes : ";
	
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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ListePersonnesControllerTest.class);

	// *************************METHODES************************************/
	

	/**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ListePersonnesControllerTest() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * Teste la méthode ajouterPersonneAList(IPersonne pPersonne).<br/>
	 * garantit que :<br/>
	 * <ul>
	 * <li>l'instance de liste dans le Controller doit être this.listePersonnes.</li>
	 * <li>le nombre initial d'objets dans la liste vaut 0.</li>
	 * <li>le nombre final d'objets dans la liste vaut nombreInitial + 3.</li>
	 * <li>L'ajout dans la liste du CONTROLLER se passe bien.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused") // NOPMD by dan on 16/05/18 20:11
	@Test
	public void testAjouterPersonneAList() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** méthode testAjouterPersonneAList() ********** ");
		}
		
		
		/* l'instance de liste dans le Controller doit être this.listePersonnes. */
		assertSame(INSTANCE_LISTE
				, this.listePersonnes, this.listePersonneController.getListePersonnes());
		
		assertEquals(
				INSTANCE_LISTE
				, this.listePersonnes
				, this.listePersonneController.getListePersonnes());
		
		final int nombreInitial = this.listePersonneController.getListePersonnes().size();
		
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
		this.ajouterPersonnes();
		
		final int nombreFinal = this.listePersonneController.count();

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
			System.out.println(this.listePersonneController.afficherListe());
		}
		
	} // Fin de testAjouterPersonneAList().________________________________
	

	
	/**
	 * Teste la méthode retirerPersonneAList(IPersonne pPersonne).<br/>
	 * garantit que :<br/>
	 * <ul>
	 * <li>le nombre final d'objets dans la liste vaut nombreInitial - 1.</li>
	 * <li>le retrait dans la liste du CONTROLLER se passe bien.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testRetirerPersonneAList() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** méthode testRetirerPersonneAList() ********** ");
		}
		
		/* AJOUT D'OBJETS. */
		this.ajouterPersonnes();

		final int nombreInitial 
			= this.listePersonneController.getListePersonnes().size();
		
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
			System.out.println(this.listePersonneController.afficherListe());
		}
		
		/* RETRAIT D'OBJET. */
		final boolean retrait 
			= this.listePersonneController.retirerPersonneAList(this.personne3);
		
		assertTrue("le retrait dans la liste du CONTROLLER se passe bien : "
					, retrait);
		
		final int nombreFinal = this.listePersonneController.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(NOMBRE_FINAL + nombreFinal);
			
			System.out.println();
			System.out.println(CONTENU_LISTE);
			System.out.println(this.listePersonneController.afficherListe());
		}
		
		/* le nombre final d'objets dans la liste vaut nombreInitial - 1. */
		assertEquals(
				"le nombre final d'objets dans la liste vaut nombreInitial - 1 : "
					, nombreInitial - 1
						, nombreFinal);
		
	} // Fin de testRetirerPersonneAList().________________________________


	
	/**
	 * Teste la méthode ajouterListePersonnesAList(...).<br/>
	 *  garantit que :<br/>
	 * <ul>
	 * <li>le nombre final d'objets dans la liste vaut nombreInitial + 2.</li>
	 * <li>L'ajout dans la liste du CONTROLLER se passe bien.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testAjouterListePersonnesAList() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** méthode testAjouterListePersonnesAList() ********** ");
		}
		
		final int nombreInitial 
			= this.listePersonneController.getListePersonnes().size();
		
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
		this.constituerLIstePersonnesAAjouter();
		this.listePersonneController.ajouterListePersonnesAList(this.listePersonnesAAjouter);
		
		final int nombreFinal = this.listePersonneController.count();

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
			System.out.println(this.listePersonneController.afficherListe());
		}

	} // Fin de testAjouterListePersonnesAList().__________________________


	
	/**
	 * Teste la méthode retirerListePersonnesAList().<br/>
	 * garantit que :<br/>
	 * <ul>
	 * <li>le nombre final d'objets dans la liste vaut nombreInitial - 2.</li>
	 * <li>le retrait dans la liste du CONTROLLER se passe bien.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testRetirerListePersonnesAList() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** méthode testRetirerListePersonnesAList() ********** ");
		}
		
		/* AJOUT D'OBJETS. */
		this.ajouterPersonnes();

		final int nombreInitial 
			= this.listePersonneController.getListePersonnes().size();
		
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
			System.out.println(this.listePersonneController.afficherListe());
		}
		
		/* RETRAIT D'OBJET. */
		final List<IPersonne> listeRetrait = new ArrayList<IPersonne>();
		listeRetrait.add(this.personne2);
		listeRetrait.add(this.personne3);
		
		final boolean retrait 
			= this.listePersonneController.retirerListePersonnesAList(listeRetrait);
		
		assertTrue("le retrait dans la liste du CONTROLLER se passe bien : "
					, retrait);
		
		final int nombreFinal = this.listePersonneController.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(NOMBRE_FINAL + nombreFinal);
			
			System.out.println();
			System.out.println(CONTENU_LISTE);
			System.out.println(this.listePersonneController.afficherListe());
		}
		
		/* le nombre final d'objets dans la liste vaut nombreInitial - 2. */
		assertEquals(
				"le nombre final d'objets dans la liste vaut nombreInitial - 2 : "
					, nombreInitial - 2
						, nombreFinal);
		
	}
	
	
	
	/**
	 * Ajoute des Personne à la liste de 
	 * this.listePersonneController.<br/>
	 */
	private void ajouterPersonnes() {
		
		this.listePersonneController.ajouterPersonneAList(this.personne1);
		this.listePersonneController.ajouterPersonneAList(this.personne2);
		this.listePersonneController.ajouterPersonneAList(this.personne3);
		
	} // Fin de ajouterPersonnes().________________________________________
	

	
	/**
	 * Instancie this.listePersonnesAAjouter.<br/>
	 * Ajoute this.personne4 et this.personne5 
	 * à this.listePersonnesAAjouter.<br/>
	 */
	private void constituerLIstePersonnesAAjouter() {
		
		this.listePersonnesAAjouter = new ArrayList<IPersonne>();
		this.listePersonnesAAjouter.add(this.personne4);
		this.listePersonnesAAjouter.add(this.personne5);
		
	} // Fin de constituerLIstePersonnesAAjouter().________________________
	
	
	
} // Fin de CLASSE ListePersonnesControllerTest.-----------------------------
