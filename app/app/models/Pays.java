package models;


import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pj on 17/11/16.
 */
@Entity
@Table(name="pays")
public class Pays extends Model {
    @Id
    public long id;

    public String nom;

}
