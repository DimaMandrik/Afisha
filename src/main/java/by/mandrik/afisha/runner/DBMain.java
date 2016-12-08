package by.mandrik.afisha.runner;

import java.sql.Statement;

import by.mandrik.afisha.dao.db.BatchAdd;
import by.mandrik.afisha.dao.db.DBConnection;
import by.mandrik.afisha.dao.db.DBReader;

public class DBMain {

	public static void main(String[] args) {
		//final Logger log = LogManager.getLogger();
		DBConnection con = new DBConnection();
		Statement st = con.getSt();
		BatchAdd bAdd = new BatchAdd();
		bAdd.insert();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		DBReader dbr = new DBReader();
		dbr.dbRead(st);
	}
}