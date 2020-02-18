package com.imooc.luckymoney.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Luckymoney {
    @Id
    @GeneratedValue
    private Integer id;

    @Min(value = 10, message = "红包不能小于10元")
    private BigDecimal money;

    /**
     * 发送方
     */
    private String producer;

    /**
     * 接收方
     */
    private String consumer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    @Override
    public String toString() {
        return "Luckymoney{" +
                "id=" + id +
                ", money=" + money +
                ", producer='" + producer + '\'' +
                ", consumer='" + consumer + '\'' +
                '}';
    }
}
