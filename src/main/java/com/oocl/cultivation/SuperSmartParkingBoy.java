package com.oocl.cultivation;

import java.util.List;


public class SuperSmartParkingBoy implements ParkingBoy {
    List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkResult park(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getRemainingPosition() > 0)
                .max((a, b) -> (double) a.getRemainingPosition() / (double) a.getCapacity() >= (double) b.getRemainingPosition() / (double) b.getCapacity() ? 1 : -1)
                .orElse(this.parkingLots.get(0))
                .park(car);
    }

    @Override
    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }
}
