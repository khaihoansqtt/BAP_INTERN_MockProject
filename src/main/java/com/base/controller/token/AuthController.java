package com.base.controller.token;

import com.base.dto.BaseResDto;
import com.base.dto.ErrorDto;
import com.base.dto.authentication.JwtDTO;
import com.base.dto.authentication.LoginRequest;
import com.base.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResDto login(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors= new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> System.out.println(error.getCode())
            );

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );

            String errorMsg= "";
            Iterator<String> iterator = errors.keySet().iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                errorMsg+= errors.get(key);
                if (iterator.hasNext()) errorMsg+= ", ";
            }
            return  BaseResDto.badRequest(new ErrorDto("400",errorMsg));
        }
        try {
            JwtDTO jwtDTO =  authenticationService.authenticate(loginRequest);
            return BaseResDto.ok(jwtDTO);
        }
        catch (BadCredentialsException e){
            return BaseResDto.badRequest(new ErrorDto("400", "Your email address or password is incorrect."));
        }
        catch (Exception e){
            return BaseResDto.badRequest(new ErrorDto("500", e.getMessage()));
        }
    }

}
