package com.study.calscheduleback.member.controller;

import com.study.calscheduleback.member.dto.MemberRequestDto;
import com.study.calscheduleback.member.dto.MemberResponseDto;
import com.study.calscheduleback.member.service.MemberService;
import com.study.calscheduleback.util.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 화면 이동이 필요한 경우 Controller, 아니면 Rest
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final SessionManager sessionManager;


    @GetMapping("/")
    public String home(HttpServletRequest request) {
        MemberResponseDto session = (MemberResponseDto) sessionManager.getSession(request);
        return session == null ? "index" : "main";
    }

    @PostMapping("/")
    public String signIn( MemberRequestDto memberRequestDto, Model model, HttpServletResponse response ) {
        MemberResponseDto memberResponseDto = memberService.loginCheck(memberRequestDto);
        model.addAttribute("userId", memberResponseDto.getUser_id());
        model.addAttribute("userName", memberResponseDto.getUser_name());
        sessionManager.createSession(memberResponseDto, response);
        return "main";
    }

    @GetMapping("/member/signup")
    public String moveSignUp() {
        return "signup";
    }

    @PostMapping("/member/signup")
    public String signUp(MemberRequestDto memberRequestDto, Model model) {
        int i = memberService.signUp(memberRequestDto);
        return "index";
    }

}
