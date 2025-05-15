package com.singtel.systempayment.java.services;

import java.util.List;

import com.singtel.systempayment.java.exception.AdminException;
import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.exception.LoginException;
import com.singtel.systempayment.java.exception.UserException;
import com.singtel.systempayment.java.exception.WalletException;
import com.singtel.systempayment.java.model.Beneficiary;
import com.singtel.systempayment.java.model.Transaction;
import com.singtel.systempayment.java.model.User;

/**
 * @author Rizki
 *
 */
public interface TransactionService {

	public Transaction addTransaction(String key, String receiver, String description, String transactionType,
			Double amount) throws CustomerException, LoginException;

	public Transaction viewTransaction(String key, Integer transactionId) throws CustomerException, LoginException;

	public List<Transaction> viewAllTransactions(String key) throws CustomerException, LoginException;

	// Admin
	public List<Transaction> viewAllTransactionsByCustomer(String key, String mobileNumber)
			throws AdminException, LoginException, CustomerException;

	// Admin
	public List<Transaction> viewAllTransactionsByCustomerByDate(String key, String date, String mobileNumber)
			throws AdminException, LoginException, CustomerException;

	public List<Transaction> viewTransactionByDate(String key, String date) throws LoginException, CustomerException;

}
