package com.study.calscheduleback.member.service;

import com.study.calscheduleback.member.dto.MemberRequestDto;
import com.study.calscheduleback.member.dto.MemberResponseDto;
import com.study.calscheduleback.member.repository.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final String NAME_SPACE = "mybatis.mapper.member.";

    private final Repository repository;


    public MemberResponseDto loginCheck(MemberRequestDto memberRequestDto) {
        return repository.selectOne(NAME_SPACE + "selectMember", memberRequestDto);
    }

    public int signUp(MemberRequestDto memberRequestDto) {
        return repository.insert(NAME_SPACE + "insertMember", memberRequestDto);
    }


}
