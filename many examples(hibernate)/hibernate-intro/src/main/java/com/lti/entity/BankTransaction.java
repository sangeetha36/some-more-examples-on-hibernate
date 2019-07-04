package com.lti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_acc_tx")
public class BankTransaction {

	@Id
	@GeneratedValue
	private long txno;
	
	@Column(name="tx_date")
	private Date date;
	
	@Column(name="tx_type")
	private String type;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="acc_no")
	private Account account;

	public long getTxno() {
		return txno;
	}

	public void setTxno(long txno) {
		this.txno = txno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "BankTransaction [txno=" + txno + ", date=" + date + ", type=" + type + ", amount=" + amount
				+ ", account=" + account + "]";
	}
	
	
}
