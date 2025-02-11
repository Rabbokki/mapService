package com.example.mapservice.repository;

import com.example.mapservice.dto.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //1.회원 맵에 저장
    Member save(Member member);

    //2.특정 ID를 갖고 검색하는 기능
    Optional<Member> findById(Long id);
    //3.전체 데이터 검색
    List<Member> findAll();
    //4.이름으로 검색하기
    Optional<Member> findByName(String name);
    //5.삭제(ID)하기
    void deleteById(Long id);

    //6.ID로 수정
    Member updateById(Long memberId, Member member);
}
