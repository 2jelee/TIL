package com.test.jelee.demo.repository;


import com.test.jelee.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String emp_number);
}
