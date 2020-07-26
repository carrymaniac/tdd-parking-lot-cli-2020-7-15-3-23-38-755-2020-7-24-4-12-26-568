package com.oocl.cultivation;

import java.util.List;

/**
 * @ProjectName: parking-lot
 * @Package: com.oocl.cultivation
 * @ClassName: ParkingBoy
 * @Author: carrymaniac
 * @Description:
 * @Date: 2020/7/26 3:46 下午
 * @Version:
 */
public interface ParkingBoy {

    ParkResult park(Car car);

    List<ParkingLot> getParkingLots();

    default FetchResult fetch(CarTicket carTicket) {
        for (int i = 0; i < this.getParkingLots().size(); i++) {
            FetchResult fetchResult = this.getParkingLots().get(i).fetch(carTicket);
            if (fetchResult.getCar() != null) {
                return fetchResult;
            }
        }
        return this.getParkingLots().get(0).fetch(carTicket);
    }
}
