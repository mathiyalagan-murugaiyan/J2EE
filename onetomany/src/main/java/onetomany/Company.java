package onetomany;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Company {
	
	private int id;
	
	private String cname;
	
	private String caddres;
	
	private List<Employee> ems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddres() {
		return caddres;
	}

	public void setCaddres(String caddres) {
		this.caddres = caddres;
	}

	public List<Employee> getEms() {
		return ems;
	}

	public void setEms(List<Employee> ems) {
		this.ems = ems;
	}

	public Company(int id, String cname, String caddres, List<Employee> ems) {
		super();
		this.id = id;
		this.cname = cname;
		this.caddres = caddres;
		this.ems = ems;
	}
	
	public Company() {
		
	}
	

}
