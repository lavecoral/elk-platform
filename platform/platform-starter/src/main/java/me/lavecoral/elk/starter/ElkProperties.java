package me.lavecoral.elk.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lave
 * @date 2021/4/1 04:30
 */
@ConfigurationProperties(prefix = "elk")
public class ElkProperties {
    private String name = "elk";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
