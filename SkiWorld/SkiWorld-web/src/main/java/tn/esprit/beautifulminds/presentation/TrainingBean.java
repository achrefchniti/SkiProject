package tn.esprit.beautifulminds.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import tn.esprit.beautifulminds.persistence.Trainer;
import tn.esprit.beautifulminds.persistence.Training;
import tn.esprit.beautifulminds.persistence.User;
import tn.esprit.beautifulminds.services.crud.TrainerServicesLocal;
import tn.esprit.beautifulminds.services.crud.TrainingservicesLocal;
import tn.esprit.beautifulminds.services.crud.UserServicesLocal;

@ManagedBean
@SessionScoped
public class TrainingBean {
	@EJB
	private TrainingservicesLocal TrainingLocal;
	@EJB
	private TrainerServicesLocal TrainerLocal;
	@EJB
	private UserServicesLocal UserLocal;
	private List<Training> Trainings = new ArrayList<>();
	private Boolean formVisibility = false;

	private Training trainingSelected = new Training();
	private Training trainingins = new Training();

	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	Trainer trainer = new Trainer();

	public void doSomme() {
		
	}

	public void onRowSelect(SelectEvent event) {
		

	}

	public void onRowUnselect(UnselectEvent event) {
		
	}

	public void payer() {
		
	}

	

	public Training getTrainingins() {
		return trainingins;
	}

	public void setTrainingins(Training trainingins) {
		this.trainingins = trainingins;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public void changeVisibility() {
		formVisibility = true;
	}

	public Boolean getFormVisibility() {
		return formVisibility;
	}

	public void setFormVisibility(Boolean formVisibility) {
		this.formVisibility = formVisibility;
	}

	public List<Training> getTrainings() {
		Trainings = TrainingLocal.findAllTrainings();
		return Trainings;
	}

	public void setTrainings(List<Training> Trainings) {
		this.Trainings = Trainings;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Training doFindTrainingByName(String name) {
		return TrainingLocal.findTrainingsByName(name);
	}

	public Training getTrainingSelected() {
		return trainingSelected;
	}

	public void setTrainingSelected(Training trainingSelected) {
		this.trainingSelected = trainingSelected;
	}

}
