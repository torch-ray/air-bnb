package com.codesquad.team10.airbnb.service;

import com.codesquad.team10.airbnb.dto.request.SignUpDto;
import com.codesquad.team10.airbnb.model.User;
import com.codesquad.team10.airbnb.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add(SignUpDto signUpDto) {
        User user = signUpDto.toEntity();
        userRepository.add(user);
    }
}
