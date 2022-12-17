package com.study.calscheduleback.sample.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SampleDto {

    private final Long id;
    private final String name;

}