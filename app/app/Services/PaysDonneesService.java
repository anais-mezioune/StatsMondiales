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

//    public static List<PaysDonnees> chercherDonneesPays(String nomPays){
//        Pays pays = PaysService.chercherPaysbyName(nomPays);
//        List<PaysDonnees> donnees =  PaysDonnees.find("id_pays",pays.id).fetch();
//        return donnees;
//    }

//    public static Map<String,PaysDonnees> chercherDonneesPaysbyAnnee(short annee){
//        Map<String,PaysDonnees> map = new HashMap<String, PaysDonnees>();
//        List<Pays> listePays = Pays.findAll();
//        long idAnnee = AnneeService.recupererAnneeId(annee);
//
//        for(Pays pays : listePays){
//            PaysDonnees donnees = PaysDonnees.find("id_annee",annee).first();
//            map.put(pays.nom,donnees);
//        }
//        return map;
//    }

//    public static PaysDonnees chercherDonneesPaysbyAnnee(String nomPays,String tabAnnees){
//        long id_pays = PaysService.chercherPaysbyName(nomPays).id;
//        long id_annee = AnneeService.recupererAnneeId(tabAnnees);
//
//        PaysDonnees donnes = PaysDonnees.find("id_pays = ? and id_annee = ?",id_pays,id_annee).first();
//        return donnes;
//    }

//    public static double[] chercherDonneeForListePaysForAnne(String[] payses , String annee, String typeDonnee) {
//        double[] array = new double[payses.length+1];
//        array[0] = (double) annee;
//        for (int i=0;i<payses.length;i++) {
//            double datico = PaysDonneesService.chercherDonneePaysAnnees(typeDonnee, payses[i], annee);
//            array[i+1] = datico;
//        }
//        return array;
//    }
    

//    public static <T> Map<String,T> chercherDonneesOfListePaysForAnne(List<String> payses , String annee, String typeDonnee){
//        //
//        Map<String,T> map = new HashMap<>();
//        for(String pays : payses){
//            T datico = PaysDonneesService.chercherDonneePaysAnnees(typeDonnee,pays,annee);
//            map.put(pays,datico);
//        }
//        return map;
//
//    }

//    public static <T> T chercherDonneePaysAnnees(String donnee,String nomPays,String annee){
//        long id_pays = PaysService.chercherPaysbyName(nomPays).id;
//        long id_annee = AnneeService.recupererAnneeId(annee);
//
//        String query =  "select " + donnee + " from pays_donnees where id_pays = ?1 and id_annee = ?2";
//
//        try {
//            return (T)JPA.em().createNativeQuery(query)
//                    .setParameter(1, id_pays)
//                    .setParameter(2, id_annee)
//                    .getSingleResult();
//        }catch(NoResultException exception){
//            return null;
//        }
//
//    }
    
    /**
     * @author Anaïs
     * @param criteres[]
     * @param nomPays
     * @param annee
     * @return Les données pour 1 pays et 1 année
     */
//    public static <T> T chercherDonneesPaysAnnee(String[] criteres,String nomPays,String annee){
//        long id_pays = PaysService.chercherPaysbyName(nomPays).id;
//        long id_annee = AnneeService.recupererAnneeId(annee);
//        String query =  "select "; 
//        Integer i = 0;
//        
//        for(String critere : criteres){
//    		query += critere;
//    		i++;
//    		
//    		if(i == criteres.length) break;
//    		else{
//    			query += ",";
//    		}
//    	}
//        query += " from pays_donnees where id_pays = ?1 and id_annee = ?2";
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + query);
//        try {
//            return (T)JPA.em().createNativeQuery(query)
//                    .setParameter(1, id_pays)
//                    .setParameter(2, id_annee)
//                    .getResultList();
//                    //.getSingleResult();
//        }catch(NoResultException exception){
//            return null;
//        }
//
//    }
    
    /**
     * @author Anaïs
     * @param donnee
     * @param nomPays
     * @param annee
     * @return Un tableau de donneées pour 1 pays et plusieurs années
     */
//	public static String[] tableauDonneesPaysAnnees(String[] donnees,String nomPays,String[] annees){
//        long id_annee = 0;
//        String[] resultats = null;
//        int i = 0;
//        for(String annee : annees){
//        	id_annee = AnneeService.recupererAnneeId(annee);
//        	resultats[i] = chercherDonneesPaysAnnee(donnees, nomPays, String.valueOf(id_annee));
//        	i++;
//    	}
//        return resultats;
//    }
	
	/**
	 * @author Anaïs
	 * @param critere
	 * @param pays
	 * @param annee
	 * @return Une donnée d'un pays pour une année
	 */
	public static <T> T chercherDonneesPaysAnneeByCritere(String critere, String pays, String annee) {
		long id_annee = AnneeService.recupererAnneeId(annee);
		long id_pays = PaysService.chercherPaysbyName(pays).id;
		String requete = "select " + critere + " from pays_donnees where id_annee = ?1 and id_pays = ?2";
		
		try {
            return (T)JPA.em().createNativeQuery(requete)
                    .setParameter(1, id_annee)
                    .setParameter(2, id_pays)
                    .getSingleResult();
        }catch(NoResultException exception){
            return null;
        }
	}
	
	/**
	 * @author Anaïs
	 * @param array
	 * @return
	 */
	public static String[] stringToArray(String... array) {
	   return array;
	}

    
}
