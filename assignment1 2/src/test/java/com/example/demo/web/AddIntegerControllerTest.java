package com.example.demo.web;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
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

@RunWith(SpringRunner.class)
public class AddIntegerControllerTest {
    private MockMvc mockMvc;
    @MockBean
    AddInteger addInteger;
    @Before
    public void setUpInt() throws Exception{
       addInteger.setA(1);
        addInteger.setB(2);
    }
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AddIntegerController()).build();
    }
    @Test
    public void testaddInt() throws Exception{
        this.mockMvc.perform(get("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("addInteger"))
                .andDo(print());
    }
    @Test
    public void testaddInteger() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("addInteger"))
                .andExpect(MockMvcResultMatchers.view().name("addInteger"))
                .andExpect(content().string(Matchers.containsString("")))
                .andDo(print());
    }
}