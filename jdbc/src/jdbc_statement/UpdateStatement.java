package jdbc_statement;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStatement {

	public static void main(String[] args) throws SQLException {

		Driver driver = new com.mysql.cj.jdbc.Driver();

		DriverManager.registerDriver(driver);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");

		Statement st = conn.createStatement();
		
		String query = " update student set mobile='9876543212' where id=3";
		
		int res = st.executeUpdate(query);
		
		System.out.println(res);
		
		conn.close();

	}

}
