//package com.example.mapservice.service;
//
//import com.example.mapservice.dto.Member;
//import com.example.mapservice.repository.MapMemberRepository;
//import com.example.mapservice.repository.MemberRepository;
//import org.springframework.stereotype.Service;
//
//import java.awt.*;
//import java.util.List;
//import java.util.Optional;
//
//@Service
////@RequiredArgsConstructor
//public class MemberService {
//    // 1.필드 주입 방법
////    @Autowired
////    MapMemberRepository memberRepository;
//
//    //2. 필드주입 방법
////    private final MapMemberRepository repository;
//
//    //3. 생성자 주입방법
//   private final MemberRepository memberRepository;
//
//    public MemberService(MapMemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    //회원가입 기능
//    public Long join(Member member) {
//        // 같은 이름, 주소가 있는 중복회원 X
//        Optional<Member> result = memberRepository
//                .findByName(member.getName());
//        // 이름, 주소 둘 다 확인
//        if(result.isPresent() &&
//                result.get().getAddress().equals(member.getAddress())) {
//            return -1L;
//        } else {
//            // 입력 가능
//            Member save = memberRepository.save(member);
//            return save.getId();
//        }
//    }
//
//    // 아이디로 검색해서 1개 찾기
//    public Optional<Member> findOne(Long id){
//        return memberRepository.findById(id);
//    }
//
//    //전체 리스트 출력
//    public List<Member> findAll(){
//        return memberRepository.findAll();
//    }
//
//    //유저 삭제
//    public void deleteById(Long id){
//        memberRepository.deleteById(id);
//    }
//
//    //유저 업데이트
//    public void update(Member member){
//        memberRepository.updateById(member.getId(), member);
//    }
//}
