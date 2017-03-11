package tn.esprit.beautifulminds.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Person;
import tn.esprit.beautifulminds.services.crud.PersonServicesRemote;

public class TestFindPerson {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		PersonServicesRemote personServicesRemote = (PersonServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/PersonServices!tn.esprit.beautifulminds.services.crud.PersonServicesRemote");
		Person person2 = personServicesRemote.findPersonById(3);
		System.out.println(person2.getFirstName());
		System.out.println(person2.getLastName());
	}
}
