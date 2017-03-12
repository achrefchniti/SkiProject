package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Event;

/**
 * Session Bean implementation class EventServices
 */
@Stateless
@LocalBean
public class EventServices implements EventServicesRemote, EventServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EventServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addEvent(Event event) {
		entityManager.persist(event);
	}

	@Override
	public void deleteEvent(Event event) {
		entityManager.remove(entityManager.merge(event));
	}

	@Override
	public void updateEvent(Event event) {
		entityManager.merge(event);

	}

	@Override
	public Event findEventById(Integer id) {
		return entityManager.find(Event.class, id);
	}

	public List<Event> findAllEvents() {
		return entityManager.createQuery("select e from Event e ").getResultList();
	}

}
