package com.dxc.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet 
{
   @Id
   private int customer_id;
   private double balance;
   
   public Wallet()
   {
	   
   }

public int getCustomer_id() {
	return customer_id;
}

public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}
   
   
}
