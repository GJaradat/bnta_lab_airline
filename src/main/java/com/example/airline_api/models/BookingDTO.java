package com.example.airline_api.models;

public class BookingDTO {

    private Long flightId;
    private Long passengerId;

    public BookingDTO(Long flightId, Long passengerId) {
        this.flightId = flightId;
        this.passengerId = passengerId;
    }

    public BookingDTO() {
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }
}
