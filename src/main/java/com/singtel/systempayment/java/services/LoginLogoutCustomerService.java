package com.singtel.systempayment.java.services;

import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.exception.LoginException;
import com.singtel.systempayment.java.exception.LogoutException;
import com.singtel.systempayment.java.exception.UserException;
import com.singtel.systempayment.java.model.CurrentCustomerSession;
import com.singtel.systempayment.java.model.Customer;
import com.singtel.systempayment.java.model.User;

/**
 * @author Rizki
 *
 */

public interface LoginLogoutCustomerService {

	public CurrentCustomerSession loginCustomer(User user) throws LoginException, CustomerException;

	public String logoutCustomer(String key) throws LogoutException;
	
	public User authenticateCustomer(User user, String key) throws UserException, LoginException, CustomerException;

	public Customer validateCustomer(String key) throws LoginException, CustomerException;
}
