package by.mandrik.afisha.dao.db;

import java.sql.ResultSet; 
import java.sql.SQLException;

import by.mandrik.afisha.entity.Exhibition;
import by.mandrik.afisha.entity.Film;
import by.mandrik.afisha.entity.Opera;
import by.mandrik.afisha.entity.Singer;

public class DBReader {
	ResultSet rs;
	public void dbRead(java.sql.Statement st){
	try {
		rs = st.executeQuery("SELECT title, cost, date, rating FROM event INNER JOIN types ON event.eventType = types.ID where types.name = 'film'");
		while (rs.next()) {
			Film film = new Film();
			film.setName(rs.getString("title"));
			film.setDate(rs.getDate("date"));
			film.setCost(rs.getBigDecimal("cost"));
			film.setRating(rs.getDouble("rating"));
			System.out.println(film);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		rs = st.executeQuery("SELECT title, cost, date, singer FROM event INNER JOIN types ON event.eventType = types.ID where types.name = 'opera'");
		while (rs.next()) {
			Opera opera = new Opera();
			opera.setName(rs.getString("title"));
			opera.setDate(rs.getDate("date"));
			opera.setCost(rs.getString("cost"));
			Singer singer = new Singer(rs.getString("singer"));
			opera.setSinger(singer);
			System.out.println(opera);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		rs = st.executeQuery("SELECT title, cost, date, theme, author FROM event INNER JOIN types ON event.eventType = types.ID where types.name = 'exhibition'");
		while (rs.next()) {
			Exhibition exhibition = new Exhibition();
			exhibition.setName(rs.getString("title"));
			exhibition.setDate(rs.getDate("date"));
			exhibition.setCost(rs.getString("cost"));
			exhibition.setTheme(rs.getString("theme"));
			exhibition.setAuthor(rs.getString("author"));
			System.out.println(exhibition);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
