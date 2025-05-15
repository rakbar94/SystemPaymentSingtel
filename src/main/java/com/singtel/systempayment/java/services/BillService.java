package com.singtel.systempayment.java.services;

import java.util.List;

import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.exception.LoginException;
import com.singtel.systempayment.java.exception.WalletException;
import com.singtel.systempayment.java.model.Bill;
import com.singtel.systempayment.java.model.Transaction;

/**
 * @author Rizki
 *
 */
public interface BillService {

	public Transaction BillPayment(String key, Bill bill) throws CustomerException, LoginException, WalletException;

	public List<Bill> viewBillPayments(String key) throws CustomerException, LoginException;

}
