package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Admin;

/**
 * Session Bean implementation class AdminService
 */
@Stateless

public class AdminService implements AdminServiceRemote, AdminServiceLocal {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public AdminService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Admin> retrieveAdmins() {
		// TODO Auto-generated method stub
		return em.createQuery("Select a from Admin a").getResultList();
	}

	@Override
	public void addAdmin(Admin a) {
		// TODO Auto-generated method stub
		em.persist(a);
	}
	
	

}
