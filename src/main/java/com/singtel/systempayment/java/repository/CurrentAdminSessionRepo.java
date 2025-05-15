package com.singtel.systempayment.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singtel.systempayment.java.model.CurrentAdminSession;

/**
 * @author Rizki
 *
 */

@Repository
public interface CurrentAdminSessionRepo extends JpaRepository<CurrentAdminSession, Integer> {

	public Optional<CurrentAdminSession> findByKey(String key);

	public Optional<CurrentAdminSession> findByAdminId(Integer adminId);

}
