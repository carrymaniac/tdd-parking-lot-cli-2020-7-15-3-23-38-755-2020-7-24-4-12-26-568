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
        if(capacity<10){
            CarTicket carTicket = new CarTicket();
            parkingRoom.put(carTicket, car);
            capacity++;
            return carTicket;
        }else {
            return null;
        }
    }

    public Car fetch(CarTicket carTicket) {
        Car remove = parkingRoom.remove(carTicket);
        if(remove!=null){
            capacity--;
        }
        return remove;
    }

    public HashMap<CarTicket, Car> getParkingRoom() {
        return parkingRoom;
    }
}
