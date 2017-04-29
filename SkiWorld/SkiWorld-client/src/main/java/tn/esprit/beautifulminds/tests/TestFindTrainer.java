package tn.esprit.beautifulminds.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Trainer;
import tn.esprit.beautifulminds.services.crud.TrainerServicesRemote;

public class TestFindTrainer {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TrainerServicesRemote trainerServicesRemote = (TrainerServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/TrainerServices!tn.esprit.beautifulminds.services.crud.TrainerServicesRemote");
		//Trainer trainer2 = trainerServicesRemote.findTrainerById(4);
		
		//System.out.println(trainer2.getCategorie());
	System.out.println(trainerServicesRemote.findTrainerByName("momo"));
	}
}
