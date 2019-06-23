package com.bank.loan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LoanDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int loanAccountNumber;
	private String securityAddress;
	private String loanStatus;
	private double loanAmount;
	private int managerId;

	@OneToOne
	@JoinColumn(name="id")
	private LoanRequest loanRequest;

	public LoanRequest getLoanRequest() {
		return loanRequest;
	}

	public void setLoanRequest(LoanRequest loanRequest) {
		this.loanRequest = loanRequest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(int loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public String getSecurityAddress() {
		return securityAddress;
	}

	public void setSecurityAddress(String securityAddress) {
		this.securityAddress = securityAddress;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

}
