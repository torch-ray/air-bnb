package com.codesquad.team10.airbnb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WishListRequestDto {
    @JsonProperty
    private Integer roomId;

    @JsonProperty
    private String userId;

    @JsonProperty
    private String accessToken;

    public WishListRequestDto(Integer roomId, String userId, String accessToken) {
        this.roomId = roomId;
        this.userId = userId;
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "WishListRequestDto{" +
                "roomId=" + roomId +
                ", userId='" + userId + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
