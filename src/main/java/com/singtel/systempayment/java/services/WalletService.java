package com.singtel.systempayment.java.services;

import com.singtel.systempayment.java.exception.BankAccountException;
import com.singtel.systempayment.java.exception.BeneficiaryException;
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
public interface WalletService {

	public Double showWalletBalance(String key) throws LoginException, CustomerException;

	public Transaction transferFunds(User user, String key, String targetMobileNumber, Double amount,
			String description) throws LoginException, CustomerException, WalletException, UserException;

	public Transaction addMoneyToWallet(User user, String key, Double amount)
			throws UserException, LoginException, CustomerException, WalletException, BankAccountException;

	public Transaction addMoneyToBank(User user, String key, Double amount) throws UserException, LoginException, CustomerException, WalletException, BankAccountException;

	public Transaction transferFundsToBeneficiary(User user, String key, String benficiarymobileNumber, Double amount,
			String description) throws LoginException, CustomerException, WalletException, UserException, BankAccountException, BeneficiaryException;
}
