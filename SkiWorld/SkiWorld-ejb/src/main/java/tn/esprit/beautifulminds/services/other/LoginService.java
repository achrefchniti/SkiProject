package tn.esprit.beautifulminds.services.other;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Admin;
import tn.esprit.beautifulminds.persistence.Staff;
import tn.esprit.beautifulminds.services.crud.AdminServiceLocal;
import tn.esprit.beautifulminds.services.crud.StaffServicesLocal;

/**
 * Session Bean implementation class LoginService
 */
@Stateful
public class LoginService implements LoginServiceRemote, LoginServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;

	Admin admin;
	Staff staff;

	/**
	 * Default constructor.
	 */
	public LoginService() {
		// TODO Auto-generated constructor stub

	}

	@EJB
	private AdminServiceLocal as;

	@EJB
	private StaffServicesLocal ss;
	String auth;

	@Override
	public String isAuthentified(String email, String password) throws NamingException {
		// TODO Auto-generated method stub
		// admin.setEmail(email);
		// admin.setPassword(password);
		// System.out.println("****" + admin.getEmail());
		// System.out.println("****" + admin.getPassword());

		System.out.println("get list************");
		List<Admin> admins = as.retrieveAdmins();
		System.out.println("list OKKKKKK");

		for (Admin p : admins) {

			if (email.equals(p.getEmail())) {
				if (password.equals(p.getPassword())) {
					auth = "Admin";
					this.admin = p;

					System.out.println("auth");
					System.out.println(this.admin.getPersonId());
					break;
				}
				System.out.println(" NONauth");
			}
			System.out.println("list");
		}

		System.out.println("get list************");
		List<Staff> staffs = ss.retrieveStaffs();
		System.out.println("list OKKKKKK");
		for (Staff s : staffs) {

			if (email.equals(s.getEmail())) {
				if (password.equals(s.getPassword())) {
					if (s.getRole().equals("Manager")) {
						auth = "Manager";
						this.staff = s;
						System.out.println("auth");
						System.out.println(this.staff.getPersonId());
						break;
					}

					System.out.println(" NONauth");
				}
				System.out.println("list");
			}
		}
		return auth;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
