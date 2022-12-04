package com.study.calscheduleback.sample.controller;

import com.study.calscheduleback.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    SampleService service;

    @GetMapping("/sample")
    public ResponseEntity<Long> getSampleCnt() {

        long resVal = 0;

        resVal = service.getSampleCnt();

        return ResponseEntity.ok(resVal);

    }

}
