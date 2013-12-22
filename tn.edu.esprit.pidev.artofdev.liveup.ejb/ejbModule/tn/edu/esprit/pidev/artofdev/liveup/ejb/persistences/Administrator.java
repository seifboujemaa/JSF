package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * Entity implementation class for Entity: Administrator
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@XmlRootElement
public class Administrator extends User implements Serializable {

	private List<Reporter> repoters = new ArrayList<Reporter>();
	private List<SubscribedClient> subscribedClients  = new ArrayList<SubscribedClient>();
	private List<Agent> agents = new ArrayList<Agent>();
	
	private ChefEditor chefEditor;
	
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}
    @OneToMany(mappedBy="administrator")
    @XmlTransient
	public List<Reporter> getRepoters() {
		return repoters;
	}

	public void setRepoters(List<Reporter> repoters) {
		this.repoters = repoters;
	}
    @OneToMany(mappedBy="administrator")
	public List<SubscribedClient> getSubscribedClients() {
		return subscribedClients;
	}

	public void setSubscribedClients(List<SubscribedClient> subscribedClients) {
		this.subscribedClients = subscribedClients;
	}
    @OneToMany(mappedBy="administrator")
	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	@OneToOne(mappedBy="administrator")
	 public ChefEditor getChefEditor() {
		return chefEditor;
	}
	 public void setChefEditor(ChefEditor chefEditor) {
		this.chefEditor = chefEditor;
	}
	
   
}
