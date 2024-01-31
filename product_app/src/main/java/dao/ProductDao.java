package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.ProductDto;

public class ProductDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/productdatabase","root","root");
	}
	
	public int ProductInsert(ProductDto p) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdatabase","root","root");
		
		PreparedStatement pst=c.prepareStatement("insert into product values(?,?,?,?,?,?)");
		pst.setInt(1,p.getid());
		pst.setString(2,p.getProductName());
		pst.setDouble(3,p.getprice());
		pst.setString(4,p.getBrand() );
		pst.setDouble(5,p.getdiscount());
		Blob image=new SerialBlob(p.getimage());
		pst.setBlob(6, image);
		
		
		int insert=pst.executeUpdate();
		c.close();
		return insert;
	}
	public int ProductDelete( int id) throws ClassNotFoundException, SQLException
	{
         Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdatabase","root","root");
		
		PreparedStatement pst=c.prepareStatement("delete from product where id=?");
		pst.setInt(1,id);
		
		
		int delete=pst.executeUpdate();
		c.close();
		return delete;
	}
	
	public int ProductUpdate(ProductDto p) throws ClassNotFoundException, SQLException
	{

        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdatabase","root","root");
		
		PreparedStatement pst=c.prepareStatement("update product set name=?,price=?,Brand=?,discount=?,image=? where id=?");
		 
		
		pst.setInt(6,p.getid());
		pst.setString(1,p.getProductName());
		pst.setDouble(2,p.getprice());
		pst.setString(3,p.getBrand() );
		pst.setDouble(4,p.getdiscount());
		Blob image=new SerialBlob(p.getimage());
		pst.setBlob(5,image);
		
		
		int update=pst.executeUpdate();
		c.close();
		return update;
	}
    public ProductDto FindById(int id) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdatabase","root","root");
		
    	PreparedStatement pst= c.prepareStatement("select * from product where id=?");
    	
    	pst.setInt(1, id);
    	ProductDto p=new ProductDto();
    	ResultSet rs= pst.executeQuery();
    	if(rs.next())
    	{
    	
    	p.setid(rs.getInt(1));
		p.setProductName(rs.getString(2));
		p.setprice(rs.getDouble(3));
		p.setBrand(rs.getString(4) );
		p.setdiscount(rs.getDouble(5));
		Blob blob=rs.getBlob(6);
		byte[] image=blob.getBytes(1l, (int)blob.length());
		p.setimage(image);
    	}
		
		
    	
	c.close();
    	return p;
    }
    public List<ProductDto>  findall() throws ClassNotFoundException, SQLException
    {
    	

        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdatabase","root","root");
		
    	PreparedStatement pst=c.prepareStatement("select * from product");
    	ResultSet rs=pst.executeQuery();
    	List<ProductDto> products=new ArrayList<ProductDto>();
    	while(rs.next())
    	{
        	ProductDto p=new ProductDto();
        	p.setid(rs.getInt(1));
    		p.setProductName(rs.getString(2));
    		p.setprice(rs.getDouble(3));
    		p.setBrand(rs.getString(4) );
    		p.setdiscount(rs.getDouble(5));
    		Blob blob=rs.getBlob(6);
    		byte[] image=blob.getBytes(1, (int)blob.length());
    		p.setimage(image);
    		
    		products.add(p);
    		
    		
        	
    	}
    	c.close();
    	return products;
    }
    
   
	

}
