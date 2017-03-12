package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Shop;

@Remote
public interface ShopServicesRemote {

	void addShop(Shop shop);

	void deleteShop(Shop shop);

	void updateShop(Shop shop);

	Shop findShopById(Integer id);

	List<Shop> findAllShops();

}
