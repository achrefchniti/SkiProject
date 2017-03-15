package tn.esprit.beautifulminds.services.crud;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.beautifulminds.persistence.Feedback;

/**
 * Session Bean implementation class FeedbackService
 */
@Stateless
public class FeedbackService implements FeedbackServiceRemote, FeedbackServiceLocal {

	@PersistenceContext
	EntityManager entitymanager;

	/**
	 * Default constructor.
	 */
	public FeedbackService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		entitymanager.persist(feedback);

	}

	@Override
	public void removeFeedbackById(Integer feedbackId) {
		// TODO Auto-generated method stub
		entitymanager.remove(entitymanager.find(Feedback.class, feedbackId));
	}

	@Override
	public void updateFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		entitymanager.merge(feedback);
	}

	@Override
	public Feedback retrieveFeedbackById(Integer feedbackId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Feedback.class, feedbackId);
	}

	@Override
	public List<Feedback> retrieveAllFeedbacks() {
		// TODO Auto-generated method stub
		List<Feedback> allfeeds = entitymanager.createQuery("Select f from Feedback f").getResultList();
		return allfeeds;
	}

	public List<Feedback> retrieveFeedbackByKeyword(String keyword) throws IOException {
		// TODO Auto-generated method stub
		return entitymanager.createQuery(
				"Select f from Feedback f where f.status like '" + keyword + "' " + "or f.content like '" + keyword
						+ "' or f.user.firstName like '" + keyword + "' " + "or f.user.lastName like '" + keyword + "'")
				.getResultList();
	}

	@Override
	public List<Feedback> retrieveFeedbacksByStatus(String status) {
		// TODO Auto-generated method stub
		List<Feedback> feeds = entitymanager
				.createQuery("Select f from Feedback f where f.status like '" + status + "'").getResultList();
		return feeds;
	}

	@Override
	public List<Feedback> retrieveFeedbacksByDate(String selection) throws ParseException {
		// TODO Auto-generated method stub

		/*********************************/
		// LocalDate d;
		// d = date.getValue();
		// String s = d.toString();
		Date datemonth = new Date();
		int month = datemonth.getMonth() - 1;
		datemonth.setMonth(month);
		Date dateyear = new Date();
		int year = dateyear.getYear() - 1;
		dateyear.setYear(year);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// // System.out.println("*********" + s);

		/*********************************/
		if (selection.equals("A month ago")) {
			return entitymanager.createQuery("Select f from Feedback f where f.date between '"
					+ format.format(datemonth) + "' and " + "'" + format.format(new Date()) + "'").getResultList();
		} else if (selection.equals("A year ago")) {
			return entitymanager.createQuery("Select f from Feedback f where f.date between '" + format.format(dateyear)
					+ "' and " + "'" + format.format(new Date()) + "'").getResultList();
		} else {
			return entitymanager.createQuery("Select f from Feedback f").getResultList();
		}
	}

	@Override
	public List<Feedback> retrieveAcceptedFeedbacks() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("Select f from Feedback f where f.status like 'Accepted'").getResultList();
	}
}
