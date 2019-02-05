package levy.daniel.application.model.utilitaires.jpa.datasource;

import java.util.Locale;

import javax.sql.DataSource;

import levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring.lecteur.LecteurConfigurationBaseSpring;

/**
 * INTERFACE IMyDataSource :<br/>
 * <p>
 * <b>WRAPPER de javax.sql.DataSource</b> permettant de : <br/>
 * <ul>
 * <li><b>instancier une Datasource avec POOL DE CONNEXION</b> 
 * (par exemple <code>com.mchange.v2.c3p0.ComboPooledDataSource</code> 
 * pour le POOL C3P0)
 * héritant de javax.sql.DataSource en lui passant un  
 * <b>fichier de configuration de base SPRING</b> 
 * encapsulé dans un {@link LecteurConfigurationBaseSpring}.</li>
 * <li><b>instancier une Datasource avec POOL DE CONNEXION</b> 
 * (par exemple <code>com.mchange.v2.c3p0.ComboPooledDataSource</code> 
 * pour le POOL C3P0) en lui <b>passant tous ses attributs</b>.</li>
 * <li><b>WRAPPER une <code>javax.sql.DataSource</code></b> 
 * dans <code>this.dataSource</code> de la présente classe 
 * en la <b>typant Datasource avec POOL DE CONNEXION</b> 
 * (par exemple <code>com.mchange.v2.c3p0.ComboPooledDataSource</code> 
 * pour le POOL C3P0)</li>
 * <li><b>afficher tous les attributs de la Datasource typée</b> 
 * avec POOL DE CONNEXION. Ces attributs diffèrent en effet 
 * en fonction du POOL DE CONNEXION utilisé (C3P0, DBCP2, BoneCP
 * , Tomcat JDBC, HikariCP, ...).</li>
 * <li><b>retourner la Datasource typée avec POOL DE CONNEXION</b> 
 * (par exemple <code>com.mchange.v2.c3p0.ComboPooledDataSource</code> 
 * pour le POOL C3P0) encapsulée dans la présente classe</li>
 * </ul>
 * </p>
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
public interface IMyDataSource {

		
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
	 * getter de la DataSource encapsulée avec la visibilité 
	 * javax.sql.DataSource.<br/>
	 *
	 * @return : DataSource : javax.sql.DataSource.<br/>
	 */
	DataSource getDataSource();

	
	
	 /**
	 * Setter de la DataSource encapsulée.<br/>
	 * <ul>
	 * <li>cast la javax.sql.DataSource en type de DataSource 
	 * réellement utilisé par la classe (ComboPooledDataSource, ...).</li>
	 * <li>alimente tous les attributs de la classe 
	 * à partir de pDataSource.</li>
	 * </ul>
	 * 
	 * @param pDataSource : javax.sql.DataSource : 
	 * valeur à passer à <code>this.dataSource</code>.<br/>
	 */
	void setDataSource(
			DataSource pDataSource);
	
	
	
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
