package com.oocl.cultivation;

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

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(CarTicket carTicket) {
        return parkingLot.fetch(carTicket);
    }
}
