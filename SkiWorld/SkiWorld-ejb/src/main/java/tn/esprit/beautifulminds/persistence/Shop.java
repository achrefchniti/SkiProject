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

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public List<Staff> getShops() {
		return shops;
	}

	public void setShops(List<Staff> shops) {
		this.shops = shops;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@OneToMany(mappedBy = "shop")
	private List<Material> materials;

	@ManyToOne
	private Station station_shop;

	@OneToMany(mappedBy = "shop")
	private List<Staff> shops;

	public Station getStation_shop() {
		return station_shop;
	}

	public void setStation_shop(Station station_shop) {
		this.station_shop = station_shop;
	}

	private static final long serialVersionUID = 1L;

	public Shop() {
		super();
	}

}
