package assingnments;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class DeleteStatement {

	public static void main(String[] args) throws Exception {
		
		 FileInputStream fis = new FileInputStream("E:\\J2EE\\jdbc\\src\\abc.properties");
		 
		 Properties p = new Properties();
		 p.load(fis);


		 Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", p);
		 
		 Scanner in = new Scanner(System.in);
		 
		 System.out.println("Enter the id");
		 int id = in.nextInt();
		 
		 PreparedStatement pst = con.prepareStatement("delete from employee where id=?");
		 
		 pst.setInt(1, id);
		 
		 pst.executeUpdate();
		 
		 System.out.println(pst.getUpdateCount() +"rows affected");

		 in.close();
		 con.close();
	}

}
