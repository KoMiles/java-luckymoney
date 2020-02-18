package com.imooc.luckymoney.service;

import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.enums.ResultEnum;
import com.imooc.luckymoney.expection.LuckymoneyExpection;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import java.math.BigDecimal;
import java.util.Optional;
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
        luckymoneyOne.setProducer("王小二");
        luckymoneyRepository.save(luckymoneyOne);

        // 发送第二个红包
        Luckymoney luckymoneyTwo= new Luckymoney();
        luckymoneyTwo.setMoney(new BigDecimal("1314"));
        luckymoneyTwo.setProducer("王小二");
        luckymoneyRepository.save(luckymoneyTwo);
    }


    /**
     * 获取金额
     * @param id
     * @throws Exception
     */
    public void getMoney(Integer id) throws LuckymoneyExpection {
        Optional<Luckymoney> optional = luckymoneyRepository.findById(id);
        Luckymoney luckymoney = optional.get();
        BigDecimal money = luckymoney.getMoney();
        if(money.intValue() < 20) {
            throw new LuckymoneyExpection(ResultEnum.MONEY_TOO_LITTLE);
        } else if(money.intValue() > 20 && money.intValue() < 100) {
            throw new LuckymoneyExpection(ResultEnum.MONEY_LITTLE);
        }
    }
}
