package tn.edu.esprit.pidev.artofdev.liveup.ejb.sevices.video;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Video;
@Stateless
public class VideoServices implements VideoServicesLocal,VideoServicesRemote {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void createVideo(Video video) {
		entityManager.persist(video);
		
	}

	@Override
	public void updateVideo(Video video) {
		entityManager.merge(video);
		
	}

	@Override
	public void deleteVideo(Video video) {
		entityManager.remove(entityManager.merge(video));
		
	}

	@Override
	public Video findVideoById(int idVideo) {
		Video video =entityManager.find(Video.class,idVideo);
		return video;

	}

	@Override
	public List<Video> findAllVideo() {
		Query query=entityManager.createQuery("select v from Video v");
		return query.getResultList();
	}
	
	
	
	
	
	
	

}
