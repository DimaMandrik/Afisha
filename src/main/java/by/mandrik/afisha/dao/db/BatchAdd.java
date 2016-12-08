package by.mandrik.afisha.dao.db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class BatchAdd {
	public void insert() {
	try (java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afisha", "root", "root"); 
			java.sql.Statement st = connection.createStatement();){
	
		st.addBatch("INSERT INTO `afisha`.`event` (`title`, `date`, `cost`, `rating`, `eventType`) VALUES ('film3', '2015-08-18', '453', '2.43', '1');");
		st.addBatch("INSERT INTO `afisha`.`event` (`title`, `date`, `cost`, `rating`, `eventType`) VALUES ('film4', '2011-08-18', '23', '4.43', '1');");
		
		st.executeBatch();
		st.clearBatch();
		}catch (SQLException e) {
		e.printStackTrace();
	}
	}
}