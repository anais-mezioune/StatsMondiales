package Services;

import models.Pays;
import models.PaysDonnees;
import play.db.jpa.JPA;

import javax.persistence.NoResultException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pj on 17/11/16.
 */
public class PaysDonneesService {

	/**
	 * @author Anaïs
	 * @param critere
	 * @param pays
	 * @param annee
	 * @return Une donnée d'un pays pour une année
	 * @throws UnsupportedEncodingException 
	 */
	public static <T> T chercherDonneesPaysAnneeByCritere(String critere, String pays, String annee) throws UnsupportedEncodingException {
		long id_annee = AnneeService.recupererAnneeId(annee);
		long id_pays = PaysService.chercherPaysbyName(pays).id;
		String requete = "select " + critere + " from pays_donnees where id_annee = ?1 and id_pays = ?2";
		
		try {
            return (T)JPA.em().createNativeQuery(requete)
                    .setParameter(1, id_annee)
                    .setParameter(2, id_pays)
                    .getSingleResult();
        }catch(NoResultException exception){
            System.out.println(exception.getMessage());
        	return null;
        }
	}
	
	/**
	 * @author Anaïs
	 * @param array
	 * @return Converti une chaine de caractères en tableau
	 */
	public static String[] stringToArray(String... array) {
	   return array;
	}
	
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
}
