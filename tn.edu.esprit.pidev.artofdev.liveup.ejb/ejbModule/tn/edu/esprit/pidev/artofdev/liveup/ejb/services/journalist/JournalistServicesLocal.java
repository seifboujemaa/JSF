package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.journalist;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;



public interface JournalistServicesLocal {
	
	public void createJournalist(Journalist journalist);
	public void updateJournalist(Journalist journalist);
	public void deleteJournalist(Journalist journalist);
	public Journalist findJournalistById(int idJournalist);
	public List<Journalist> findAllJournalist();  

}
