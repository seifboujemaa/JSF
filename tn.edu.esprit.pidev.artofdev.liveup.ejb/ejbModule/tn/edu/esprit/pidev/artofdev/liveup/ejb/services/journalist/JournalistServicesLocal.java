package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.journalist;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;


@Local
public interface JournalistServicesLocal {
	
	public void createJournalist(Journalist journalist);
	public void updateJournalist(Journalist journalist);
	public void deleteJournalist(Journalist journalist);
	public Journalist findJournalistById(int idJournalist);
	public List<Journalist> findAllJournalist();  
	
	public List<Journalist> findAllJournalistJSF();

}
