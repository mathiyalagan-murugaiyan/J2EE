package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SellerDao;
import dto.SellerDto;
@WebServlet("/signup")
public class Seller extends HttpServlet{

	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		SellerDto s= new SellerDto();
		int id=Integer.parseInt(req.getParameter("User-Id"));
		String name=req.getParameter("User-Name");
		String email=req.getParameter("User-Email");
		String password=req.getParameter("User-Password");
		long contact=Long.parseLong(req.getParameter("User-Contact"));
		
	
		s.setid(id);
		s.setname(name);
		s.setcontact(contact);
		s.setemail(email);
		s.setPassword(password);
		s.setid(id);
		
		SellerDao Sdao=new SellerDao();
		
		
	     try {
			int result=Sdao.InsertSellerDetails(s);
			if(result==1)
			{
				req.setAttribute("message","signup success");
				RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("message","signup failed");
				RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
