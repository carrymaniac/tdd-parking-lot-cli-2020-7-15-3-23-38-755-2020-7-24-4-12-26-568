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

    public SuperSmartParkingBoy(List<ParkingLot> asList) {

    }

    @Override
    public ParkResult park(Car car) {
        return null;
    }

    @Override
    public List<ParkingLot> getParkingLots() {
        return null;
    }
}
