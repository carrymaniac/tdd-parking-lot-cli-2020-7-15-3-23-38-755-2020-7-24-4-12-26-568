package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {
    private final HashMap<CarTicket, Car> parkingRoom = new HashMap<>();

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
