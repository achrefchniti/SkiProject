package tn.esprit.beautifulminds.services.crud;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.beautifulminds.persistence.Trainer;
import tn.esprit.beautifulminds.persistence.Training;

@Local
public interface TrainerServicesLocal {
	Trainer findTrainerByName(String name);
	List<Trainer> findAllTrainers();

}
