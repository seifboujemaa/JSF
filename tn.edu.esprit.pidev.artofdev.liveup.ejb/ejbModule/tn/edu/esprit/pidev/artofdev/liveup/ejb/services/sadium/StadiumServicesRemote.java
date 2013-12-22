package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.sadium;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Stadium;

@Remote
public interface StadiumServicesRemote {
	public void createStadium(Stadium stadium);
	public void updateStadium(Stadium stadium);
	public void deleteStadium(Stadium stadium);
	public Stadium findStadiumById(int idStadium);
	public Stadium findStadiumByName(String nameStadium);
	public List<Stadium> findAllStadium();


}
