package assingnments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;

		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");

			
			String createTableSQL = "create table employee (" + "id int, " + "name varchar(40), "
					+ "gender varchar(6), " + "email varchar(25), " + "salary decimal(10, 2))";

			pst = con.prepareStatement(createTableSQL);

			pst.execute();

			System.out.println("Table 'employee' created successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();

		} finally {
			pst.close();

			con.close();

		}
	}
}
