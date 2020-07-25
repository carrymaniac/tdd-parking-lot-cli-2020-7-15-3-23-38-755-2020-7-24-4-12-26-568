package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {
    private final HashMap<CarTicket, Car> parkingRoom = new HashMap<>();
    private Integer capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public CarTicket park(Car car) {
        if (capacity-parkingRoom.size()>0&&!parkingRoom.containsValue(car)) {
            CarTicket carTicket = new CarTicket();
            parkingRoom.put(carTicket, car);
            return carTicket;
        } else {
            return null;
        }
    }

    public FetchResult fetch(CarTicket carTicket) {
        parkingRoom.remove(carTicket);
        return null;
    }
}
