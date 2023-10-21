package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatement {

	public static void main(String[] args) throws SQLException {

		Driver driver = new com.mysql.cj.jdbc.Driver();

		DriverManager.registerDriver(driver);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");

		Statement st = conn.createStatement();

		String query = "insert into student values(2,'sudhan','sudhan@gmail.com',9876543210),(3,'dinesh','dinesh@gmail.com',9876543211)";

		int result = st.executeUpdate(query);

		System.out.println(result);

		conn.close();

	}

}
