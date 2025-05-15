package com.singtel.systempayment.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singtel.systempayment.java.model.Customer;

/**
 * @author tejas
 *
 */

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

}
