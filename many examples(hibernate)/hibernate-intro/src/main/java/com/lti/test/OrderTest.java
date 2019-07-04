package com.lti.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;
import com.lti.entity.Order;

public class OrderTest {

	@Test
	public void InsertOrderTest() {
		Order ord=new Order();
	//	int a=84;
	//	Integer id=new Integer(a);
		GenericDao dao=new GenericDao();
		ord.setOrderDate(new Date());
		ord.setAmount(12000);
		ord.setCustomer(dao.fetchById(Customer.class, 84));
		System.out.println(dao.save(ord));
	}
	@Test
	public void fetchTest() {
		GenericDao dao=new GenericDao();
		List<Customer> cl= dao.fetchAll(Customer.class);
		for(Customer c:cl)
			System.out.println(c);
		List<Order> ocl= dao.fetchAll(Order.class);
		for(Order c:ocl)
			{
			System.out.println(c);
			System.out.println(c.getCustomer().getName());
			}
	}
}
