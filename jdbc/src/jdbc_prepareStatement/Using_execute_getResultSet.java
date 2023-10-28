package jdbc_prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionClass;

public class Using_execute_getResultSet {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	Connection con =	ConnectionClass.getconnection();
	
	PreparedStatement pst = con.prepareStatement("select * from student");
	
	System.out.println(pst.execute());
	
	ResultSet rs =pst.getResultSet();
	
	
	while(rs.next()) {
		
		int id =rs.getInt(1);
		String name = rs.getString(2);
		String email = rs.getString(3);
		Long mobile = rs.getLong(4);
		
		System.out.println(id +" | "+ name+ " | "+ email + " | " +mobile );
	}

	}

}
