package com.singtel.systempayment.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singtel.systempayment.java.model.Address;

/**
 * @author Rizki
 *
 */

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
