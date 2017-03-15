package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Applier;

@Remote
public interface ApplierServiceRemote {

	public List<Applier> retrieveAllAppliers();

	public List<Applier> retrieveAppliersByRole(String role);

	public List<Applier> retrieveApplierByNationality(String nationality);

	public List<Applier> retrieveApplierByStatus(String status);

	public void hireApplier(Applier applier);

	public void rejectApplier(Applier applier);
}
