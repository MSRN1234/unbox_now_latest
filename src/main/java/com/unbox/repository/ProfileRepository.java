package com.unbox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unbox.entity.Profile;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	@Query("SELECT t FROM Profile t WHERE t.full_name = ?1")
	public Optional<Profile> findByFull_name(String full_name);
}
