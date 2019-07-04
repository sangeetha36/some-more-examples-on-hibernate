package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class CustomerDao {

/*	public void add(Customer c) {
		//1-create EntityManagaerFactory object
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
				//2- Create/load EntityManager object
				EntityManager em= emf.createEntityManager();
		try {
				
		//3-Start Transactions
		
		EntityTransaction tx =em.getTransaction();
		tx.begin();
		
		em.persist(c);//persist method generates insert query and finds table from object class
		tx.commit();
		}
		finally {
		//Below code shld be in finally block
		em.close();
		emf.close();
		}
	}
	*/
	public Customer fetch(int cstId) {
		
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
				EntityManager em= emf.createEntityManager();
			try {
				//Find Method generates select Query
				Customer c= em.find(Customer.class, cstId);
				return c;
			}
			finally {
				em.close();
				emf.close();
				
			}
				
				
	
	}
	public Customer updateOrInsert(Customer c) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em= emf.createEntityManager();
		EntityTransaction ts=em.getTransaction();
		try {
		ts.begin();
		//Find Method generates select Query
		Customer cs=em.merge(c);
		return cs;
		}
		finally {
		ts.commit();
		em.close();
		emf.close();
		}
		
}
	public List<Customer> query() {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em= emf.createEntityManager();
		//introducing JP-QL/HQL
		try {
		Query q= em.createQuery("select c from Customer c");
		List<Customer> list=q.getResultList();
		return list;
		}
		finally {
		em.close();
		emf.close();
		}
		
		

}
	public List<Customer> fetchByEmail(String email) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em= emf.createEntityManager();
		//introducing JP-QL/HQL
		try {
		Query q= em.createQuery("select c from Customer c where c.email like '%"+email+"%'");
		//q.setParameter("em", email);
	//	q.setParameter(1, email); //if using ? like in jdbc
		List<Customer> list=q.getResultList();
		return list;
		}
		finally {
		em.close();
		emf.close();
		}
		
		

}
	
}
