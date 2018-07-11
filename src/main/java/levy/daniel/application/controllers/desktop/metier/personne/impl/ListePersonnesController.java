package levy.daniel.application.controllers.desktop.metier.personne.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import levy.daniel.application.controllers.desktop.accueil.IAccueilController;
import levy.daniel.application.controllers.desktop.metier.personne.IListePersonnesController;
import levy.daniel.application.controllers.desktop.metier.personne.IPersonneController;
import levy.daniel.application.model.metier.personne.IPersonne;


/**
 * CLASSE ListePersonnesController :<br/>
 * CONTROLLER chargé de la gestion des listes de Personne.<br/>
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
public class ListePersonnesController implements IListePersonnesController {

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
	 * listePersonnes : ObservableList<IPersonneController> :<br/>
	 * liste des PersonneController.<br/>
	 */
	private ObservableList<IPersonneController> listePersonnes;
	

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ListePersonnesController.class);

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR ListePersonnesController() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ListePersonnesController() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ListePersonnesController(
	 * AnchorPane pAnchorPane
	 * , IAccueilController pAccueilController
	 * , ObservableList&lt;IPersonneController&gt; pList) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pAnchorPane : AnchorPane.<br/>
	 * @param pAccueilController : IAccueilController.<br/>
	 * @param pList : ObservableList&lt;IPersonneController&gt;.<br/>
	 */
	public ListePersonnesController(
			final AnchorPane pAnchorPane
				, final IAccueilController pAccueilController
					, final ObservableList<IPersonneController> pList) {
		
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
			final IPersonne pPersonne) {
		
		return this.ajouterPersonneAList(pPersonne, this.listePersonnes);
		
	} // Fin de ajouterPersonneAList(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterPersonneAList(
			final IPersonne pPersonne
				, final ObservableList<IPersonneController> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
		
		if (pPersonne != null) {
			
			/* instancie le IPersonneController associé au IPersonne. */
			final IPersonneController personneController 
				= new PersonneController(pPersonne);
			
			return pList.add(personneController);
		}
		
		/* retourne false si pPersonne == null.*/
		return false;
		
	} // Fin de ajouterPersonneAList(...)._________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterPersonneControllerAList(
			final IPersonneController pPersonne) {
		
		return this.ajouterPersonneControllerAList(
				pPersonne, this.listePersonnes);
		
	} // Fin de ajouterPersonneControllerAList(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterPersonneControllerAList(
			final IPersonneController pPersonne
				, final ObservableList<IPersonneController> pList) {
		
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
			final List<IPersonne> pListAAjouter) {
		
		return this.ajouterListePersonnesAList(
				pListAAjouter, this.listePersonnes);
		
	} // Fin de ajouterListePersonnesAList(...).__________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterListePersonnesAList(
			final List<IPersonne> pListAAjouter
				, final ObservableList<IPersonneController> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
		
		/* retourne false si pListAAjouter == null. */
		if (pListAAjouter == null) {
			return false;
		}
		
		boolean resultat = true;
		
		for (final IPersonne personne : pListAAjouter) {
			
			if (personne != null) {
				
				final IPersonneController personneController 
				= new PersonneController(personne);
				
				resultat = pList.add(personneController);
				
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
			final List<IPersonneController> pListAAjouter) {
		
		return this.ajouterListePersonneControllersAList(
				pListAAjouter, this.listePersonnes);
		
	} // Fin de ajouterListePersonneControllersAList(...)._________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterListePersonneControllersAList(
			final List<IPersonneController> pListAAjouter
				, final ObservableList<IPersonneController> pList) {
				
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
			final IPersonne pPersonne) {
		
		return this.retirerPersonneAList(pPersonne, this.listePersonnes);
		
	} // Fin de retirerPersonneAList(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerPersonneAList(
			final IPersonne pPersonne
				, final ObservableList<IPersonneController> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
		
		if (pPersonne != null) {
			
			/* instancie le IPersonneController associé au IPersonne. */
			final IPersonneController personneController 
				= new PersonneController(pPersonne);
			
			return pList.remove(personneController);
		}
		
		/* retourne false si pPersonne == null.*/
		return false;
		
	} // Fin de retirerPersonneAList(...)._________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerPersonneControllerAList(
			final IPersonneController pPersonne) {
		
		return this.retirerPersonneControllerAList(
				pPersonne, this.listePersonnes);
		
	} // Fin de retirerPersonneControllerAList(...)._______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerPersonneControllerAList(
			final IPersonneController pPersonne
				, final ObservableList<IPersonneController> pList) {
		
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
			final List<IPersonne> pListAretirer) {
		
		return this.retirerListePersonnesAList(
				pListAretirer, this.listePersonnes);
		
	} // Fin de retirerListePersonnesAList(...).__________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerListePersonnesAList(
			final List<IPersonne> pListAretirer
				, final ObservableList<IPersonneController> pList) {
		
		/* retourne false si pList == null. */
		if (pList == null) {
			return false;
		}
		
		/* retourne false si pListAretirer == null. */
		if (pListAretirer == null) {
			return false;
		}
		
		boolean resultat = true;
		
		for (final IPersonne personne : pListAretirer) {
			
			if (personne != null) {
				
				final IPersonneController personneController 
				= new PersonneController(personne);
				
				resultat = pList.remove(personneController);
				
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
			final List<IPersonneController> pListAretirer) {
		
		return this.retirerListePersonneControllersAList(
				pListAretirer, this.listePersonnes);
		
	} // Fin de retirerListePersonneControllersAList(...)._________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerListePersonneControllersAList(
			final List<IPersonneController> pListAretirer
				, final ObservableList<IPersonneController> pList) {
				
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
			final ObservableList<IPersonneController> pList) {
		
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
			final ObservableList<IPersonneController> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final int taille = pList.size();
		
		int compteur = 0;
		
		final StringBuffer stb = new StringBuffer();
		
		for (final IPersonneController personne : pList) {
			
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
	public final ObservableList<IPersonneController> getListePersonnes() {	
		return this.listePersonnes;
	} // Fin de getListePersonnes()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setListePersonnes(
			final ObservableList<IPersonneController> pListePersonnes) {	
		this.listePersonnes = pListePersonnes;
	} // Fin de setListePersonnes(...).____________________________________
	
	

} // FIN DE LA CLASSE ListePersonnesController.------------------------------
