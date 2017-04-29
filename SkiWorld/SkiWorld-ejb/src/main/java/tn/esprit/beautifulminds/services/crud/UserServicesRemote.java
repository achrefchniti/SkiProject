package tn.esprit.beautifulminds.services.crud;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.User;

@Remote
public interface UserServicesRemote {
	public float Somme(User user);
	void updateUser(User user);

	User findUserById(Integer idPerson);

}
