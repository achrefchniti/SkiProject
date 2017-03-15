package tn.esprit.beautifulminds.services.crud;

import java.io.IOException;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.beautifulminds.persistence.Feedback;

@Local
public interface FeedbackServiceLocal {

	public List<Feedback> retrieveFeedbackByKeyword(String keyword) throws IOException;
}
