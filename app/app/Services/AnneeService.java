package Services;

import javax.persistence.NoResultException;

import models.Annee;
import play.db.jpa.JPA;
import javax.persistence.NoResultException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pj on 17/11/16.
 */
public class AnneeService {

	/**
	 * @author Anaïs
	 * @param annee
	 * @return L'identifiant d'une année
	 */
    public static Integer recupererAnneeId(String annee){
//        Annee objAnnee = Annee.find("annee",annee).first();
//        return objAnnee.id;
   

        String query =  "select id from annee where annee = ?1";

        try {
            return (Integer) JPA.em().createNativeQuery(query)
                    .setParameter(1, annee)
                    .getSingleResult();
        }catch(NoResultException exception){
            return (Integer) null;
        }

    }

}
