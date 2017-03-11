package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.beautifulminds.persistence.Admin;

@Local
public interface AdminServiceLocal {

	public List<Admin> retrieveAdmins();

	public void addAdmin(Admin a);

}
