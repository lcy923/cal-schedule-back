package com.study.calscheduleback.member.controller;

import com.study.calscheduleback.member.dto.MemberRequestDto;
import com.study.calscheduleback.member.dto.MemberResponseDto;
import com.study.calscheduleback.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 화면 이동이 필요한 경우 Controller, 아니면 Rest
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/member")
    public String index(@RequestParam(value = "userId") String userId,
                        @RequestParam(value = "userPw") String userPw,
                        Model model){

        log.info( "id : {}", userId);
        log.info( "password : {}", userPw );

        model.addAttribute(userId,userPw);

        return "main";
    }

    @PostMapping("/member")
    public String index( MemberRequestDto memberRequestDto, Model model ) {
        MemberResponseDto memberResponseDto = memberService.loginCheck(memberRequestDto);
        model.addAttribute("userName", memberResponseDto.getUserName());
        return "main";
    }

    @GetMapping("/member/signup")
    public String moveSignUp() {
        return "signup";
    }

    @PostMapping("/member/signup")
    public String signUp(MemberRequestDto memberRequestDto, Model model) {
        int i = memberService.signUp(memberRequestDto);
        System.out.println("sign up result : " + i);
        return "index";
    }

}
