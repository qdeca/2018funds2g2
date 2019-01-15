package fr.epita.datamodel;

import java.util.List;

public class Exam {

	private long grade;
	
	private List<Answer> listAnswers;
	
	private List<MCQAnswer> listMCQAnswers;

	public long getGrade() {
		return grade;
	}

	public void setGrade(long grade) {
		this.grade = grade;
	}

	public List<Answer> getListAnswers() {
		return listAnswers;
	}

	public void setListAnswers(List<Answer> listAnswers) {
		this.listAnswers = listAnswers;
	}

	public List<MCQAnswer> getListMCQAnswers() {
		return listMCQAnswers;
	}

	public void setListMCQAnswers(List<MCQAnswer> listMCQAnswers) {
		this.listMCQAnswers = listMCQAnswers;
	}
	
	
}
