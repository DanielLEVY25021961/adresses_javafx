package levy.daniel.application.model.persistence.metier.contactsimple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.impl.ContactSimpleModelObs;


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
	 * "France".<br/>
	 */
	public static final String FRANCE = "France";

	/**
	 * listeContactSimples : List&lt;IContactSimple&gt; :<br/>
	 * Liste de IContactSimple.<br/>
	 */
	private static List<IContactSimple> listeContactSimples = new ArrayList<IContactSimple>();
	
	/**
	 * Liste de IContactSimpleModelObs correspondant à la listeContactSimples.<br/>
	 */
	private static ObservableList<IContactSimpleModelObs> listeContactSimplesObservables 
		= FXCollections.observableArrayList();

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(InitialiseurDeData.class);


	// *************************METHODES************************************/
	
	/**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	private InitialiseurDeData() {
		super();
	} // Fin de  CONSTRUCTEUR D'ARITE NULLE._______________________________
	
	

	/**
	 * Point d'entrée de la classe.<br/>
	 *
	 * @param pArgs : String[].<br/>
	 */
	public static void main(
			final String... pArgs) {
		
		instancierContactSimples();

	} // Fin de main(...)._________________________________________________


	
	/**
	 * Instancie des ContactSimple et les 
	 * intègre à listeContactSimples.<br/>
	 */
	private static void instancierContactSimples() {
		
		final IContactSimple contactSimple1 
			= new ContactSimple(
					"Horace", "Silver"
					, "17, rue de la Plomberie"
					, null
					, "73 698", "Chambéry"
					, FRANCE
					, "04 79 85 54 63"
					, "horace.silver@free.fr"
					, LocalDate.of(1950, 1, 17));
		
		final IContactSimple contactSimple2 
		= new ContactSimple(
				"Johnny", "Halliday"
				, "7, avenue des Zozos"
				, "Bâtiment les Etoiles"
				, "75 001", "Paris"
				, FRANCE
				, "01 44 85 54 63"
				, "johnny.halliday@free.fr"
				, LocalDate.of(1952, 7, 22));

		final IContactSimple contactSimple3 
		= new ContactSimple(
				"Papy", "Gonzales"
				, "rue3"
				, "complément rue3"
				, "cp3", "ville3"
				, "USA"
				, "00 33 (1) 585 54 63"
				, "papy.gonzales@aol.com"
				, LocalDate.of(2018, 5, 3));

		final IContactSimple contactSimple4 
		= new ContactSimple(
				"Zorro", "Démoniaque"
				, "rue4"
				, null
				, "cp4", "ville4"
				, "Angleterre"
				, "00 33 (3) 472 54 63"
				, "zorro.demoniac@british.com"
				, LocalDate.of(2018, 5, 4));

		listeContactSimples.add(contactSimple1);
		listeContactSimplesObservables.add(new ContactSimpleModelObs(contactSimple1));
		listeContactSimples.add(contactSimple2);
		listeContactSimplesObservables.add(new ContactSimpleModelObs(contactSimple2));
		listeContactSimples.add(contactSimple3);
		listeContactSimplesObservables.add(new ContactSimpleModelObs(contactSimple3));
		listeContactSimples.add(contactSimple4);
		listeContactSimplesObservables.add(new ContactSimpleModelObs(contactSimple4));
		
	} // Fin de instancierContactSimples().________________________________


	
	/**
	 * method ajouterContactSimple(
	 * IContactSimple pContactSimple) :<br/>
	 * Ajoute une IContactSimple à listeContactSimples.<br/>
	 * Ajoute un ContactSimpleModelObs correspondant 
	 * à listeContactSimplesObservables.<br/>
	 * <br/>
	 *
	 * @param pContactSimple : IContactSimple :  .<br/>
	 */
	public void ajouterContactSimple(
			final IContactSimple pContactSimple) {
		
		listeContactSimples.add(pContactSimple);
		listeContactSimplesObservables.add(new ContactSimpleModelObs(pContactSimple));
		
	} // Fin de ajouterContactSimple(...).__________________________________
	
	
	
	/**
	 * Getter de la liste de ContactSimple.<br/>
	 *
	 * @return listeContactSimples : List&lt;IContactSimple&gt;.<br/>
	 */
	public static List<IContactSimple> getListeContactSimples() {
		
		if (listeContactSimples.isEmpty()) {
			instancierContactSimples();
		}
		
		return listeContactSimples;
		
	} // Fin de getListeContactSimples().__________________________________


	
	/**
	 * Getter de la liste de ContactSimpleControllers.<br/>
	 *
	 * @return : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 */
	public static ObservableList<IContactSimpleModelObs> getListeContactSimplesObservables() {
		
		if (listeContactSimplesObservables.isEmpty()) {
			instancierContactSimples();
		}
		
		return listeContactSimplesObservables;
		
	} // Fin de getListeContactSimplesObservables()._______________________
	
	
	
} // FIN DE LA CLASSE InitialiseurDeData.------------------------------------
