package jdbc_prepareStatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Assingnment2 {

	public static void main(String[] args) throws SQLException, IOException {
		
		FileInputStream fis = new FileInputStream("E:\\J2EE\\jdbc\\src\\abc.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata",p );
		
		Statement st = con.createStatement();
		
		String query = "delete from student where id= 9";
		
		 int result = st.executeUpdate(query);
		 
		 System.out.println(result + " row dleted " );
		 
		 con.close();
		
		
		
		
		

	}

}
