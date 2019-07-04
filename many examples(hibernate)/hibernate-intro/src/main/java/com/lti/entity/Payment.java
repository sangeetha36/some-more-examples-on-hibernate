package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="TBL_PAYMENT")
public class Payment {
	@Id
	@GeneratedValue
	@Column(name="PAYMENT_ID")
	private int id;
	private double amount;
	private String paymode;
	private Status stat;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymode() {
		return paymode;
	}
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	public Status getStat() {
		return stat;
	}
	public void setStat(Status stat) {
		this.stat = stat;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", mode=" + paymode + ", stat=" + stat + "]";
	}

}
