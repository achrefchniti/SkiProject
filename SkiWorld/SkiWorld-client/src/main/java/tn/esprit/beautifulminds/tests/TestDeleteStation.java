package tn.esprit.beautifulminds.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Station;
import tn.esprit.beautifulminds.services.crud.StationServicesRemote;

public class TestDeleteStation {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StationServicesRemote stationServicesRemote = (StationServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StationServices!tn.esprit.beautifulminds.services.crud.StationServicesRemote");

		Station station = stationServicesRemote.findStationById(1);

		stationServicesRemote.deleteStation(station);
	}

}
