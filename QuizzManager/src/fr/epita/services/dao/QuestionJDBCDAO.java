package fr.epita.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.epita.datamodel.Question;

public class QuestionJDBCDAO {

	private static final String PWD = "";
	private static final String USERNAME = "sa";
	private static final String URL = "jdbc:h2:tcp://localhost//C:/db/h2DS;create=true";
	private static final String insert_sql = "INSERT INTO QUESTIONS (QUESTION,DIFFICULTY) VALUES (?, ?)";

	public void create(Question question) {
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement(insert_sql);
			stmt.setString(1, question.getQuestion());
			stmt.setInt(2, question.getDifficulty());

			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PWD);
	}

}
