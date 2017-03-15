package tn.esprit.beautifulminds.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthController {
	private static Integer id11;
	@FXML
	private TextField id;

	@FXML
	private Button ok;

	@FXML
	void clickok(ActionEvent event) {
		
		id11 = Integer.parseInt(id.getText());
		try {
			Stage stage = new Stage();
			stage.setTitle("Mon Compte");

			Scene scene;
			scene = new Scene(FXMLLoader.load(getClass().getResource("PersonalIneterfaceView.fxml")));

			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Integer getId11() {
		return id11;
	}

}
