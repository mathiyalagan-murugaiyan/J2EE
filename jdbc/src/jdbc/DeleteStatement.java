package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStatement {

	public static void main(String[] args) throws SQLException {
		
		Driver dreiver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(dreiver);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","root");
		
		Statement st = conn.createStatement();
		
		String query= "delete from student where id=2";
		
		int res = st.executeUpdate(query);
		
		System.out.println(res);
		
		conn.close();
		
		
		
		

	}

}
