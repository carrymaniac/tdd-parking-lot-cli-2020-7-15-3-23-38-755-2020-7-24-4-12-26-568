package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {
    private final HashMap<CarTicket, Car> parkingRoom = new HashMap<>();
    private Integer capacity;
    private Integer nowCars = 0;
    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public CarTicket park(Car car) {
        if(nowCars<capacity){
            CarTicket carTicket = new CarTicket();
            parkingRoom.put(carTicket, car);
            nowCars++;
            return carTicket;
        }else {
            return null;
        }
    }

    public Car fetch(CarTicket carTicket) {
        Car remove = parkingRoom.remove(carTicket);
        if(remove!=null){
            nowCars--;
        }
        return remove;
    }

    public HashMap<CarTicket, Car> getParkingRoom() {
        return parkingRoom;
    }
}
