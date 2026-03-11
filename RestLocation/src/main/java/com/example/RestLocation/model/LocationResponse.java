package com.example.RestLocation.model;

public class LocationResponse {
    private final String restaurant;
    private final double latitude;
    private final double longitude;

    public LocationResponse(String restaurant, double latitude, double longitude) {
        this.restaurant = restaurant;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
