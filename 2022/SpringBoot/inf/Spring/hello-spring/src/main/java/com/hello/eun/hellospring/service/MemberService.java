package com.hello.eun.hellospring.service;

import com.hello.eun.hellospring.domain.Member;
import com.hello.eun.hellospring.repository.MemberRepository;
import com.hello.eun.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service     // Spring Container에 등록해줌 => Controller의 Autowired에 사용됨. | Service :
public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원 가입
    public Long join(Member member){
        // 같은 이름이 있는 회원 X => 이름 중복 체크
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }


    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
