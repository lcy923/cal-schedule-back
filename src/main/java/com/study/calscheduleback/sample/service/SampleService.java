package com.study.calscheduleback.sample.service;

import com.study.calscheduleback.sample.dao.SampleDao;
import com.study.calscheduleback.sample.dto.SampleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    @Autowired
    private SampleDao sampleDao;

    private final String NAME_SPACE = "mybatis.mapper.sample";

    public long getSampleCnt() {
        Object cnt = sampleDao.selectCnt(NAME_SPACE + ".selectAllCnt", "");
        return Long.parseLong(cnt.toString());
    }
}
