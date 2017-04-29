package tn.esprit.beautifulminds.services.crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.User;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public UserServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public float Somme(User user) {
		float a=user.getSomme();
		return a;
	}

	@Override
	public User findUserById(Integer idPerson) {
		return entityManager.find(User.class, idPerson);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
		
	}

}
