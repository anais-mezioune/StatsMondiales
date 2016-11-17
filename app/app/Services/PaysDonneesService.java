package Services;

import models.Pays;
import models.PaysDonnees;
import play.db.jpa.JPA;

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

    public static Map<String,List<PaysDonnees>> chercherDonneesPaysbyAnnee(short annee){
        Map<String,List<PaysDonnees>> map = new HashMap<String, List<PaysDonnees>>();
        List<Pays> listePays = Pays.findAll();

        for(Pays pays : listePays){
            map.put(pays.nom,chercherDonneesPays(pays.nom));
        }
        return map;
    }

    public static <T> T chercherDonneesPaysAnnees(String donnee,String nomPays,short annee){
        long id_pays = PaysService.chercherPaysbyName(nomPays).id;
        long id_annee = AnneeService.recupererAnneeId(annee);

        String query =  "select " + donnee + " from pays_donnees where id pays = ?1 and id_annee = ?2";

         return (T) JPA.em().createNativeQuery(query)
                 .setParameter(1,id_pays)
                 .setParameter(2,id_annee)
                 .getSingleResult();
    }
}
