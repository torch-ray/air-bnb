package com.codesquad.team10.airbnb.dto.request;

import com.codesquad.team10.airbnb.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignUpDto {
    @JsonProperty
    private String userId;

    @JsonProperty
    private String password;

    @JsonProperty
    private String nickname;

    @JsonProperty
    private String email;

    public SignUpDto(String userId, String password, String nickname, String email) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public User toEntity() {
        return new User(this.userId, this.password, this.nickname, this.email);
    }

    @Override
    public String toString() {
        return "SignUpDto{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
