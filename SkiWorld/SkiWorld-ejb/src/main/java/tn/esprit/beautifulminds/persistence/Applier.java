package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Applier
 *
 */
@Entity

public class Applier extends Person implements Serializable {

	private String cv;
	private String role;
	private static final long serialVersionUID = 1L;

	public Applier() {
		super();
	}

	public Applier(Integer personId, String firstName, String lastName, Date birthday, String nationality,
			String gender, String cv, String role) {
		super(personId, firstName, lastName, birthday, nationality, gender);
		this.cv = cv;
		this.role = role;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
