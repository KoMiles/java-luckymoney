package com.imooc.luckymoney.service;

import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository luckymoneyRepository;

    @Transactional
    public void createTwo()
    {
        // 发送第一个红包
        Luckymoney luckymoneyOne = new Luckymoney();
        luckymoneyOne.setMoney(new BigDecimal("520"));
        luckymoneyOne.setProducer("王孔明");
        luckymoneyRepository.save(luckymoneyOne);

        // 发送第二个红包
        Luckymoney luckymoneyTwo= new Luckymoney();
        luckymoneyTwo.setMoney(new BigDecimal("1314"));
        luckymoneyTwo.setProducer("王孔明");
        luckymoneyRepository.save(luckymoneyTwo);
    }
}
