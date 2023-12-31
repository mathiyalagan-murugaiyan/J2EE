package jdbc_prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Assingnment {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=root");

		Scanner in = new Scanner(System.in);

		PreparedStatement pst;

		boolean condition = true;

		int rows = 0,res = 0;

		System.out.println("how many rows you want inserted");
		int limit = in.nextInt();

		while (condition == true) {

			System.out.println("Enter The id");
			int id = in.nextInt();

			System.out.println("Enter The name");
			String name = in.next();

			System.out.println("Emter The email");
			String email = in.next();

			System.out.println("Enter The mobile");
			Long mobile = in.nextLong();

			pst = con.prepareStatement("insert into student values (?,?,?,?)");

			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setLong(4, mobile);

			res =pst.executeUpdate();
			rows++;

			if (rows == limit) {
				condition = false;
				break;
			}
		}
		System.out.println(res + " rows affected");
		in.close();
		con.close();
	}

}
