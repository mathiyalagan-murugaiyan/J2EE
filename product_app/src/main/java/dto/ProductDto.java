package dto;

import java.util.Arrays;

public class ProductDto {

	
	private int id;
	private String ProductName;
	private double price;
	private String Brand;
	private double discount;
	private byte[] image;
	
	
	
	public void setid(int id)
	{
		this.id=id;
	}
	public void setProductName(String ProductName)
	{
		this.ProductName=ProductName;
	}
	public void setprice(double price)
	{
		this.price=price;
	}
	public void setBrand(String Brand)
	{
		this.Brand=Brand;
	}
	public void setdiscount(double discount)
	{
		this.discount=discount;
	}
	public void setimage(byte[] image)
	{
		this.image=image;
	}
	
	
	
	
	public int getid() 
	{
		return id;
	}
	public String getProductName()
	{
		return ProductName;
	}
	public double getprice()
	{
		return price;
	}
	public String getBrand()
	{
		return Brand;
	}
	public double getdiscount()
	{
		return discount;
	}
	public byte[] getimage()
	{
		return image;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", ProductName=" + ProductName + ", price=" + price + ", Brand=" + Brand
				+ ", discount=" + discount + ", image=" + Arrays.toString(image) + "]";
	}
	
}
	
	
