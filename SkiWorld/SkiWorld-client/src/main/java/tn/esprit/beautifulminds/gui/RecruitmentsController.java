package tn.esprit.beautifulminds.gui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

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
import tn.esprit.beautifulminds.persistence.Applier;
import tn.esprit.beautifulminds.services.crud.ApplierServiceRemote;

public class RecruitmentsController {

	@FXML
	private Button hirebtn;

	@FXML
	private Button searchbtn;

	@FXML
	private ComboBox<Label> rolecbx;

	@FXML
	private TextField searchtxt;

	@FXML
	private ComboBox<Label> natcbx;

	@FXML
	private Button rejectbtn;

	@FXML
	private TableView<Applier> table;

	@FXML
	private TableColumn<Applier, String> cv;

	@FXML
	private Button cvbtn;

	@FXML
	private TableColumn<Applier, String> firstname;

	@FXML
	private TableColumn<Applier, String> lastname;

	@FXML
	private TableColumn<Applier, String> status;

	@FXML
	private TableColumn<Applier, Integer> personId;

	@FXML
	private TableColumn<Applier, String> nationality;

	@FXML
	private TableColumn<Applier, String> role;

	@FXML
	void searchAction(ActionEvent event) throws NamingException, IOException {

		/********* handlingCvs of all my appliers ***********/
		Map<Applier, String> mapOfAppliers = new HashMap();
		Context context = new InitialContext();
		ApplierServiceRemote asr = (ApplierServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/ApplierService!tn.esprit.beautifulminds.services.crud.ApplierServiceRemote");

		List<Applier> allAppliers = asr.retrieveAllAppliers();
		for (Applier applier : allAppliers) {
			String filepath = applier.getCv();
			String name = applier.getFirstName() + applier.getLastName();
			if (name == null)
				name = "null";
			String text = this.extractingTextCV(filepath, name);
			System.out.println(text);
			mapOfAppliers.put(applier, text);
		}
		/********* Search for concerned appliers ************/
		List<Applier> concerned = new ArrayList<>();
		Iterator it = mapOfAppliers.entrySet().iterator();
		while (it.hasNext()) {
			Entry thisEntry = (Entry) it.next();
			Applier a = (Applier) thisEntry.getKey();
			String s = (String) thisEntry.getValue();

			if (s.toLowerCase().contains(searchtxt.getText().toLowerCase())) {
				concerned.add(a);
			}
		}
		/************* Filling my tableView ****************/
		ObservableList<Applier> searchedappliers = FXCollections.observableArrayList(concerned);

		personId.setCellValueFactory(new PropertyValueFactory<Applier, Integer>("personId"));
		firstname.setCellValueFactory(new PropertyValueFactory<Applier, String>("firstName"));
		lastname.setCellValueFactory(new PropertyValueFactory<Applier, String>("lastName"));
		status.setCellValueFactory(new PropertyValueFactory<Applier, String>("status"));
		nationality.setCellValueFactory(new PropertyValueFactory<Applier, String>("nationality"));
		role.setCellValueFactory(new PropertyValueFactory<Applier, String>("role"));

		table.setItems(searchedappliers);
	}

	@FXML
	void selectedNationalityAction(ActionEvent event) throws NamingException {

		Context context = new InitialContext();

		ApplierServiceRemote asr = (ApplierServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/ApplierService!tn.esprit.beautifulminds.services.crud.ApplierServiceRemote");
		String selected = natcbx.getSelectionModel().getSelectedItem().getText();
		System.out.println(selected);
		ObservableList<Applier> appliers;
		if (selected.equals("All")) {
			appliers = FXCollections.observableArrayList(asr.retrieveAllAppliers());
			personId.setCellValueFactory(new PropertyValueFactory<Applier, Integer>("personId"));
			firstname.setCellValueFactory(new PropertyValueFactory<Applier, String>("firstName"));
			lastname.setCellValueFactory(new PropertyValueFactory<Applier, String>("lastName"));
			status.setCellValueFactory(new PropertyValueFactory<Applier, String>("status"));
			nationality.setCellValueFactory(new PropertyValueFactory<Applier, String>("nationality"));
			role.setCellValueFactory(new PropertyValueFactory<Applier, String>("role"));

		} else {
			appliers = FXCollections.observableArrayList(asr.retrieveApplierByNationality(selected));
			personId.setCellValueFactory(new PropertyValueFactory<Applier, Integer>("personId"));
			firstname.setCellValueFactory(new PropertyValueFactory<Applier, String>("firstName"));
			lastname.setCellValueFactory(new PropertyValueFactory<Applier, String>("lastName"));
			status.setCellValueFactory(new PropertyValueFactory<Applier, String>("status"));
			nationality.setCellValueFactory(new PropertyValueFactory<Applier, String>("nationality"));
			role.setCellValueFactory(new PropertyValueFactory<Applier, String>("role"));

		}

		personId.setVisible(false);
		table.setItems(appliers);
		initializeCombobox();

	}

	@FXML
	void rejectAction(ActionEvent event) throws NamingException {

		if (table.getSelectionModel().getSelectedItem().getStatus().equals("Rejected")) {
			rejectbtn.setDefaultButton(true);
		} else {
			rejectbtn.setDefaultButton(false);
		}
		Context context = new InitialContext();

		ApplierServiceRemote asr = (ApplierServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/ApplierService!tn.esprit.beautifulminds.services.crud.ApplierServiceRemote");

		asr.rejectApplier(table.getSelectionModel().getSelectedItem());
		this.initialize();
	}

	@FXML
	void hireAction(ActionEvent event) throws NamingException {

		if (table.getSelectionModel().getSelectedItem().getStatus().equals("Hired")) {
			hirebtn.setDefaultButton(true);
		} else {
			hirebtn.setDefaultButton(false);
		}
		Context context = new InitialContext();

		ApplierServiceRemote asr = (ApplierServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/ApplierService!tn.esprit.beautifulminds.services.crud.ApplierServiceRemote");

		asr.hireApplier(table.getSelectionModel().getSelectedItem());
		this.initialize();

	}

	@FXML
	void openCVAction(ActionEvent event) throws NamingException {
		if (Desktop.isDesktopSupported()) {
			try {

				Desktop.getDesktop().open(new File(table.getSelectionModel().getSelectedItem().getCv()));
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	@FXML
	void selectedRoleAction(ActionEvent event) throws NamingException {

		Context context = new InitialContext();

		ApplierServiceRemote asr = (ApplierServiceRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/ApplierService!tn.esprit.beautifulminds.services.crud.ApplierServiceRemote");

		String selected = rolecbx.getSelectionModel().getSelectedItem().getText();
		System.out.println(selected);
		ObservableList<Applier> appliers;
		if (selected.equals("All")) {
			appliers = FXCollections.observableArrayList(asr.retrieveAllAppliers());
			personId.setCellValueFactory(new PropertyValueFactory<Applier, Integer>("personId"));
			firstname.setCellValueFactory(new PropertyValueFactory<Applier, String>("firstName"));
			lastname.setCellValueFactory(new PropertyValueFactory<Applier, String>("lastName"));
			status.setCellValueFactory(new PropertyValueFactory<Applier, String>("status"));
			nationality.setCellValueFactory(new PropertyValueFactory<Applier, String>("nationality"));
			role.setCellValueFactory(new PropertyValueFactory<Applier, String>("role"));

		} else {
			appliers = FXCollections.observableArrayList(asr.retrieveAppliersByRole(selected));
			personId.setCellValueFactory(new PropertyValueFactory<Applier, Integer>("personId"));
			firstname.setCellValueFactory(new PropertyValueFactory<Applier, String>("firstName"));
			lastname.setCellValueFactory(new PropertyValueFactory<Applier, String>("lastName"));
			status.setCellValueFactory(new PropertyValueFactory<Applier, String>("status"));
			nationality.setCellValueFactory(new PropertyValueFactory<Applier, String>("nationality"));
			role.setCellValueFactory(new PropertyValueFactory<Applier, String>("role"));
		}

		personId.setVisible(false);
		table.setItems(appliers);
		initializeCombobox();

	}

	public void initialize() {
		try {// TODO Auto-generated method stub
			Context context;

			context = new InitialContext();

			ApplierServiceRemote asr = (ApplierServiceRemote) context.lookup(
					"SkiWorld-ear/SkiWorld-ejb/ApplierService!tn.esprit.beautifulminds.services.crud.ApplierServiceRemote");
			ObservableList<Applier> allappliers = FXCollections.observableArrayList(asr.retrieveAllAppliers());

			personId.setCellValueFactory(new PropertyValueFactory<Applier, Integer>("personId"));
			firstname.setCellValueFactory(new PropertyValueFactory<Applier, String>("firstName"));
			lastname.setCellValueFactory(new PropertyValueFactory<Applier, String>("lastName"));
			status.setCellValueFactory(new PropertyValueFactory<Applier, String>("status"));
			nationality.setCellValueFactory(new PropertyValueFactory<Applier, String>("nationality"));
			role.setCellValueFactory(new PropertyValueFactory<Applier, String>("role"));

			personId.setVisible(false);
			cv.setVisible(false);
			table.setItems(allappliers);
			this.initializeCombobox();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initializeCombobox() {
		natcbx.getItems().clear();
		rolecbx.getItems().clear();
		natcbx.getItems().add(new Label("All"));
		natcbx.getItems().add(new Label("Tunisian"));
		natcbx.getItems().add(new Label("French"));
		natcbx.getItems().add(new Label("English"));
		natcbx.getItems().add(new Label("American"));

		rolecbx.getItems().add(new Label("All"));
		rolecbx.getItems().add(new Label("Software Engineer"));
		rolecbx.getItems().add(new Label("Security"));
		rolecbx.getItems().add(new Label("Management"));
		rolecbx.getItems().add(new Label("Financial"));

	}

	public String extractingTextCV(String filepath, String name) throws IOException {
		// TODO Auto-generated method stub

		System.out.println(filepath);
		File file = new File(filepath.replace("\\", "\\\\"));
		System.out.println(filepath.replace("\\", "\\\\"));

		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
		parser.parse();
		cosDoc = parser.getDocument();
		pdfStripper = new PDFTextStripper();
		pdDoc = new PDDocument(cosDoc);
		pdfStripper.setStartPage(1);
		pdfStripper.setEndPage(2);
		String parsedText = pdfStripper.getText(pdDoc);
		return parsedText;
	}

}
