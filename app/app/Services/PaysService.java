package Services;

import models.Pays;

import java.util.List;

/**
 * Created by pj on 17/11/16.
 */
public class PaysService {

    public static Pays chercherPaysbyName(String nomPays){
        Pays pays = (Pays) Pays.find("nom",nomPays).first();
        return pays;
    }



}
