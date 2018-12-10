package fr.epita.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd_HH:mm:ss.SSS");
	private static boolean isInitialized = false;

	private static String currentLevel = "INFO";
	
	
	private static PrintWriter pw;

	public static void logMessage(String message) {
		Date date = new Date();
		if (!isInitialized) {
			pw = initialize();
		}
		if (pw != null) {
			pw.println(SIMPLE_DATE_FORMAT.format(date) + "-" + message);
		}
		pw.flush();
	}
	
	
	public static void info(String message) {
		logMessage(" INFO " + message);
	}
	public static void warn(String message) {
		logMessage(" WARN " + message);
	}
	public static void debug(String message) {
		logMessage(" DEBUG " + message);
	}
	public static void error(String message) {
		logMessage(" ERROR " + message);
	}

	private static PrintWriter initialize(){
		try {
			File file = new File("application.log");
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(new FileWriter(file, true));
			isInitialized = true;
			writer.println("initialized!");
			return writer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		isInitialized = false;
		return null;

	}

}
