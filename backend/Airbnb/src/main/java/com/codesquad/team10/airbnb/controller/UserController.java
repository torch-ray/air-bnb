package com.codesquad.team10.airbnb.controller;

import com.codesquad.team10.airbnb.dto.request.LogInDto;
import com.codesquad.team10.airbnb.dto.request.SignUpDto;
import com.codesquad.team10.airbnb.model.User;
import com.codesquad.team10.airbnb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody SignUpDto signUpDto) {
        logger.debug(signUpDto.toString());
        userService.add(signUpDto);
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody LogInDto logInDto, HttpSession session) {
        User user = userService.findById(logInDto.getUserId());

        if (!user.isMatchedPassword(logInDto.getPassword())) {
            throw new IllegalArgumentException("Password is not correct!");
        }

        logger.debug("User {} logged in successfully!", user.getId());
    }
}
