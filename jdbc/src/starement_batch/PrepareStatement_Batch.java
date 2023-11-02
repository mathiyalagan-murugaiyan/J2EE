package starement_batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class PrepareStatement_Batch {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=root");

		PreparedStatement pst = null;

		Scanner in = new Scanner(System.in);

		System.out.println("How many rows inerted");
		int limit = in.nextInt();
		int rows = 0;
		boolean condition = true;
		while (condition) {

			System.out.println("Enter the id");
			int id = in.nextInt();
			System.out.println("Enter the name");
			String name = in.next();
			System.out.println("Enter the email");
			String email = in.next();
			System.out.println("Enter the mobile");
			Long mobile = in.nextLong();
			pst = con.prepareStatement("insert into student values (?,?,?,?)");

			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setLong(4, mobile);
			if (rows == limit) {
				condition = false;
			}
			rows++;
		}
		pst.addBatch();
		int[] arr = pst.executeBatch();

		//Arrays.stream(arr).forEach(System.out::println);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}

		in.close();
		con.close();

	}

}
