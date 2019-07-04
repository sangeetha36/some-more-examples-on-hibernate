package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Account;
import com.lti.entity.BankTransaction;



public class AccountDao extends GenericDao{

 public List<BankTransaction> fetchMiniStatement(long accno){
	 	
			EntityManagerFactory emf=null;
			EntityManager em= null;
			try {
				  emf=Persistence.createEntityManagerFactory("oracle-pu");
				  em= emf.createEntityManager();
			String ql = "select t from BankTransaction t where t.account.accno= :ac order by t.date desc";
			
				  Query q= em.createQuery(ql);
			q.setParameter("ac",accno);
			q.setMaxResults(5);
			List <BankTransaction> list=q.getResultList();
			return list;
			}
			finally {
			em.close();
			emf.close();
			}
			
 }
 
 public List<Account> balanceStatement(double balance){
	 	
		EntityManagerFactory emf=null;
		EntityManager em= null;
		try {
			  emf=Persistence.createEntityManagerFactory("oracle-pu");
			  em= emf.createEntityManager();
		String ql = "select a from Account a where a.balance > :bal";
			  Query q= em.createQuery(ql);
		q.setParameter("bal",balance);
		
		List <Account> list=q.getResultList();
		return list;
		}
		finally {
		em.close();
		emf.close();
		}
 }
		
		
		public List<Account> fetchAccountsByActivity(String type,double amount){
		 	
			EntityManagerFactory emf=null;
			EntityManager em= null;
			try {
				 
				emf=Persistence.createEntityManagerFactory("oracle-pu");
				em= emf.createEntityManager();
				String ql = "select a from Account a join a.transactions tx where tx.type = :tp and tx.amount >= :amt";
				//String ql = "select a from Account a";
				Query q= em.createQuery(ql);
				q.setParameter("tp",type);
				q.setParameter("amt", amount);
			
				List <Account> list=q.getResultList();
				return list;
				}
				finally {
					em.close();
					emf.close();
				}
}
}
