package levy.daniel.application.model.persistence.metier.contactsimple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import levy.daniel.application.controllers.desktop.metier.contactsimple.IContactSimpleController;
import levy.daniel.application.controllers.desktop.metier.contactsimple.impl.ContactSimpleController;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;


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
	 * listePersonnes : List&lt;IContactSimple&gt; :<br/>
	 * Liste de IContactSimple.<br/>
	 */
	private static List<IContactSimple> listePersonnes = new ArrayList<IContactSimple>();
	
	/**
	 * listePersonnesControllers : ObservableList<IContactSimpleController> :<br/>
	 * Liste de IContactSimpleController correspondant à la listePersonnes.<br/>
	 */
	private static ObservableList<IContactSimpleController> listePersonnesControllers 
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
	 * Instancie des ContactSimple et les intègre à listePersonnes.<br/>
	 * <br/>
	 */
	private static void instancierPersonnes() {
		
		final IContactSimple personne1 
			= new ContactSimple(
					"Horace", "Silver"
					, "17, rue de la Plomberie", "73 698", "Chambéry"
					, LocalDate.of(1950, 1, 17));
		
		final IContactSimple personne2 
		= new ContactSimple(
				"Johnny", "Halliday"
				, "7, avenue des Zozos", "75 001", "Paris"
				, LocalDate.of(1952, 7, 22));

		final IContactSimple personne3 
		= new ContactSimple(
				"Papy", "Gonzales"
				, "rue3", "cp3", "ville3"
				, LocalDate.of(2018, 5, 3));

		final IContactSimple personne4 
		= new ContactSimple(
				"Zorro", "Démoniaque"
				, "rue4", "cp4", "ville4"
				, LocalDate.of(2018, 5, 4));

		listePersonnes.add(personne1);
		listePersonnesControllers.add(new ContactSimpleController(personne1));
		listePersonnes.add(personne2);
		listePersonnesControllers.add(new ContactSimpleController(personne2));
		listePersonnes.add(personne3);
		listePersonnesControllers.add(new ContactSimpleController(personne3));
		listePersonnes.add(personne4);
		listePersonnesControllers.add(new ContactSimpleController(personne4));
		
	} // Fin de instancierPersonnes()._____________________________________


	
	/**
	 * method ajouterPersonne(
	 * IContactSimple pPersonne) :<br/>
	 * Ajoute une IContactSimple à listePersonnes.<br/>
	 * Ajoute un ContactSimpleController correspondant 
	 * à listePersonnesControllers.<br/>
	 * <br/>
	 *
	 * @param pContactSimple : IContactSimple :  .<br/>
	 */
	public void ajouterPersonne(
			final IContactSimple pContactSimple) {
		
		listePersonnes.add(pContactSimple);
		listePersonnesControllers.add(new ContactSimpleController(pContactSimple));
		
	} // Fin de ajouterPersonne(...).______________________________________
	
	
	
	/**
	 * method getListePersonnes() :<br/>
	 * Getter de la liste de ContactSimple.<br/>
	 * <br/>
	 *
	 * @return listePersonnes : List&lt;IContactSimple&gt;.<br/>
	 */
	public static List<IContactSimple> getListePersonnes() {
		
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
	 * @return : ObservableList&lt;IContactSimpleController&gt; :  .<br/>
	 */
	public static ObservableList<IContactSimpleController> getListePersonnesControllers() {
		
		if (listePersonnesControllers.isEmpty()) {
			instancierPersonnes();
		}
		
		return listePersonnesControllers;
		
	} // Fin de getListePersonnesControllers().____________________________
	
	
	
} // FIN DE LA CLASSE InitialiseurDeData.------------------------------------
