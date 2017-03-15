package tn.esprit.beautifulminds.services.other;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Applier;
import tn.esprit.beautifulminds.services.crud.ApplierServiceLocal;

/**
 * Session Bean implementation class RecruitmentService
 */
@Stateless
public class RecruitmentService implements RecruitmentServiceRemote, RecruitmentServiceLocal {

	@PersistenceContext
	EntityManager em;

	@EJB
	private ApplierServiceLocal asl;

	/**
	 * Default constructor.
	 */

	public RecruitmentService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String extractingTextCV(byte[] bytearray, String name) throws IOException {
		// TODO Auto-generated method stub

		// FileOutputStream fos = new
		// FileOutputStream("C:\\Users\\USER\\Desktop\\CVs\\" + name);
		// fos.write(bytearray);
		// fos.close();
		// PDFTextStripper pdfStripper = null;
		// PDDocument pdDoc = null;
		// COSDocument cosDoc = null;
		// File file = new File("C:\\Users\\USER\\Desktop\\CVs\\Test.pdf");
		//
		// PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
		// parser.parse();
		// cosDoc = parser.getDocument();
		// pdfStripper = new PDFTextStripper();
		// pdDoc = new PDDocument(cosDoc);
		// pdfStripper.setStartPage(1);
		// pdfStripper.setEndPage(2);
		// String parsedText = pdfStripper.getText(pdDoc);
		//
		return "";

	}

	@Override
	public List<Applier> retrieveApplierByKeyword(String keyword) throws IOException {
		// TODO Auto-generated method stub
		Map<Applier, String> mapOfAppliers = this.handlingCVs();
		List<Applier> concerned = new ArrayList<>();
		// String keywordencoded =
		// Base64.getEncoder().encodeToString(keyword.getBytes());
		// List<Applier> finalConcerned = new ArrayList<>();
		Iterator it = mapOfAppliers.entrySet().iterator();
		while (it.hasNext()) {
			Entry thisEntry = (Entry) it.next();
			Applier a = (Applier) thisEntry.getKey();
			String s = (String) thisEntry.getValue();

			if (s.toLowerCase().contains(keyword.toLowerCase())) {
				concerned.add(a);
			}
		}
		return concerned;
	}

	@Override
	public Map<Applier, String> handlingCVs() throws IOException {
		// TODO Auto-generated method stub
		Map<Applier, String> mapOfAppliers = new HashMap();

		List<Applier> allAppliers = asl.retrieveAllAppliers();
		for (Applier applier : allAppliers) {
			// byte[] bytearray = applier.getCv();
			String name = applier.getFirstName() + applier.getLastName();
			if (name == null)
				name = "null";
			//String text = this.extractingTextCV(bytearray, name);
			// System.out.println(text);
			// mapOfAppliers.put(applier, text);
		}
		return mapOfAppliers;
	}

}
