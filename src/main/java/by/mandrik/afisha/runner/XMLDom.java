package by.mandrik.afisha.runner;

import java.io.IOException; 
import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import by.mandrik.afisha.entity.Event;
import by.mandrik.afisha.entity.Exhibition;
import by.mandrik.afisha.entity.Film;
import by.mandrik.afisha.entity.Opera;
import by.mandrik.afisha.entity.Singer;

public class XMLDom {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		Element afishaRoot; 
		NodeList eventsNode = null;
		
		try{
			builder = factory.newDocumentBuilder();
			document = builder.parse(new InputSource("files/afisha.xml"));
			afishaRoot = document.getDocumentElement();
			String att = afishaRoot.getAttribute("city");
			System.out.println(att);
			eventsNode = afishaRoot.getElementsByTagName("events");
			
			for (int i = 0; i < eventsNode.getLength(); i++){
				Element events = (Element) eventsNode.item(i);
				NodeList allEvents = events.getChildNodes();
				for (int j = 0; j < allEvents.getLength(); j++){
					Node eventNode = allEvents.item(j);
					Element eventElement;
					if (eventNode.getNodeType()==1){
						eventElement = (Element) eventNode;
						Event eventEntity = buildEvent(eventElement, eventNode.getNodeName());
						System.out.println(eventEntity);
					}
				}
			}
		}catch (IOException | SAXException | ParserConfigurationException ex){}
			
	}

	private static Event buildEvent(Element eventElement, String nodeName) {
		Event event = null;
		System.out.println("nodeName:" + nodeName);
		switch (nodeName) {
		case "film":
			Film film = new Film();
			film.setName(getSingleElementContent(eventElement, "title"));
			film.setDate(getSingleElementContent(eventElement, "date"));
			film.setCost(new BigDecimal(getSingleElementContent(eventElement, "cost")));
			film.setRating(new Double(getSingleElementContent(eventElement, "rating")));
			event = film;
			break;
		case "opera":
			Opera opera = new Opera();
			opera.setName(getSingleElementContent(eventElement, "title"));
			opera.setDate(getSingleElementContent(eventElement, "date"));
			opera.setCost(new BigDecimal(getSingleElementContent(eventElement, "cost")));
			opera.setSinger(new Singer(getSingleElementContent(eventElement, "singer")));
			event = opera;
			break;
		case "exhibition":
			Exhibition exhibition = new Exhibition();
			exhibition.setName(getSingleElementContent(eventElement, "title"));
			exhibition.setDate(getSingleElementContent(eventElement, "date"));
			exhibition.setCost(new BigDecimal(getSingleElementContent(eventElement, "cost")));
			exhibition.setAuthor(getSingleElementContent(eventElement, "author"));
			exhibition.setTheme(getSingleElementContent(eventElement, "theme"));
			event = exhibition;
			break;
	}
		return event;
}

	private static String getSingleElementContent(Element eventElement,
			String tagName) {
		NodeList list = eventElement.getElementsByTagName(tagName);
		Element el = (Element) list.item(0);
		String content = el.getTextContent().trim();
		return content;
	}
}

