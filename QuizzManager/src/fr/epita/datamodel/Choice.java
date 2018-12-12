package fr.epita.datamodel;

public class Choice {
	
	 //CREATE TABLE CHOICE (ID INT PRIMARY KEY, LABEL VARCHAR(255), VALID BOOLEAN, QUESTIONID INT);
	
	private int id;
	
	private String label;
	
	private Question question;

	private boolean valid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	
}
