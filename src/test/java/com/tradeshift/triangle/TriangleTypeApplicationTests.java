package com.tradeshift.triangle;

import static com.tradeshift.triangle.Constants.MISSING_PARAM;
import static com.tradeshift.triangle.Constants.TYPE_MISMATCH;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TriangleTypeApplicationTests {

    private static final String TRIANGLE_TYPE_PATH = "/triangle/type";

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturn400InCaseOfMissingParameter() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get(TRIANGLE_TYPE_PATH))
        .andExpect(status().isBadRequest())
        .andExpect(content().string(equalTo(MISSING_PARAM)));
    }

    @Test
    public void shouldReturn400InCaseOfBadParameter() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get(TRIANGLE_TYPE_PATH).param("a", "bad"))
        .andExpect(status().isBadRequest())
        .andExpect(content().string(equalTo(TYPE_MISMATCH)));
    }
}
