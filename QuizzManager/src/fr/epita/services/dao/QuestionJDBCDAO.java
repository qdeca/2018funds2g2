package fr.epita.services.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.datamodel.Question;
import fr.epita.services.Configuration;

public class QuestionJDBCDAO {

	private static final String INSERT_QUERY = "INSERT INTO QUESTIONS (QUESTION,DIFFICULTY) VALUES (?, ?)";
	private static final String UPDATE_QUERY = "UPDATE QUESTIONS SET QUESTION=?,DIFFICULTY=? WHERE ID=?";
	private static final String DELETE_QUERY = "DELETE QUESTIONS WHERE ID=?";
	private static final String SEARCH_QUERY = "SELECT QUESTION,ID,DIFFICULTY FROM QUESTIONS WHERE (? IS NOT NULL AND QUESTION LIKE ?) AND (? IS NOT NULL  AND DIFFICULTY = ?)";
	
	
	
	public void create(Question question) {
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement(INSERT_QUERY);
			stmt.setString(1, question.getQuestion());
			stmt.setInt(2, question.getDifficulty());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(Question question) {
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement(UPDATE_QUERY);
			stmt.setString(1, question.getQuestion());
			stmt.setInt(2, question.getDifficulty());
			stmt.setInt(3, question.getId());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(Question question) {
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement(DELETE_QUERY);
			stmt.setInt(1, question.getId());
			
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Question> search(Question question) {
		List<Question> questions = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement(SEARCH_QUERY);
			stmt.setString(1, question.getQuestion());
			stmt.setString(2, "%" + question.getQuestion()+ "%");
			stmt.setInt(3, question.getDifficulty());
			stmt.setInt(4, question.getDifficulty());
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String questionLabel = rs.getString(1);
				int id = rs.getInt(2);
				int difficulty = rs.getInt(3);
				Question currentQuestion = new Question();
				currentQuestion.setId(id);
				currentQuestion.setQuestion(questionLabel);
				currentQuestion.setDifficulty(difficulty);
				questions.add(currentQuestion);
			}
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}

	private Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		Configuration config = Configuration.getInstance();
		String url = config.getPropertyValue("jdbc.url");
		String username = config.getPropertyValue("jdbc.username");
		String password = config.getPropertyValue("jdbc.password");
		
		return DriverManager.getConnection(url, username, password);
	}

}
