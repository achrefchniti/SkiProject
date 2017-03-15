package tn.esprit.beautifulminds.services.other;

import javax.ejb.Remote;
import javax.naming.NamingException;

@Remote
public interface LoginServiceRemote {

	public String isAuthentified(String email, String password) throws NamingException;

}
