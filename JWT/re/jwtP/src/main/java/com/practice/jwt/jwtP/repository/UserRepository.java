package com.practice.jwt.jwtP.repository;

import com.practice.jwt.jwtP.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository를 extends하면 findAll, save 등의 메서드를 기본적으로 사용할 수 있게 된다.
public interface UserRepository extends JpaRepository<User, Long> {
    // @EntityGraph : 쿼리가 수행이 될 때 Lazy 조회가 아니고 Eager 조회로 authorities 정보를 같이 가져오게 된다.
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);
    // findOneWithAuthoritiesByUsername() : username을 기준으로 User 정보를 가져올 때 권한 정보도 같이 가져오게 된다.
}
