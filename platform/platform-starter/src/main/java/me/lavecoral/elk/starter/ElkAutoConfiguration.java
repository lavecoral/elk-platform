package me.lavecoral.elk.starter;

import feign.RequestInterceptor;
import me.lavecoral.elk.common.exception.BusinessExceptionDecoder;
import me.lavecoral.elk.common.exception.GlobalDefaultExceptionHandler;
import me.lavecoral.elk.common.response.ResponseAdvice;
import me.lavecoral.elk.starter.feign.FeignRequestInterceptor;
import me.lavecoral.elk.starter.lifecycle.ElkPreparedListener;
import me.lavecoral.elk.starter.lifecycle.ElkReadyListener;
import me.lavecoral.elk.starter.lifecycle.ElkStartedListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author lave
 * @date 2021/4/1 04:31
 */
@Configuration
@EnableConfigurationProperties(ElkProperties.class)
public class ElkAutoConfiguration {

    @Bean
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    @ConditionalOnMissingBean({ResponseAdvice.class})
    @ConditionalOnClass({ResponseBodyAdvice.class})
    public ResponseAdvice responseAdvice() {
        return new ResponseAdvice();
    }

    @Bean
    public ElkPreparedListener elkPreparedListener() {
        return new ElkPreparedListener();
    }

    @Bean
    public ElkReadyListener elkReadyListener() {
        return new ElkReadyListener();
    }

    @Bean
    public ElkStartedListener elkStartedListener() {
        return new ElkStartedListener();
    }

    @Bean
    @ConditionalOnClass({RequestInterceptor.class})
    public FeignRequestInterceptor feignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }

    @Bean
    @ConditionalOnClass({RequestInterceptor.class})
    public BusinessExceptionDecoder businessExceptionDecoder() {
        return new BusinessExceptionDecoder();
    }

    @Bean
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    public GlobalDefaultExceptionHandler globalDefaultExceptionHandler() {
        return new GlobalDefaultExceptionHandler();
    }

}
