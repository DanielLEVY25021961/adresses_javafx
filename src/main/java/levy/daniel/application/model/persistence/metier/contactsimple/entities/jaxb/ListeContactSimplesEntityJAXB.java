package levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.IConstantesApplicatives;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.model.persistence.metier.contactsimple.ContactSimpleConvertisseurMetierEntity;


/**
 * CLASSE ListeContactSimplesEntityJAXB :<br/>
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
public class ListeContactSimplesEntityJAXB {

	// ************************ATTRIBUTS************************************/

	// XmLElementWrapper generates a wrapper element around XML representation
    
    
	/**
	 * Liste de ContactSimpleEntityJAXB (contacts).<br/>
	 */
	private List<ContactSimpleEntityJAXB> listeContactSimples;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ListeContactSimplesEntityJAXB.class);

	// *************************METHODES************************************/

		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public ListeContactSimplesEntityJAXB() {
		this(null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.
	 *
	 * @param pListeContactSimples : 
	 * List&lt;ContactSimpleEntityJAXB&gt;.<br/> 
	 */
	public ListeContactSimplesEntityJAXB(
			final List<ContactSimpleEntityJAXB> pListeContactSimples) {
		
		super();
		
		this.listeContactSimples = pListeContactSimples;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	/**
	 * <b>convertit une Liste d' OBJETS METIER (ContactSimple) en liste 
	 * d' ENTITY JAXB (ContactSimpleEntityJAXB)</b>.<br/>
	 *
	 * @param pList : List&lt;IContactSimple&gt;
	 * 
	 * @return : List&lt;ContactSimpleEntityJAXB&gt;.<br/>
	 */
	private List<ContactSimpleEntityJAXB> convertirListModelEnEntities(
			final List<IContactSimple> pList) {
		
		if (pList == null) {
			return null;
		}
		
		final List<ContactSimpleEntityJAXB> resultat 
			= new ArrayList<ContactSimpleEntityJAXB>();
		
		for (final IContactSimple objet : pList) {
			
			if (objet != null) {
				
				final ContactSimpleEntityJAXB entityJAXB 
					= ContactSimpleConvertisseurMetierEntity
						.creerEntityJAXBAPartirObjetMetier(objet);
				
				resultat.add(entityJAXB);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________
	

	
	/**
	 * Getter de la Liste de ContactSimpleEntityJAXB (contacts).<br/>
	 *
	 * @return this.listeContactSimples : 
	 * List&lt;ContactSimpleEntityJAXB&gt;.<br/>
	 */
	@XmlElementWrapper(name = "listeContactSimples")
    @XmlElement(name = "contactSimple")
	public List<ContactSimpleEntityJAXB> getListeContactSimples() {
		return this.listeContactSimples;
	} // Fin de getListeContactSimples().__________________________________
	

	
	/**
	* Setter de la Liste de ContactSimpleEntityJAXB (contacts).<br/>
	*
	* @param pListeContactSimples : List&lt;ContactSimpleEntityJAXB&gt; : 
	* valeur à passer à listeContactSimples.<br/>
	*/
	public void setListeContactSimples(
			final List<ContactSimpleEntityJAXB> pListeContactSimples) {
		this.listeContactSimples = pListeContactSimples;
	} // Fin de setListeContactSimples(...)._______________________________


	
} // FIN DE LA CLASSE ListeContactSimplesEntityJAXB.-------------------------
