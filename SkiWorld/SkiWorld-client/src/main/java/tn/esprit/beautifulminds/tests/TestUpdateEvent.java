package tn.esprit.beautifulminds.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Event;
import tn.esprit.beautifulminds.services.crud.EventServicesRemote;

public class TestUpdateEvent {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		EventServicesRemote EventServicesRemote = (EventServicesRemote) context
				.lookup("SkiWorld-ear/SkiWorld-ejb/EventServices!tn.esprit.beautifulminds.services.crud.EventServicesRemote");

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = format.parse("01-01-2001");

		Event event = EventServicesRemote.findEventById(7);
		event.setDate_debut(date);

		EventServicesRemote.updateEvent(event);
	}
}
