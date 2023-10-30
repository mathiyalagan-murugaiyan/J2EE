package assingnments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.ConnectionClass;

public class InsertPrepareStatement {

	public static void main(String[] args) throws SQLException {
		
	Connection con =	ConnectionClass.getconnection();
	PreparedStatement pst = null;
	
	int count =0;
	
	while(count<5) 
	{
	
	Scanner in = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = in.nextInt();
		System.out.println("Enter the name");
		String name = in.next();
		System.out.println("Enter the gender");
		String gender = in.next();
		System.out.println("Enter the email");
		String email = in.next();
		System.out.println("Enter the salary");
		Long salary = in.nextLong();
		
		pst = con.prepareStatement("insert into employee values (?,?,?,?,?)");
		
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setString(3, gender);
		pst.setString(4, email);
		pst.setLong(5, salary);
	
	System.out.println( pst.execute());
	 count ++;
	}
	
	System.out.println(count + "  rows affected");
	con.close();
	}
}
