package tn.esprit.beautifulminds.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.beautifulminds.persistence.Person;
import tn.esprit.beautifulminds.persistence.Staff;
import tn.esprit.beautifulminds.services.crud.StaffServicesRemote;

public class ManagerController implements Initializable {

	@FXML
	private Button addManager;

	@FXML
	private Button deleteManager;

	@FXML
	private TextField firstname;

	@FXML
	private TextField lastname;

	@FXML
	private TextField nationality;

	@FXML
	private TextField email;

	@FXML
	private TextField station;

	@FXML
	private TextField role;

	@FXML
	private TableView<Person> tableView1;

	@FXML
	private TableColumn<Person, String> cc1;

	@FXML
	private TableColumn<Person, String> cc2;

	@FXML
	private TableColumn<Person, String> cc3;

	@FXML
	private TableColumn<Person, String> cc4;

	@FXML
	private TableColumn<Person, String> cc5;

	@FXML
	private Label labelsaisie1;

	@FXML
	private Button updateStaff;

	@FXML
	private Button cancel;

	@FXML
	private Button update;

	ObservableList<Person> data;

	Context context;

	public static Staff up = new Staff();

	@FXML
	void addAction1(ActionEvent event) throws NamingException {

		Context context = new InitialContext();
		StaffServicesRemote proxy = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");
		Staff s = new Staff();

		s.setFirstName(firstname.getText());
		s.setLastName(lastname.getText());
		s.setNationality(nationality.getText());
		s.setEmail(email.getText());
		s.setRole(role.getText());

		// if((address.getText()!="")&& (firstN.getText()!="")&&
		// (lastN.getText()!="")&&(mail.getText()!="")&&(phoneN.getText()!="" )
		// )
		if (!(firstname.getText().equals(new String(""))) && !(lastname.getText().equals(new String("")))
				&& (email.getText().contains("@")) && !(email.getText().equals(new String("")))
				&& !(nationality.getText().equals(new String(""))) && !(role.getText().equals(new String("")))) {
			proxy.addStaff(s);

			firstname.setText("");
			lastname.setText("");
			nationality.setText("");
			role.setText("");
			email.setText("");

			List<Staff> us;
			us = proxy.afficheStaff();
			data = FXCollections.observableArrayList(us);
			cc1.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
			cc2.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
			cc3.setCellValueFactory(new PropertyValueFactory<Person, String>("nationality"));
			cc4.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
			cc5.setCellValueFactory(new PropertyValueFactory<Person, String>("role"));
			tableView1.setItems(data);

		} else {
			labelsaisie1.setText("Check the data entry fields");
		}
		List<Staff> us;

		context = new InitialContext();
		StaffServicesRemote proxy2 = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");
		us = proxy2.afficheStaff();
		data = FXCollections.observableArrayList(us);
		cc1.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		cc2.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		cc3.setCellValueFactory(new PropertyValueFactory<Person, String>("nationality"));
		cc4.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		cc5.setCellValueFactory(new PropertyValueFactory<Person, String>("role"));
		tableView1.setItems(data);

	}

	@FXML
	void deleteAction1(ActionEvent event) throws NamingException {

		Staff u = new Staff();
		int ii = tableView1.getSelectionModel().getSelectedItem().getPersonId();
		u.setPersonId(ii);

		context = new InitialContext();
		StaffServicesRemote proxy = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");
		proxy.deleteStaff(u);

		List<Staff> us;

		StaffServicesRemote proxy2 = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");
		us = proxy2.afficheStaff();
		data = FXCollections.observableArrayList(us);
		cc1.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		cc2.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		cc3.setCellValueFactory(new PropertyValueFactory<Person, String>("nationality"));
		cc4.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		cc5.setCellValueFactory(new PropertyValueFactory<Person, String>("role"));
		tableView1.setItems(data);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateStaff.setVisible(true);
		addManager.setVisible(true);
		cancel.setVisible(false);
		update.setVisible(false);

		List<Staff> us;

		try {
			context = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StaffServicesRemote proxy2;
		try {
			proxy2 = (StaffServicesRemote) context.lookup(
					"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");

			us = proxy2.findAllStaffs();
			data = FXCollections.observableArrayList(us);
			cc1.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
			cc2.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
			cc3.setCellValueFactory(new PropertyValueFactory<Person, String>("nationality"));
			cc4.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
			cc5.setCellValueFactory(new PropertyValueFactory<Person, String>("role"));
			tableView1.setItems(data);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void update(ActionEvent event) throws NamingException {
		context = new InitialContext();
		StaffServicesRemote proxy = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");

		up.setFirstName(firstname.getText());
		up.setLastName(lastname.getText());
		up.setNationality(nationality.getText());
		up.setRole(role.getText());
		up.setEmail(email.getText());

		proxy.updateStaff(up);

		firstname.setText("");
		lastname.setText("");
		nationality.setText("");
		role.setText("");
		email.setText("");

		updateStaff.setVisible(true);
		addManager.setVisible(true);
		cancel.setVisible(false);
		update.setVisible(false);

	}

	@FXML
	void cancel(ActionEvent event) throws NamingException {

		firstname.setText("");
		lastname.setText("");
		nationality.setText("");
		role.setText("");
		email.setText("");

		updateStaff.setVisible(true);
		addManager.setVisible(true);
		cancel.setVisible(false);
		update.setVisible(false);

	}

	@FXML
	void updateStaff(ActionEvent event) throws NamingException {

		context = new InitialContext();
		StaffServicesRemote proxy = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");

		int ii = tableView1.getSelectionModel().getSelectedItem().getPersonId();
		up = proxy.findStaffById(ii);

		firstname.setText(up.getFirstName());
		lastname.setText(up.getLastName());
		nationality.setText(up.getNationality());
		role.setText(up.getRole());
		email.setText(up.getEmail());

		System.out.println("-------" + up.getFirstName());

		updateStaff.setVisible(false);
		addManager.setVisible(false);
		cancel.setVisible(true);
		update.setVisible(true);

		List<Staff> us;

		StaffServicesRemote proxy2 = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");
		us = proxy2.afficheStaff();
		data = FXCollections.observableArrayList(us);
		cc1.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		cc2.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		cc3.setCellValueFactory(new PropertyValueFactory<Person, String>("nationality"));
		cc4.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		cc5.setCellValueFactory(new PropertyValueFactory<Person, String>("role"));
		tableView1.setItems(data);

	}

}
