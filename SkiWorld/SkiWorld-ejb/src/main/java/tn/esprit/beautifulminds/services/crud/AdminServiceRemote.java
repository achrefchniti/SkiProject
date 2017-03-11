package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Admin;

@Remote
public interface AdminServiceRemote {

	public List<Admin> retrieveAdmins();

	public void addAdmin(Admin a);

}
