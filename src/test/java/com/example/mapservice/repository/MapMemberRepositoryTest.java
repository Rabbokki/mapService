package com.example.mapservice.repository;

import com.example.mapservice.dto.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MapMemberRepositoryTest {
    MapMemberRepository repository = new MapMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member();
        member.setName("장원영");
        member.setAddress("서울");
        repository.save(member);

        //when
        Member result = repository.findById(member.getId()).get();

        //then
        Long saveId = 1L;

        //org.junit.jupiter.api
        Assertions.assertEquals(member, result);

        //org.assertj.core.api -- static import
        assertThat(result).isEqualTo(result);
    }

    @Test
    @DisplayName("ID로 검색하기")
    void findById() {
        //give
        Member member = new Member();
        member.setName("안유진");
        member.setAddress("제주도");
        repository.save(member);

        //when
        Long id = 1L;
        Member findMember = repository.findById(id).get();

        //then
        assertThat(findMember.getName()).isEqualTo("안유진");
    }

    @Test
    @DisplayName("ID로 검색실패")
    void findById_Fail() {
        //give
        Member member = new Member();
        member.setName("안유진");
        member.setAddress("제주도");
        repository.save(member);

        //when
        Long id = 2L;
        Member findMember = repository.findById(id).orElse(null);

        //then
        assertThat(findMember).isEqualTo(null);
    }
    @Test
    @DisplayName("전체검색 테스트")
    void findAll() {
        //Given
        Member jang = new Member();
        jang.setName("장원영");
        jang.setAddress("서울");
        repository.save(jang);

        Member ahn = new Member();
        ahn.setName("안유진");
        ahn.setAddress("대구");
        repository.save(ahn);

        //When
        List<Member> list = repository.findAll();

        //Then
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("이름으로 검색")
    void findByName() {
        //Given
        //장원영, 안유진 입력
        Member jang = new Member();
        jang.setName("장원영");
        jang.setAddress("중국");
        repository.save(jang);
        Member ahn = new Member();
        ahn.setName("안유진");
        ahn.setAddress("대구");
        repository.save(ahn);
        //When
        //장원영 검색
        Optional<Member> r = repository.findByName("장원영");

        //Then
        //찾은 member 객체가 장원영 객체와 비교 같은지

        assertThat(r.get()).isEqualTo(jang);
    }

    @Test
    @DisplayName("이름으로 검색 실패")
    void findByNameFail() {
        //Given
        //장원영, 안유진 입력
        Member jang = new Member();
        jang.setName("장원영");
        jang.setAddress("중국");
        repository.save(jang);
//        Member ahn = new Member();
//        ahn.setName("안유진");
//        ahn.setAddress("대구");
//        repository.save(ahn);
        //When
        //장원영 검색
        Member r = repository.findByName("안유진").orElse(null);

        //Then
        //찾은 member 객체가 장원영 객체와 비교 같은지

        assertThat(r).isEqualTo(null);
    }

    @Test
    @DisplayName("아이디로 삭제하기 테스트")
    void deleteById() {
        Member rei = new Member();
        rei.setId(3L);
        rei.setName("레이");
        rei.setAddress("일본");
        repository.save(rei);

        repository.deleteById(rei.getId());

        Optional<Member> result = repository.findById(rei.getId());
        assertThat(result).isEmpty();

    }

    @Test
    @DisplayName("데이터 수정 테스트")
    void updateById() {
        //Given
        //장원영 입력(장원영, 서울) --> id:1
        Member jang = new Member();
        jang.setName("장원영");
        jang.setAddress("서울");
        repository.save(jang);

        //When
        //객체 생성(1,장원영,중국)
        //updateByIId(1,updateMember)
        Member updateMember = new Member();
        updateMember.setName("장원영");
        updateMember.setAddress("중국");
        Member member = repository.updateById(1L, updateMember);

        //Then
        //id:1 읽고 주소가 중국으로 바뀌었는지 확인
        assertThat(member.getAddress()).isEqualTo("중국");
    }
}