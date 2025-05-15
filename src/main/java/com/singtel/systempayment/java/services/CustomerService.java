package com.singtel.systempayment.java.services;

import java.util.List;

import com.singtel.systempayment.java.exception.AdminException;
import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.exception.LoginException;
import com.singtel.systempayment.java.model.Customer;

/**
 * @author Rizki
 *
 */

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(String key, Customer customer) throws CustomerException, LoginException;

	public String removeCustomer(String key, String customer_Id) throws CustomerException, LoginException;

	public Customer viewCustomer(String key, String customer_Id) throws CustomerException, LoginException;

	// Check for Admin Role
	public List<Customer> viewAllCustomers(String key) throws AdminException, LoginException, CustomerException;

}
