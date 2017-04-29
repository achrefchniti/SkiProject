package tn.esprit.beautifulminds.services.crud;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Admin;
import tn.esprit.beautifulminds.persistence.Trainer;
import tn.esprit.beautifulminds.persistence.User;

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
		User x = new User();
		User y = new User();
		Trainer p= new Trainer();
		Trainer s= new Trainer();

		x.setEmail("a@esprit.tn");
		x.setPassword("a");
		x.setFirstName("a");
		x.setLastName("a");
		x.setSomme(100);
		y.setEmail("b@esprit.tn");
		y.setPassword("b");
		y.setFirstName("b");
		y.setLastName("b");
		y.setSomme(100);

		p.setEmail("mimo@esprit.tn");
		p.setPassword("mimo");
		p.setFirstName("mimo");
		p.setLastName("mimo");
		s.setEmail("toto@esprit.tn");
		s.setPassword("toto");
		s.setFirstName("toto");
		s.setLastName("toto");
		a.setEmail("a");
		a.setPassword("a");
		entityManager.persist(a);
		entityManager.persist(x);
		entityManager.persist(y);
		entityManager.persist(s);
		entityManager.persist(p);


	}
}
