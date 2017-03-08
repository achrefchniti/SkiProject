package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Training
 *
 */
@Entity

public class Training implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTraining;
	private String Name;
	private String type;
	private String categorie;
	private Date dateBegin;
	private Integer hourBegin;
	private Integer durationDay;
	private Integer durationHour;
	private String trainer;
	private Float fees;
	private Integer capacity;

	@ManyToOne
	private Trainer trainerstaff;
	@ManyToMany
	private List<User> users;

	@ManyToOne
	private Station station;
	private static final long serialVersionUID = 1L;

	public Training() {
		super();
	}

	public Integer getIdTraining() {
		return this.idTraining;
	}

	public void setIdTraining(Integer idTraining) {
		this.idTraining = idTraining;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Date getDateBegin() {
		return this.dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Integer getHourBegin() {
		return this.hourBegin;
	}

	public void setHourBegin(Integer hourBegin) {
		this.hourBegin = hourBegin;
	}

	public Integer getDurationDay() {
		return this.durationDay;
	}

	public void setDurationDay(Integer durationDay) {
		this.durationDay = durationDay;
	}

	public Integer getDurationHour() {
		return this.durationHour;
	}

	public void setDurationHour(Integer durationHour) {
		this.durationHour = durationHour;
	}

	public String getTrainer() {
		return this.trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public float getFees() {
		return this.fees;
	}

	public void setFees(Float fees) {
		this.fees = fees;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Trainer getTrainerstaff() {
		return trainerstaff;
	}

	public void setTrainerstaff(Trainer trainerstaff) {
		this.trainerstaff = trainerstaff;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

}
