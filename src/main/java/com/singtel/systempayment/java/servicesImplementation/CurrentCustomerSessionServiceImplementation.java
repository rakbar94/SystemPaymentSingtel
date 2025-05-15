package com.singtel.systempayment.java.servicesImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singtel.systempayment.java.exception.CurrentCustomerSessionException;
import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.model.CurrentCustomerSession;
import com.singtel.systempayment.java.model.Customer;
import com.singtel.systempayment.java.repository.CurrentCustomerSessionRepo;
import com.singtel.systempayment.java.repository.CustomerRepo;
import com.singtel.systempayment.java.services.CurrentCustomerSessionService;

/**
 * @author Rizki
 *
 */

@Service
public class CurrentCustomerSessionServiceImplementation implements CurrentCustomerSessionService {

	@Autowired
	private CurrentCustomerSessionRepo currentCustomerSessionRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public CurrentCustomerSession getCurrentCustomerSession(String key) throws CurrentCustomerSessionException {

		Optional<CurrentCustomerSession> optional_CurrentCustomerSession = currentCustomerSessionRepo.findByKey(key);

		if (optional_CurrentCustomerSession.isPresent()) {

			CurrentCustomerSession currentCustomerSession = optional_CurrentCustomerSession.get();

			return currentCustomerSession;
		} else {
			throw new CurrentCustomerSessionException("Invalid key, Please Login In !");
		}

	}

	@Override
	public Customer getCustomerDetails(String key) throws CurrentCustomerSessionException, CustomerException {

		Optional<CurrentCustomerSession> optional_CurrentUserSession = currentCustomerSessionRepo.findByKey(key);

		if (optional_CurrentUserSession.isPresent()) {

			CurrentCustomerSession currentCustomerSession = optional_CurrentUserSession.get();

			String current_customerId = currentCustomerSession.getCustomerMobileNumber();

			Optional<Customer> current_Customer = customerRepo.findById(current_customerId);

			if (current_Customer.isPresent()) {

				Customer customer = current_Customer.get();

				return customer;

			} else {
				throw new CustomerException("No Registered Customer Found !");
			}

		} else {
			throw new CurrentCustomerSessionException("Invalid key, Please Login In !");
		}

	}

	@Override
	public String getCurrentCustomerId(String key) throws CurrentCustomerSessionException {

		Optional<CurrentCustomerSession> optional_CurrentCustomerSession = currentCustomerSessionRepo.findByKey(key);

		if (optional_CurrentCustomerSession.isPresent()) {

			CurrentCustomerSession currentCustomerSession = optional_CurrentCustomerSession.get();

			String current_customerId = currentCustomerSession.getCustomerMobileNumber();

			return current_customerId;

		} else {

			throw new CurrentCustomerSessionException("Invalid key, Please Login In !");
		}

	}

}
