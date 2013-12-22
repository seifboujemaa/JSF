package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.photo;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;


@Local
public interface PhotoServicesLocal {
	public void createPhoto(Photo photo);
	public void updatePhoto(Photo photo);
	public void deletePhoto(Photo photo);
	public Photo findPhotoById(int idPhoto);
	public List<Photo> findAllPhoto();


}
