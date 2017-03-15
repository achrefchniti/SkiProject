package tn.esprit.beautifulminds.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.beautifulminds.persistence.Staff;
import tn.esprit.beautifulminds.services.crud.StaffServicesRemote;

public class StaffController {

	@FXML
	private TableView<Staff> tabstaff;

	@FXML
	private TableColumn<Staff, String> firstname;

	@FXML
	private TableColumn<Staff, String> lastname;

	@FXML
	private TableColumn<Staff, String> role;

	@FXML
	private TableColumn<Staff, String> gender;

	@FXML
	private TableColumn<Staff, String> nationality;

	@FXML
	private TableColumn<Staff, String> email;

	@FXML
	private TableColumn<Staff, Integer> nbjCAR;

	@FXML
	private TableColumn<Staff, Integer> nbjCMAR;

	public void initialize() {

		try {
			Context context;
			context = new InitialContext();

			StaffServicesRemote staffServicesRemote = (StaffServicesRemote) context.lookup(
					"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");

			ObservableList<Staff> data = FXCollections.observableArrayList(staffServicesRemote.findAllStaffs());

			firstname.setCellValueFactory(new PropertyValueFactory<Staff, String>("firstName"));
			lastname.setCellValueFactory(new PropertyValueFactory<Staff, String>("lastName"));
			role.setCellValueFactory(new PropertyValueFactory<Staff, String>("role"));
			gender.setCellValueFactory(new PropertyValueFactory<Staff, String>("gender"));
			nationality.setCellValueFactory(new PropertyValueFactory<Staff, String>("nationality"));
			email.setCellValueFactory(new PropertyValueFactory<Staff, String>("email"));
			nbjCAR.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("nbjCAR"));
			nbjCMAR.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("nbjCMAR"));

			tabstaff.setItems(data);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private TextField fn;

	@FXML
	private TextField ln;

	@FXML
	private TextField em;

	@FXML
	private TextField pa;

	@FXML
	private TextField ro;

	// @FXML
	// private ComboBox<String> g;

	@FXML
	private TextField na;
	@FXML
	private TextField ge;
	@FXML
	private DatePicker bi;

	@FXML
	private Button add;

	@FXML
	private Button delete;

	@FXML
	private Button update;

	@FXML
	private Button recover;
	// ObservableList<String> ge = FXCollections.observableArrayList("Male",
	// "Female");

	@FXML
	void clickAdd(ActionEvent event) throws NamingException, ParseException {
		Context context = new InitialContext();
		StaffServicesRemote staffServicesRemote = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");

		String firstName = fn.getText();
		String lastName = ln.getText();
		LocalDate d;
		d = bi.getValue();
		String s = d.toString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
		// System.out.println("*********" + s);
		Date birthday = format.parse(s);
		String nationality = na.getText();
		// g = new ComboBox<>();
		// g.getItems().addAll("Male", "Female");
		String gender = ge.getText();
		String email = em.getText();
		String password = pa.getText();
		String role = ro.getText();
		Integer nbjCA = 30;
		Integer nbjCM = 30;
		Integer nbjCAR = 30;
		Integer nbjCMAR = 30;

		Staff st = new Staff();
		st.setFirstName(firstName);
		st.setLastName(lastName);
		st.setBirthday(birthday);
		st.setNationality(nationality);
		st.setGender(gender);
		st.setEmail(email);
		st.setPassword(password);
		st.setRole(role);
		st.setNbjCA(nbjCAR);
		st.setNbjCAR(nbjCAR);
		st.setNbjCM(nbjCMAR);
		st.setNbjCMAR(nbjCMAR);
		staffServicesRemote.addStaff(st);
		JOptionPane.showMessageDialog(null, "Staff added");
	}

	@FXML
	void clickdelete(ActionEvent event) throws NamingException {
		Context context = new InitialContext();
		StaffServicesRemote staffServicesRemote = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");

		staffServicesRemote.deleteStaff(tabstaff.getSelectionModel().getSelectedItem());
		tabstaff.getItems().remove(tabstaff.getSelectionModel().getSelectedItem());

	}

	@FXML
	void clickrecover(ActionEvent event) {
		Staff staff = tabstaff.getSelectionModel().getSelectedItem();
		fn.setText(staff.getFirstName());
		ln.setText(staff.getLastName());
		na.setText(staff.getNationality());
		ge.setText(staff.getGender());
		em.setText(staff.getEmail());
		pa.setText(staff.getPassword());
		ro.setText(staff.getRole());

	}

	@FXML
	void clickupdate(ActionEvent event) throws NamingException {
		Context context = new InitialContext();
		StaffServicesRemote staffServicesRemote = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");

		Staff st = new Staff();
		ObservableList<Staff> staffs;

		staffs = tabstaff.getSelectionModel().getSelectedItems();
		for (Staff staff : staffs) {
			int id = staff.getPersonId();
			st = staffServicesRemote.findStaffById(id);

			st.setFirstName(fn.getText());
			st.setLastName(ln.getText());
			st.setNationality(na.getText());
			st.setGender(ge.getText());
			st.setEmail(em.getText());
			st.setPassword(pa.getText());
			st.setRole(ro.getText());

			staffServicesRemote.updateStaff(st);
		}
		fn.setText("");
		ln.setText("");
		na.setText("");
		ge.setText("");
		em.setText("");

		pa.setText("");

		ro.setText("");

		////////////////////////////////////////
		firstname.setCellValueFactory(new PropertyValueFactory<Staff, String>("firstName"));
		lastname.setCellValueFactory(new PropertyValueFactory<Staff, String>("lastName"));
		role.setCellValueFactory(new PropertyValueFactory<Staff, String>("role"));
		gender.setCellValueFactory(new PropertyValueFactory<Staff, String>("gender"));
		nationality.setCellValueFactory(new PropertyValueFactory<Staff, String>("nationality"));
		email.setCellValueFactory(new PropertyValueFactory<Staff, String>("email"));
		nbjCAR.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("nbjCAR"));
		nbjCMAR.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("nbjCMAR"));
		ObservableList<Staff> data = FXCollections.observableArrayList(staffServicesRemote.findAllStaffs());

		tabstaff.setItems(data);
		staffServicesRemote.updateStaff(st);

	}

	@FXML
	private TextField rech;

	@FXML
	private Button find;

	@FXML
	void clickfind(ActionEvent event) throws NamingException {
		String a = rech.getText();
		Context context = new InitialContext();
		StaffServicesRemote staffServicesRemote = (StaffServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");
		ObservableList<Staff> data = FXCollections.observableArrayList(staffServicesRemote.findStaffByRole(a));

		firstname.setCellValueFactory(new PropertyValueFactory<Staff, String>("firstName"));
		lastname.setCellValueFactory(new PropertyValueFactory<Staff, String>("lastName"));
		role.setCellValueFactory(new PropertyValueFactory<Staff, String>("role"));
		gender.setCellValueFactory(new PropertyValueFactory<Staff, String>("gender"));
		nationality.setCellValueFactory(new PropertyValueFactory<Staff, String>("nationality"));
		email.setCellValueFactory(new PropertyValueFactory<Staff, String>("email"));
		nbjCAR.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("nbjCAR"));
		nbjCMAR.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("nbjCMAR"));

		tabstaff.setItems(data);
		// tabtraining.refresh();

	}
}
