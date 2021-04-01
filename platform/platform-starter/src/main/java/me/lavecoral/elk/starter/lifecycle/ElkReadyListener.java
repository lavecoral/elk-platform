package me.lavecoral.elk.starter.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * @author lave
 * @date 2021/4/1 04:39
 */
public class ElkReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger log = LoggerFactory.getLogger(ElkReadyListener.class);

    private void handleNone() {

    }

    private void handleServlet(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        String ip = "127.0.0.1";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
        }

        String port = environment.getProperty("server.port");
        String path = environment.getProperty("server.servlet.context-path");
        if (Objects.isNull(path)) {
            path = "";
        }

        System.out.println(environment.getProperty("server.port"));

        log.info("\n----------------------------------------------------------\n" +
                        "\tApplication {} is running! Access URLs:\n" +
                        "\tActive Profiles: {}\n" +
                        "\tLocal访问网址: \t\thttp://localhost:{}{}\n" +
                        "\tExternal访问网址: \thttp://{}:{}{}\n" +
                        "----------------------------------------------------------",
                context.getId(),
                String.join(",", environment.getActiveProfiles()),
                port, path, ip, port, path
        );
    }

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ConfigurableApplicationContext context = event.getApplicationContext();

        SpringApplication application = event.getSpringApplication();
        WebApplicationType webApplicationType = application.getWebApplicationType();
        if (webApplicationType == WebApplicationType.NONE) {
            handleNone();
        } else if (webApplicationType == WebApplicationType.SERVLET) {
            handleServlet(context);
        }

    }
}
