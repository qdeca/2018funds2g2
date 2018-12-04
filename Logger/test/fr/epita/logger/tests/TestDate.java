package fr.epita.logger.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HH:mm:ss.SSS");
		
		System.out.println(formatter.format(date));
	}
}
