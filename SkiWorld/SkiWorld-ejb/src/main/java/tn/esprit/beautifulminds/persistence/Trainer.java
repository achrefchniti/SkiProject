package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Trainer
 *
 */
@Entity

public class Trainer extends Person implements Serializable {

	private String email;
	private String password;
	private String role;
	private Integer nbjCA;
	private Integer nbjCAR;
	private Integer nbjCM;
	private Integer nbjCMAR;
	private String experience;
	private String description;
	private String categorie;
	private Integer ratingPoints;

	@OneToMany(mappedBy = "trainerstaff")
	private List<Training> trainings;
	private static final long serialVersionUID = 1L;

	public Trainer() {
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

	public String getExperience() {
		return experience;
	}

	public void setExperince(String experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Integer getRatingPoints() {
		return ratingPoints;
	}

	public void setRatingPoints(Integer ratingPoints) {
		this.ratingPoints = ratingPoints;
	}

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Trainer(String firstName, String lastName, Date birthday, String nationality, String gender, String email,
			String password, String role, Integer nbjCA, Integer nbjCM, String experience, String description,
			String categorie, Integer ratingPoints) {
		super(firstName, lastName, birthday, nationality, gender);
		this.email = email;
		this.password = password;
		this.role = role;
		this.nbjCA = nbjCA;
		this.nbjCM = nbjCM;
		this.experience = experience;
		this.description = description;
		this.categorie = categorie;
		this.ratingPoints = ratingPoints;
	}

	public Trainer(String firstName, String lastName, Date birthday, String nationality, String gender, String email,
			String password, String role, Integer nbjCA, Integer nbjCAR, Integer nbjCM, Integer nbjCMAR,
			String experience, String description, String categorie, Integer ratingPoints) {
		super(firstName, lastName, birthday, nationality, gender);
		this.email = email;
		this.password = password;
		this.role = role;
		this.nbjCA = nbjCA;
		this.nbjCAR = nbjCAR;
		this.nbjCM = nbjCM;
		this.nbjCMAR = nbjCMAR;
		this.experience = experience;
		this.description = description;
		this.categorie = categorie;
		this.ratingPoints = ratingPoints;
	}

}
