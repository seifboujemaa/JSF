package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Video;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.Freelance;

/**
 * Session Bean implementation class Reporter
 */
@Stateless
public class Reporter implements ReporterRemote, ReporterLocal {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public Reporter() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void createReporter(Reporter reporter) {
		em.persist(reporter);
		
	}

	@Override
	public List<Photo> viewPhoto() {
		Query query = em.createQuery("select p from Photo p");
		return query.getResultList();
		
	}

	@Override
	public List<Video> viewVideo() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void addVideo(Video video) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVideo(Video video) {
		em.remove(em.merge(video));
		
	}

	@Override
	public void deletePhoto(Photo photo) {
		em.remove(em.merge(photo));
		
	}


	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] imageToByte(File imageFile) {
		byte[] imagebytes = null;

		try {

		FileInputStream fis = new FileInputStream(imageFile);

		imagebytes = new byte[(int) imageFile.length()];

		fis.read(imagebytes);

		} catch (FileNotFoundException ex) {

		ex.printStackTrace();

		} catch (IOException ex) {

		ex.printStackTrace();

		}
		return imagebytes;
	}

	@Override
	public void addPhoto(Photo photo) {
	   em.persist(photo);
		
	}
	@Override
	public void createReporter(
			tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter reporter) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addReporter(
			tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter reporter) {
		em.persist(reporter);
		
	}
	@Override
	public void deleteReporter(
			tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter reporter) {
		em.remove(em.merge(reporter));
		
	}
	@Override
	public void updateReporter(
			tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter reporter) {
		em.merge(reporter);
		
	}
	@Override
	public List<tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter> findAllReporter() {
		Query query=em.createQuery("select r from Reporter r");
		return query.getResultList();
	}
	
	
	

	
	

}
