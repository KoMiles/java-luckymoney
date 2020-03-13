package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.properties.LimitConfig;
import com.imooc.luckymoney.properties.WeixinConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    @Autowired
    private WeixinConfig weixinConfig;

    @GetMapping("/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {

//        return "minMoney:" + limitConfig.getMinMoney() + "，说明： "+ limitConfig.getDescription();
        return "id:" + myId;
    }

    @PostMapping("/say")
    public String say2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {

//        return "minMoney:" + limitConfig.getMinMoney() + "，说明： "+ limitConfig.getDescription();
        return "id:" + myId;
    }

    @GetMapping("weixin_config")
    public String test() {

        String appname = weixinConfig.getAppName();
        String appnameNew = " " + appname + " ";
        log.info("字符串长度为：{}", appname.length());
        log.info("下标为2的字符串为：{}", appname.charAt(2));
        log.info("截取字符串0-3：{}", appname.substring(0, 3));
        log.info("加上空格:{}", appnameNew);
        log.info("去掉空格：{}", appnameNew.trim());
        log.info("变成大写：{}", appname.toUpperCase());
        log.info("新的字符串：{}", appname.replace("ming", "zi"));
        return "app_id:" + weixinConfig.getAppId() + "app_name:" + weixinConfig.getAppName();
    }
    @GetMapping("arr")
    public String array()
    {
        int [] a = new int[10];
        return "app_id:" + weixinConfig.getAppId() + "app_name:" + weixinConfig.getAppName();
    }

}
