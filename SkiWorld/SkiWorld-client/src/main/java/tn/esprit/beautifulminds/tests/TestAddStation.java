package tn.esprit.beautifulminds.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Station;
import tn.esprit.beautifulminds.services.crud.StationServicesRemote;

public class TestAddStation {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StationServicesRemote stationServicesRemote = (StationServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StationServices!tn.esprit.beautifulminds.services.crud.StationServicesRemote");

		// String name = "Tabarka";
		// float longitude = 2;
		// float latitude = 25;
		// String address = "aaaaa";
		// String area = "bbbb";
		// String description = "cccc";
		Station station = new Station();
		station.setName("Tabarka");
		station.setLongitude(20);
		station.setLongitude(30);
		station.setAddress("aaaa");
		station.setArea("bbb");
		station.setDescription("cccc");

		stationServicesRemote.addStation(station);

	}
}
