package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Db2  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 ServletConfig config = getServletConfig();
	        
	        String db2 = config.getInitParameter("emp");
		PrintWriter pw = res.getWriter();
		
		pw.println("employee name is " + db2);
		
		
	}

}
