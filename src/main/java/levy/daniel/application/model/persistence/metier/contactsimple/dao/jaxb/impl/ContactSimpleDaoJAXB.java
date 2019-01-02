package levy.daniel.application.model.persistence.metier.contactsimple.dao.jaxb.impl;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.ConfigurationApplicationManager;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.persistence.daoexceptions.technical.impl.DaoJAXBException;
import levy.daniel.application.model.persistence.metier.contactsimple.IContactSimpleDAO;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ContactSimpleEntityJAXB;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ListeContactSimplesEntityJAXB;


/**
 * CLASSE ContactSimpleDaoJAXB :<br/>
 * DAO JAXB pour les ContactSimple.<br/>
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
 * @since 24 mai 2018
 *
 */
public class ContactSimpleDaoJAXB implements IContactSimpleDAO {

	// ************************ATTRIBUTS************************************/

	/**
	 * "CLasse ContactSimpleDaoJAXB".
	 */
	public static final String CLASSE_CONTACTSIMPLE_DAO 
		= "CLasse ContactSimpleDaoJAXB";
	
	/**
	 * " - ".
	 */
	public static final String TIRET_MOINS_ESPACE 
		= " - ";
	
	/**
	 * context JAXB.<br/>
	 */
	private transient JAXBContext context;
		
	/**
	 * Objet vers XML.<br/>
	 */
	private transient Marshaller marshaller;

	/**
	 * XML vers Objet.<br/>
	 */
	private transient Unmarshaller unmarshaller;

	
	/**
	 * fichier XML dans lequel écrire les entities JAXB.<br/>
	 */
	private File fichierXML;
	
	
	/**
	 * saut de ligne de la plateforme.<br/>
	 */
	public static final String SAUT_LIGNE_PLATEFORME 
		= System.getProperty("line.separator");
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ContactSimpleDaoJAXB.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * 
	 * @throws JAXBException 
	 */
	public ContactSimpleDaoJAXB() throws JAXBException {
		this(null);		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

		
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pFile : java.io.File : 
	 * le fichier XML dans lequel écrire les entities JAXB.<br/>
	 * 
	 * @throws JAXBException
	 */
	public ContactSimpleDaoJAXB(
			final File pFile) throws JAXBException {
		
		super();
		
		if (pFile != null) {
			this.fichierXML = pFile;
		} else {
			this.fichierXML = this.fournirFichierXMLParDefaut();
		}
		
		
		this.instancierContextJAXB();
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * <b>retourne le fichier XML de stockage du DAO stocké 
	 * dans ConfigurationApplicationManager</b>.<br/>
	 * <ul>
	 * <li><code>data/
	 * base-adresses_javafx-JAXB/base-adresses_javafx-JAXB.xml</code></li>
	 * </ul>
	 *
	 * @return : File : fichier XML de stockage du DAO.<br/>
	 */
	private File fournirFichierXMLParDefaut() {
		
		final Path pathFichierXML 
			= ConfigurationApplicationManager.getFichierJAXBXMLPath();
		
		final File fichierXMLParDefaut = pathFichierXML.toFile();
		
		return fichierXMLParDefaut;
		
	} // Fin de fournirFichierXMLParDefaut().______________________________
	
	
	
	/**
	 * <b>Instancie le context JAXB et les Marshaller 
	 * et Unmarshaller</b>.<br/>
	 * <ul>
	 * <li>instancie le context pour l'Entity 
	 * ListeContactSimplesEntityJAXB (équivalent d'une table SGBDR).</li>
	 * <li>Instancie le Marshaller (Objet vers XML).</li>
	 * <li>Paramètre le Marshaller (Objet vers XML) 
	 * en demandant le formatage.</li>
	 * <li>Instancie le Unmarshaller (XML vers Objet).</li>
	 * </ul>
	 * 
	 * @throws JAXBException 
	 */
	private void instancierContextJAXB() throws JAXBException {
		
		/* instancie le context pour l'Entity ListeContactSimplesEntityJAXB. */
		this.context 
			= JAXBContext.newInstance(ListeContactSimplesEntityJAXB.class);
		
		/* Instancie le Marshaller (Objet vers XML). */
		this.marshaller = this.context.createMarshaller();
		
		/* Paramètre le Marshaller (Objet vers XML) 
		 * en demandant le formatage. */
		this.marshaller.setProperty(
				Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		/* Instancie le Unmarshaller (XML vers Objet). */
		this.unmarshaller = this.context.createUnmarshaller();
		
	} // Fin de instancierContextJAXB().___________________________________
	
	
	
	/**
	 * <b>Crée un OBJET METIER à partir d'une EntityJAXB</b>.<br/>
	 * <br/>
	 * - retourne null si pEntityJAXB == null.<br/>
	 * <br/>
	 *
	 * @param pEntityJAXB : ContactSimpleEntityJAXB.<br/>
	 * 
	 * @return : IContactSimple.<br/>
	 */
	private IContactSimple creerObjetMetier(
			final ContactSimpleEntityJAXB pEntityJAXB) {
		
		/* retourne null si pEntityJAXB == null. */
		if (pEntityJAXB == null) {
			return null;
		}
		
		final IContactSimple contactSimple 
			= new ContactSimple(pEntityJAXB.getId()
					, pEntityJAXB.getPrenom()
					, pEntityJAXB.getNom()
					, pEntityJAXB.getRue()
					, pEntityJAXB.getRue2()
					, pEntityJAXB.getCodePostal()
					, pEntityJAXB.getVille()
					, pEntityJAXB.getPays()
					, pEntityJAXB.getTelephone()
					, pEntityJAXB.getMail()
					, pEntityJAXB.getDateNaissance());
		
		return contactSimple;
		
	} // Fin de creerObjetMetier(...)._____________________________________
	
	
	
	/**
	 * <b>convertit une Liste d'OBJETS METIER en liste 
	 * d'Entities JAXB</b>.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;
	 * 
	 * @return : List&lt;ContactSimpleEntityJAXB&gt;.<br/>
	 */
	private List<ContactSimpleEntityJAXB> convertirListModelEnEntities(
			final List<IContactSimple> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<ContactSimpleEntityJAXB> resultat 
			= new ArrayList<ContactSimpleEntityJAXB>();
		
		for (final IContactSimple contactSimple : pList) {
			
			if (contactSimple != null) {
				
				final ContactSimpleEntityJAXB contactSimpleJAXB 
					= new ContactSimpleEntityJAXB(contactSimple);
				
				resultat.add(contactSimpleJAXB);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________
	

		
	/**
	 * <b>convertit une Liste d'Entities JAXB 
	 * en liste d'OBJETS METIER</b>.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;ContactSimpleEntityJAXB&gt;.<br/>
	 * 
	 * @return : List&lt;IContactSimple&gt;.<br/>
	 */
	private List<IContactSimple> convertirListEntitiesEnModel(
			final List<ContactSimpleEntityJAXB> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<IContactSimple> resultat 
			= new ArrayList<IContactSimple>();
		
		for (final ContactSimpleEntityJAXB contactSimple : pList) {
			
			if (contactSimple != null) {
				
				final IContactSimple contactSimpleModel 
					= this.creerObjetMetier(contactSimple);
				
				resultat.add(contactSimpleModel);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListEntitiesEnModel(...)._________________________
	
	
	
	/**
	 * <b>Instancie une Entity JAXB ListeContactSimplesEntityJAXB 
	 * <i>(équivalent d'une table SGBDR)</i> à partir 
	 * d'une Liste d'OBJETS METIER List&lt;IContactSimple&gt; pList</b>.<br/>
	 * <ul>
	 * <li>retourne null si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IContactSimple&gt; : Liste d'OBJETS METIER
	 * à transformer en Entity JAXB en vue de la sérialization.<br/>
	 * 
	 * @return : ListeContactSimplesEntityJAXB : Entity JAXB serializable 
	 * sous forme de fichier XML.<br/>
	 */
	private ListeContactSimplesEntityJAXB creerEntityJAXB(
			final List<IContactSimple> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<ContactSimpleEntityJAXB> liste 
			= this.convertirListModelEnEntities(pList);
	
		final ListeContactSimplesEntityJAXB contacts 
			= new ListeContactSimplesEntityJAXB(liste);
		
		return contacts;
		
	} // Fin de creerEntityJAXB(...).______________________________________



	
	/* CREATE ************/

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IContactSimple create(
			final IContactSimple pObject) throws AbstractDaoException {
		return this.create(pObject, this.fichierXML);
	} // Fin de create(...)._______________________________________________
	
	
	
	/**
	 * <b>Crée l'OBJET METIER pObject dans un fichier XML pFile 
	 * et retourne l'Objet Métier persisté</b>.<br/>
	 * <ul>
	 * <li>ajoute l'Objet Métier pObject à la liste 
	 * des objets métier stockés.</li>
	 * <li>enregistre la nouvelle liste dans le stockage XML.</li>
	 * <li>ne crée pas de doublon.</li>
	 * <li>retourne null si pObject existe déjà dans le stockage.</li>
	 * <li>retourne null si les attributs obligatoires 
	 * de pObject ne sont pas remplis.</li>
	 * </ul>
	 * - retourne null si pObject == null.<br/>
	 * - retourne null si pFile == null.<br/>
	 * <br/>
	 *
	 * @param pObject : IContactSimple.<br/>
	 * @param pFile : java.io.File : 
	 * le fichier XML dans lequel écrire les entities JAXB.<br/>
	 *  
	 * @return : IContactSimple : OBJET METIER stocké dans le fichier.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	private IContactSimple create(
			final IContactSimple pObject
				, final File pFile) 
						throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		List<IContactSimple> stockageList = null;
		
		if (pFile.exists()) {
			stockageList = this.recupererListeModeles(pFile);
		} else {
			stockageList = new ArrayList<IContactSimple>();
		}
		  		
		if (stockageList != null) {
			
			/* ne crée pas de doublon. */
			if (!this.exists(pObject)) {
				
				/* ajoute l'Objet Métier pObject à la liste 
				 * des objets métier stockés. */
				/* VERIFIE LES ATTRIBUTS OBLIGATOIRES. */
				if (pObject.getNom() != null && pObject.getPrenom() != null) {
					stockageList.add(pObject);
				} else {
					return null;
				}
								
				/* enregistre la nouvelle liste dans le stockage XML. */
				this.enregistrer(stockageList, pFile);
				
			} else {
				/* retourne null si pObject existe déjà dans le stockage. */
				return null;
			}
						
			return pObject;
			
		} 
		
		/* retourne null si pObject == null. */
		return null;
				
	} // Fin de create(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 * - ne fait rien si this.fichierXML == null.<br/>
	 * <br/>
	 */
	@Override
	public void persist(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* ne fait rien si pObject == null. */
		if (pObject == null) {
			return;
		}
		
		/* ne fait rien si this.fichierXML == null. */
		if (this.fichierXML == null) {
			return;
		}
		
		List<IContactSimple> stockageList = null;
		
		if (this.fichierXML.exists()) {
			stockageList = this.recupererListeModeles(this.fichierXML);
		} else {
			stockageList = new ArrayList<IContactSimple>();
		}
		  		
		if (stockageList != null) {
			
			/* ne crée pas de doublon. */
			if (!this.exists(pObject)) {
				
				/* ajoute l'Objet Métier pObject à la liste 
				 * des objets métier stockés. */
				/* VERIFIE LES ATTRIBUTS OBLIGATOIRES. */
				if (pObject.getNom() != null && pObject.getPrenom() != null) {
					stockageList.add(pObject);
				} else {
					return;
				}
								
				/* enregistre la nouvelle liste dans le stockage XML. */
				this.enregistrer(stockageList, this.fichierXML);
				
			}
			
		} 
				
	} // Fin de persist(...).______________________________________________



	/**
	 * {@inheritDoc}
	 *  retourne null si this.fichierXML == null.<br/>
	 *  <br/>
	 */
	@Override
	public Long createReturnId(
			final IContactSimple pObject) throws AbstractDaoException {
		
		final IContactSimple objetPersistant = this.create(pObject);
		Long resultat = null;
		
		if (objetPersistant != null) {
			resultat = this.retrieveId(objetPersistant);
		}
		
		return resultat;
		
	} // Fin de createReturnId(...)._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IContactSimple> save(
			final Iterable<IContactSimple> pList) throws AbstractDaoException {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}

		List<IContactSimple> stockageList = null;
		
		if (this.fichierXML.exists()) {
			stockageList = this.recupererListeModeles(this.fichierXML);
		} else {
			stockageList = new ArrayList<IContactSimple>();
		}

		final List<IContactSimple> resultat = new ArrayList<IContactSimple>();

		final Iterator<IContactSimple> iteS = pList.iterator();
		
		if (stockageList != null) {
			
			while (iteS.hasNext()) {
				
				final IContactSimple objet = iteS.next();
				
				if (objet != null) {
					
					/* ne crée pas de doublon. */
					if (!this.exists(objet)) {
						
						/* ajoute l'Objet Métier pObject à la liste 
						 * des objets métier stockés. */
						/* VERIFIE LES ATTRIBUTS OBLIGATOIRES. */
						if (objet.getNom() != null 
								&& objet.getPrenom() != null) {
							
							if (!stockageList.contains(objet)) {
								stockageList.add(objet);
							}
							
							if (!resultat.contains(objet)) {
								resultat.add(objet);
							}
							
						}
						
					}
					
				}
							
			}
			
			/* enregistre la nouvelle liste dans le stockage XML. */
			this.enregistrer(stockageList, this.fichierXML);
		}

		return resultat;
		
	} // Fin de save(...)._________________________________________________
	
	

	/* READ *************/



	/**
	 * {@inheritDoc}
	 * - retourne null si le stockage n'existe pas.<br/>
	 * - retourne null si le stockage est vide.<br/>
	 * <br/>
	 */
	@Override
	public IContactSimple retrieve(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		List<IContactSimple> stockageList = null;
		
		/* retourne null si le stockage n'existe pas. */
		if (this.fichierXML.exists()) {
			stockageList = this.recupererListeModeles(this.fichierXML);
		} else {
			return null;
		}
		
		/* retourne null si le stockage est vide. */
		if (stockageList.isEmpty()) {
			return null;
		}
		
		IContactSimple resultat = null;
		
		for (final IContactSimple objet : stockageList) {
			
			if (pObject.equals(objet)) {
				resultat = objet;
				break;
			}
		}
		
		return resultat;
		
	} // Fin de retrieve(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 * - retourne null si pId est en dehors des index de stockage.<br/>
	 * - retourne null si le stockage n'existe pas.<br/>
	 * - retourne null si le stockage est vide.<br/>
	 * <br/>
	 */
	@Override
	public IContactSimple findById(
			final Long pId) throws AbstractDaoException {
		
		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}
		
		List<IContactSimple> stockageList = null;
		
		/* retourne null si le stockage n'existe pas. */
		if (this.fichierXML.exists()) {
			stockageList = this.recupererListeModeles(this.fichierXML);
		} else {
			return null;
		}
		
		/* retourne null si le stockage est vide. */
		if (stockageList.isEmpty()) {
			return null;
		}
		
		/* retourne null si pId est en dehors des index de stockage. */
		if (pId > stockageList.size() - 1) {
			return null;
		}
		
		IContactSimple resultat = null;
		
		Long id = 0L;
		
		for (final IContactSimple objet : stockageList) {
			
			if (pId.equals(id)) {
				resultat = objet;
				break;
			}
			
			id++;
		}
		
		return resultat;
		
	} // Fin de findById(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 * - retourne null si le stockage n'existe pas.<br/>
	 * - retourne null si le stockage est vide.<br/>
	 * <br/>
	 */
	@Override
	public Long retrieveId(
			final IContactSimple pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		List<IContactSimple> stockageList = null;
		
		/* retourne null si le stockage n'existe pas. */
		if (this.fichierXML.exists()) {
			stockageList = this.recupererListeModeles(this.fichierXML);
		} else {
			return null;
		}
		
		/* retourne null si le stockage est vide. */
		if (stockageList.isEmpty()) {
			return null;
		}
		
		Long resultat = null;
		
		int i = 0;
		
		for (final IContactSimple objet : stockageList) {
			
			if (pObject.equals(objet)) {
				resultat = Long.valueOf(i);
				break;
			}
			
			i++;
		}
		
		return resultat;
		
	} // Fin de retrieveId(...).___________________________________________



	/**
	 * {@inheritDoc}
	 * - retourne null si le stockage n'existe pas.<br/>
	 * <br/>
	 */
	@Override
	public List<IContactSimple> findAll() throws AbstractDaoException {
		
		List<IContactSimple> stockageList = null;
		
		/* retourne null si le stockage n'existe pas. */
		if (this.fichierXML.exists()) {
			stockageList = this.recupererListeModeles(this.fichierXML);
		} else {
			return null;
		}
		
		return stockageList;
		
	} // Fin de findAll()._________________________________________________



	/**
	 * {@inheritDoc}
	 * - retourne null si le stockage n'existe pas.<br/>
	 * - retourne null si le stockage est vide.<br/>
	 * <br/>
	 */
	@Override
	public List<IContactSimple> findAllMax(
			final int pStartPosition, final int pMaxResult) 
						throws AbstractDaoException {
		
		List<IContactSimple> stockageList = null;
		
		/* retourne null si le stockage n'existe pas. */
		if (this.fichierXML.exists()) {
			stockageList = this.recupererListeModeles(this.fichierXML);
		} else {
			return null;
		}
		
		/* retourne null si le stockage est vide. */
		if (stockageList.isEmpty()) {
			return null;
		}
		
		/* retourne null si pId est en dehors des index de stockage. */
		if (pStartPosition > stockageList.size() - 1) {
			return null;
		}
		
		
		final List<IContactSimple> resultat 
			= new ArrayList<IContactSimple>();
		
		for (final IContactSimple objet : stockageList) {
			
			final Long indexContactSimple = this.retrieveId(objet);
			final int finPosition = pStartPosition + pMaxResult;
			
			if (indexContactSimple >= pStartPosition 
					&& indexContactSimple < finPosition) {
				resultat.add(objet);
			}
		}
		
		return resultat;
		
	} // Fin de findAllMax(...).___________________________________________



	/**
	 * {@inheritDoc}
	 * - retourne null si le stockage n'existe pas.<br/>
	 * - retourne null si le stockage est vide.<br/>
	 * <br/>
	 */
	@Override
	public Iterable<IContactSimple> findAllIterable(
			final Iterable<Long> pIds) throws AbstractDaoException {
		
		/* retourne null si pIds == null. */
		if (pIds == null) {
			return null;
		}
		
		List<IContactSimple> stockageList = null;
		
		/* retourne null si le stockage n'existe pas. */
		if (this.fichierXML.exists()) {
			stockageList = this.recupererListeModeles(this.fichierXML);
		} else {
			return null;
		}
		
		/* retourne null si le stockage est vide. */
		if (stockageList.isEmpty()) {
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
		
		return resultat;
		
	} // Fin de findAll(...).______________________________________________



	/* UPDATE *************/

	
	/**
	 * {@inheritDoc}
	 * <b>retourne toujours null pour un DAO JAXB.</b><br/>
	 * <br/>
	 */
	@Override
	public IContactSimple update(
			final IContactSimple pObject) throws AbstractDaoException {
		
		return null;
				
	} // Fin de update(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 * - retourne null si le stockage n'existe pas.<br/>
	 * - retourne null si le stockage est vide.<br/>
	 * <br/>
	 */
	@Override
	public IContactSimple update(
			final Long pId, final IContactSimple pObjectModifie) 
					throws AbstractDaoException {
		
		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}
		
		/* retourne null si pId est en dehors des indexes. */
		if (pId > this.count() - 1) {
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
		
		final IContactSimple objetPersistant = this.findById(pId);
		
		/* retourne null s'il n'y a pas d'objet persistant à pId. */
		if (objetPersistant == null) {
			return null;
		}
		
		
		List<IContactSimple> stockageList = null;
		
		/* retourne null si le stockage n'existe pas. */
		if (this.fichierXML.exists()) {
			stockageList = this.recupererListeModeles(this.fichierXML);
		} else {
			return null;
		}
		
		/* retourne null si le stockage est vide. */
		if (stockageList.isEmpty()) {
			return null;
		}
		
		final List<IContactSimple> resultat 
			= new ArrayList<IContactSimple>();
		
		/* substitue pObjectModifie à l'objet persistant 
		 * d'ID pId dans le stockage. */
		for (final IContactSimple objet : stockageList) {
			
			if (!objetPersistant.equals(objet)) {				
				resultat.add(objet);
			} else {
				resultat.add(pObjectModifie);
			}
		}

		/* enregistre la nouvelle liste dans le stockage XML. */
		this.enregistrer(resultat, this.fichierXML);
		
		return this.retrieve(pObjectModifie);
		
	} // Fin de update(...)._______________________________________________



	/* DELETE *************/



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final IContactSimple pObject) throws AbstractDaoException {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(
			final Long pId) throws AbstractDaoException {
		// TODO Auto-generated method stub
		
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws AbstractDaoException {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() throws AbstractDaoException {
		
		/* instancie une nouvelle liste vide. */
		final List<IContactSimple> contacts = new ArrayList<IContactSimple>();
		
		/* enregistre la nouvelle liste vide dans le stockage XML. */
		this.enregistrer(contacts, this.fichierXML);
		
	} // Fin de deleteAll()._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBoolean() throws AbstractDaoException {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteIterable(
			final Iterable<IContactSimple> pList) throws AbstractDaoException {
		// TODO Auto-generated method stub
		
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteIterableBoolean(
			final Iterable<IContactSimple> pList) throws AbstractDaoException {
		// TODO Auto-generated method stub
		return false;
	}



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
		
		List<IContactSimple> stockageList = null;
		
		stockageList = this.findAll();
		
		for (final IContactSimple objet : stockageList) {
			
			if (pObject.equals(objet)) {
				return true;
			}
		}
		
		return false;

	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Long pId) throws AbstractDaoException {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() throws AbstractDaoException {
		
		List<IContactSimple> contacts = null;
		
		contacts = this.findAll();
		
		if (contacts != null) {
			return Long.valueOf(contacts.size());
		}
		
		return null;
		
	} // Fin de count().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireStockageDansConsole() 
					throws AbstractDaoException {
		// TODO Auto-generated method stub
		
	}


	
	/**
	 * <b>fournit une String pour l'affichage à la console 
	 * d'une Liste d'OBJETS METIER</b>.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;.<br/>
	 * 
	 * @return : String.<br/>
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
		
	} // Fin de afficherListeContactSimple(...).________________________________


	
	/**
	 * <b>Enregistre sur disque dans le fichier XML pFile 
	 * la liste d'OBJETS METIER 
	 * List&lt;IContactSimple&gt; pList</b>.<br/>
	 * <ul>
	 * <li>Crée le fichier XML pFile sur disque si il n'existe pas.</li>
	 * <li>Remplace pFile si il existe déjà.</li>
	 * </ul>
	 * - ne fait rien si pList == null.<br/>
	 * - ne fait rien si pFile == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;.<br/>
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private void enregistrer(
			final List<IContactSimple> pList
				, final File pFile) throws AbstractDaoException {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
		
		final ListeContactSimplesEntityJAXB contacts 
			= this.creerEntityJAXB(pList);
		
		this.enregistrer(contacts, pFile);
		
	} // Fin de enregistrer(...).__________________________________________
	
	
	
	/**
	 * <b>Enregistre sur disque dans le fichier XML pFile 
	 * l'Entity JAXB pContactsEntityJAXB</b>.<br/>
	 * <ul>
	 * <li>Crée le fichier XML pFile sur disque si il n'existe pas.</li>
	 * <li>Remplace pFile si il existe déjà.</li>
	 * <li>utilise <code>marshaller.marshal(
	 * pListeContactSimplesEntityJAXB, pFile);</code> pour serializer 
	 * dans le fichier XML</li>
	 * </ul>
	 * - ne fait rien si pContactsEntityJAXB == null.<br/>
	 * - ne fait rien si pFile == null.<br/>
	 * <br/>
	 *
	 * @param pListeContactSimplesEntityJAXB : ListeContactSimplesEntityJAXB.<br/>
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private void enregistrer(
			final ListeContactSimplesEntityJAXB pListeContactSimplesEntityJAXB
				, final File pFile) throws AbstractDaoException {
		
		/* ne fait rien si pContactsEntityJAXB == null. */
		if (pListeContactSimplesEntityJAXB == null) {
			return;
		}
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
		
		/* Ecriture sur disque dur sous forme de fichier XML. */
		try {
			
			this.marshaller.marshal(pListeContactSimplesEntityJAXB, pFile);
			
		} catch (JAXBException e) {
			
			final String message 
				= CLASSE_CONTACTSIMPLE_DAO
				+ TIRET_MOINS_ESPACE
				+ "méthode enregistrer("
				+ "ListeContactSimplesEntityJAXB pListeContactSimplesEntityJAXB"
				+ ", File pFile)" 
				+ TIRET_MOINS_ESPACE 
				+ "Impossible de sérializer dans le fichier : " 
				+ pFile.getAbsolutePath();
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message, e);
			}
			
			throw new DaoJAXBException(message, e);

		}
		
	} // Fin de enregistrer(...).__________________________________________
	


	/**
	 * Affiche à la console la liste de MODEL 
	 * List&lt;IContactSimple&gt; pList sous forme de fichier XML.<br/>
	 * <ul>
	 * <li>ne fait rien si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IContactSimple&gt;
	 * 
	 * @throws AbstractDaoException
	 */
	public void ecrireContactsConsole(
			final List<IContactSimple> pList) throws AbstractDaoException {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}
		
		final List<ContactSimpleEntityJAXB> contactsContactSimpleJAXB 
			= this.convertirListModelEnEntities(pList);
		
		final ListeContactSimplesEntityJAXB contactsJAXB 
			= new ListeContactSimplesEntityJAXB(contactsContactSimpleJAXB);
		
		this.ecrireContactsConsole(contactsJAXB);
		
	} // Fin de ecrireContactsConsole(...).________________________________
	

	
	/**
	 * method ecrireContactsConsole(
	 * ListeContactSimplesEntityJAXB pContactsEntityJAXB) :<br/>
	 * Affiche à la console l'Entity JAXB pContactsEntityJAXB 
	 * sous forme de fichier XML.<br/>
	 * <ul>
	 * <li>ne fait rien si pContactsEntityJAXB == null.</li>
	 * </ul>
	 *
	 * @param pListeContactSimplesEntityJAXB : ListeContactSimplesEntityJAXB.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	private void ecrireContactsConsole(
			final ListeContactSimplesEntityJAXB pListeContactSimplesEntityJAXB) 
					throws AbstractDaoException {
		
		/* ne fait rien si pContactsEntityJAXB == null. */
		if (pListeContactSimplesEntityJAXB == null) {
			return;
		}
		
		/* Ecriture dans la console sous forme de fichier XML. */
		try {
			
			this.marshaller.marshal(pListeContactSimplesEntityJAXB, System.out);
			
		} catch (JAXBException e) {
			
			final String message 
				= CLASSE_CONTACTSIMPLE_DAO
				+ TIRET_MOINS_ESPACE
				+ "méthode ecrireContactsConsole("
				+ "ListeContactSimplesEntityJAXB pListeContactSimplesEntityJAXB)" 
				+ TIRET_MOINS_ESPACE 
				+ "Impossible d'écrire les objets dans la console";
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message, e);
			}
			
			throw new DaoJAXBException(message, e);

		}
		
	} // Fin de ecrireContactsConsole(...).________________________________
	
	
	
	/**
	 * Récupére la liste des OBJETS METIER dans le fichier XML 
	 * correspondant à une Entity JAXB ListeContactSimplesEntityJAXB 
	 * (équivalent d'une table SGBDR).<br/>
	 * <br/>
	 * - return null si pFile == null.<br/>
	 * - return null si pFile n'existe pas.<br/>
	 * - return null si pFile n'est pas un fichier simple.<br/>
	 * <br/>
	 *
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @return List&lt;IContactSimple&gt;.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public List<IContactSimple> recupererListeModeles(
			final File pFile) 
					throws AbstractDaoException {
		
		/* return null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* return null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* return null si pFile n'est pas un fichier simple. */
		if (pFile.isDirectory()) {
			return null;
		}
		
		final ListeContactSimplesEntityJAXB contacts 
			= this.recupererEntites(pFile);
		
		final List<ContactSimpleEntityJAXB> listeEntities 
			= contacts.getListeContactSimples();
		
		final List<IContactSimple> resultat 
			= this.convertirListEntitiesEnModel(listeEntities);
		
		return resultat;
		
	} // Fin de recupererListeModeles(...).________________________________
	
	
	
	/**
	 * <b>Récupère une Entity JAXB ListeContactSimplesEntityJAXB 
	 * (équivalent d'une table SGBDR)
	 * à partir du fichier XML pFile</b>.<br/>
	 * <ul>
	 * <li>return null si pFile == null.</li>
	 * <li>return null si pFile n'existe pas.</li>
	 * <li>return null si pFile n'est pas un fichier simple.</li>
	 * </ul>
	 *
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @return ListeContactSimplesEntityJAXB : 
	 * Entity JAXB modélisant le contenu du fichier XML pFile 
	 * (équivalent d'une table SGBDR).<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	public ListeContactSimplesEntityJAXB recupererEntites(
			final File pFile) 
					throws AbstractDaoException {
		
		/* return null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		/* return null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* return null si pFile n'est pas un fichier simple. */
		if (pFile.isDirectory()) {
			return null;
		}
		
		FileReader fileReader = null;
		
		ListeContactSimplesEntityJAXB resultat = null;
		
		try {
			
			fileReader = new FileReader(pFile);
			
			resultat 
				= (ListeContactSimplesEntityJAXB) 
					this.unmarshaller.unmarshal(fileReader);
			
		} catch (Exception e) {
			
			final String message 
				= CLASSE_CONTACTSIMPLE_DAO
				+ TIRET_MOINS_ESPACE
				+ "méthode recupererEntites(File pFile)" 
				+ TIRET_MOINS_ESPACE 
				+ "Impossible de désérializer le fichier : " 
				+ pFile.getAbsolutePath();
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message, e);
			}
			
			throw new DaoJAXBException(message, e);
		}
		
		return resultat;
		
	} // Fin de recupererEntites(...)._____________________________________
	

	
	/**
	 * fournit une String pour l'affichage à la console 
	 * d'une liste de ContactSimple contenue dans une Entity JAXB 
	 * pContacts.<br/>
	 * <ul>
	 * <li>retourne null si pContacts == null.</li>
	 * </ul>
	 *
	 * @param pContacts : ListeContactSimplesEntityJAXB.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListeContactSimpleDansContacts(
			final ListeContactSimplesEntityJAXB pContacts) {
		
		/* retourne null si pContacts == null. */
		if (pContacts == null) {
			return null;
		}
		
		final List<ContactSimpleEntityJAXB> listeEntities 
			= pContacts.getListeContactSimples();
		
		return this.afficherListeContactSimpleJAXB(listeEntities);
		
	} // Fin de afficherListeContactSimpleDansContacts(...).____________________
	
	
	
	/**
	 * method afficherListeContactSimpleJAXB(
	 * List&lt;ContactSimpleEntityJAXB&gt; pList) :<br/>
	 * fournit une String pour l'affichage à la console 
	 * d'une Liste de ContactSimpleEntityJAXB.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;ContactSimpleEntityJAXB&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListeContactSimpleJAXB(
			final List<ContactSimpleEntityJAXB> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final ContactSimpleEntityJAXB contactSimple : pList) {
			
			stb.append(contactSimple.toString());
			stb.append(SAUT_LIGNE_PLATEFORME);
			
		}
		
		return stb.toString();		

	} // Fin de afficherListeContactSimpleJAXB(...).____________________________



	/**
	 * method getFichierXML() :<br/>
	 * Getter du fichier XML dans lequel écrire les entities JAXB.<br/>
	 * <br/>
	 *
	 * @return fichierXML : File.<br/>
	 */
	public File getFichierXML() {
		return this.fichierXML;
	} // Fin de getFichierXML().___________________________________________


	
	/**
	* method setFichierXML(
	* File pFichierXML) :<br/>
	* Setter du fichier XML dans lequel écrire les entities JAXB.<br/>
	* <br/>
	*
	* @param pFichierXML : File : valeur à passer à fichierXML.<br/>
	*/
	public void setFichierXML(
			final File pFichierXML) {
		this.fichierXML = pFichierXML;
	} // Fin de setFichierXML(...).________________________________________
	
		
	
} // FIN DE LA CLASSE ContactSimpleDaoJAXB.---------------------------------------
