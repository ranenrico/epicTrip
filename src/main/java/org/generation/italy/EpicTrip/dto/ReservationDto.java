package org.generation.italy.EpicTrip.dto;

import org.generation.italy.EpicTrip.model.*;
import org.generation.italy.EpicTrip.utils.DateUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationDto {
    private long id;
    private long packageId;
    private long userId;
    private int peopleCount;
    private BigDecimal cost;
    private String creationDate;
    private String startDate;
    //guide section
    private long guideId;
    private String startPerformanceDate;
    private String endPerformanceDate;
    //hotel section
    private long hotelId;
    //restaurant section
    private List<RestaurantCheckInDto> restaurantCheckIns = new ArrayList<>();


    public ReservationDto(HolidayPackageReservation holidayPackageReservation, GuideReservation guideReservation,
                          HotelReservation hotelReservation, List<RestaurantReservation> restaurantReservations) {
        this.id = holidayPackageReservation.getId();
        this.packageId = holidayPackageReservation.getHolidayPackage().getId();
        this.userId = holidayPackageReservation.getUser().getId();
        this.peopleCount = holidayPackageReservation.getPeopleCount();
        this.cost = holidayPackageReservation.getCost();
        this.creationDate = DateUtils.format(holidayPackageReservation.getCreationDate());
        this.startDate = DateUtils.format(holidayPackageReservation.getStartDate());
        this.guideId = guideReservation.getId();
        this.startPerformanceDate = DateUtils.format(guideReservation.getStartPerformanceDate());
        this.endPerformanceDate = DateUtils.format(guideReservation.getEndPerformanceDate());
        this.hotelId = hotelReservation.getId();
        this.restaurantCheckIns = restaurantReservations.stream().map(RestaurantCheckInDto::new).toList();
    }

    public ReservationDto() {
    }

    public HolidayPackageReservation toHolidayPackageReservation(AppUser user, HolidayPackage holidayPackage){
        return new HolidayPackageReservation(holidayPackage, user,
                this.peopleCount, this.cost, DateUtils.parse(this.creationDate), DateUtils.parse(this.startDate));
    }

    public GuideReservation toGuideReservation(Guide guide, HolidayPackageReservation holidayPackageReservation){
        return new GuideReservation(guide, holidayPackageReservation, DateUtils.parse(this.creationDate),
                DateUtils.parse(this.startPerformanceDate), DateUtils.parse(this.endPerformanceDate));
    }

    public HotelReservation toHotelReservation(Hotel hotel, LocalDateTime checkout, HolidayPackageReservation holidayPackageReservation){
        return new HotelReservation(hotel, DateUtils.parse(this.creationDate), holidayPackageReservation.getStartDate().atTime(15,30),
                checkout, holidayPackageReservation, this.peopleCount);
    }

    public List<RestaurantReservation> toRestaurantReservation(List<Restaurant> restaurants, HolidayPackageReservation holidayPackageReservation){
        List<RestaurantReservation> restaurantReservations = new ArrayList<>();
        for(int i = 0; i < restaurantCheckIns.size(); i++){
            restaurantReservations.add(fromRestaurantCheckIn(restaurantCheckIns.get(i), restaurants.get(i), holidayPackageReservation));
        }
        return restaurantReservations;
    }

    private RestaurantReservation fromRestaurantCheckIn(RestaurantCheckInDto restaurantCheckInDto, Restaurant restaurant, HolidayPackageReservation holidayPackageReservation){
        return new RestaurantReservation(restaurant, DateUtils.parse(this.creationDate),
                LocalDateTime.parse(restaurantCheckInDto.getCheckIn()), this.peopleCount, holidayPackageReservation);
    }

    public long getId() {
        return id;
    }

    public long getPackageId() {
        return packageId;
    }

    public long getUserId() {
        return userId;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public long getGuideId() {
        return guideId;
    }

    public String getStartPerformanceDate() {
        return startPerformanceDate;
    }

    public String getEndPerformanceDate() {
        return endPerformanceDate;
    }

    public long getHotelId() {
        return hotelId;
    }

    public List<RestaurantCheckInDto> getRestaurantCheckIns() {
        return restaurantCheckIns;
    }
}
