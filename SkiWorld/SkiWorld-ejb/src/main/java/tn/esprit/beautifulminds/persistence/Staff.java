package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Staff
 *
 */
@Entity

public class Staff extends Person implements Serializable {

	private String email;
	private String password;
	private String role;
	private Integer nbjCA;
	private Integer nbjCAR;
	private Integer nbjCM;
	private Integer nbjCMAR;

	@ManyToOne
	private Staff staff;

	@OneToMany(mappedBy = "staff")
	private List<Staff> staffs;

	@ManyToMany(mappedBy = "eventStaffs")
	private List<Event> staffEvents;

	@ManyToOne
	private Station station;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Shop shop;

	public Staff() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getNbjCA() {
		return nbjCA;
	}

	public void setNbjCA(Integer nbjCA) {
		this.nbjCA = nbjCA;
	}

	public Integer getNbjCAR() {
		return nbjCAR;
	}

	public void setNbjCAR(Integer nbjCAR) {
		this.nbjCAR = nbjCAR;
	}

	public Integer getNbjCM() {
		return nbjCM;
	}

	public void setNbjCM(Integer nbjCM) {
		this.nbjCM = nbjCM;
	}

	public Integer getNbjCMAR() {
		return nbjCMAR;
	}

	public void setNbjCMAR(Integer nbjCMAR) {
		this.nbjCMAR = nbjCMAR;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public List<Event> getStaffEvents() {
		return staffEvents;
	}

	public void setStaffEvents(List<Event> staffEvents) {
		this.staffEvents = staffEvents;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Staff(Integer personId, String firstName, String lastName, Date birthday, String nationality, String gender,
			String email, String password, String role, Integer nbjCA, Integer nbjCAR, Integer nbjCM, Integer nbjCMAR,
			Staff staff, List<Staff> staffs, List<Event> staffEvents, Station station, Shop shop) {
		super(personId, firstName, lastName, birthday, nationality, gender);
		this.email = email;
		this.password = password;
		this.role = role;
		this.nbjCA = nbjCA;
		this.nbjCAR = nbjCAR;
		this.nbjCM = nbjCM;
		this.nbjCMAR = nbjCMAR;
		this.staff = staff;
		this.staffs = staffs;
		this.staffEvents = staffEvents;
		this.station = station;
		this.shop = shop;
	}

	public Staff(Integer personId, String firstName, String lastName, Date birthday, String nationality, String gender,
			String email, String password, String role, Integer nbjCA, Integer nbjCAR, Integer nbjCM, Integer nbjCMAR) {
		super(personId, firstName, lastName, birthday, nationality, gender);
		this.email = email;
		this.password = password;
		this.role = role;
		this.nbjCA = nbjCA;
		this.nbjCAR = nbjCAR;
		this.nbjCM = nbjCM;
		this.nbjCMAR = nbjCMAR;
	}

	public Staff(String firstName, String lastName, Date birthday, String nationality, String gender, String email,
			String password, String role, Integer nbjCA, Integer nbjCM) {
		super(firstName, lastName, birthday, nationality, gender);
		this.email = email;
		this.password = password;
		this.role = role;
		this.nbjCA = nbjCA;
		this.nbjCM = nbjCM;
	}

	public Staff(String firstName, String lastName, Date birthday, String nationality, String gender, String email,
			String password, String role, Integer nbjCA, Integer nbjCAR, Integer nbjCM, Integer nbjCMAR) {
		super(firstName, lastName, birthday, nationality, gender);
		this.email = email;
		this.password = password;
		this.role = role;
		this.nbjCA = nbjCA;
		this.nbjCAR = nbjCAR;
		this.nbjCM = nbjCM;
		this.nbjCMAR = nbjCMAR;
	}

}
