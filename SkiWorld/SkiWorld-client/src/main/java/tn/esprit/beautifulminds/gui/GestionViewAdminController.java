package tn.esprit.beautifulminds.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GestionViewAdminController {

    @FXML
    private Button stationsbtn;

    @FXML
    private Button applicationsbtn;

    @FXML
    private Button feedbacksbtn;

    @FXML
    private Button managersbtn;

    @FXML
    private Button holidaysbtn;

    @FXML
    void applicationsAction(ActionEvent event) {
    		
    }

    @FXML
    void feedbacksAction(ActionEvent event) {

    }

    @FXML
    void holidaysAction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("HolidayView.fxml"));

		Scene scene = new Scene(root);

		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void managersAction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));

		Scene scene = new Scene(root);

		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void stationsAction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Station.fxml"));

		Scene scene = new Scene(root);

		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
    }

}
