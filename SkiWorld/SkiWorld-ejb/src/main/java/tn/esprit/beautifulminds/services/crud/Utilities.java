package tn.esprit.beautifulminds.services.crud;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Admin;

/**
 * Session Bean implementation class Utilities
 */
@Singleton
@LocalBean
@Startup
public class Utilities {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public Utilities() {
	}

	@PostConstruct
	public void initDb() throws NamingException {

		Admin a = new Admin();
		a.setEmail("a");
		a.setPassword("a");
		entityManager.persist(a);

	}
}
