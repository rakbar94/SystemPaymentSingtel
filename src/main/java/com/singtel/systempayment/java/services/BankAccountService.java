package com.singtel.systempayment.java.services;

import java.util.List;

import com.singtel.systempayment.java.exception.AdminException;
import com.singtel.systempayment.java.exception.BankAccountException;
import com.singtel.systempayment.java.exception.CurrentAdminSessionException;
import com.singtel.systempayment.java.exception.CurrentCustomerSessionException;
import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.exception.LoginException;
import com.singtel.systempayment.java.exception.UserException;
import com.singtel.systempayment.java.model.BankAccount;
import com.singtel.systempayment.java.model.User;

/**
 * @author Rizki
 *
 */
public interface BankAccountService {

	String addAccount(User user, String key, String mobileNumber, String bankName, String ifscCode, Double balance,
			String accountNo) throws CurrentCustomerSessionException, UserException, LoginException, CustomerException;

	public String removeAccount(User user, String key) throws UserException, LoginException, CustomerException,
			BankAccountException, CurrentCustomerSessionException;

	public BankAccount viewAccount(User user, String key) throws UserException, LoginException, CustomerException,
			BankAccountException, CurrentCustomerSessionException;

	public Double viewBankBalance(User user, String key) throws UserException, LoginException, CustomerException,
			BankAccountException, CurrentCustomerSessionException;

	// Admin
	public List<BankAccount> viewAllAccounts(User user, String key)
			throws UserException, AdminException, LoginException, BankAccountException, CurrentAdminSessionException;

}
