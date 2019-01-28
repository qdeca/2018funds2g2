package fr.epita.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.epita.datamodel.Question;
import fr.epita.services.dao.QuestionXMLDAO;

public class QuestionXMLDAOTest {

	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		//xmlRead();
		//xmlWrite();
//		QuestionXMLDAO dao = new QuestionXMLDAO();
//		Question question = new  Question();
//		question.setId(5);
//		question.setDifficulty(8);
//		question.setQuestion("What are the main differences between Java and C++ ?");
//		String[] topics = new  String[2];
//		topics[0] = "Java";
//		topics[1] = "C++";
//		question.setTopics(topics);
//		dao.create(question);
		
		QuestionXMLDAO dao = new QuestionXMLDAO();
		List<Question> searchResults = dao.searchUsingXPATH(new Question("JVM"));
		System.out.println(searchResults);
	}

	private static void xmlWrite() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder builder = fact.newDocumentBuilder(); // builder used to parse the xml file
		Document doc = builder.parse(new File("questions.xml")); //extraction of the data in xml 

		// new element creation with the tag question
		Element newQuestion = doc.createElement("question");
		newQuestion.setAttribute("order", "3"); // attribute setting

		// new element creation (label)
		Element newLabel = doc.createElement("label");
		newLabel.setTextContent("Is Java a compiled language ?");
		newQuestion.appendChild(newLabel); // put the label element as a child of the new question element
		
		// new element creation (difficulty)
		Element newDifficulty = doc.createElement("difficulty");
		newDifficulty.setTextContent("2");
		
		
		newQuestion.appendChild(newDifficulty); // put the new question element at the root of the xml file (with all its child it contains)
		
		
		doc.getDocumentElement().appendChild(newQuestion);
		
		final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("questions.xml", true)));
		System.out.println(documentToString(doc));
		printWriter.flush();
		printWriter.close();
		
	}

	private static String documentToString(Document doc) {
		String result = "";
		try {
			final StringWriter sw = new StringWriter();
			final TransformerFactory tf = TransformerFactory.newInstance();
			final Transformer transformer = tf.newTransformer(); //creation of the object that transfoms the xml file
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			transformer.transform(new DOMSource(doc), new StreamResult("questions.xml")); // applying modifications in java to the actual xml file
			result = sw.toString();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static void xmlRead() throws ParserConfigurationException, SAXException, IOException {
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
