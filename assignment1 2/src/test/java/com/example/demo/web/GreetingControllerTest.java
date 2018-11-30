package com.example.demo.web;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@RunWith(SpringRunner.class)
public class GreetingControllerTest {
    private MockMvc mockMvc;
    @MockBean
    Greeting greeting;
    @Before
    public void setUpContent() throws Exception{
       greeting.setContent1("a");
       greeting.setContent2("b");
    }
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
    }

    @Test
    public void testaddstring() throws Exception{
        this.mockMvc.perform(get("/string"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andDo(print());
    }
    @Test
    public void teststring() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/string"))
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(MockMvcResultMatchers.view().name("greeting"))
                .andExpect(content().string(Matchers.containsString("")))
                .andDo(print());
    }
}