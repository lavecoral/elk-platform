package me.lavecoral.elk.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lave
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class DemoServerBetaApplication {
    // 这里配置的是我们要调用的服务实例名，我们要调用USER服务，因此这里的地址是USER
    private static final String REST_URL_PREFIX = "http://demo-server";


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoServerBetaApplication.class, args);
    }


    @RequestMapping("/")
    public String home() {
        return "This is beta. another response is " + restTemplate.getForObject(REST_URL_PREFIX + "/", String.class);
    }
    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
