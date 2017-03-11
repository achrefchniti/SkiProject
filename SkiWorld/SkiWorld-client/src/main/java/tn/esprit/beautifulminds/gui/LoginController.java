package tn.esprit.beautifulminds.gui;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.beautifulminds.persistence.Admin;
import tn.esprit.beautifulminds.services.other.LoginServiceRemote;

public class LoginController {

	@FXML
	private TextField emailtext;
	@FXML
	private TextField pwdtext;
	@FXML
	private Button signin;

	@FXML
	public void login(ActionEvent event) throws IOException, NamingException {

		Context context = new InitialContext();
		String email = emailtext.getText();
		String password = pwdtext.getText();

		LoginServiceRemote lsr = (LoginServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/LoginService!tn.esprit.beautifulminds.services.other.LoginServiceRemote");
		Admin admin = new Admin();
		System.out.println("email=" + email);
		admin.setEmail(email);
		System.out.println("password" + password);
		admin.setPassword(password);

		if (lsr.isAuthentified(email, password)) {
			System.out.println("logged in...");
			Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));

			Scene scene = new Scene(root);

			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

		} else

		{
			System.out.println("Error...");
		}
	}
}
