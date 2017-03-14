package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eventId;

	private Date date_debut;
	private Date date_fin;
	private String title;
	private String place;
	private String Description;

	public List<Staff> getEventStaffs() {
		return eventStaffs;
	}

	public void setEventStaffs(List<Staff> eventStaffs) {
		this.eventStaffs = eventStaffs;
	}

	@ManyToMany
	private List<Staff> eventStaffs;

	public Event(Date date_debut, Date date_fin, String title, String place, String description) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.title = title;
		this.place = place;
		Description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@ManyToMany(mappedBy = "events")
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

}
