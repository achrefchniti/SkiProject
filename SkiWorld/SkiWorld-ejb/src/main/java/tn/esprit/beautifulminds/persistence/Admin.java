package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends Person implements Serializable {

	private String email;
	private String password;
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}

	public Admin(Integer personId, String firstName, String lastName, Date birthday, String nationality, String gender,
			String email, String password) {
		super(personId, firstName, lastName, birthday, nationality, gender);
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
