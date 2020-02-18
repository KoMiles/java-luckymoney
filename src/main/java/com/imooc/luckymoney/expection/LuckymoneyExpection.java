package com.imooc.luckymoney.expection;

public class LuckymoneyExpection extends RuntimeException{

    private Integer code;

    private String message;


    public LuckymoneyExpection(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
