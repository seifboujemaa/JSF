package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.sadium;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Stadium;


@Local
public interface StadiumServicesLocal {
	public void createStadium(Stadium stadium);
	public void updateStadium(Stadium stadium);
	public void deleteStadium(Stadium stadium);
	public Stadium findStadiumById(int idStadium);
	public List<Stadium> findAllStadium();

}
