package levy.daniel.application.model.utilitaires.jpa.datasource.impl;

import java.beans.PropertyVetoException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import levy.daniel.application.model.utilitaires.jpa.datasource.IMyDataSource;
import levy.daniel.application.model.utilitaires.spring.configurateurpersistencespring.lecteur.LecteurConfigurationBaseSpring;

/**
 * CLASSE MyDataSourceC3P0 :<br/>
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
public class MyDataSourceC3P0 implements IMyDataSource {

	// ************************ATTRIBUTS************************************/

	/**
	 * URL de la BASE.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.connexion.url</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.url</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.url</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String url;
	
	/**
	 * DRIVER JDBC de la BASE (sous forme de String).
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.driver</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.driver</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.driver</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String driver;
	
	/**
	 * LOGIN de la BASE.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.connection.username</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.user</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.user</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String userName;
	
	/**
	 * MOT DE PASSE de la BASE.
	 * <ul>
	 * <li>clé : 
	 * <code>javax.persistence.jdbc.connection.password</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>javax.persistence.jdbc.password</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>javax.persistence.jdbc.password</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String password;

	/**
	 * Taille initiale du pool de connexion C3P0 pour Hibernate.
	 */
	private transient String poolInitialSize;
	
	/**
	 * Taille minimale du pool de connexion C3P0 pour Hibernate.
	 * <ul>
	 * <li>clé : 
	 * <code>spring.jpa.properties.hibernate.c3p0.min_size</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>hibernate.c3p0.min_size</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.c3p0.min_size</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String poolMinSize;
	
	/**
	 * Taille maximale du pool de connexion C3P0 pour Hibernate.
	 * <ul>
	 * <li>clé : 
	 * <code>spring.jpa.properties.hibernate.c3p0.max_size</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>hibernate.c3p0.max_size</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.c3p0.max_size</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String poolMaxSize;
	
	/**
	 * Timeout du pool de connexion C3P0 pour Hibernate.
	 * <ul>
	 * <li>clé : 
	 * <code>spring.jpa.properties.hibernate.c3p0.timeout</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>hibernate.c3p0.timeout</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.c3p0.timeout</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String poolTimeOut;
	
	/**
	 * taille du cache de PreparedStatements du pool de connexion 
	 * C3P0 pour Hibernate.
	 * <ul>
	 * <li>clé : 
	 * <code>spring.jpa.properties.hibernate.c3p0.max_statements</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>hibernate.c3p0.max_statements</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.c3p0.max_statements</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String poolMaxStatements;
	
	/**
	 * période de recherche des connexions inactives 
	 * du pool de connexion C3P0 pour Hibernate.
	 * <ul>
	 * <li>clé : 
	 * <code>spring.jpa.properties.hibernate.c3p0.idle_test_period</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>hibernate.c3p0.idle_test_period</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.c3p0.idle_test_period</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String poolIdleTestPeriod;

	/**
	 * nombre de connexions acquises en une seule fois 
	 * lorsque le pool de connexion C3P0 pour Hibernate est épuisé.
	 * <ul>
	 * <li>clé : 
	 * <code>spring.jpa.properties.hibernate.c3p0.acquire_increment</code> 
	 * dans le fichier properties SPRING</li>
	 * <li>clé : property nommée <code>hibernate.c3p0.acquire_increment</code> 
	 * dans un persistence.xml préconisé par JPA</li>
	 * <li>clé : <code>hibernate.c3p0.acquire_increment</code> 
	 * dans un EntityManagerFactory créé par le 
	 * PersistenceProvider HIBERNATE</li>
	 * </ul>
	 */
	private transient String poolAcquireIncrement;

	/**
	 * .
	 */
	private transient ComboPooledDataSource dataSource;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(MyDataSourceC3P0.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR MALIN.<br/>
	 * 
	 * @param pLecteurConfigurationBaseSpring : 
	 * LecteurConfigurationBaseSpring.<br/>
	 */
	public MyDataSourceC3P0(
			final LecteurConfigurationBaseSpring 
					pLecteurConfigurationBaseSpring) {
		
		this(pLecteurConfigurationBaseSpring.getUrl()
				, pLecteurConfigurationBaseSpring.getDriver()
				, pLecteurConfigurationBaseSpring.getUserName()
				, pLecteurConfigurationBaseSpring.getPassword()
				, null
				, pLecteurConfigurationBaseSpring.getPoolMinSize()
				, pLecteurConfigurationBaseSpring.getPoolMaxSize()
				, pLecteurConfigurationBaseSpring.getPoolTimeOut()
				, pLecteurConfigurationBaseSpring.getPoolMaxStatements()
				, pLecteurConfigurationBaseSpring.getPoolIdleTestPeriod()
				, pLecteurConfigurationBaseSpring.getPoolAcquireIncrement());
		
	} // Fin de CONSTRUCTEUR MALIN.________________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * 
	 * @param pUrl
	 * @param pDriver
	 * @param pUserName
	 * @param pPassword
	 * @param pPoolInitialSize 
	 * @param pPoolMinSize
	 * @param pPoolMaxSize
	 * @param pPoolTimeOut
	 * @param pPoolMaxStatements
	 * @param pPoolIdleTestPeriod
	 * @param pPoolAcquireIncrement
	 */
	public MyDataSourceC3P0(
			final String pUrl
				, final String pDriver
				, final String pUserName, final String pPassword
				, final String pPoolInitialSize
				, final String pPoolMinSize, final String pPoolMaxSize
				, final String pPoolTimeOut
				, final String pPoolMaxStatements
				, final String pPoolIdleTestPeriod
				, final String pPoolAcquireIncrement) {
		
		super();
		
		this.url = pUrl;
		this.driver = pDriver;
		this.userName = pUserName;
		this.password = pPassword;
		
		if (pPoolInitialSize == null) {
			this.poolInitialSize = pPoolMinSize;
		} else {
			this.poolInitialSize = pPoolInitialSize;
		}
		
		this.poolMinSize = pPoolMinSize;
		this.poolMaxSize = pPoolMaxSize;
		this.poolTimeOut = pPoolTimeOut;
		this.poolMaxStatements = pPoolMaxStatements;
		this.poolIdleTestPeriod = pPoolIdleTestPeriod;
		this.poolAcquireIncrement = pPoolAcquireIncrement;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	 /**
	 * CONSTRUCTEUR MALIN.<br/>
	 * 
	 * @param pDataSource : ComboPooledDataSource.<br/>
	 */
	public MyDataSourceC3P0(
			final ComboPooledDataSource pDataSource) {
		
		super();
		
		this.dataSource = pDataSource;
		
		this.url = this.dataSource.getJdbcUrl();
		this.driver = this.dataSource.getDriverClass();
		this.userName = this.dataSource.getUser();
		this.password = this.dataSource.getPassword();
		
		this.poolInitialSize 
			= String.valueOf(this.dataSource.getInitialPoolSize());
		
		this.poolMinSize 
			= String.valueOf(this.dataSource.getMinPoolSize());
		
		this.poolMaxSize 
			= String.valueOf(this.dataSource.getMaxPoolSize());
		
		this.poolTimeOut 
		= String.valueOf(this.dataSource.getUnreturnedConnectionTimeout());
		
		this.poolMaxStatements 
			= String.valueOf(this.dataSource.getMaxStatements());
		
		this.poolIdleTestPeriod 
		= String.valueOf(this.dataSource.getIdleConnectionTestPeriod());
		
		this.poolAcquireIncrement 
			= String.valueOf(this.dataSource.getAcquireIncrement());
		
	} // Fin de CONSTRUCTEUR MALIN.________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataSource getDataSource() {
		
		this.dataSource = new ComboPooledDataSource();
			
		/* url. */
		this.dataSource.setJdbcUrl(this.url);
		
		/* driver. */
		try {
			this.dataSource.setDriverClass(this.driver);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		/* userName. */
		this.dataSource.setUser(this.userName);
		
		/* password. */
		this.dataSource.setPassword(this.password);
		
		/* initialPoolSize. */
		this.dataSource.setInitialPoolSize(
				this.fournirIntPoolMinSize(
						this.poolMinSize));
		
		/* poolMinSize. */
		this.dataSource.setMinPoolSize(
				this.fournirIntPoolMinSize(
						this.poolMinSize));
		
		/* poolMaxSize. */
		this.dataSource.setMaxPoolSize(
				this.fournirIntPoolMaxSize(
						this.poolMaxSize));
		
		/* poolTimeOut. */
		this.dataSource.setUnreturnedConnectionTimeout(
				this.fournirIntPoolTimeOut(
						this.poolTimeOut));
		
		/* poolMaxStatements. */
		this.dataSource.setMaxStatements(
				this.fournirIntPoolMaxStatements(
						this.poolMaxStatements));
		
		/* poolIdleTestPeriod. */
		this.dataSource.setIdleConnectionTestPeriod(
				this.fournirIntPoolIdleTestPeriod(
						this.poolIdleTestPeriod));
		
		/* poolAcquireIncrement. */
		this.dataSource.setAcquireIncrement(
				this.fournirIntPoolAcquireIncrement(
						this.poolAcquireIncrement));
		
		return this.dataSource;
		
	} // Fin de getDataSource().___________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherDataSource() {
		
		final StringBuilder stb = new StringBuilder();
		
		stb.append(SAUT_LIGNE_PLATEFORME);
		stb.append("CONTENU DE LA DATASOURCE DANS MyDataSourceC3P0 : ");
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* DRIVER. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "DRIVER", this.driver));		
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* URL. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "URL", this.url));
		stb.append(SAUT_LIGNE_PLATEFORME);

		/* LOGIN. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
							, "USERNAME (LOGIN)", this.userName));
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* PASSWORD. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "PASSWORD", this.password));
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* CLASSE. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "CLASSE DE LA DATASOURCE"
								, this.dataSource.getClass().getName()));
		stb.append(SAUT_LIGNE_PLATEFORME);
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* poolInitialSize. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "Taille initiale du Pool"
								, this.poolInitialSize));
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* poolMinSize. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "Taille minimale du Pool"
								, this.poolMinSize));
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* poolMaxSize. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "Taille maximale du Pool"
								, this.poolMaxSize));
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* poolTimeOut. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "TimeOut en secondes"
								, this.poolTimeOut));
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* poolMaxStatements. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "MaxStatements"
								, this.poolMaxStatements));
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* poolIdleTestPeriod. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "Période en secondes de vérification des connexions inactives (poolIdleTestPeriod)"
								, this.poolIdleTestPeriod));
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		/* poolAcquireIncrement. */
		stb.append(
				String.format(
						LOCALE_PLATEFORME
							, FORMAT_TOSTRING
								, "poolAcquireIncrement"
								, this.poolAcquireIncrement));
		stb.append(SAUT_LIGNE_PLATEFORME);
		
		return stb.toString();

	} // Fin de afficherDataSource().______________________________________

	
	
	/**
	 * <b>retourne une valeur entière pour this.poolMinSize 
	 * à partir d'une String pPoolMinSize</b>.<br/>
	 * <br/>
	 * - retourne 5 si pPoolMinSize est blank.<br/>
	 * - retourne 5 si pPoolMinSize n'est pas parsable en entier.<br/>
	 * <br/>
	 *
	 * @param pPoolMinSize : String.<br/>
	 * 
	 * @return : int.<br/>
	 */
	private int fournirIntPoolMinSize(
			final String pPoolMinSize) {
		
		/* retourne 5 si pPoolMinSize est blank. */
		if (StringUtils.isBlank(pPoolMinSize)) {
			return 5;
		}
		
		int resultat = 5;
		
		try {
			resultat = Integer.parseInt(pPoolMinSize);
		} catch (NumberFormatException e) {
			/* retourne 5 si pPoolMinSize n'est pas parsable en entier. */
			resultat = 5;
		}
		
		return resultat;
		
	} // Fin de fournirIntPoolMinSize(...).________________________________

	
	
	/**
	 * <b>retourne une valeur entière pour this.poolMaxSize 
	 * à partir d'une String pPoolMaxSize</b>.<br/>
	 * <br/>
	 * - retourne 20 si pPoolMaxSize est blank.<br/>
	 * - retourne 20 si pPoolMaxSize n'est pas parsable en entier.<br/>
	 * <br/>
	 *
	 * @param pPoolMaxSize : String.<br/>
	 * 
	 * @return : int.<br/>
	 */
	private int fournirIntPoolMaxSize(
			final String pPoolMaxSize) {
		
		/* retourne 20 si pPoolMaxSize est blank. */
		if (StringUtils.isBlank(pPoolMaxSize)) {
			return 20;
		}
		
		int resultat = 20;
		
		try {
			resultat = Integer.parseInt(pPoolMaxSize);
		} catch (NumberFormatException e) {
			/* retourne 20 si pPoolMaxSize n'est pas parsable en entier. */
			resultat = 20;
		}
		
		return resultat;
		
	} // Fin de fournirIntPoolMaxSize(...).________________________________

	
	
	/**
	 * <b>retourne une valeur entière pour this.poolTimeOut 
	 * à partir d'une String pPoolTimeOut</b>.<br/>
	 * <br/>
	 * - retourne 500 si pPoolTimeOut est blank.<br/>
	 * - retourne 500 si pPoolTimeOut n'est pas parsable en entier.<br/>
	 * <br/>
	 *
	 * @param pPoolTimeOut : String.<br/>
	 * 
	 * @return : int.<br/>
	 */
	private int fournirIntPoolTimeOut(
			final String pPoolTimeOut) {
		
		/* retourne 500 si pPoolTimeOut est blank. */
		if (StringUtils.isBlank(pPoolTimeOut)) {
			return 500;
		}
		
		int resultat = 500;
		
		try {
			resultat = Integer.parseInt(pPoolTimeOut);
		} catch (NumberFormatException e) {
			/* retourne 500 si pPoolTimeOut n'est pas parsable en entier. */
			resultat = 500;
		}
		
		return resultat;
		
	} // Fin de fournirIntPoolTimeOut(...).________________________________

	
	
	/**
	 * <b>retourne une valeur entière pour this.poolMaxStatements 
	 * à partir d'une String pPoolMaxStatements</b>.<br/>
	 * <br/>
	 * - retourne 50 si pPoolMaxStatements est blank.<br/>
	 * - retourne 50 si pPoolMaxStatements n'est pas parsable en entier.<br/>
	 * <br/>
	 *
	 * @param pPoolMaxStatements : String.<br/>
	 * 
	 * @return : int.<br/>
	 */
	private int fournirIntPoolMaxStatements(
			final String pPoolMaxStatements) {
		
		/* retourne 50 si pPoolMaxStatements est blank. */
		if (StringUtils.isBlank(pPoolMaxStatements)) {
			return 50;
		}
		
		int resultat = 50;
		
		try {
			resultat = Integer.parseInt(pPoolMaxStatements);
		} catch (NumberFormatException e) {
			/* retourne 50 si pPoolMaxStatements 
			 * n'est pas parsable en entier. */
			resultat = 50;
		}
		
		return resultat;
		
	} // Fin de fournirIntPoolMaxStatements(...).__________________________

	
	
	/**
	 * <b>retourne une valeur entière pour this.poolIdleTestPeriod 
	 * à partir d'une String pPoolIdleTestPeriod</b>.<br/>
	 * <br/>
	 * - retourne 2000 si pPoolIdleTestPeriod est blank.<br/>
	 * - retourne 2000 si pPoolIdleTestPeriod n'est pas parsable en entier.<br/>
	 * <br/>
	 *
	 * @param pPoolIdleTestPeriod : String.<br/>
	 * 
	 * @return : int.<br/>
	 */
	private int fournirIntPoolIdleTestPeriod(
			final String pPoolIdleTestPeriod) {
		
		/* retourne 2000 si pPoolIdleTestPeriod est blank. */
		if (StringUtils.isBlank(pPoolIdleTestPeriod)) {
			return 2000;
		}
		
		int resultat = 2000;
		
		try {
			resultat = Integer.parseInt(pPoolIdleTestPeriod);
		} catch (NumberFormatException e) {
			/* retourne 2000 si pPoolIdleTestPeriod 
			 * n'est pas parsable en entier. */
			resultat = 2000;
		}
		
		return resultat;
		
	} // Fin de fournirIntPoolIdleTestPeriod(...)._________________________

	
	
	/**
	 * <b>retourne une valeur entière pour this.poolAcquireIncrement 
	 * à partir d'une String pPoolAcquireIncrement</b>.<br/>
	 * <br/>
	 * - retourne 1 si pPoolAcquireIncrement est blank.<br/>
	 * - retourne 1 si pPoolAcquireIncrement n'est pas parsable en entier.<br/>
	 * <br/>
	 *
	 * @param pPoolAcquireIncrement : String.<br/>
	 * 
	 * @return : int.<br/>
	 */
	private int fournirIntPoolAcquireIncrement(
			final String pPoolAcquireIncrement) {
		
		/* retourne 1 si pPoolAcquireIncrement est blank. */
		if (StringUtils.isBlank(pPoolAcquireIncrement)) {
			return 1;
		}
		
		int resultat = 1;
		
		try {
			resultat = Integer.parseInt(pPoolAcquireIncrement);
		} catch (NumberFormatException e) {
			/* retourne 1 si pPoolAcquireIncrement 
			 * n'est pas parsable en entier. */
			resultat = 1;
		}
		
		return resultat;
		
	} // Fin de fournirIntPoolAcquireIncrement(...)._______________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Connection getConnection() throws SQLException {
		return this.dataSource.getConnection();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Connection getConnection(
			final String pUsername, final String pPassword) 
											throws SQLException {
		return this.dataSource.getConnection(pUsername, pPassword);
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return this.dataSource.getLogWriter();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLogWriter(
			final PrintWriter pOut) throws SQLException {
		this.dataSource.setLogWriter(pOut);
		
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLoginTimeout() throws SQLException {
		return this.dataSource.getLoginTimeout();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLoginTimeout(
			final int pSeconds) throws SQLException {
		this.dataSource.setLoginTimeout(pSeconds);		
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return this.dataSource.getParentLogger();
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T unwrap(Class<T> pIface) throws SQLException {
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isWrapperFor(Class<?> pIface) throws SQLException {
		return false;
	}
	
	
} // FIN DE LA CLASSE MyDataSourceC3P0.--------------------------------------
