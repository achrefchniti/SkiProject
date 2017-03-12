package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Shop;

/**
 * Session Bean implementation class ShopServices
 */
@Stateless
@LocalBean
public class ShopServices implements ShopServicesRemote, ShopServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ShopServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addShop(Shop shop) {
		entityManager.persist(shop);
	}

	@Override
	public void deleteShop(Shop shop) {
		entityManager.remove(entityManager.merge(shop));
	}

	@Override
	public void updateShop(Shop shop) {
		entityManager.merge(shop);

	}

	@Override
	public Shop findShopById(Integer id) {
		return entityManager.find(Shop.class, id);
	}

	public List<Shop> findAllShops() {
		return entityManager.createQuery("select s from Shop s ").getResultList();
	}

}
