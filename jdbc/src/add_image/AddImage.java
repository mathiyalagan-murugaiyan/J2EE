package add_image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddImage {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=root");
		
		
		//FileInputStream fis = new FileInputStream("E:\\workspace_webtech\\image\\dog.jpg");
		
		FileInputStream fis1 = new FileInputStream("E:\\workspace_webtech\\image\\dog1.jpg");
		
		PreparedStatement pst = con.prepareStatement("insert into img_table values(?,?)");
		
		pst.setInt(1, 2);
		pst.setBlob(2, fis1);
		
		int res = pst.executeUpdate();
		
		System.out.println(res);
		con.close();
	}

}
