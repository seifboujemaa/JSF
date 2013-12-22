package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.event;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Event;


@Remote
public interface EventServicesRemote {
	public void createEvent(Event event);
	public void updateEventEvent(Event event);
	public void deleteEvent(Event event);
	public Event findEventById(int idEvent);
	public List<Event> findAllEvent();


}
