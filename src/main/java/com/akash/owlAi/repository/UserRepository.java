package com.akash.owlAi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.owlAi.entity.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long>{

	Optional<user> findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	boolean existsByEmailAndIdNot(String email, Long id);
}
