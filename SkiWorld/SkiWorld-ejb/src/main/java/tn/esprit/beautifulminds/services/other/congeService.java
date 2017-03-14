package tn.esprit.beautifulminds.services.other;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Staff;

/**
 * Session Bean implementation class congeService
 */
@Stateless

public class congeService implements congeServiceRemote, congeServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public congeService() {
		// TODO Auto-generated constructor stub
	}

	// public Person findStaffById(Integer idPerson) {
	// return entityManager.find(Staff.class, idPerson);
	// }

	@Override
	public Integer getCar(Staff staff, Integer j) {
		Integer a = staff.getNbjCAR();
		return a - j;
	}

	@Override
	public Integer getCar2(Staff staff, Integer j) {
		Integer a = staff.getNbjCMAR();
		return a - j;
	}

}
