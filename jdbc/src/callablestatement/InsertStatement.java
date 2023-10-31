package callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStatement {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=root");

		Scanner in = new Scanner(System.in);

		System.out.println("Enter the id");
		int id = in.nextInt();
		System.out.println("Enter the name");
		String name = in.next();
		System.out.println("Enter the email");
		String email = in.next();
		System.out.println("Enter the mobile");
		Long mobile = in.nextLong();

		CallableStatement cst = con.prepareCall("call studentdata.insert_student(?,?,?,?)");

		cst.setInt(1, id);
		cst.setString(2, name);
		cst.setString(3, email);
		cst.setLong(4, mobile);

		System.out.println(cst.execute());

		System.out.println(cst.getUpdateCount() + " rows inserted");
		
		in.close();
		con.close();

	}

}
