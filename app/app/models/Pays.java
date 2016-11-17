package models;

import javax.persistence.Id;

/**
 * Created by pj on 17/11/16.
 */
public class Pays {
    @Id
    public long id_pays;

    public String nom_pays;

}
