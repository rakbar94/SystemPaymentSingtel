package com.singtel.systempayment.java.services;

import java.util.List;

import com.singtel.systempayment.java.exception.AddressException;
import com.singtel.systempayment.java.exception.AdminException;
import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.exception.LoginException;
import com.singtel.systempayment.java.model.Address;

/**
 * @author Rizki
 *
 */

public interface AddressService {

	public String addAddress(String key, Address address) throws CustomerException, LoginException;

	public String updateAddress(String key, Address address) throws CustomerException, LoginException;

	public String removeAddress(String key, Integer addressId)
			throws CustomerException, LoginException, AddressException;

	// Admin
	public List<Address> viewAllAddress(String key) throws AdminException, LoginException, AddressException;

	public Address viewAddress(String key) throws CustomerException, LoginException, AddressException;

}
