package tn.esprit.beautifulminds.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Person;
import tn.esprit.beautifulminds.services.crud.PersonServicesRemote;

public class TestAddPerson {
	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		PersonServicesRemote personServicesRemote = (PersonServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/PersonServices!tn.esprit.beautifulminds.services.crud.PersonServicesRemote");

		String firstName = "snake";
		String lastName = "shark";
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date birthday = format.parse("22-04-1994");
		String nationality = "tunisienne";
		String gender = "male";
		Person p = new Person(firstName, lastName, birthday, nationality, gender);
		personServicesRemote.addPerson(p);
	}
}
