package com.oocl.cultivation;

import java.util.List;

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
        return null;
    }

    public FetchResult fetch(CarTicket ticket){
        return null;
    }
}
