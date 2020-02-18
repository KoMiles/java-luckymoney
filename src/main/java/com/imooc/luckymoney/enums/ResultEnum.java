package com.imooc.luckymoney.enums;

public enum ResultEnum {

    UNKNOW_ERROR(-1,"未知错误"),

    SUCCESS(0,"成功"),

    MONEY_TOO_LITTLE(101,"你发的红包小于10元"),

    MONEY_LITTLE(102,"你发的红包小于100元"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
