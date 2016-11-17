package Services;

import models.Annee;

/**
 * Created by pj on 17/11/16.
 */
public class AnneeService {

    public static long recupererAnneeId(short annee){
        Annee objAnnee = Annee.find("annee",annee).first();
        return objAnnee.id;
    }

}
