package com.bank.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.loan.entity.LoanRequest;
import com.bank.loan.service.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@PostMapping("/")
	public ResponseEntity<LoanRequest> applyingLoan(@RequestBody LoanRequest loanRequest){
		loanRequest=loanService.applyingLoan(loanRequest);
		if(loanRequest!=null) {
			return new ResponseEntity<LoanRequest>(loanRequest,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<LoanRequest>(loanRequest,HttpStatus.NOT_ACCEPTABLE);
		
	}

}
