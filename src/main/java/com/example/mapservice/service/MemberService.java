package com.example.mapservice.service;

import com.example.mapservice.dto.Member;
import com.example.mapservice.repository.MapMemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class MemberService {
    // 1.필드 주입 방법
//    @Autowired
//    MapMemberRepository memberRepository;

    //2. 필드주입 방법
//    private final MapMemberRepository repository;

    //3. 생성자 주입방법
   private final MapMemberRepository memberRepository;

    public MemberService(MapMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입 기능
    public Long join(Member member){
        Optional<Member> result = memberRepository.findByName(member.getName());
        if (result.isPresent()){
            return -1L;
        }else {
            Member save = memberRepository.save(member);
            return save.getId();
        }
    }

    // 아이디로 검색해서 1개 찾기
    public Optional<Member> findOne(Long id){
        return memberRepository.findById(id);
    }
}
