package com.example.mapservice.repository;

import com.example.mapservice.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class UserRepository implements UserRepositoryInterface{

    private static List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(String userId) {
        return users.stream().filter(x->x.getUserId().equals(userId)).findAny();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> findByPassword(String password) {
        return users.stream().filter(x->x.getPassword().equals(password)).findAny();
    }

    @Override
    public void deleteById(String userId) {
        users.removeIf(x->x.getUserId().equals(userId));
    }

    @Override
    public User updateById(String userId, User user) {
        for (int i = 0; i < users.size(); i++) {
            System.out.println("비교 중인 userId: " + users.get(i).getUserId() + ", 전달된 userId: " + userId); // 로그 추가
            if (!(users.get(i).getUserId().equals(userId))) {
                System.out.println("수정되는 데이터: " + users.get(i));
                users.set(i, user);
                System.out.println("수정 후 데이터: " + users.get(i));
                return user;
            }
        }
        return null; // 일치하는 데이터가 없으면 null 리턴
    }


    public void clearStore(){
        users.clear();

    }
}
