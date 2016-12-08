package by.mandrik.afisha.runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.mandrik.afisha.entity.Afisha;
import by.mandrik.afisha.entity.Event;
import by.mandrik.afisha.entity.Exhibition;
import by.mandrik.afisha.entity.Film;
import by.mandrik.afisha.entity.Opera;
import by.mandrik.afisha.entity.Singer;
import by.mandrik.afisha.logic.AfishaVisitor;
import by.mandrik.afisha.logic.impl.ConsolAfishaVisitor;

public class Main {

	public static void main(String[] args) {
		/*
		 * Date date1 = new Date(500); Date date2 = new Date(1000); Date date3 =
		 * new Date(1500); Event film = new Film("White Shark", new
		 * BigDecimal(5), date1, new Double(2)); Event opera = new
		 * Opera("Carmen", new BigDecimal(5), new Date(700), new Singer("Bob"));
		 * Event exhibition = new Exhibition("Shagal", new BigDecimal(5),
		 * date3);
		 */
		Afisha afisha = new Afisha("Minsk");
		// afisha.addEvent(film);
		// afisha.addEvent(opera);
		// afisha.addEvent(exhibition);
		AfishaVisitor visitor = new ConsolAfishaVisitor();
		// visitor.showAfisha(afisha);
		// afisha.getEvents(date3);
		// afisha.getEvents(date1, date2);
		/*
		 * afisha.addEventFromFile("files/films.txt");
		 * afisha.addEventFromFile("files/operas.txt");
		 * afisha.addEventFromFile("files/exhibitions.txt");
		 */
		afisha.addEventFromProp();
		visitor.showAfisha(afisha);

	}
}
