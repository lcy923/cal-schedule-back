package com.study.calscheduleback.sample.controller;

import com.study.calscheduleback.sample.dto.SampleDto;
import com.study.calscheduleback.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SampleAPIController {

    @Autowired
    SampleService service;

    @GetMapping("/sample")
    public ResponseEntity<Long> getSampleCnt() {

        long resVal = 0;

        resVal = service.getSampleCnt();

        return ResponseEntity.ok(resVal);

    }

    @PostMapping("/sample")
    public ResponseEntity<String> insertSample(@RequestBody SampleDto sampleDto) {

        log.info( "sample dto id : {}", sampleDto.getId() );
        log.info( "sample dto name : {}", sampleDto.getName() );

//        service.insert(sampleDto);

        return ResponseEntity.ok("Success");
    }

    @PutMapping("/sample")
    public ResponseEntity<String> updateSample(@RequestBody SampleDto sampleDto){
        log.info( "sample dto id : {}", sampleDto.getId() );
        log.info( "sample dto name : {}", sampleDto.getName() );

        service.update(sampleDto);

        return ResponseEntity.ok("Success");
    }

    @DeleteMapping("/sample")
    public ResponseEntity<String> deleteSample(@RequestBody SampleDto sampleDto){
        service.delete(sampleDto);

        return ResponseEntity.ok("Success");
    }
}
