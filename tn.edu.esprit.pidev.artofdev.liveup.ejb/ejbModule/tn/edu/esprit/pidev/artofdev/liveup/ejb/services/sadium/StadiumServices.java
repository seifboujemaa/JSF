package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.sadium;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Stadium;

/**
 * Session Bean implementation class StadiumServices
 */
@Stateless
public class StadiumServices implements StadiumServicesRemote, StadiumServicesLocal {
@PersistenceContext
    /**
     * Default constructor. 
     */

EntityManager entityManager ;
    public StadiumServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createStadium(Stadium stadium) {
		entityManager.persist(stadium)	;	
	}

	@Override
	public void updateStadium(Stadium stadium) {
		entityManager.merge(stadium);
		
	}

	@Override
	public void deleteStadium(Stadium stadium) {
		
		entityManager.remove(entityManager.merge(stadium));
		
		
	}

	@Override
	public Stadium findStadiumById(int idStadium) {
		Stadium stadium = entityManager.find(Stadium.class, idStadium);
		return stadium ;
	}

	@Override
	public List<Stadium> findAllStadium() {
		Query query=entityManager.createQuery("select s from Stadium s");
		return query.getResultList();
	}

	@Override
	public Stadium findStadiumByName(String nameStadium) {
		Query query=entityManager.createQuery("select s from Stadium s where name = '"+nameStadium+"'");
		return (Stadium) query.getSingleResult();
	}

}
