package com.study.calscheduleback.member.controller;

import com.study.calscheduleback.member.dto.ContentsRequestDto;
import com.study.calscheduleback.member.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentsAPIController {

    @Autowired
    ContentsService contentsService;

    @GetMapping("/add/contents")
    public ResponseEntity<String> addContents(ContentsRequestDto contentsRequestDto, Model model) {
        System.out.println( contentsRequestDto.getUserId() );
        System.out.println( contentsRequestDto.getContent() );
        System.out.println( contentsRequestDto.getCreateDate() );
        System.out.println( "abc " + contentsRequestDto.getContentDate() );
        contentsService.addContent(contentsRequestDto);
        return ResponseEntity.ok("ok");
    }

}
