package tn.esprit.beautifulminds.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Staff;
import tn.esprit.beautifulminds.services.crud.StaffServicesRemote;

public class TestAddStaff {
	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		StaffServicesRemote staffServicesRemote = (StaffServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");

		String firstName = "snake";
		String lastName = "shark";
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date birthday = format.parse("22-04-1994");
		String nationality = "tunisienne";
		String gender = "male";
		String email = "snake@gmail.com";
		String password = "snake";
		String role = "vendor";
		Integer nbjT = 30;
		Integer nbjR = 12;
		Staff st = new Staff(firstName, lastName, birthday, nationality, gender, email, password, role, nbjT, nbjR);
		staffServicesRemote.addStaff(st);
	}
}
