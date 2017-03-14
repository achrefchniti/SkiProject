package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Station;

@Remote
public interface StationServicesRemote {
	
	void addStation(Station station);

	Station findStationById(Integer id);

	void deleteStationById(Integer id);

	void deleteStation(Station station);

	void updateStation(Station station);

	List<Station> findAllStations();
	
	public List<Station> afficheStation();

}
