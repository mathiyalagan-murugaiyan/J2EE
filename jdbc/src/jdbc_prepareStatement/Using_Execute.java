package jdbc_prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Using_Execute{

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root","root");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the id");
		
		int id = in.nextInt();

		PreparedStatement pst = con.prepareStatement("delete from student where id =?");
		
		pst.setInt(1, id);
		
		boolean result = pst.execute();
		
		System.out.println(result);
		
		System.out.println(pst.getUpdateCount());
	}

}
