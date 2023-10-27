package jdbc_prepareStatement;

import java.util.*;

import connection.ConnectionClass;

import java.sql.*;

public class InsertStatement {

	public static void main(String[] args) throws SQLException {

		Connection con  = ConnectionClass.getconnection();

		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Enter the id");

			int id = in.nextInt();

			System.out.println("Enter the name");

			String name = in.next();

			System.out.println("Enter the E-mail");

			String email = in.next();

			System.out.println("Enter the mobile number");

			long mobile = in.nextLong();

			PreparedStatement pst = con.prepareStatement("insert into student values (?,?,?,?)");

			pst.setInt(1, id);
			pst.setString(3, email);
			pst.setString(2, name);
			pst.setLong(4, mobile);
			System.out.println(pst.executeUpdate());
		}

		con.close();

	}

}
