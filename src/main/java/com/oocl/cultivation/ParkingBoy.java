package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

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
        return parkingLots.get(0).park(car);
    }

    public FetchResult fetch(CarTicket carTicket) {
      return parkingLots.get(0).fetch(carTicket);
    }
}
