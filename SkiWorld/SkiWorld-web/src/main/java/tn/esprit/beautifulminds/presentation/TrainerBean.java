package tn.esprit.beautifulminds.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.beautifulminds.persistence.Trainer;
import tn.esprit.beautifulminds.persistence.Training;
import tn.esprit.beautifulminds.services.crud.TrainerServicesLocal;

@ManagedBean
@ViewScoped
public class TrainerBean {
	@EJB
	private TrainerServicesLocal TrainerLocal;
	private List<Trainer> Trainers = new ArrayList<>();

	public List<Trainer> getTrainers() {
		Trainers = TrainerLocal.findAllTrainers();
		return Trainers;
	}
	public void setTrainers(List<Trainer> trainers) {
		Trainers = trainers;
	}
	Trainer trainer=new Trainer();
public Trainer doFindTrainerByName(String name) {
		
	trainer=TrainerLocal.findTrainerByName(name);
	return trainer;
	}
public Trainer getTrainer() {
	
	return trainer;
}
public void setTrainer(Trainer trainer) {
	this.trainer = trainer;
}

}
