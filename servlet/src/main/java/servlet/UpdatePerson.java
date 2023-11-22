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

@WebServlet("/updateperson")
public class UpdatePerson extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		    String name = req.getParameter("name");
	        int age = Integer.parseInt(req.getParameter("age"));
	        String email = req.getParameter("email");
	        
                  try {
                	  Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root","root");
					
					  PreparedStatement pst = con.prepareStatement("update new_table set name=?, age=?,  email=? where name=?");
			           pst.setString(1, name);
			           pst.setInt(2, age);
			           pst.setString(3, email);
			           pst.setString(4, name);
			           int res1 = pst.executeUpdate();
					
					PrintWriter pw = res.getWriter();
					
					pw.println(name + " "+ age + " "+ email );
					
					
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}
