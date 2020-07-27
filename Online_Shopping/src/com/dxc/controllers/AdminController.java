package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dxc.dao.AdminDao;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.services.AdminService;

@Controller
@RequestMapping("/views")
public class AdminController 
{
	String message;
	AdminService service=new AdminService();
	AdminDao dao=new AdminDao();
	
	
	@RequestMapping("/adminlogin")
	public String authentication(@ModelAttribute Admin a,HttpSession session)
	{
		boolean b=service.authentication(a);
		if(b)
		{
			 message="Successfully Login!!!";
			session.setAttribute("message", message);
			return "adminloginmenupage";
		}
		else
		{
			 String str="Invalid login!!!";
			session.setAttribute("str", str);
			return "invalid";
		}
		
	}
	
	@RequestMapping("/addproduct")
	public String addProduct(@ModelAttribute Product p,HttpSession session)
	{
		service.addProduct(p);
		message="Product added successfully!!!";
		session.setAttribute("message", message);
		return "addproduct";
				
		
	}
	
	@RequestMapping("/getAllProducts")
	public String showProducts(Model m)
	{
		List<Product> list=service.showProducts();
		m.addAttribute("list", list);
		return "showproduct";
	}
	
	@RequestMapping("/particularproduct")
	public String particularProduct(@RequestParam("product_no") int i,Model m)
	{
		String status="Product Not found!!!";
		m.addAttribute("status", status);
	
		List<Product> list1=service.getparticularproduct(i);
		for(Product p:list1)
		{
			if(p.getProduct_no()==i)
			{
				m.addAttribute("list1", list1);
				return "productfound";
			}
		}
		return "noproductfound";
		
	}
	
	
	  @RequestMapping("/addcustomer")
	public String addCustomer(@ModelAttribute Customer c,HttpSession session)
	{
		 session.setAttribute("c", c.getCustomer_id());
		service.addCustomer(c);
		message="Customer added successfully!!!";
		session.setAttribute("message", message);
		return "addcustomer";
				
		
	}
	  @RequestMapping("/removecustomer")
	  public String removeCustomer(@RequestParam("customer_id") int id ,Model m,HttpSession session)
	  {
		 boolean b=service.removeCustomer(id);
		 if(b)
		 {
			 message="Customer removed Successfully!!!";
			 session.setAttribute("message", message);
			 return "removecustomerfound";
			 
		 }
		 else
		 {
			 message="customer not found";
			 session.setAttribute("message", message);
			 return "customernotfound";
		 }
	  }
}





