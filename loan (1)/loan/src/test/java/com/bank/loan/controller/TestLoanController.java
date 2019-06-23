package com.bank.loan.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bank.loan.entity.LoanRequest;
import com.bank.loan.service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestContext.class, LoanController.class })
@WebAppConfiguration
public class TestLoanController {
	
	@InjectMocks
	LoanController loanController;
	
	private MockMvc mockMvc;
	
	@Mock
	LoanService loanService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(loanController).build();
	}

	@Test
	public void testapplyingLoan() throws Exception {
		LoanRequest loanRequest = new LoanRequest();
		ResponseEntity<LoanRequest> res=new ResponseEntity<LoanRequest>(loanRequest,HttpStatus.ACCEPTED);
		Mockito.when(loanService.applyingLoan(Mockito.anyObject())).thenReturn(loanRequest);
		this.mockMvc.perform(
				post("/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(loanRequest)))
				.andReturn();
		ResponseEntity<LoanRequest> res1=loanController.applyingLoan(loanRequest);
		assertEquals(res, res1);
	}
	
	@Test
	public void testapplyingLoan_1() throws Exception {
		LoanRequest loanRequest = new LoanRequest();
		ResponseEntity<LoanRequest> res=new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
		Mockito.when(loanService.applyingLoan(Mockito.anyObject())).thenReturn(null);
		this.mockMvc.perform(
				post("/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(loanRequest)))
				.andReturn();
		ResponseEntity<LoanRequest> res1=loanController.applyingLoan(loanRequest);
		assertEquals(res, res1);
	}
	
	
	
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}
