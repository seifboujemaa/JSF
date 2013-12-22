package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.photo;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;

@Remote
public interface PhotoServicesRemote {
	public void createPhoto(Photo photo);
	public void updatePhoto(Photo photo);
	public void deletePhoto(Photo photo);
	public Photo findPhotoById(int idPhoto);
	public List<Photo> findAllPhoto();

}
