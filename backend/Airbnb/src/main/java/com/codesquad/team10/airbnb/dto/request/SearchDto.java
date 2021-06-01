package com.codesquad.team10.airbnb.dto.request;

public class SearchDto {
    private String location;
    private String checkIn;
    private String checkOut;
    private Integer min;
    private Integer max;
    private Integer guests;

    public SearchDto(String location, String checkIn, String checkOut, Integer min, Integer max, Integer guests) {
        this.location = location;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.min = min;
        this.max = max;
        this.guests = guests;
    }

    public String getLocation() {
        return location;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    public Integer getGuests() {
        return guests;
    }

    @Override
    public String toString() {
        return "SearchDto{" +
                "location='" + location + '\'' +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", min=" + min +
                ", max=" + max +
                ", guests=" + guests +
                '}';
    }
}
