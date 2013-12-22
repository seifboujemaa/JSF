package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import javax.persistence.*;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.User;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Admin extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}
   
}
