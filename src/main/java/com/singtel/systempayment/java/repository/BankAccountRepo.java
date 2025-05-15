package com.singtel.systempayment.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singtel.systempayment.java.model.BankAccount;

/**
 * @author Rizki
 *
 */

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccount, String> {

}
