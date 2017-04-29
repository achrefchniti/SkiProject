package tn.esprit.beautifulminds.services.other;

import javax.ejb.Local;

import tn.esprit.beautifulminds.persistence.User;

@Local
public interface SignInServicesLocal {
	User login(String login, String password);

}
