package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by pj on 17/11/16.
 */
@Entity
public class PaysDonnees {
    @OneToOne
    public long id_pays;

    @OneToOne
    public long id_annee;

    @Id
    public long id;

    public long densite_population;

    public short esperance_vie;

    public long pib;

    public long nb_habitants;

}
