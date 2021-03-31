package me.lavecoral.elk.adminserver;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import org.springframework.context.ApplicationEvent;

/**
 * @author lave
 * @date 2021/3/31 00:02
 */
public class InstanceOfflineEvent extends ApplicationEvent {
    private static final long serialVersionUID = 4379471145542100749L;

    private final Instance instance;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public InstanceOfflineEvent(Instance source) {
        super(source);
        this.instance = source;
    }

    public Instance getInstance() {
        return this.instance;
    }
}
