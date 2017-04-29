package tn.esprit.beautifulminds.services.other;

import javax.ejb.Remote;


import tn.esprit.beautifulminds.persistence.User;

@Remote
public interface SignInServicesRemote {
	User login(String login, String password);

}
