package tn.esprit.beautifulminds.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Event;
import tn.esprit.beautifulminds.services.crud.EventServicesRemote;

public class TestDeleteEvent {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		EventServicesRemote EventServicesRemote = (EventServicesRemote) context
				.lookup("SkiWorld-ear/SkiWorld-ejb/EventServices!tn.esprit.beautifulminds.services.crud.EventServicesRemote");

		Event event = EventServicesRemote.findEventById(7);
		EventServicesRemote.deleteEvent(event);
	}

}
