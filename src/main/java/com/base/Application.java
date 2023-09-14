package com.base;

import com.base.config.prop.ApplicationProperties;
import com.base.utils.DefaultProfileUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@EnableConfigurationProperties({ApplicationProperties.class})
public class Application {

    private final Environment env;

    public Application(Environment env) {
        this.env = env;
    }

    /**
     * Main method of Spring Application
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
    }
}
