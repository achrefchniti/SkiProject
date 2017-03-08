package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Materiel
 *
 */
@Entity

public class Material implements Serializable {

	@Id
	private Integer materialId;
	private String fournisseur;

	@ManyToOne
	private Shop shop_material;

	public Shop getShop_material() {
		return shop_material;
	}

	public void setShop_material(Shop shop_material) {
		this.shop_material = shop_material;
	}

	private static final long serialVersionUID = 1L;

	public Material() {
		super();
	}

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public String getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

}
