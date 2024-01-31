package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ProductDao;
import dto.ProductDto;

@WebServlet("/editproduct")
@MultipartConfig(maxFileSize = 1024*1024*100)
public class UpdateProduct extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("User-Id"));
		
		String ProductName=req.getParameter("User-Product");
		double price=Double.parseDouble(req.getParameter("User-price"));
		String Brand=req.getParameter("User-Brand");
		double discount=Double.parseDouble(req.getParameter("User-Discount"));
	    Part image=req.getPart("User-image");
	    
		
		ProductDto p=new ProductDto();
		p.setid(id);
		p.setBrand(Brand);
		p.setdiscount(discount);
		p.setprice(price);
		p.setProductName(ProductName);
		p.setimage(image.getInputStream().readAllBytes());
		
		
		ProductDao Pdao=new ProductDao();
		
		
		try {
			
			if(image.getSize()>1) {
		     Pdao.ProductUpdate(p);
		     req.setAttribute("products", Pdao.findall());
		     RequestDispatcher dispatcher=req.getRequestDispatcher("product.jsp");
		     dispatcher.include(req, resp);
			}
			else
			{
				 ProductDto p1=Pdao.FindById(id);
				p.setimage(p1.getimage());
				Pdao.ProductUpdate(p);
			     req.setAttribute("products", Pdao.findall());
			     RequestDispatcher dispatcher=req.getRequestDispatcher("product.jsp");
			     dispatcher.include(req, resp);
				
			}
		} 
	
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
