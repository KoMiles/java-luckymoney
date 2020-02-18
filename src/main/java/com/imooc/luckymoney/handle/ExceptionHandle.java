package com.imooc.luckymoney.handle;

import com.imooc.luckymoney.domain.Result;
import com.imooc.luckymoney.expection.LuckymoneyExpection;
import com.imooc.luckymoney.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e)
    {
        if(e instanceof LuckymoneyExpection) {
            LuckymoneyExpection luckymoneyExpection = (LuckymoneyExpection) e;
            return ResultUtils.error(luckymoneyExpection.getCode(), luckymoneyExpection.getMessage());
        } else {
            return ResultUtils.error(-1, "未知错误");
        }
    }
}
