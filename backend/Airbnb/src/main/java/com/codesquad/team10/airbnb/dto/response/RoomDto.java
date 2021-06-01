package com.codesquad.team10.airbnb.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RoomDto {
    @JsonProperty
    private String location;

    @JsonProperty
    private String title;

    @JsonProperty
    private String image;

    @JsonProperty
    private String xPos;

    @JsonProperty
    private String yPos;

    @JsonProperty
    private String description;

    @JsonProperty
    private Integer charge;

    @JsonProperty
    private Integer totalCharge;

    @JsonProperty
    private Double ratings;

    @JsonProperty
    private Integer reviews;

    public RoomDto(String location, String title, String image, String xPos, String yPos, String description, Integer charge, Integer totalCharge, Double ratings, Integer reviews) {
        this.location = location;
        this.title = title;
        this.image = image;
        this.xPos = xPos;
        this.yPos = yPos;
        this.description = description;
        this.charge = charge;
        this.totalCharge = totalCharge;
        this.ratings = ratings;
        this.reviews = reviews;
    }

    public void setTotalCharge(String checkIn, String checkOut) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate checkInDate = LocalDate.parse(checkIn, dateTimeFormatter);
        LocalDate checkOutDate = LocalDate.parse(checkOut, dateTimeFormatter);
        long days = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        this.totalCharge = this.charge * (int) days;
    }
}
