package fr.epita.tests;

import java.util.List;

import fr.epita.datamodel.Question;
import fr.epita.services.dao.QuestionFileDAO;
import fr.epita.services.dao.QuestionJDBCDAO;

public class QuestionDAOJDBCTest {

	
	public static void main(String[] args) {
		QuestionJDBCDAO dao = new QuestionJDBCDAO();
		//questionCreationTest(dao);
		Question criteria = new Question();
		criteria.setQuestion("acronym");
		List<Question> questions = dao.search(criteria);		// get all questions from the file
		for (Question question : questions) {
			System.out.println(question.getQuestion());
		}
		
		
		
	}

	private static void questionCreationTest(QuestionFileDAO dao) {
		Question firstQuestion = new Question("What is the square root of 25 ?");
		Question secondQuestion = new Question("How many sides are in a triangle ?");
		
		dao.create(firstQuestion);
		dao.create(secondQuestion);
		
	}
}
