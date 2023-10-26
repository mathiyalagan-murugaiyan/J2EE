
package jdbc_prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import connection.ConnectionClass;

public class ReadStatement {

	public static void main(String[] args) throws SQLException {
		
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");
//		
		Connection con = ConnectionClass.getconnection();
		
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Enter the id");
			
			int userid = in.nextInt();
			
			PreparedStatement pst = con.prepareStatement("select * from student where id = ?");
			
			pst.setInt(1, userid);
			
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			int id=rs.getInt(1);
			String name =rs.getString(2);
			String email =rs.getString(3);
			Long mobile =rs.getLong(4);
			
			System.out.println(id +" | " + name+ " | " +email+ " | "+ mobile);
		}
		
		con.close();
		

	}

}
