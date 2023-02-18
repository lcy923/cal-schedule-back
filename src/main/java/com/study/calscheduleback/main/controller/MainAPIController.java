package com.study.calscheduleback.main.controller;

import com.study.calscheduleback.main.dto.MonthContentsRequestDto;
import com.study.calscheduleback.main.dto.MonthContentsResponseDto;
import com.study.calscheduleback.main.service.MainService;
import com.sun.tools.javac.Main;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainAPIController {

    private final MainService mainService;

    public MainAPIController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/calendar")
    public List<MonthContentsResponseDto> getSpreadContents(
            @RequestParam(name = "userId") String userId,
            @RequestParam(name = "contentDate") String cDate
    ) {

        MonthContentsRequestDto reqDto = MonthContentsRequestDto.builder()
                .userId(userId)
                .contentDate(cDate)
                .build();

        List<MonthContentsResponseDto> spreadContents = mainService.getSpreadContents(reqDto);
        System.out.println("hihihihi~~" + spreadContents.size());

        return spreadContents;
    }

}
