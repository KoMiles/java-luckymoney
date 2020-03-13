package com.imooc.luckymoney.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "weixin")
public class WeixinConfig {

    private String appId;

    private String appName;
}
