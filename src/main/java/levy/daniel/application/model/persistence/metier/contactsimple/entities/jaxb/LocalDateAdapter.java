package levy.daniel.application.model.persistence.metier.contactsimple.entities.jaxb;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE LocalDateAdapter :<br/>
 * Adapter pour permettre à JAXB de lire et écrire les LocalDate.<br/>
 * <b>utilisé par l'ENTITY JAXB</b>.
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 25 mai 2018
 *
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(LocalDateAdapter.class);

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR LocalDateAdapter() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public LocalDateAdapter() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String marshal(
			final LocalDate pDate) {
		
		if (pDate == null) {
			return null;
		}
			
		return pDate.toString();
	} // Fin de marshal(...).______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocalDate unmarshal(
			final String string) {
		return LocalDate.parse(string);
	} // Fin de unmarshal(...).____________________________________________
	
	
	
} // FIN DE LA CLASSE CLASSE LocalDateAdapter.-------------------------------
