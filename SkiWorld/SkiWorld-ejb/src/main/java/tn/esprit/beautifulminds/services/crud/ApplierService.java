package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Applier;

/**
 * Session Bean implementation class ApplierService
 */
@Stateless

public class ApplierService implements ApplierServiceRemote, ApplierServiceLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager em;

	public ApplierService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Applier> retrieveAllAppliers() {
		// TODO Auto-generated method stub
		return em.createQuery("Select a from Applier a").getResultList();
	}

	@Override
	public List<Applier> retrieveAppliersByRole(String role) {
		// TODO Auto-generated method stub
		return em.createQuery("Select a from Applier a where a.role like '" + role + "'").getResultList();
	}

	@Override
	public List<Applier> retrieveApplierByNationality(String nationality) {
		// TODO Auto-generated method stub
		return em.createQuery("Select a from Applier a where a.nationality like '" + nationality + "'").getResultList();
	}

	@Override
	public void hireApplier(Applier applier) {
		// TODO Auto-generated method stub
		applier.setStatus("Hired");
		em.merge(applier);

	}

	@Override
	public void rejectApplier(Applier applier) {
		// TODO Auto-generated method stub
		applier.setStatus("Rejected");
		em.merge(applier);

	}

	@Override
	public List<Applier> retrieveApplierByStatus(String status) {
		// TODO Auto-generated method stub
		return em.createQuery("Select a from Applier a where a.status like '" + status + "'").getResultList();
	}

}
