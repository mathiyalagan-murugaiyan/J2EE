package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;


@WebServlet("/delete")
public class Delete extends HttpServlet {

	
	
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

	
		
	
		
	int id=	Integer.parseInt(req.getParameter("id"));
	ProductDao Pdao=new ProductDao();
	
	
	try {
		HttpSession session=req.getSession();
		String email=(String)session.getAttribute("email");
		String Password=(String)session.getAttribute("Password");
		 if(email!=null && Password!=null)
		 { 
			 Pdao.ProductDelete(id);
			 req.setAttribute("products", Pdao.findall());
	       RequestDispatcher dispatcher=req.getRequestDispatcher("product.jsp");
	       dispatcher.include(req, resp);
		 }
		 else {
			 req.setAttribute("message","login Required");
			 RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			 dispatcher.include(req, resp);
			 
		 }
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
