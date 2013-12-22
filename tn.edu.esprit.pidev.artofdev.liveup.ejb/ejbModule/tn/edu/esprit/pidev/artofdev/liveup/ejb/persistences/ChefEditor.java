package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * Entity implementation class for Entity: ChefEditor
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@XmlRootElement
public class ChefEditor extends User implements Serializable {

	private List<FreeLance> freeLances= new ArrayList<FreeLance>();
	private List<Journalist> journalists = new ArrayList<Journalist>();
	
	private Administrator administrator;
	
	private static final long serialVersionUID = 1L;

	public ChefEditor() {
		super();
	}
    @OneToMany(mappedBy="chefEditor")
    @XmlTransient
	public List<FreeLance> getFreeLances() {
		return freeLances;
	}

	public void setFreeLances(List<FreeLance> freeLances) {
		this.freeLances = freeLances;
	}
      @OneToMany(mappedBy="chefEditor")
      @XmlTransient
	public List<Journalist> getJournalists() {
		return journalists;
	}

	public void setJournalists(List<Journalist> journalists) {
		this.journalists = journalists;
	}
	@OneToOne
	@XmlTransient
	public Administrator getAdministrator() {
		return administrator;
	}
	
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
   
}
