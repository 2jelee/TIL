package com.hello.eun.hellospring.repository;

import com.hello.eun.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository // @Repository : 데이터 저장
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //sequence : 0, 1, 2 .. key값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); // map에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { // store에서 꺼내기
//        return store.get(id);
        return Optional.ofNullable(store.get(id)); // null 값으로 들어와도 optional로 감싸서 반환할 수 있도록 -> client에서 처리 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                             .filter(member -> member.getName().equals(name)) // 파라미터로 넘어온 name과 같으면 필터링
                             .findAny(); //하나라도 찾으면
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // values => member | member들 반환하기.
    }
}
