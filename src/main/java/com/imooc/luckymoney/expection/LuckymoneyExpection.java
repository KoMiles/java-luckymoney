package com.imooc.luckymoney.expection;

import com.imooc.luckymoney.enums.ResultEnum;

public class LuckymoneyExpection extends RuntimeException{

    private Integer code;

    private String message;

    public LuckymoneyExpection(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
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
