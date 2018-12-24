package levy.daniel.application.model.persistence.metier.contactsimple.dao.jpaspring.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.persistence.daoexceptions.GestionnaireDaoException;
import levy.daniel.application.model.persistence.metier.contactsimple.IContactSimpleDAO;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jpa.ContactSimpleEntityJPA;





/**
 * CLASSE CONCRETE <b>DAO</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <p>
 * <b>ContactSimple</b> modélise un un <i>concept</i> 
 * de <b>ContactSimple</b> avec ********
 * <b>*****</b>  qui identifie <i>une ou plusieurs</i> <b>****</b>.<br/>
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * DAO</span>
 * </p>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>ContactSimple</b>.</li>
 * <li>
 * Implémente l'interface <b>IContactSimpleDAO</b>.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES DAO</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../../../../javadoc/images/implementation_ContactSimple_DAO_JpaSpring.png" 
 * alt="implémentation des DAOs ContactSimple JPA SPRING" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">UTILISATION DES DAO</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/utilisation_ContactSimple_DAO_JpaSpring.png" 
 * alt="utilisation des DAOs DAO JPA SPRING" border="1" align="center" />
 * </li>
 * </ul>
 * 
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
 * @since 11 nov. 2018
 *
 */
@Repository("ContactSimpleDAOJPASpring")
public class ContactSimpleDAOJPASpring implements IContactSimpleDAO {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * "Classe ContactSimpleDAOJPASpring".<br/>
	 */
	public static final String CLASSE_PERSONNEDAO_JPA_SPRING 
		= "Classe ContactSimpleDAOJPASpring";

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';

	/**
	 * SELECT_OBJET : String :<br/>
	 * "select contactSimple from 
	 * ContactSimpleEntityJPA as contactSimple ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select contactSimple from "
				+ "ContactSimpleEntityJPA as contactSimple ";
	
	/**
	 * JPA EntityManager <b>injecté par SPRING</b>.<br/>
	 */
	@PersistenceContext
	private transient EntityManager entityManager;
	
	/**
	 * gestionnaireException : GestionnaireDaoException :<br/>
	 * Gestionnaire pour les Exceptions de DAO.<br/>
	 */
	private final transient GestionnaireDaoException gestionnaireException 
		= new GestionnaireDaoException();
	
	/**
	 * "this.entityManager est NULL dans le présent DAO".<br/>
	 */
	public static final String MESSAGE_ENTITYMANAGER_NULL 
	= "this.entityManager est NULL dans le présent DAO";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ContactSimpleDAOJPASpring.class);

	
	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ContactSimpleDAOJPASpring() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/* CREATE ************/

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple create(
			final IContactSimple pObject) throws Exception {

		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		IContactSimple persistentObject = null;

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

		try {
			
			/* Obtention d'une Entity JPA à partir de l'objet métier. */
			final ContactSimpleEntityJPA entity 
				= new ContactSimpleEntityJPA(pObject);

			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);

			persistentObject = entity;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
							, "Méthode create(IContactSimple pObject)", e);

		}

		/* retourne l'Objet persistant. */
		return persistentObject;

	} // Fin de create(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void persist(
			final IContactSimple pObject) throws Exception {

		/* ne fait rien si pObject == null. */
		if (pObject == null) {
			return;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		/* ne fait rien si pObject est un doublon. */
		if (this.exists(pObject)) {
			return;
		}


		try {
			
			/* Obtention d'une Entity JPA à partir de l'objet métier. */
			final ContactSimpleEntityJPA entity 
				= new ContactSimpleEntityJPA(pObject);

			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
							, "Méthode persist(IContactSimple Object)", e);

		}

	} // Fin de persist(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final IContactSimple pObject) throws Exception {

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
		}

		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}

		/* ******************************************************* */
		/* Crée l'Objet en base ou jette une Exception. */
		final IContactSimple objectPersistant 
			= this.create(pObject);

		/* retourne null si l'objet pObject n'a pu être créé en base. */
		if (objectPersistant == null) {
			return null;
		}

		/* retourne l'Long de l'objet persistant. */
		return objectPersistant.getId();	

	} // Fin de createReturnId(...)._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IContactSimple> save(
			final Iterable<IContactSimple> pList) 
					throws Exception {
		
		/* retourne null si pList == null. */
		if (pList == null) {
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

		final List<IContactSimple> resultat = new ArrayList<IContactSimple>();

		final Iterator<IContactSimple> iteS = pList.iterator();

		try {

			while (iteS.hasNext()) {

				final IContactSimple objet = iteS.next();

				/* Passe les doublons existants en base. */
				if (!this.exists(objet)) {

					/* passe un null dans le lot. */
					if (objet != null) {

						/* Obtention d'une Entity JPA à partir 
						 * de l'objet métier. */
						final ContactSimpleEntityJPA entity 
							= new ContactSimpleEntityJPA(objet);
						
						IContactSimple objectPersistant = null;

						try {

							/* ***************** */
							/* PERSISTE en base. */
							this.entityManager.persist(entity);

							objectPersistant = objet;

						} catch (Exception e) {

							/* LOG. */
							if (LOG.isFatalEnabled()) {
								LOG.fatal(e.getMessage(), e);
							}

							/* Gestion de la DAO Exception. */
							this.gestionnaireException
								.gererException(
										CLASSE_PERSONNEDAO_JPA_SPRING
											, "Méthode save(Iterable)", e);
						}


						/* ne sauvegarde pas un doublon 
						 * présent dans le lot. */
						if (objectPersistant != null) {

							/* Ajoute à l'iterable resultat. */
							resultat.add(objectPersistant);								
						}						
					}					
				}				
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
						CLASSE_PERSONNEDAO_JPA_SPRING
							, "Méthode save(Iterable)", e);

		}

		/* retourne l'iterable resultat. */
		return resultat;

	} // Fin de save(...)._________________________________________________
	
	

	/* READ *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple retrieve(
			final IContactSimple pObject) throws Exception {

		/* return null si pObject == null. */
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
		}

		IContactSimple objectPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where contactSimple.nom = :pNom" 
					+ "and contactSimple.prenom = :pPrenom";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNom", pObject.getNom());
		requete.setParameter("pAnneesExperiences", pObject.getPrenom());

		try {

			/* Execution de la requete HQL. */
			objectPersistant 
				= (IContactSimple) requete.getSingleResult();

		}
		catch (NoResultException noResultExc) {

			/* retourne null si l'Objet métier n'existe pas en base. */
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
						CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode retrieve(IContactSimple pObject)", e);
		}

		return objectPersistant;

	} // Fin de retrieve(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple findById(
			final Long pId) throws Exception {

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

			/* ******************** */
			// RECHERCHE EN BASE.
			objetTrouve 
				= this.entityManager
					.find(ContactSimpleEntityJPA.class, pId);

		}
		catch (Exception e) {

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode findById(Long)", e);

		}

		return objetTrouve;

	} // Fin de findById(...)._____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long retrieveId(
			final IContactSimple pObject) throws Exception {
		
		final IContactSimple object = this.retrieve(pObject);
		
		Long resultat = null;
		
		if (object != null) {
			resultat = object.getId();
		}
		
		return resultat;
		
	} // Fin de retrieveId(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IContactSimple> findAll() throws Exception {

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
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode findall()", e);

		}

		/* Retourne la liste résultat. */
		return resultat;

	} // Fin de findAll()._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IContactSimple> findAllMax(
			final int pStartPosition
				, final int pMaxResult) throws Exception {


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

		List<IContactSimple> resultat = null;

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString)
					.setFirstResult(pStartPosition).setMaxResults(pMaxResult);

			/* Exécute la javax.persistence.Query. */
			resultat = query.getResultList();

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode findAllMax(...)", e);

		}

		/* Retourne la liste résultat. */
		return resultat;

	} // Fin de findAllMax(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IContactSimple> findAll(
			final Iterable<Long> pIds) throws Exception {

		/* retourne null si pIds == null. */
		if (pIds == null) {
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

		final List<IContactSimple> resultat = new ArrayList<IContactSimple>();		

		final Iterator<Long> iteratorID = pIds.iterator();

		while (iteratorID.hasNext()) {

			final Long id = iteratorID.next();
			
			/* Recherche en base sur Long. */
			final IContactSimple objetEnBase = this.findById(id);

			if (objetEnBase != null) {
				resultat.add(objetEnBase);
			}			
		}

		return resultat;

	} // Fin de findAll(...).______________________________________________



	/* UPDATE *************/

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple update(
			final IContactSimple pObject) throws Exception {

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

			/* Obtention d'une Entity JPA à partir de l'objet métier. */
			final ContactSimpleEntityJPA entity 
				= new ContactSimpleEntityJPA(pObject);
			
			/* **************** */
			/* MODIFIE en base. */
			this.entityManager.merge(entity);

			persistentObject = pObject;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode update(IContactSimple Object)", e);

		}

		/* retourne l'Objet persistant modifié. */
		return persistentObject;

	} // Fin de update(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple update(
			final Long pId, final IContactSimple pObjectModifie) 
												throws Exception {

		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}
		
		/* retourne null si pObjectModifie == null. */
		if (pObjectModifie == null) {
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

		/* récupération de l'objet persistant à modifier. */
		final IContactSimple objectPersistant = this.findById(pId);
		
		/* retourne null s'il n'y a pas d'objet persistant à pId. */
		if (objectPersistant == null) {
			return null;
		}

		IContactSimple persistentObject = null;
		
		try {
			
			final Long id = objectPersistant.getId();
			
			/* Obtention d'une Entity JPA à partir de l'objet métier. */
			final ContactSimpleEntityJPA entity 
				= new ContactSimpleEntityJPA(pObjectModifie);
			
			/* Passage de l'ID à l'entity contenant les modifications. */
			entity.setId(id);
			
			/* **************** */
			/* MODIFIE en base. */
			this.entityManager.merge(entity);

			persistentObject = pObjectModifie;
			
		} catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode update(Long pId"
								+ ", IContactSimple Object)", e);
			
		}

		/* retourne l'Objet persistant modifié. */
		return persistentObject;
		
	} // Fin de update(...)._______________________________________________



	/* DELETE *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final IContactSimple pObject) throws Exception {

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

		/* Vérifie qu'il existe une instance persistante. */
		final IContactSimple objectPersistant = this.retrieve(pObject);
		
		/* retourne false si pObject n'est pas persisté. */
		if (objectPersistant == null) {
			return false;
		}

		boolean resultat = false;
		
		try {

			/* Obtention d'une Entity JPA à partir de l'objet métier. */
			final ContactSimpleEntityJPA entity 
				= new ContactSimpleEntityJPA(objectPersistant);

			/* merge avant de pouvoir détruire. */
			this.entityManager.merge(entity);

			/* ************ */
			/* DESTRUCTION. */
			this.entityManager.remove(entity);

			resultat = true;

		} catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode delete(IContactSimple pObject)", e);

		}

		return resultat;

	} // Fin de delete(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(
			final Long pId) throws Exception {

		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		IContactSimple objectPersistant = null;

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
			objectPersistant 
			= (IContactSimple) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objectPersistant = null;
		}

		try {

			if (objectPersistant != null) {

				/* Obtention d'une Entity JPA à partir de l'objet métier. */
				final ContactSimpleEntityJPA entity 
					= new ContactSimpleEntityJPA(objectPersistant);

				/* Merge avant destruction. */
				this.entityManager.merge(entity);

				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);

			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode deleteById(Long pId)", e);
		}

	} // Fin de deleteById(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws Exception {

		/* retourne false si pId == null. */
		if (pId == null) {
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

		IContactSimple objectPersistant = null;

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
			objectPersistant 
			= (IContactSimple) requete.getSingleResult();
			
		}
		catch (NoResultException noResultExc) {
			objectPersistant = null;
			resultat = false;
		}

		try {

			if (objectPersistant != null) {

				/* Obtention d'une Entity JPA à 
				 * partir de l'objet métier. */
				final ContactSimpleEntityJPA entity 
					= new ContactSimpleEntityJPA(objectPersistant);

				/* Merge avant destruction. */
				this.entityManager.merge(entity);

				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);

				resultat = true;
			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode deleteByIdBoolean(Long pId)", e);
		}

		return resultat;

	} // Fin de deleteByIdBoolean(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() throws Exception {

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
			= "delete from ContactSimpleEntityJPA";

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);

			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode deleteAll()", e);

		}

	} // Fin de deleteAll()._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBoolean() throws Exception {

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
			= "delete from ContactSimpleEntityJPA";

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
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode deleteAllBoolean()", e);

		}

		return resultat;

	} // Fin de deleteAll()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteIterable(
			final Iterable<IContactSimple> pList) throws Exception {

		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		final Iterator<IContactSimple> itePersistants = pList.iterator();
		final List<IContactSimple> listePersistants 
			= new ArrayList<IContactSimple>();

		/* Récupération préalable des objets persistants en base. */
		while (itePersistants.hasNext()) {
			
			final IContactSimple objet = itePersistants.next();
			
			/* récupère l'objet persistant dans le stockage. */
			final IContactSimple objectPersistant = this.retrieve(objet);

			if (objectPersistant != null) {
				listePersistants.add(objectPersistant);
			}
		}


		/* Itération uniquement sur la liste des Objets persistants. */
		final Iterator<IContactSimple> ite = listePersistants.iterator();

		try {

			while (ite.hasNext()) {

				final IContactSimple objectPersistant = ite.next();
				
				/* Obtention d'une Entity JPA à 
				 * partir de l'objet métier. */
				final ContactSimpleEntityJPA entity 
					= new ContactSimpleEntityJPA(objectPersistant);
				
				/* Merge avant destruction. */
				this.entityManager.merge(entity);

				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);

			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_PERSONNEDAO_JPA_SPRING
					, "Méthode deleteIterable(Iterable)", e);

		}

	} // Fin de deleteIterable(...)._______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteIterableBoolean(
			final Iterable<IContactSimple> pList) throws Exception {

		/* retourne false si pList == null. */
		if (pList == null) {
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

		final Iterator<IContactSimple> itePersistants = pList.iterator();
		final List<IContactSimple> listePersistants 
			= new ArrayList<IContactSimple>();

		/* Récupération préalable des objets persistants en base. */
		while (itePersistants.hasNext()) {
			
			final IContactSimple objet = itePersistants.next();
			
			/* récupère l'objet persistant dans le stockage. */
			final IContactSimple objectPersistant = this.retrieve(objet);

			if (objectPersistant != null) {
				listePersistants.add(objectPersistant);
			}
		}


		boolean resultat = false;
		
		/* Itération uniquement sur la liste des Objets persistants. */
		final Iterator<IContactSimple> ite = listePersistants.iterator();

		try {

			while (ite.hasNext()) {

				final IContactSimple objectPersistant = ite.next();
				
				/* Obtention d'une Entity JPA à 
				 * partir de l'objet métier. */
				final ContactSimpleEntityJPA entity 
					= new ContactSimpleEntityJPA(objectPersistant);
				
				/* Merge avant destruction. */
				this.entityManager.merge(entity);

				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);

			}
			
			resultat = true;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_PERSONNEDAO_JPA_SPRING
					, "Méthode deleteIterableBoolean(Iterable)", e);

		}
		
		return resultat;

	} // Fin de deleteIterableBoolean(...).________________________________



	/* TOOLS *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final IContactSimple pObject) throws Exception {

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
		IContactSimple objectPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where contactSimple.nom = :pNom "
				+ "and contactSimple.prenom = :pPrenom";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNom", pObject.getNom());
		requete.setParameter("pPrenom", pObject.getPrenom());

		try {

			/* Execution de la requete HQL. */
			objectPersistant 
			= (IContactSimple) requete.getSingleResult();

			/* retourne true si l'objet existe en base. */
			if (objectPersistant != null) {
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
				.gererException(CLASSE_PERSONNEDAO_JPA_SPRING
						, "Méthode exists(IContactSimple pObject)", e);
		}

		return resultat;

	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Long pId) throws Exception {

		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}

		/* retourne true si l'objet métier existe en base. */
		if (this.findById(pId) != null) {
			return true;
		}

		return false;

	} // Fin de exists(Long...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() throws Exception {

		/* Récupère la liste d'Objets métier de Type paramétré IContactSimple. */
		final List<IContactSimple> listObjects = this.findAll();

		if (listObjects != null) {

			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}

		/* retourne 0L si this.findAll() retourne null. */
		return 0L;

	} // Fin de count().___________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireStockageDansConsole() throws Exception {
		
		/* récupération de tous les objets métier dans le stockage. */
		final List<IContactSimple> contenuStockage = this.findAll();
		
		/* ne fait rien si findAll() retourne null. */
		if (contenuStockage == null) {
			return;
		}
		
		for (final IContactSimple objet : contenuStockage) {
			System.out.println(objet.toString());
		}
		
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
		
		final StringBuilder stb =new StringBuilder();
		
		for (final IContactSimple objetMetier : pList) {
			
			stb.append(objetMetier.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		return stb.toString();
		
	} // Fin de afficherListeObjetsMetier(...).____________________________


	
} // FIN DE LA CLASSE DAO.--------------------------------------------
