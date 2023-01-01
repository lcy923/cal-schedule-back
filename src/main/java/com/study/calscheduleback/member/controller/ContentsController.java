package com.study.calscheduleback.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ContentsController {

    @GetMapping("/contents")
    public String moveSignUp() {
        System.out.println("hi");
        return "contents";
    }

}
