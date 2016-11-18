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


    public static <T> Map<String,T> chercherDonneeForListePaysForAnne(List<String> payses , short annee, String typeDonnee){
        //
        Map<String,T> map = new HashMap<>();
        for(String pays : payses){
            T datico =PaysDonneesService.chercherDonneesPaysAnnees(typeDonnee,pays,annee);
            map.put(pays ,datico );
        }
      return map;

    }



    public static <T> T chercherDonneesPaysAnnees(String donnee,String nomPays,short annee){
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
}
