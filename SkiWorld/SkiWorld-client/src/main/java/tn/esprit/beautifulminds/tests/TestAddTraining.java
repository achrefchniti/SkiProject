package tn.esprit.beautifulminds.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Training;
import tn.esprit.beautifulminds.services.crud.TrainingservicesRemote;

public class TestAddTraining {
	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		TrainingservicesRemote trainingservicesRemote = (TrainingservicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/Trainingservices!tn.esprit.beautifulminds.services.crud.TrainingservicesRemote");

		String name = "League";
		String type = "ICE";
		String categorie = "amateur";
		// Date dateBegin = new Date(System.currentTimeMillis());
		@SuppressWarnings("deprecation")
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date dateBegin = format.parse("12-03-2017");

		Integer hourBegin = 13;
		Integer durationDay = 5;
		Integer durationHour = 1;
		String trainer = "Toto";
		float fees = 3;
		Integer capacity = 20;
		Training t = new Training(name, type, categorie, dateBegin, hourBegin, durationDay, durationHour, trainer, fees,
				capacity);
		trainingservicesRemote.addTraining(t);
	}
}
