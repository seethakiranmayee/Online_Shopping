package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.dao.CustomerDao;
import com.dxc.pojos.Bill;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Product;
import com.dxc.pojos.Wallet;
import com.dxc.services.CustomerService;

@Controller
@RequestMapping("/views")
public class CustomerController {
	String message;
	CustomerService service = new CustomerService();
	CustomerDao dao = new CustomerDao();

	@RequestMapping("/userlogin")
	public String authentication(@ModelAttribute Customer a, HttpSession session) {
		int id = a.getCustomer_id();
		session.setAttribute("id", id);
		boolean b = service.authentication(a);
		if (b) {
			message = "Successfully Login!!!";
			session.setAttribute("message", message);
			return "userloginmenupage";
		} else {
			String str = "Invalid login!!!";
			session.setAttribute("str", str);
			return "invalid";
		}

	}

	@RequestMapping("/getAvailableProducts")
	public String availableProducts(Model m) {
		List<Product> list = service.availableProducts();
		m.addAttribute("list", list);
		return "availableproducts";
	}

	@RequestMapping("/addtocart")
	public String addproducttocart(@RequestParam("product_no") int i, @ModelAttribute Cart c, @ModelAttribute Product p,
			HttpSession session, Model m) {
		int cust = (int) session.getAttribute("id");
		c.setCustomer_id(cust);
		boolean b = service.addproducttocart(i, c, cust, p);
		if (b) {
			message = "Sussessfully added to cart";
			m.addAttribute("message", message);
			return "addtocart";
		} else {
			message = "product is not found can't able to add to cart";
			m.addAttribute("message", message);
			return "cartnotfound";
		}
	}

	@RequestMapping("/getcartproducts")
	public String showCartProducts(Model m, HttpSession session) {
		int id = (int) session.getAttribute("id");
		List<Cart> list = service.showCartProducts(id);

		if (!(list.isEmpty())) {
			m.addAttribute("list", list);
			return "showcartproduct";
		} else {
			message = "cart is empty!!!";
			m.addAttribute("message", message);
			return "cartempty";
		}

	}

	@RequestMapping("/addbalancetowallet")
	public String walletBlance(HttpSession session, @ModelAttribute Wallet w, Model m) {
		int cid = (int) session.getAttribute("id");
		w.setCustomer_id(cid);
		double bal = w.getBalance();
		boolean b = service.walletBalance(w, cid, bal);
		if (b) {
			message = "Balance is addedd successfully to the wallet!!!!";
			m.addAttribute("message", message);
			return "wallet";
		}
		return message;
	}

	@RequestMapping("/getbalance")
	public String getBlance(HttpSession session, @ModelAttribute Wallet w, Model m) {
		int cid = (int) session.getAttribute("id");
		double balance = service.getBalance(cid);
		m.addAttribute("balance", balance);
		return "getBalance";
	}

	@RequestMapping("/displaybill")
	public String displayBill(@ModelAttribute Bill b, @ModelAttribute Product p, @ModelAttribute Cart c,
			HttpSession session, Model m) {
		int cid = (int) session.getAttribute("id");
		List<Bill> bill = service.displayBill(cid, c);
		if (!(bill.isEmpty())) {
			m.addAttribute("bill", bill);
			b.setCustomer_id(cid);
			return "displaybill";
		} else {
			message = "your cart is empty please add the product into ur cart for to generate the bill";
			m.addAttribute("message", message);
			return "nobilldisplay";
		}
	}

	@RequestMapping("/paybill")
	public String payBill(@ModelAttribute Wallet w, @ModelAttribute Bill b, Model m, HttpSession session) {
		int cid = (int) session.getAttribute("id");

		String msg = service.payBill(cid, b, w);
		if (msg.equals("success"))
		{
			msg="successfully paid Thanks for shopping with us!!!";
			m.addAttribute("msg", msg);
			return "paybill";
		} else {

			m.addAttribute("msg", msg);
			return "nobillgenerate";
		}

	}
}
