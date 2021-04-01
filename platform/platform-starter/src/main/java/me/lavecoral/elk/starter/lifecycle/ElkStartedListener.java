package me.lavecoral.elk.starter.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author lave
 * @date 2021/4/1 04:52
 */
public class ElkStartedListener implements ApplicationListener<ApplicationStartedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ElkStartedListener.class);
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.info("started");
    }
}
