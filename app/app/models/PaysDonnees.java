package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by pj on 17/11/16.
 */
@Entity
@Table(name="pays_donnees")
public class PaysDonnees extends Model {
    @ManyToOne
    public Pays pays;

    @ManyToOne
    public Annee annee;

    public long population;

    public double esperance_vie;

    public double natalite;

    public double mortalite;

    public double mortalite_infantile;

    public double croissance;

}
