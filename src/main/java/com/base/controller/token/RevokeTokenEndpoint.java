package com.base.controller.token;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@FrameworkEndpoint
public class RevokeTokenEndpoint {

    @Resource(name = "tokenServices")
    private ConsumerTokenServices tokenServices;

    /**
     * revoke a token
     * @param request
     * @param token
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/oauth/token")
    @ResponseBody
    public boolean revokeToken(HttpServletRequest request, @RequestParam("token") String token) {
        boolean result = false;
        if (!StringUtils.isEmpty(token)) {
            result = tokenServices.revokeToken(token);
        }
        return result;
    }
}
