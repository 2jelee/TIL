package com.example.jwtTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtTest.model.UserTbl;

public interface UserRepository extends JpaRepository<UserTbl, Long> {

}

