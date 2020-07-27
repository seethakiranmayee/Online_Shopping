package com.dxc.services;

import java.util.List;

import com.dxc.dao.AdminDao;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;

public class AdminService 
{
	AdminDao dao=new AdminDao();
	
	/*public void adminlogin(Admin a)
	{
		 dao.adminlogin(a);
	}*/
	public boolean authentication(Admin a)
	{
		return dao.authentication(a);
	}
	public boolean addProduct(Product p)
	{
		return dao.addProduct(p);
	}
	
	 public List<Product> showProducts()
	 {
		 return dao.showProducts();
	 }
	 
	 public List<Product> getparticularproduct(int i)
	 {
		 return dao.getparticularproduct(i);
	 }
	 
	 public void addCustomer(Customer c)
	 {
		 dao.addCustomer(c);
	 }
	 
	 public boolean removeCustomer(int i)
	 {
		 return dao.removeCustomer(i);
	 }
	 
}
