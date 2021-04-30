package me.lavecoral.elk.platform.gateway.filter;

import me.lavecoral.elk.platform.gateway.ElkGatewayProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author lave
 * @date 2021/4/23 22:06
 */
@Component
public class SlowRequestGlobalFilter implements GlobalFilter, Ordered {

    private final ElkGatewayProperties elkGatewayProperties;
    private static final Logger LOG = LoggerFactory.getLogger(SlowRequestGlobalFilter.class);

    public SlowRequestGlobalFilter(ElkGatewayProperties elkGatewayProperties) {
        this.elkGatewayProperties = elkGatewayProperties;
    }

    /**
     * Process the Web request and (optionally) delegate to the next {@code WebFilter}
     * through the given {@link GatewayFilterChain}.
     *
     * @param exchange the current server exchange
     * @param chain    provides a way to delegate to the next filter
     * @return {@code Mono<Void>} to indicate when request processing is complete
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        LOG.info("request : {} path: {} query: {} header: {}",
                request.getId(),
                request.getPath(),
                request.getQueryParams(),
                request.getHeaders()
        );
        long startTime = System.nanoTime();
        Mono<Void> result = chain.filter(exchange);
        LOG.info("request: {} end", request.getId());
        Duration duration = Duration.ofNanos(System.nanoTime() - startTime);
        if (duration.compareTo(elkGatewayProperties.getSlowRequestTime()) > 0) {
            LOG.warn("request: {} use time: {} method: {} path: {} ",
                    request.getId(),
                    duration,
                    request.getMethodValue(),
                    request.getPath());
        }
        return result;
    }

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
