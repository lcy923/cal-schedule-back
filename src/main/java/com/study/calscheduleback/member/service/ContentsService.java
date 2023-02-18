package com.study.calscheduleback.member.service;

import com.study.calscheduleback.member.dto.ContentsRequestDto;
import com.study.calscheduleback.member.dto.ContentsResponseDto;
import com.study.calscheduleback.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentsService {

    @Autowired
    private Repository repository;

    private final String NAME_SPACE = "mybatis.mapper.contents.";

    public int addContent(ContentsRequestDto contentsRequestDto) {
        return repository.insert(NAME_SPACE + "addContent", contentsRequestDto);
    }

    public List<ContentsResponseDto> getContentsList(String userId) {
        return repository.selectList(NAME_SPACE + "getContentsList", userId);
    }

}
