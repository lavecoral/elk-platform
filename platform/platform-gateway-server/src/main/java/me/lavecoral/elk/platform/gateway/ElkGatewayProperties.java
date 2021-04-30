package me.lavecoral.elk.platform.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Duration;

/**
 * @author lave
 * @date 2021/4/30 21:47
 */
@Component
@ConfigurationProperties(prefix="elk.gateway")
public class ElkGatewayProperties implements Serializable {
    private static final long serialVersionUID = -4204373053523210073L;
    private Duration slowRequestTime = Duration.ofMillis(50);

    public Duration getSlowRequestTime() {
        return slowRequestTime;
    }

    public void setSlowRequestTime(Duration slowRequestTime) {
        this.slowRequestTime = slowRequestTime;
    }
}
