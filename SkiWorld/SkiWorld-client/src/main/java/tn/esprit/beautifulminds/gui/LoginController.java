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
import tn.esprit.beautifulminds.persistence.Staff;
import tn.esprit.beautifulminds.services.crud.StaffServicesRemote;
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
		StaffServicesRemote ssr = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");

		Admin admin = new Admin();
		System.out.println("email=" + email);
		admin.setEmail(email);
		System.out.println("password" + password);
		admin.setPassword(password);

		if (lsr.isAuthentified(email, password).equals("Admin")) {

			System.out.println("logged in...");
			Parent root = FXMLLoader.load(getClass().getResource("GestionViewAdmin.fxml"));

			Scene scene = new Scene(root);

			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

		} else if (lsr.isAuthentified(email, password).equals("Manager")) {

			Staff staff = new Staff();

			staff.setEmail(email);
			staff.setPassword(password);

			System.out.println("role" + staff.getRole());
			Parent root = FXMLLoader.load(getClass().getResource("GestionViewManager.fxml"));

			Scene scene = new Scene(root);

			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} else

		{
			System.out.println("Error...");
		}
	}
	  @FXML
	    private Button pers;

	    @FXML
	    void clickpers(ActionEvent event) throws IOException {
	    	Stage stage = new Stage();
			stage.setTitle("Mon Compte");

			Scene scene;
			scene = new Scene(FXMLLoader.load(getClass().getResource("Authent.fxml")));

			stage.setScene(scene);
			stage.show();
	    }
}
