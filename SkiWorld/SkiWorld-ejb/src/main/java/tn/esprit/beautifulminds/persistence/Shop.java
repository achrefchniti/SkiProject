package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Shop
 *
 */
@Entity

public class Shop implements Serializable {

	@Id
	private Integer shopId;

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@OneToMany(mappedBy = "shop_material")
	private List<Material> material_shop;

	public List<Material> getMaterial_shop() {
		return material_shop;
	}

	public void setMaterial_shop(List<Material> material_shop) {
		this.material_shop = material_shop;
	}

	@ManyToOne
	private Station station_shop;

	@OneToMany(mappedBy = "shops")
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

}
