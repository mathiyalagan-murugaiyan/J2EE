package jdbc_prepareStatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PrepareStatement_Task1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");

		FileInputStream fis = new FileInputStream("E:\\J2EE\\jdbc\\src\\abc.properties");

		Properties p = new Properties();

		p.load(fis);

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", p);

		PreparedStatement pst = con.prepareStatement("select * from student");

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			String name = rs.getString(2);
			Long mobile = rs.getLong(4);

			System.out.println(name + " \t " + mobile);
		}
		con.close();
	}
}
