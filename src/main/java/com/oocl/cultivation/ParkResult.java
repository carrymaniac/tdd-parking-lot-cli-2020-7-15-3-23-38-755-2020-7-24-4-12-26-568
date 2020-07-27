package com.oocl.cultivation;


public class ParkResult {
    private CarTicket carTicket;
    private String message;

    public ParkResult(String message, CarTicket carTicket) {
        this.carTicket = carTicket;
        this.message = message;
    }

    public CarTicket getCarTicket() {
        return carTicket;
    }

    public void setCarTicket(CarTicket carTicket) {
        this.carTicket = carTicket;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
