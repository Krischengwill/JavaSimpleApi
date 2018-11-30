package com.example.demo.web;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.boot.test.mock.mockito.MockBean;
@RunWith(SpringRunner.class)
public class storeControllerTest {
    private MockMvc mockMvc;
    @MockBean
    storeToDb str;
    @Before
    public void setUpProduct() throws Exception{
        str = new storeToDb("123");
        str.setStr("123");
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new storeToDbController()).build();
    }
    @Test
    public void teststore() throws Exception{
        this.mockMvc.perform(get("/store"))
                .andExpect(status().isOk())
                .andExpect(view().name("storeToDb"))
                .andDo(print());
    }
    @Test
    public void teststoreToDb() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/store"))
                .andExpect(status().isOk())
                .andExpect(view().name("storeToDb"))
                .andExpect(MockMvcResultMatchers.view().name("storeToDb"))
                .andExpect(content().string(Matchers.containsString("123")))
                .andDo(print());
    }
}