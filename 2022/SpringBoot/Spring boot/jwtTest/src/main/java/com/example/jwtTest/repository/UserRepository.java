package com.example.jwtTest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtTest.model.UserTbl;

public interface UserRepository extends JpaRepository<UserTbl, Long> {
	Optional<UserTbl> findByEmail(String email);
}

