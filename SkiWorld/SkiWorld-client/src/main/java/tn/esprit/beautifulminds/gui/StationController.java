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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.beautifulminds.persistence.Station;
import tn.esprit.beautifulminds.services.crud.StationServicesRemote;

public class StationController implements Initializable {

	@FXML
	private Button addStation;

	@FXML
	private Button deleteStation;

	@FXML
	private TextField name;

	@FXML
	private TextField longitude;

	@FXML
	private TextField latitude;

	@FXML
	private TextField address;

	@FXML
	private TextField area;

	@FXML
	private TextField description;

	@FXML
	private TableView<Station> tableView;

	@FXML
	private TableColumn<Station, String> c1;

	@FXML
	private TableColumn<Station, Float> c2;

	@FXML
	private TableColumn<Station, Float> c3;

	@FXML
	private TableColumn<Station, String> c4;

	@FXML
	private TableColumn<Station, String> c5;

	@FXML
	private TableColumn<Station, String> c6;

	@FXML
	private Label labelsaisie;
	
	@FXML 
	private Button updateStation;
	
	@FXML
	private Button update;
	
	@FXML	
	private Button cancel;

	
	ObservableList<Station> data;

	Context context;
	
	public static Station up;

	public void initialize(URL location, ResourceBundle resources) {
		
		
		cancel.setVisible(false);
		update.setVisible(false);
		
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		try {
			StationServicesRemote proxy = (StationServicesRemote) context.lookup(
					"SkiWorld-ear/SkiWorld-ejb/StationServices!tn.esprit.beautifulminds.services.crud.StationServicesRemote");
			List<Station> us;
			us = proxy.findAllStations();
			data = FXCollections.observableArrayList(us);
			c1.setCellValueFactory(new PropertyValueFactory<Station, String>("name"));
			c2.setCellValueFactory(new PropertyValueFactory<Station, Float>("longitude"));
			c3.setCellValueFactory(new PropertyValueFactory<Station, Float>("latitude"));
			c4.setCellValueFactory(new PropertyValueFactory<Station, String>("address"));
			c5.setCellValueFactory(new PropertyValueFactory<Station, String>("area"));
			c6.setCellValueFactory(new PropertyValueFactory<Station, String>("description"));
			tableView.setItems(data);

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	@FXML

	void addAction(ActionEvent event) throws NamingException {

		Station s = new Station();
		s.setName(name.getText());
		s.setLongitude(Float.parseFloat(longitude.getText()));
		s.setLatitude(Float.parseFloat(latitude.getText()));
		s.setAddress(address.getText());
		s.setArea(area.getText());
		s.setDescription(description.getText());

		Context context = new InitialContext();
		StationServicesRemote proxy = (StationServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StationServices!tn.esprit.beautifulminds.services.crud.StationServicesRemote");

		// if((address.getText()!="")&& (firstN.getText()!="")&&
		// (lastN.getText()!="")&&(mail.getText()!="")&&(phoneN.getText()!="" )
		// )
		if (!(name.getText().equals(new String(""))) && !(address.getText().equals(new String("")))
				&& !(area.getText().equals(new String(""))) && !(description.getText().equals(new String("")))) {
			proxy.addStation(s);
			name.setText("");
			address.setText("");
			area.setText("");
			description.setText("");
			latitude.setText("");
			longitude.setText("");

			context = new InitialContext();
			StationServicesRemote proxy2 = (StationServicesRemote) context.lookup(
					"SkiWorld-ear/SkiWorld-ejb/StationServices!tn.esprit.beautifulminds.services.crud.StationServicesRemote");
			List<Station> us;
			us = proxy2.findAllStations();
			data = FXCollections.observableArrayList(us);
			c1.setCellValueFactory(new PropertyValueFactory<Station, String>("name"));
			c2.setCellValueFactory(new PropertyValueFactory<Station, Float>("longitude"));
			c3.setCellValueFactory(new PropertyValueFactory<Station, Float>("latitude"));
			c4.setCellValueFactory(new PropertyValueFactory<Station, String>("address"));
			c5.setCellValueFactory(new PropertyValueFactory<Station, String>("area"));
			c6.setCellValueFactory(new PropertyValueFactory<Station, String>("description"));
			tableView.setItems(data);

		} else {
			labelsaisie.setText("Check the data entry fields");
		}

	}

	@FXML
	void deleteAction(ActionEvent event) throws NamingException {
		Station u = new Station();
		int ii = tableView.getSelectionModel().getSelectedItem().getStationId();
		u.setStationId(ii);

		context = new InitialContext();
		StationServicesRemote proxy = (StationServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StationServices!tn.esprit.beautifulminds.services.crud.StationServicesRemote");
		proxy.deleteStation(u);

		List<Station> us;

		StationServicesRemote proxy2 = (StationServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StationServices!tn.esprit.beautifulminds.services.crud.StationServicesRemote");
		us = proxy2.afficheStation();
		data = FXCollections.observableArrayList(us);
		c1.setCellValueFactory(new PropertyValueFactory<Station, String>("name"));
		c2.setCellValueFactory(new PropertyValueFactory<Station, Float>("longitude"));
		c3.setCellValueFactory(new PropertyValueFactory<Station, Float>("latitude"));
		c4.setCellValueFactory(new PropertyValueFactory<Station, String>("address"));
		c5.setCellValueFactory(new PropertyValueFactory<Station, String>("area"));
		c6.setCellValueFactory(new PropertyValueFactory<Station, String>("description"));
		tableView.setItems(data);

	}

	@FXML
	void updateStation(ActionEvent event) throws NamingException {
		
		context = new InitialContext();
		StationServicesRemote proxy = (StationServicesRemote) context.lookup(
		"SkiWorld-ear/SkiWorld-ejb/StationServices!tn.esprit.beautifulminds.services.crud.StationServicesRemote");
	
		
		int ii=tableView.getSelectionModel().getSelectedItem().getStationId();
		 up=proxy.findStationById(ii);
	
		name.setText(up.getName());
		address.setText(up.getAddress());
		area.setText(up.getArea());
		description.setText(up.getDescription());
		latitude.setText(String.valueOf(up.getLatitude()));
		longitude.setText(String.valueOf(up.getLongitude()));
	

		updateStation.setVisible(false);
		addStation.setVisible(false);
		cancel.setVisible(true);
		update.setVisible(true);
		
		List<Station> us;

		StationServicesRemote proxy2 = (StationServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StationServices!tn.esprit.beautifulminds.services.crud.StationServicesRemote");
		us = proxy2.afficheStation();
		data = FXCollections.observableArrayList(us);
		c1.setCellValueFactory(new PropertyValueFactory<Station, String>("name"));
		c2.setCellValueFactory(new PropertyValueFactory<Station, Float>("longitude"));
		c3.setCellValueFactory(new PropertyValueFactory<Station, Float>("latitude"));
		c4.setCellValueFactory(new PropertyValueFactory<Station, String>("address"));
		c5.setCellValueFactory(new PropertyValueFactory<Station, String>("area"));
		c6.setCellValueFactory(new PropertyValueFactory<Station, String>("description"));
		tableView.setItems(data);
	
	}
	
	@FXML
	void update(ActionEvent event) throws NamingException {
		context = new InitialContext();
		StationServicesRemote proxy = (StationServicesRemote) context.lookup(
		"SkiWorld-ear/SkiWorld-ejb/StationServices!tn.esprit.beautifulminds.services.crud.StationServicesRemote");	
		
			
		up.setName(name.getText());
		up.setLongitude(Float.parseFloat(longitude.getText()));
		up.setLatitude(Float.parseFloat(latitude.getText()));
		up.setAddress(address.getText());
		up.setArea(area.getText());
		up.setDescription(description.getText());
		
		proxy.updateStation(up);
		
		name.setText("");
		address.setText("");
		area.setText("");
		description.setText("");
		latitude.setText("");
		longitude.setText("");
				
		updateStation.setVisible(true);
		addStation.setVisible(true);
		cancel.setVisible(false);
		update.setVisible(false);
		
	}
	
	@FXML
	void Cancel(ActionEvent event) throws NamingException {
		
		name.setText("");
		address.setText("");
		area.setText("");
		description.setText("");
		latitude.setText("");
		longitude.setText("");
		updateStation.setVisible(true);
		addStation.setVisible(true);
		cancel.setVisible(false);
		update.setVisible(false);
		
	}
	
	
}
	
	


