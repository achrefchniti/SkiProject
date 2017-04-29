package tn.esprit.beautifulminds.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Training;
import tn.esprit.beautifulminds.persistence.User;
import tn.esprit.beautifulminds.services.crud.TrainingservicesRemote;
import tn.esprit.beautifulminds.services.crud.UserServicesRemote;

public class Testtraining {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TrainingservicesRemote trainingservicesRemote = (TrainingservicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/Trainingservices!tn.esprit.beautifulminds.services.crud.TrainingservicesRemote");
		Training training = trainingservicesRemote.findTrainingById(1);

		System.out.println(trainingservicesRemote.getFees(training));
	}
}
