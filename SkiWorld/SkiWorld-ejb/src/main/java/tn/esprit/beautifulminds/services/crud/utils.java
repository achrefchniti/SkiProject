package tn.esprit.beautifulminds.services.crud;

import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Training;

/**
 * Session Bean implementation class utils
 */
@Singleton
@LocalBean
@Startup
public class utils {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public utils() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
		Training tr = new Training();
		tr.setName("ent1");
		tr.setType("water");
		tr.setCategorie("amateur");
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		tr.setHourBegin(18);
		tr.setDurationDay(9);
		tr.setDurationHour(2);
		tr.setTrainer("mimo");
		tr.setFees(9);
		tr.setCapacity(20);
		entityManager.persist(tr);
		
		Training tr1 = new Training();
		tr1.setName("ent1");
		tr1.setType("water");
		tr1.setCategorie("amateur");
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		tr1.setHourBegin(18);
		tr1.setDurationDay(9);
		tr1.setDurationHour(2);
		tr1.setTrainer("toto");
		tr1.setFees(9);
		tr1.setCapacity(20);
		entityManager.persist(tr1);
	}
}
