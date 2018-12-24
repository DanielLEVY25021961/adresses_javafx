package levy.daniel.application.model.persistence.metier.contactsimple.dao.jpa.impl;

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

import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.persistence.daoexceptions.GestionnaireDaoException;
import levy.daniel.application.model.persistence.metier.JPAUtils;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jpa.ContactSimpleEntityJPA;


/**
 * CLASSE ContactSimpleDaoJPA :<br/>
 * DAO JPA pour les ContactSimple.<br/>
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
public class ContactSimpleDaoJPA {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_PERSONNEDAOJPA : String :<br/>
	 * "Classe ContactSimpleDaoJPA".<br/>
	 */
	public static final String CLASSE_PERSONNEDAOJPA 
		= "Classe ContactSimpleDaoJPA";
	
	/**
	 * METHODE_CREATE : String :<br/>
	 * "Méthode create(IContactSimple pObject)".<br/>
	 */
	public static final String  METHODE_CREATE 
		= "Méthode create(IContactSimple pObject)";
	
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
	 * "this.entityManager est NULL dans ContactSimpleDaoJPA".<br/>
	 */
	public static final String MESSAGE_ENTITYMANAGER_NULL 
		= "this.entityManager est NULL dans ContactSimpleDaoJPA";
	

	/**
	 * SELECT_OBJET : String :<br/>
	 * "select contactSimple from 
	 * ContactSimpleEntityJPA as contactSimple ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select contactSimple from "
				+ "ContactSimpleEntityJPA as contactSimple ";
	
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
	private static final Log LOG = LogFactory.getLog(ContactSimpleDaoJPA.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR ContactSimpleDaoJPA() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ContactSimpleDaoJPA() {
		
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
	 * method creerContactSimple(
	 * ContactSimpleEntityJPA pContactSimple) :<br/>
	 * Crée une ContactSimple à partir d'une ContactSimpleEntityJPA.<br/>
	 * <br/>
	 * retourne null si pContactSimple == null.<br/>
	 * <br/>
	 *
	 * @param pContactSimple : ContactSimpleEntityJPA.<br/>
	 * 
	 * @return : IContactSimple.<br/>
	 */
	private IContactSimple creerContactSimple(
			final ContactSimpleEntityJPA pContactSimple) {
		
		/* retourne null si pContactSimple == null. */
		if (pContactSimple == null) {
			return null;
		}
		
		final IContactSimple contactSimple 
			= new ContactSimple(pContactSimple.getId()
					, pContactSimple.getPrenom()
					, pContactSimple.getNom()
					, pContactSimple.getRue()
					, pContactSimple.getCodePostal()
					, pContactSimple.getVille()
					, pContactSimple.getDateNaissance());
		
		return contactSimple;
		
	} // Fin de creerContactSimple(...).________________________________________
	
	
	
	/**
	 * method convertirListModelEnEntities(
	 * Iterable&lt;IContactSimple&gt; pList) :<br/>
	 * convertit une Liste de ContactSimple (MODEL) en liste 
	 * de ContactSimpleEntityJPA (Entities JPA).<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;
	 * 
	 * @return : List&lt;ContactSimpleEntityJPA&gt;.<br/>
	 */
	private List<ContactSimpleEntityJPA> convertirListModelEnEntities(
			final Iterable<IContactSimple> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<ContactSimpleEntityJPA> resultat 
			= new ArrayList<ContactSimpleEntityJPA>();
		
		for (final IContactSimple contactSimple : pList) {
			
			if (contactSimple != null) {
				
				final ContactSimpleEntityJPA contactSimpleJAXB 
					= new ContactSimpleEntityJPA(contactSimple);
				
				resultat.add(contactSimpleJAXB);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________
	

		
	/**
	 * method convertirListEntitiesEnModel(
	 * List&lt;ContactSimpleEntityJPA&gt; pList) :<br/>
	 * convertit une Liste de ContactSimpleEntityJPA (Entities JPA) 
	 * en liste de ContactSimple (MODEL).<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;ContactSimpleEntityJPA&gt;.<br/>
	 * 
	 * @return : List&lt;IContactSimple&gt;.<br/>
	 */
	private List<IContactSimple> convertirListEntitiesEnModel(
			final List<ContactSimpleEntityJPA> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<IContactSimple> resultat 
			= new ArrayList<IContactSimple>();
		
		for (final ContactSimpleEntityJPA contactSimple : pList) {
			
			if (contactSimple != null) {
				
				final IContactSimple contactSimpleModel 
					= this.creerContactSimple(contactSimple);
				
				resultat.add(contactSimpleModel);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListEntitiesEnModel(...)._________________________
	
	
	
	
	/* CREATE ************/
	
	/**
	 * method create(
	 * IContactSimple pObject) :<br/>
	 * Crée un Objet en base.<br/>
	 * <br/>
	 *
	 * @param pObject : IContactSimple.<br/>
	 * 
	 * @return : IContactSimple : Objet persisté en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public IContactSimple create(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		IContactSimple persistentObject = null;
		
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
	 * Iterable&lt;IContactSimple&gt; pObjects) :<br/>
	 * <ul>
	 * <li>Sauvegarde en base tous les objets métier de type IContactSimple 
	 * contenus dans la collection itérable d'objets métier 
	 * de type IContactSimple "pObjects".</li>
	 * <li>Retourne la Collection itérable (List&lt;IContactSimple&gt;) 
	 * d'objets de type IContactSimple sauvegardés en base.</li>
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
	 * @param pObjects : Iterable&lt;IContactSimple&gt; : 
	 * collection itérable d'objets métier de type IContactSimple.<br/>
	 *  
	 * @return : Iterable&lt;IContactSimple&gt; : La Collection itérable d'objets 
	 * de type IContactSimple sauvegardés en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final Iterable<IContactSimple> save(
			final Iterable<IContactSimple> pObjects) 
			throws AbstractDaoException {

		/* retourne null si pObjects == null. */
		if (pObjects == null) {
			return null;
		}

		/* conversion des MODEL en ENTITIES. */
		final List<ContactSimpleEntityJPA> listeEntities 
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

		
		final List<IContactSimple> resultat = new ArrayList<IContactSimple>();

		final Iterator<ContactSimpleEntityJPA> iteS = listeEntities.iterator();

		try {

			while (iteS.hasNext()) {

				final IContactSimple objet = iteS.next();
				
				/* Passe les doublons existants en base. */
				if (!this.exists(objet)) {
					
					/* passe un null dans le lot. */
					if (objet != null) {
						
						IContactSimple objetPersistant = null;

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
	 * IContactSimple pObject) :<br/>
	 * <ul>
	 * <li>Recherche un objet métier de Type 
	 * IContactSimple pObject en base.</li>
	 * </ul>
	 * Retourne null si aucun objet equals à pObject 
	 * est retrouvé en base.<br/>
	 * La base doit avoir un index d'unicité sur equals(...).<br/>
	 * <br/>
	 *
	 * @param pObject : IContactSimple.<br/>
	 * 
	 * @return : IContactSimple : objet métier existant en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public IContactSimple retrieve(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		IContactSimple objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where contactSimple.prenom = :pPrenom "
				+ "and contactSimple.nom = :pNom "
				+ "and contactSimple.dateNaissance = :pDateNaissance";
		
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
			= (IContactSimple) requete.getSingleResult();
			
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
						, "Méthode retrieve(IContactSimple pObject)", e);
		}
				
		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________
	

	
	/**
	 * method findById(
	 * Long pId) :<br/>
	 * <ul>
	 * <li>Recherche un Objet métier de Type 
	 * IContactSimple via son ID en base.</li>
	 * </ul>
	 * retourne null si pId == null.<br/>
	 * retourne null si pId n'existe pas en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base de l'Objet métier.<br/>
	 * 
	 * @return : IContactSimple : Objet métier existant en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public IContactSimple findById(
			final Long pId) throws AbstractDaoException {
		
		IContactSimple objetTrouve = null;
		
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
				= this.entityManager.find(IContactSimple.class, pId);
			
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
	 * <li>Retourne la liste de tous les objets métier de Type IContactSimple 
	 * présents en base.</li>
	 * </ul>
	 *
	 * @return : List&lt;IContactSimple&gt; : 
	 * liste de tous les objets métier de Type IContactSimple 
	 * présents en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public List<IContactSimple> findAll() throws AbstractDaoException {
		
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
			= "from IContactSimple";
		
		List<IContactSimple> resultat = null;
		
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
	 * IContactSimple pObject) :<br/>
	 * <ul>
	 * <li><b>Modifie</b> un objet métier <b>persistant</b> 
	 * de Type IContactSimple pObject.</li>
	 * <li>Retourne l'objet métier de Type IContactSimple 
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
	 * @param pObject : IContactSimple.<br/>
	 * 
	 * @return : IContactSimple : objet métier de Type IContactSimple
	 * modifié en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final IContactSimple update(
			final IContactSimple pObject) throws AbstractDaoException {
		
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

		IContactSimple persistentObject = null;
		
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
						, "Méthode update(IContactSimple Object)", e);
						
		}
				
		/* retourne l'Objet persistant modifié. */
		return persistentObject;
		
	} // Fin de update(...)._______________________________________________

		
	
	/* DELETE *************/
	
	
	/**
	 * method delete(
	 * IContactSimple pObject) :<br/>
	 * <ul>
	 * <li>Détruit un Objet métier de Type IContactSimple pObject
	 * existant en base.</li>
	 * <li>Vérifie que pObject est déjà persistant en base.</li>
	 * <li>Retourne un boolean (true si OK) précisant 
	 * si l'opération de destruction a eu lieu.</li>
	 * </ul>
	 * retourne false si pObject == null.<br/>
	 * retourne false si l'objet n'existait pas en base.<br/>
	 * <br/>
	 *
	 * @param pObject : IContactSimple.<br/>
	 * 
	 * @return : boolean : true si l'objet métier de Type IContactSimple
	 * a été détruit en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final boolean delete(
			final IContactSimple pObject) throws AbstractDaoException {
		
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
		final IContactSimple persistanceInstance = this.retrieve(pObject);
		
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
						, "Méthode delete(IContactSimple pObject)", e);
									
		}
				
		return resultat;
										
	} // Fin de delete(...)._______________________________________________


	
	/**
	 * method deleteById(
	 * Long pId) :<br/>
	 * <ul>
	 * <li>Détruit un Objet métier de Type IContactSimple 
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

		IContactSimple objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where contactSimple.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (IContactSimple) requete.getSingleResult();
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
	 * <li>Détruit un Objet métier de Type IContactSimple
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
		
		IContactSimple objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where contactSimple.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (IContactSimple) requete.getSingleResult();
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
	 * d'Objets métier de Type IContactSimple.</li>
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
			= "delete from IContactSimple";
		
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
	 * d'Objets métier de Type IContactSimple.</li>
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
			= "delete from IContactSimple";
		
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
	 * Iterable&lt;IContactSimple&gt; pObjects) :<br/>
	 * <ul>
	 * <li>Détruit en base tous les objets métier de IContactSimple
	 * contenus dans la collection itérable pObjects.</li>
	 * </ul>
	 * ne fait rien si pObjects == null.<br/>
	 * ne plante pas si un des objets de la collection 
	 * n'existe pas en base.<br/>
	 * <br/>
	 *
	 * @param pObjects : Iterable&lt;IContactSimple&gt; : 
	 * collection itérable d'objets de type IContactSimple.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final void delete(
			final Iterable<IContactSimple> pObjects) 
						throws AbstractDaoException {
		
		/* ne fait rien si pObjects == null. */
		if (pObjects == null) {
			return;
		}
		
		final Iterator<IContactSimple> itePersistants = pObjects.iterator();
		final List<IContactSimple> listePersistants 
			= new ArrayList<IContactSimple>();
		
		/* Récupération préalable des objets persistans en base. */
		while (itePersistants.hasNext()) {
			final IContactSimple objet = itePersistants.next();
			final IContactSimple objetPersistant = this.retrieve(objet);
			
			if (objetPersistant != null) {
				listePersistants.add(objetPersistant);
			}
		}
		
		
		/* Itération uniquement sur la liste des Objets persistants. */
		final Iterator<IContactSimple> ite = listePersistants.iterator();
		
		try {
			
			while (ite.hasNext()) {
				
				final IContactSimple objectPersistant = ite.next();
				
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
	 * IContactSimple pObject) :<br/>
	 * <ul>
	 * <li>Retourne un boolean permettant de déterminer si l'Objet métier 
	 * de Type IContactSimple pObject est persisté en base.</li>
	 * <li>Retourne true si l'Objet métier a été trouvé en base.</li>
	 * </ul>
	 * retourne false si l'objet n'existe pas en base.<br/>
	 * <br/>
	 *
	 * @param pObject : IContactSimple.<br/>
	 * 
	 * @return boolean : true si l'objet métier existe en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	public boolean exists(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		boolean resultat = false;		
		IContactSimple objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where contactSimple.prenom = :pPrenom "
				+ "and contactSimple.nom = :pNom "
				+ "and contactSimple.dateNaissance = :pDateNaissance";
		
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
			= (IContactSimple) requete.getSingleResult();
			
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
						, "Méthode exists(IContactSimple pObject)", e);
		}
				
		return resultat;
		
	} // Fin de exists(...)._______________________________________________
	
	

	/**
	 * method exists(
	 * Long pId) :<br/>
	 * <ul>
	 * <li>Retourne un boolean permettant de déterminer si un Objet métier 
	 * de Type IContactSimple avec ID == pId  est persisté en base.</li>
	 * <li>Retourne true si l'Objet métier a été trouvé en base.</li>
	 * </ul>
	 * retourne false si l'objet n'existe pas en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long .<br/>
	 * 
	 * @return boolean : true si l'objet métier de Type IContactSimple 
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
	 * de type IContactSimple présents en base.</li>
	 * </ul>
	 *
	 * @return : Long : 
	 * le nombre d'Objets metier de type IContactSimple 
	 * présents en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public final Long count() throws AbstractDaoException {
		
		/* Récupère la liste d'Objets métier de Type paramétré T. */
		final List<IContactSimple> listObjects = this.findAll();
		
		if (listObjects != null) {
			
			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}
		
		return 0L;
		
	} // Fin de count().___________________________________________________
	
	
	
	/**
	 * method afficherListe(
	 * List&lt;IContactSimple&gt; pListe) :<br/>
	 * Retourne une String pour l'affichage à la console 
	 * d'une liste d'Objets métier de type IContactSimple.<br/>
	 * <br/>
	 * retourne null si pListe == null.<br/>
	 * <br/>
	 *
	 * @param pListe : List&lt;IContactSimple&gt;.<br/>
	 * 
	 * @return : String : String pour affichage à la console.<br/>
	 */
	public final String afficherListe(
			final List<IContactSimple> pListe) {
		
		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final IContactSimple objet : pListe) {
			stb.append(objet.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
				
		return stb.toString();			

	} // Fin de afficherListe(...).________________________________________
	

	
} // FIN DE LA CLASSE ContactSimpleDaoJPA.----------------------------------------
