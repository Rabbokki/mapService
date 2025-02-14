package com.example.mapservice.service;

import com.example.mapservice.dto.User;
import com.example.mapservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface{
    private final UserRepository userRepository;

    @Override
    public Long signIn(User user) {
        Optional<User> result = userRepository.findById(user.getUserId());
        if(result.isPresent() &&
        result.get().getPassword().equals(user.getPassword())){
            return -1L;
        }else {
            User save = userRepository.save(user);
            return 1L;
        }
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user) {
        userRepository.updateById(user.getUserId(),user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
