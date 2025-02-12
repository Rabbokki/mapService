package com.example.mapservice.service;

import com.example.mapservice.dto.Member;
import com.example.mapservice.repository.MapMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MapMemberRepository repository = new MapMemberRepository();
    MemberService memberService = new MemberService(repository);

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void join() {
        //Given
        Member member = new Member();
        member.setName("장원영");
        member.setAddress("중국");


        //When
        Long saveId = memberService.join(member);

        //Then
        Member findMember = memberService.findOne(saveId).orElse(null);

        assertThat(findMember.getName())
                .isEqualTo(member.getName());
    }

    @Test
    @DisplayName("회원가입 실패")
    void joinFail(){
        //Given
        Member member = new Member();
        member.setName("장원영");
        member.setAddress("중국");
        memberService.join(member);

        Long firstJoinResult = memberService.join(member);

        Member member2 = new Member();
        member2.setName("장원영");
        member2.setAddress("서울");
        memberService.join(member2);
        //When
        Long secondJoinResult = memberService.join(member2);

        //Then
        assertThat(firstJoinResult)
                .isEqualTo(secondJoinResult);
    }

    @Test
    void findOne(){
        //Given
        Member member = new Member();
        member.setName("장원영");
        member.setAddress("중국");
        memberService.join(member);
        //When
        Member r = memberService.findOne(member.getId()).orElse(null);

        //Then
        assertThat(r.getId())
                .isEqualTo(member.getId());
    }
}