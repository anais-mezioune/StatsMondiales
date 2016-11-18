package controllers;

import Services.PaysDonneesService;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        List<PaysDonnees> donnees = PaysDonneesService.chercherDonneesPays("France");
        
        Map<String,PaysDonnees> paysDonnees = PaysDonneesService.chercherDonneesPaysbyAnnee((short)2016); 
        List<Pays> listePays = Pays.findAll();
        List<Annee> listeAnnees = Annee.findAll();
        render(donnees, listePays, listeAnnees, paysDonnees);

    }
    
    
    public static void confirmer(String pays, String annees, String critereRecherche) {
    	String[] tabPays = pays.split(",");
    	String[] tabAnnees= annees.split(",");
    	String[] tabCritereRecherche= critereRecherche.split(",");
    	
    	for(String elem : tabPays){
    		System.out.println(elem);
    	}
    	
    	for(String elem : tabAnnees){
    		System.out.println(elem);
    	}
    	
    	for(String elem : tabCritereRecherche){
    		System.out.println(elem);
    	}
    	
    	
    	String data = "[";
    	
    	for(int i = 0 ; i < tabAnnees.length ; i++){
    		PaysDonneesService.chercherDonneesPaysAnnees(tabCritereRecherche, tabPays[i], Short.parseShort(tabAnnees[i]));
    		data += "[\"" + tabAnnees[i] + "\"" + ", 23, 17]";
    		
    		
    		
    		if(i == tabAnnees.length-1) break;
    		else{
    			data += ",";
    		}
    	}
    	
    	
    	data += "]";  
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Data : "+ data);
    	renderJSON(data);
    	
//    	 String data = "[[\"2010\", 23, 17], [\"2011\", 17, 23]]";
  
    }

}