package Services;

import models.Pays;
import models.PaysDonnees;
import play.db.jpa.JPA;

import javax.persistence.NoResultException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pj on 17/11/16.
 */
public class PaysDonneesService {

    public static List<PaysDonnees> chercherDonneesPays(String nomPays){
        Pays pays = PaysService.chercherPaysbyName(nomPays);
        List<PaysDonnees> donnees =  PaysDonnees.find("id_pays",pays.id).fetch();
        return donnees;
    }

    public static Map<String,PaysDonnees> chercherDonneesPaysbyAnnee(short annee){
        Map<String,PaysDonnees> map = new HashMap<String, PaysDonnees>();
        List<Pays> listePays = Pays.findAll();
        long idAnnee = AnneeService.recupererAnneeId(annee);

        for(Pays pays : listePays){
            PaysDonnees donnees = PaysDonnees.find("id_annee",annee).first();
            map.put(pays.nom,donnees);
        }
        return map;
    }

    public static PaysDonnees chercherDonneesPaysbyAnnee(String nomPays,short annee){
        long id_pays = PaysService.chercherPaysbyName(nomPays).id;
        long id_annee = AnneeService.recupererAnneeId(annee);

        PaysDonnees donnes = PaysDonnees.find("id_pays = ? and id_annee = ?",id_pays,id_annee).first();
        return donnes;
    }

    public static double[] chercherDonneeForListePaysForAnne(String[] payses , short annee, String typeDonnee) {
        double[] array = new double[payses.length+1];
        array[0] = (double) annee;
        for (int i=0;i<payses.length;i++) {
            double datico = PaysDonneesService.chercherDonneePaysAnnees(typeDonnee, payses[i], annee);
            array[i+1] = datico;
        }
        return array;
    }
    

    public static <T> Map<String,T> chercherDonneesOfListePaysForAnne(List<String> payses , short annee, String typeDonnee){
        //
        Map<String,T> map = new HashMap<>();
        for(String pays : payses){
            T datico = PaysDonneesService.chercherDonneePaysAnnees(typeDonnee,pays,annee);
            map.put(pays,datico);
        }
        return map;

    }

    public static <T> T chercherDonneePaysAnnees(String donnee,String nomPays,short annee){
        long id_pays = PaysService.chercherPaysbyName(nomPays).id;
        long id_annee = AnneeService.recupererAnneeId(annee);

        String query =  "select " + donnee + " from pays_donnees where id_pays = ?1 and id_annee = ?2";

        try {
            return (T)JPA.em().createNativeQuery(query)
                    .setParameter(1, id_pays)
                    .setParameter(2, id_annee)
                    .getSingleResult();
        }catch(NoResultException exception){
            return null;
        }

    }
    
    public static <T> T chercherDonneesPaysAnnees(String[] donnees,String nomPays,short annee){
        long id_pays = PaysService.chercherPaysbyName(nomPays).id;
        long id_annee = AnneeService.recupererAnneeId(annee);

        String query =  "select"; 
        Integer i = 0;
        
        while(donnees.length < i){
    		i++;
    		query += " " + donnees[i] ;
    		
    		if(i == donnees.length-1) break;
    		else{
    			query += ",";
    		}
    	}
        
        query += "from pays_donnees where id_pays = ?1 and id_annee = ?";

        try {
            return (T)JPA.em().createNativeQuery(query)
                    .setParameter(1, id_pays)
                    .setParameter(2, id_annee)
                    .getSingleResult();
        }catch(NoResultException exception){
            return null;
        }

    }
    
}
