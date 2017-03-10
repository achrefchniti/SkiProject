package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Staff;

@Remote
public interface StaffServicesRemote {
	void addStaff(Staff staff);

	Staff findStaffById(Integer idPerson);

	void deleteStaff(Staff staff);

	void updateStaff(Staff staff);

	List<Staff> findAllStaffs();
}
