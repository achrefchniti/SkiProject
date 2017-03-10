package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Trainer;

/**
 * Session Bean implementation class TrainerServices
 */
@Stateless

public class TrainerServices implements TrainerServicesRemote, TrainerServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TrainerServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addTrainer(Trainer trainer) {
		entityManager.persist(trainer);

	}

	@Override
	public Trainer findTrainerById(Integer idPerson) {
		return entityManager.find(Trainer.class, idPerson);
	}

	@Override
	public void deleteTraining(Trainer trainer) {
		entityManager.remove(entityManager.merge(trainer));
	}

	@Override
	public void updateTraining(Trainer trainer) {
		entityManager.merge(trainer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trainer> findAllTrainers() {
		return entityManager.createQuery("select ent from Trainer ent ").getResultList();
	}

}
