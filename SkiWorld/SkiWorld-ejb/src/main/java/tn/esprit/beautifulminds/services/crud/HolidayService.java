package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Holiday;

/**
 * Session Bean implementation class HolidayService
 */
@Stateless

public class HolidayService implements HolidayServiceRemote, HolidayServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public HolidayService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addHoliday(Holiday holiday) {
		entityManager.persist(holiday);

	}

	@Override
	public Holiday findHolidayById(Integer idHoliday) {
		return entityManager.find(Holiday.class, idHoliday);
	}

	@Override
	public void deleteHoliday(Holiday holiday) {
		entityManager.remove(entityManager.merge(holiday));
	}

	@Override
	public void updateHoliday(Holiday holiday) {
		entityManager.merge(holiday);
	}

	@Override
	public List<Holiday> findAllHolidays() {
		return entityManager.createQuery("select st from Holiday st ").getResultList();

	}

	@Override
	public List<Holiday> findAllHolidaysPerPerson(Integer personId) {

		return entityManager.createQuery("select a from Holiday a where a.personId=?1", Holiday.class)
				.setParameter(1, personId).getResultList();
	}

}
