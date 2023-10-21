package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver = new com.mysql.cj.jdbc.Driver();

		DriverManager.registerDriver(driver);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");

		Statement st = conn.createStatement();

		String query = "select email , id , mobile from student";

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {

			String email = rs.getString(1);

			int id = rs.getInt(2);

			long mobile = rs.getLong(3);

			System.out.println(email + " | " + id + " | " + mobile);
		}

	}

}
