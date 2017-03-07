package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;



/**
 * Entity implementation class for Entity: Materiel
 *
 */
@Entity

public class Materiel implements Serializable {

	   
	@Id
	private Integer id_materiel;
	private String fournisseur;
	
	@ManyToOne
	private Shop shop_materiel;
	
	public Shop getShop_materiel() {
		return shop_materiel;
	}
	public void setShop_materiel(Shop shop_materiel) {
		this.shop_materiel = shop_materiel;
	}

	
	private static final long serialVersionUID = 1L;

	public Materiel() {
		super();
	}   
	public Integer getId_materiel() {
		return this.id_materiel;
	}

	public void setId_materiel(Integer id_materiel) {
		this.id_materiel = id_materiel;
	}   
	public String getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
   
}
