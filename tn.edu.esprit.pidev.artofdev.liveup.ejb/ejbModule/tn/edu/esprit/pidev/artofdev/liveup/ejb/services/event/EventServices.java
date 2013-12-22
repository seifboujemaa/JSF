package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.event;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Event;

/**
 * Session Bean implementation class EventServices
 */
@Stateless
public class EventServices implements EventServicesRemote, EventServicesLocal {
@PersistenceContext
    /**
     * Default constructor. 
     */
EntityManager entityManager ;
    public EventServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createEvent(Event event) {
		entityManager.persist(event);		
	}

	@Override
	public void updateEventEvent(Event event) {
		entityManager.merge(event);
		
	}

	@Override
	public void deleteEvent(Event event) {
		entityManager.remove(entityManager.merge(event));
		
	}

	@Override
	public Event findEventById(int idEvent) {
		Event event = entityManager.find(Event.class, idEvent);
		return event;
	}

	@Override
	public List<Event> findAllEvent() {
		Query query=entityManager.createQuery("select e from Event e");
		return query.getResultList();
	}

}
