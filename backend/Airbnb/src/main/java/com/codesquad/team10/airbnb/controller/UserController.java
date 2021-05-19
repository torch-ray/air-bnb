package com.codesquad.team10.airbnb.controller;

import com.codesquad.team10.airbnb.dto.LogInDto;
import com.codesquad.team10.airbnb.dto.SignInDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody SignInDto signInDto) {
        System.out.println(signInDto.toString());
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody LogInDto logInDto){
        System.out.println(logInDto.toString());
    }
}
