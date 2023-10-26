package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionClass {

	static final String url = "jdbc:mysql://localhost:3306/studentdata";

	static final String username = "root";
   
	static final String password = "root";

	static Connection getconnection() throws SQLException {

		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

}
