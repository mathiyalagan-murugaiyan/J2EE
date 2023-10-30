package assingnments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePrepareStqatement {

	public static void main(String[] args) throws SQLException {

   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=root");
   
   Scanner in = new Scanner(System.in);
   
   System.out.println("Enter the slary");
   Double salary = in.nextDouble();
   
   System.out.println("Enter the id");
   int id = in.nextInt();
   
   PreparedStatement pst = con.prepareStatement("update employee set salary=? where id=?");
   
   pst.setDouble(1, salary);
   pst.setInt(2, id);
   
   pst.executeUpdate();
   
   System.out.println( pst.getUpdateCount() + "rows affected");

	}

}
