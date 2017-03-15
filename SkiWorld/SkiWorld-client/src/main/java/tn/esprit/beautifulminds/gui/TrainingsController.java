package tn.esprit.beautifulminds.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
import tn.esprit.beautifulminds.persistence.Training;
import tn.esprit.beautifulminds.services.crud.TrainingservicesRemote;

public class TrainingsController {
	@FXML
	private Button addB;

	@FXML
	private TableView<Training> tabtraining;

	@FXML
	private TableColumn<Training, String> name;

	@FXML
	private TableColumn<Training, Integer> capacity;

	@FXML
	private TableColumn<Training, String> categorie;

	@FXML
	private TableColumn<Training, Date> dateBegin;

	@FXML
	private TableColumn<Training, Integer> durationDay;

	@FXML
	private TableColumn<Training, Integer> durationHour;

	@FXML
	private TableColumn<Training, Float> fees;

	@FXML
	private TableColumn<Training, Integer> hourBegin;

	@FXML
	private TableColumn<Training, String> trainer;

	@FXML
	private TableColumn<Training, String> type;
	@FXML
	private TextField na;

	@FXML
	private TextField cap;

	@FXML
	private TextField cat;

	@FXML
	private TextField hb;

	@FXML
	private TextField dd;

	@FXML
	private TextField dh;

	@FXML
	private TextField fe;

	@FXML
	private TextField tr;

	@FXML
	private TextField ty;
	@FXML
	private DatePicker date;

	public void initialize() {

		try {
			Context context;
			context = new InitialContext();

			TrainingservicesRemote trainingservicesRemote = (TrainingservicesRemote) context.lookup(
					"/projet-personnel-ear/projet-personnel-ejb/Trainingservices!tn.esprit.beautifulminds.services.crud.TrainingservicesRemote");
			// List<Training> T = trainingservicesRemote.findAllTrainings();

			ObservableList<Training> data = FXCollections
					.observableArrayList(trainingservicesRemote.findAllTrainings());

			name.setCellValueFactory(new PropertyValueFactory<Training, String>("name"));
			capacity.setCellValueFactory(new PropertyValueFactory<Training, Integer>("capacity"));
			categorie.setCellValueFactory(new PropertyValueFactory<Training, String>("categorie"));
			dateBegin.setCellValueFactory(new PropertyValueFactory<Training, Date>("dateBegin"));
			durationDay.setCellValueFactory(new PropertyValueFactory<Training, Integer>("durationDay"));
			durationHour.setCellValueFactory(new PropertyValueFactory<Training, Integer>("durationHour"));
			fees.setCellValueFactory(new PropertyValueFactory<Training, Float>("fees"));
			hourBegin.setCellValueFactory(new PropertyValueFactory<Training, Integer>("hourBegin"));
			trainer.setCellValueFactory(new PropertyValueFactory<Training, String>("trainer"));
			type.setCellValueFactory(new PropertyValueFactory<Training, String>("type"));

			tabtraining.setItems(data);
			// tabtraining.refresh();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void clickbuttonB(ActionEvent event) throws ParseException, NamingException {
		Context context;
		
			context = new InitialContext();

			TrainingservicesRemote trainingservicesRemote = (TrainingservicesRemote) context.lookup(
					"/projet-personnel-ear/projet-personnel-ejb/Trainingservices!tn.esprit.beautifulminds.services.crud.TrainingservicesRemote");
			String name = na.getText();
			Integer capacity = Integer.parseInt(cap.getText());
			String categorie = cat.getText();

			// date.setValue(LocalDate.now());
			// date.setShowWeekNumbers(true);
			LocalDate d;
			d = date.getValue();
			String s = d.toString();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
			// System.out.println("*********" + s);
			Date dateBegin = format.parse(s);
			// System.out.println("*********" + dateBegin);
			// Integer station = Integer.parseInt(st.getText());
			Integer durationDay = Integer.parseInt(dd.getText());
			Integer durationHour = Integer.parseInt(dh.getText());
			Float fees = Float.parseFloat(fe.getText());
			Integer hourBegin = Integer.parseInt(hb.getText());
			String trainer = tr.getText();
			String type = ty.getText();

			Training T = new Training();
			T.setName(name);
			T.setType(type);
			T.setCategorie(categorie);
			T.setDateBegin(dateBegin);
			T.setHourBegin(hourBegin);
			T.setDurationDay(durationDay);
			T.setDurationHour(durationHour);
			T.setTrainer(trainer);
			T.setFees(fees);
			T.setCapacity(capacity);
			trainingservicesRemote.addTraining(T);
		
		//JOptionPane.showMessageDialog(null, "lesson added");
		

	}

	@FXML
	private Button delete;

	@FXML
	void clickDelete(ActionEvent event) throws NamingException {
		Context context = new InitialContext();
		TrainingservicesRemote trainingservicesRemote = (TrainingservicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/Trainingservices!tn.esprit.beautifulminds.services.crud.TrainingservicesRemote");
		trainingservicesRemote.deleteTraining(tabtraining.getSelectionModel().getSelectedItem());
		tabtraining.getItems().remove(tabtraining.getSelectionModel().getSelectedItem());
	}

	@FXML
	private Button up;

	@FXML
	void clickUp(ActionEvent event) throws NamingException {
		// Context context = new InitialContext();
		// TrainingservicesRemote trainingservicesRemote =
		// (TrainingservicesRemote) context.lookup(
		// "projet-personnel-ear/projet-personnel-ejb/Trainingservices!tn.esprit.beautifulminds.services.crud.TrainingservicesRemote");

		Training training = tabtraining.getSelectionModel().getSelectedItem();
		na.setText(training.getName());
		cap.setText("" + training.getCapacity());

		cat.setText(training.getCategorie());

		// date.setValue(training.getDateBegin());
		hb.setText("" + training.getHourBegin());
		dd.setText("" + training.getDurationDay());

		dh.setText("" + training.getDurationHour());
		;

		fe.setText("" + training.getFees());

		tr.setText(training.getTrainer());

		ty.setText(training.getType());

	}

	@FXML
	private Button upp;

	@FXML
	void clickupp(ActionEvent event) throws NamingException, ParseException {
		Context context = new InitialContext();
		TrainingservicesRemote trainingservicesRemote = (TrainingservicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/Trainingservices!tn.esprit.beautifulminds.services.crud.TrainingservicesRemote");

		Training T = new Training();

		ObservableList<Training> trainings;

		trainings = tabtraining.getSelectionModel().getSelectedItems();
		for (Training train : trainings) {
			int id = train.getIdTraining();
			T = trainingservicesRemote.findTrainingById(id);

			T.setName(na.getText());
			T.setCapacity(Integer.parseInt(cap.getText()));
			T.setCategorie(cat.getText());
			// Date dateBegin=h.setDateBegin(dateBegin);
			LocalDate d;
			d = date.getValue();
			String s = d.toString();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
			// System.out.println("*********" + s);
			Date dateBegin = format.parse(s);
			T.setDateBegin(dateBegin);
			T.setHourBegin(Integer.parseInt(hb.getText()));
			T.setDurationDay(Integer.parseInt(dd.getText()));
			T.setDurationHour(Integer.parseInt(dh.getText()));
			T.setFees(Float.parseFloat(fe.getText()));
			T.setTrainer(tr.getText());
			T.setType(ty.getText());

			trainingservicesRemote.updateTraining(T);
		}
		na.setText("");
		cap.setText("");

		cat.setText("");

		hb.setText("");
		dd.setText("");

		dh.setText("");

		fe.setText("");
		tr.setText("");

		ty.setText("");
		////////////////////////////////////////
		name.setCellValueFactory(new PropertyValueFactory<Training, String>("name"));
		capacity.setCellValueFactory(new PropertyValueFactory<Training, Integer>("capacity"));
		categorie.setCellValueFactory(new PropertyValueFactory<Training, String>("categorie"));
		dateBegin.setCellValueFactory(new PropertyValueFactory<Training, Date>("dateBegin"));
		durationDay.setCellValueFactory(new PropertyValueFactory<Training, Integer>("durationDay"));
		durationHour.setCellValueFactory(new PropertyValueFactory<Training, Integer>("durationHour"));
		fees.setCellValueFactory(new PropertyValueFactory<Training, Float>("fees"));
		hourBegin.setCellValueFactory(new PropertyValueFactory<Training, Integer>("hourBegin"));
		trainer.setCellValueFactory(new PropertyValueFactory<Training, String>("trainer"));
		type.setCellValueFactory(new PropertyValueFactory<Training, String>("type"));
		ObservableList<Training> data = FXCollections.observableArrayList(trainingservicesRemote.findAllTrainings());

		tabtraining.setItems(data);
		trainingservicesRemote.updateTraining(T);
	}

	@FXML
	private TextField rech;

	@FXML
	private Button find;

	@FXML
	void clickfind(ActionEvent event) throws NamingException {
		String a = rech.getText();
		Context context = new InitialContext();
		TrainingservicesRemote trainingservicesRemote = (TrainingservicesRemote) context.lookup(
				"projet-personnel-ear/projet-personnel-ejb/Trainingservices!tn.esprit.beautifulminds.services.crud.TrainingservicesRemote");
		ObservableList<Training> data = FXCollections
				.observableArrayList(trainingservicesRemote.findTrainingsByType2(a));

		name.setCellValueFactory(new PropertyValueFactory<Training, String>("name"));
		capacity.setCellValueFactory(new PropertyValueFactory<Training, Integer>("capacity"));
		categorie.setCellValueFactory(new PropertyValueFactory<Training, String>("categorie"));
		dateBegin.setCellValueFactory(new PropertyValueFactory<Training, Date>("dateBegin"));
		durationDay.setCellValueFactory(new PropertyValueFactory<Training, Integer>("durationDay"));
		durationHour.setCellValueFactory(new PropertyValueFactory<Training, Integer>("durationHour"));
		fees.setCellValueFactory(new PropertyValueFactory<Training, Float>("fees"));
		hourBegin.setCellValueFactory(new PropertyValueFactory<Training, Integer>("hourBegin"));
		trainer.setCellValueFactory(new PropertyValueFactory<Training, String>("trainer"));
		type.setCellValueFactory(new PropertyValueFactory<Training, String>("type"));

		tabtraining.setItems(data);
		// tabtraining.refresh();

	}

}
