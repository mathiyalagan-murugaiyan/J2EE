package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/delete")
public class DeletePerson extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		 String name = req.getParameter("name");
		 
		 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
 		
 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root","root");

         PreparedStatement pst = con.prepareStatement("delete from new_table where name= ?");
         pst.setString(1, name);
         
         pst.executeUpdate();
         
         PrintWriter pw = res.getWriter();
         
         pw.println(" deleted the person " + name);
          
    } catch (SQLException e) {
        e.printStackTrace(); // Handle exceptions appropriately
    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
