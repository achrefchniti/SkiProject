package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Station;

/**
 * Session Bean implementation class StationServices
 */
@Stateless

public class StationServices implements StationServicesRemote, StationServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public StationServices() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void addStation(Station station) {
		entityManager.persist(station);
	}

	@Override
	public Station findStationById(Integer id) {
		return entityManager.find(Station.class, id);
	}

	@Override
	public void deleteStationById(Integer id) {
		entityManager.remove(findStationById(id));
	}

	@Override
	public void deleteStation(Station station) {
		entityManager.remove(entityManager.merge(station));
	}

	@Override
	public void updateStation(Station station) {
		entityManager.merge(station);

	}

	public List<Station> findAllStations() {
		return entityManager.createQuery("select s from Station s ").getResultList();
	}

}
