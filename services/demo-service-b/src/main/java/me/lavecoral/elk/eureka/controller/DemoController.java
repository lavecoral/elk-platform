package me.lavecoral.elk.eureka.controller;

import me.lavecoral.elk.common.exception.BusinessException;
import me.lavecoral.elk.eureka.client.DemoClient;
import me.lavecoral.elk.eureka.client.Dto;
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
        try {
            Dto dto = demoClient.ok();
            return "This is beta. another response is " + dto;
        } catch (BusinessException e) {
            System.out.println(e.getCode());
            throw new BusinessException("adbcefg", "lanjie");
        }
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
