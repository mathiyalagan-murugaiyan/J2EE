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


@WebServlet("/demo2")
public class Demo2 extends GenericServlet {

  

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");

        try {
          
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root","root");

            PreparedStatement pst = con.prepareStatement("insert into new_table values (?,?,?)");
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, email);
            int res1 = pst.executeUpdate();
            System.out.println(name );
   
            PrintWriter pw = res.getWriter();
            
            pw.println( res1 + " " +name + " " + age+ " " +email);
           
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }

   
}
