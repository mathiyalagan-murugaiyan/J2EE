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
import dao.SellerDao;
import dto.SellerDto;
@SuppressWarnings("serial")
@WebServlet("/login")
public class Login extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String email=req.getParameter("User-Email");
		String Password=req.getParameter("User-Password");
		
		
		
		
		SellerDao Sdao=new SellerDao();
		ProductDao Pdao=new ProductDao();
		
	try {
		SellerDto s1=Sdao.FindByEmail(email);
		if(s1!=null)
		{
		if(s1.getPassword().equals(Password) && s1.getemail().equals(email))
		{
			HttpSession session=req.getSession();
			session.setAttribute("email", email);
			session.setAttribute("Password", Password);
			
			req.setAttribute("products",Pdao.findall());
			RequestDispatcher dispatcher=req.getRequestDispatcher("product.jsp");
			dispatcher.include(req, resp);
		}
		else
		{ req.setAttribute("message","invalid Email / Password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	} 
		else {
			req.setAttribute("message","invalid Email / Password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}
		catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}	

}
