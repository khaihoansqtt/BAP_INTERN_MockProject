package com.base.config.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private String test;

    private String tokenUrl;

    private String appClientId;

    private String appClientSecret;

    private String resourceId;

    private String swaggerClientId;

    private String swaggerClientSecret;
}
