package levy.daniel.application.model.utilitaires.jpa.datasource.impl;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.utilitaires.jpa.datasource.IMyDataSource;

/**
 * CLASSE MyDataSourceC3P0Test :<br/>
 * Test JUnit de la classe MyDataSourceC3P0.<br/>
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
 * @since 2 févr. 2019
 *
 */
public class MyDataSourceC3P0Test {

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
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
	/**
	 * ", ".<br/>
	 */
	public static final String VIRGULE_ESPACE = ", ";
	
	/**
	 * "null".<br/>
	 */
	public static final String NULL = "null";
	
	/**
	 * " - ".
	 */
	public static final String TIRET_ESPACE = " - ";
	
	/**
	 * "BIDON : ".<br/>
	 */
	public static final String BIDON 
		= "BIDON : ";
	
	/**
	 * "jdbc:h2:file:D:/Donnees/eclipse/eclipseworkspace/adresses_javafx/data/base-adresses_javafx-h2/base-adresses_javafx".
	 */
	public static final String URL_FILE4 
		= "jdbc:h2:file:D:/Donnees/eclipse/eclipseworkspace/adresses_javafx/data/base-adresses_javafx-h2/base-adresses_javafx";

	/**
	 * "org.h2.Driver".
	 */
	public static final String DRIVER = "org.h2.Driver";
	
	/**
	 * "sa".
	 */
	public static final String USERNAME = "sa";
	
	/**
	 * "sa".
	 */
	public static final String PASSWORD = "sa";
	
	/**
	 * 7.
	 */
	public static final String POOLMINSIZE = "7";
	
	/**
	 * 22.
	 */
	public static final String POOLMAXSIZE = "22";
	
	/**
	 * 550.
	 */
	public static final String POOLTIMEOUT = "550";
	
	/**
	 * 55.
	 */
	public static final String POOLMAXSTATEMENTS = "55";
	
	/**
	 * 2001.
	 */
	public static final String POOLIDLETESTPERIOD = "2001";
	
	/**
	 * 2.
	 */
	public static final String POOLACQUIREINCREMENT = "2";
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(MyDataSourceC3P0Test.class);

	
	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public MyDataSourceC3P0Test() {		
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testGetDataSource() {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
		System.out.println("********** CLASSE MyDataSourceC3P0Test - méthode testGetDataSource() ********** ");
		}

		final IMyDataSource myDataSource 
			= new MyDataSourceC3P0(
					URL_FILE4, DRIVER, USERNAME, PASSWORD
					, null
					, POOLMINSIZE, POOLMAXSIZE
					, POOLTIMEOUT
					, POOLMAXSTATEMENTS
					, POOLIDLETESTPERIOD
					, POOLACQUIREINCREMENT);
		
		final DataSource dataSource = myDataSource.getDataSource();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(myDataSource.afficherDataSource());
		}
		
		assertNotNull(
				"dataSource ne doit pas être null: "
					, dataSource);
		
	} // Fin de testGetDataSource()._______________________________________

	

} // FIN DE LA CLASSE MyDataSourceC3P0Test.----------------------------------
