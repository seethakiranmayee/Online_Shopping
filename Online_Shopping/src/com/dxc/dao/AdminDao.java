package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;


public class AdminDao 
{

	private static SessionFactory sessionFactory;
	
	static{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	  public boolean authentication(Admin a)
	  {
		  Session session=sessionFactory.openSession();
		 Query query=session.createQuery("from Admin where id=:id and password=:password ");
		 query.setParameter("id", a.getId());
		 query.setParameter("password", a.getPassword());
		 List<Admin>list=query.getResultList(); 
		 for(Admin l:list) 
		 {
			 System.out.println(a.getId());
			 System.out.println(l.getId());
			 System.out.println(a.getPassword());
			 System.out.println(l.getPassword());	 
		 if(a.getId().equals(l.getId()) && a.getPassword().equals(l.getPassword())) {
		 return true; 
		 } 
		 
		 }
		
		 
		return false;
	}
	  
	  public boolean addProduct(Product p)
	  {
		 System.out.println(p.getProduct_no());
		 Session session=sessionFactory.openSession();
		  session.beginTransaction();
		  session.save(p);
		  session.getTransaction().commit();
    return true;
		 
	  }
	  
	  public List<Product> showProducts()
	  {
		  Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
			  List<Product> list=query.getResultList();
			  System.out.println(list);
			  return list;
		  
	  }
	  
	  public List<Product> getparticularproduct(int i)
	  {
		  List<Product> list = new ArrayList<>();
		  if(findproduct(i))
		  {
			  System.out.println("pnumber-"+i);
		  Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Product where product_no=:i");
			     query.setParameter("i", i);
				  List<Product> list1=query.getResultList();
				  System.out.println(list1);
				  return list1;
		  }
		return list;
	  }
	  public boolean findproduct(int i)
	  {
		  Product p=null;
		  Session session=sessionFactory.openSession();
		  Query query2=session.createQuery("from Product where product_no=:i");
		  query2.setParameter("i", i);
		  System.out.println(i);
		  List<Product> list1=query2.getResultList();
		  try
		  {
			  p=list1.get(0);
			  return true;
		  }
		  catch(Exception e)
		  {
		  return false;
	      }
	  }
	  
	  
	  public void addCustomer(Customer c)
	  {
		 System.out.println(c.getCustomer_id());
		 System.out.println(c.getName());
		 System.out.println(c.getPassword());
		 
		  Session session=sessionFactory.openSession();
		  session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
		 
	  }
	  
	  public boolean removeCustomer(int i)
	  {
		  
		 
		  if(findCustomer(i))
		  {
		  Session session=sessionFactory.openSession();
			session.beginTransaction();
			Query query1=session.createQuery("delete from Customer where customer_id=:i");
			query1.setParameter("i",i);
			query1.executeUpdate();
			session.getTransaction().commit();
			return true;
			
	  }
	  return false;
	  }
	  
	  public boolean findCustomer(int i)
	  {
		  Customer c=null;
		  Session session=sessionFactory.openSession();
		  Query query2=session.createQuery("from Customer where customer_id=:i");
		  query2.setParameter("i", i);
		  System.out.println(i);
		  List<Customer> list1=query2.getResultList();
		  try
		  {
			  c=list1.get(0);
			  return true;
		  }
		  catch(Exception e)
		  {
		  return false;
	      }
	  }
}
