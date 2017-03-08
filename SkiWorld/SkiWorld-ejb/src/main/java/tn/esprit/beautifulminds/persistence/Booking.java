package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Booking
 *
 */
@Entity

public class Booking implements Serializable {

	@Id
	private Integer bookingId;
	private Date date;
	private Float fees;
	private Integer perNumber;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Station station;
	@ManyToOne
	private User user;

	public Booking() {
		super();
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getFees() {
		return this.fees;
	}

	public void setFees(Float fees) {
		this.fees = fees;
	}

	public Integer getPerNumber() {
		return this.perNumber;
	}

	public void setPerNumber(Integer perNumber) {
		this.perNumber = perNumber;
	}

}
