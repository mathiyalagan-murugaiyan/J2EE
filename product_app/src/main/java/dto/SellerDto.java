package dto;

public class SellerDto {
	
	private int id;
	private String name;
	private long contact;
	private String email;
	private String Password;
	
	
	public void setid( int id)
	{
		this.id=id;
	}
	public void setname( String name) 
	{
		this.name=name;
	}
	public void setcontact(long contact)
	{
		this.contact=contact;
	}
	public void setemail(String email)
	{
		this.email=email;
	}
	public void setPassword(String Password)
	{
		this.Password=Password;
	}
	
	
	
	public int getid() 
	{
		return id;
	}
	public String getname()
	{
		return name;
	}
	public String getemail()
	{
		return email;
	}
	public long getcontact()
	{
		return contact;
	}
	public String getPassword()
	{
		return Password;
	}
	

}
