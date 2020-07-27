package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

public class SmartParkingBoy implements ParkingBoy {
    List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkResult park(Car car) {
        Optional<ParkingLot> first = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getRemainingPosition() > 0)
                .max((a, b) -> a.getRemainingPosition() >= b.getRemainingPosition() ? 1 : -1);
        if (first.isPresent()) {
            return first.get().park(car);
        } else {
            return this.parkingLots.get(0).park(car);
        }
    }

    @Override
    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }
}
