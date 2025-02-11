package com.example.mapservice.controller;

import com.example.mapservice.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    @GetMapping ("/new")
    public String newMember(){
        return "/members/createMemberForm";
    }
    @PostMapping("/new")
    public String createMember(Member member){
        //1. 회원가입 창에서 보낸자료 DTO로 받고
        System.out.println(member);
        //2. 받은 회원 정보를 서비스에 보내고 맵에 저장
        return "redirect:/members";
    }

    @GetMapping
    public String showMembers(){
        return "/members/memberList";
    }
}
