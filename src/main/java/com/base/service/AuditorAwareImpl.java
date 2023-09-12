package com.base.service;

import com.google.common.base.Strings;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * The type AuditorAwareImpl
 */
public class AuditorAwareImpl implements AuditorAware<String> {
    private String systemUser = "system";

    /**
     * get current auditor
     * @return
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userName = null;
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                userName = springSecurityUser.getUsername();
            } else if (authentication.getPrincipal() instanceof String) {
                userName = (String) authentication.getPrincipal();
            }
        }
        return Strings.isNullOrEmpty(userName) ? Optional.of(systemUser): Optional.of(userName);
    }
}
