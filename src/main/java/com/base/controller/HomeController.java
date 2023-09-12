package com.base.controller;

import com.base.message.Message;
import com.base.response.SuccessResponse;
import com.base.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/home")
@Api(description = "This is API to test base project")
public class HomeController {

    @Autowired
    private Message message;

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    @ApiOperation("Return String hello all")
    public String hello() {
        return message.getMessage("app.hello");
    }

    @GetMapping("/get-user-by-email/{email}")
    @RolesAllowed("ROLE_ADMIN")
    public Object getUserByEmail(@PathVariable("email") String email) {
        return new SuccessResponse<>(userService.getUserByEmail(email));
    }
}
