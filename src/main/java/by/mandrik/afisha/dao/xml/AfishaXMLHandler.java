package by.mandrik.afisha.dao.xml; 

import org.xml.sax.Attributes;   
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.mandrik.afisha.entity.Event;
import by.mandrik.afisha.entity.Exhibition;
import by.mandrik.afisha.entity.Film;
import by.mandrik.afisha.entity.Opera;

public class AfishaXMLHandler extends DefaultHandler {
	
	private String thisElement="thisElement";
	private Event event;
	
	int characters = 0;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start Document"); 
		// super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		thisElement = qName;
		if (qName.equals("event")) {
			String type = attributes.getValue("type");
		if (attributes != null) {
				switch (type) {
				case "film":
					event = new Film();
					break;
				case "opera":
					event = new Opera();
					break;
				case "exhibition":
					event = new Exhibition();
					break;
				}
			}
		}
		}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if (thisElement.equals("name")) { 
			event.setName(new String(ch, start, length));
		}
		if (thisElement.equals("price")) { 
			event.setCost(new String(ch, start, length));
		}
		if (thisElement.equals("date")) { 
			event.setDate(new String(ch, start, length));
		}
		if (thisElement.equals("rating")) { 
			Film film = (Film) event;
			film .setRating(new Double(new String(ch, start, length)));
		}
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("End Document");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		thisElement = "";
		System.out.println(event);
		}
	}
