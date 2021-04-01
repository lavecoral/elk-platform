package me.lavecoral.elk.common.exception;

/**
 * @author lave
 * @date 2021/4/1 03:49
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -319635706368048944L;

    private String code;
    private String message;

    public BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
