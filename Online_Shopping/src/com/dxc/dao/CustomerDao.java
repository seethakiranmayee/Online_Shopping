package com.dxc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Bill;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.pojos.Wallet;

public class CustomerDao {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	public boolean authentication(Customer c) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer where customer_id=:customer_id and password=:password ");
		query.setParameter("customer_id", c.getCustomer_id());
		query.setParameter("password", c.getPassword());
		List<Customer> list = query.getResultList();
		for (Customer l : list) {
			System.out.println(c.getCustomer_id());
			System.out.println(l.getCustomer_id());
			System.out.println(c.getPassword());
			System.out.println(l.getPassword());
			if (c.getCustomer_id() == l.getCustomer_id() && c.getPassword().equals(l.getPassword())) {
				return true;
			}

		}

		return false;
	}

	public List<Product> availableProducts() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> list = query.getResultList();
		System.out.println(list);
		return list;
	}

	@Transactional
	public boolean addproducttocart(int i, Cart c, int cust, Product p) {
		System.out.println(c.getProduct_no());
		System.out.println(c.getQuantity());
		if (isAvailable(i)) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query1 = session.createQuery("from Product where product_no=:i");
			query1.setParameter("i", i);

			List<Product> list1 = query1.getResultList();
			for (Product pro : list1) {
				if (c.getQuantity() <= pro.getQuantity()) {
					System.out.println();

					int q = pro.getQuantity() - c.getQuantity();
					session.save(c);
					Query query2 = session
							.createQuery("update Product set quantity=:quantity where product_no=:product_no");
					query2.setParameter("quantity", q);
					query2.setParameter("product_no", c.getProduct_no());
					query2.executeUpdate();
					
				    session.save(c);
					session.getTransaction().commit();

				}
			}
			return true;

		}
		return false;
	}

	public boolean isAvailable(int i) {
		Product p1 = null;
		Session session = sessionFactory.openSession();
		Query query2 = session.createQuery("from Product where product_no=:i");
		query2.setParameter("i", i);
		List<Product> list1 = query2.getResultList();
		try {
			p1 = list1.get(0);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Cart> showCartProducts(int i) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where customer_id=:i");
		query.setParameter("i", i);

		List<Cart> list = query.getResultList();
		System.out.println(list);
		return list;

	}

	public boolean walletBalance(Wallet w, int cid, double bal) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query1 = session.createQuery("from Wallet where customer_id=:cid");
		query1.setParameter("cid", cid);
		List<Wallet> list = query1.getResultList();
		double amount = w.getBalance(); // form balance
		System.out.println("form balance" + amount);
		if (list.isEmpty()) {
			System.out.println("customer id-->" + cid);

			w.setCustomer_id(cid);
			w.setBalance(bal);

			session.save(w);
			session.getTransaction().commit();

		} else {
			for (Wallet w1 : list) {
				System.out.println("inside if loop");
				double balance = w1.getBalance();
				System.out.println("table balance" + balance);

				Session session1 = sessionFactory.openSession();
				session1.beginTransaction();
				balance = balance + amount;
				System.out.println("updated balance" + balance);
				Query query2 = session.createQuery("update Wallet set balance=:balance where customer_id=:customer_id");
				query2.setParameter("balance", balance);
				query2.setParameter("customer_id", cid);
				query2.executeUpdate();
				session1.save(w);
				session.getTransaction().commit();
			}
		}
		return true;
	}

	@Transactional
	public List<Bill> displayBill(int cid, Cart c) {
		Bill b = new Bill();

		// System.out.println(p.getProduct_no());
		System.out.println("display bill");

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query1 = session.createQuery("from Cart where customer_id=:cid");
		query1.setParameter("cid", cid);
		List<Cart> list1 = query1.getResultList();
		for (Cart c1 : list1) {
			System.out.println("inside 1st loop");
			int pid = c1.getProduct_no();
			int quantity = c1.getQuantity();

			Query query = session.createQuery("from Product where product_no=:pid");
			query.setParameter("pid", pid);
			List<Product> list = query.getResultList();
			for (Product p1 : list) {
				System.out.println("inside 2nd loop ");
				int originalprice = p1.getPrice();
				int discount = p1.getDiscount();

				int amount = originalprice * quantity - discount;
				System.out.println("total amount");

				b.setCustomer_id(cid);
				b.setProduct_no(c1.getProduct_no());
				b.setProduct_name(p1.getProduct_name());
				b.setPrice(p1.getPrice());
				b.setQuantity(quantity);
				b.setDiscount(p1.getDiscount());
				b.setTotal_amount(amount);
				session.merge(b);

			}
			// session.getTransaction().commit();
		}
		Query query2 = session.createQuery("from Bill where customer_id=:cid");
		query2.setParameter("cid", cid);
		List<Bill> list2 = query2.getResultList();
		System.out.println(b.getCustomer_id());
		System.out.println(b.getPrice());
		return list2;

	}

	public double getBalance(int cid) {
		Session session = sessionFactory.openSession();
		Query query2 = session.createQuery("from Wallet where customer_id=:cid");
		query2.setParameter("cid", cid);
		List<Wallet> list = query2.getResultList();

		if (!(list.isEmpty())) {
			Wallet w1 = list.get(0);
			return w1.getBalance();

		}
		return 0.0;

	}

	public String payBill(int cid, Bill b, Wallet w) {

		System.out.println("Inside paybill---");

		double finalbill = 0.0;
		String msg = "Failed";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query1 = session.createQuery("from Bill where customer_id=:cid");
		query1.setParameter("cid", cid);
		System.out.println(cid);
		List<Bill> list = query1.getResultList();
		System.out.println("inside cart list of items"+list.size());
		if (list.size() > 0) {
			for (Bill b1 : list) {
				System.out.println("inside 1st fro loop");
				double total_amount = b1.getTotal_amount();
				System.out.println(total_amount);
				finalbill = finalbill + total_amount;
			}

			Query query2 = session.createQuery("from Wallet where customer_id=:cid");
			query2.setParameter("cid", cid);
			List<Wallet> list2 = query2.getResultList();

			Wallet w1 = list2.get(0);

			double balance = w1.getBalance();
			System.out.println(balance);
			if (finalbill <= balance) {
				System.out.println("true true");
				balance = balance - finalbill;
				System.out.println(balance);

				Query query3 = session.createQuery("update Wallet set balance=:balance where customer_id=:cid");
				query3.setParameter("balance", balance);
				query3.setParameter("cid", cid);
				query3.executeUpdate();

				Query query4 = session.createQuery("delete from Cart where customer_id=:cid");
				query4.setParameter("cid", cid);
				query4.executeUpdate();

				Query query5 = session.createQuery("delete from Bill where customer_id=:cid");
				query5.setParameter("cid", cid);
				query5.executeUpdate();

				
				session.getTransaction().commit();
				msg = "success";

			} else {
				msg = "insufficient balance!!!";
				System.out.println("false false");

			}

		} else {
			msg = "cart is empty can't pay the bill";
		}
		return msg;

	}

}
