package me.lavecoral.elk.adminserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

/**
 * @author lave
 * @date 2021/3/30 23:00
 */
public class KubernetesInstanceOfflineListener implements ApplicationListener<InstanceOfflineEvent> {
    private static final Logger log = LoggerFactory.getLogger(KubernetesInstanceOfflineListener.class);

    private final ApplicationContext context;

    public KubernetesInstanceOfflineListener(ApplicationContext context) {
        this.context = context;
    }

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(InstanceOfflineEvent event) {
        log.info("instance {} offline", event.getInstance().getId());
        context.publishEvent(new InstanceRegisteredEvent<>(new Object(), null));
    }
}
