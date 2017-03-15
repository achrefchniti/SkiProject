package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Materiel
 *
 */
@Entity

public class Material implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer materialId;
	private String name;
	private String fournisseur;

	public Material(String name, String fournisseur, Shop shop) {
		super();
		this.name = name;
		this.fournisseur = fournisseur;
		this.shop = shop;
	}

	public Material(String name, String fournisseur) {
		super();
		this.name = name;
		this.fournisseur = fournisseur;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	private Shop shop;

	@ManyToMany(mappedBy = "materials")
	private List<User> users;

	private static final long serialVersionUID = 1L;

	public Material() {
		super();
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
