package fr.epita.services.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

import fr.epita.datamodel.Choice;
import fr.epita.logger.Logger;

public class ChoiceDAO {

	private static final String CHOICE_DB_FILE = "choice.db";

	private PrintWriter writer;

	private File file;
	
	public ChoiceDAO() {
		file = new File(CHOICE_DB_FILE);
			try {
				this.writer = new PrintWriter(new FileWriter(file, true));
			} catch (IOException e) {
				Logger.error("Exception occured while init the writer");
				e.printStackTrace();
			}

	}

	public void create(Choice choice) {
		writer.println("--------------");
		writer.println(choice.getId());
		writer.println(choice.getLabel());
		writer.println("Question id " + choice.getQuestion().getId());
		writer.println(choice.isValid());
		writer.println("--------------");
		writer.flush();		
	}
	
	public Choice getChoiceById(int id) {
		List<String> fileLines;
		try {
			fileLines = Files.readAllLines(file.toPath());
			for(String line : fileLines) {
				if (line.equals(Integer.toString(id))) {
					Choice choice = new Choice();
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
