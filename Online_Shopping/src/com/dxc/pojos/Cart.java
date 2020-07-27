package com.dxc.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   
@Table(name="cart_table")
public class Cart
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
   private int product_no;
	private int customer_id;
   private int quantity;

  
public Cart()
   {
	   
   }


public int getSno() {
	return sno;
}


public void setSno(int sno) {
	this.sno = sno;
}


public int getProduct_no() {
	return product_no;
}


public void setProduct_no(int product_no) {
	this.product_no = product_no;
}


public int getCustomer_id() {
	return customer_id;
}


public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}





}




   
   

