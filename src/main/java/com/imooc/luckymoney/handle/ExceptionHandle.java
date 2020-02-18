package com.imooc.luckymoney.handle;

import com.imooc.luckymoney.domain.Result;
import com.imooc.luckymoney.enums.ResultEnum;
import com.imooc.luckymoney.expection.LuckymoneyExpection;
import com.imooc.luckymoney.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e)
    {
        if(e instanceof LuckymoneyExpection) {
            LuckymoneyExpection luckymoneyExpection = (LuckymoneyExpection) e;
            return ResultUtils.error(luckymoneyExpection.getCode(), luckymoneyExpection.getMessage());
        } else {
            logger.info("【未知错误】{}", e);
            return ResultUtils.error(ResultEnum.UNKNOW_ERROR.getCode(),ResultEnum.UNKNOW_ERROR.getMessage());
        }
    }
}
