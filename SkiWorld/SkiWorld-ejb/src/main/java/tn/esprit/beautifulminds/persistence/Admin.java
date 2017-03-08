package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends Person implements Serializable {

	private String email;
	private String password;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "admin")
	private List<Feedback> feedbacks;
	@OneToMany(mappedBy = "admin")
	private List<Memory> memories;

	@OneToMany(mappedBy = "admin")
	private List<Applier> appliers;

	public List<Applier> getAppliers() {
		return appliers;
	}

	public void setAppliers(List<Applier> appliers) {
		this.appliers = appliers;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<Memory> getMemories() {
		return memories;
	}

	public void setMemories(List<Memory> memories) {
		this.memories = memories;
	}

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
