package com.singtel.systempayment.java.services;

import com.singtel.systempayment.java.exception.AdminException;
import com.singtel.systempayment.java.exception.LoginException;
import com.singtel.systempayment.java.exception.LogoutException;
import com.singtel.systempayment.java.exception.UserException;
import com.singtel.systempayment.java.model.Admin;
import com.singtel.systempayment.java.model.CurrentAdminSession;
import com.singtel.systempayment.java.model.User;

/**
 * @author Rizki
 *
 */
public interface LoginLogoutAdminService {

	public CurrentAdminSession loginAdmin(User user) throws LoginException, AdminException;

	public String logoutAdmin(String key) throws LogoutException;

	public User authenticateAdmin(User user, String key) throws UserException, AdminException, LoginException;

	public Admin validateAdmin(String key) throws AdminException, LoginException;

}
