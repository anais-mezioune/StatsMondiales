package controllers;

import Services.PaysDonneesService;
import play.*;
import play.mvc.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mysql.fabric.xmlrpc.base.Array;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.*;

public class Application extends Controller {

    public static void index() {
//        List<PaysDonnees> donnees = PaysDonneesService.chercherDonneesPays("France");
        
        // Map<String,PaysDonnees> paysDonnees = PaysDonneesService.chercherDonneesPaysbyAnnee((short)2016); 
        List<Pays> listePays = Pays.findAll();
        List<Annee> listeAnnees = Annee.findAll();
        render(listePays, listeAnnees/*, paysDonnees*/);

    }
    
    /**
     * @author Anaïs
     * @param pays
     * @param annees
     * @param criteresRecherche
     */
    public static void confirmer(String pays, String annees, String criteresRecherche) {
    	String[] tabPays;
    	String[] tabAnnees; 
    	String[] tabCriteresRecherche;
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>pays : "+ pays);
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>annees : "+ annees);
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>criteresRecherche : "+ criteresRecherche);
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
    	
    	if (criteresRecherche.indexOf(',') != -1){
    		tabCriteresRecherche = criteresRecherche.split(",");
    	} else{
    		tabCriteresRecherche = PaysDonneesService.stringToArray(criteresRecherche);
    	}
   
    	String donnees = "[";
    	for(int i = 0 ; i < tabCriteresRecherche.length ; i++){
    		String critere = tabCriteresRecherche[i];
    		for(int j = 0 ; j < tabAnnees.length ; j++){
    			donnees += "[\"" + tabAnnees[j]  + "\",";
    			
    			for(int k = 0 ; k < tabPays.length ; k++){
    				
    				donnees += PaysDonneesService.chercherDonneesPaysAnneeByCritere(critere, tabPays[k], tabAnnees[j]);
    				// data += ", 17]";
    				
    				
    				if(k == tabPays.length-1){
    					if(k == 0){
    						donnees += ", 0";
    					}
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
    		if(i == tabCriteresRecherche.length-1) break;
			else{
				donnees += ",";
    		}
    	}
    	
//    	for(int i = 0 ; i < tabAnnees.length ; i++){
//    		data += "[\"" + tabAnnees[i]  + "\",";
//    		
//    		for(int j = 0 ; j < tabPays.length ; j++){
//    			
//    			for(int k = 0 ; k < tabCriteresRecherche.length ; k++){
//    				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>><"+tabPays[i] +","+ tabAnnees[j] + "," + tabCriteresRecherche[k]);
//    				String critere = tabCriteresRecherche[k];
//    				
//    				data += PaysDonneesService.chercherDonneesPaysAnneeByCritere(critere, tabPays[j], tabAnnees[i])+" ii " ;
//        			
//    			}
//    			
//    			data += ", 17]";
//    			
//    			if(j == tabPays.length) break;
//        		else{
//        			data += ",";
//        		}
//    		}
//    		
//    		data += "";
//    		
//    		if(i == tabPays.length) break;
//    		else{
//    			data += ",";
//    		}
//    	}
    	
    	donnees += "]"; 
    	ArrayList<String> tabDonnees = new ArrayList();
    	Pattern pattern1 = Pattern.compile("(\"[0-9]{4}\",[0-9a-zA-Z.,-]+,[0-9a-zA-Z.-]+)");
    	Matcher matcher1 = pattern1.matcher(donnees);
    	   
    	while(matcher1.find()){
    		tabDonnees.add("[" + matcher1.group() + "]");
    		
    	}
    	
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>tabDonneesBis : "+ tabDonnees.toString());
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>donnees : "+ donnees);
    	
    	String json = new Gson().toJson(tabDonnees);
    	
//    	JsonParser  parser = new JsonParser();
//        JsonElement elem = parser.parse(tabDonnees);
//        JsonArray tabs = tabDonnees.getAsJsonArray();
//        JsonObject datas = elem.getAsJsonArray().getAsJsonObject();
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Datas : "+ datas);
    	
    	renderTemplate("Application/index.html", json, tabCriteresRecherche, tabPays, tabAnnees);
//    	renderJSON(data);
    	
//    	 String data = "[[\"2010\", 23, 17], [\"2011\", 17, 23]]";
  
    }

}