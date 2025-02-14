package com.example.mapservice.repository;

import com.example.mapservice.dto.Member;
import com.example.mapservice.dto.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository repository = new UserRepository();

    @AfterEach
    public void afterEach(){repository.clearStore();}

    @Test
    @DisplayName("유저 회원가입")
    void save() {
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        User save = repository.save(user);

        User result = repository.findById(user.getUserId()).orElseThrow();

        assertThat(result.getUserId()).isEqualTo(save.getUserId());
    }

    @Test
    @DisplayName("유저 아이디 찾기")
    void findById() {
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        repository.save(user);

        User findUser = repository.findById("야마자키").orElseThrow();

        assertThat(user.getUserId()).isEqualTo(findUser.getUserId());
    }
    @Test
    @DisplayName("ID로 검색실패")
    void findById_Fail() {
        //give
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        repository.save(user);

        assertThatThrownBy(() -> repository.findById("aaa")
                .orElseThrow(() -> new NoSuchElementException("해당 유저를 찾을 수 없습니다.")))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("해당 유저를 찾을 수 없습니다.");
    }

    @Test
    @DisplayName("유저 리스트 출력")
    void findAll() {
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        repository.save(user);

        User user2 = new User();
        user2.setUserId("야마자키");
        user2.setNickName("야마자키");
        user2.setPassword("야마자키");
        repository.save(user2);

        List<User> users = repository.findAll();

        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("유저 비밀번호 찾기")
    void findByPassword() {
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        repository.save(user);

        User u = repository.findByPassword("야마자키").orElseThrow();

        assertThat(u.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    @DisplayName("유저 삭제")
    void deleteById() {
        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        repository.save(user);

        repository.deleteById(user.getUserId());

        Optional<User> u = repository.findById(user.getUserId());

        assertThat(u).isEmpty();
    }

    @Test
    @DisplayName("유저 수정")
    void updateById() {

        User user = new User();
        user.setUserId("야마자키");
        user.setNickName("야마자키");
        user.setPassword("야마자키");
        repository.save(user);

        User updateUser = new User();
        updateUser.setUserId("카발란");
        updateUser.setPassword("카발란");
        updateUser.setNickName("카발란");
        User user1 = repository.updateById(user.getUserId(), updateUser);

        assertThat(user1.getUserId()).isEqualTo("카발란");
    }

}