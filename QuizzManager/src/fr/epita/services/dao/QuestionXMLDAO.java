package fr.epita.services.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.epita.datamodel.Question;

public class QuestionXMLDAO {

	public void create(Question question) {
		
	}
	
	public void update(Question question) {
		
	}
	
	public List<Question> getAllQuestions() throws ParserConfigurationException, SAXException, IOException {
		Document doc = xmlInit();
		
		NodeList listQuestionsXML = doc.getElementsByTagName("question");
		List<Question> result = new ArrayList<>();
		xmlQuestionParse(listQuestionsXML, result);
		
		return result;
	}

	private void xmlQuestionParse(NodeList listQuestionsXML, List<Question> result) {
		for (int i=0; i<listQuestionsXML.getLength(); i++) {
			Question question = new Question();
			Element questionXML = (Element) listQuestionsXML.item(i);
			
			//order parse
			String order = questionXML.getAttribute("order");
			question.setId(Integer.parseInt(order));
			
			//difficulty parse
			Element difficultyElement = (Element) questionXML.getElementsByTagName("difficulty").item(0);
			String difficultyXML = difficultyElement.getTextContent();
			question.setDifficulty(Integer.parseInt(difficultyXML));
			
			//label parse
			Element labelElement = (Element) questionXML.getElementsByTagName("label").item(0);
			String labelXML = labelElement.getTextContent();
			question.setQuestion(labelXML);
			
			//topics parse
			Element topicList = (Element) questionXML.getElementsByTagName("topics").item(0);
			NodeList topics = topicList.getElementsByTagName("topic");
			String[] topicsToAdd = new String[topics.getLength()];
			for (int j=0; j<topics.getLength(); j++) {
				Element topic = (Element) topics.item(j);
				topicsToAdd[i] = topic.getTextContent();
				
			}
			question.setTopics(topicsToAdd);
			
			result.add(question);
		}
	}

	private Document xmlInit() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder builder = fact.newDocumentBuilder(); // builder used to parse the xml file
		Document doc = builder.parse(new File("questions.xml")); //extraction of the data in xml 
		return doc;
	}
}
