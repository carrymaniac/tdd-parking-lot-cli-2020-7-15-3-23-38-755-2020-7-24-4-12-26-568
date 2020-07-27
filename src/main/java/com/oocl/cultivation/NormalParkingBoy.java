package com.oocl.cultivation;

import java.util.List;


public class NormalParkingBoy implements ParkingBoy {
    List<ParkingLot> parkingLots;

    public NormalParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkResult park(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getRemainingPosition() > 0)
                .findFirst().orElse(this.parkingLots.get(0)).park(car);
    }

    @Override
    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }
}
