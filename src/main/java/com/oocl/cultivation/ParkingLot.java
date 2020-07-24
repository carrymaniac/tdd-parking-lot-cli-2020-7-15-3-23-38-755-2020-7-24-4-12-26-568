package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {
    private final HashMap<CarTicket, Car> parkingRoom = new HashMap<>();
    private Integer capacity;
    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        parkingRoom.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        return parkingRoom.remove(carTicket);
    }

    public HashMap<CarTicket, Car> getParkingRoom() {
        return parkingRoom;
    }
}
