package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.BankTransaction;
import com.lti.entity.example.Song;

public class AlbumDao extends GenericDao{
	 public List<Song> fetchMiniStatement(long accno){
		 	
			EntityManagerFactory emf=null;
			EntityManager em= null;
			try {
				  emf=Persistence.createEntityManagerFactory("oracle-pu");
				  em= emf.createEntityManager();
			String ql = "select t from BankTransaction t where t.account.accno= :ac order by t.date desc";
			
				  Query q= em.createQuery(ql);
			q.setParameter("ac",accno);
			q.setMaxResults(5);
			List <Song> list=q.getResultList();
			//return List<Song>;
			}
			finally {
			em.close();
			emf.close();
			}
			return null;
			
}
}
