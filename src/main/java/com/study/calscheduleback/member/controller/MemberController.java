package com.study.calscheduleback.member.controller;

import com.study.calscheduleback.member.dto.MemberRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 화면 이동이 필요한 경우 Controller, 아니면 Rest
 */
@Slf4j
@Controller
public class MemberController {

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

        return "example";
    }

}
