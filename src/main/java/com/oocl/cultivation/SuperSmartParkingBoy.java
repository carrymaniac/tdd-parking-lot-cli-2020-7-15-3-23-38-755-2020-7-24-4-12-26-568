package com.oocl.cultivation;

import java.util.List;

/**
 * @ProjectName: parking-lot
 * @Package: com.oocl.cultivation
 * @ClassName: SuperSmartParkingBoy
 * @Author: carrymaniac
 * @Description:
 * @Date: 2020/7/26 11:27 下午
 * @Version:
 */
public class SuperSmartParkingBoy implements ParkingBoy{
    List<ParkingLot> parkingLots;
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkResult park(Car car) {
        return parkingLots.get(0).park(car);
    }

    @Override
    public List<ParkingLot> getParkingLots() {
        return this.parkingLots;
    }
}
