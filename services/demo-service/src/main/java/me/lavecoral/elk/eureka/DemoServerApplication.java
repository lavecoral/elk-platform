package me.lavecoral.elk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lave
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class DemoServerApplication {
    private static final String VALUE = UUID.randomUUID().toString();

    public static void main(String[] args) {
        SpringApplication.run(DemoServerApplication.class, args);
    }


    @RequestMapping("/")
    public String home() {
        return "OK " + VALUE;
    }
}
