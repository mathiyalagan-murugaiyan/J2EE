package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.SellerDto;

public class SellerDao {
	
	public int InsertSellerDetails(SellerDto s) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerdatabase","root","root");
		
		PreparedStatement pst=c.prepareStatement("insert into seller values(?,?,?,?,?)");
		
		pst.setInt(1, s.getid());
		pst.setString(2,s.getname());
		pst.setLong(3, s.getcontact());
		pst.setString(4,s.getemail());
		pst.setString(5,s.getPassword());
		
		int res= pst.executeUpdate();
		
		c.close();
		return res;
	}

	public SellerDto FindByEmail (String email) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerdatabase","root","root");
		
		PreparedStatement pst=c.prepareStatement("select * from seller where email=?");
		pst.setString(1,email);
		ResultSet rs=pst.executeQuery();
		
		
		if(rs.next())
		{
			SellerDto s=new SellerDto();
		s.setid(rs.getInt(1));
		s.setname(rs.getString(2));
		s.setcontact(rs.getLong(3));
		s.setemail(rs.getString(4));
		s.setPassword(rs.getString(5));
		
		
		c.close();
		
		
		return s;
		}
		else {
			SellerDto s=null;
			c.close();
			return s;
		}
	}
	
	
	

}
