package com.imooc.luckymoney.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LuckymoneyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void list() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/luckymoneys"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}