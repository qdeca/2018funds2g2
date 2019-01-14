package fr.epita.tests;

import java.util.List;

import fr.epita.datamodel.Question;
import fr.epita.services.dao.QuestionFileDAO;

public class QuestionDAOTest {

	
	public static void main(String[] args) {
		QuestionFileDAO dao = new QuestionFileDAO();
		//questionCreationTest(dao);
		
		List<Question> questions = dao.getAllQuestions();		// get all questions from the file
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
