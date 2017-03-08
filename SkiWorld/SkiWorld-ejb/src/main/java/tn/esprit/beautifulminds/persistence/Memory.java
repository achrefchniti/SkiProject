package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Memory
 *
 */
@Entity

public class Memory implements Serializable {

	@Id
	private Integer memoryId;
	private String name;
	private String status;
	private String image;
	private String video;
	private Integer rating;
	private Person person;
	@ManyToOne
	private Admin admin;
	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Memory(Integer memoryId, String name, String status, String image, String video, Integer rating,
			Person person) {
		super();
		this.memoryId = memoryId;
		this.name = name;
		this.status = status;
		this.image = image;
		this.video = video;
		this.rating = rating;
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	private static final long serialVersionUID = 1L;

	public Memory() {
		super();
	}

	public Integer getMemoryId() {
		return this.memoryId;
	}

	public void setMemoryId(Integer memoryId) {
		this.memoryId = memoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
