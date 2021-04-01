package me.lavecoral.elk.common.response;

import me.lavecoral.elk.common.exception.BusinessException;

import java.io.Serializable;

/**
 * @author lave
 * @date 2021/4/1 03:51
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 9159369869805094005L;
    private String code;
    private String message;
    private String status;
    private T data;

    public Result() {
    }

    public static <T> Result<T> of(T data) {
        Result<T> result = new Result<T>();

        result.code = "";
        result.message = "";
        result.status = "successful";
        result.data = data;
        return result;
    }

    public static <T> Result<T> exception(BusinessException exception) {
        Result<T> result = new Result<T>();

        result.code = exception.getCode();
        result.message = exception.getMessage();
        result.status = "failed";
        result.data = null;
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
