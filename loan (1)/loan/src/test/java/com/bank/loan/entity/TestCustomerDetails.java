package com.bank.loan.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class TestCustomerDetails {
	
	@InjectMocks
	CustomerDetails customerDetails;
	
	@Before
	public void setUp() {
		customerDetails = new CustomerDetails();
	}

	@Test
	public void testgetId() {
		customerDetails.setId(1);
		assertEquals(1, customerDetails.getId());
	}
	
	@Test
	public void testgetName() {
		customerDetails.setName("name");
		assertEquals("name", customerDetails.getName());
	}
	
	@Test
	public void testgetMobileNumber() {
		customerDetails.setMobileNumber(1);
		assertEquals(1, customerDetails.getMobileNumber());
	}
	
	@Test
	public void testgetAge() {
		customerDetails.setAge(1);
		assertEquals(1, customerDetails.getAge());
	}
	
	@Test
	public void testgetGender() {
		customerDetails.setGender("gender");
		assertEquals("gender", customerDetails.getGender());
		
	}
	
	@Test
	public void testgetMaritalStatus() {
		customerDetails.setMaritalStatus("maritalStatus");
		assertEquals("maritalStatus", customerDetails.getMaritalStatus());
	}
}
