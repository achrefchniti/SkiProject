package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	@Id
	private Integer id_event;

	private Date date_debut;
	private Date date_fin;

	@ManyToMany(mappedBy = "events")
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Staff> getEventStaffs() {
		return eventStaffs;
	}

	public void setEventStaffs(List<Staff> eventStaffs) {
		this.eventStaffs = eventStaffs;
	}

	@ManyToMany
	private List<Staff> eventStaffs;

	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}

	public Integer getId_event() {
		return this.id_event;
	}

	public void setId_event(Integer id_event) {
		this.id_event = id_event;
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
