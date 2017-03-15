package tn.esprit.beautifulminds.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GestionController {

	@FXML
	private Button trainingsB;

	@FXML
	private Button staffB;
	@FXML
	private Button holi;
	@FXML
	void clickeventStaffB(ActionEvent event) {
		try {
			Stage stage = new Stage();
			stage.setTitle("Management of the staff");

			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("GestionView2.fxml")));

			stage.setScene(scene);

			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void clickeventTrainingsB(ActionEvent event) {
		try {
			Stage stage = new Stage();
			stage.setTitle("Management of trainings");

			Scene scene;

			scene = new Scene(FXMLLoader.load(getClass().getResource("TrainingView.fxml")));

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void clickholi(ActionEvent event) {
		try {
			Stage stage = new Stage();
			stage.setTitle("Management of holidays");

			Scene scene;

			scene = new Scene(FXMLLoader.load(getClass().getResource("HolidayView.fxml")));

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
