package callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateStatement {

	public static void main(String[] args) throws SQLException {
		
	
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root","root");
			
			Scanner in = new Scanner(System.in);
			
			System.out.println("Enter the update id");
			int id = in.nextInt();
			
			System.out.println("Enter the name");
			String name = in.next();
			
			System.out.println("Enter the email");
			String email = in.next();
			
			System.out.println("Enter the mobile");
			Long mobile = in.nextLong();
			
			CallableStatement cst = con.prepareCall("call studentdata.update_student(?,?,?,?)");
			
			cst.setString(1, name);
			cst.setString(2, email);
			cst.setLong(3, mobile);
			cst.setInt(4, id);
			
			System.out.println(cst.executeUpdate());
			
		    in.close();
		    con.close();
		
		

	}

}
