package tn.esprit.beautifulminds.gui;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Staff;
import tn.esprit.beautifulminds.services.crud.StaffServicesRemote;

public class TestAddStaff {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StaffServicesRemote staffServicesRemote = (StaffServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");

		String firstName = "snake";
		String lastName = "shark";
		@SuppressWarnings("deprecation")
		Date birthday = new Date(85, 02, 03);
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
