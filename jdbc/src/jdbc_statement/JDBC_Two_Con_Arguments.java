package jdbc_statement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC_Two_Con_Arguments {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("E:\\J2EE\\jdbc\\src\\abc.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata",p);
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter The Id");
		int id = in.nextInt();
		
		System.out.println("Enter The Name");
		String name = in.next();
		
		System.out.println("Enter The Email");
		String email = in.next();
		
		System.out.println("Enter the Mobile");
		
		Long mobile = in.nextLong();
		
		String query= "insert into student values (?,?,?,?)";
		
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setString(3, email);
		pst.setLong(4, mobile);
		
	   int res = pst.executeUpdate();
		
		System.out.println("one row affected" + res);
		
		con.close();
		
		
		

	}

}
