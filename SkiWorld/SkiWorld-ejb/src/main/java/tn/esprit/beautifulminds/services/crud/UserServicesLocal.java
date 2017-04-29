package tn.esprit.beautifulminds.services.crud;

import javax.ejb.Local;

import tn.esprit.beautifulminds.persistence.Training;
import tn.esprit.beautifulminds.persistence.User;

@Local
public interface UserServicesLocal {
	public float Somme(User user);
	User findUserById(Integer idPerson);
	void updateUser(User user);

}
