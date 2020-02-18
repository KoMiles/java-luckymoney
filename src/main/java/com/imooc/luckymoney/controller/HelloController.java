package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.properties.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId)
    {

//        return "minMoney:" + limitConfig.getMinMoney() + "，说明： "+ limitConfig.getDescription();
        return "id:" + myId;
    }
    @PostMapping("/say")
    public String say2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId)
    {

//        return "minMoney:" + limitConfig.getMinMoney() + "，说明： "+ limitConfig.getDescription();
        return "id:" + myId;
    }

}
