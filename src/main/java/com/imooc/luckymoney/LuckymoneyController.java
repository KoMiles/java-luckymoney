package com.imooc.luckymoney;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckymoneyController {

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
        return luckymoneyRepository.findAll();
    }


    /**
     * 创建红包（发红包）
     * @return
     */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                            @RequestParam("money")BigDecimal money)
    {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
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
