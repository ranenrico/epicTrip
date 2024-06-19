package org.generation.italy.EpicTrip.dto;

import org.generation.italy.EpicTrip.model.RestaurantReservation;
import org.generation.italy.EpicTrip.utils.DateUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RestaurantCheckInDto {
    private long restaurantId;
    private String checkIn;

    public RestaurantCheckInDto(RestaurantReservation restaurantReservation){
        this.restaurantId = restaurantReservation.getId();
        this.checkIn = restaurantReservation.getCheckIn().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public RestaurantCheckInDto() {
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public long getRestaurantId() {
        return restaurantId;
    }
}
