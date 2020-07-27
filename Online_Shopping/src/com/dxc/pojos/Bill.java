package com.dxc.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill 
{

	
   private int customer_id;
   private int product_no;
   private String product_name;
   private int price;
   private int quantity;
   @Id
   private int discount;
   private double total_amount;
   
   public Bill()
   {
	   
   }

public int getCustomer_id() 
{
	return customer_id;
}

public int getProduct_no() {
	return product_no;
}

public void setProduct_no(int product_no) {
	this.product_no = product_no;
}

public String getProduct_name() {
	return product_name;
}

public void setProduct_name(String product_name) {
	this.product_name = product_name;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getDiscount() {
	return discount;
}

public void setDiscount(int discount) {
	this.discount = discount;
}

public double getTotal_amount() {
	return total_amount;
}

public void setTotal_amount(double total_amount) {
	this.total_amount = total_amount;
}

public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}


   
}
