package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.beautifulminds.persistence.Staff;

@Local
public interface StaffServicesLocal {
	
	public List<Staff> retrieveStaffs();

	public void addStaff(Staff b);

}
