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
import tn.esprit.beautifulminds.persistence.Trainer;
import tn.esprit.beautifulminds.services.crud.TrainerServicesRemote;

public class TrainerController {

	@FXML
	private TableView<Trainer> tabtrainer;

	@FXML
	private TableColumn<Trainer, String> firstName;

	@FXML
	private TableColumn<Trainer, String> ln;

	@FXML
	private TableColumn<Trainer, String> ge;

	@FXML
	private TableColumn<Trainer, String> na;

	@FXML
	private TableColumn<Trainer, String> em;

	@FXML
	private TableColumn<Trainer, Integer> car;

	@FXML
	private TableColumn<Trainer, Integer> cmr;

	@FXML
	private TableColumn<Trainer, String> ex;

	@FXML
	private TableColumn<Trainer, String> de;

	@FXML
	private TableColumn<Trainer, String> cat;

	@FXML
	private Button add;

	@FXML
	private Button delete;

	@FXML
	private Button up;

	@FXML
	private Button re;

	@FXML
	private TextField f;

	@FXML
	private TextField l;

	@FXML
	private TextField g;

	@FXML
	private TextField n;

	@FXML
	private TextField e;

	@FXML
	private TextField p;

	@FXML
	private TextField exp;

	@FXML
	private TextField d;

	@FXML
	private TextField c;

	@FXML
	private DatePicker b;

	public void initialize() throws NamingException {

		Context context = new InitialContext();
		TrainerServicesRemote trainerServicesRemote = (TrainerServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/TrainerServices!tn.esprit.beautifulminds.services.crud.TrainerServicesRemote");
		// List<Trainer> trainer = trainerServicesRemote.findAllTrainers();

		ObservableList<Trainer> data = FXCollections.observableArrayList(trainerServicesRemote.findAllTrainers());

		firstName.setCellValueFactory(new PropertyValueFactory<Trainer, String>("firstName"));
		ln.setCellValueFactory(new PropertyValueFactory<Trainer, String>("lastName"));
		ge.setCellValueFactory(new PropertyValueFactory<Trainer, String>("gender"));
		na.setCellValueFactory(new PropertyValueFactory<Trainer, String>("nationality"));
		em.setCellValueFactory(new PropertyValueFactory<Trainer, String>("email"));
		car.setCellValueFactory(new PropertyValueFactory<Trainer, Integer>("nbjCAR"));
		cmr.setCellValueFactory(new PropertyValueFactory<Trainer, Integer>("nbjCMAR"));
		ex.setCellValueFactory(new PropertyValueFactory<Trainer, String>("experience"));
		de.setCellValueFactory(new PropertyValueFactory<Trainer, String>("description"));
		cat.setCellValueFactory(new PropertyValueFactory<Trainer, String>("categorie"));
		tabtrainer.setItems(data);

	}

	@FXML
	void clickadd(ActionEvent event) throws NamingException, ParseException {
		Context context = new InitialContext();
		TrainerServicesRemote trainerServicesRemote = (TrainerServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/TrainerServices!tn.esprit.beautifulminds.services.crud.TrainerServicesRemote");

		String firstName = f.getText();
		String lastName = l.getText();
		LocalDate z;
		z = b.getValue();
		String s = z.toString();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
		// System.out.println("*********" + s);
		Date birthday = format.parse(s);
		String nationality = n.getText();
		// g = new ComboBox<>();
		// g.getItems().addAll("Male", "Female");
		String gender = g.getText();
		String email = e.getText();
		String password = p.getText();
		String role = "trainer";
		Integer nbjCA = 30;
		Integer nbjCM = 30;
		Integer nbjCAR = 30;
		Integer nbjCMAR = 30;
		String experience = exp.getText();
		String description = d.getText();
		String categorie = c.getText();

		Trainer st = new Trainer();
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
		st.setExperince(experience);
		st.setDescription(description);
		st.setCategorie(categorie);
		trainerServicesRemote.addTrainer(st);
		JOptionPane.showMessageDialog(null, "Trainer added");

	}

	@FXML
	void clickdelete(ActionEvent event) throws NamingException {
		Context context = new InitialContext();
		TrainerServicesRemote trainerServicesRemote = (TrainerServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/TrainerServices!tn.esprit.beautifulminds.services.crud.TrainerServicesRemote");

		trainerServicesRemote.deleteTraining(tabtrainer.getSelectionModel().getSelectedItem());
		tabtrainer.getItems().remove(tabtrainer.getSelectionModel().getSelectedItem());

	}

	@FXML
	void clickre(ActionEvent event) {
		Trainer tr = tabtrainer.getSelectionModel().getSelectedItem();
		f.setText(tr.getFirstName());
		l.setText(tr.getLastName());
		n.setText(tr.getNationality());
		g.setText(tr.getGender());
		e.setText(tr.getEmail());
		p.setText(tr.getPassword());
		exp.setText(tr.getExperience());
		d.setText(tr.getDescription());
		c.setText(tr.getCategorie());
	}

	@FXML
	void clickup(ActionEvent event) throws NamingException {
		Context context = new InitialContext();
		TrainerServicesRemote trainerServicesRemote = (TrainerServicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/TrainerServices!tn.esprit.beautifulminds.services.crud.TrainerServicesRemote");

		Trainer st = new Trainer();
		ObservableList<Trainer> staffs;

		staffs = tabtrainer.getSelectionModel().getSelectedItems();
		for (Trainer staff : staffs) {
			int id = staff.getPersonId();
			st = trainerServicesRemote.findTrainerById(id);

			st.setFirstName(f.getText());
			st.setLastName(l.getText());
			st.setNationality(n.getText());
			st.setGender(g.getText());
			st.setEmail(e.getText());
			st.setPassword(p.getText());
			st.setExperince(exp.getText());
			st.setDescription(d.getText());
			st.setCategorie(c.getText());
			trainerServicesRemote.updateTraining(st);
		}
		f.setText("");
		l.setText("");
		n.setText("");
		g.setText("");
		e.setText("");
		p.setText("");
		exp.setText("");
		d.setText("");
		c.setText("");

		////////////////////////////////////////
		firstName.setCellValueFactory(new PropertyValueFactory<Trainer, String>("firstName"));
		ln.setCellValueFactory(new PropertyValueFactory<Trainer, String>("lastName"));
		ge.setCellValueFactory(new PropertyValueFactory<Trainer, String>("gender"));
		na.setCellValueFactory(new PropertyValueFactory<Trainer, String>("nationality"));
		em.setCellValueFactory(new PropertyValueFactory<Trainer, String>("email"));
		car.setCellValueFactory(new PropertyValueFactory<Trainer, Integer>("nbjCAR"));
		cmr.setCellValueFactory(new PropertyValueFactory<Trainer, Integer>("nbjCMAR"));
		ex.setCellValueFactory(new PropertyValueFactory<Trainer, String>("experience"));
		de.setCellValueFactory(new PropertyValueFactory<Trainer, String>("description"));
		cat.setCellValueFactory(new PropertyValueFactory<Trainer, String>("categorie"));
		ObservableList<Trainer> data = FXCollections.observableArrayList(trainerServicesRemote.findAllTrainers());

		tabtrainer.setItems(data);
		trainerServicesRemote.updateTraining(st);

	}

}
