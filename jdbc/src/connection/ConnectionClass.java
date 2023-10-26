package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	
	
	public static Connection getconnection() throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");
		return con;
	}
	

}
