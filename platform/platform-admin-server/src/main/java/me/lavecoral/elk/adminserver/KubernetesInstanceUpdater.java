package me.lavecoral.elk.adminserver;

import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author lave
 * @date 2021/3/31 00:31
 */

public class KubernetesInstanceUpdater {
    private final ApplicationContext context;

    public KubernetesInstanceUpdater(ApplicationContext context) {
        this.context = context;
    }

    @Scheduled(fixedDelay = 30_000L)
    public void update() {
        context.publishEvent(new InstanceRegisteredEvent<>(new Object(), null));
    }
}
