package tn.esprit.beautifulminds.gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Trainer;
import tn.esprit.beautifulminds.services.crud.TrainerServicesRemote;

public class TestUpdateTrainer {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TrainerServicesRemote trainerServicesRemote = (TrainerServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/TrainerServices!tn.esprit.beautifulminds.services.crud.TrainerServicesRemote");
		Trainer trainer = trainerServicesRemote.findTrainerById(4);
		trainer.setFirstName("SkiBoard");

		trainerServicesRemote.updateTraining(trainer);

	}
}
