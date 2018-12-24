package levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;
import levy.daniel.application.model.metier.contactsimple.IContactSimple;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IContactSimpleModelObs;
import levy.daniel.application.vues.desktop.metier.contactsimple.modelobs.IListeContactSimplesModelObs;


/**
 * CLASSE ListeContactSimplesModelObs :<br/>
 * CONTROLLER chargé de la gestion des listes de ContactSimple.<br/>
 * <ul>
 * <li></li>
 * <li></li>
 * <li></li>
 * <li></li>
 * </ul>
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
 * @since 9 mai 2018
 *
 */
public class ListeContactSimplesModelObs implements IListeContactSimplesModelObs {

	// ************************ATTRIBUTS************************************/

	/**
	 * accueilController : IAccueilController :<br/>
	 * IAccueilController "Maître de Cérémonie" chargé 
	 * de mettre à disposition du présent CONTROLLER 
	 * toutes les vues, controllers et services de l'application.<br/>
	 */
	private IAccueilController accueilController;
	
	/**
	 * contactSimpleAnchorPane : AnchorPane :<br/>
	 * panneau AnchorPane (VUE) modélisant une contactSimple.<br/>
	 */
	private AnchorPane contactSimpleAnchorPane;
		
	/**
	 * listeContactSimples : ObservableList<IContactSimpleModelObs> :<br/>
	 * liste des ContactSimpleModelObs.<br/>
	 */
	private ObservableList<IContactSimpleModelObs> listeContactSimples;
	

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ListeContactSimplesModelObs.class);

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR ListeContactSimplesModelObs() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ListeContactSimplesModelObs() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ListeContactSimplesModelObs(
	 * AnchorPane pAnchorPane
	 * , IAccueilController pAccueilController
	 * , ObservableList&lt;IContactSimpleModelObs&gt; pList) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pAnchorPane : AnchorPane.<br/>
	 * @param pAccueilController : IAccueilController.<br/>
	 * @param pList : ObservableList&lt;IContactSimpleModelObs&gt;.<br/>
	 */
	public ListeContactSimplesModelObs(
			final AnchorPane pAnchorPane
				, final IAccueilController pAccueilController
					, final ObservableList<IContactSimpleModelObs> pList) {
		
		super();
		
		this.contactSimpleAnchorPane = pAnchorPane;
		this.accueilController = pAccueilController;
		this.listeContactSimples = pList;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterContactSimpleAList(
			final IContactSimple pContactSimple) {
		
		return this.ajouterContactSimpleAList(pContactSimple, this.listeContactSimples);
		
	} // Fin de ajouterContactSimpleAList(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterContactSimpleAList(
			final IContactSimple pContactSimple
				, final ObservableList<IContactSimpleModelObs> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
		
		if (pContactSimple != null) {
			
			/* instancie le IContactSimpleModelObs associé au IContactSimple. */
			final IContactSimpleModelObs contactSimpleModelObs 
				= new ContactSimpleModelObs(pContactSimple);
			
			return pList.add(contactSimpleModelObs);
		}
		
		/* retourne false si pContactSimple == null.*/
		return false;
		
	} // Fin de ajouterContactSimpleAList(...)._________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterContactSimpleControllerAList(
			final IContactSimpleModelObs pContactSimple) {
		
		return this.ajouterContactSimpleControllerAList(
				pContactSimple, this.listeContactSimples);
		
	} // Fin de ajouterContactSimpleControllerAList(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterContactSimpleControllerAList(
			final IContactSimpleModelObs pContactSimple
				, final ObservableList<IContactSimpleModelObs> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
				
		if (pContactSimple != null) {			
			return pList.add(pContactSimple);
		}
		
		/* retourne false si pContactSimple == null.*/
		return false;
		
	} // Fin de ajouterContactSimpleControllerAList(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterListeContactSimplesAList(
			final List<IContactSimple> pListAAjouter) {
		
		return this.ajouterListeContactSimplesAList(
				pListAAjouter, this.listeContactSimples);
		
	} // Fin de ajouterListeContactSimplesAList(...).__________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterListeContactSimplesAList(
			final List<IContactSimple> pListAAjouter
				, final ObservableList<IContactSimpleModelObs> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
		
		/* retourne false si pListAAjouter == null. */
		if (pListAAjouter == null) {
			return false;
		}
		
		boolean resultat = true;
		
		for (final IContactSimple contactSimple : pListAAjouter) {
			
			if (contactSimple != null) {
				
				final IContactSimpleModelObs contactSimpleModelObs 
				= new ContactSimpleModelObs(contactSimple);
				
				resultat = pList.add(contactSimpleModelObs);
				
				if (!resultat) {
					return false;
				}
			}
			
		}
		
		return resultat;
		
	} // Fin de ajouterListeContactSimplesAList(...).___________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterListeContactSimpleControllersAList(
			final List<IContactSimpleModelObs> pListAAjouter) {
		
		return this.ajouterListeContactSimpleControllersAList(
				pListAAjouter, this.listeContactSimples);
		
	} // Fin de ajouterListeContactSimpleControllersAList(...)._________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterListeContactSimpleControllersAList(
			final List<IContactSimpleModelObs> pListAAjouter
				, final ObservableList<IContactSimpleModelObs> pList) {
				
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
		
		/* retourne false si pListAAjouter == null. */
		if (pListAAjouter == null) {
			return false;
		}

		return pList.addAll(pListAAjouter);
		
	} // Fin de ajouterListeContactSimpleControllersAList(...)._________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerContactSimpleAList(
			final IContactSimple pContactSimple) {
		
		return this.retirerContactSimpleAList(pContactSimple, this.listeContactSimples);
		
	} // Fin de retirerContactSimpleAList(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerContactSimpleAList(
			final IContactSimple pContactSimple
				, final ObservableList<IContactSimpleModelObs> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
		
		if (pContactSimple != null) {
			
			/* instancie le IContactSimpleModelObs associé au IContactSimple. */
			final IContactSimpleModelObs contactSimpleModelObs 
				= new ContactSimpleModelObs(pContactSimple);
			
			return pList.remove(contactSimpleModelObs);
		}
		
		/* retourne false si pContactSimple == null.*/
		return false;
		
	} // Fin de retirerContactSimpleAList(...)._________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerContactSimpleControllerAList(
			final IContactSimpleModelObs pContactSimple) {
		
		return this.retirerContactSimpleControllerAList(
				pContactSimple, this.listeContactSimples);
		
	} // Fin de retirerContactSimpleControllerAList(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerContactSimpleControllerAList(
			final IContactSimpleModelObs pContactSimple
				, final ObservableList<IContactSimpleModelObs> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
				
		if (pContactSimple != null) {			
			return pList.remove(pContactSimple);
		}
		
		/* retourne false si pContactSimple == null.*/
		return false;
		
	} // Fin de retirerContactSimpleControllerAList(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerListeContactSimplesAList(
			final List<IContactSimple> pListAretirer) {
		
		return this.retirerListeContactSimplesAList(
				pListAretirer, this.listeContactSimples);
		
	} // Fin de retirerListeContactSimplesAList(...).__________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerListeContactSimplesAList(
			final List<IContactSimple> pListAretirer
				, final ObservableList<IContactSimpleModelObs> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
		
		/* retourne false si pListAretirer == null. */
		if (pListAretirer == null) {
			return false;
		}
		
		boolean resultat = true;
		
		for (final IContactSimple contactSimple : pListAretirer) {
			
			if (contactSimple != null) {
				
				final IContactSimpleModelObs contactSimpleModelObs 
				= new ContactSimpleModelObs(contactSimple);
				
				resultat = pList.remove(contactSimpleModelObs);
				
				if (!resultat) {
					return false;
				}
			}
			
		}
		
		return resultat;
		
	} // Fin de retirerListeContactSimplesAList(...).___________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerListeContactSimpleControllersAList(
			final List<IContactSimpleModelObs> pListAretirer) {
		
		return this.retirerListeContactSimpleControllersAList(
				pListAretirer, this.listeContactSimples);
		
	} // Fin de retirerListeContactSimpleControllersAList(...)._________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerListeContactSimpleControllersAList(
			final List<IContactSimpleModelObs> pListAretirer
				, final ObservableList<IContactSimpleModelObs> pList) {
				
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
		
		/* retourne false si pListAretirer == null. */
		if (pListAretirer == null) {
			return false;
		}

		return pList.removeAll(pListAretirer);
		
	} // Fin de retirerListeContactSimpleControllersAList(...)._________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int count() {
		return this.count(this.listeContactSimples);
	} // Fin de count().___________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int count(
			final ObservableList<IContactSimpleModelObs> pList) {
		
		if (pList != null) {
			return pList.size();
		}
		
		/* retourne 0 si pLIst == null. */
		return 0;
	} // Fin de count(...).________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherListe() {
		return this.afficherListe(this.listeContactSimples);
	} // Fin de afficherListe().___________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherListe(
			final ObservableList<IContactSimpleModelObs> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final int taille = pList.size();
		
		int compteur = 0;
		
		final StringBuffer stb = new StringBuffer();
		
		for (final IContactSimpleModelObs contactSimple : pList) {
			
			compteur++;
			
			if (contactSimple != null) {
				stb.append(contactSimple.toString());
			}
			
			if (compteur < taille) {
				stb.append(SAUT_LIGNE_JAVA);
			}
		}
		
		return stb.toString();
		
	} // Fin de afficherListe(...).________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IAccueilController getAccueilController() {	
		return this.accueilController;
	} // Fin de getAccueilController().____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setAccueilController(
			final IAccueilController pAccueilController) {	
		this.accueilController = pAccueilController;
	} // Fin de setAccueilController(...)._________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final AnchorPane getContactSimpleAnchorPane() {	
		return this.contactSimpleAnchorPane;
	} // Fin de getContactSimpleAnchorPane().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setContactSimpleAnchorPane(
			final AnchorPane pContactSimpleAnchorPane) {	
		this.contactSimpleAnchorPane = pContactSimpleAnchorPane;
	} // Fin de setContactSimpleAnchorPane(...).________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ObservableList<IContactSimpleModelObs> getListeContactSimples() {	
		return this.listeContactSimples;
	} // Fin de getListeContactSimples()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setListeContactSimples(
			final ObservableList<IContactSimpleModelObs> pListeContactSimples) {	
		this.listeContactSimples = pListeContactSimples;
	} // Fin de setListeContactSimples(...).____________________________________
	
	

} // FIN DE LA CLASSE ListeContactSimplesModelObs.------------------------------
