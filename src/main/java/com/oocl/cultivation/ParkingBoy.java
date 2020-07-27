package com.oocl.cultivation;


import java.util.List;

public interface ParkingBoy extends Parkable {

    List<? extends Parkable> getParkingLots();

    @Override
    default FetchResult fetch(CarTicket carTicket) {
        for (int i = 0; i < this.getParkingLots().size(); i++) {
            FetchResult fetchResult = this.getParkingLots().get(i).fetch(carTicket);
            if (fetchResult.getCar() != null) {
                return fetchResult;
            }
        }
        return this.getParkingLots().get(0).fetch(carTicket);
    }

    @Override
    default int getRemainingPosition() {
        return getParkingLots().stream().map(Parkable::getRemainingPosition).reduce((x, y) -> x + y).orElse(0);
    }
}
