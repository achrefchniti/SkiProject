package tn.esprit.beautifulminds.services.other;

import javax.ejb.Remote;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Person;
import tn.esprit.beautifulminds.persistence.Staff;

@Remote
public interface LoginServiceRemote {

	public String isAuthentified(String email, String password) throws NamingException;
	
	
}
