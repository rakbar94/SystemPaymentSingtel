package com.singtel.systempayment.java.servicesImplementation;

import java.util.List;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.exception.LoginException;
import com.singtel.systempayment.java.exception.WalletException;
import com.singtel.systempayment.java.model.Bill;
import com.singtel.systempayment.java.model.Customer;
import com.singtel.systempayment.java.model.Transaction;
import com.singtel.systempayment.java.model.Wallet;
import com.singtel.systempayment.java.repository.TransactionRepo;
import com.singtel.systempayment.java.repository.WalletRepo;
import com.singtel.systempayment.java.services.BillService;
import com.singtel.systempayment.java.services.TransactionService;

/**
 * @author Rizki
 *
 */
@Service
public class BillServiceImplementation implements BillService {

	@Autowired
	private LoginLogoutCustomerServiceImplementation loginLogoutCustomerServiceImplementation;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private WalletRepo walletRepo;

	@Override
	public Transaction BillPayment(String key, Bill bill) throws CustomerException, LoginException, WalletException {

		Customer customer = loginLogoutCustomerServiceImplementation.validateCustomer(key);

		if (customer != null) {

			Wallet wallet = customer.getWallet();

			Double availablebalance = wallet.getBalance();

			List<Bill> listofbills = wallet.getListofBills();

			// make a Transaction and add transaction to transaction list

			if (availablebalance >= bill.getAmount()) {

				Transaction transaction = transactionService.addTransaction(key, bill.getReceiver(), bill.getBillType(),
						"Bill Payment", bill.getAmount());

				if (transaction != null) {

					listofbills.add(bill);

					wallet.setBalance(availablebalance - bill.getAmount());

					wallet.setListofBills(listofbills);

					walletRepo.save(wallet);

					return transaction;
				}

				else {
					throw new TransactionException("Opps ! Transaction Failed !");

				}
			} else {
				throw new WalletException("Insufficient Funds ! Available Wallet Balance : " + availablebalance);
			}

		} else {
			throw new CustomerException("Invalid Customer Key, Please Login In ! ");
		}

	}

	@Override
	public List<Bill> viewBillPayments(String key) throws CustomerException, LoginException {

		Customer customer = loginLogoutCustomerServiceImplementation.validateCustomer(key);

		if (customer != null) {

			Wallet wallet = customer.getWallet();

			return wallet.getListofBills();

		} else {
			throw new CustomerException("Invalid Customer Key, Please Login In ! ");
		}

	}

}
