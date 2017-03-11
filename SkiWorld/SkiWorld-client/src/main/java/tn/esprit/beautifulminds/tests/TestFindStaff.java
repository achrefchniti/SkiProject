package tn.esprit.beautifulminds.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Staff;
import tn.esprit.beautifulminds.services.crud.StaffServicesRemote;



public class TestFindStaff {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		StaffServicesRemote staffServicesRemote = (StaffServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");
		Staff staff2 = staffServicesRemote.findStaffById(3);
		System.out.println(staff2.getRole());
	}
}
