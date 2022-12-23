package com.study.calscheduleback.member.repository;

import com.study.calscheduleback.member.dto.MemberRequestDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public int insert(String sqlId, Object paramObj) {
        return (Integer) sessionTemplate.insert(sqlId, paramObj);
    }

    public <T> T selectOne(String sqlId, Object paramObj) {
        return sessionTemplate.selectOne(sqlId, paramObj);
    }

}
