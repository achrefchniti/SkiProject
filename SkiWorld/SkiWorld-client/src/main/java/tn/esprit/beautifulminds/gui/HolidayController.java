package tn.esprit.beautifulminds.gui;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.beautifulminds.persistence.Holiday;
import tn.esprit.beautifulminds.services.crud.HolidayServiceRemote;

public class HolidayController {

	@FXML
	private TableView<Holiday> tabholi;

	@FXML
	private TableColumn<Holiday, Integer> idHoliday;

	@FXML
	private TableColumn<Holiday, Date> dateDemande;

	@FXML
	private TableColumn<Holiday, Date> dateDepart;

	@FXML
	private TableColumn<Holiday, Integer> nbrjour;

	@FXML
	private TableColumn<Holiday, Boolean> etat;

	public void initialize() throws NamingException {

		Context context = new InitialContext();
		HolidayServiceRemote holidayServicesRemote = (HolidayServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/HolidayService!tn.esprit.beautifulminds.services.crud.HolidayServiceRemote");

		ObservableList<Holiday> data = FXCollections.observableArrayList(holidayServicesRemote.findAllHolidays());

		idHoliday.setCellValueFactory(new PropertyValueFactory<Holiday, Integer>("personId"));
		dateDemande.setCellValueFactory(new PropertyValueFactory<Holiday, Date>("dateDemande"));
		dateDepart.setCellValueFactory(new PropertyValueFactory<Holiday, Date>("dateDepart"));
		nbrjour.setCellValueFactory(new PropertyValueFactory<Holiday, Integer>("nbrjour"));
		etat.setCellValueFactory(new PropertyValueFactory<Holiday, Boolean>("etat"));

		tabholi.setItems(data);

	}

	@FXML
	private Button accept;

	@FXML
	private Button refuse;

	@FXML
	void clickaccept(ActionEvent event) throws NamingException {
		Context context = new InitialContext();
		HolidayServiceRemote holidayServicesRemote = (HolidayServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/HolidayService!tn.esprit.beautifulminds.services.crud.HolidayServiceRemote");
		Holiday h = tabholi.getSelectionModel().getSelectedItem();
		h.getEtat();
		h.setEtat(true);
		holidayServicesRemote.updateHoliday(h);
		///
		ObservableList<Holiday> data = FXCollections.observableArrayList(holidayServicesRemote.findAllHolidays());

		idHoliday.setCellValueFactory(new PropertyValueFactory<Holiday, Integer>("personId"));
		dateDemande.setCellValueFactory(new PropertyValueFactory<Holiday, Date>("dateDemande"));
		dateDepart.setCellValueFactory(new PropertyValueFactory<Holiday, Date>("dateDepart"));
		nbrjour.setCellValueFactory(new PropertyValueFactory<Holiday, Integer>("nbrjour"));
		etat.setCellValueFactory(new PropertyValueFactory<Holiday, Boolean>("etat"));

		tabholi.setItems(data);

		holidayServicesRemote.updateHoliday(h);
	}

	@FXML
	void clickrefuse(ActionEvent event) throws NamingException {
		Context context = new InitialContext();
		HolidayServiceRemote holidayServicesRemote = (HolidayServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/HolidayService!tn.esprit.beautifulminds.services.crud.HolidayServiceRemote");

		// holidayServicesRemote.deleteHoliday(tabholi.getSelectionModel().getSelectedItem());
		tabholi.getItems().remove(tabholi.getSelectionModel().getSelectedItem());

	}
}
