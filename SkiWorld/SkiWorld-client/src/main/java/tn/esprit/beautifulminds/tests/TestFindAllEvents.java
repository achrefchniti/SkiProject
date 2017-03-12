package tn.esprit.beautifulminds.tests;

import java.text.ParseException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Event;
import tn.esprit.beautifulminds.services.crud.EventServicesRemote;

public class TestFindAllEvents {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		EventServicesRemote EventServicesRemote = (EventServicesRemote) context
				.lookup("SkiWorld-ear/SkiWorld-ejb/EventServices!tn.esprit.beautifulminds.services.crud.EventServicesRemote");

		List<Event> events = EventServicesRemote.findAllEvents();

		for (Event e : events) {
			System.out.println(e.getDate_debut());
			System.out.println(e.getDate_fin());
		}

	}
}
