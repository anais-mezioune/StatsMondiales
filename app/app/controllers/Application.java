package controllers;

import Services.AnneeService;
import Services.PaysDonneesService;
import Services.PaysService;
import play.*;
import play.mvc.*;

import java.io.UnsupportedEncodingException;
import java.util.*;

import models.*;

public class Application extends Controller {

	public static void index() {
    	List<Pays> listePays = Pays.findAll();
        List<Annee> listeAnnees = AnneeService.listAnneesOrdonnee();
        render(listePays, listeAnnees/*, paysDonnees*/);
    }

	/**
	 * @author Anaïs
	 * @param pays
	 * @param annees
	 * @param critere
	 */
		public static <T> void confirmer(String pays, String annees, String critere) {
	    	String[] tabPays;
	    	String[] tabAnnees;
	    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>pays : "+ pays);
	    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>annees : "+ annees);

	    	if (pays.indexOf(',') != -1){
	    		tabPays = pays.split(",");
	    	} else{
	    		tabPays = PaysDonneesService.stringToArray(pays);
	    	}

	    	if (annees.indexOf(',') != -1){
	    		tabAnnees = annees.split(",");
	    	} else{
	    		tabAnnees = PaysDonneesService.stringToArray(annees);
	    	}

	    	ArrayList<ArrayList> donnees = new ArrayList();
	    	for(int j = 0 ; j < tabAnnees.length ; j++){
	    		ArrayList<T> donnee = new ArrayList();
	    		donnee.add((T) tabAnnees[j]);
				for(int k = 0 ; k < tabPays.length ; k++){
					donnee.add(PaysDonneesService.chercherDonneesPaysAnneeByCritere(critere, tabPays[k], tabAnnees[j]));
				}
				donnees.add(donnee);
			}
	    	renderJSON(donnees);
//	    	 String data = "[[\"2010\", 23, 17], [\"2011\", 17, 23]]";
	    }

    /**
     * @author Anaïs
     * @param pays
     * @param annees
     * @param criteresRecherche
     */
    public static void confirmer2(String pays, String annees, String critere) {
    	String[] tabPays;
    	String[] tabAnnees;
    	String[] tabCriteresRecherche;
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>pays : "+ pays);
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>annees : "+ annees);

    	if (pays.indexOf(',') != -1){
    		tabPays = pays.split(",");
    	} else{
    		tabPays = PaysDonneesService.stringToArray(pays);
    	}

    	if (annees.indexOf(',') != -1){
    		tabAnnees = annees.split(",");
    	} else{
    		tabAnnees = PaysDonneesService.stringToArray(annees);
    	}

    	String donnees = "[";
    	for(int j = 0 ; j < tabAnnees.length ; j++){
			donnees += "[\"" + tabAnnees[j]  + "\",";
			for(int k = 0 ; k < tabPays.length ; k++){
		    		donnees += PaysDonneesService.chercherDonneesPaysAnneeByCritere(critere, tabPays[k], tabAnnees[j]);

				if(k == tabPays.length-1){
					break;
				}else{
					donnees += ",";
        		}
			}
			donnees += "]";
			if(j == tabAnnees.length-1) break;
			else{
				donnees += ",";
    		}
		}
    	donnees += "]";
    	renderJSON(donnees);
//    	 String data = "[[\"2010\", 23, 17], [\"2011\", 17, 23]]";
    }
}
