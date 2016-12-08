package by.mandrik.afisha.runner;

import java.io.IOException;  

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.mandrik.afisha.dao.xml.AfishaXMLHandler;

public class XMLSax {
	public static void main(String[] args) throws SAXException, IOException{
		XMLReader reader = XMLReaderFactory.createXMLReader();
		InputSource source = new InputSource("files/afisha.xml");
		AfishaXMLHandler handler = new AfishaXMLHandler();
		reader.setContentHandler(handler);
		reader.parse(source);
	}
}
