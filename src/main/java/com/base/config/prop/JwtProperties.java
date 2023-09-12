package com.base.config.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "jwt", ignoreUnknownFields = false)
public class JwtProperties {

    private String signingKey;

    private int accessTokenValiditySeconds;

    private int refreshTokenValiditySeconds;
}
