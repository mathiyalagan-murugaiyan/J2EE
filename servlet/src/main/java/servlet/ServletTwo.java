package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletTwo implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String num1 =  req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		PrintWriter pw = res.getWriter();
		pw.println(num1);
		pw.println(num2);
		
		int number1 =Integer.parseInt(num1) ;
		
		int number2 = Integer.parseInt(num2);
		
		pw.println("sum of 2 numbers = " + (number1+number2));
		
		pw.println("mul is 2 numbera = " +(number1*number2));
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
