package com.singtel.systempayment.java.servicesImplementation;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singtel.systempayment.java.exception.AdminException;
import com.singtel.systempayment.java.exception.BeneficiaryException;
import com.singtel.systempayment.java.exception.CustomerException;
import com.singtel.systempayment.java.exception.LoginException;
import com.singtel.systempayment.java.exception.UserException;
import com.singtel.systempayment.java.model.Beneficiary;
import com.singtel.systempayment.java.model.Customer;
import com.singtel.systempayment.java.model.User;
import com.singtel.systempayment.java.model.Wallet;
import com.singtel.systempayment.java.repository.BeneficiaryRepo;
import com.singtel.systempayment.java.repository.CustomerRepo;
import com.singtel.systempayment.java.repository.WalletRepo;
import com.singtel.systempayment.java.services.BeneficiaryService;

/**
 * @author Rizki
 *
 */
@Service
public class BeneficiaryServiceImplementation implements BeneficiaryService {

	@Autowired
	private LoginLogoutCustomerServiceImplementation loginLogoutCustomerServiceImplementation;

	@Autowired
	private LoginLogoutAdminServiceImplementation loginLogoutAdminServiceImplementation;

	@Autowired
	private WalletRepo walletRepo;

	@Autowired
	private BeneficiaryRepo beneficiaryRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Beneficiary addBeneficiary(String key, Beneficiary beneficiary)
			throws CustomerException, LoginException, BeneficiaryException {

		Customer customer = loginLogoutCustomerServiceImplementation.validateCustomer(key);

		if (customer != null) {

			Wallet wallet = customer.getWallet();

			List<Beneficiary> listofbeneficiaries = wallet.getListofBeneficiaries();

			Beneficiary databasebeneficiary = null;

			for (Beneficiary b : listofbeneficiaries) {

				if (Objects.equals(b.getMobileNumber(), beneficiary.getMobileNumber())) {
					databasebeneficiary = b;
				}
			}

			if (databasebeneficiary == null) {

				listofbeneficiaries.add(beneficiary);

				wallet.setListofBeneficiaries(listofbeneficiaries);

				walletRepo.save(wallet);

				beneficiaryRepo.save(beneficiary);

				return beneficiary;

			} else {
				throw new BeneficiaryException(
						"A Beneficiary already exists with this Mobile Number : " + beneficiary.getMobileNumber());
			}

		} else {
			throw new LoginException("Invalid Customer Key, Please Login In !");
		}

	}

	@Override
	public String deleteBeneficiary(String key, String beneficiaryMobileNumber)
			throws CustomerException, LoginException, BeneficiaryException {

		Customer customer = loginLogoutCustomerServiceImplementation.validateCustomer(key);

		if (customer != null) {

			Wallet wallet = customer.getWallet();

			List<Beneficiary> listofbeneficiaries = wallet.getListofBeneficiaries();

			if (!listofbeneficiaries.isEmpty()) {

				Beneficiary targetbeneficiary = null;

				for (Beneficiary b : listofbeneficiaries) {

					if (Objects.equals(b.getMobileNumber(), beneficiaryMobileNumber)) {
						targetbeneficiary = b;
					}

				}

				if (targetbeneficiary != null) {

					Beneficiary delete_beneficiary = null;

					Boolean flag = false;

					for (Beneficiary b : listofbeneficiaries) {

						if (Objects.equals(b.getMobileNumber(), beneficiaryMobileNumber)) {

							delete_beneficiary = b;

							flag = true;
						}

					}

					if (delete_beneficiary != null && flag) {

						listofbeneficiaries.remove(delete_beneficiary);

						wallet.setListofBeneficiaries(listofbeneficiaries);

						walletRepo.save(wallet);

						beneficiaryRepo.delete(delete_beneficiary);

						return "Beneficiary has been Successfully Deleted !";
					} else {
						throw new BeneficiaryException(
								"No Registered Beneficiary Found with this Mobile Number : " + beneficiaryMobileNumber);
					}

				} else {

					throw new BeneficiaryException(
							"No Registered Beneficiary Found with this Mobile Number : " + beneficiaryMobileNumber);
				}

			} else {
				throw new BeneficiaryException(
						"No Registered Beneficiary Found with this Mobile Number : " + beneficiaryMobileNumber);

			}

		} else {
			throw new LoginException("Invalid Customer Key, Please Login In !");
		}

	}

	@Override
	public List<Beneficiary> viewAllBeneficiaries(String key)
			throws BeneficiaryException, UserException, LoginException, CustomerException {

		Customer customer = loginLogoutCustomerServiceImplementation.validateCustomer(key);

		if (customer != null) {

			Wallet wallet = customer.getWallet();

			List<Beneficiary> listofbenficiaries = wallet.getListofBeneficiaries();

			if (listofbenficiaries.isEmpty()) {

				throw new BeneficiaryException("No Beneficiaries Found in The Database For This Customer !");
			} else {

				return listofbenficiaries;

			}

		}

		else {
			throw new CustomerException("Invalid Customer Id or Password !");
		}
	}

	@Override
	public List<Beneficiary> viewAllBeneficiariesByCustomer(User user, String key, String customerMobileNumber)
			throws BeneficiaryException, UserException, LoginException, CustomerException, AdminException {

		User validate_User = loginLogoutAdminServiceImplementation.authenticateAdmin(user, key);

		if (validate_User != null) {

			Optional<Customer> optionalCustomer = customerRepo.findById(customerMobileNumber);

			if (optionalCustomer.isPresent()) {

				Customer customer = optionalCustomer.get();

				Wallet wallet = customer.getWallet();

				List<Beneficiary> listofbenficiaries = wallet.getListofBeneficiaries();

				if (listofbenficiaries.isEmpty()) {

					throw new BeneficiaryException("No Beneficiaries Found in The Database !");
				} else {

					return listofbenficiaries;

				}

			} else {
				throw new CustomerException("No Registered Customer Found with this Mobile Number : " + user.getId());
			}

		} else {
			throw new AdminException("Invalid Admin Id or Password ! ");
		}

	}

}
