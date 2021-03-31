package me.lavecoral.elk.adminserver;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.kubernetes.client.discovery.KubernetesInformerDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lave
 * @date 2021/3/30 23:40
 */
@Configuration
public class Config {

    @Bean
    @ConditionalOnClass(KubernetesInformerDiscoveryClient.class)
    public KubernetesInstanceOfflineListener kubernetesInstanceOfflineListener(ApplicationContext context) {
        return new KubernetesInstanceOfflineListener(context);
    }

    @Bean
    @ConditionalOnClass(KubernetesInformerDiscoveryClient.class)
    public KubernetesInstanceUpdater kubernetesInstanceUpdater(ApplicationContext context) {
        return new KubernetesInstanceUpdater(context);
    }
}
