package com.dxc.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer 
{

	@Id
	private int customer_id;
	private String name;
	private String password;
	
	public Customer()
	{
		
	}
	
	public Customer(int customer_id, String name, String password) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.password = password;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
}
