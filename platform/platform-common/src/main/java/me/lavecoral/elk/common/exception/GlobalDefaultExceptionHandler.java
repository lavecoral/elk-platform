package me.lavecoral.elk.common.exception;

import me.lavecoral.elk.common.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lave
 * @date 2021/4/1 10:33
 */
@ResponseBody
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = BusinessException.class)
    public Object bizExceptionHandler(BusinessException e) {
        return Result.exception(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e) {
        log.error("发生未知异常！原因是: ", e);
        BusinessException businessException = new BusinessException("unknown.exception", "Unknown Exception");
        return Result.exception(businessException);
    }
}
