package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Trainer
 *
 */
@Entity

public class Trainer extends Person implements Serializable {

	private String email;
	private String passwd;
	private String role;
	private Integer nbjT;
	private Integer nbjR;
	private String expirence;
	private String description;
	private String categorie;
	private Integer ratingPoints;
	private static final long serialVersionUID = 1L;

	public Trainer() {
		super();
	}

	public String getExpirence() {
		return this.expirence;
	}

	public void setExpirence(String expirence) {
		this.expirence = expirence;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Integer getRatingPoints() {
		return this.ratingPoints;
	}

	public void setRatingPoints(Integer ratingPoints) {
		this.ratingPoints = ratingPoints;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getNbjT() {
		return this.nbjT;
	}

	public void setNbjT(Integer nbjT) {
		this.nbjT = nbjT;
	}

	public Integer getNbjR() {
		return this.nbjR;
	}

	public void setNbjR(Integer nbjR) {
		this.nbjR = nbjR;
	}

}
