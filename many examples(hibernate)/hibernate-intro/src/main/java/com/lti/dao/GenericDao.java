package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class GenericDao {
	public <E>  E  fetchById(Class <E> c,Object Id) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em= emf.createEntityManager();
	try {
		//Find Method generates select Query
		E obj= em.find(c, Id);
		return obj;
	}
	finally {
		em.close();
		emf.close();
		
	}
		
		

}
public Object save(Object obj) {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em= emf.createEntityManager();
		EntityTransaction ts=em.getTransaction();
		try {
		ts.begin();
		//Find Method generates select Query
		Object cs=em.merge(obj);
		return cs;
		}
		finally {
		ts.commit();
		em.close();
		emf.close();
		}
		
}

public <E> List<E> fetchAll(Class<E> classname) {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
	EntityManager em= emf.createEntityManager();
	//introducing JP-QL/HQL
	try {
	Query q= em.createQuery("select o from "+ classname.getName()+" o");
	List <E> list=q.getResultList();
	return list;
	}
	finally {
	em.close();
	emf.close();
	}
	
	

}
}
