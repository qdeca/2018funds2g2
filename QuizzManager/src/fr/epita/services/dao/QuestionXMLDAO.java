package fr.epita.services.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.epita.datamodel.Question;

public class QuestionXMLDAO {

	public void create(Question question) throws ParserConfigurationException, SAXException, IOException {
		Document doc = xmlInit();
		
		Element xmlQuestion = doc.createElement("question");
		xmlQuestion.setAttribute("order", String.valueOf( question.getId()));

		Element xmlLabel = doc.createElement("label");
		xmlLabel.setTextContent(question.getQuestion());
		xmlQuestion.appendChild(xmlLabel);
		
		Element xmlDifficulty = doc.createElement("difficulty");
		xmlDifficulty.setTextContent(String.valueOf(question.getDifficulty()));
		xmlQuestion.appendChild(xmlDifficulty);
		
		Element xmlTopics = doc.createElement("topics");
		for (String topic : question.getTopics()) {
			Element xmlTopic = doc.createElement("topic");
			xmlTopic.setTextContent(topic);
			xmlTopics.appendChild(xmlTopic);
		}
		xmlQuestion.appendChild(xmlTopics);
		doc.getDocumentElement().appendChild(xmlQuestion);
		
		final PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("questions.xml", true)));
		System.out.println(documentToString(doc));
		printWriter.flush();
		printWriter.close();
		
	}
	
	private String documentToString(Document doc) {
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
	
	public void updateQuestion(Question question) {
		//TODO get xml file
		//TODO find question we want to update
		//TODO edit element(s)
		//TODO save xml file
	}
	
	public void deleteQuestion(Question question) {
		//TODO get xml file
		//TODO find question we want to update
		//TODO use the method removeChild (instead of appendChild on the create method for example)
		//TODO save xml file
	}
	
	public List<Question> getAllQuestions() throws ParserConfigurationException, SAXException, IOException {
		Document doc = xmlInit();
		
		NodeList listQuestionsXML = doc.getElementsByTagName("question");
		List<Question> result = xmlQuestionParse(listQuestionsXML);
		
		return result;
	}

	public List<Question> searchUsingXPATH(Question question) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpathExpression = factory.newXPath();
		XPathExpression expression = xpathExpression.compile("//question[contains(label/text(), '"+question.getQuestion()+"') ]");
		NodeList list = (NodeList) expression.evaluate( xmlInit(), XPathConstants.NODESET);
		
		return xmlQuestionParse(list);
		
		
	}
	
	public List<Question> search(Question question) throws ParserConfigurationException, SAXException, IOException {
		List<Question> allQuestions = getAllQuestions();
		List<Question> result = new ArrayList<>();
		for(Question current : allQuestions) {
			boolean difficultyMatch = current.getDifficulty() == question.getDifficulty();
			
			boolean topicsMatching = false;
			if (question.getTopics()!= null) {
				for (String topic : question.getTopics()) {
					if (Arrays.asList(current.getTopics()).contains(topic)) {
						topicsMatching = true;
						break;
					}
				}
			}else {
				topicsMatching = true;
			}
			
			boolean questionLabelMatching = current.getQuestion().contains(question.getQuestion());
			if (questionLabelMatching && topicsMatching && difficultyMatch) {
				result.add(current);
			}
			
		}
	
		//result = allQuestions.stream()
		//		.filter(q -> q.getDifficulty() == question.getDifficulty() && q.getQuestion().contains(question.getQuestion()))
		//		.collect(Collectors.toList());
		
		return result;
	}
	private List<Question> xmlQuestionParse(NodeList listQuestionsXML) {
		
		List<Question> results = new ArrayList<>();
		
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
				topicsToAdd[j] = topic.getTextContent();
				
			}
			question.setTopics(topicsToAdd);
			
			results.add(question);
		}
		return results;
	}

	private Document xmlInit() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder builder = fact.newDocumentBuilder(); // builder used to parse the xml file
		Document doc = builder.parse(new File("questions.xml")); //extraction of the data in xml 
		return doc;
	}
}
