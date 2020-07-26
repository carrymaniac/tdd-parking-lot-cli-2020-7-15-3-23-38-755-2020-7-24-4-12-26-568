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
public class NormalParkingBoy implements ParkingBoy {
    List<ParkingLot> parkingLots;

    public NormalParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
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

    @Override
    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }
}
