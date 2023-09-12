package com.base.config;

import com.base.service.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * The type JpaConfiguration
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfiguration {
    /**
     * Auditor aware auditor aware.
     *
     * @return the auditor aware
     */
    @Bean
    AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
}
