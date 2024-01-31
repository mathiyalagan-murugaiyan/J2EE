package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user")
public class UserHttpservlet extends HttpServlet {
	
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
       String name = req.getParameter("name");
       
       int year = Integer.parseInt(req.getParameter("year"));
       
       int month = Integer.parseInt(req.getParameter("month"));
       
       int day = Integer.parseInt(req.getParameter("day"));
       
       
       
       PrintWriter pw = resp.getWriter();
       
       pw.println( "hello " + name + "your " + year + "old");
      
    }

}
