package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Material;

/**
 * Session Bean implementation class MaterialServices
 */
@Stateless
@LocalBean
public class MaterialServices implements MaterialServicesRemote, MaterialServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public MaterialServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addMaterial(Material material) {
		entityManager.persist(material);
	}

	@Override
	public void deleteMaterial(Material material) {
		entityManager.remove(entityManager.merge(material));
	}

	@Override
	public void updateMaterial(Material material) {
		entityManager.merge(material);

	}

	@Override
	public Material findMaterialById(Integer id) {
		return entityManager.find(Material.class, id);

	}

	public List<Material> findAllMaterials() {
		return entityManager.createQuery("select m from Material m ").getResultList();
	}

}
