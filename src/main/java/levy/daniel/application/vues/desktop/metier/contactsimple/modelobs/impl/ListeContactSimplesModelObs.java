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
	 * personneAnchorPane : AnchorPane :<br/>
	 * panneau AnchorPane (VUE) modélisant une personne.<br/>
	 */
	private AnchorPane personneAnchorPane;
		
	/**
	 * listePersonnes : ObservableList<IContactSimpleModelObs> :<br/>
	 * liste des ContactSimpleModelObs.<br/>
	 */
	private ObservableList<IContactSimpleModelObs> listePersonnes;
	

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
		
		this.personneAnchorPane = pAnchorPane;
		this.accueilController = pAccueilController;
		this.listePersonnes = pList;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterPersonneAList(
			final IContactSimple pContactSimple) {
		
		return this.ajouterPersonneAList(pContactSimple, this.listePersonnes);
		
	} // Fin de ajouterPersonneAList(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterPersonneAList(
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
		
		/* retourne false si pPersonne == null.*/
		return false;
		
	} // Fin de ajouterPersonneAList(...)._________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterPersonneControllerAList(
			final IContactSimpleModelObs pPersonne) {
		
		return this.ajouterPersonneControllerAList(
				pPersonne, this.listePersonnes);
		
	} // Fin de ajouterPersonneControllerAList(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterPersonneControllerAList(
			final IContactSimpleModelObs pPersonne
				, final ObservableList<IContactSimpleModelObs> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
				
		if (pPersonne != null) {			
			return pList.add(pPersonne);
		}
		
		/* retourne false si pPersonne == null.*/
		return false;
		
	} // Fin de ajouterPersonneControllerAList(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterListePersonnesAList(
			final List<IContactSimple> pListAAjouter) {
		
		return this.ajouterListePersonnesAList(
				pListAAjouter, this.listePersonnes);
		
	} // Fin de ajouterListePersonnesAList(...).__________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterListePersonnesAList(
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
		
	} // Fin de ajouterListePersonnesAList(...).___________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterListePersonneControllersAList(
			final List<IContactSimpleModelObs> pListAAjouter) {
		
		return this.ajouterListePersonneControllersAList(
				pListAAjouter, this.listePersonnes);
		
	} // Fin de ajouterListePersonneControllersAList(...)._________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterListePersonneControllersAList(
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
		
	} // Fin de ajouterListePersonneControllersAList(...)._________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerPersonneAList(
			final IContactSimple pContactSimple) {
		
		return this.retirerPersonneAList(pContactSimple, this.listePersonnes);
		
	} // Fin de retirerPersonneAList(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerPersonneAList(
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
		
		/* retourne false si pPersonne == null.*/
		return false;
		
	} // Fin de retirerPersonneAList(...)._________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerPersonneControllerAList(
			final IContactSimpleModelObs pPersonne) {
		
		return this.retirerPersonneControllerAList(
				pPersonne, this.listePersonnes);
		
	} // Fin de retirerPersonneControllerAList(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerPersonneControllerAList(
			final IContactSimpleModelObs pPersonne
				, final ObservableList<IContactSimpleModelObs> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
				
		if (pPersonne != null) {			
			return pList.remove(pPersonne);
		}
		
		/* retourne false si pPersonne == null.*/
		return false;
		
	} // Fin de retirerPersonneControllerAList(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerListePersonnesAList(
			final List<IContactSimple> pListAretirer) {
		
		return this.retirerListePersonnesAList(
				pListAretirer, this.listePersonnes);
		
	} // Fin de retirerListePersonnesAList(...).__________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerListePersonnesAList(
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
		
	} // Fin de retirerListePersonnesAList(...).___________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerListePersonneControllersAList(
			final List<IContactSimpleModelObs> pListAretirer) {
		
		return this.retirerListePersonneControllersAList(
				pListAretirer, this.listePersonnes);
		
	} // Fin de retirerListePersonneControllersAList(...)._________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerListePersonneControllersAList(
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
		
	} // Fin de retirerListePersonneControllersAList(...)._________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int count() {
		return this.count(this.listePersonnes);
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
		return this.afficherListe(this.listePersonnes);
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
		
		for (final IContactSimpleModelObs personne : pList) {
			
			compteur++;
			
			if (personne != null) {
				stb.append(personne.toString());
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
	public final AnchorPane getPersonneAnchorPane() {	
		return this.personneAnchorPane;
	} // Fin de getPersonneAnchorPane().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setPersonneAnchorPane(
			final AnchorPane pPersonneAnchorPane) {	
		this.personneAnchorPane = pPersonneAnchorPane;
	} // Fin de setPersonneAnchorPane(...).________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ObservableList<IContactSimpleModelObs> getListePersonnes() {	
		return this.listePersonnes;
	} // Fin de getListePersonnes()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setListePersonnes(
			final ObservableList<IContactSimpleModelObs> pListePersonnes) {	
		this.listePersonnes = pListePersonnes;
	} // Fin de setListePersonnes(...).____________________________________
	
	

} // FIN DE LA CLASSE ListeContactSimplesModelObs.------------------------------
