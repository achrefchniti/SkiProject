package tn.esprit.beautifulminds.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GestionManagerController {
	
	
	@FXML
	private Button trainings;


	@FXML
	private Button staffs;

	@FXML
	private Button trainers;

	@FXML
	void holidaysAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("HolidayView.fxml"));

		Scene scene = new Scene(root);

		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	void staffsAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("StaffView2.fxml"));

		Scene scene = new Scene(root);

		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	void trainingsAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("TrainingView.fxml"));

		Scene scene = new Scene(root);

		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	void trainersAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("TrainerView.fxml"));

		Scene scene = new Scene(root);

		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();

	}
	 

}
