package com.codesquad.team10.airbnb.controller;

import com.codesquad.team10.airbnb.dto.SignInDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public void createUser(@RequestBody SignInDto signInDto) {
        System.out.println(signInDto.toString());
    }
}
