package levy.daniel.application.model.utilitaires.jpa.datasource;

import java.util.Locale;

import javax.sql.DataSource;

/**
 * INTERFACE IMyDataSource :<br/>
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
 * @since 1 févr. 2019
 *
 */
public interface IMyDataSource extends DataSource {

		
	/**
	 * ';'.<br/>
	 */
	char POINT_VIRGULE = ';';
	
	/**
	 * ", ".<br/>
	 */
	String VIRGULE_ESPACE = ", ";
	
	/**
	 * "null".<br/>
	 */
	String NULL = "null";
	
	/**
	 * " - ".
	 */
	String TIRET_ESPACE = " - ";
	
	/**
	 * saut de ligne de la plateforme.<br/>
	 * System.getProperty("line.separator")
	 */
	String SAUT_LIGNE_PLATEFORME 
		= System.getProperty("line.separator");
	
	/**
	 * Locale.getDefault().
	 */
	Locale LOCALE_PLATEFORME 
		= Locale.getDefault();
	
	/**
	 * "%1$-40s : %2$-45s".
	 */
	String FORMAT_TOSTRING 
		= "%1$70s : %2$-72s";
	
	/**
	 * "%1$-5d  clé : %2$-35s - valeur : %3$s".
	 */
	String FORMAT_PROPERTIES 
		= "%1$-5d  clé : %2$-45s - valeur : %3$s";

	
	
	/**
	 * retourne la DataSource encapsulée.<br/>
	 * <br/>
	 *
	 * @return : DataSource : javax.sql.DataSource.<br/>
	 */
	DataSource getDataSource();

	
	
	/**
	 * <b>fournit une String pour l'affichage 
	 * du contenu de 
	 * <code>this.dataSource</code></b>.<br/>
	 * <br/>
	 * - retourne null si <code>this.dataSource</code> == null.
	 * <br/>
	 *
	 * @return : String : affichage.<br/>
	 */
	String afficherDataSource();
	
	

} // FIN DE L'INTERFACE IMyDataSource.---------------------------------------
