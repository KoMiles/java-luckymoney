package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.domain.Luckymoney;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import com.imooc.luckymoney.service.LuckymoneyService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckymoneyController {

    private final static Logger logger = LoggerFactory.getLogger(LuckymoneyController.class);

    @Autowired
    private LuckymoneyRepository luckymoneyRepository;

    @Autowired
    private LuckymoneyService luckymoneyService;

    /**
     * 获取红包列表
     * @return
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list()
    {
        logger.info("list start");
        return luckymoneyRepository.findAll();
    }


    /**
     * 创建红包（发红包）
     * @return
     */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@Valid Luckymoney luckymoney, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        luckymoney.setProducer(luckymoney.getProducer());
        luckymoney.setMoney(luckymoney.getMoney());
        return luckymoneyRepository.save(luckymoney);
    }

    /**
     * 查询红包
     * @param id
     * @return
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findId(@PathVariable("id") Integer id)
    {
        return luckymoneyRepository.findById(id).orElse(null);
    }

    /**
     * 领取红包
     * @param id
     * @param consumer
     * @return
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
            @RequestParam("consumer") String consumer)
    {
        Optional<Luckymoney> optional = luckymoneyRepository.findById(id);
        if(optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            luckymoney.setId(id);
            luckymoney.setConsumer(consumer);
            return luckymoneyRepository.save(luckymoney);
        } else {
            return null;
        }
    }

    @PostMapping("/luckymoneys/two")
    public void createTwo()
    {
        luckymoneyService.createTwo();
    }

}
