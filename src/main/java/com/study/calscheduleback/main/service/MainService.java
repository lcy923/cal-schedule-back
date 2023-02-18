package com.study.calscheduleback.main.service;

import com.study.calscheduleback.main.dto.MonthContentsRequestDto;
import com.study.calscheduleback.main.dto.MonthContentsResponseDto;
import com.study.calscheduleback.member.dto.ContentsResponseDto;
import com.study.calscheduleback.repository.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private static final String NAME_SPACE = "mybatis.mapper.calendar.";
    private final Repository repository;

    public MainService(Repository repository) {
        this.repository = repository;
    }

    public List<MonthContentsResponseDto> getSpreadContents(MonthContentsRequestDto monthContentsResponseDto){
            return repository.selectList(NAME_SPACE + "getMonthCalendar", monthContentsResponseDto);
    }

}
