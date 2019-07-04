package com.lti.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_acc")
public class Account {
	
	@Id
	@Column(name="acc_no")
	@GeneratedValue
	private long accno;
	
	private String name;
	@Column(name="acc_type")
	private String type;
	private double balance;
	
	@OneToMany(mappedBy="account")
	private Set<BankTransaction> transactions;

	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<BankTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<BankTransaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accno=" + accno + "]";
	}



	
}
