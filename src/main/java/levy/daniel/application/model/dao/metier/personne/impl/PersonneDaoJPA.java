package levy.daniel.application.model.dao.metier.personne.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.JPAUtils;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.daoexceptions.GestionnaireDaoException;
import levy.daniel.application.model.metier.personne.IPersonne;
import levy.daniel.application.model.metier.personne.impl.Personne;


/**
 * CLASSE PersonneDaoJPA :<br/>
 * DAO JPA pour les Personne.<br/>
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
 * @since 25 mai 2018
 *
 */
public class PersonneDaoJPA {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_PERSONNEDAOJPA : String :<br/>
	 * "Classe PersonneDaoJPA".<br/>
	 */
	public static final String CLASSE_PERSONNEDAOJPA 
		= "Classe PersonneDaoJPA";
	
	/**
	 * METHODE_CREATE : String :<br/>
	 * "Méthode create(IPersonne pObject)".<br/>
	 */
	public static final String  METHODE_CREATE 
		= "Méthode create(IPersonne pObject)";
	
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';

	
	/**
	 * MESSAGE_ENTITYMANAGER_NULL : String :<br/>
	 * "this.entityManager est NULL dans PersonneDaoJPA".<br/>
	 */
	public static final String MESSAGE_ENTITYMANAGER_NULL 
		= "this.entityManager est NULL dans PersonneDaoJPA";
	

	/**
	 * SELECT_OBJET : String :<br/>
	 * "select personne from 
	 * PersonneEntityJPA as personne ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select personne from "
				+ "PersonneEntityJPA as personne ";
	
	/**
	 * entityManagerFactory : EntityManagerFactory :<br/>
	 * EntityManagerFactory JPA.<br/>
	 */
	private transient EntityManagerFactory entityManagerFactory;
	
	/**
	 * entityManager : EntityManager :<br/>
	 * EntityManager JPA.<br/>
	 */
	private transient EntityManager entityManager;
	
	/**
	 * gestionnaireException : GestionnaireDaoException :<br/>
	 * Gestionnaire pour les Exceptions de DAO.<br/>
	 */
	private final transient GestionnaireDaoException gestionnaireException 
		= new GestionnaireDaoException();

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(PersonneDaoJPA.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR PersonneDaoJPA() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public PersonneDaoJPA() {
		
		super();
		
		this.instancierContextJPA();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method instancierContextJPA() :<br/>
	 * Instancie le Contexte JPA 
	 * (EntityManagerFactory).<br/>
	 * <ul>
	 * <li>lit le contexte de persistence dans META-INF/persistence.xml 
	 * (connexion à la base, driver, ORM, ...).</li>
	 * <li>récupère une instance d'EntityManager auprès de la Factory.</li>
	 * </ul>
	 */
	private void instancierContextJPA() {
		
		/* lit le contexte de persistence dans 
		 * META-INF/persistence.xml 
		 * (connexion à la base, driver, ORM, ...). */
		try {
			this.entityManagerFactory = JPAUtils.getEntityManagerFactory();
		}
		catch (Exception e) {
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal("Problèmes de Persistence", e);
			}
		}
						
	} // Fin de instancierContextJPA().____________________________________
	

	
	/**
	 * method instancierEntityManager() :<br/>
	 * Instancie this.entityManager en récupérant 
	 * une instance auprès de la Factory.<br/>
	 * <ul>
	 * <li>Opération à faire dans chaque action 
	 * (create, delete, ...).</li>
	 * <li>EntityManager ne supporte pas le
	 *  MultiThreading et doit être 
	 * <b>créé</b> et <b>détruit</b> à chaque 
	 * utilisation par un Thread</li>
	 * </ul>
	 */
	private void instancierEntityManager() {
		
		if (this.entityManagerFactory != null) {
			/* récupère une instance d'EntityManager 
			 * auprès de la Factory. */
			this.entityManager 
				= this.entityManagerFactory.createEntityManager();
		}
	} // Fin de instancierEntityManager()._________________________________
	
	
	
	/**
	 * method creerPersonne(
	 * PersonneEntityJPA pPersonne) :<br/>
	 * Crée une Personne à partir d'une PersonneEntityJPA.<br/>
	 * <br/>
	 * retourne null si pPersonne == null.<br/>
	 * <br/>
	 *
	 * @param pPersonne : PersonneEntityJPA.<br/>
	 * 
	 * @return : IPersonne.<br/>
	 */
	private IPersonne creerPersonne(
			final PersonneEntityJPA pPersonne) {
		
		/* retourne null si pPersonne == null. */
		if (pPersonne == null) {
			return null;
		}
		
		final IPersonne personne 
			= new Personne(pPersonne.getId()
					, pPersonne.getPrenom()
					, pPersonne.getNom()
					, pPersonne.getRue()
					, pPersonne.getCodePostal()
					, pPersonne.getVille()
					, pPersonne.getDateNaissance());
		
		return personne;
		
	} // Fin de creerPersonne(...).________________________________________
	
	
	
	/**
	 * method convertirListModelEnEntities(
	 * Iterable&lt;IPersonne&gt; pList) :<br/>
	 * convertit une Liste de Personne (MODEL) en liste 
	 * de PersonneEntityJPA (Entities JPA).<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IPersonne&gt;
	 * 
	 * @return : List&lt;PersonneEntityJPA&gt;.<br/>
	 */
	private List<PersonneEntityJPA> convertirListModelEnEntities(
			final Iterable<IPersonne> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<PersonneEntityJPA> resultat 
			= new ArrayList<PersonneEntityJPA>();
		
		for (final IPersonne personne : pList) {
			
			if (personne != null) {
				
				final PersonneEntityJPA personneJAXB 
					= new PersonneEntityJPA(personne);
				
				resultat.add(personneJAXB);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________
	

		
	/**
	 * method convertirListEntitiesEnModel(
	 * List&lt;PersonneEntityJPA&gt; pList) :<br/>
	 * convertit une Liste de PersonneEntityJPA (Entities JPA) 
	 * en liste de Personne (MODEL).<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;PersonneEntityJPA&gt;.<br/>
	 * 
	 * @return : List&lt;IPersonne&gt;.<br/>
	 */
	private List<IPersonne> convertirListEntitiesEnModel(
			final List<PersonneEntityJPA> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<IPersonne> resultat 
			= new ArrayList<IPersonne>();
		
		for (final PersonneEntityJPA personne : pList) {
			
			if (personne != null) {
				
				final IPersonne personneModel 
					= this.creerPersonne(personne);
				
				resultat.add(personneModel);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListEntitiesEnModel(...)._________________________
	
	
	
	
	/* CREATE ************/
	
	/**
	 * method create(
	 * IPersonne pObject) :<br/>
	 * Crée un Objet en base.<br/>
	 * <br/>
	 *
	 * @param pObject : IPersonne.<br/>
	 * 
	 * @return : IPersonne : Objet persisté en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public IPersonne create(
			final IPersonne pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		IPersonne persistentObject = null;
		
		/* TRANSACTIONNEL. ****/
		/* instancie un EntityManager. */
		this.instancierEntityManager();
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
		
		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}
		
		/* TRANSACTIONNEL. ****/
		EntityTransaction transaction = null;
		
		if (this.entityManager != null) {
			transaction = this.entityManager.getTransaction();
		}
		
		if (transaction == null) {
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal("Create - Transaction null");
			}
			return null;
		}
		
		
		try {
			
			/* TRANSACTIONNEL. ****/	
			transaction.begin();
			
			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(pObject);
					
			persistentObject = pObject;
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();
												
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			transaction.rollback();
			
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAOJPA
							, METHODE_CREATE, e);
						
		}
		finally {
			
			/* TRANSACTIONNEL. *****/
			/* détruit l'entityManager. */
			if (this.entityManager != null) {
				this.entityManager.close();
				
			}
		}
		
		/* retourne l'Objet persistant. */
		return persistentObject;
				
	} // Fin de create(...)._______________________________________________
	

	
	/**
	 * method save(
	 * Iterable&lt;IPersonne&gt; pObjects) :<br/>
	 * <ul>
	 * <li>Sauvegarde en base tous les objets métier de type IPersonne 
	 * contenus dans la collection itérable d'objets métier 
	 * de type IPersonne "pObjects".</li>
	 * <li>Retourne la Collection itérable (List&lt;IPersonne&gt;) 
	 * d'objets de type IPersonne sauvegardés en base.</li>
	 * <li>ne <b>sauvegarde pas et n'ajoute pas à la Collection 
	 * retournée un doublon</b> présent dans le lot pObjects sans lever 
	 * d'Exception (test de l'existence avant la mise en base).</li>
	 * <li>Ne fait rien et continue si un objet est null 
	 * dans le lot pObjects.</li>
	 * </ul>
	 * retourne null si pObjects == null.<br/>
	 * jette une AbstractDaoException si pObjects n'a pu être enregistrée 
	 * en base (doublon, Exception, ...).<br/>
	 * <br/>
	 *
	 * @param pObjects : Iterable&lt;IPersonne&gt; : 
	 * collection itérable d'objets métier de type IPersonne.<br/>
	 *  
	 * @return : Iterable&lt;IPersonne&gt; : La Collection itérable d'objets 
	 * de type IPersonne sauvegardés en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final Iterable<IPersonne> save(
			final Iterable<IPersonne> pObjects) 
			throws AbstractDaoException {

		/* retourne null si pObjects == null. */
		if (pObjects == null) {
			return null;
		}

		/* conversion des MODEL en ENTITIES. */
		final List<PersonneEntityJPA> listeEntities 
			= this.convertirListModelEnEntities(pObjects);
		
		/* TRANSACTIONNEL. ****/
		/* instancie un EntityManager. */
		this.instancierEntityManager();
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* TRANSACTIONNEL. ****/
		EntityTransaction transaction = null;
		
		if (this.entityManager != null) {
			transaction = this.entityManager.getTransaction();
		}
		
		if (transaction == null) {
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal("Create - Transaction null");
			}
			return null;
		}

		
		final List<IPersonne> resultat = new ArrayList<IPersonne>();

		final Iterator<PersonneEntityJPA> iteS = listeEntities.iterator();

		try {

			while (iteS.hasNext()) {

				final IPersonne objet = iteS.next();
				
				/* Passe les doublons existants en base. */
				if (!this.exists(objet)) {
					
					/* passe un null dans le lot. */
					if (objet != null) {
						
						IPersonne objetPersistant = null;

						try {
							
							/* TRANSACTIONNEL. ****/	
							transaction.begin();
							
							/* PERSISTE en base. */
							this.entityManager.persist(objet);
							
							objetPersistant = objet;
							
							/* TRANSACTIONNEL. *****/
							transaction.commit();
							
						} catch (Exception e) {
							
							/* TRANSACTIONNEL. *****/
							transaction.rollback();
							
							/* LOG. */
							if (LOG.isDebugEnabled()) {
								LOG.debug(e.getMessage(), e);
							}
							
							/* Gestion de la DAO Exception. */
							this.gestionnaireException
								.gererException(
										CLASSE_PERSONNEDAOJPA
											, "Méthode save(Iterable)", e);
						}
						
						
						/* ne sauvegarde pas un doublon 
						 * présent dans le lot. */
						if (objetPersistant != null) {
							
							/* Ajoute à l'iterable resultat. */
							resultat.add(objetPersistant);								
						}						
					}					
				}				
			} // Next._____________________________________

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAOJPA
							, "Méthode save(Iterable)", e);

		}
		finally {
			
			/* TRANSACTIONNEL. *****/
			/* détruit l'entityManager. */
			if (this.entityManager != null) {
				this.entityManager.close();
				
			}
		}

		/* retourne l'iterable resultat. */
		return resultat;

	} // Fin de save(...)._________________________________________________

	
	
	
	
	/* READ *************/
	

	
	/**
	 * method retrieve(
	 * IPersonne pObject) :<br/>
	 * <ul>
	 * <li>Recherche un objet métier de Type 
	 * IPersonne pObject en base.</li>
	 * </ul>
	 * Retourne null si aucun objet equals à pObject 
	 * est retrouvé en base.<br/>
	 * La base doit avoir un index d'unicité sur equals(...).<br/>
	 * <br/>
	 *
	 * @param pObject : IPersonne.<br/>
	 * 
	 * @return : IPersonne : objet métier existant en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public IPersonne retrieve(
			final IPersonne pObject) throws AbstractDaoException {
		
		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		IPersonne objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where personne.prenom = :pPrenom "
				+ "and personne.nom = :pNom "
				+ "and personne.dateNaissance = :pDateNaissance";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pPrenom", pObject.getPrenom());
		requete.setParameter("pNom", pObject.getNom());
		requete.setParameter("pDateNaissance", pObject.getDateNaissance());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (IPersonne) requete.getSingleResult();
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAOJPA
						, "Méthode retrieve(IPersonne pObject)", e);
		}
				
		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________
	

	
	/**
	 * method findById(
	 * Long pId) :<br/>
	 * <ul>
	 * <li>Recherche un Objet métier de Type 
	 * IPersonne via son ID en base.</li>
	 * </ul>
	 * retourne null si pId == null.<br/>
	 * retourne null si pId n'existe pas en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base de l'Objet métier.<br/>
	 * 
	 * @return : IPersonne : Objet métier existant en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public IPersonne findById(
			final Long pId) throws AbstractDaoException {
		
		IPersonne objetTrouve = null;
		
		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		try {
			
			objetTrouve 
				= this.entityManager.find(IPersonne.class, pId);
			
		}
		catch (Exception e) {
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAOJPA
						, "Méthode findById(ID)", e);
			
		}
		
		return objetTrouve;
				
	} // Fin de findById(...)._____________________________________________
	

	
	/**
	 * method findAll() :<br/>
	 * <ul>
	 * <li>Retourne la liste de tous les objets métier de Type IPersonne 
	 * présents en base.</li>
	 * </ul>
	 *
	 * @return : List&lt;IPersonne&gt; : 
	 * liste de tous les objets métier de Type IPersonne 
	 * présents en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public List<IPersonne> findAll() throws AbstractDaoException {
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from IPersonne";
		
		List<IPersonne> resultat = null;
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* Exécute la javax.persistence.Query. */
			resultat = query.getResultList();

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAOJPA
						, "Méthode findall()", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAll()._________________________________________________


	
	/* UPDATE *************/
	
	/**
	 * method update(
	 * IPersonne pObject) :<br/>
	 * <ul>
	 * <li><b>Modifie</b> un objet métier <b>persistant</b> 
	 * de Type IPersonne pObject.</li>
	 * <li>Retourne l'objet métier de Type IPersonne 
	 * pObject modifié en base.</li>
	 * </ul>
	 * retourne null si pObject == null.<br/>
	 * ne fait rien et retourne l'instance détachée 
	 * si pObject n'est pas déjà persistant en base.<br/>
	 * <br/>
	 * <code>Exemple de code : </code><br/>
	 * <code>// Récupération de l'objet persistant à modifier.</code><br/>
	 * <code>objet1Persistant = this.daoUserSimple.retrieve(objet1);</code><br/>
	 * <code>// Modifications.</code><br/>
	 * <code>objet1Persistant.setPrenom("Jean-Frédéric modifié");</code><br/>
	 * <code>objet1Persistant.setNom("Bôrne modifié");</code><br/>
	 * <code>// Application des modifications en base.</code><br/>
	 * <code>objet1ModifiePersistant = 
	 * this.daoUserSimple.<b>update(objet1Persistant)</b>;</code><br/>
	 * <br/>
	 *
	 * @param pObject : IPersonne.<br/>
	 * 
	 * @return : IPersonne : objet métier de Type IPersonne
	 * modifié en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final IPersonne update(
			final IPersonne pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		} // Fin de this.entityManager == null.____________

		
		/* retourne pObject si l'objet n'est pas 
		 * déjà persistant en base. */
		if (!this.exists(pObject)) {
			return pObject;
		}

		IPersonne persistentObject = null;
		
		try {
			
			/* MODIFIE en base. */
			this.entityManager.merge(pObject);
			
			persistentObject = pObject;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAOJPA
						, "Méthode update(IPersonne Object)", e);
						
		}
				
		/* retourne l'Objet persistant modifié. */
		return persistentObject;
		
	} // Fin de update(...)._______________________________________________

		
	
	/* DELETE *************/
	
	
	/**
	 * method delete(
	 * IPersonne pObject) :<br/>
	 * <ul>
	 * <li>Détruit un Objet métier de Type IPersonne pObject
	 * existant en base.</li>
	 * <li>Vérifie que pObject est déjà persistant en base.</li>
	 * <li>Retourne un boolean (true si OK) précisant 
	 * si l'opération de destruction a eu lieu.</li>
	 * </ul>
	 * retourne false si pObject == null.<br/>
	 * retourne false si l'objet n'existait pas en base.<br/>
	 * <br/>
	 *
	 * @param pObject : IPersonne.<br/>
	 * 
	 * @return : boolean : true si l'objet métier de Type IPersonne
	 * a été détruit en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final boolean delete(
			final IPersonne pObject) throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}

		boolean resultat = false;
		
		/* Vérifie qu'il existe une instance persistante. */
		final IPersonne persistanceInstance = this.retrieve(pObject);
		
		try {
								
			if (persistanceInstance != null) {
				
				/* merge avant de pouvoir détruire. */
				this.entityManager.merge(persistanceInstance);
				
				/* DESTRUCTION. */
				this.entityManager.remove(persistanceInstance);
				
				resultat = true;
				
			}
			else {
				resultat = false;
			}
			
		} catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAOJPA
						, "Méthode delete(IPersonne pObject)", e);
									
		}
				
		return resultat;
										
	} // Fin de delete(...)._______________________________________________


	
	/**
	 * method deleteById(
	 * Long pId) :<br/>
	 * <ul>
	 * <li>Détruit un Objet métier de Type IPersonne 
	 * existant en base via son ID de Type Long.</li>
	 * </ul>
	 * ne fait rien si pId est null.<br/>
	 * ne fait rien si pId n'existe pas en base.<br/>
	 * <br/>
	 * 
	 * @param pId : Long : ID en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final void deleteById(
			final Long pId) throws AbstractDaoException {
		
		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}

		IPersonne objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where personne.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (IPersonne) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objetPersistant = null;
		}

		
		try {
			
			if (objetPersistant != null) {
				
				/* Merge avant destruction. */
				this.entityManager.merge(objetPersistant);
				
				/* DESTRUCTION. */
				this.entityManager.remove(objetPersistant);
				
			}

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_PERSONNEDAOJPA
						, "Méthode deleteById(Long pId)", e);
		}
		
	} // Fin de deleteById(...).___________________________________________

	
		
	/**
	 * method deleteBoolean(
	 * Long pId) :<br/>
	 * <ul>
	 * <li>Détruit un Objet métier de Type IPersonne
	 * existant en base via son ID en base.</li>
	 * <li>Retourne un boolean (true si OK) précisant 
	 * si l'opération de destruction a eu lieu.</li>
	 * </ul>
	 * retourne false si pId est null.<br/>
	 * retourne false si pId n'existe pas en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * 
	 * @return boolean : true si l'objet d'ID pId 
	 * a été détruit en base.<br:>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final boolean deleteByIdBoolean(
			final Long pId) throws AbstractDaoException {
		
		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}
		
		boolean resultat = false;
		
		IPersonne objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where personne.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (IPersonne) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objetPersistant = null;
			resultat = false;
		}
		
		try {
			
			if (objetPersistant != null) {
				
				/* Merge avant destruction. */
				this.entityManager.merge(objetPersistant);
				
				/* DESTRUCTION. */
				this.entityManager.remove(objetPersistant);
				
				resultat = true;
			}

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_PERSONNEDAOJPA
						, "Méthode deleteByIdBoolean(Long pId)", e);
		}
		
		return resultat;
		
	} // Fin de deleteByIdBoolean(...).____________________________________

	

	/**
	 * method deleteAll() :<br/>
	 * <ul>
	 * <li>Détruit en base toutes les instances 
	 * d'Objets métier de Type IPersonne.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final void deleteAll() throws AbstractDaoException {
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from IPersonne";
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAOJPA
						, "Méthode deleteAll()", e);
			
		}
		
	} // Fin de deleteAll()._______________________________________________


	
	/**
	 * method deleteAllBoolean() :<br/>
	 * <ul>
	 * <li>Détruit en base tous les enregistrements 
	 * d'Objets métier de Type IPersonne.</li>
	 * <li>Retourne true si la destruction a bien été effectuée.</li>
	 * </ul>
	 * @return boolean : true si tous les enregistrements 
	 * ont été détruits en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final boolean deleteAllBoolean() throws AbstractDaoException {
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}

		
		boolean resultat = false;
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from IPersonne";
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();
			
			resultat = true;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAOJPA
						, "Méthode deleteAllBoolean()", e);
			
		}
		
		return resultat;
		
	} // Fin de deleteAll()._______________________________________________


	
	/**
	 * method delete(
	 * Iterable&lt;IPersonne&gt; pObjects) :<br/>
	 * <ul>
	 * <li>Détruit en base tous les objets métier de IPersonne
	 * contenus dans la collection itérable pObjects.</li>
	 * </ul>
	 * ne fait rien si pObjects == null.<br/>
	 * ne plante pas si un des objets de la collection 
	 * n'existe pas en base.<br/>
	 * <br/>
	 *
	 * @param pObjects : Iterable&lt;IPersonne&gt; : 
	 * collection itérable d'objets de type IPersonne.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final void delete(
			final Iterable<IPersonne> pObjects) 
						throws AbstractDaoException {
		
		/* ne fait rien si pObjects == null. */
		if (pObjects == null) {
			return;
		}
		
		final Iterator<IPersonne> itePersistants = pObjects.iterator();
		final List<IPersonne> listePersistants 
			= new ArrayList<IPersonne>();
		
		/* Récupération préalable des objets persistans en base. */
		while (itePersistants.hasNext()) {
			final IPersonne objet = itePersistants.next();
			final IPersonne objetPersistant = this.retrieve(objet);
			
			if (objetPersistant != null) {
				listePersistants.add(objetPersistant);
			}
		}
		
		
		/* Itération uniquement sur la liste des Objets persistants. */
		final Iterator<IPersonne> ite = listePersistants.iterator();
		
		try {
			
			while (ite.hasNext()) {
				
				final IPersonne objectPersistant = ite.next();
				
				/* DESTRUCTION. */
				this.entityManager.remove(objectPersistant);
				
			}
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_PERSONNEDAOJPA
					, "Méthode delete(Iterable)", e);
			
		}
				
	} // Fin de delete(...)._______________________________________________

	

	
	/* TOOLS *************/

	
	/**
	 * method exists(
	 * IPersonne pObject) :<br/>
	 * <ul>
	 * <li>Retourne un boolean permettant de déterminer si l'Objet métier 
	 * de Type IPersonne pObject est persisté en base.</li>
	 * <li>Retourne true si l'Objet métier a été trouvé en base.</li>
	 * </ul>
	 * retourne false si l'objet n'existe pas en base.<br/>
	 * <br/>
	 *
	 * @param pObject : IPersonne.<br/>
	 * 
	 * @return boolean : true si l'objet métier existe en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	public boolean exists(
			final IPersonne pObject) throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		boolean resultat = false;		
		IPersonne objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where personne.prenom = :pPrenom "
				+ "and personne.nom = :pNom "
				+ "and personne.dateNaissance = :pDateNaissance";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pPrenom", pObject.getPrenom());
		requete.setParameter("pNom", pObject.getNom());
		requete.setParameter("pDateNaissance", pObject.getDateNaissance());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (IPersonne) requete.getSingleResult();
			
			/* retourne true si l'objet existe en base. */
			if (objetResultat != null) {
				resultat = true;
			}
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne false si l'Objet métier n'existe pas en base. */
			return false;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_PERSONNEDAOJPA
						, "Méthode exists(IPersonne pObject)", e);
		}
				
		return resultat;
		
	} // Fin de exists(...)._______________________________________________
	
	

	/**
	 * method exists(
	 * Long pId) :<br/>
	 * <ul>
	 * <li>Retourne un boolean permettant de déterminer si un Objet métier 
	 * de Type IPersonne avec ID == pId  est persisté en base.</li>
	 * <li>Retourne true si l'Objet métier a été trouvé en base.</li>
	 * </ul>
	 * retourne false si l'objet n'existe pas en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long .<br/>
	 * 
	 * @return boolean : true si l'objet métier de Type IPersonne 
	 * existe en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public boolean exists(
			final Long pId) throws AbstractDaoException {
		
		/* retourne false si pId == null . */
		if (pId == null) {
			return false;
		}
		
		/* retourne true si l'objet métier existe en base. */
		if (this.findById(pId) != null) {
			return true;
		}
		
		return false;
		
	} // Fin de exists(...)._______________________________________________
	

	
	/**
	 * method count() :<br/>
	 * <ul>
	 * <li>Retourne le nombre d'Objets metier 
	 * de type IPersonne présents en base.</li>
	 * </ul>
	 *
	 * @return : Long : 
	 * le nombre d'Objets metier de type IPersonne 
	 * présents en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final Long count() throws AbstractDaoException {
		
		/* Récupère la liste d'Objets métier de Type paramétré T. */
		final List<IPersonne> listObjects = this.findAll();
		
		if (listObjects != null) {
			
			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}
		
		return 0L;
		
	} // Fin de count().___________________________________________________
	
	
	
	/**
	 * method afficherListe(
	 * List&lt;IPersonne&gt; pListe) :<br/>
	 * Retourne une String pour l'affichage à la console 
	 * d'une liste d'Objets métier de type IPersonne.<br/>
	 * <br/>
	 * retourne null si pListe == null.<br/>
	 * <br/>
	 *
	 * @param pListe : List&lt;IPersonne&gt;.<br/>
	 * 
	 * @return : String : String pour affichage à la console.<br/>
	 */
	public final String afficherListe(
			final List<IPersonne> pListe) {
		
		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final IPersonne objet : pListe) {
			stb.append(objet.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
				
		return stb.toString();			

	} // Fin de afficherListe(...).________________________________________
	

	
} // FIN DE LA CLASSE PersonneDaoJPA.----------------------------------------
