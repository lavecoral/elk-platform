package me.lavecoral.elk.auth.model.enums;

/**
 * @author lave
 * @date 2021/7/22 22:25
 */
public enum PasswordEncoderTypeEnum {

    BCRYPT("{bcrypt}", "BCRYPT加密"),
    NOOP("{noop}", "无加密明文");

    private final String prefix;
    private final String description;

    public String getPrefix() {
        return prefix;
    }

    public String getDescription() {
        return description;
    }

    PasswordEncoderTypeEnum(String prefix, String description) {
        this.prefix = prefix;
        this.description = description;
    }

}

