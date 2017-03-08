package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User extends Person implements Serializable {

	private String email;
	private String password;
	private Boolean vip;

	@ManyToMany(mappedBy = "users")
	private List<Training> trainings;

	@OneToMany(mappedBy = "user")
	private List<Feedback> feedbacks;

	@OneToMany(mappedBy = "user")
	private List<Memory> memories;
	@ManyToMany
	private List<Event> events;

	public List<Memory> getMemories() {
		return memories;
	}

	public void setMemories(List<Memory> memories) {
		this.memories = memories;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	@OneToMany(mappedBy = "user")
	private List<Booking> bookings;

	@ManyToMany
	private List<Material> materials;

	private static final long serialVersionUID = 1L;

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public User() {
		super();
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getVip() {
		return this.vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
