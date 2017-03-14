package tn.esprit.beautifulminds.services.other;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Admin;
import tn.esprit.beautifulminds.services.crud.AdminServiceLocal;

/**
 * Session Bean implementation class LoginService
 */
@Stateful
public class LoginService implements LoginServiceRemote, LoginServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;

	Admin admin;

	/**
	 * Default constructor.
	 */
	public LoginService() {
		// TODO Auto-generated constructor stub

	}

	@EJB
	private AdminServiceLocal as;

	@Override
	public boolean isAuthentified(String email, String password) throws NamingException {
		// TODO Auto-generated method stub

		// admin.setEmail(email);
		// admin.setPassword(password);
		// System.out.println("****" + admin.getEmail());
		// System.out.println("****" + admin.getPassword());

		boolean auth = false;

		System.out.println("get list************");
		List<Admin> admins = as.retrieveAdmins();
		System.out.println("list OKKKKKK");
		for (Admin p : admins) {

			if (email.equals(p.getEmail())) {
				if (password.equals(p.getPassword())) {
					auth = true;
					this.admin = p;
					System.out.println("auth");
					System.out.println(this.admin.getPersonId());
					break;
				}
				System.out.println(" NONauth");
			}
			System.out.println("list");
		}

		return auth;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
