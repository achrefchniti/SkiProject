package tn.esprit.beautifulminds.gui;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.gui.SendMailSSL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.beautifulminds.persistence.Feedback;
import tn.esprit.beautifulminds.persistence.User;
import tn.esprit.beautifulminds.services.crud.FeedbackServiceRemote;

public class FeedbacksController {

	@FXML
	private TableColumn<Feedback, User> user1;

	@FXML
	private javafx.scene.control.TextArea replytxt;

	@FXML
	private TableColumn<Feedback, Integer> feedbackId1;

	@FXML
	private Button cancelbtn;

	@FXML
	private TableColumn<Feedback, Date> date1;

	@FXML
	private TableColumn<Feedback, String> status1;

	@FXML
	private TableView<Feedback> table1;

	@FXML
	private TableColumn<Feedback, String> content1;

	@FXML
	private Button sendbtn;

	@FXML
	private TableColumn<Feedback, Date> date;

	@FXML
	private Button acceptbtn;

	@FXML
	private TextField searchtxt;

	@FXML
	private TableColumn<Feedback, Integer> feedbackId;

	@FXML
	private Button searchbtn;

	@FXML
	private Button rejectbtn;

	@FXML
	private ComboBox<Label> datecbx;

	@FXML
	private ComboBox<Label> statuscbx;

	@FXML
	private TableColumn<Feedback, User> user;

	@FXML
	private TableView<Feedback> table;

	@FXML
	private TableColumn<Feedback, String> content;

	@FXML
	private TableColumn<Feedback, String> status;

	@FXML
	void searchAction(ActionEvent event) throws NamingException, IOException {
		Context context = new InitialContext();
		FeedbackServiceRemote asr = (FeedbackServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/FeedbackService!tn.esprit.beautifulminds.services.crud.FeedbackServiceRemote");
		String keyword = searchtxt.getText();
		ObservableList<Feedback> allfeedbacks = FXCollections
				.observableArrayList(asr.retrieveFeedbackByKeyword(keyword));

		feedbackId.setCellValueFactory(new PropertyValueFactory<Feedback, Integer>("feedbackId"));
		user.setCellValueFactory(new PropertyValueFactory<Feedback, User>("user"));
		status.setCellValueFactory(new PropertyValueFactory<Feedback, String>("status"));
		date.setCellValueFactory(new PropertyValueFactory<Feedback, Date>("date"));
		content.setCellValueFactory(new PropertyValueFactory<Feedback, String>("content"));

		feedbackId.setVisible(false);
		table.setItems(allfeedbacks);
	}

	@FXML
	void acceptAction(ActionEvent event) throws NamingException {
		Feedback feedback = table.getSelectionModel().getSelectedItem();
		feedback.setStatus("Accepted");
		Context context = new InitialContext();
		FeedbackServiceRemote asr = (FeedbackServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/FeedbackService!tn.esprit.beautifulminds.services.crud.FeedbackServiceRemote");
		asr.updateFeedback(feedback);
		this.initialize();

	}

	@FXML
	void rejectAction(ActionEvent event) throws NamingException {
		Feedback feedback = table.getSelectionModel().getSelectedItem();
		feedback.setStatus("Rejected");
		Context context = new InitialContext();
		FeedbackServiceRemote asr = (FeedbackServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/FeedbackService!tn.esprit.beautifulminds.services.crud.FeedbackServiceRemote");
		asr.updateFeedback(feedback);
		this.initialize();
	}

	@FXML
	void selectedDate(ActionEvent event) throws NamingException, ParseException {
		Context context = new InitialContext();
		FeedbackServiceRemote asr = (FeedbackServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/FeedbackService!tn.esprit.beautifulminds.services.crud.FeedbackServiceRemote");

		String selected = datecbx.getSelectionModel().getSelectedItem().getText();
		System.out.println(selected);
		ObservableList<Feedback> allfeedbacks;
		if (selected.equals("All")) {
			allfeedbacks = FXCollections.observableArrayList(asr.retrieveAllFeedbacks());

			feedbackId.setCellValueFactory(new PropertyValueFactory<Feedback, Integer>("feedbackId"));
			user.setCellValueFactory(new PropertyValueFactory<Feedback, User>("user"));
			status.setCellValueFactory(new PropertyValueFactory<Feedback, String>("status"));
			date.setCellValueFactory(new PropertyValueFactory<Feedback, Date>("date"));
			content.setCellValueFactory(new PropertyValueFactory<Feedback, String>("content"));

		} else {
			allfeedbacks = FXCollections.observableArrayList(asr.retrieveFeedbacksByDate(selected));

			feedbackId.setCellValueFactory(new PropertyValueFactory<Feedback, Integer>("feedbackId"));
			user.setCellValueFactory(new PropertyValueFactory<Feedback, User>("user"));
			status.setCellValueFactory(new PropertyValueFactory<Feedback, String>("status"));
			date.setCellValueFactory(new PropertyValueFactory<Feedback, Date>("date"));
			content.setCellValueFactory(new PropertyValueFactory<Feedback, String>("content"));

		}
		feedbackId.setVisible(false);
		table.setItems(allfeedbacks);
		initializeCombobox();

	}

	@FXML
	void selectedStatus(ActionEvent event) throws NamingException {

		Context context = new InitialContext();
		FeedbackServiceRemote asr = (FeedbackServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/FeedbackService!tn.esprit.beautifulminds.services.crud.FeedbackServiceRemote");

		String selected = statuscbx.getSelectionModel().getSelectedItem().getText();
		System.out.println(selected);
		ObservableList<Feedback> allfeedbacks;
		if (selected.equals("All")) {
			allfeedbacks = FXCollections.observableArrayList(asr.retrieveAllFeedbacks());

			feedbackId.setCellValueFactory(new PropertyValueFactory<Feedback, Integer>("feedbackId"));
			user.setCellValueFactory(new PropertyValueFactory<Feedback, User>("user"));
			status.setCellValueFactory(new PropertyValueFactory<Feedback, String>("status"));
			date.setCellValueFactory(new PropertyValueFactory<Feedback, Date>("date"));
			content.setCellValueFactory(new PropertyValueFactory<Feedback, String>("content"));

		} else {
			allfeedbacks = FXCollections.observableArrayList(asr.retrieveFeedbacksByStatus(selected));

			feedbackId.setCellValueFactory(new PropertyValueFactory<Feedback, Integer>("feedbackId"));
			user.setCellValueFactory(new PropertyValueFactory<Feedback, User>("user"));
			status.setCellValueFactory(new PropertyValueFactory<Feedback, String>("status"));
			date.setCellValueFactory(new PropertyValueFactory<Feedback, Date>("date"));
			content.setCellValueFactory(new PropertyValueFactory<Feedback, String>("content"));

		}

		feedbackId.setVisible(false);
		table.setItems(allfeedbacks);
		initializeCombobox();

	}

	public void initialize() throws NamingException {
		Context context;

		context = new InitialContext();

		FeedbackServiceRemote asr = (FeedbackServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/FeedbackService!tn.esprit.beautifulminds.services.crud.FeedbackServiceRemote");
		ObservableList<Feedback> allfeedbacks = FXCollections.observableArrayList(asr.retrieveAllFeedbacks());

		feedbackId.setCellValueFactory(new PropertyValueFactory<Feedback, Integer>("feedbackId"));
		user.setCellValueFactory(new PropertyValueFactory<Feedback, User>("user"));
		status.setCellValueFactory(new PropertyValueFactory<Feedback, String>("status"));
		date.setCellValueFactory(new PropertyValueFactory<Feedback, Date>("date"));
		content.setCellValueFactory(new PropertyValueFactory<Feedback, String>("content"));

		feedbackId.setVisible(false);
		table.setItems(allfeedbacks);
		initializeCombobox();

		ObservableList<Feedback> acceptedfeedbacks = FXCollections.observableArrayList(asr.retrieveAcceptedFeedbacks());

		feedbackId1.setCellValueFactory(new PropertyValueFactory<Feedback, Integer>("feedbackId"));
		user1.setCellValueFactory(new PropertyValueFactory<Feedback, User>("user"));
		status1.setCellValueFactory(new PropertyValueFactory<Feedback, String>("status"));
		date1.setCellValueFactory(new PropertyValueFactory<Feedback, Date>("date"));
		content1.setCellValueFactory(new PropertyValueFactory<Feedback, String>("content"));

		feedbackId1.setVisible(false);
		status1.setVisible(false);
		table1.setItems(acceptedfeedbacks);

	}

	// public void initializeTwo() throws NamingException {
	// Context context;
	//
	// context = new InitialContext();
	//
	// FeedbackServiceRemote asr = (FeedbackServiceRemote) context.lookup(
	// "MySkiWorld-ear/MySkiWorld-ejb/FeedbackService!tn.esprit.beautifulminds.services.crud.FeedbackServiceRemote");
	//
	// }

	private void initializeCombobox() {
		// TODO Auto-generated method stub
		// datecbx.getSelectionModel().clearSelection();
		// statuscbx.getSelectionModel().clearSelection();
		datecbx.getItems().clear();
		statuscbx.getItems().clear();
		datecbx.getItems().add(new Label("All"));
		datecbx.getItems().add(new Label("A month ago"));
		datecbx.getItems().add(new Label("A year ago"));

		statuscbx.getItems().add(new Label("All"));
		statuscbx.getItems().add(new Label("Pending"));
		statuscbx.getItems().add(new Label("Handled"));
		statuscbx.getItems().add(new Label("Rejected"));
		statuscbx.getItems().add(new Label("Marked as Spam"));

	}

	@FXML
	void sendMailAction(ActionEvent event) {
		String reply = replytxt.getText();
		if (!reply.equals("")) {
			SendMailSSL.SendMessage(reply);
		}

	}

	@FXML
	void cancelMailAction(ActionEvent event) {
		replytxt.clear();

	}

}
