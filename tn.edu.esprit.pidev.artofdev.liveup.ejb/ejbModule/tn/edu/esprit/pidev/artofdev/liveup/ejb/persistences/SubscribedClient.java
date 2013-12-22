package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: SubscribedClient
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@XmlRootElement
public class SubscribedClient extends User implements Serializable {

	private Administrator administrator;
	private static final long serialVersionUID = 1L;

	public SubscribedClient() {
		super();
	}
     @ManyToOne
	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
   
}
