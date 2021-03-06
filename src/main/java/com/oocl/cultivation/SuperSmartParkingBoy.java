package com.oocl.cultivation;

import java.util.Comparator;
import java.util.List;


public class SuperSmartParkingBoy implements ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkResult park(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getRemainingPosition() > 0)
                .max(Comparator.comparingDouble(a -> (double) a.getRemainingPosition() / (double) a.getCapacity()))
                .orElse(this.parkingLots.get(0))
                .park(car);
    }

    @Override
    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }
}
