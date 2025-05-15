package com.singtel.systempayment.java.services;

import com.singtel.systempayment.java.exception.CurrentCustomerSessionException;
import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.model.CurrentCustomerSession;
import com.singtel.systempayment.java.model.Customer;

/**
 * @author Rizki
 *
 */

public interface CurrentCustomerSessionService {

	public CurrentCustomerSession getCurrentCustomerSession(String key) throws CurrentCustomerSessionException;

	public Customer getCustomerDetails(String key) throws CurrentCustomerSessionException, CustomerException;

	public String getCurrentCustomerId(String key) throws CurrentCustomerSessionException;

}
