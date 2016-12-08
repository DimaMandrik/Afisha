package by.mandrik.afisha.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	Statement st;
	public DBConnection() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afisha", "root", "root"); 
			st = connection.createStatement();
			System.out.println("Connection has been set");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Statement getSt() {
		return st;
	}	
}