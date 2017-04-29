package tn.esprit.beautifulminds.tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Training;
import tn.esprit.beautifulminds.services.crud.TrainingservicesRemote;

public class TestFindAllTraining {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TrainingservicesRemote trainingservicesRemote = (TrainingservicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/Trainingservices!tn.esprit.beautifulminds.services.crud.TrainingservicesRemote");
		List<Training> training = trainingservicesRemote.findAllTrainings();

		for (Training t : training) {
			System.out.println(t);
		}

	}

}
