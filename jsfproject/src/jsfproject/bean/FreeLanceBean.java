package jsfproject.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.FreelanceLocal;
@ManagedBean
@ViewScoped
public class FreeLanceBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private FreelanceLocal localFreeLance ;
	
	
	private FreeLance freelance = new FreeLance();
	
	
	private List<FreeLance> freeLances = new ArrayList<FreeLance>();


	public FreelanceLocal getLocalFreeLance() {
		return localFreeLance;
	}


	public void setLocalFreeLance(FreelanceLocal localFreeLance) {
		this.localFreeLance = localFreeLance;
	}


	public FreeLance getFreelance() {
		return freelance;
	}


	public void setFreelance(FreeLance freelance) {
		this.freelance = freelance;
	}


	public List<FreeLance> getFreeLances() {
		return freeLances;
	}


	public void setFreeLances(List<FreeLance> freeLances) {
		this.freeLances = freeLances;
	}


	public FreeLanceBean() {
		
	}
	@PostConstruct
	public void init(){
		freeLances = localFreeLance.findAllFreelance();
		
	}
	
	public String  doAddFreeLancer(){
		localFreeLance.addFreeLance(freelance);
		freelance = new FreeLance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Welcome","Your now in the  list! wait for our confirmation:)");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return null;
	}
	
	

}
