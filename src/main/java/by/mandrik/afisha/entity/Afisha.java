package by.mandrik.afisha.entity;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Afisha {
	private ArrayList<Event> events;
	
	protected Afisha(ArrayList<Event> events, String city) {
		super();
		this.events = events;
		this.city = city;
	}

	public Afisha() {
		super();
	}

	@SuppressWarnings("unused")
	private String city;

	public boolean addEvent(Event event) {
		if (event != null) {
			return events.add(event);
		}
		return false;
	}

	public void addEventFromFile(String a) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(a),
					StandardCharsets.UTF_8);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < lines.size(); i++) {
			String[] s = new String[4];
			Film film = new Film();
			s = lines.get(i).split(";");
			film.setName(s[0]);
			BigDecimal money = new BigDecimal(s[1].replaceAll(",", ""));
			film.setCost(money);
			try {
				SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
				Date date = format.parse(s[2]);
				film.setDate(date);
			} catch (ParseException e) {
				System.out.println("Parse Error");
				e.printStackTrace();
			}
			film.setRating(Double.parseDouble(s[3]));
			events.add(film);
		}
	}
	//add From Property file
	
	public void addEventFromProp(){
	try{
		ResourceBundle bundleEN = ResourceBundle.getBundle("config", Locale.ENGLISH);
		Film film = new Film();
		film.setName(bundleEN.getString("name"));
		BigDecimal price = new BigDecimal(bundleEN.getString("price").replaceAll(",", ""));
		film.setCost(price);
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
			Date date1 = format.parse(bundleEN.getString("date"));
			film.setDate(date1);
		} catch (ParseException e) {
			System.out.println("Parse Error");
			e.printStackTrace();
		}
		film.setRating(Double.parseDouble(bundleEN.getString("rating")));
		events.add(film);
		
	}catch (Exception e){
		/*log.error("dasdasd");
		log.info("info");
		log.debug("debug");*/
	}
}
	public ArrayList<Event> getEvents() {
		return events;
	}

	public void getEvents(Date date) {
		for (int i = 0; i < events.size(); i++)
			if (date == events.get(i).getDate()) {
				System.out.println(events.get(i).toString());
			}
	}
	
	public Event getEvents(Date start, Date end) {
		for (int i = 0; i < events.size(); i++)
			if (start.getTime() <= events.get(i).getDate().getTime() & end.getTime() >= events.get(i).getDate().getTime()) {
				System.out.println(events.get(i));
			}
		return null;
	}

	public Afisha(String city) {
		events = new ArrayList<Event>();
		this.city = city;
	}

	@Override
	public String toString() {
		return "Afisha [events=" + events + "]";
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
}
