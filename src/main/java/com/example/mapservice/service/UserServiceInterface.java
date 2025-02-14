package com.example.mapservice.service;

import com.example.mapservice.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    //회원가입 기능
    public Long signIn(User user);

    // 아이디로 검색해서 1개 찾기
    public Optional<User> findById(String id);
    
    //유저 삭제
    public void deleteById(String id);

    //유저 업데이트
    public void update(User user);

    List<User> findAll();
}
