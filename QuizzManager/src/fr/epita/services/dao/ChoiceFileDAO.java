package fr.epita.services.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

import fr.epita.datamodel.MCQChoice;
import fr.epita.logger.Logger;

public class ChoiceFileDAO {

	private static final String CHOICE_DB_FILE = "choice.db";

	private PrintWriter writer;

	private File file;
	
	public ChoiceFileDAO() {
		file = new File(CHOICE_DB_FILE);
			try {
				this.writer = new PrintWriter(new FileWriter(file, true));
			} catch (IOException e) {
				Logger.error("Exception occured while init the writer");
				e.printStackTrace();
			}

	}

	public void create(MCQChoice choice) {
		writer.println("--------------");
		writer.println(choice.getLabel());
		writer.println("Question id " + choice.getQuestion().getId());
		writer.println(choice.isValid());
		writer.println("--------------");
		writer.flush();		
	}
	
	public MCQChoice getChoiceById(int id) {
		List<String> fileLines;
		try {
			fileLines = Files.readAllLines(file.toPath());
			for(String line : fileLines) {
				if (line.equals(Integer.toString(id))) {
					MCQChoice choice = new MCQChoice();
					choice.setId(id);
					int index = fileLines.indexOf(line);
					choice.setLabel(fileLines.get(index)+1);
					choice.setValid(fileLines.get(index)+3 == "true" ? true : false);
					return choice;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
