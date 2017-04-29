package tn.esprit.beautifulminds.services.other;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.User;

/**
 * Session Bean implementation class SignInServices
 */
@Stateless

public class SignInServices implements SignInServicesRemote, SignInServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SignInServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User login(String login, String password) {
		User client = null;
		try {
			client = (User) entityManager
					.createQuery("select p from Person p where p.email=:param1 and p.password=:param2")
					.setParameter("param1", login).setParameter("param2", password).getSingleResult();
		} catch (Exception e) {
		}

		return client;
	}

	

}
