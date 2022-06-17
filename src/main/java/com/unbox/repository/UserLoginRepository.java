package com.unbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unbox.entity.UserLogin;
@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

	@Query("SELECT t FROM UserLogin t WHERE t.name = ?1")
	public UserLogin findByName(String name);
	
	

}
