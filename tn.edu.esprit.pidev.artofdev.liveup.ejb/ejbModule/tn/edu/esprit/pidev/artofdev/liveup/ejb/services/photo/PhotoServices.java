package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.photo;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;

/**
 * Session Bean implementation class PhotoServices
 */
@Stateless
public class PhotoServices implements PhotoServicesRemote, PhotoServicesLocal {
@PersistenceContext
	
    /**
     * Default constructor. 
     */
EntityManager entityManager ;
    public PhotoServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createPhoto(Photo photo) {
		entityManager.persist(photo);
		
	}

	@Override
	public void updatePhoto(Photo photo) {
		entityManager.merge(photo);		
	}

	@Override
	public void deletePhoto(Photo photo) {
		entityManager.remove(entityManager.merge(photo));		
	}

	@Override
	public Photo findPhotoById(int idPhoto) {
		Photo photo = entityManager.find(Photo.class, idPhoto);
		return photo ;
	}

	@Override
	public List<Photo> findAllPhoto() {
		Query query=entityManager.createQuery("select p from Photo p");
		return query.getResultList();

	}

}
