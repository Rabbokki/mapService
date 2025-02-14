package com.example.mapservice.controller;

import com.example.mapservice.dto.User;
import com.example.mapservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public String userList(Model model){
        List<User> userList = userService.findAll();
        System.out.println("유저 리스트" + userList);
        model.addAttribute("userList",userList);
        return "/users/userList";
    }

    @GetMapping("/new")
    public String signIn(Model model){
        model.addAttribute("user",new User());
        return "/users/signInUser";
    }

    @PostMapping("/new")
    public String signInUser(User user){
        System.out.println(user);
        userService.signIn(user);

        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id){
        System.out.println("삭제 요청된 사용자 ID: " + id);
        userService.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") String id, Model model) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "/users/updateUser";
        } else {
            System.out.println("해당 ID의 사용자가 없습니다: " + id);
            return "redirect:/users"; // 사용자 없음 시, 목록 페이지로 돌아가기
        }
    }

//    @GetMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") String id,Model model){
//        System.out.println("");
//        model.addAttribute("user",userService.findById(id));
//        return "/users/updateUser";
//    }

    @PostMapping("/update")
    public String update(User user){
        System.out.println("업데이트된 사용자: " + user);
        userService.update(user);
        return "redirect:/users";
    }
}
