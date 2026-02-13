package com.hello.eun.hellospring.repository;

import com.hello.eun.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id); // null로 들어올 수 있으므로 이러한 경우 Optional로 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 모든 회원 list 반환

}
