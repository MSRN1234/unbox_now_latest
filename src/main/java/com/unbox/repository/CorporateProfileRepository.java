package com.unbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unbox.entity.CorporateProfile;

public interface CorporateProfileRepository extends JpaRepository<CorporateProfile,Integer> {

	@Query("SELECT t FROM CorporateProfile t WHERE t.user_Id=?1")
	public CorporateProfile findByUser_Id(Integer id);
}
