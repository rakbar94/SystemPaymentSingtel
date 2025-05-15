package com.singtel.systempayment.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singtel.systempayment.java.model.Beneficiary;

@Repository
public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Integer> {


}
