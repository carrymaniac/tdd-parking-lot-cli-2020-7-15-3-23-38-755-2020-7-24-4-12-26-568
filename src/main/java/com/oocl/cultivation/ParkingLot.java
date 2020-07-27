package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot implements Parkable {
    private final HashMap<CarTicket, Car> parkingRoom = new HashMap<>();
    private final Integer capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public ParkResult park(Car car) {
        if (this.getRemainingPosition() > 0 && !parkingRoom.containsValue(car)) {
            CarTicket carTicket = new CarTicket();
            parkingRoom.put(carTicket, car);
            return new ParkResult("", carTicket);
        } else {
            return new ParkResult("Not enough position.", null);
        }
    }

    public FetchResult fetch(CarTicket carTicket) {
        if (carTicket == null) {
            return new FetchResult("Please provide your parking ticket.", null);
        }
        Car remove = parkingRoom.remove(carTicket);
        if (remove == null) {
            return new FetchResult("Unrecognized parking ticket.", null);
        }
        return new FetchResult("success", remove);
    }

    public int getRemainingPosition() {
        return this.capacity - parkingRoom.size();
    }
}
