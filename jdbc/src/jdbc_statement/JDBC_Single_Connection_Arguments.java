package jdbc_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Single_Connection_Arguments {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql:///studentdata?user=root&password=root");
		
		con.setAutoCommit(false);
		
		Statement st = con.createStatement();
		
		String query = "delete from student where id =4";
		
		int result = st.executeUpdate(query);
		
		con.setAutoCommit(true);
		
		System.out.println(result);
		
		con.close();
	}

}
