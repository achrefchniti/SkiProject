package tn.esprit.beautifulminds.services.other;

import javax.ejb.Local;
import javax.naming.NamingException;

@Local
public interface LoginServiceLocal {

	public String isAuthentified(String email, String password) throws NamingException;

}
