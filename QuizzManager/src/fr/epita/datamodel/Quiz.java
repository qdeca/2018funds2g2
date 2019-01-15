package fr.epita.datamodel;

import java.util.List;

public class Quiz {
	private String title;
	
	private List<Question> listQuestions;
	
	private List<MCQQuestion> listMCQQuestions;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getListQuestions() {
		return listQuestions;
	}

	public void setListQuestions(List<Question> listQuestions) {
		this.listQuestions = listQuestions;
	}

	public List<MCQQuestion> getListMCQQuestions() {
		return listMCQQuestions;
	}

	public void setListMCQQuestions(List<MCQQuestion> listMCQQuestions) {
		this.listMCQQuestions = listMCQQuestions;
	}
	
	
}
