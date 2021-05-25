package com.codesquad.team10.airbnb.dto.request;

import com.codesquad.team10.airbnb.model.WishList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WishListAddDto {
    @JsonProperty
    private String userId;

    @JsonProperty
    private Long roomId;

    public WishListAddDto(String userId, Long roomId) {
        this.userId = userId;
        this.roomId = roomId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public WishList toEntity() {
        return new WishList(null, this.userId, this.roomId);
    }

    @Override
    public String toString() {
        return "WishListAddDto{" +
                "userId='" + userId + '\'' +
                ", roomId=" + roomId +
                '}';
    }
}
