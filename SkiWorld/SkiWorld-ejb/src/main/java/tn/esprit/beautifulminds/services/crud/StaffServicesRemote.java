package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Staff;
import tn.esprit.beautifulminds.persistence.Training;

@Remote
public interface StaffServicesRemote {
	void addStaff(Staff staff);

	Staff findStaffById(Integer idPerson);

	void deleteStaff(Staff staff);

	void updateStaff(Staff staff);

	List<Staff> findAllStaffs();
	List<Staff> findStaffByRole(String role);

}
