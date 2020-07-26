package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @ProjectName: parking-lot
 * @Package: com.oocl.cultivation.test
 * @ClassName: SmartParkingBoyTest
 * @Author: carrymaniac
 * @Description:
 * @Date: 2020/7/26 12:51 下午
 * @Version:
 */
public class SmartParkingBoyTest {
    @Test
    void should_return_park_result_when_park_given_car() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot()));
        //when
        ParkResult parkResult = smartParkingBoy.park(new Car());
        //then
        assertNotNull(parkResult);
        assertNotNull(parkResult.getCarTicket());
    }

    @Test
    void should_return_fetch_result_when_fetch_given_car_ticket(){
        //given
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot()));
        ParkResult parkResult = smartParkingBoy.park(car);
        //when
        FetchResult fetchResult = smartParkingBoy.fetch(parkResult.getCarTicket());
        //then
        assertNotNull(fetchResult);
        assertEquals(car,fetchResult.getCar());

    }

}