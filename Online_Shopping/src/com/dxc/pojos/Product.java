package com.dxc.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Product 
{
	@Id
    private int product_no;
    private String product_name;
    private int price;
    private int quantity;
    private int discount;
    
    public Product()
    {
    	
    }

	public Product(int product_no, String product_name, int price, int quantity, int discount) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
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

	@Override
	public String toString() {
		return "Product [product_no=" + product_no + ", product_name=" + product_name + ", price=" + price
				+ ", quantity=" + quantity + ", discount=" + discount + "]";
	}
    
    
}
