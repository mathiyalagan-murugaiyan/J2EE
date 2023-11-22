package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletTwo  extends GenericServlet{
	
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	String name = (String) req.getAttribute("uname");
	String age1 = (String) req.getAttribute("uage");
	
	int age = Integer.parseInt(age1) ;
	
	String email = (String)req.getAttribute("uemail");
	
	PrintWriter pw = res.getWriter();
	
	pw.println("user name is    "+ name);
	
	pw.println("user age is     " + age);
	
	pw.println("user email is   "+ email);
       
		
		
		
		
	}

}
