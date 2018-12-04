package fr.epita.logger.tests;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TestFileWriting {
	
	public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		PrintWriter writer = new PrintWriter(file);
		writer.println("test!");
		writer.close();
	}

}
