package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Person;

/**
 * Session Bean implementation class PersonServices
 */
@Stateless
public class PersonServices implements PersonServicesRemote, PersonServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PersonServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addPerson(Person person) {
		entityManager.persist(person);
	}

	@Override
	public Person findPersonById(Integer idPerson) {
		return entityManager.find(Person.class, idPerson);
	}

	@Override
	public void deletePerson(Person person) {
		entityManager.remove(entityManager.merge(person));

	}

	@Override
	public void updatePerson(Person person) {
		entityManager.merge(person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAllPersons() {
		return entityManager.createQuery("select per from Person per ").getResultList();
	}

}
