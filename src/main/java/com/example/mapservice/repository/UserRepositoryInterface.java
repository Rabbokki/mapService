package com.example.mapservice.repository;

import com.example.mapservice.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {
    //1.회원 리스트에 저장(userStore : List)
    User save(User user);

    //2.특정 ID를 갖고 검색하는 기능
    Optional<User> findById(String userId);
    //3.전체 데이터 검색
    List<User> findAll();
    //4.이름으로 검색하기
    Optional<User> findByPassword(String password);
    //5.삭제(ID)하기
    void deleteById(String userId);

    //6.ID로 수정
    User updateById(String userId, User user);
}
