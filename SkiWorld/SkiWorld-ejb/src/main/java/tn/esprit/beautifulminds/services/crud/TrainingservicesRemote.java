package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Training;

@Remote
public interface TrainingservicesRemote {
	void addTraining(Training training);

	Training findTrainingById(Integer idPerson);

	void deleteTraining(Training training);

	void updateTraining(Training training);

	List<Training> findAllTrainings();

	Training findTrainingsByType(String type);

	Training findTrainingsByName(String name);

	List<Training> findTrainingsByType2(String type);

	public void getCap(Training training);
public Integer capa(Training training);
	public float getFees(Training tr);
}
