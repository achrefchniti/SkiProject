package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.beautifulminds.persistence.Training;

@Local
public interface TrainingservicesLocal {
	List<Training> findAllTrainings();

	public void getCap(Training training);

	void updateTraining(Training training);

	Training findTrainingsByName(String name);

	Training findTrainingById(Integer idPerson);

	public float getFees(Training tr);
	public Integer capa(Training training);

}
