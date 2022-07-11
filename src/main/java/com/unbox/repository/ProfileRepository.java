package com.unbox.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unbox.entity.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	@Query("SELECT t FROM Profile t WHERE t.user_Id= ?1")
	public Profile findByUser_Id(Integer id);
}
