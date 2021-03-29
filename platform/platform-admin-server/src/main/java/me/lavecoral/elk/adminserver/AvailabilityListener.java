package me.lavecoral.elk.adminserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author lave
 * @date 2021/3/28 12:08
 */
@Component
public class AvailabilityListener {
    private static final Logger log = LoggerFactory.getLogger(AvailabilityListener.class);

    /**
     * 监听系统消息，
     * AvailabilityChangeEvent类型的消息都从会触发此方法被回调
     */
    @EventListener
    public void onStateChange(AvailabilityChangeEvent<? extends AvailabilityState> event) {
        log.info(event.getState().getClass().getSimpleName() + " : " + event.getState());
    }
}
