package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Shop
 *
 */
@Entity

public class Shop implements Serializable {

	   
	@Id
	private Integer id_shop;
	
	@OneToMany(mappedBy="shop_materiel")
	private List<Materiel> materiel_shop;
	
	public List<Materiel> getMateriel_shop() {
		return materiel_shop;
	}
	public void setMateriel_shop(List<Materiel> materiel_shop) {
		this.materiel_shop = materiel_shop;
	}

	@ManyToOne
	private Station station_shop;
	
	@OneToMany(mappedBy="shops")
	private List<Staff> staff_shop;
	
	
	public Station getStation_shop() {
		return station_shop;
	}
	public void setStation_shop(Station station_shop) {
		this.station_shop = station_shop;
	}
	public List<Staff> getStaff_shop() {
		return staff_shop;
	}
	public void setStaff_shop(List<Staff> staff_shop) {
		this.staff_shop = staff_shop;
	}
	
	private static final long serialVersionUID = 1L;

	public Shop() {
		super();
	}   
	public Integer getId_shop() {
		return this.id_shop;
	}

	public void setId_shop(Integer id_shop) {
		this.id_shop = id_shop;
	}
   
}
