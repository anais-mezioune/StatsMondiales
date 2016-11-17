package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pj on 17/11/16.
 */
@Entity
@Table(name="annee")
public class Annee extends Model{
	
    public short annee;
}
