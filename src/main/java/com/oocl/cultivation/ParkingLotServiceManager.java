package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotServiceManager implements ParkingBoy {
    List<Parkable> parkables = new ArrayList<>();

    public ParkingLotServiceManager(Parkable... parkables) {
        this.getParkingLots().addAll(Arrays.asList(parkables));
    }

    @Override
    public List<Parkable> getParkingLots() {
        return this.parkables;
    }

    @Override
    public ParkResult park(Car car) {
        return parkables.stream()
                .filter(parkable -> parkable.getRemainingPosition() > 0)
                .findFirst()
                .orElse(parkables.get(0))
                .park(car);
    }
}
