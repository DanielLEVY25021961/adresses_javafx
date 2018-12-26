package levy.daniel.application.model.persistence.metier.contactsimple.dao.jaxb.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.metier.contactsimple.impl.ContactSimple;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ListeContactSimplesEntityJAXB;
import levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb.ContactSimpleEntityJAXB;


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
public class ContactSimpleDaoJAXB {

	// ************************ATTRIBUTS************************************/

	/**
	 * context : JAXBContext :<br/>
	 * context JAXB.<br/>
	 */
	private transient JAXBContext context;
		
	/**
	 * marshaller : Marshaller :<br/>
	 * Objet vers XML.<br/>
	 */
	private transient Marshaller marshaller;

	/**
	 * unmarshaller : Unmarshaller :<br/>
	 * XML vers Objet.<br/>
	 */
	private transient Unmarshaller unmarshaller;

	
	/**
	 * fichierXML : File :<br/>
	 * fichier XML dans lequel écrire les entities JAXB.<br/>
	 */
	private File fichierXML;
	
	
	/**
	 * SAUT_LIGNE_JAVA : Character :<br/>
	 * saut de ligne "\n".<br/>
	 */
	public static final String SAUT_LIGNE_JAVA = "\n";
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ContactSimpleDaoJAXB.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ContactSimpleDaoJAXB() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * @throws JAXBException 
	 */
	public ContactSimpleDaoJAXB() throws JAXBException {
		this(null);		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

		
	 /**
	 * method CONSTRUCTEUR ContactSimpleDaoJAXB(
	 * File pFile) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pFile : java.io.File : 
	 * le fichier XML dans lequel écrire les entities JAXB.<br/>
	 * 
	 * @throws JAXBException
	 */
	public ContactSimpleDaoJAXB(
			final File pFile) throws JAXBException {
		
		super();
		
		this.fichierXML = pFile;
		
		this.instancierContextJAXB();
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	/**
	 * method instancierContext() :<br/>
	 * Instancie le context JAXB et les Marshaller et Unmarshaller.<br/>
	 * <ul>
	 * <li>instancie le context pour l'Entity ListeContactSimplesEntityJAXB. </li>
	 * <li>Instancie le Marshaller (Objet vers XML).</li>
	 * <li>Paramètre le Marshaller (Objet vers XML).</li>
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
		
		/* Paramètre le Marshaller (Objet vers XML). */
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
	private IContactSimple creerContactSimple(
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
		
	} // Fin de creerContactSimple(...).________________________________________
	
	
	
	/**
	 * method convertirListModelEnEntities(
	 * List&lt;IContactSimple&gt; pList) :<br/>
	 * convertit une Liste de ContactSimple (MODEL) en liste 
	 * de ContactSimpleEntityJAXB (Entities JAXB).<br/>
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
	 * method convertirListEntitiesEnModel(
	 * List&lt;ContactSimpleEntityJAXB&gt; pList) :<br/>
	 * convertit une Liste de ContactSimpleEntityJAXB (Entities JAXB) 
	 * en liste de ContactSimple (MODEL).<br/>
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
					= this.creerContactSimple(contactSimple);
				
				resultat.add(contactSimpleModel);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListEntitiesEnModel(...)._________________________
	
	
	
	/**
	 * Instancie une Entity JAXB ListeContactSimplesEntityJAXB à partir 
	 * d'une Liste de MODEL List&lt;IContactSimple&gt; pList.<br/>
	 * <ul>
	 * <li>retourne null si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IContactSimple&gt; : Liste de MODEL 
	 * à transformer en Entities JAXB en vue de la sérialization.<br/>
	 * 
	 * @return : ListeContactSimplesEntityJAXB : Entity serializable 
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


	
	/**
	 * Crée la ContactSimple pObject dans un fichier XML pFile.<br/>
	 * <ul>
	 * <li>retourne null si pObject == null.</li>
	 * <li>retourne null si pFile == null.</li>
	 * </ul>
	 *
	 * @param pObject : IContactSimple.<br/>
	 * @param pFile : java.io.File : 
	 * le fichier XML dans lequel écrire les entities JAXB.<br/>
	 *  
	 * @return : IContactSimple : le MODEL stocké dans le fichier.<br/>
	 * 
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public IContactSimple create(
			final IContactSimple pObject
				, final File pFile) 
						throws FileNotFoundException, JAXBException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* retourne null si pFile == null. */
		if (pFile == null) {
			return null;
		}
		
		List<IContactSimple> contacts = null;
		
		if (pFile.exists()) {
			contacts = this.recupererListeModeles(pFile);
		} else {
			contacts = new ArrayList<IContactSimple>();
		}
		  		
		if (contacts != null) {
			
			/* ajout de la contactSimple à la liste. */
			contacts.add(pObject);
			
			/* enregistrement de la nouvelle liste. */
			this.enregistrer(contacts, pFile);
			
			return pObject;
		} 
			
		return null;
				
	} // Fin de create(...)._______________________________________________


	
	/**
	 * Enregistre sur disque dans le fichier XML pFile 
	 * la liste de MODEL List&lt;IContactSimple&gt; pList.<br/>
	 * <ul>
	 * <li>Crée pFile sur disque si il n'existe pas.</li>
	 * <li>Remplace pFile si il existe déjà.</li>
	 * <li>ne fait rien si pList == null.</li>
	 * <li>ne fait rien si pFile == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IContactSimple&gt;.<br/>
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @throws JAXBException
	 */
	public void enregistrer(
			final List<IContactSimple> pList
				, final File pFile) throws JAXBException {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
		
		final ListeContactSimplesEntityJAXB contacts = this.creerEntityJAXB(pList);
		
		this.enregistrer(contacts, pFile);
		
	} // Fin de enregistrer(...).__________________________________________
	
	
	
	/**
	 * Enregistre sur disque dans le fichier XML pFile 
	 * l'Entity JAXB pContactsEntityJAXB.<br/>
	 * <ul>
	 * <li>Crée pFile sur disque si il n'existe pas.</li>
	 * <li>Remplace pFile si il existe déjà.</li>
	 * <li>ne fait rien si pContactsEntityJAXB == null.</li>
	 * <li>ne fait rien si pFile == null.</li>
	 * </ul>
	 *
	 * @param pListeContactSimplesEntityJAXB : ListeContactSimplesEntityJAXB.<br/>
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @throws JAXBException
	 */
	private void enregistrer(
			final ListeContactSimplesEntityJAXB pListeContactSimplesEntityJAXB
				, final File pFile) throws JAXBException {
		
		/* ne fait rien si pContactsEntityJAXB == null. */
		if (pListeContactSimplesEntityJAXB == null) {
			return;
		}
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
		
		/* Ecriture sur disque dur sous forme de fichier XML. */
		this.marshaller.marshal(pListeContactSimplesEntityJAXB, pFile);
		
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
	 * @throws JAXBException
	 */
	public void ecrireContactsConsole(
			final List<IContactSimple> pList) throws JAXBException {
		
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
	 * @throws JAXBException 
	 */
	private void ecrireContactsConsole(
			final ListeContactSimplesEntityJAXB pListeContactSimplesEntityJAXB) 
					throws JAXBException {
		
		/* ne fait rien si pContactsEntityJAXB == null. */
		if (pListeContactSimplesEntityJAXB == null) {
			return;
		}
		
		/* Ecriture dans la console sous forme de fichier XML. */
		this.marshaller.marshal(pListeContactSimplesEntityJAXB, System.out);
		
	} // Fin de ecrireContactsConsole(...).________________________________
	
	
	
	/**
	 * method recupererListeModeles(
	 * File pFile) :<br/>
	 * Récupére la liste des MODEL dans le fichier XML 
	 * correspondant à une Entity JAXB.<br/>
	 * <br/>
	 *
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @return List&lt;IContactSimple&gt;.<br/>
	 * 
	 * @throws FileNotFoundException
	 * @throws JAXBException :  :  .<br/>
	 */
	public List<IContactSimple> recupererListeModeles(
			final File pFile) 
					throws FileNotFoundException, JAXBException {
		
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
	 * Récupère une Entity JAXB à partir du fichier XML pFile.<br/>
	 * <ul>
	 * <li>return null si pFile == null.</li>
	 * <li>return null si pFile n'existe pas.</li>
	 * <li>return null si pFile n'est pas un fichier simple.</li>
	 * </ul>
	 *
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @return ListeContactSimplesEntityJAXB : 
	 * Entity JAXB modélisant le contenu du fichier XML pFile.<br/>
	 * 
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 */
	public ListeContactSimplesEntityJAXB recupererEntites(
			final File pFile) 
					throws FileNotFoundException, JAXBException {
		
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
		
		final FileReader fileReader = new FileReader(pFile);
		
		final ListeContactSimplesEntityJAXB resultat 
			= (ListeContactSimplesEntityJAXB) this.unmarshaller.unmarshal(fileReader);
		
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
	 * method afficherListeContactSimple(
	 * List&lt;IContactSimple&gt; pList) :<br/>
	 * fournit une String pour l'affichage à la console 
	 * d'une Liste de IContactSimple.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListeContactSimple(
			final List<IContactSimple> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final IContactSimple contactSimple : pList) {
			
			stb.append(contactSimple.toString());
			stb.append(SAUT_LIGNE_JAVA);
			
		}
		
		return stb.toString();
		
	} // Fin de afficherListeContactSimple(...).________________________________
	
	
	
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
			stb.append(SAUT_LIGNE_JAVA);
			
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
