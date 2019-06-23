package com.bank.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.loan.entity.OfficerDetails;

@Repository
public interface OfficerDetailsRepo extends JpaRepository<OfficerDetails, Integer> {

}
