package levy.daniel.application.model.dao.metier.personne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import levy.daniel.application.controllers.desktop.metier.personne.IPersonneController;
import levy.daniel.application.controllers.desktop.metier.personne.impl.PersonneController;
import levy.daniel.application.model.metier.personne.IPersonne;
import levy.daniel.application.model.metier.personne.impl.Personne;


/**
 * class InitialiseurDeData :<br/>
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
 * @author dan Lévy
 * @version 1.0
 * @since 9 mai 2018
 *
 */
public final class InitialiseurDeData {

	// ************************ATTRIBUTS************************************/

	/**
	 * listePersonnes : List&lt;IPersonne&gt; :<br/>
	 * Liste de IPersonne.<br/>
	 */
	private static List<IPersonne> listePersonnes = new ArrayList<IPersonne>();
	
	/**
	 * listePersonnesControllers : ObservableList<IPersonneController> :<br/>
	 * Liste de IPersonneController correspondant à la listePersonnes.<br/>
	 */
	private static ObservableList<IPersonneController> listePersonnesControllers 
		= FXCollections.observableArrayList();

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(InitialiseurDeData.class);


	// *************************METHODES************************************/
	
	/**
	 * method CONSTRUCTEUR InitialiseurDeData() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	private InitialiseurDeData() {
		super();
	} // Fin de  CONSTRUCTEUR D'ARITE NULLE._______________________________
	
	

	/**
	 * method main(
	 * String[] pArgs) :<br/>
	 * Point d'entrée de la classe.<br/>
	 * <br/>
	 *
	 * @param pArgs : String[] :  .<br/>
	 */
	public static void main(
			final String[] pArgs) {
		
		instancierPersonnes();

	} // Fin de main(...)._________________________________________________


	
	/**
	 * method instancierPersonnes() :<br/>
	 * Instancie des Personne et les intègre à listePersonnes.<br/>
	 * <br/>
	 */
	private static void instancierPersonnes() {
		
		final IPersonne personne1 
			= new Personne(
					"Horace", "Silver"
					, "17, rue de la Plomberie", "73 698", "Chambéry"
					, LocalDate.of(1950, 1, 17));
		
		final IPersonne personne2 
		= new Personne(
				"Johnny", "Halliday"
				, "7, avenue des Zozos", "75 001", "Paris"
				, LocalDate.of(1952, 7, 22));

		final IPersonne personne3 
		= new Personne(
				"Papy", "Gonzales"
				, "rue3", "cp3", "ville3"
				, LocalDate.of(2018, 5, 3));

		final IPersonne personne4 
		= new Personne(
				"Zorro", "Démoniaque"
				, "rue4", "cp4", "ville4"
				, LocalDate.of(2018, 5, 4));

		listePersonnes.add(personne1);
		listePersonnesControllers.add(new PersonneController(personne1));
		listePersonnes.add(personne2);
		listePersonnesControllers.add(new PersonneController(personne2));
		listePersonnes.add(personne3);
		listePersonnesControllers.add(new PersonneController(personne3));
		listePersonnes.add(personne4);
		listePersonnesControllers.add(new PersonneController(personne4));
		
	} // Fin de instancierPersonnes()._____________________________________


	
	/**
	 * method ajouterPersonne(
	 * IPersonne pPersonne) :<br/>
	 * Ajoute une IPersonne à listePersonnes.<br/>
	 * Ajoute un PersonneController correspondant 
	 * à listePersonnesControllers.<br/>
	 * <br/>
	 *
	 * @param pPersonne : IPersonne :  .<br/>
	 */
	public void ajouterPersonne(
			final IPersonne pPersonne) {
		
		listePersonnes.add(pPersonne);
		listePersonnesControllers.add(new PersonneController(pPersonne));
		
	} // Fin de ajouterPersonne(...).______________________________________
	
	
	
	/**
	 * method getListePersonnes() :<br/>
	 * Getter de la liste de Personne.<br/>
	 * <br/>
	 *
	 * @return listePersonnes : List&lt;IPersonne&gt;.<br/>
	 */
	public static List<IPersonne> getListePersonnes() {
		
		if (listePersonnes.isEmpty()) {
			instancierPersonnes();
		}
		
		return listePersonnes;
		
	} // Fin de getListePersonnes()._______________________________________


	
	/**
	 * method getListePersonnesControllers() :<br/>
	 * Getter de la liste de PersonneControllers.<br/>
	 * <br/>
	 *
	 * @return : ObservableList&lt;IPersonneController&gt; :  .<br/>
	 */
	public static ObservableList<IPersonneController> getListePersonnesControllers() {
		
		if (listePersonnesControllers.isEmpty()) {
			instancierPersonnes();
		}
		
		return listePersonnesControllers;
		
	} // Fin de getListePersonnesControllers().____________________________
	
	
	
} // FIN DE LA CLASSE InitialiseurDeData.------------------------------------
