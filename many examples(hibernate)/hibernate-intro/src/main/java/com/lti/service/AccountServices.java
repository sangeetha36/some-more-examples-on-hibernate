package com.lti.service;

import java.util.Date;
import java.util.List;

import com.lti.dao.AccountDao;
import com.lti.entity.Account;
import com.lti.entity.BankTransaction;

//Classes which contain business are commonly referred to as Service classes
//people also use this naming convention in WebServices(SOAP/REST)
public class AccountServices { 
	
    
	public void openAccount(Account acc) {
		 AccountDao dao= new AccountDao();
		 dao.save(acc);
		 //apart from this we might write/execute the code for sending
		 //email to the customer here
	}
	public void withdraw(long accno,double amount) {
		AccountDao dao = new AccountDao();
		BankTransaction bt= new BankTransaction();
		
		bt.setDate(new Date());
		bt.setType("withdraw");
		bt.setAmount(amount);
		
		Account  acc = (Account) dao.fetchById(Account.class, accno);
		
		double balance= acc.getBalance();
		if ( amount < balance) {
			balance=balance-amount;
			acc.setBalance(balance);
			dao.save(acc);
		}
	else {
		System.out.println("insufficient balance");
	}

	
		 
		
	}
	public void deposit(long accno,double amount) {
		
		AccountDao dao = new AccountDao();
		Account  acc = (Account) dao.fetchById(Account.class, accno);
    	double	bal=acc.getBalance()+amount;
    	acc.setBalance(bal);
    	dao.save(acc);
    	
    	BankTransaction bt= new BankTransaction();
 	   bt.setTxno(1);
 		bt.setDate(new Date());
 		bt.setType("deposite");
 		bt.setAmount(500);
 		bt.setAccount(acc);
 		dao.save(bt);
	   	
	}
	public void transfer(long fromAccno,long toAccno,double amount) {
		AccountDao dao = new AccountDao();
		Account  acc1 = (Account) dao.fetchById(Account.class, fromAccno);
		Account  acc2= (Account) dao.fetchById(Account.class, toAccno);
		
		acc1.setBalance(acc1.getBalance()-amount);
		acc2.setBalance(acc2.getBalance()+amount);
		dao.save(acc1);
		dao.save(acc2);
		
		    BankTransaction bt1= new BankTransaction();
	 	   bt1.setTxno(1);
	 		bt1.setDate(new Date());
	 		bt1.setType("trasfer money");
	 		bt1.setAmount(500);
	 		bt1.setAccount(acc1);
	 		dao.save(bt1);
	 		
		    BankTransaction bt2= new BankTransaction();
		 	   bt2.setTxno(1);
		 		bt2.setDate(new Date());
		 		bt2.setType("received money");
		 		bt2.setAmount(500);
		 		bt2.setAccount(acc2);
		 		dao.save(bt2);
		
	}
	public double  checkBalance(long accno) {
		AccountDao dao = new AccountDao();
		Account  acc = (Account) dao.fetchById(Account.class, accno);
		return acc.getBalance();
		
	}
	
	public List<BankTransaction>  miniStatement(long accno) {
		
		AccountDao dao = new AccountDao();
		List<BankTransaction> one=dao.fetchMiniStatement(accno);
		return one;
		
		
}
	public List<Account> balanceStatement(double balance){
		AccountDao dao = new AccountDao();
		List<Account> one=dao.balanceStatement(balance);
		return one;
	}
	
	public List<Account> fetchAccountsByActivity(String type,double amount){	
		AccountDao dao = new AccountDao();
		List<Account> one=dao.fetchAccountsByActivity(type,amount);
		return one;
		}
	}
