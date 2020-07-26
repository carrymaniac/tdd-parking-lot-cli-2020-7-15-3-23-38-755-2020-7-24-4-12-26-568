package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ProjectName: parking-lot
 * @Package: com.oocl.cultivation.test
 * @ClassName: SuperSmartBoy
 * @Author: carrymaniac
 * @Description:
 * @Date: 2020/7/26 4:40 下午
 * @Version:
 */
public class SuperSmartBoyTest {
    @Test
    void should_return_park_result_when_park_given_car() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot()));
        //when
        ParkResult parkResult = superSmartParkingBoy.park(new Car());
        //then
        assertNotNull(parkResult);
        assertNotNull(parkResult.getCarTicket());
    }

    @Test
    void should_return_fetch_result_when_fetch_given_car_ticket() {
        //given
        Car car = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot()));
        ParkResult parkResult = superSmartParkingBoy.park(car);
        //when
        FetchResult fetchResult = superSmartParkingBoy.fetch(parkResult.getCarTicket());
        //then
        assertNotNull(fetchResult);
        assertEquals(car, fetchResult.getCar());
    }

    @Test
    void should_park_larger_available_position_rate_park_when_park_given_car() {
        ParkingLot parkingLotA = new ParkingLot(20);
        ParkingLot parkingLotB = new ParkingLot();
        for(int i = 0;i<5;i++){
            parkingLotA.park(new Car());
        }
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLotA,parkingLotB));
        ParkResult parkResult = superSmartParkingBoy.park(new Car());
        //then
        assertNotNull(parkResult);
        assertTrue(parkingLotB.getRemainingPosition()<10);
    }
}
