package com.bank.loan.serviceImpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.loan.entity.CustomerDetails;
import com.bank.loan.entity.LoanDetails;
import com.bank.loan.entity.LoanRequest;
import com.bank.loan.repo.CustomerDetailsRepo;
import com.bank.loan.repo.LoanDetailsRepo;
import com.bank.loan.repo.LoanRequestRepo;
@RunWith(MockitoJUnitRunner.class)
public class TestLoanServiceImpl {
	
	@InjectMocks
	LoanServiceImpl loanServiceImpl;
	
	@Mock
	CustomerDetailsRepo customerDetailsRepo;
	
	@Mock
	LoanDetailsRepo loanDetailsRepo;
	
	@Mock
	LoanRequestRepo loanRequestRepo;
	
	@Test
	public void testapplyingLoan() {
		LoanRequest loanRequest = new LoanRequest();
		CustomerDetails customerDetails= new CustomerDetails();
		customerDetails.setAge(10);
		LoanDetails loanDetails = new LoanDetails();
		Mockito.when(customerDetailsRepo.save(Mockito.anyObject())).thenReturn(customerDetails);
		Mockito.when(loanDetailsRepo.save(Mockito.anyObject())).thenReturn(loanDetails);
		Mockito.when(loanRequestRepo.save(Mockito.anyObject())).thenReturn(loanRequest);
		loanServiceImpl.applyingLoan(loanRequest);
		assertEquals(10, customerDetails.getAge());
	}

}
