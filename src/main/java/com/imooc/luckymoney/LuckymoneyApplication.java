package com.imooc.luckymoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LuckymoneyApplication {

    public static void main(String[] args) {
        System.out.println("================= appliaction start =================");
        SpringApplication.run(LuckymoneyApplication.class, args);
        System.out.println("================= appliaction end =================");
    }

}
