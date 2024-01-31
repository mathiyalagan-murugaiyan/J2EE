package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDao;
import dto.ProductDto;
@WebServlet("/addproduct")
@MultipartConfig(maxFileSize=1024*1024*100)


public class AddProduct extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		ProductDto p=new ProductDto();
		int id=Integer.parseInt(req.getParameter("User-Id"));
		String ProductName=req.getParameter("User-Product");
		double price=Double.parseDouble(req.getParameter("User-price"));
		String Brand=req.getParameter("User-Brand");
		double discount=Double.parseDouble(req.getParameter("User-Discount"));
	    Part image=req.getPart("User-image");
	    
	   
	    
		
		
	    p.setid(id);
		p.setProductName(ProductName);
		p.setBrand(Brand);
		p.setprice(price);
		p.setdiscount(discount);
		p.setimage(image.getInputStream().readAllBytes());
		
		
	ProductDao Pdao= new ProductDao();
	
	
	try {
		int res=Pdao.ProductInsert(p);
		
	/*	if(res==1)
		{
			PrintWriter pw=resp.getWriter();
			pw.println("data Saved");
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.println("data failed");
		}*/
		if(res==1)
		{
			//req.setAttribute("message","data is successfully added");
			req.setAttribute("products", Pdao.findall());
			RequestDispatcher dispatcher=req.getRequestDispatcher("product.jsp");
			dispatcher.include(req, resp);
			
		}
		else {
			

			req.setAttribute("message","data is not successfully added");
			RequestDispatcher dispatcher=req.getRequestDispatcher("addproduct.jsp");
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