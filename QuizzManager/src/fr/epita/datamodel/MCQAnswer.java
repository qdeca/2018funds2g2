package fr.epita.datamodel;

public class MCQAnswer {
	
	private MCQChoice choice;
	
	private Student student;

	public MCQChoice getChoice() {
		return choice;
	}

	public void setChoice(MCQChoice choice) {
		this.choice = choice;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
