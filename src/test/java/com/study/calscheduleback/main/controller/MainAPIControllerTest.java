package com.study.calscheduleback.main.controller;

import com.study.calscheduleback.main.service.MainService;
import com.study.calscheduleback.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MainAPIControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        StandaloneMockMvcBuilder mockService = MockMvcBuilders.standaloneSetup(new MainService(new Repository()));
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MainAPIController(new MainService(new Repository())))
                .build();
    }

    @Test
    public void ajax_get_요청_테스트() throws Exception {

        ResultActions resultActions = mockMvc.perform(
                get("/main/calendar")
                        .param("userId", "2")
                        .param("contentDate", "202302")
                )
                .andExpect(status().isOk());

    }

}