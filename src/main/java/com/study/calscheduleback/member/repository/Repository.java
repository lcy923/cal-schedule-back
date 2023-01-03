package com.study.calscheduleback.member.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public int insert(String sqlId, Object paramObj) {
        return (Integer) sessionTemplate.insert(sqlId, paramObj);
    }

    public <T> T selectOne(String sqlId, Object paramObj) {
        return sessionTemplate.selectOne(sqlId, paramObj);
    }

    public <T> List<T> selectList(String sqlId, Object paramObj) {
        return sessionTemplate.selectList(sqlId, paramObj);
    }

}
