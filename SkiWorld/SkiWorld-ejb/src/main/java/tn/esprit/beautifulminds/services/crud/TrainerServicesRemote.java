package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Trainer;

@Remote
public interface TrainerServicesRemote {
	void addTrainer(Trainer trainer);

	Trainer findTrainerById(Integer idPerson);

	void deleteTraining(Trainer trainer);

	void updateTraining(Trainer trainer);

	List<Trainer> findAllTrainers();
}
