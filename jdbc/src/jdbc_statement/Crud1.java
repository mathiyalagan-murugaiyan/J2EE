package jdbc_statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionClass;

public class Crud1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
//		Driver driver = new com.mysql.cj.jdbc.Driver();
//		DriverManager.registerDriver(driver);
		
		
		//Class.forName("com.mysql.cj.jdbc.Driver");

//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");

		Connection conn = ConnectionClass.getconnection();
		
		Statement st = conn.createStatement();

		String query = "select email , id , mobile from student ";

		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {

			String email = rs.getString(1);

			int id = rs.getInt(2);

			long mobile = rs.getLong(3);

			System.out.println(email + " | " + id + " | " + mobile);
		}

	}

}
