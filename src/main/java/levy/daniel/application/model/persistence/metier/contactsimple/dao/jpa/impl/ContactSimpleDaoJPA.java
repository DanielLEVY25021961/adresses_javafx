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
import levy.daniel.application.model.persistence.metier.contactsimple.ContactSimpleConvertisseurMetierEntity;
import levy.daniel.application.model.persistence.metier.contactsimple.IContactSimpleDAO;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jpa.ContactSimpleEntityJPA;


/**
 * CLASSE <b>ContactSimpleDaoJPA</b> :<br/>
 * DAO (Data Access Object) JPA (sans SPRING) <i>CONCRET</i> 
 * pour les ContactSimple.<br/>
 * 
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * 
 * <p>
 * <b>{@link IContactSimple}</b> modélise un <i>concept</i> de <b>Contact</b> 
 * (Personne avec des coordonnées) avec un nom, un prénom et des coordonnées
 * <i>simples</i>.<br/>
 * Un ContactSimple ne possède qu'une seule adresse, 
 * un seul numéro de téléphone, et un seul mail.
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * DAO</span>
 * </p>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>{@link IContactSimple}</b>.</li>
 * <li>
 * Implémente l'interface <b>IContactSimpleDAO</b>.
 * </li>
 * <li>
 * DAO pour serializer des ENTITIES JPA {@link ContactSimpleEntityJPA} 
 * lors de l'utilisation de Java Persistence API (JPA)
 * pour la persistence dans un contexte <i>SANS</i> SPRING.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES DAO</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../../../../javadoc/images/implementation_ContactSimple_DAO_JPA.png" 
 * alt="implémentation des DAOs ContactSimple JPA" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">UTILISATION DES DAO</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/utilisation_ContactSimple_DAO_JPA.png" 
 * alt="utilisation des DAOs ContactSimple JPA" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <br/>
 * 
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
public class ContactSimpleDaoJPA implements IContactSimpleDAO {

	// ************************ATTRIBUTS************************************/

	/**
	 * "Classe ContactSimpleDaoJPA".<br/>
	 */
	public static final String CLASSE_CONTACTSIMPLE_DAO_JPA 
		= "Classe ContactSimpleDaoJPA";
	
	/**
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE 
		= " - ";
	
	/**
	 * saut de ligne de la plateforme.<br/>
	 */
	public static final String SAUT_LIGNE_PLATEFORME 
		= System.getProperty("line.separator");
	
	/**
	 * "this.entityManager est NULL dans ContactSimpleDaoJPA".<br/>
	 */
	public static final String MESSAGE_ENTITYMANAGER_NULL 
		= "this.entityManager est NULL dans ContactSimpleDaoJPA";
	

	/**
	 * "select contactSimple from 
	 * ContactSimpleEntityJPA as contactSimple ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select contactSimple from "
				+ "ContactSimpleEntityJPA as contactSimple ";
	
	/**
	 * EntityManagerFactory JPA.<br/>
	 */
	private transient EntityManagerFactory entityManagerFactory;
	
	/**
	 * EntityManager JPA.<br/>
	 */
	private transient EntityManager entityManager;
	
	/**
	 * Gestionnaire pour les Exceptions de DAO.<br/>
	 */
	private final transient GestionnaireDaoException gestionnaireException 
		= new GestionnaireDaoException();

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleDaoJPA.class);

	
	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ContactSimpleDaoJPA() {
		
		super();
		
		this.instancierContextJPA();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
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
	 * @throws AbstractDaoException 
	 */
	private void instancierEntityManager() throws AbstractDaoException {
		this.entityManager = JPAUtils.fournirEntityManager();
	} // Fin de instancierEntityManager()._________________________________
	
	
	
	/**
	 * <b>Crée un OBJET METIER à partir d'une EntityJPA</b>.<br/>
	 * <br/>
	 * - retourne null si pEntityJPA == null.<br/>
	 * <br/>
	 *
	 * @param pEntityJPA : ContactSimpleEntityJPA.<br/>
	 * 
	 * @return : IContactSimple.<br/>
	 */
	private IContactSimple creerContactSimple(
			final ContactSimpleEntityJPA pEntityJPA) {
		
		/* retourne null si pEntityJPA == null. */
		if (pEntityJPA == null) {
			return null;
		}
		
		final IContactSimple contactSimple 
			= new ContactSimple(pEntityJPA.getId()
					, pEntityJPA.getPrenom()
					, pEntityJPA.getNom()
					, pEntityJPA.getRue()
					, pEntityJPA.getRue2()
					, pEntityJPA.getCodePostal()
					, pEntityJPA.getVille()
					, pEntityJPA.getPays()
					, pEntityJPA.getTelephone()
					, pEntityJPA.getMail()
					, pEntityJPA.getDateNaissance());
		
		return contactSimple;
		
	} // Fin de creerContactSimple(...).________________________________________
	
	
	
	/**
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
		
		for (final IContactSimple objet : pList) {
			
			if (objet != null) {
				
				final ContactSimpleEntityJPA entity 
					= ContactSimpleConvertisseurMetierEntity
						.convertirObjetMetierEnEntityJPA(objet);
				
				resultat.add(entity);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________
	

		
	/**
	 * convertit une Liste de ContactSimpleEntityJPA (Entities JPA) 
	 * en liste de ContactSimple (MODEL).<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
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
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple create(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}
		
		/* retourne null si les attributs obligatoires 
		 * de pObject ne sont pas remplis.*/
		if (pObject.getPrenom() == null 
				|| pObject.getNom() == null 
					|| pObject.getDateNaissance() == null) {
			return null;
		}
		
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
				LOG.fatal("create(Object) - Transaction null");
			}
			return null;
		}
		
		
		/* conversion de l'OBJET METIER en ENTITY. */
		final ContactSimpleEntityJPA entity = 
				ContactSimpleConvertisseurMetierEntity
					.convertirObjetMetierEnEntityJPA(pObject);
		
		IContactSimple persistentObject = null;
		
		
		try {
			
			/* TRANSACTIONNEL. ****/	
			transaction.begin();
			
			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);
			
			/* conversion de l'ENTITY en OBJET METIER. */
			persistentObject 
				= ContactSimpleConvertisseurMetierEntity
				.convertirEntityJPAEnObjetMetier(entity);
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();
												
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			transaction.rollback();
									
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
							, "méthode create(object)", e);
						
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
	 * {@inheritDoc}
	 */
	@Override
	public void persist(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* ne fait rien si pObject == null. */
		if (pObject == null) {
			return;
		}
		
		/* ne fait rien si pObject est un doublon. */
		if (this.exists(pObject)) {
			return;
		}
		
		if (this.existsId(pObject.getId())) {
			return;
		}
		
		/* ne fait rien si les attributs obligatoires 
		 * de pObject ne sont pas remplis.*/
		if (pObject.getPrenom() == null 
				|| pObject.getNom() == null 
					|| pObject.getDateNaissance() == null) {
			return;
		}

		
		/* TRANSACTIONNEL. ****/
		/* instancie un EntityManager. */
		this.instancierEntityManager();
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}
		
		
		/* TRANSACTIONNEL. ****/
		EntityTransaction transaction = null;
		
		if (this.entityManager != null) {
			transaction = this.entityManager.getTransaction();
		}
		
		if (transaction == null) {
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal("Persist - Transaction null");
			}
			return;
		}
		
		/* conversion de l'OBJET METIER en ENTITY. */
		final ContactSimpleEntityJPA entity = 
				ContactSimpleConvertisseurMetierEntity
					.convertirObjetMetierEnEntityJPA(pObject);
		
		try {
			
			/* TRANSACTIONNEL. ****/	
			transaction.begin();
			
			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();
												
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			transaction.rollback();
					
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
							, "méthode persist(object)", e);
						
		}
		finally {
			
			/* TRANSACTIONNEL. *****/
			/* détruit l'entityManager. */
			if (this.entityManager != null) {
				this.entityManager.close();
				
			}
		}
		
	} // Fin de persist(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}
		
		/* retourne null si les attributs obligatoires 
		 * de pObject ne sont pas remplis.*/
		if (pObject.getPrenom() == null 
				|| pObject.getNom() == null 
					|| pObject.getDateNaissance() == null) {
			return null;
		}
		
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
				LOG.fatal("CreateReturnId - Transaction null");
			}
			return null;
		}
		
		
		/* conversion de l'OBJET METIER en ENTITY. */
		final ContactSimpleEntityJPA entity = 
				ContactSimpleConvertisseurMetierEntity
					.convertirObjetMetierEnEntityJPA(pObject);
		
		IContactSimple persistentObject = null;
		
		
		try {
			
			/* TRANSACTIONNEL. ****/	
			transaction.begin();
			
			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);
			
			/* conversion de l'ENTITY en OBJET METIER. */
			persistentObject 
				= ContactSimpleConvertisseurMetierEntity
				.convertirEntityJPAEnObjetMetier(entity);
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();
												
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/			
			transaction.rollback();			
									
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
							, "méthode createReturnId(object)", e);
						
		}
		finally {
			
			/* TRANSACTIONNEL. *****/
			/* détruit l'entityManager. */
			if (this.entityManager != null) {
				this.entityManager.close();
				
			}
		}
		
		/* retourne l'ID de l'Objet persistant. */
		if (persistentObject != null) {
			return persistentObject.getId();
		}
		
		return null;		

	} // Fin de createReturnId(...)._______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IContactSimple> saveIterable(
			final Iterable<IContactSimple> pList) 
									throws AbstractDaoException {

		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}

		
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
		
		
		/* conversion de le liste de MODEL en liste d'ENTITIES. */
		final List<ContactSimpleEntityJPA> listeEntities 
			= ContactSimpleConvertisseurMetierEntity
				.convertirListModelEnEntitiesJPA(pList);
		
		final List<IContactSimple> resultat 
			= new ArrayList<IContactSimple>();

		final Iterator<ContactSimpleEntityJPA> iteS 
			= listeEntities.iterator();

		try {

			while (iteS.hasNext()) {

				final ContactSimpleEntityJPA entity = iteS.next();
				
				/* Passe les doublons existants en base. */
				if (!this.exists(entity)) {
					
					/* passe un null dans le lot. */
					if (entity != null) {
						
						/* passe si les attributs obligatoires 
						 * de l'objet ne sont pas remplis.*/
						if (entity.getPrenom() != null 
								&& entity.getNom() != null 
									&& entity.getDateNaissance() != null) {
							
							IContactSimple objetPersistant = null;
						
							try {
																
								if (this.entityManager != null) {
									transaction = this.entityManager.getTransaction();
								}
								
								if (transaction == null) {
									/* LOG. */
									if (LOG.isFatalEnabled()) {
										LOG.fatal("saveIterable(Iterable) - Transaction null" 
												+ "pour l'objet : " 
													+ entity.toString());
									}
									return null;
								}

								
								/* TRANSACTIONNEL. ****/	
								transaction.begin();
								
								/* PERSISTE en base. */
								this.entityManager.persist(entity);
								
								/* TRANSACTIONNEL. *****/
								transaction.commit();
								
								/* conversion de l'ENTITY en OBJET METIER. */
								objetPersistant 
									= ContactSimpleConvertisseurMetierEntity
									.convertirEntityJPAEnObjetMetier(entity);
															
							} catch (Exception e) {
								
								/* TRANSACTIONNEL. *****/
								if (transaction != null) {
									transaction.rollback();
								}
								
								
								/* LOG. */
								if (LOG.isFatalEnabled()) {
									LOG.fatal(e.getMessage(), e);
								}
								
								/* Gestion de la DAO Exception. */
								this.gestionnaireException
									.gererException(
											CLASSE_CONTACTSIMPLE_DAO_JPA
												, "Méthode saveIterable(lot)", e);
							}
													
							/* ne sauvegarde pas un doublon 
							 * présent dans le lot. */
							if (objetPersistant != null) {
								
								/* Ajoute à l'iterable resultat. */
								resultat.add(objetPersistant);	
								
							}						

						} // Entity avec attributs obligatoires remplis.
						
					} // Entity non null._____________
					
				} // Entity persistante._________________
				
			} // Next._____________________________________

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
							, "Méthode saveIterable(lot)", e);

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

	} // Fin de saveIterable(...)._________________________________________
	
	

	/* READ *************/



	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple retrieve(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
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

		IContactSimple objetResultat = null;		
		ContactSimpleEntityJPA entity = null;
		
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
			entity 
				= (ContactSimpleEntityJPA) requete.getSingleResult();
			
			/* conversion de l'ENTITY en OBJET METIER. */
			objetResultat 
				= ContactSimpleConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne null si l'Objet métier n'existe pas 
			 * dans le stockage. */
			return null;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode retrieve(objet)", e);
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
		/* retourne l'objet metier trouvé. */
		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple findById(
			final Long pId) throws AbstractDaoException {
		
		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}

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

		IContactSimple objetTrouve = null;
		ContactSimpleEntityJPA entity = null;

		try {
			
			/* ************************* */
			/* récupération de l'ENTITY. */
			entity 
				= this.entityManager.find(
						ContactSimpleEntityJPA.class, pId);
			
			/* conversion de l'ENTITY en OBJET METIER. */
			objetTrouve 
				= ContactSimpleConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);
			
		}
		catch (Exception e) {
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode findById(ID)", e);
			
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
		/* retourne l'objet metier trouvé. */
		return objetTrouve;
				
	} // Fin de findById(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long retrieveId(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
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
		
		IContactSimple objetResultat = null;		
		ContactSimpleEntityJPA entity = null;
		
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
			entity 
				= (ContactSimpleEntityJPA) requete.getSingleResult();
			
			/* conversion de l'ENTITY en OBJET METIER. */
			objetResultat 
				= ContactSimpleConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne null si l'Objet métier n'existe pas 
			 * dans le stockage. */
			return null;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode retrieveId(objet)", e);
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
		/* retourne l'ID de l'objet metier trouvé. */
		if (objetResultat != null) {
			return objetResultat.getId();
		}
		
		return null;
		
	} // Fin de retrieveId(...).___________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IContactSimple> findAll() throws AbstractDaoException {

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
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from ContactSimpleEntityJPA";
		
		List<ContactSimpleEntityJPA> resultatEntity = null;
		
		List<IContactSimple> resultat = null;
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* Exécute la javax.persistence.Query. */
			resultatEntity = query.getResultList();
			
			/* convertit la liste d'Entities en OBJETS METIER. */
			resultat = ContactSimpleConvertisseurMetierEntity
						.convertirListEntitiesJPAEnModel(
								resultatEntity);

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode findAll()", e);
			
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAll()._________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IContactSimple> findAllMax(
			final int pStartPosition, final int pMaxResult) 
										throws AbstractDaoException {

		/* retourne null si pId est en dehors des index de stockage. */
		if (pStartPosition > this.count() - 1) {
			return null;
		}
		
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
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from ContactSimpleEntityJPA";
		
		List<ContactSimpleEntityJPA> resultatEntity = null;
		
		List<IContactSimple> resultat = null;
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString)
					.setFirstResult(pStartPosition)
						.setMaxResults(pMaxResult);
			
			/* Exécute la javax.persistence.Query. */
			resultatEntity = query.getResultList();
						
			/* convertit la liste d'Entities en OBJETS METIER. */
			resultat 
			= ContactSimpleConvertisseurMetierEntity
				.convertirListEntitiesJPAEnModel(resultatEntity);

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode findAllMax(int pStartPosition"
								+ ", int pMaxResult)", e);
			
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAllMax(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IContactSimple> findAllIterable(
			final Iterable<Long> pIds) throws AbstractDaoException {
		
		/* retourne null si pIds == null. */
		if (pIds == null) {
			return null;
		}

		final List<IContactSimple> resultat 
			= new ArrayList<IContactSimple>();

		for (final Long id : pIds) {
			
			final IContactSimple objet = this.findById(id);
			
			if (objet != null) {
				resultat.add(objet);
			}
		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAllIterable(...).______________________________________



	/* UPDATE *************/

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple update(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* retourne pObject si l'objet n'est pas 
		 * déjà persistant en base. */
		if (!this.existsId(pObject.getId())) {
			return pObject;
		}
		
		/* retourne null si pObject créerait un doublon. */
		if (this.exists(pObject)) {
			return null;
		}
		
		/* retourne null si les attributs obligatoires 
		 * de pObject ne sont pas remplis.*/
		if (pObject.getPrenom() == null 
				|| pObject.getNom() == null 
					|| pObject.getDateNaissance() == null) {
			return null;
		}

		
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
				LOG.fatal("update(Object) - Transaction null");
			}
			return null;
		}

		
		/* conversion de l'OBJET METIER en ENTITY. */
		final ContactSimpleEntityJPA entity = 
				ContactSimpleConvertisseurMetierEntity
					.convertirObjetMetierEnEntityJPA(pObject);

		IContactSimple persistentObject = null;
		
		try {
			
			/* TRANSACTIONNEL. ****/	
			transaction.begin();

			/* MODIFIE en base. */
			this.entityManager.merge(entity);
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();

			/* conversion de l'ENTITY en OBJET METIER. */
			persistentObject 
				= ContactSimpleConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);
			
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			transaction.rollback();
		
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode update(objet)", e);
						
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
				
		/* retourne l'Objet persistant modifié. */
		return persistentObject;
		
	} // Fin de update(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple updateById(
			final Long pId
				, final IContactSimple pObjectModifie) 
										throws AbstractDaoException {
		
		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}

		/* retourne null si pId est hors indexes. */
		if (this.findById(pId) == null) {
			return null;
		}
		
		/* retourne null si pObjectModifie == null. */
		if (pObjectModifie == null) {
			return null;
		}
		
		/* retourne null si l'objet modifie pObjectModifie 
		 * créerait un doublon dans le stockage. */
		if (this.exists(pObjectModifie)) {
			return null;
		}
		
		/* retourne null si les attributs obligatoires 
		 * de pObject ne sont pas remplis.*/
		if (pObjectModifie.getPrenom() == null 
				|| pObjectModifie.getNom() == null 
					|| pObjectModifie.getDateNaissance() == null) {
			return null;
		}
		
		/* récupère l'objet à modifier par sons index. */
		final IContactSimple objetAModifier = this.findById(pId);
		
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
				LOG.fatal("updateById(Id, Object) - Transaction null");
			}
			return null;
		}


		IContactSimple persistentObject = null;
		
		try {
			
			/* TRANSACTIONNEL. ****/	
			transaction.begin();
						
			/* applique les modifications. */
			objetAModifier.setPrenom(pObjectModifie.getPrenom());
			objetAModifier.setNom(pObjectModifie.getNom());
			objetAModifier.setRue(pObjectModifie.getRue());
			objetAModifier.setRue2(pObjectModifie.getRue2());
			objetAModifier.setCodePostal(pObjectModifie.getCodePostal());
			objetAModifier.setVille(pObjectModifie.getVille());
			objetAModifier.setPays(pObjectModifie.getPays());
			objetAModifier.setTelephone(pObjectModifie.getTelephone());
			objetAModifier.setMail(pObjectModifie.getMail());
			objetAModifier.setDateNaissance(pObjectModifie.getDateNaissance());
			
			/* conversion de l'OBJET METIER en ENTITY. */
			final ContactSimpleEntityJPA entity = 
					ContactSimpleConvertisseurMetierEntity
						.convertirObjetMetierEnEntityJPA(objetAModifier);

			/* MODIFIE en base. */
			this.entityManager.merge(entity);
			
			/* applique les modifications dans le stockage (si nécessaire). */
			this.entityManager.flush();
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();
			
			/* conversion de l'ENTITY en OBJET METIER. */
			persistentObject 
				= ContactSimpleConvertisseurMetierEntity
					.convertirEntityJPAEnObjetMetier(entity);
			
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			transaction.rollback();
		
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
						, "méthode updateById(Id, Object)", e);
						
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
				
		/* retourne l'Objet persistant modifié. */
		return persistentObject;
		
	} // Fin de updateById(...).___________________________________________



	/* DELETE *************/



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}
		
		/* récupère l'instance persistante. */
		final IContactSimple persistanceInstance 
			= this.retrieve(pObject);
		
		/* retourne false si pObject n'est pas persisté. */
		if (persistanceInstance == null) {
			return false;
		}
				
		/* TRANSACTIONNEL. ****/
		/* instancie un EntityManager. */
		this.instancierEntityManager();
				
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}
				
		/* TRANSACTIONNEL. ****/
		EntityTransaction transaction = null;
				
		if (this.entityManager != null) {
			transaction = this.entityManager.getTransaction();
		}
		
		if (transaction == null) {
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal("delete(Object) - Transaction null");
			}
			return false;
		}

		boolean resultat = false;
			
		try {
															
			/* TRANSACTIONNEL. ****/	
			transaction.begin();

			/* récupération de l'ENTITY a détruire. */
			final ContactSimpleEntityJPA entity 
				= this.entityManager.find(
						ContactSimpleEntityJPA.class
							, persistanceInstance.getId());
						
			/* ************ */
			/* DESTRUCTION. */
			this.entityManager.remove(entity);
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();
			
			resultat = true;
							
		} catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			transaction.rollback();
					
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode delete(objet)", e);
									
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
		/* retourne le boolean resultat. */
		return resultat;
										
	} // Fin de delete(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(
			final Long pId) throws AbstractDaoException {
		
		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}
		
		/* ne fait rien si pId est hors indexes. */
		if (this.findById(pId) == null) {
			return;
		}
		
		/* TRANSACTIONNEL. ****/
		/* instancie un EntityManager. */
		this.instancierEntityManager();
				
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}
				
		/* TRANSACTIONNEL. ****/
		EntityTransaction transaction = null;
				
		if (this.entityManager != null) {
			transaction = this.entityManager.getTransaction();
		}
		
		if (transaction == null) {
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal("deleteById(ID) - Transaction null");
			}
			return;
		}
		
		try {
		
			/* TRANSACTIONNEL. ****/	
			transaction.begin();

			/* récupération de l'ENTITY a détruire. */
			final ContactSimpleEntityJPA entity 
				= this.entityManager.find(
						ContactSimpleEntityJPA.class
							, pId);
						
			/* ************ */
			/* DESTRUCTION. */
			this.entityManager.remove(entity);
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();

		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			transaction.rollback();
		
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode deleteById(ID)", e);
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
	} // Fin de deleteById(...).___________________________________________

	
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws AbstractDaoException {
		
		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}
		
		/* retourne false si pId est hors indexes. */
		if (this.findById(pId) == null) {
			return false;
		}
		
		/* TRANSACTIONNEL. ****/
		/* instancie un EntityManager. */
		this.instancierEntityManager();
				
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}
				
		/* TRANSACTIONNEL. ****/
		EntityTransaction transaction = null;
				
		if (this.entityManager != null) {
			transaction = this.entityManager.getTransaction();
		}
		
		if (transaction == null) {
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal("deleteByIdBoolean(ID) - Transaction null");
			}
			return false;
		}

		
		try {
						
			/* TRANSACTIONNEL. ****/	
			transaction.begin();

			/* récupération de l'ENTITY a détruire. */
			final ContactSimpleEntityJPA entity 
				= this.entityManager.find(
						ContactSimpleEntityJPA.class
							, pId);
			
			/* ************ */
			/* DESTRUCTION. */
			this.entityManager.remove(entity);
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();
			
			return true;
				
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			transaction.rollback();
		
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode deleteByIdBoolean(ID)", e);
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
		return false;
		
	} // Fin de deleteByIdBoolean(...).____________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() throws AbstractDaoException {

		/* TRANSACTIONNEL. ****/
		/* instancie un EntityManager. */
		this.instancierEntityManager();

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		/* TRANSACTIONNEL. ****/
		EntityTransaction transaction = null;
		
		if (this.entityManager != null) {
			transaction = this.entityManager.getTransaction();
		}
		
		if (transaction == null) {
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal("deleteAll() - Transaction null");
			}
			return;
		}
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from ContactSimpleEntityJPA";

		try {
			
			/* TRANSACTIONNEL. ****/	
			transaction.begin();

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();
			
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			transaction.rollback();
		
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode deleteAll()", e);
			
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
	} // Fin de deleteAll()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBoolean() throws AbstractDaoException {

		/* TRANSACTIONNEL. ****/
		/* instancie un EntityManager. */
		this.instancierEntityManager();

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}

		/* TRANSACTIONNEL. ****/
		EntityTransaction transaction = null;
		
		if (this.entityManager != null) {
			transaction = this.entityManager.getTransaction();
		}
		
		if (transaction == null) {
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal("deleteAllBoolean() - Transaction null");
			}
			return false;
		}
		
		boolean resultat = false;
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from ContactSimpleEntityJPA";
		
		try {
			
			/* TRANSACTIONNEL. ****/	
			transaction.begin();
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();
			
			/* TRANSACTIONNEL. *****/
			transaction.commit();
			
			resultat = true;
			
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			transaction.rollback();
					
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode deleteAllBoolean()", e);
			
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
		/* retourne le boolean resultat. */
		return resultat;
		
	} // Fin de deleteAllBoolean().________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteIterable(
			final Iterable<IContactSimple> pList) 
						throws AbstractDaoException {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}

		/* TRANSACTIONNEL. ****/
		/* instancie un EntityManager. */
		this.instancierEntityManager();

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		/* TRANSACTIONNEL. ****/
		EntityTransaction transaction = null;
		
		final Iterator<IContactSimple> ite = pList.iterator();
		
		try {
			
			while (ite.hasNext()) {
				
				final IContactSimple objet = ite.next();
				final IContactSimple objetPersistant = this.retrieve(objet);
				
				if (objetPersistant == null) {
					continue;
				}
				
				/* TRANSACTIONNEL. ****/
				if (this.entityManager != null) {
					transaction = this.entityManager.getTransaction();
				}
				
				if (transaction == null) {
					/* LOG. */
					if (LOG.isFatalEnabled()) {
						LOG.fatal("deleteIterable(Iterable) - Transaction null" 
								+ " pour l'objet persistant : " 
								+ objetPersistant.toString());
					}
					return;
				}

				transaction.begin();
				
				/* récupération de l'ENTITY a détruire. */
				final ContactSimpleEntityJPA entity 
					= this.entityManager.find(
							ContactSimpleEntityJPA.class
								, objetPersistant.getId());
				
				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);
				
				/* TRANSACTIONNEL. *****/
				transaction.commit();
				
			}
			
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			if (transaction != null) {
				transaction.rollback();
			}
					
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_CONTACTSIMPLE_DAO_JPA
					, "Méthode deleteIterable(Iterable)", e);
			
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
				
	} // Fin de deleteIterable(...)._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteIterableBoolean(
			final Iterable<IContactSimple> pList) 
						throws AbstractDaoException {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}

		/* TRANSACTIONNEL. ****/
		/* instancie un EntityManager. */
		this.instancierEntityManager();

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}

		/* TRANSACTIONNEL. ****/
		EntityTransaction transaction = null;
		
		boolean resultat = false;
		
		final Iterator<IContactSimple> ite = pList.iterator();
		
		try {
			
			while (ite.hasNext()) {
				
				final IContactSimple objet = ite.next();
				final IContactSimple objetPersistant = this.retrieve(objet);
				
				if (objetPersistant == null) {
					continue;
				}
				
				/* TRANSACTIONNEL. ****/
				if (this.entityManager != null) {
					transaction = this.entityManager.getTransaction();
				}
				
				if (transaction == null) {
					/* LOG. */
					if (LOG.isFatalEnabled()) {
						LOG.fatal("deleteIterableBoolean(Iterable) - Transaction null" 
								+ " pour l'objet persistant : " 
								+ objetPersistant.toString());
					}
					return false;
				}

				transaction.begin();
				
				/* récupération de l'ENTITY a détruire. */
				final ContactSimpleEntityJPA entity 
					= this.entityManager.find(
							ContactSimpleEntityJPA.class
								, objetPersistant.getId());
				
				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);
				
				/* TRANSACTIONNEL. *****/
				transaction.commit();
				
			}
			
			resultat = true;
			
		}
		catch (Exception e) {
			
			/* TRANSACTIONNEL. *****/
			if (transaction != null) {
				transaction.rollback();
			}
					
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_CONTACTSIMPLE_DAO_JPA
					, "Méthode deleteIterableBoolean(Iterable)", e);
			
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
		/* retourne le boolean resultat. */
		return resultat;
				
	} // Fin de deleteIterableBoolean(...).________________________________



	/* TOOLS *************/



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}
		
		/* instancie un EntityManager. */
		this.instancierEntityManager();

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
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
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_CONTACTSIMPLE_DAO_JPA
						, "Méthode exists(objet)", e);
		}
//		finally {
//			
//			/* TRANSACTIONNEL. *****/
//			/* détruit l'entityManager. */
//			if (this.entityManager != null) {
//				this.entityManager.close();
//				
//			}
//		}
		
		/* retourne le boolean resultat. */
		return resultat;
		
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsId(
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
		
	} // Fin de existsId(...)._____________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() throws AbstractDaoException {
		
		/* Récupère la liste d'Objets métier de Type paramétré T. */
		final List<IContactSimple> listObjects = this.findAll();
		
		if (listObjects != null) {
			
			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}
		
		return null;
		
	} // Fin de count().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireStockageDansConsole() 
					throws AbstractDaoException {
		
		final List<IContactSimple> stockageList = this.findAll();
		
		/* ne fait rien si this.findAll() retourne null. */
		if (stockageList == null) {
			return;
		}
		
		System.out.println(this.afficherListeObjetsMetier(stockageList));
		
	} // Fin de ecrireStockageDansConsole()._______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListeObjetsMetier(
				final List<IContactSimple> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final IContactSimple contactSimple : pList) {
			
			stb.append(contactSimple.toString());
			stb.append(SAUT_LIGNE_PLATEFORME);
			
		}
		
		return stb.toString();
		
	} // Fin de afficherListeObjetsMetier(...).____________________________

	
		
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
	public String afficherListe(
			final List<IContactSimple> pListe) {
		
		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final IContactSimple objet : pListe) {
			stb.append(objet.toString());
			stb.append(SAUT_LIGNE_PLATEFORME);
		}
				
		return stb.toString();			

	} // Fin de afficherListe(...).________________________________________


	
} // FIN DE LA CLASSE ContactSimpleDaoJPA.-----------------------------------
