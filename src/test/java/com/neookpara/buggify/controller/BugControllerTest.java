package com.neookpara.buggify.controller;

import com.neookpara.buggify.BaseTest;
import com.neookpara.buggify.services.BugService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
class BugControllerTest extends BaseTest {

    private final String URL_BASE = "/api/v1/bugs";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BugService bugService;

    @Test
    @DisplayName("To test that all open bugs are returned")
    void find_all_open_bugs() throws Exception {

        int page = 0, size = 5;
        getOpenBugs(page, size, "$.message", "Success", status().isOk());
    }

    private void getOpenBugs(int page, int size, String jsonPath, Object jsonPathValue, ResultMatcher expectedStatus) throws Exception {
        mockMvc.perform(get(URL_BASE + "/open?page=" + page + "&size=" + size)
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(jsonPath(jsonPath, Is.is(jsonPathValue)));
    }

}