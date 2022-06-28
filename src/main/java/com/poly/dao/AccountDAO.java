package com.poly.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Account;



public interface AccountDAO extends JpaRepository<Account, String>{
	
	Page<Account> findAllByFullnameLike(String keywords, Pageable pageable);
	@Query("select a from Account a where a.email like ?1")
	public Optional<Account> findByEmail(String email);
	
	@Query("select a from Account a where a.username like ?1 and a.password like ?2")
	public Optional<Account> checkLogin(String userName, String password);
}
