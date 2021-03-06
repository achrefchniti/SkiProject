package tn.esprit.beautifulminds.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tn.esprit.beautifulminds.persistence.Holiday;
import tn.esprit.beautifulminds.persistence.Staff;
import tn.esprit.beautifulminds.services.crud.HolidayServiceRemote;
import tn.esprit.beautifulminds.services.crud.StaffServicesRemote;
import tn.esprit.beautifulminds.services.other.congeServiceRemote;

public class RequestController {

	@FXML
	private AnchorPane holi;

	@FXML
	private DatePicker datepicker;

	@FXML
	private TextField txt;

	@FXML
	private Button valider;

	@FXML
	void clickValide(ActionEvent event) throws ParseException, NamingException {

		Context context1 = new InitialContext();
		StaffServicesRemote staffServicesRemote = (StaffServicesRemote) context1.lookup(
				"SkiWorld-ear/SkiWorld-ejb/StaffServices!tn.esprit.beautifulminds.services.crud.StaffServicesRemote");
		Staff staff = staffServicesRemote.findStaffById(AuthController.getId11());

		Context context2 = new InitialContext();
		congeServiceRemote CongeServiceRemote = (congeServiceRemote) context2.lookup(
				"SkiWorld-ear/SkiWorld-ejb/congeService!tn.esprit.beautifulminds.services.other.congeServiceRemote");
		Integer nbrjour = Integer.parseInt(txt.getText());
		Integer b = CongeServiceRemote.getCar(staff, nbrjour);

		if (b >= 0) {

			Context context = new InitialContext();
			HolidayServiceRemote holidayServiceRemote = (HolidayServiceRemote) context.lookup(
					"SkiWorld-ear/SkiWorld-ejb/HolidayService!tn.esprit.beautifulminds.services.crud.HolidayServiceRemote");

			LocalDate d;
			d = datepicker.getValue();
			String s = d.toString();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
			Date dateDepart = format.parse(s);
			// Integer nbrjour = Integer.parseInt(txt.getText());
			Integer personId = AuthController.getId11();
			Date dateDemande = new Date(System.currentTimeMillis());
			Boolean etat = false;
			Holiday h = new Holiday(personId, dateDemande, dateDepart, nbrjour, etat);
			holidayServiceRemote.addHoliday(h);
			// Integer nb = staff.getNbjCAR() - nbrjour;
			staff.setNbjCAR(b);

			staffServicesRemote.updateStaff(staff);
			JOptionPane.showMessageDialog(null, "wait for a response please!");
		} else
			JOptionPane.showMessageDialog(null, "You can't have this periode sorry!");

	}
}