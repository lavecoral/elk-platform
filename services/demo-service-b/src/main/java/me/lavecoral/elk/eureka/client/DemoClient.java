package me.lavecoral.elk.eureka.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lave
 * @date 2021/3/30 00:39
 */
@FeignClient(name = "demo-service")
public interface DemoClient {
    /**
     * 测试Open Feign的接口
     */
    @GetMapping("/")
    String ok();
}
