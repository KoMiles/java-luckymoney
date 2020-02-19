package com.imooc.luckymoney;

import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.service.LuckymoneyService;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
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
@SpringBootTest()
@AutoConfigureMockMvc
public class LuckymoneyTest {

    @Autowired
    private LuckymoneyService luckymoneyService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getOneTest()
    {
        Luckymoney luckymoney = luckymoneyService.getOne(31);
        Assert.assertEquals(new BigDecimal("14.00"),luckymoney.getMoney());
    }

    @Test
    public void list() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/luckymoneys"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
