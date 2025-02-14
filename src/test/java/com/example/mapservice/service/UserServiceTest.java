package com.example.mapservice.service;

import com.example.mapservice.dto.User;
import com.example.mapservice.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserRepository userRepository = new UserRepository();
    UserService userService = new UserService(userRepository);

    @AfterEach
    public void afterEach(){
        userRepository.clearStore();
    }

    @Test
    @DisplayName("회원가입")
    void signIn() {
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");

        User user2 = new User();
        user2.setUserId("야마자키");
        user2.setNickName("야마자키");
        user2.setPassword("야마자키");

        Long saveID = userService.signIn(user);
        Long saveID2 = userService.signIn(user2);
        assertThat(saveID).isEqualTo(1L);
        assertThat(saveID2).isEqualTo(-1L);
    }

    @Test
    @DisplayName("유저 찾기")
    void findById() {
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        userService.signIn(user);

        User u = userService.findById(user.getUserId()).orElse(null);

        assertThat(u.getUserId()).isEqualTo(user.getUserId());
    }

    @Test
    @DisplayName("유저 삭제")
    void deleteById() {
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        userService.signIn(user);

        userService.deleteById(user.getUserId());

        int size = userService.findAll().size();
        assertThat(size).isEqualTo(0);
    }

    @Test
    @DisplayName("업데이트")
    void update() {
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        userService.signIn(user);

        User user2 = new User();
        user2.setUserId("카발란");
        user2.setNickName("카발란");
        user2.setPassword("카발란");
        userService.update(user2);

        User result = userService.findById("카발란").orElseThrow();

        assertThat(result.getUserId()).isEqualTo("카발란");
    }

    @Test
    @DisplayName("유저 전체 목록")
    void findAll() {
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        userService.signIn(user);

        User user2 = new User();
        user2.setUserId("카발란");
        user2.setNickName("카발란");
        user2.setPassword("카발란");
        userService.signIn(user2);

        List<User> userList = userRepository.findAll();
        assertThat(userList.size()).isEqualTo(2);

    }
}