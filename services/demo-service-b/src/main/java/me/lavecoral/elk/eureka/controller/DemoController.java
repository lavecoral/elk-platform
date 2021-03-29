package me.lavecoral.elk.eureka.controller;

import me.lavecoral.elk.eureka.client.DemoClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lave
 * @date 2021/3/30 00:43
 */
@RestController
public class DemoController {
    private final DemoClient demoClient;

    public DemoController(DemoClient demoClient) {
        this.demoClient = demoClient;
    }

    @RequestMapping("/")
    public String home() {
        return "This is beta. another response is " + demoClient.ok();
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
