package com.study.calscheduleback.sample.dao;

import com.study.calscheduleback.sample.dto.SampleDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SampleDao {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public <T> T selectCnt(String sqlId, Object paramObj) {
        return sessionTemplate.selectOne( sqlId, paramObj );
    }

    public int insert(String sqlId, Object paramObj) {
        return (Integer) sessionTemplate.insert(sqlId, paramObj);
    }

    public int update(String sqlId, Object paramObj) {
        return (Integer) sessionTemplate.update(sqlId, paramObj);
    }

    public int delete(String sqlId, Object paramObj) {
        return (Integer) sessionTemplate.delete(sqlId, paramObj);
    }

}