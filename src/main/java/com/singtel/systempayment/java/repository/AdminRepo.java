package com.singtel.systempayment.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singtel.systempayment.java.model.Admin;
import com.singtel.systempayment.java.model.Customer;

/**
 * @author Rizki
 *
 */

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

	public Optional<Admin> findByMobileNumber(String mobileNumber);
	
}
