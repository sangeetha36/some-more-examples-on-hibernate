package com.lti.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;

import oracle.sql.DATE;

public class HibernateTest {

	@Test
	public void addTest() {
		try {
		Customer c=new Customer();
		c.setName("Abhi	");
		c.setEmail("Abhishk@123.com");
		Date d;
		d = new SimpleDateFormat("dd/MM/yyyy").parse("30/9/1997");
		c.setDob(d);
		c.setCity("Kozhi");
		GenericDao dao=new GenericDao();
		dao.save(c);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void fetchTest() {
		CustomerDao dao=new CustomerDao();
		Customer c=new Customer();
		c=dao.fetch(1);
		System.out.println(c);
	}
	@Test
	public void testUpdate() {
		
		CustomerDao dao=new CustomerDao();
		Customer c=dao.fetch(84);
		c.setCity("Cali");
			System.out.println(dao.updateOrInsert(c));
		
		
	}
	@Test
	public void testQuery() {
		
		CustomerDao dao=new CustomerDao();
		List<Customer> cst=dao.query();
		for(Customer c:cst)
			System.out.println(c);
	
		
	}
	@Test
	public void testFetchByEmail() {
		
		CustomerDao dao=new CustomerDao();
		List<Customer> cst=dao.fetchByEmail("gmail");
		for(Customer c:cst)
			System.out.println(c);
	
		
	}
}
