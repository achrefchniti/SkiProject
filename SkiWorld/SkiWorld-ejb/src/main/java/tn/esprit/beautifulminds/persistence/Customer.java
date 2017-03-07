package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity

public class Customer extends Person implements Serializable {

	private Integer bookingId;
	private Integer stationId;
	private String type;
	private String category;
	private String email;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}

	public Customer(Integer bookingId, Integer stationId, String type, String category, String email) {
		super();
		this.bookingId = bookingId;
		this.stationId = stationId;
		this.type = type;
		this.category = category;
		this.email = email;
	}

	public Integer getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getStationId() {
		return this.stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
