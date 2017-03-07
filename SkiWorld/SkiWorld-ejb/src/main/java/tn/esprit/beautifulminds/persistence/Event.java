package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


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
	
	@ManyToMany
	private List<Staff> staff_event;
	@ManyToOne
	private Station station_event;
	
	public List<Staff> getStaff_event() {
		return staff_event;
	}
	public void setStaff_event(List<Staff> staff_event) {
		this.staff_event = staff_event;
	}
	public Station getStation_event() {
		return station_event;
	}
	public void setStation_event(Station station_event) {
		this.station_event = station_event;
	}
	
	
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
