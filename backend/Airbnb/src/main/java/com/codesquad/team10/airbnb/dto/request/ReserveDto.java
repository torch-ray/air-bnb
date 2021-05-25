package com.codesquad.team10.airbnb.dto.request;

import com.codesquad.team10.airbnb.model.Reserve;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReserveDto {
    @JsonProperty
    private String userId;

    @JsonProperty
    private Long roomId;

    @JsonProperty
    private String checkIn;

    @JsonProperty
    private String checkOut;

    @JsonProperty
    private Integer guests;

    public ReserveDto(String userId, Long roomId, String checkIn, String checkOut, Integer guests) {
        this.userId = userId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
    }

    public Reserve toEntity() {
        return new Reserve(null, this.userId, this.roomId, this.checkIn, this.checkOut, this.guests);
    }

    @Override
    public String toString() {
        return "ReserveDto{" +
                "userId='" + userId + '\'' +
                ", roomId=" + roomId +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", guests=" + guests +
                '}';
    }
}
