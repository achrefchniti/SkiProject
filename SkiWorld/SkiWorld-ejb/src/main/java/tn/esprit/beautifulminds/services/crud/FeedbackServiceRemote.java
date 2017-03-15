package tn.esprit.beautifulminds.services.crud;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.beautifulminds.persistence.Feedback;

@Remote
public interface FeedbackServiceRemote {

	public void addFeedback(Feedback feedback);

	public void removeFeedbackById(Integer feedbackId);

	public void updateFeedback(Feedback feedback);

	public Feedback retrieveFeedbackById(Integer feedbackId);

	public List<Feedback> retrieveAllFeedbacks();

	public List<Feedback> retrieveFeedbackByKeyword(String keyword) throws IOException;

	public List<Feedback> retrieveFeedbacksByStatus(String status);

	public List<Feedback> retrieveFeedbacksByDate(String selection) throws ParseException;

	public List<Feedback> retrieveAcceptedFeedbacks();

}
