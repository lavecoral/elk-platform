package me.lavecoral.elk.eureka.client;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lave
 * @date 2021/4/1 10:15
 */
public class Dto implements Serializable {
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

    @Override
    public String toString() {
        return "Dto{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
