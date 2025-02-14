//package com.example.mapservice.controller;
//
//import com.example.mapservice.dto.Member;
//import com.example.mapservice.service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/members")
//public class MemberController {
//    private final MemberService memberService;
//
//    @GetMapping("")
//    public String list(Model model){
//        List<Member> memberList = memberService.findAll();
//        System.out.println("회원 리스트" + memberList);
//        model.addAttribute("memberList",memberList);
//        return "/members/memberList";
//    }
//
//    @GetMapping ("/new")
//    public String newMember(Model model){
//        model.addAttribute("member",new Member());
//        return "/members/createMemberForm";
//    }
//    @PostMapping("/new")
//    public String createMember(Member member){
//        //1. 회원가입 창에서 보낸자료 DTO로 받고
//        System.out.println(member);
//        memberService.join(member);
//        //2. 받은 회원 정보를 서비스에 보내고 맵에 저장
//        return "redirect:/members";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteMember(@PathVariable("id") Long id){
//        System.out.println("id : " + id);
//        memberService.deleteById(id);
//        return "redirect:/members";
//    }
//    @GetMapping("/update/{id}")
//    public String updateMember(@PathVariable("id") Long id, Model model){
//        //1 id로 검색후 member를 수정 폼에 전달
//        model.addAttribute("member",memberService.findOne(id));
//        return "/members/updateMemberForm";
//    }
//
//    @PostMapping("/update")
//    public String update(Member member){
//        memberService.update(member);
//        return "redirect:/members";
//    }
//}
