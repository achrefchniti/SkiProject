package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.util.Date;

import javax.persistence.*;

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

	public Booking() {
		super();
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
