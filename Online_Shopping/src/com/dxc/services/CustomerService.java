package com.dxc.services;

import java.util.List;

import com.dxc.dao.CustomerDao;
import com.dxc.pojos.Bill;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.pojos.Wallet;

public class CustomerService 
{
   CustomerDao dao=new CustomerDao();
   
   public boolean authentication(Customer c)
   {
	   return dao.authentication(c);
   }
   
   public List<Product> availableProducts()
   {
      return dao.availableProducts();
   }
   /*public void addproducttocart(Cart c)
   {
	   dao.addproducttocart(c);
   }*/
   
   public boolean addproducttocart(int i,Cart c,int cust,Product p) 
   {
	   return dao.addproducttocart(i,c, cust, p);
   }
   
   public List<Cart> showCartProducts(int i)
   {
	   return dao.showCartProducts(i);
   }
   public boolean walletBalance(Wallet w,int cid,double bal)
   {
	  return dao.walletBalance(w,cid,bal);
   }
   
   public double getBalance(int cid)
   {
	   return dao.getBalance(cid);
   }
   
   public List<Bill> displayBill(int cid,Cart c)
   {
	   return dao.displayBill(cid, c);
   }
   
   public String payBill(int cid,Bill b,Wallet w)
   {
	   return dao.payBill(cid, b, w);
   }
   
}  
