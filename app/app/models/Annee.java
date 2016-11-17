package models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by pj on 17/11/16.
 */
@Entity
public class Annee {
    @Id
    public long id_pays;
    public short annee;
}
