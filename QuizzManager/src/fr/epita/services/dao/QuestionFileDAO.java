package fr.epita.services.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fr.epita.datamodel.Question;
import fr.epita.logger.Logger;

public class QuestionFileDAO {
	
	private static final String QUESTION_DB_FILE = "questions.db";
	
	private PrintWriter writer;

	private File file;

	
	
	public QuestionFileDAO() {
		file = new File(QUESTION_DB_FILE);
		try {
			this.writer = new PrintWriter(new FileWriter(file, true));
		} catch (IOException e) {
			Logger.error("Exception occured while init the writer");
			e.printStackTrace();
		}
	}

	public void create(Question question) {
		writer.println("--------------");
		writer.println(question.getQuestion());
		writer.println("--------------");
		writer.flush();		
	}
	
	public List<Question> getAllQuestions() {	// get all questions stored into the file
		List<Question> listQuestions = new ArrayList<Question>();
		try {
			List<String> fileLines = Files.readAllLines(file.toPath()); // get a list of string,
			Question question = new Question();						// one string = one line
			for (int i=0; i<fileLines.size(); i++) {		// loop over all the lines you get
				if (i % 4 == 0) {							// a question takes 4 line, so modulo 4
					question = new Question();
				}
				if (i % 4 == 1) {							// in this case the id of the question
					String stringId = fileLines.get(i);
					question.setId(Integer.parseInt(stringId));
				}
				if (i % 4 == 2) {							// in this case the label of the question
					String label = fileLines.get(i);
					question.setLabel(label);
				}
				if (i % 4 == 3) {							// add the question to the final list before creating another
					listQuestions.add(question);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listQuestions;
	}

}
