package servlet;
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class GenericServletOne extends GenericServlet {
	
	@Override
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
       
		String name = req.getParameter("name");
		
		String age = req.getParameter("age");
		
		String email = req.getParameter("email");
		
		req.setAttribute("uname", name);
		req.setAttribute("uage", age);
		req.setAttribute("uemail", email);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("s6");
		
		dispatcher.include(req, res);
		
		
		
	}

}
