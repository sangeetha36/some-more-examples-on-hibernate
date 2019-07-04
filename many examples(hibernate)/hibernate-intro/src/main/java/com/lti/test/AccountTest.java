package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.dao.AccountDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.BankTransaction;
import com.lti.service.AccountServices;

public class AccountTest {

	@Test
	public void testOpenAccount() {
		 
		AccountServices accServ =new AccountServices();
		 Account acc= new  Account();
		 acc.setName("jerry");
		 acc.setType("current");
		 acc.setBalance(80000);
		 accServ.openAccount(acc);
		 		
		
	}

	@Test
	public void testWithdraw() {
		
		
		GenericDao dao = new GenericDao();
		BankTransaction bt= new BankTransaction();
		
		
	   bt.setTxno(11);
		bt.setDate(new Date());
		bt.setType("withdraw");
		bt.setAmount(500);
		//bt.setAccount(acc);
		dao.save(bt);
		
		   AccountServices accServ =new AccountServices();
		   accServ.withdraw(141,5000000);
}

	@Test
	public void testDeposite() {
		GenericDao dao = new GenericDao();
		AccountServices accServ =new AccountServices();
		 Account acc= new  Account();
		 
		 AccountServices accServ1 =new AccountServices();
		  accServ1.deposit(141,50);
		
	}


	@Test
	public void testTrasfer() {
		GenericDao dao = new GenericDao();
		AccountServices accServ =new AccountServices();
		BankTransaction bt=new BankTransaction();
		 Account acc1= new  Account();
		 
		 AccountServices accServ1 =new AccountServices();
		  accServ1.transfer(141,142,1000);
		
		             
		}
	

	@Test
	public void testcheckBalance() {
		GenericDao dao = new GenericDao();
		AccountServices accServ =new AccountServices();
		 Account acc1= new  Account();
		 
	AccountServices accServ1 =new AccountServices();
	  accServ1.checkBalance(141);
		  
	}
	@Test
	public void testminiStatement() {
		
		AccountServices accServ =new AccountServices();
		
		
		List<BankTransaction> one=accServ.miniStatement(141);
		  
		for(BankTransaction t: one) {
			System.out.println(t);
		}
	}
	@Test
	public void testBalanceStatement() {
		
		AccountServices accServ =new AccountServices();
		
		List<Account> one=accServ.balanceStatement(1000);
		  
		for(Account t: one) {
			System.out.println(t.getName());
		}
	}
		@Test
		public void testfetchAccountsByActivity() {
			
			AccountDao accServ =new AccountDao();
			
			List<Account> one=accServ.fetchAccountsByActivity("deposite",100);
			  
			for(Account t: one) {
				System.out.println(t.getAccno());
			}
		
	}
	
}
