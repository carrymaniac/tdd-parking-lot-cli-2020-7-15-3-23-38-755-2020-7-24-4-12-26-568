package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: parking-lot
 * @Package: com.oocl.cultivation
 * @ClassName: ParkingBoy
 * @Author: carrymaniac
 * @Description:
 * @Date: 2020/7/24 3:47 下午
 * @Version:
 */
public class ParkingBoy {

    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkResult park(Car car) {
        Optional<ParkingLot> first = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getRemainingPosition() > 0)
                .findFirst();
        if (first.isPresent()) {
            return first.get().park(car);
        } else {
            return this.parkingLots.get(0).park(car);
        }
    }

    public FetchResult fetch(CarTicket carTicket) {
        for (int i = 0; i < parkingLots.size(); i++) {
            FetchResult fetchResult = parkingLots.get(i).fetch(carTicket);
            if (fetchResult.getCar() != null) {
                return fetchResult;
            }
        }
        return parkingLots.get(0).fetch(carTicket);
    }
}
