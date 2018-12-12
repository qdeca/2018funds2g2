package fr.epita.tests;

import java.util.List;

import fr.epita.datamodel.Question;
import fr.epita.services.dao.QuestionDAO;

public class QuestionDAOTest {

	
	public static void main(String[] args) {
		QuestionDAO dao = new QuestionDAO();
		//questionCreationTest(dao);
		
		List<Question> questions = dao.getAllQuestions();		// get all questions from the file
		for (Question question : questions) {
			System.out.println(question.getLabel());
		}
		
	}

	private static void questionCreationTest(QuestionDAO dao) {
		Question firstQuestion = new Question(1, "What is the square root of 25 ?");
		Question secondQuestion = new Question(2, "How many sides are in a triangle ?");
		
		dao.create(firstQuestion);
		dao.create(secondQuestion);
	}
}
