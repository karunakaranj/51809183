package com.bank.loan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.loan.entity.LoanRequest;
import com.bank.loan.repo.CustomerDetailsRepo;
import com.bank.loan.repo.LoanDetailsRepo;
import com.bank.loan.repo.LoanRequestRepo;
import com.bank.loan.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	CustomerDetailsRepo customerDetailsRepo;
	
	@Autowired
	LoanDetailsRepo loanDetailsRepo;
	
	@Autowired
	LoanRequestRepo loanRequestRepo;
	
	@Override
	public LoanRequest applyingLoan(LoanRequest loanRequest) {
		if(loanRequest!=null) {
			customerDetailsRepo.save(loanRequest.getCustomerDetails());
			loanDetailsRepo.save(loanRequest.getLoanDetails());
			loanRequestRepo.save(loanRequest);
			return loanRequest;
		}
		else {
			return null;
		}
		
	}

}
