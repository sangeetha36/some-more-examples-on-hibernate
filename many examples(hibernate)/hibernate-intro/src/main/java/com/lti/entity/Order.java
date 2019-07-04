package com.lti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="TBL_ORDER")
public class Order {
		@Id
		@GeneratedValue
		@Column(name="ORDER_ID")
		private int id;
		private Date orderDate;
		private double amount;
		@ManyToOne
		@JoinColumn(name="CUST_ID")	//Foreign Key
		private Customer customer;

		@OneToOne
		@JoinColumn(name="PAYMENT_ID")
		private Payment p;
		
		public Payment getP() {
			return p;
		}
		public void setP(Payment p) {
			this.p = p;
		}
	
		@Override
		public String toString() {
			return "Order [id=" + id + ", orderDate=" + orderDate + ", amount=" + amount + ", customer=" + customer
					+ "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		} 
		
}
