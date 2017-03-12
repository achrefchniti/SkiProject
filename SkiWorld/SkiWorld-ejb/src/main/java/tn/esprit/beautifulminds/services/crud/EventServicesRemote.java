package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Event;

@Remote
public interface EventServicesRemote {

	void addEvent(Event event);

	void deleteEvent(Event event);

	void updateEvent(Event event);

	Event findEventById(Integer id);

	List<Event> findAllEvents();

}
