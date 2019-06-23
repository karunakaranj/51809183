package com.bank.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.loan.entity.LoanRequest;

@Repository
public interface LoanRequestRepo extends JpaRepository<LoanRequest, Integer> {

}
