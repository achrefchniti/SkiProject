package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Holiday
 *
 */
@Entity

public class Holiday implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHoliday;
	private Integer personId;
	private Date dateDemande;
	private Date dateDepart;
	private Integer nbrjour;
	private Boolean etat;
	@ManyToOne
	private Admin admin;
	private static final long serialVersionUID = 1L;

	public Holiday(Date dateDemande, Date dateDepart, Integer nbrjour) {
		super();
		this.dateDemande = dateDemande;
		this.dateDepart = dateDepart;
		this.nbrjour = nbrjour;
	}

	public Holiday(Integer personId, Date dateDemande, Date dateDepart, Integer nbrjour, Boolean etat) {
		super();
		this.personId = personId;
		this.dateDemande = dateDemande;
		this.dateDepart = dateDepart;
		this.nbrjour = nbrjour;
		this.etat = etat;
	}

	public Holiday() {
		super();
	}

	public Integer getIdHoliday() {
		return this.idHoliday;
	}

	public void setIdHoliday(Integer idHoliday) {
		this.idHoliday = idHoliday;
	}

	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Date getDateDemande() {
		return this.dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Date getDateDepart() {
		return this.dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Integer getNbrjour() {
		return this.nbrjour;
	}

	public void setNbrjour(Integer nbrjour) {
		this.nbrjour = nbrjour;
	}

	public Boolean getEtat() {
		return this.etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

}
