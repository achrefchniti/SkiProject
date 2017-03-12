package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Material;

@Remote
public interface MaterialServicesRemote {

	void addMaterial(Material material);

	void deleteMaterial(Material material);

	void updateMaterial(Material material);

	Material findMaterialById(Integer id);

	List<Material> findAllMaterials();

}
