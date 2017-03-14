package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.beautifulminds.persistence.Staff;

/**
 * Session Bean implementation class StaffServices
 */
@Stateless

public class StaffServices implements StaffServicesRemote, StaffServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public StaffServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addStaff(Staff staff) {
		entityManager.persist(staff);

	}

	@Override
	public Staff findStaffById(Integer idPerson) {
		return entityManager.find(Staff.class, idPerson);
	}

	@Override
	public void deleteStaff(Staff staff) {
		entityManager.remove(entityManager.merge(staff));

	}

	@Override
	public void updateStaff(Staff staff) {
		entityManager.merge(staff);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> findAllStaffs() {
		return entityManager.createQuery("select st from Staff st ").getResultList();
	}

	@Override
	public List<Staff> afficheStaff() {
		// TODO Auto-generated method stub

		String jpql = "SELECT ST FROM Staff ST";
		Query qry = entityManager.createQuery(jpql, Staff.class);

		return qry.getResultList();
	}

}
