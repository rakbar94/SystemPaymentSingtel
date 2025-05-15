package com.singtel.systempayment.java.services;

import com.singtel.systempayment.java.exception.AdminException;
import com.singtel.systempayment.java.exception.CurrentAdminSessionException;
import com.singtel.systempayment.java.model.Admin;
import com.singtel.systempayment.java.model.CurrentAdminSession;

public interface CurrentAdminSessionService {

	public CurrentAdminSession getCurrentAdminSession(String key) throws CurrentAdminSessionException;

	public Admin getAdminDetails(String key) throws AdminException, CurrentAdminSessionException;

	public Integer getAdminId(String key) throws CurrentAdminSessionException;

}
