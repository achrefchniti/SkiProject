package tn.esprit.beautifulminds.gui;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Trainer;
import tn.esprit.beautifulminds.services.crud.TrainerServicesRemote;

public class TestAddTrainer {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TrainerServicesRemote trainerServicesRemote = (TrainerServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/TrainerServices!tn.esprit.beautifulminds.services.crud.TrainerServicesRemote");

		String firstName = "snake";
		String lastName = "shark";
		@SuppressWarnings("deprecation")
		Date birthday = new Date(85, 02, 03);
		String nationality = "tunisienne";
		String gender = "male";
		String email = "snake@gmail.com";
		String password = "snake";
		String role = "entreneur glisse";
		Integer nbjT = 30;
		Integer nbjR = 12;
		String expirence = "trois ans de travail dans differents stations";
		String description = "jeune tunisien";
		String categorie = "entreneur des amateurs";
		Integer ratingPoints = null;
		Trainer tr = new Trainer(firstName, lastName, birthday, nationality, gender, email, password, role, nbjT, nbjR,
				expirence, description, categorie, ratingPoints);
		trainerServicesRemote.addTrainer(tr);
	}
}
