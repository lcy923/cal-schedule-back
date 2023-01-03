package com.study.calscheduleback.member.controller;

import com.study.calscheduleback.member.dto.ContentsRequestDto;
import com.study.calscheduleback.member.dto.ContentsResponseDto;
import com.study.calscheduleback.member.dto.MemberRequestDto;
import com.study.calscheduleback.member.service.ContentsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContentsController {

    @Autowired
    ContentsService contentsService;

    @GetMapping("/contents")
    public String moveContents(MemberRequestDto memberRequestDto, Model model) {
        String userId = memberRequestDto.getUserId();
        model.addAttribute("userId", userId);

        List<ContentsResponseDto> contentsList = contentsService.getContentsList(userId);

        model.addAttribute("contentsList", contentsList);

        return "contents";
    }


}
