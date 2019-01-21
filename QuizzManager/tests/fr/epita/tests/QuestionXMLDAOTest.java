package fr.epita.tests;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class QuestionXMLDAOTest {

	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder builder = fact.newDocumentBuilder(); // builder used to parse the xml file
		
		Document doc = builder.parse(new File("questions.xml")); //extraction of the data in xml 
																// and put in the doc object
		NodeList listQuestions = doc.getElementsByTagName("question");  // get all the elements going by the "question" tag
		for (int i=0; i<listQuestions.getLength(); i++) {
			Element question = (Element) listQuestions.item(i);
			String order = question.getAttribute("order");   //get the "order" attribute of the element
			System.out.println("Order : " + order);
			NodeList listLabels = question.getElementsByTagName("label"); //get all the elements of the "label" tag (here, only one)
			String label = listLabels.item(0).getTextContent(); // get the text content of the label element
			System.out.println("Question : " + label);
			
			Element topicList = (Element) question.getElementsByTagName("topics").item(0);
			NodeList topics = topicList.getElementsByTagName("topic");
			for (int j=0; j<topics.getLength(); j++) {
				Element topic = (Element) topics.item(j);
				System.out.println("Topic : " + topic.getTextContent());
			}
		}
	}
}
