package callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStatement {

	public static void main(String[] args) throws SQLException {


		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root", "root");
		
		Scanner in =new Scanner (System.in);
		
		System.out.println("Enter the id");
		
		int id = in.nextInt();
		
		CallableStatement cst = con.prepareCall("call studentdata.delete_student(?)");
		
		cst.setInt(1, id);
		
		System.out.println(cst.executeUpdate());
		
		in.close();
		con.close();

	}

}
