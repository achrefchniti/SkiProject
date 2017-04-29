package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Training;

/**
 * Session Bean implementation class Training
 */
@Stateless

public class Trainingservices implements TrainingservicesRemote, TrainingservicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public Trainingservices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addTraining(Training training) {
		entityManager.persist(training);

	}

	@Override
	public Training findTrainingById(Integer idPerson) {
		return entityManager.find(Training.class, idPerson);
	}

	@Override
	public void deleteTraining(Training training) {
		entityManager.remove(entityManager.merge(training));

	}

	@Override
	public void updateTraining(Training training) {
		entityManager.merge(training);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Training> findAllTrainings() {
		return entityManager.createQuery("select t from Training t ").getResultList();
	}

	@Override
	public Training findTrainingsByType(String type) {

		return entityManager.createQuery("select a from Training a where a.type=?1", Training.class)
				.setParameter(1, type).getSingleResult();
	}

	@Override
	public List<Training> findTrainingsByType2(String type) {
		return entityManager.createQuery("select a from Training a where a.type=?1", Training.class)
				.setParameter(1, type).getResultList();

	}

	

	@Override
	public void getCap(Training  training) {
		Integer a = training.getCapacity();
		Integer b=a-1;
		training.setCapacity(b);
		 entityManager.merge(training);
	}

	@Override
	public Training findTrainingsByName(String name) {
		return entityManager.createQuery("SELECT c FROM Training c WHERE c.trainer=:p", Training.class)
				.setParameter("p", name).getSingleResult();

	}

	public float getFees(Training tr) {
		float a=tr.getFees();
		return a;
	}

	@Override
	public Integer capa(Training training) {
		Integer a=training.getCapacity();
		return a;
	}
	

}
