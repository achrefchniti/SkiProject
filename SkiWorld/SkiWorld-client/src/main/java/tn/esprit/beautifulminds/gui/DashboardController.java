package tn.esprit.beautifulminds.gui;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class DashboardController {

	@FXML
	private TableColumn<?, ?> column1;

	@FXML
	private VBox vbox;

	@FXML
	private TableColumn<?, ?> column5;

	@FXML
	private TableColumn<?, ?> column4;

	@FXML
	private TableColumn<?, ?> column3;

	@FXML
	private TableColumn<?, ?> column2;

	@FXML
	private JFXButton staff;

	@FXML
	private JFXButton training;

	@FXML
	private JFXButton feedback;

	@FXML
	private JFXButton exit;

	@FXML
	private JFXButton application;

	@FXML
	private JFXButton trainer;

	@FXML
	private JFXButton station;

	@FXML
	private TableView<?> table;

}
