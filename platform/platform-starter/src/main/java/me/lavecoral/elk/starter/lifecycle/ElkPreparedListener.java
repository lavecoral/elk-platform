package me.lavecoral.elk.starter.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author lave
 * @date 2021/4/1 04:51
 */
public class ElkPreparedListener implements ApplicationListener<ApplicationPreparedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ElkPreparedListener.class);
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        log.info("prepared");
    }
}
