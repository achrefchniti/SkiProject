package tn.esprit.beautifulminds.services.other;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.*;
import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Applier;

@Remote
public interface RecruitmentServiceRemote {

	public String extractingTextCV(byte[] bytearray, String name) throws IOException;

	public List<Applier> retrieveApplierByKeyword(String keyword) throws IOException;

	public Map<Applier, String> handlingCVs() throws IOException;

}
