package com.oocl.cultivation;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: parking-lot
 * @Package: com.oocl.cultivation
 * @ClassName: SmartParkingBoy
 * @Author: carrymaniac
 * @Description:
 * @Date: 2020/7/26 12:57 下午
 * @Version:
 */
public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkResult park(Car car){
        Optional<ParkingLot> first = parkingLots.stream()
                .filter(parkingLot -> parkingLot.getRemainingPosition() > 0)
                .max((a,b)-> a.getRemainingPosition()>=b.getRemainingPosition()?1:-1);
        if (first.isPresent()) {
            return first.get().park(car);
        } else {
            return this.parkingLots.get(0).park(car);
        }
    }

    public FetchResult fetch(CarTicket ticket){
        return parkingLots.get(0).fetch(ticket);
    }
}
