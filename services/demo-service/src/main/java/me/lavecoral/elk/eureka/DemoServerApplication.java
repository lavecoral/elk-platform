package me.lavecoral.elk.eureka;

import me.lavecoral.elk.common.exception.BusinessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.LocalDateTime;
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

    public static class Dto implements Serializable {
        private static final long serialVersionUID = -4507605362677963808L;
        private String name;
        private String value;
        private LocalDateTime createdAt = LocalDateTime.now();

        public Dto() {
        }

        public Dto(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
    }

    @RequestMapping("/")
    public Dto home() {
        if(Math.random() < 0.5D) {
            throw new BusinessException("abcd.code","tmpException");
        }
        return new Dto("OK", VALUE);
    }
}
