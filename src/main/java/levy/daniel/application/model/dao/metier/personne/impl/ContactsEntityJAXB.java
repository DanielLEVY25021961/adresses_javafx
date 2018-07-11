package levy.daniel.application.model.dao.metier.personne.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.IConstantesApplicatives;
import levy.daniel.application.model.metier.personne.IPersonne;


/**
 * CLASSE ContactsEntityJAXB :<br/>
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
 * @since 24 mai 2018
 *
 */
@XmlRootElement(namespace = IConstantesApplicatives.NAMESPACE)
public class ContactsEntityJAXB {

	// ************************ATTRIBUTS************************************/

	// XmLElementWrapper generates a wrapper element around XML representation
    
    
	/**
	 * listePersonnes : List&lt;PersonneEntityJAXB&gt; :<br/>
	 * Liste de PersonneEntityJAXB (contacts).<br/>
	 */
	private List<PersonneEntityJAXB> listePersonnes;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ContactsEntityJAXB.class);

	// *************************METHODES************************************/

		
	 /**
	 * method CONSTRUCTEUR ContactsEntityJAXB() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ContactsEntityJAXB() {
		this(null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ContactsEntityJAXB(
	 * List&lt;PersonneEntityJAXB&gt; pListePersonnes) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pListePersonnes : List&lt;PersonneEntityJAXB&gt;.<br/> 
	 */
	public ContactsEntityJAXB(
			final List<PersonneEntityJAXB> pListePersonnes) {
		
		super();
		
		this.listePersonnes = pListePersonnes;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	/**
	 * method convertirListModelEnEntities(
	 * List&lt;IPersonne&gt; pList) :<br/>
	 * convertit une Liste de Personne en liste 
	 * de PersonneEntityJAXB.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IPersonne&gt;
	 * 
	 * @return : List&lt;PersonneEntityJAXB&gt;.<br/>
	 */
	private List<PersonneEntityJAXB> convertirListModelEnEntities(
			final List<IPersonne> pList) {
		
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
	 * method getListePersonnes() :<br/>
	 * Getter de la Liste de PersonneEntityJAXB (contacts).<br/>
	 * <br/>
	 *
	 * @return this.listePersonnes : List&lt;PersonneEntityJAXB&gt;.<br/>
	 */
	@XmlElementWrapper(name = "contacts")
    @XmlElement(name = "personne")
	public List<PersonneEntityJAXB> getListePersonnes() {
		return this.listePersonnes;
	} // Fin de getListePersonnes()._______________________________________
	

	
	/**
	* method setListePersonnes(
	* List&lt;PersonneEntityJAXB&gt; pListePersonnes) :<br/>
	* Getter de la Liste de PersonneEntityJAXB (contacts).<br/>
	* <br/>
	*
	* @param pListePersonnes : List&lt;PersonneEntityJAXB&gt; : 
	* valeur à passer à listePersonnes.<br/>
	*/
	public void setListePersonnes(
			final List<PersonneEntityJAXB> pListePersonnes) {
		this.listePersonnes = pListePersonnes;
	} // Fin de setListePersonnes(...).____________________________________


	
} // FIN DE LA CLASSE ContactsEntityJAXB.------------------------------------
