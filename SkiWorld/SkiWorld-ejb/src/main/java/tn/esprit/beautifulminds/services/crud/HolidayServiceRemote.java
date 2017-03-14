package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Holiday;

@Remote
public interface HolidayServiceRemote {
	void addHoliday(Holiday holiday);

	Holiday findHolidayById(Integer idHoliday);

	void deleteHoliday(Holiday holiday);

	void updateHoliday(Holiday holiday);

	List<Holiday> findAllHolidays();

	List<Holiday> findAllHolidaysPerPerson(Integer idPerson);

}
