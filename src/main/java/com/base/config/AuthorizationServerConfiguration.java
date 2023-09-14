package com.base.config;

import com.base.config.prop.ApplicationProperties;
import com.base.config.prop.JwtProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Slf4j
@Configuration
@EnableAuthorizationServer
@EnableConfigurationProperties(JwtProperties.class)
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private static final String GRANT_TYPE_PASSWORD = "password";
    private static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
    private static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    private static final String GRANT_TYPE_IMPLICIT = "implicit";

    private static final String SCOPE_READ = "read";
    private static final String SCOPE_WRITE = "write";
    private static final String SCOPE_TRUST = "trust";

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private JedisConnectionFactory redisConnectionFactory;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.
                inMemory().
                withClient(applicationProperties.getAppClientId()).
                secret(passwordEncoder.encode(applicationProperties.getAppClientSecret())).
                resourceIds(applicationProperties.getResourceId()).
                authorizedGrantTypes(GRANT_TYPE_PASSWORD, GRANT_TYPE_REFRESH_TOKEN,
                        GRANT_TYPE_AUTHORIZATION_CODE, GRANT_TYPE_IMPLICIT).
                scopes(SCOPE_READ, SCOPE_WRITE, SCOPE_TRUST).
                autoApprove(true).
                accessTokenValiditySeconds(jwtProperties.getAccessTokenValiditySeconds()).
                refreshTokenValiditySeconds(jwtProperties.getRefreshTokenValiditySeconds()).
                and().
                withClient(applicationProperties.getSwaggerClientId()).
                secret(passwordEncoder.encode(applicationProperties.getSwaggerClientSecret())).
                resourceIds(applicationProperties.getResourceId()).
                authorizedGrantTypes(GRANT_TYPE_PASSWORD).
                scopes(SCOPE_READ, SCOPE_WRITE);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.
                tokenStore(tokenStore()).
                authenticationManager(authenticationManager).
                accessTokenConverter(accessTokenConverter()).
                userDetailsService(userDetailsService);
    }

    /*  Redis
    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }
    */

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(jwtProperties.getSigningKey());

        return converter;
    }
}
