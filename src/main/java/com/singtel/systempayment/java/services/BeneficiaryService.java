package com.singtel.systempayment.java.services;

import java.util.List;

import com.singtel.systempayment.java.exception.AdminException;
import com.singtel.systempayment.java.exception.BeneficiaryException;
import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.exception.LoginException;
import com.singtel.systempayment.java.exception.UserException;
import com.singtel.systempayment.java.model.Beneficiary;
import com.singtel.systempayment.java.model.User;

/**
 * @author Rizki
 *
 */
public interface BeneficiaryService {

	public Beneficiary addBeneficiary(String key, Beneficiary beneficiary)
			throws CustomerException, LoginException, BeneficiaryException;

	public String deleteBeneficiary(String key, String beneficiaryMobileNumber)
			throws CustomerException, LoginException, BeneficiaryException;

	public List<Beneficiary> viewAllBeneficiaries(String key)
			throws BeneficiaryException, UserException, LoginException, CustomerException;

	// Admin
	public List<Beneficiary> viewAllBeneficiariesByCustomer(User user, String key, String customerMobileNumber)
			throws BeneficiaryException, UserException, LoginException, CustomerException, AdminException;

}
