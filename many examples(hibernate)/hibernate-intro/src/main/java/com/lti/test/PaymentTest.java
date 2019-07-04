package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Customer;
import com.lti.entity.Order;
import com.lti.entity.Payment;
import com.lti.entity.Status;

public class PaymentTest {

	@Test
	public void InsertOrderTest() {
		Payment py=new Payment();
	//	int a=84;
	//	Integer id=new Integer(a);
		GenericDao dao=new GenericDao();
		py.setAmount(dao.fetchById(Order.class, 101).getAmount());
		
		py.setPaymode("Cash");
		py.setStat(Status.SUCCESS);
		
		System.out.println(dao.save(py));
		 
	}
	@Test
	public void fetchTest() {
		GenericDao dao=new GenericDao();
		List<Payment> cl= dao.fetchAll(Payment.class);
		for(Payment c:cl)
			System.out.println(c);
	
	}

}
