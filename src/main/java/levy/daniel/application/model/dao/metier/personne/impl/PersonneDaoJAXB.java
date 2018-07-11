package levy.daniel.application.model.dao.metier.personne.impl;

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

import levy.daniel.application.model.metier.personne.IPersonne;
import levy.daniel.application.model.metier.personne.impl.Personne;


/**
 * CLASSE PersonneDaoJAXB :<br/>
 * DAO JAXB pour les Personne.<br/>
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
public class PersonneDaoJAXB {

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
	private static final Log LOG = LogFactory.getLog(PersonneDaoJAXB.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR PersonneDaoJAXB() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 * @throws JAXBException 
	 */
	public PersonneDaoJAXB() throws JAXBException {
		this(null);		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

		
	 /**
	 * method CONSTRUCTEUR PersonneDaoJAXB(
	 * File pFile) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pFile : java.io.File : 
	 * le fichier XML dans lequel écrire les entities JAXB.<br/>
	 * 
	 * @throws JAXBException
	 */
	public PersonneDaoJAXB(
			final File pFile) throws JAXBException {
		
		super();
		
		this.fichierXML = pFile;
		
		this.instancierContextJAXB();
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	/**
	 * method instancierContext() :<br/>
	 * Instancie le context JAXB et les Marshaller et Unmarshaller.<br/>
	 * <ul>
	 * <li>instancie le context pour l'Entity ContactsEntityJAXB. </li>
	 * <li>Instancie le Marshaller (Objet vers XML).</li>
	 * <li>Paramètre le Marshaller (Objet vers XML).</li>
	 * <li>Instancie le Unmarshaller (XML vers Objet).</li>
	 * </ul>
	 * 
	 * @throws JAXBException 
	 */
	private void instancierContextJAXB() throws JAXBException {
		
		/* instancie le context pour l'Entity ContactsEntityJAXB. */
		this.context 
			= JAXBContext.newInstance(ContactsEntityJAXB.class);
		
		/* Instancie le Marshaller (Objet vers XML). */
		this.marshaller = this.context.createMarshaller();
		
		/* Paramètre le Marshaller (Objet vers XML). */
		this.marshaller.setProperty(
				Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		/* Instancie le Unmarshaller (XML vers Objet). */
		this.unmarshaller = this.context.createUnmarshaller();
		
	} // Fin de instancierContextJAXB().___________________________________
	
	
	
	/**
	 * method creerPersonne(
	 * PersonneEntityJAXB pPersonne) :<br/>
	 * Crée une Personne à partir d'une PersonneEntityJAXB.<br/>
	 * <br/>
	 * retourne null si pPersonne == null.<br/>
	 * <br/>
	 *
	 * @param pPersonne : PersonneEntityJAXB.<br/>
	 * 
	 * @return : IPersonne.<br/>
	 */
	private IPersonne creerPersonne(
			final PersonneEntityJAXB pPersonne) {
		
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
	 * List&lt;IPersonne&gt; pList) :<br/>
	 * convertit une Liste de Personne (MODEL) en liste 
	 * de PersonneEntityJAXB (Entities JAXB).<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IPersonne&gt;
	 * 
	 * @return : List&lt;PersonneEntityJAXB&gt;.<br/>
	 */
	private List<PersonneEntityJAXB> convertirListModelEnEntities(
			final List<IPersonne> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<PersonneEntityJAXB> resultat 
			= new ArrayList<PersonneEntityJAXB>();
		
		for (final IPersonne personne : pList) {
			
			if (personne != null) {
				
				final PersonneEntityJAXB personneJAXB 
					= new PersonneEntityJAXB(personne);
				
				resultat.add(personneJAXB);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________
	

		
	/**
	 * method convertirListEntitiesEnModel(
	 * List&lt;PersonneEntityJAXB&gt; pList) :<br/>
	 * convertit une Liste de PersonneEntityJAXB (Entities JAXB) 
	 * en liste de Personne (MODEL).<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;PersonneEntityJAXB&gt;.<br/>
	 * 
	 * @return : List&lt;IPersonne&gt;.<br/>
	 */
	private List<IPersonne> convertirListEntitiesEnModel(
			final List<PersonneEntityJAXB> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<IPersonne> resultat 
			= new ArrayList<IPersonne>();
		
		for (final PersonneEntityJAXB personne : pList) {
			
			if (personne != null) {
				
				final IPersonne personneModel 
					= this.creerPersonne(personne);
				
				resultat.add(personneModel);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListEntitiesEnModel(...)._________________________
	
	
	
	/**
	 * Instancie une Entity JAXB ContactsEntityJAXB à partir 
	 * d'une Liste de MODEL List&lt;IPersonne&gt; pList.<br/>
	 * <ul>
	 * <li>retourne null si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IPersonne&gt; : Liste de MODEL 
	 * à transformer en Entities JAXB en vue de la sérialization.<br/>
	 * 
	 * @return : ContactsEntityJAXB : Entity serializable 
	 * sous forme de fichier XML.<br/>
	 */
	private ContactsEntityJAXB creerEntityJAXB(
			final List<IPersonne> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<PersonneEntityJAXB> liste 
			= this.convertirListModelEnEntities(pList);
	
		final ContactsEntityJAXB contacts 
			= new ContactsEntityJAXB(liste);
		
		return contacts;
		
	} // Fin de creerEntityJAXB(...).______________________________________


	
	/**
	 * Crée la Personne pObject dans un fichier XML pFile.<br/>
	 * <ul>
	 * <li>retourne null si pObject == null.</li>
	 * <li>retourne null si pFile == null.</li>
	 * </ul>
	 *
	 * @param pObject : IPersonne.<br/>
	 * @param pFile : java.io.File : 
	 * le fichier XML dans lequel écrire les entities JAXB.<br/>
	 *  
	 * @return : IPersonne : le MODEL stocké dans le fichier.<br/>
	 * 
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public IPersonne create(
			final IPersonne pObject
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
		
		List<IPersonne> contacts = null;
		
		if (pFile.exists()) {
			contacts = this.recupererListeModeles(pFile);
		} else {
			contacts = new ArrayList<IPersonne>();
		}
		  		
		if (contacts != null) {
			
			/* ajout de la personne à la liste. */
			contacts.add(pObject);
			
			/* enregistrement de la nouvelle liste. */
			this.enregistrer(contacts, pFile);
			
			return pObject;
		} 
			
		return null;
				
	} // Fin de create(...)._______________________________________________


	
	/**
	 * Enregistre sur disque dans le fichier XML pFile 
	 * la liste de MODEL List&lt;IPersonne&gt; pList.<br/>
	 * <ul>
	 * <li>Crée pFile sur disque si il n'existe pas.</li>
	 * <li>Remplace pFile si il existe déjà.</li>
	 * <li>ne fait rien si pList == null.</li>
	 * <li>ne fait rien si pFile == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IPersonne&gt;.<br/>
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @throws JAXBException
	 */
	public void enregistrer(
			final List<IPersonne> pList
				, final File pFile) throws JAXBException {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
		
		final ContactsEntityJAXB contacts = this.creerEntityJAXB(pList);
		
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
	 * @param pContactsEntityJAXB : ContactsEntityJAXB.<br/>
	 * @param pFile : java.io.File.<br/>
	 * 
	 * @throws JAXBException
	 */
	private void enregistrer(
			final ContactsEntityJAXB pContactsEntityJAXB
				, final File pFile) throws JAXBException {
		
		/* ne fait rien si pContactsEntityJAXB == null. */
		if (pContactsEntityJAXB == null) {
			return;
		}
		
		/* ne fait rien si pFile == null. */
		if (pFile == null) {
			return;
		}
		
		/* Ecriture sur disque dur sous forme de fichier XML. */
		this.marshaller.marshal(pContactsEntityJAXB, pFile);
		
	} // Fin de enregistrer(...).__________________________________________
	


	/**
	 * Affiche à la console la liste de MODEL 
	 * List&lt;IPersonne&gt; pList sous forme de fichier XML.<br/>
	 * <ul>
	 * <li>ne fait rien si pList == null.</li>
	 * </ul>
	 *
	 * @param pList : List&lt;IPersonne&gt;
	 * 
	 * @throws JAXBException
	 */
	public void ecrireContactsConsole(
			final List<IPersonne> pList) throws JAXBException {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}
		
		final List<PersonneEntityJAXB> contactsPersonneJAXB 
			= this.convertirListModelEnEntities(pList);
		
		final ContactsEntityJAXB contactsJAXB 
			= new ContactsEntityJAXB(contactsPersonneJAXB);
		
		this.ecrireContactsConsole(contactsJAXB);
		
	} // Fin de ecrireContactsConsole(...).________________________________
	

	
	/**
	 * method ecrireContactsConsole(
	 * ContactsEntityJAXB pContactsEntityJAXB) :<br/>
	 * Affiche à la console l'Entity JAXB pContactsEntityJAXB 
	 * sous forme de fichier XML.<br/>
	 * <ul>
	 * <li>ne fait rien si pContactsEntityJAXB == null.</li>
	 * </ul>
	 *
	 * @param pContactsEntityJAXB : ContactsEntityJAXB.<br/>
	 * 
	 * @throws JAXBException 
	 */
	private void ecrireContactsConsole(
			final ContactsEntityJAXB pContactsEntityJAXB) 
					throws JAXBException {
		
		/* ne fait rien si pContactsEntityJAXB == null. */
		if (pContactsEntityJAXB == null) {
			return;
		}
		
		/* Ecriture dans la console sous forme de fichier XML. */
		this.marshaller.marshal(pContactsEntityJAXB, System.out);
		
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
	 * @return List&lt;IPersonne&gt;.<br/>
	 * 
	 * @throws FileNotFoundException
	 * @throws JAXBException :  :  .<br/>
	 */
	public List<IPersonne> recupererListeModeles(
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
		
		final ContactsEntityJAXB contacts 
			= this.recupererEntites(pFile);
		
		final List<PersonneEntityJAXB> listeEntities 
			= contacts.getListePersonnes();
		
		final List<IPersonne> resultat 
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
	 * @return ContactsEntityJAXB : 
	 * Entity JAXB modélisant le contenu du fichier XML pFile.<br/>
	 * 
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 */
	public ContactsEntityJAXB recupererEntites(
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
		
		final ContactsEntityJAXB resultat 
			= (ContactsEntityJAXB) this.unmarshaller.unmarshal(fileReader);
		
		return resultat;
		
	} // Fin de recupererEntites(...)._____________________________________
	

	
	/**
	 * fournit une String pour l'affichage à la console 
	 * d'une liste de Personne contenue dans une Entity JAXB 
	 * pContacts.<br/>
	 * <ul>
	 * <li>retourne null si pContacts == null.</li>
	 * </ul>
	 *
	 * @param pContacts : ContactsEntityJAXB.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListePersonneDansContacts(
			final ContactsEntityJAXB pContacts) {
		
		/* retourne null si pContacts == null. */
		if (pContacts == null) {
			return null;
		}
		
		final List<PersonneEntityJAXB> listeEntities 
			= pContacts.getListePersonnes();
		
		return this.afficherListePersonneJAXB(listeEntities);
		
	} // Fin de afficherListePersonneDansContacts(...).____________________
	
	
	
	/**
	 * method afficherListePersonne(
	 * List&lt;IPersonne&gt; pList) :<br/>
	 * fournit une String pour l'affichage à la console 
	 * d'une Liste de IPersonne.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IPersonne&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListePersonne(
			final List<IPersonne> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final IPersonne personne : pList) {
			
			stb.append(personne.toString());
			stb.append(SAUT_LIGNE_JAVA);
			
		}
		
		return stb.toString();
		
	} // Fin de afficherListePersonne(...).________________________________
	
	
	
	/**
	 * method afficherListePersonneJAXB(
	 * List&lt;PersonneEntityJAXB&gt; pList) :<br/>
	 * fournit une String pour l'affichage à la console 
	 * d'une Liste de PersonneEntityJAXB.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;PersonneEntityJAXB&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListePersonneJAXB(
			final List<PersonneEntityJAXB> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final PersonneEntityJAXB personne : pList) {
			
			stb.append(personne.toString());
			stb.append(SAUT_LIGNE_JAVA);
			
		}
		
		return stb.toString();		

	} // Fin de afficherListePersonneJAXB(...).____________________________



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
	
		
	
} // FIN DE LA CLASSE PersonneDaoJAXB.---------------------------------------
